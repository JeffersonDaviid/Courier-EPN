package BL.Facturacion;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;
import BL.BASEDEDATOS.DataHelper;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idPaquete;
    private String fecha;
    private float subtotal;
    private float iva;
    private float ivaPorcentaje;
    private double total;
    private String descripcionTarifa;

    /**
     * Contructor para insertar una factura en la base de datos
     * 
     * @param idCliente         id del cliente
     * @param idPaquete         id del paquete
     * @param subtotal          subtotal de la factura
     * @param iva               iva de la factura
     * @param total             total de la factura
     * @param descripcionTarifa descripcion de la tarifa
     * 
     */
    public Factura(int idCliente, int idPaquete, float subtotal, float iva, double total, String descripcionTarifa) {
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    /**
     * Constructor para obtener una factura de la base de datos
     * 
     * @param idFactura
     * @param idCliente
     * @param idPaquete
     * @param fecha
     * @param subtotal
     * @param iva
     * @param total
     * @param descripcionTarifa
     */
    public Factura(int idFactura, int idCliente, int idPaquete, String fecha, float subtotal, float iva,
            float ivaPorcentaje, double total,
            String descripcionTarifa) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.ivaPorcentaje = ivaPorcentaje;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    public void guardarFactura() {
        Properties props = new Properties();
        try {
            var in = Files.newInputStream(Paths.get("opciones.properties"));
            props.load(in);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo de propiedades: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Formato: yyyy-MM-dd HH:mm:ss en string
        java.util.Date fechaActual = new java.util.Date();
        fecha = String.format("%tF %tT", fechaActual, fechaActual);
        int rs = -1;

        String sql = "INSERT INTO FACTURAS (idCliente, idPaquete, fecha, subtotal, iva, ivaPorcentaje, total, descripcionTarifa) VALUES ("
                + idCliente + ", " + idPaquete + ", '" + fecha + "', " + subtotal + ", " + iva + ", "
                + Float.parseFloat(props.getProperty("IVA")) + ", " + total + ", '"
                + descripcionTarifa + "')";

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
    }

    public static Factura obtenerFactura(int idFactura) {
        Factura factura = null;
        String sql = String.format("SELECT * FROM FACTURAS WHERE idFactura = %d", idFactura);

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);
            while (rs.next()) {
                factura = new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idCliente"),
                        rs.getInt("idPaquete"),
                        rs.getString("fecha"),
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

        // mostrar factura en pantalla
        if (factura != null) {
            String message = "<html><body>"
                    + "ID Factura: " + factura.idFactura + "<br>"
                    + "ID Cliente: " + factura.idCliente + "<br>"
                    + "ID Paquete: " + factura.idPaquete + "<br>"
                    + "Fecha: " + factura.fecha + "<br>"
                    + "Subtotal: " + factura.subtotal + "<br>"
                    + "IVA (" + factura.ivaPorcentaje + "%): " + factura.iva + "<br>"
                    + "Total: " + factura.total + "<br>"
                    + "Descripcion de la tarifa: " + factura.descripcionTarifa + "<br>"
                    + "</body></html>";
            JOptionPane.showMessageDialog(null, message, "Factura", JOptionPane.INFORMATION_MESSAGE);
        }

        return factura;
    }
}
