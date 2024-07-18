package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BL.GestionPaquete.Paquete;
import BL.BASEDEDATOS.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

/**
 *
 * @author BugsBusters
 */
public class Inventario {
    private ArrayList<Integer> idPaquetes;
    private Map<String,Paquete> paquetes;
    private int capacidadTotal;
    private int capacidadOcupada;
    private Historial historial;
    private int tiempoMaximo;
    private final int CAPACIDAD_PAQUETE_PEQUENIO = 1;
    private final int CAPACIDAD_PAQUETE_MEDIANO = 2;
    private final int CAPACIDAD_PAQUETE_GRANDE = 3;

    public Inventario(){
        this.tiempoMaximo = 15;
        this.capacidadTotal = 500;
        this.idPaquetes = getIdPaquetesAlmacenados();
        this.paquetes = getPaquetesAlmacenados();
        this.capacidadOcupada = calcularCapacidadOcupada();
        this.historial = new Historial();
    }

    private Map<String, Paquete> getPaquetesAlmacenados() {
        Map<String,Paquete> paquetes = new HashMap<>();
        String sql = "SELECT * FROM Paquetes WHERE estado = 'recibido'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);

            while (rs.next()) {
                int idPaquete = rs.getInt("idPaquete");
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
                
                paquetes.put(String.valueOf(idPaquete),new Paquete(idPaquete, peso, tamanio, fechaHoraLlegada, 
                fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario,
                correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger, trackingNumber, estado, 12, domicilio));
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paquetes;
    }

    //Método que obtiene los id's de los paquetes que estan en la base de datos
    private ArrayList<Integer> getIdPaquetesAlmacenados() {
        ArrayList<Integer> paquetes = new ArrayList<>();
        String sql = "SELECT idPaquete FROM Paquetes WHERE estado LIKE 'En bodega'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);
    
            while (rs.next()) {
                int idPaquete = rs.getInt("idPaquete");
                paquetes.add(idPaquete);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paquetes;
    }

    //Método que calcula la capacidad ocupada por los paquetes ya almacenados en la bodega
    private int calcularCapacidadOcupada() {
        int capacidad = 0;
        for (Integer id : idPaquetes) {
            capacidad += clasificarCapacidad(obtenerTamanioPaquetesBase(String.valueOf(id)));
        }
        return capacidad;
    }

    private String obtenerTamanioPaquetesBase(String idPaquete) {
        //La consulta con el id
        String sql = "SELECT tamanio FROM Paquetes WHERE idPaquete= "+idPaquete+"";
        String tamanio = null;
        try {
        DataHelper dataHelper = DataHelper.getInstancia();
        ResultSet rs = dataHelper.executeQueryRead(sql);

        if (rs.next()) {
            tamanio = rs.getString("tamanio");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return tamanio;
    }

    //Metodo que registra un paquete que se ha recibido la agencia
    public void registrarPaquete(String idPaquete){
        int capacidadPaquete = clasificarCapacidad(obtenerTamanioPaquetesBase(idPaquete));
        //Si no hay espacio para ingresar el paquete, se notifica y termina elmetodo
        if(!hayEspacioSuficiente(capacidadPaquete)){
            notificarCapacidadCompleta();
            return;
        }
        //Si existe espacio suficiente, se ingresa a la bodega y se crea el registro
        idPaquetes.add(Integer.parseInt(idPaquete));
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),idPaquete,TipoRegistro.INGRESO));
        JOptionPane.showMessageDialog(null, "registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizar(capacidadPaquete);
        //Cambiar estado del paquete a "En bodega"
        actualizarEstadoPaquete(idPaquete,"En Bodega");
    }

    public void registrarPaquete(Paquete paquete){
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        //Si no hay espacio para ingresar el paquete, se notifica y termina elmetodo
        if(!hayEspacioSuficiente(capacidadPaquete)){
            notificarCapacidadCompleta();
            return;
        }
        //Si existe espacio suficiente, se ingresa a la bodega y se crea el registro
        paquetes.put(String.valueOf(paquete.getId_paquete()), paquete);
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),String.valueOf(paquete.getId_paquete()),TipoRegistro.INGRESO));
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizar(capacidadPaquete);
        //Cambiar estado del paquete a "En bodega"
        paquete.setEstado("En bodega");
        actualizarEstadoPaquete(String.valueOf(paquete.getId_paquete()),"En Bodega");
    }

    //Método que retorna el id del paquete si se encuentra en bodega 
    public String retirarPaquete(String idPaquete){
        if(!idPaquetes.contains(Integer.parseInt(idPaquete))){
            System.out.println("No contiene esta clave");
            return null;
        }
        idPaquetes.removeIf(valor -> valor.equals(Integer.parseInt(idPaquete)));
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),idPaquete,TipoRegistro.SALIDA));
        int capacidadPaquete = clasificarCapacidad(obtenerTamanioPaquetesBase(idPaquete));
        actualizar(-capacidadPaquete);
        //Cambiar el estado del paquete a "Transportandose"
        actualizarEstadoPaquete(idPaquete,"Transportandose");
        return idPaquete;
    } 

    //Método que retorna el paquete si se encuentra en bodega 
    public Paquete retirarPaquete(int idPaquete){
        if(!paquetes.containsKey(idPaquete)){
            return null;
        }
        Paquete paquete = paquetes.remove(idPaquete);
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),String.valueOf(idPaquete),TipoRegistro.SALIDA));
        int capacidadPaquete = clasificarCapacidad(obtenerTamanioPaquetesBase(String.valueOf(idPaquete)));
        actualizar(-capacidadPaquete);
        //Cambiar el estado del paquete a "Retiro Transporte"
        paquete.setEstado("Retiro Transporte");
        actualizarEstadoPaquete(String.valueOf(idPaquete),"Retiro Transporte");
        return paquete;
    }

    private void actualizarEstadoPaquete(String idPaquete, String estado) {
        int rs = -1;
        String sql = "UPDATE Paquetes SET estado = '"+ estado +"' WHERE idPaquete = " + idPaquete + ""; 
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Estado actualizado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean hayEspacioSuficiente(int capacidadPaquete) {
        return (capacidadOcupada + capacidadPaquete) < capacidadTotal;
    }

    private int clasificarCapacidad(String tamanio) {
        switch (tamanio) {
            case "grande": 
                return CAPACIDAD_PAQUETE_GRANDE;
            case "mediano": 
                return CAPACIDAD_PAQUETE_MEDIANO;
        }
        return CAPACIDAD_PAQUETE_GRANDE;
    }
    

    //Metodo que actualiza la Capacidad Ocupada del Inventario
    public void actualizar(int cantidad){
        capacidadOcupada += cantidad;
    }

    public void actualizarCapacidadTotal(int nuevaCapacidad){
        this.capacidadTotal = nuevaCapacidad;
    }

    public String calcularFechaLimite(String fechaIngreso){
        //Calcular fecha limite para cada paquete
        long diasRestantes = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
        LocalDate fechaIngresoDate = LocalDate.parse(fechaIngreso, formato);
        LocalDate fechaLimite = fechaIngresoDate.plusDays(tiempoMaximo);
        LocalDate fechaActual = LocalDate.now();
        diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaLimite);
        }catch (DateTimeParseException e){
            System.out.println(e.getMessage());
        }
        // mandar "dias restantes" a la celda del df     
        return String.valueOf(diasRestantes);  
    }

    public int getCapacidadTotal(){
        return capacidadTotal;
    }

    public int getCapacidadOcupada(){
        return capacidadOcupada;
    }

