package BL.Facturacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class Factura {
    private int idFactura;
    private int idPaquete;
    private String trackingNumber;
    private String nombreRemitente;
    private String correoRemitente;
    private String telefonoRemitente;
    private String nombreDestinatario;
    private String correoDestinatario;
    private String telefonoDestinatario;
    private String fecha = String.format("%tF %tT", new java.util.Date(), new java.util.Date());
    private String sucursalAceptoPaquete;
    private String sucursalParaRecoger;
    private String domicilio;
    private Float peso;
    private String tamanio;
    private float subtotal;
    private float iva;
    private float ivaPorcentaje;
    private double total;
    private String descripcionTarifa;

    public Factura() {
    }

    /**
     * Constructor para obtener una factura de la base de datos
     */
    public Factura(int idFactura, int idPaquete, String trackingNumber, String nombreRemitente, String correoRemitente,
            String telefonoRemitente, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario,
            String fecha, String sucursalAceptoPaquete, String sucursalParaRecoger, String domicilio, float peso,
            String tamanio, float subtotal, float iva, float ivaPorcentaje, double total, String descripcionTarifa) {
        this.idFactura = idFactura;
        this.idPaquete = idPaquete;
        this.trackingNumber = trackingNumber;
        this.telefonoDestinatario = nombreRemitente;
        this.nombreRemitente = correoRemitente;
        this.telefonoRemitente = telefonoRemitente;
        this.nombreDestinatario = nombreDestinatario;
        this.correoDestinatario = correoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.fecha = fecha;
        this.sucursalAceptoPaquete = sucursalAceptoPaquete;
        this.sucursalParaRecoger = sucursalParaRecoger;
        this.domicilio = domicilio;
        this.peso = peso;
        this.tamanio = tamanio;
        this.subtotal = subtotal;
        this.iva = iva;
        this.ivaPorcentaje = ivaPorcentaje;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    public void guardarFactura(Paquete paquete, Tarifa tarifa) {
        subtotal = tarifa.getSubtotal();
        total = tarifa.getTotal();
        iva = tarifa.getIva();

        int rs = -1;

        String sql = "INSERT INTO FACTURAS ( idPaquete, fecha, subtotal, iva, ivaPorcentaje, total, descripcionTarifa) VALUES ("
                + paquete.getId() + ", '" + fecha + "', " + subtotal + ", " + (subtotal * iva / 100) + ", "
                + iva + ", " + total + ", '" + tarifa.getDescripcionTarifa() + "')";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Factura guardada con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // mostrar factura en pantalla

        String message = "<html><body>"
                + "ID Factura: " + idFactura + "<br>"
                + "ID Paquete: " + idPaquete + "<br>"
                + "Fecha: " + fecha + "<br>"
                + "Subtotal: " + subtotal + "<br>"
                + "IVA (" + iva + "%): " + subtotal * iva / 100 + "<br>"
                + "Total: " + total + "<br>"
                + "Descripcion de la tarifa: " + descripcionTarifa + "<br>"
                + "</body></html>";
        JOptionPane.showMessageDialog(null, message, "Factura",
                JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * 
     * @param codigo puede ser el ID de la factura o el ID del paquete
     * @return
     */
    public Factura buscarFactura(String codigo) {
        Factura factura = null;
        String sql = String.format(
                "SELECT * FROM FACTURAS fa JOIN PAQUETES pa on fa.idPaquete = pa.idPaquete WHERE fa.idFactura = %d OR fa.idPaquete = %d",
                codigo, codigo);

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);
            while (rs.next()) {
                factura = new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idPaquete"),
                        rs.getString("trackingNumber"),
                        rs.getString("nombreRemitente"),
                        rs.getString("correoRemitente"),
                        rs.getString("telefonoRemitente"),
                        rs.getString("nombreDestinatario"),
                        rs.getString("correoDestinatario"),
                        rs.getString("telefonoDestinatario"),
                        rs.getString("fecha"),
                        rs.getString("sucursalAceptoPaquete"),
                        rs.getString("sucursalParaRecoger"),
                        rs.getString("domicilio"),
                        rs.getFloat("peso"),
                        rs.getString("tamanio"),
                        rs.getFloat("subtotal"),
                        rs.getFloat("iva"),
                        rs.getFloat("ivaPorcentaje"),
                        rs.getDouble("total"),
                        rs.getString("descripcionTarifa"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return factura;
    }

    public void mostrarFactura(Factura factura) {
        // mostrar factura en pantalla
        if (factura != null) {
            String message = "<html><body>"
                    + "ID Factura: " + factura.idFactura + "<br>"
                    + "ID Paquete: " + factura.idPaquete + "<br>"
                    + "Fecha: " + this.fecha + "<br>"
                    + "Subtotal: " + factura.subtotal + "<br>"
                    + "IVA (" + factura.ivaPorcentaje + "%): " + this.iva + "<br>"
                    + "Total: " + factura.total + "<br>"
                    + "Descripcion de la tarifa: " + factura.descripcionTarifa + "<br>"
                    + "</body></html>";
            JOptionPane.showMessageDialog(null, message, "Factura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public String getCorreoRemitente() {
        return correoRemitente;
    }

    public String getTelefonoRemitente() {
        return telefonoRemitente;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSucursalAceptoPaquete() {
        return sucursalAceptoPaquete;
    }

    public String getSucursalParaRecoger() {
        return sucursalParaRecoger;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Float getPeso() {
        return peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getIva() {
        return iva;
    }

    public float getIvaPorcentaje() {
        return ivaPorcentaje;
    }

    public double getTotal() {
        return total;
    }

    public String getDescripcionTarifa() {
        return descripcionTarifa;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

}
