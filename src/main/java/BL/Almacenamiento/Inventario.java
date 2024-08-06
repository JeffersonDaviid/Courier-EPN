package BL.Almacenamiento;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BL.Administracion.Global;
import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Recepcion;

public class Inventario {
    private Recepcion recepcion;
    private Map<String, Paquete> paquetesAlmacenados;
    private Map<String, Paquete> paquetesParaCargaSucursal;
    private Map<String, Paquete> paquetesParaCargaDomicilio;
    private int capacidadTotal;
    private int capacidadOcupada;
    private Historial historial;
    private int tiempoMaximo;
    private final int CAPACIDAD_PAQUETE_PEQUENIO = 1;
    private final int CAPACIDAD_PAQUETE_MEDIANO = 2;
    private final int CAPACIDAD_PAQUETE_GRANDE = 3;

    public Inventario() {
        this.tiempoMaximo = 15;
        this.capacidadTotal = 100;
        this.paquetesAlmacenados = new HashMap<String, Paquete>();
        this.paquetesParaCargaSucursal = new HashMap<String, Paquete>();
        this.paquetesParaCargaDomicilio = new HashMap<String, Paquete>();
        this.capacidadOcupada = calcularCapacidadOcupada();
        this.historial = new Historial();
    }

    //Método que agrega paquetes al inventario desde la recepcion
    public void agregarPaqueteDeRecepcion(String id) {
        recepcion = Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion();
        for (Paquete p : recepcion.getPaquetesRecepcion()) {
            if (p.getId().equals(id)) {
                int capacidadPaquete = clasificarCapacidad(p.getTamanio());
                // Verifica que hay espacio suficiente en el inventario
                if (!hayEspacioSuficiente(capacidadPaquete)) {
                    notificarCapacidadCompleta();
                    return;
                }
                //si hay espacio entonces lo guarda y actualiza su estado
                p.agregarEstado(new Estado("En bodega agencia remitente"));
                paquetesAlmacenados.put(p.getId(), p);
                actualizarEstadoPaqueteBD(id,"En bodega agencia remitente");
                ingresarRegistro(p, capacidadPaquete,Global.getInstancia().agenciaActual);
                recepcion.eliminarPaquete(p);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El paquete no existe o no esta en recepcion");
    }

// Método para guardar el nuevo estado del paquete en la BD
    private void actualizarEstadoPaqueteBD(String id, String estado) {
        String sql = "INSERT INTO PaqueteEstados (idPaquete, estado, fecha) VALUES ("
        + id + ", '" + estado + "', '" + getFecha() +"')";
        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al guardar el nuevo estado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo que ingresar paquetes desde el camnio de carga
    public void agregarPaqueteDeCamionCarga(Paquete paquete) {
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        //Verifica que hay espacio suficiente en el inventario
        if(!hayEspacioSuficiente(capacidadPaquete)){
            notificarCapacidadCompleta();
            return;
        }
        //si hay espacio, lo guarda y actualiza su estado
        paquetesAlmacenados.put(paquete.getId(),paquete);
        paquete.agregarEstado(new Estado("En bodega agencia destino"));
        actualizarEstadoPaqueteBD(paquete.getId(), "En bodega agencia destino");
        ingresarRegistro(paquete,capacidadPaquete,paquete.getAgenciaDestino());
    }

    //Metodo que guarda el ingreso de un paquete al invetario 
    private void ingresarRegistro(Paquete paquete, int capacidadPaquete, String agencia) {
        //historial.registrarRegistro(new Registro(getFecha(),getAgencia(paquete),paquete.getId()));
        historial.registrarRegistro(new Registro(getFecha(),agencia,paquete.getId()));
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizarCapacidadOcupada(capacidadPaquete);
    }

    //Metodo que clasifica un paquete en las diferentes listas (Para envio a Sucursal - Para envio a domicilio - Para retiro de bodega)
    public void organizarPaquetes(String idPaquete) {
        for (Paquete paquete : paquetesAlmacenados.values()) {
            // Verifica que el paquete es para envio a otra sucursal
            if (paquete.getId().equals(idPaquete) && !paquete.getAgenciaDestino().equals(Global.agenciaActual)) {
                Estado estado = new Estado("Listo para envio agencia destino");
                paquete.agregarEstado(estado);
                actualizarEstadoPaqueteBD(idPaquete, "Listo para envio agencia destino");
                paquetesParaCargaSucursal.put(paquete.getId(), paquetesAlmacenados.remove(idPaquete));
                return;
            }else{
                System.out.println(paquete.getDomicilio());
                //Si el paquete ya se encuentra en la sucursal de destino entonces verificamos si tiene entrega a domicilio
                if(paquete.getDomicilio() == null){
                    Estado estado = new Estado("Listo para retiro de bodega");
                    paquete.agregarEstado(estado);
                    actualizarEstadoPaqueteBD(idPaquete, "Listo para retiro de bodega");
                }else{
                    //si lo tiene se lo coloca como listo para enviar
                    Estado estado = new Estado("Listo para envio a domicilio");
                    paquete.agregarEstado(estado);
                    actualizarEstadoPaqueteBD(idPaquete, "Listo para envio a domicilio");
                    paquetesParaCargaDomicilio.put(paquete.getId(), paquetesAlmacenados.remove(paquete.getId()));
                }
            }
        }
    }

    //Metodo para entregar el paquete al cliente desde la bodega/recepcion - La llama el bodeguero
    public void entregarPaquete(String id) {
        Paquete paquete = null;
        //Verifica si esta el paquete como retiro en bodega/recepcion
        if(paquetesAlmacenados.containsKey(id)){
            paquete = paquetesAlmacenados.remove(id);
        //Si no esta verifica si esta en la lista para entregar a domicilio
        }else if(paquetesParaCargaDomicilio.containsKey(id)){
            paquete = paquetesParaCargaDomicilio.remove(id);
        //Si no esta en niguna es porque el paquete aun no ha llegado
        }else{
            JOptionPane.showMessageDialog(null, "Paquete no encontrado");
            return;
        }
        //Si esta actualiza el estado del paquete
        paquete.agregarEstado(new Estado("Entregado"));
        //Se guarda la fecha de salida del paquete en el registro y se actualiza en la base
        historial.getRegistro(id).setFechaSalida(getFecha());
        historial.actualizarFechaDeSalida(id,getFecha());
        actualizarCapacidadOcupada(-clasificarCapacidad(paquete.getTamanio()));
        actualizarEstadoPaqueteBD(id, "Entregado");
    }

    //Metodo que devuelve toda la lsita de paquetes del invetario
    public ArrayList<Paquete> getPaquetesInventario() {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes.addAll(paquetesAlmacenados.values());
        paquetes.addAll(paquetesParaCargaSucursal.values());
        paquetes.addAll(paquetesParaCargaDomicilio.values());
        return paquetes;
    }

    //Metodo que calcula la capcidad ocupada de los paquetes que ya han estado almacenados
    private int calcularCapacidadOcupada() {
        int cantidadOcupada = 0;
        for(Paquete paquete :paquetesAlmacenados.values()){
            cantidadOcupada+= clasificarCapacidad(paquete.getTamanio());
        }
        return  cantidadOcupada;
    }

    //Método que clasifica y obtiene cuanto espacio ocupa cada paquete
    private int clasificarCapacidad(String tamanio) {
        switch (tamanio) {
            case "grande":
                return CAPACIDAD_PAQUETE_GRANDE;
            case "mediano":
                return CAPACIDAD_PAQUETE_MEDIANO;
        }
        return CAPACIDAD_PAQUETE_PEQUENIO;
    }

    //Metodo que obtiene la fecha para el registro de ingreso o salida
    private String getFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    //Metodo que actualiza la capacidad del inventario
    public void actualizarCapacidadOcupada(int cantidad){
        capacidadOcupada += cantidad;
    }

    //Metodo que notifica que el invetario ha llenado su capacidad
    private void notificarCapacidadCompleta(){
        JOptionPane.showMessageDialog(null, "Capacidad de la bodega alcanzado", "Alerta",JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo que verifica si hay espacio suficiente en el invetario para otro paquete
    private boolean hayEspacioSuficiente(int capacidadPaquete) {
        return (capacidadOcupada + capacidadPaquete) < capacidadTotal;
    }

    //Metodo que actualiza la capacidad total del inventario
    public void actualizarCapacidadTotal(int capacidad){
        this.capacidadTotal = capacidad;
    }

    //Metodo que calcula la fecha o dias que le faltan a un paquete, sin ser reclamado
    private String calcularFechaLimite(String fechaIngreso){
        //Calcular fecha limite para cada paquete
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            LocalDateTime fechaHoraActual = LocalDateTime.parse(fechaIngreso, formatter);
            LocalDateTime fechaHoraFutura = fechaHoraActual.plusDays(15);
            return fechaHoraFutura.format(formatter);
        }catch (DateTimeParseException e){
            System.out.println(e.getMessage());
        } 
        return null;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    //Metodo que consulta el historial de ingresos y salidas de los paquetes el dia ejecutado
    public void consultarHistorial() {
        historial.consultar(0);
    }
    
    public Historial getHistorial(){
        return historial;
    }

    //Metodo que retira  los paquetes desde la lista correspondiente para cargarlos a los camiones
    public Paquete retirarPaquete(String idPaquete){
        Paquete paquete = null;
        //Verifica que el paquete este en el inventario para poder retirarlo
        if (paquetesParaCargaDomicilio.containsKey(idPaquete)) {
            paquete = paquetesParaCargaDomicilio.remove(idPaquete);
        }
        else if (paquetesParaCargaSucursal.containsKey(idPaquete)) {
            paquete = paquetesParaCargaSucursal.remove(idPaquete);
        }
        else if (paquetesAlmacenados.containsKey(idPaquete)) {
            paquete = paquetesAlmacenados.remove(idPaquete);
        }else{
            System.out.println("Paquete no encontrado");
            return null;
        }
        //Se guarda la fecha de salida del paquete en el registro y actualizar en la base
        historial.getRegistro(idPaquete).setFechaSalida(getFecha());
        historial.actualizarFechaDeSalida(idPaquete,getFecha());
        actualizarCapacidadOcupada(-clasificarCapacidad(paquete.getTamanio()));      // Se actualiza la capacidad ocupada del inventario
        return paquete;
    }

    //Metodo que muestra todos los paquetes del inventario
    public DefaultTableModel mostrarPaquetes(int index){
        recepcion = Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion();
        DefaultTableModel model= new DefaultTableModel();
        String[] columnas = {"ID", "Agencia de Origen", "Agencia de Destino","Estado"};
        int cntidadCol = columnas.length;
        for(int i=0; i<cntidadCol; i++){
            model.addColumn(columnas[i]);
        } 
        Collection<Paquete> paquetes;
        switch (index) {
            case 0:
                paquetes = getPaquetesInventario();
            case 1:
                paquetes = recepcion.getPaquetesRecepcion();
                break;
            case 2:
                paquetes = this.paquetesAlmacenados.values();
                break;
            case 3:
                paquetes = this.paquetesParaCargaSucursal.values();
                break;
            case 4:
                paquetes = getPaquetesListoParaEntregar();
                break;
            default:
                throw new AssertionError();
        }
            
        for (Paquete p: paquetes){
                model.addRow(new Object[]{p.getId(),
                                p.getAgenciaOrigen(),
                                p.getAgenciaDestino(),
                                p.getHistorialEstado().getLast()});                   
        }  
        return model;
    }

    private ArrayList<Paquete> getPaquetesListoParaEntregar() {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        for (Paquete paquete : paquetesAlmacenados.values()) {
            if(paquete.getHistorialEstado().get(paquete.getHistorialEstado().size()).getEstado() == "Listo para retiro de bodega"){
                paquetes.add(paquete);
            }
        }
        return paquetes;
    }

    //Metodo que devuelve todos los paquetes listos para enviar a otra sucursal
    public ArrayList<Paquete> getPaquetesParaCarga() {
        return new ArrayList<>(paquetesParaCargaSucursal.values());
    }

    //Metodo que devuleve todoso los paquetes listos para envio a domicilio
    public ArrayList<Paquete> getPaquetesParaEnvioDomicilio() {
        return new ArrayList<>(paquetesParaCargaDomicilio.values());
    }

    public void consultarPorID(String valor) {
        historial.filtrarPorId(valor);
    }

    public void consultarPorFechaIngreso(String valor) {
        historial.filtrarPorFechaIngreso(valor);    
    }

    public void consultarPorFechaSalida(String valor) {
        historial.filtrarPorFechaSalida(valor);
    }
}