public DefaultTableModel mostrarPaquetes() {
    String[] columnas = {"ID Paquete", "Origen Paquete", "Destino Paquete", "Fecha de Ingreso", "Hora Ingreso", "Fecha Limite"};
    DefaultTableModel model = new DefaultTableModel(columnas, 0);
    ResultSet rsPaquete = null, rsFecha = null;
    for (int idPaquete : idPaquetes){
        String sql_paquete = "SELECT sucursalAceptoPaquete, sucursalParaRecoger FROM Paquetes WHERE idPaquete = " + idPaquete;
        String sql_fecha = "SELECT fecha, hora FROM Registros WHERE idPaquete = " + idPaquete + " AND tipo = 'INGRESO'";
        try {
            rsPaquete = DataHelper.getInstancia().executeQueryRead(sql_paquete);
            rsFecha = DataHelper.getInstancia().executeQueryRead(sql_fecha);

            if (rsPaquete.next() && rsFecha.next()) {
                Object[] fila = new Object[columnas.length];

                // Populate data from the first query
                fila[0] = idPaquete;
                fila[1] = rsPaquete.getString("sucursalAceptoPaquete");
                fila[2] = rsPaquete.getString("sucursalParaRecoger");

                // Populate data from the second query
                fila[3] = rsFecha.getString("fecha");
                fila[4] = rsFecha.getString("hora");
                fila[5] = calcularFechaLimite(rsFecha.getString("fecha"));

                model.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } finally {
            // Close resources to prevent resource leaks
            try {
                if (rsPaquete != null) rsPaquete.close();
                if (rsFecha != null) rsFecha.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.toString());
            }
        }
    }
    return model;
    }

    private void notificarCapacidadCompleta(){
        JOptionPane.showMessageDialog(null, "Capacidad de la bodega alcanzado", "Alerta",JOptionPane.INFORMATION_MESSAGE);
    } 

    private String getFecha(){
        return LocalDate.now().toString();
    }

    private String getHora(){
        LocalTime ahora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActual = ahora.format(formatter);
        return horaActual;
    }

    private String getAgencia(){
        return "Quito";
    }

    public String[] getDatosPaquete(String idPaquete){
        String[] dato = null;
        ResultSet rs = null;   
        String sql = "SELECT idPaquete, peso, tamanio, tipoEnvio, nombreRemitente, nombreDestinatario, sucursalAceptoPaquete, sucursalParaRecoger, estado FROM Paquetes WHERE idPaquete = " + idPaquete + "";
        try{
            rs = DataHelper.getInstancia().executeQueryRead(sql);
            ResultSetMetaData rsMd = rs.getMetaData();
            
            int cantidadDatos = rsMd.getColumnCount();
            
            dato = new String[cantidadDatos];   
            for(int i = 0; i<cantidadDatos;i++){
                dato[i]=rs.getString(i+1);
            }
            return dato;
       
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return dato;
    }

}
