package BL.GestionPaquete;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
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
    private String domicilio;
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

    public Paquete() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty() || id.equals("0")) {
            Random random = new Random();
            this.id = String.valueOf(random.nextInt(1000));
        } else {
            this.id = id;
        }
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

    public String getAgenciaOrigen() {
        return agenciaOrigen;
    }

    public void setAgenciaOrigen(String agenciaOrigen) {
        this.agenciaOrigen = agenciaOrigen;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(String agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
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

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
   
   

    public ArrayList<Estado> getHistorialEstado() {
        return historialEstado;
    }

    public void agregarEstado(Estado estado) {
        historialEstado.add(estado);
    }
    
    public void registrarPaquete(Paquete paquete) {
        Recepcion recepcion = Global.getInstancia().buscarAgencia(paquete.getAgenciaOrigen()).getRecepcion();
        recepcion.agregarPaquete(paquete);
        JOptionPane.showMessageDialog(null, "El paquete: " + paquete.getId() + " ha sido registrado");
    }

    //guardar en la base
    public void guardarPaquete(Paquete paquete) {
        String fechaHoraSalida = estado.getFecha();  // Usa la fecha del último estado

        String sql = "INSERT INTO Paquete (idPaquete, peso, tamanio, sucursalAceptoPaquete, sucursalParaRecoger, fechaHoraLlegada, fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario, telefonoDestinatario, domicilio) VALUES ('"
            + paquete.getId() + "', " + paquete.getPeso() + ", '" + paquete.getTamanio() + "', '" + paquete.getAgenciaOrigen() + "', '" + paquete.getAgenciaDestino() + "', '"
            + paquete.getFechaLlegada() + "', '" + fechaHoraSalida + "', '" + paquete.getNombreRemitente() + "', '"
            + paquete.getCorreoRemitente() + "', '" + paquete.getTelefonoRemitente() + "', '" + paquete.getNombreDestinatario() + "', '"
            + paquete.getCorreoDestinatario() + "', '" + paquete.getTelefonoDestinatario() + "', '"
            + paquete.getDomicilio() + "')";

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
