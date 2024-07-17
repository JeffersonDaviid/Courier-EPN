package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;
import BL.BASEDEDATOS.*;

/**
 *
 * @author BugsBusters
 */
public class Inventario {
    private HashMap<Integer,Paquete> paquetes;
    private int capacidadTotal;
    private int capacidadOcupada;
    private Historial historial;
    private int tiempoMaximo;
    private final int CAPACIDAD_PAQUETE_PEQUENIO = 1;
    private final int CAPACIDAD_PAQUETE_MEDIANO = 2;
    private final int CAPACIDAD_PAQUETE_GRANDE = 3;

    public Inventario(int tiempoMaximo, int capacidadTotal){
        this.tiempoMaximo = tiempoMaximo;
        this.capacidadTotal = capacidadTotal;
        this.paquetes = getPaquetesAlmacenados();
        this.capacidadOcupada = calcularCapacidadOcupada();
        this.historial = new Historial();
    }

    //Método que calcula la capacidad ocupada por los paquetes ya almacenados en la bodega
    private int calcularCapacidadOcupada() {
        int capacidad = 0;
        for (Paquete paq : paquetes.values()) {
            capacidad += clasificarCapacidad(paq.getTamanio());
        }
        return capacidad;
    }

    private HashMap<Integer, Paquete> getPaquetesAlmacenados() {
        HashMap<Integer,Paquete> paquetesBaseDeDatos = new HashMap<>();
        String sql = "SELECT * FROM Paquete WHERE estado = 'En bodega'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);
    
            while (rs.next()) {
                int idPaquete = rs.getInt("idPaquete");
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
                float precio = rs.getFloat("precio");
                String trackingNumber = rs.getString("trackingNumber");
                String estado = rs.getString("estado");
                
                paquetesBaseDeDatos.put(idPaquete, new Paquete(idPaquete, peso, tamanio, fechaHoraLlegada, 
                fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario,
                correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger,
                precio, trackingNumber, estado, precio));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paquetesBaseDeDatos;
    }

    //Metodo que registra un paquete que se ha recibido la agencia
    public void registrarPaquete(String idPaquete){
        Paquete paquete = obtenerPaquete(idPaquete);
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        //Si no hay espacio para ingresar el paquete, se notifica y termina elmetodo
        if(!hayEspacioSuficiente(capacidadPaquete)){
            notificarCapacidadCompleta();
            return;
        }
        //Si existe espacio suficiente, se ingresa a la bodega y se crea el registro
        paquetes.put(Integer.parseInt(idPaquete), paquete);
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),idPaquete,TipoRegistro.INGRESO));
        JOptionPane.showMessageDialog(null, "registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizarBodega(capacidadPaquete);
        //Cambiar estado del paquete a "En bodega"
        actualizarEstadoPaquete(idPaquete,"En Bodega");
    }

    public void retirarPaquete(String idPaquete){
        Paquete paquete = paquetes.remove(Integer.parseInt(idPaquete));
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),idPaquete,TipoRegistro.SALIDA));
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        actualizarBodega(-capacidadPaquete);
        //Cambiar el estado del paquete a "Transportandose"
        actualizarEstadoPaquete(idPaquete,"Transportandose");
    } 

    private void actualizarEstadoPaquete(String idPaquete, String estado) {
        int rs = -1;
        String sql = "UPDATE Paquete SET estado = '"+ estado +"' WHERE idPaquete = '" + idPaquete + "';"; 
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
            case "GRANDE": 
                return CAPACIDAD_PAQUETE_GRANDE;
            case "MEDIANO": 
                return CAPACIDAD_PAQUETE_MEDIANO;
        }
        return CAPACIDAD_PAQUETE_GRANDE;
    }

    private Paquete obtenerPaquete(String idPaquete) {
        String sql = "SELECT * FROM Paquete WHERE idPaquete = '" + idPaquete +"'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);
    
            while (rs.next()) {

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
                float precio = rs.getFloat("precio");
                String trackingNumber = rs.getString("trackingNumber");
                String estado = rs.getString("estado");
                
                return new Paquete(Integer.parseInt(idPaquete), peso, tamanio, fechaHoraLlegada, 
                fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario,
                correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger,
                precio, trackingNumber, estado, precio);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Metodo que actualiza la Capacidad Ocupada del Inventario
    public void actualizarBodega(int cantidad){
        capacidadOcupada += cantidad;
    }

    public void actualizarCapacidadTotal(int nuevaCapacidad){
        this.capacidadTotal = nuevaCapacidad;
    }

    public void calcularFechaLimite(){
        //Calcular fecha limite para cada paquete
    }

    public int getCapacidadTotal(){
        return capacidadTotal;
    }

    public int getCapacidadOcupada(){
        return capacidadOcupada;
    }

    public void mostrarPaquetes(){
    }

    public void buscarPaquete(String idPaquete){
        Paquete paquete = paquetes.remove(idPaquete);
        System.out.println(paquete);
    }

    private void notificarCapacidadCompleta(){
        JOptionPane.showMessageDialog(null, "Capacidad de la bodega alcanzado", "Alerta",JOptionPane.INFORMATION_MESSAGE);
    } 

    private String getFecha(){
        return LocalDate.now().toString();
    }
    private String getHora(){
        return LocalTime.now().toString();
    }

    private String getAgencia(){
        return "Quito";
    }

}
