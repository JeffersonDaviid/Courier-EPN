package BL.GestionPaquete;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Agencia.Global;
import BL.BASEDEDATOS.DataHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Paquete {
    private String id;
    private float peso;
    private String tamanio;
    private ArrayList<Estado> historialEstado = new ArrayList<>();
    private String agenciaOrigen;
    private String agenciaDestino;
   // private String domicilio;
    private String nombreRemitente;
    private String correoRemitente;
    private String telefonoRemitente;
    private String nombreDestinatario;
    private String correoDestinatario;
    private String telefonoDestinatario;
    private String Domicilio;
    private String fechaLlegada;
    Estado estado;
    //private String trackingNumber;

    public Paquete(String id, float peso, String tamanio, String agenciaOrigen, String agenciaDestino, String nombreRemitente, String correoRemitente, String telefonoRemitente, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String Domicilio, String fechaLlegada) {
        this.id = id;
        this.peso = peso;
        this.tamanio = tamanio;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.nombreRemitente = nombreRemitente;
        this.correoRemitente = correoRemitente;
        this.telefonoRemitente = telefonoRemitente;
        this.nombreDestinatario = nombreDestinatario;
        this.correoDestinatario = correoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.Domicilio = Domicilio;
        this.fechaLlegada = fechaLlegada;
    }

   
    
    public String getFechaLlegada() {
        return fechaLlegada;
    }

    /// getters and sets
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
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

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }
    

   
    public void agregarEstado(Estado estado) {
        historialEstado.add(estado);
    }

    public String getId() {
        return id;
    }

    public String getAgenciaOrigen() {
        return agenciaOrigen;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public float getPeso() {
        return peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public ArrayList<Estado> getHistorialEstado() {
        return historialEstado;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void registrarPaquete(Paquete paquete) {
        Recepcion recepcion = Global.getInstancia().buscarAgencia(paquete.getAgenciaOrigen()).getRecepcion();
        recepcion.agregarPaquete(paquete);
        JOptionPane.showMessageDialog(null, "El paquete: " + paquete.getId() + " ha sido registrado");
    }
    
    //guardar en la base
    private void guardarPaquete() {
        String fechaHoraSalida = estado.getFecha();  // Usa la fecha del último estado
        String estadoPaquete = estado.getEstado();  // Usa el estado del último estado

        String sql = "INSERT INTO Paquete (peso, tamanio, fechaHoraLlegada, fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario, telefonoDestinatario, domicilio, estado) VALUES ("
            + peso + ", '" + tamanio + "', '" + fechaLlegada + "', '"
            + fechaHoraSalida + "', '" + nombreRemitente + "', '"
            + correoRemitente + "', '" + telefonoRemitente + "', '" + nombreDestinatario + "', '"
            + correoDestinatario + "', '" + telefonoDestinatario + "', '"
            + Domicilio + "', '" + estadoPaquete + "')";

        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

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
