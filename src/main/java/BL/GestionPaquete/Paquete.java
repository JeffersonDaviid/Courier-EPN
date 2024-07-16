package BL.GestionPaquete;

import BL.BASEDEDATOS.DataHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TOMMY
 */
public class Paquete {
  //  private String id_paquete;
    private float peso;
    private String tamanio;
    private String isfragil;
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

    public Paquete() {
    }

    public Paquete(float peso, String tamanio, String isfragil, String fechaHoraLlegada, String fechaHoraSalida, String nombreRemitente, String correoRemitente, String telefonoRemitente, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String tipoEnvio, String sucursalAceptoPaquete, String sucursalParaRecoger, float precio) {
       
        this.peso = peso;
        this.tamanio = tamanio;
        this.isfragil = isfragil;
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
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public String getIsfragil() {
        return isfragil;
    }

    public void setIsfragil(String isfragil) {
        this.isfragil = isfragil;
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
    
    private static final String ID_PREFIX = "PQE";

    private String generarNuevoIdPaquete() {
        int ultimoId = 0;
        String sql = "SELECT MAX(idPaquete) AS max_id FROM Paquete";

        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);

            if (rs.next()) {
                String maxIdStr = rs.getString("max_id");
                if (maxIdStr != null) {
                    ultimoId = Integer.parseInt(maxIdStr.replace(ID_PREFIX, ""));
                }
            }

            dataHelper.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ID_PREFIX + (ultimoId + 1);
    }
    /*
    
    
    */
   public void guardarPaquete(Paquete paquete) {
    int rs = -1;
    String sql = "INSERT INTO Paquete (peso, tamanio, isFragil, fechaHoraLlegada, fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger, precio) VALUES ("
        + paquete.getPeso() + ", '" + paquete.getTamanio() + "', '" + paquete.getIsfragil() + "', '"
        + paquete.getFechaHoraLlegada() + "', '" + paquete.getFechaHoraSalida() + "', '" + paquete.getNombreRemitente() + "', '"
        + paquete.getCorreoRemitente() + "', '" + paquete.getTelefonoRemitente() + "', '" + paquete.getNombreDestinatario() + "', '"
        + paquete.getCorreoDestinatario() + "', '" + paquete.getTelefonoDestinatario() + "', '" + paquete.getTipoEnvio() + "', '"
        + paquete.getSucursalAceptoPaquete() + "', '" + paquete.getSucursalParaRecoger() + "', " + paquete.getPrecio() + ")";

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
