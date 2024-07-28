package BL.Almacenamiento;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

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
        //this.paquetesAlmacenados = cargarPaquetesAlmacenados();
        this.paquetesAlmacenados = new HashMap<String, Paquete>();
        this.paquetesParaCargaSucursal = new HashMap<String, Paquete>();
        this.paquetesParaCargaDomicilio = new HashMap<String, Paquete>();
        this.capacidadOcupada = calcularCapacidadOcupada();
        this.historial = new Historial();
        //ordenarPaquetesAlmacenados();
    }

    /*Método que carga todos los paquetes almacenados cuando se enciende el sistema
    private HashMap<String,Paquete> cargarPaquetesAlmacenados(){
        HashMap<String,Paquete> paquetes = new HashMap<String,Paquete>();
        String sql = "SELECT * FROM Inventario";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);

            while (rs.next()) {
                String idPaquete = rs.getString("idPaquete");
                String trackingNumber = rs.getString("trackingNumber");
                float peso = rs.getFloat("peso");
                String tamanio = rs.getString("tamanio");
                String fechaHoraLlegada = rs.getString("fechaHoraLlegada");
                String fechaHoraSalida = rs.getString("fechaHoraSalida");
                String nombreRemitente = rs.getString("nombreRemitente");
                String correoRemitente = rs.getString("correoRemitente");
                String telefonoRemitente = rs.getString("telefonoRemitente");
                String nombreDestinatario = rs.getString("nombreDestinatario");
                String correoDestinatario = rs.getString("correoDestinatario");
                String telefonoDestinatario = rs.getString("telefonoDestinatario");
                String tipoEnvio = rs.getString("tipoEnvio");
                String sucursalAceptoPaquete = rs.getString("sucursalAceptoPaquete");
                String sucursalParaRecoger = rs.getString("sucursalParaRecoger");
                String estado = rs.getString("estado");
                String domicilio = rs.getString("domicilio");
                //Se crea el objeto y se lo coloca en el hashmap
                paquetes.put(idPaquete,new Paquete(idPaquete, sucursalAceptoPaquete,sucursalParaRecoger,domicilio,peso,tamanio));
                //Controlar como guardamos los estados
            } 
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        return paquetes;
    }*/

    /*Método que ordena todos los paqutes cargados al sistema al encenderse
    private void ordenarPaquetesAlmacenados() {
        for (Paquete paquete : paquetesAlmacenados.values()) {
            organizarPaquetes(paquete.getId());
        }  
    }*/

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
                actualizarEstadoPaqueteBase(id,"En bodega agencia remitente");
                ingresarRegistro(p, capacidadPaquete);
                recepcion.eliminarPaquete(p);
                guardarPaqueteEnBD(p.getId(),getSucursal());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El paquete no existe o no esta en recepcion");
    }

    //Método para guardar la información de un paquete en el inventario
    private void guardarPaqueteEnBD(String id, String sucursal) {
        String sql = "INSERT INTO InventarioPaquetes (idPaquete, sucursal) VALUES (" + id + ", '" + sucursal + "')";
        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEstadoPaqueteBase(String id, String string) {
        //Algoritmo para registrar un nuevo estado en la tabla de estados
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
        actualizarEstadoPaqueteBase(paquete.getId(), "En bodega agencia destino");
        ingresarRegistro(paquete,capacidadPaquete);
        guardarPaqueteEnBD(paquete.getId(),getSucursal());
    }

    //Metodo que guarda el ingreso de un paquete al invetario 
    private void ingresarRegistro(Paquete paquete, int capacidadPaquete) {
        historial.registrarRegistro(new Registro(getFecha(),getSucursal(),paquete.getId()));
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizarCapacidadOcupada(capacidadPaquete);
    }

    private String getSucursal() {
        return (Global.getInstancia().agenciaActual).toUpperCase();
    }

    //Metodo que clasifica un paquete en las diferentes listas (Para envio a Sucursal - Para envio a domicilio - Para retiro de bodega)
    public void organizarPaquetes(String idPaquete) {
        for (Paquete paquete : paquetesAlmacenados.values()) {
            // Verifica que el paquete es para envio a otra sucursal
            if (paquete.getId().equals(idPaquete) && !paquete.getAgenciaDestino().equals(Global.agenciaActual)) {
                Estado estado = new Estado("Listo para envio agencia destino");
                paquete.agregarEstado(estado);
                paquetesParaCargaSucursal.put(paquete.getId(), paquetesAlmacenados.remove(idPaquete));
                return;
            }else{
                System.out.println(paquete.getDomicilio());
                //Si el paquete ya se encuentra en la sucursal de destino entonces verificamos si tiene entrega a domicilio
                if(paquete.getDomicilio() == null){
                    Estado estado = new Estado("Listo para retiro de bodega");
                    paquete.agregarEstado(estado);
                }else{
                    //si lo tiene se lo coloca como listo para enviar
                    Estado estado = new Estado("Listo para envio a domicilio");
                    paquete.agregarEstado(estado);
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
        actualizarEstadoPaqueteBase(id, "Entregado");
        retirarPaqueteDeBD(id);
    }

    //Metodo para retirar la informacion del paquete del inventario en la BD
    private void retirarPaqueteDeBD(String id) {
        String sql = "DELETE FROM InventarioPaquetes WHERE idPaquete = "+id;
        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
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
        historial.consultarHoy();
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
        retirarPaqueteDeBD(idPaquete);
        return paquete;
    }

    //Metodo que muestra todos los paquetes del inventario
    public void mostrarPaquetes(){
        //Algoritmo para mostrar todos los paquetes
    }

    //Metodo que devuelve todos los paquetes listos para enviar a otra sucursal
    public ArrayList<Paquete> getPaquetesParaCarga() {
        return new ArrayList<>(paquetesParaCargaSucursal.values());
    }

    //Metodo que devuleve todoso los paquetes listos para envio a domicilio
    public ArrayList<Paquete> getPaquetesParaEnvioDomicilio() {
        return new ArrayList<>(paquetesParaCargaDomicilio.values());
    }
}