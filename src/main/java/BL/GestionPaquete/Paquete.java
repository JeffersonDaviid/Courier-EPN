package BL.GestionPaquete;

import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Tarifa;
import BL.Facturacion.TarifaDomicilio;
import BL.Facturacion.TarifaEnvio;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Random;

public class Paquete {
    private int id_paquete;
    private float peso;
    private String tamanio;
    private String fechaHoraLlegada;
    private String fechaHoraSalida;
    private String nombreRemitente;
    private String correoRemitente;
    private String telefonoRemitente;
    private String nombreDestinatario;
    private String correoDestinatario;
    private String telefonoDestinatario;
    private String tipoEnvio;
    private String sucursalAceptoPaquete;
    private String sucursalParaRecoger;
    private float precio;
    private String trackingNumber;
    private String estado;
    private float precioEnvio;

    public Paquete() {
        this.trackingNumber = generateTrackingNumber();
        this.estado = "recibido";
    }

    public Paquete(int id_paquete, float peso, String tamanio, String fechaHoraLlegada, String fechaHoraSalida, String nombreRemitente, String correoRemitente, String telefonoRemitente, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String tipoEnvio, String sucursalAceptoPaquete, String sucursalParaRecoger, float precio, String trackingNumber, String estado, float precioEnvio) {
        this.id_paquete = id_paquete;
        this.peso = peso;
        this.tamanio = tamanio;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.nombreRemitente = nombreRemitente;
        this.correoRemitente = correoRemitente;
        this.telefonoRemitente = telefonoRemitente;
        this.nombreDestinatario = nombreDestinatario;
        this.correoDestinatario = correoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.tipoEnvio = tipoEnvio;
        this.sucursalAceptoPaquete = sucursalAceptoPaquete;
        this.sucursalParaRecoger = sucursalParaRecoger;
        this.precio = precio;
        this.trackingNumber = trackingNumber;
        this.estado = estado;
        this.precioEnvio = precioEnvio;
    }

    public void setPrecioEnvio(float precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
    
    

   

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(String fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getCorreoRemitente() {
        return correoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }

    public String getTelefonoRemitente() {
        return telefonoRemitente;
    }

    public void setTelefonoRemitente(String telefonoRemitente) {
        this.telefonoRemitente = telefonoRemitente;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    public void setCorreoDestinatario(String correoDestinatario) {
        this.correoDestinatario = correoDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getSucursalAceptoPaquete() {
        return sucursalAceptoPaquete;
    }

    public void setSucursalAceptoPaquete(String sucursalAceptoPaquete) {
        this.sucursalAceptoPaquete = sucursalAceptoPaquete;
    }

    public String getSucursalParaRecoger() {
        return sucursalParaRecoger;
    }

    public void setSucursalParaRecoger(String sucursalParaRecoger) {
        this.sucursalParaRecoger = sucursalParaRecoger;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    private String generateTrackingNumber() {
        Random random = new Random();
        int number = 1000000 + random.nextInt(9000000);
        return String.valueOf(number);
    }
    
    public void calcularPrecioEnvio(String tipoEnvio,float peso,String tamanio,String sucursalAceptaPaquete,String sucursalRecibe) {
        Tarifa tarifa;
        if (tipoEnvio.equals("Domicilio")) {
            tarifa = new TarifaDomicilio(new TarifaEnvio(peso, tamanio, sucursalAceptaPaquete, sucursalRecibe));
        } else { // Suponiendo que el otro caso es "Agencia"
            tarifa = new TarifaEnvio(peso, tamanio, sucursalAceptaPaquete, sucursalRecibe);
        }

        tarifa.calcularPrecioEnvio(); // Calcular el precio de envío
        this.precioEnvio = tarifa.getTotal(); // Guardar el precio en el objeto Paquete

        // Mostrar costo de envío en algún componente visual si es necesario
        //JOptionPane.showMessageDialog(null, "Precio de envío calculado: " + this.precioEnvio, "Precio de Envío", JOptionPane.INFORMATION_MESSAGE);
    }

    // Otros métodos getter y setter según sea necesario
    public float getPrecioEnvio() {
        return precioEnvio;
    }

    public void guardarPaquete(Paquete paquete) {
        int rs = -1;
        String sql = "INSERT INTO Paquete (peso, tamanio, fechaHoraLlegada, fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger, precio, trackingNumber, estado) VALUES ("
            + paquete.getPeso() + ", '" + paquete.getTamanio() + "', '" + paquete.getFechaHoraLlegada() + "', '"
            + paquete.getFechaHoraSalida() + "', '" + paquete.getNombreRemitente() + "', '"
            + paquete.getCorreoRemitente() + "', '" + paquete.getTelefonoRemitente() + "', '" + paquete.getNombreDestinatario() + "', '"
            + paquete.getCorreoDestinatario() + "', '" + paquete.getTelefonoDestinatario() + "', '" + paquete.getTipoEnvio() + "', '"
            + paquete.getSucursalAceptoPaquete() + "', '" + paquete.getSucursalParaRecoger() + "', " + paquete.getPrecio() + ", '"
            + paquete.getTrackingNumber() + "', '" + paquete.getEstado() + "')";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Paquete guardado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el paquete", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el paquete: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
