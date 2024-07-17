package BL.Facturacion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;
import BL.BASEDEDATOS.DataHelper;

public class Factura {
    private int idFactura;
    private String cedulaCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int idPaquete;
    private static String fecha = String.format("%tF %tT", new java.util.Date(), new java.util.Date());;
    private float subtotal;
    private static float iva;
    private float ivaPorcentaje;
    private double total;
    private String descripcionTarifa;

    /**
     * Constructor para obtener una factura de la base de datos
     * 
     * @param idFactura
     * @param cedulaCliente
     * @param idPaquete
     * @param fecha
     * @param subtotal
     * @param iva
     * @param total
     * @param descripcionTarifa
     */
    public Factura(int idFactura, int idPaquete, String cedulaCliente, String nombreCliente, String apellidoCliente,
            String fecha, float subtotal, float iva, float ivaPorcentaje, double total, String descripcionTarifa) {
        this.idFactura = idFactura;
        this.idPaquete = idPaquete;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        Factura.fecha = fecha;
        this.subtotal = subtotal;
        Factura.iva = iva;
        this.ivaPorcentaje = ivaPorcentaje;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    public static void guardarFactura(String correoCliente, String idPaquete, float subtotal, double total,
            String descripcionTarifa) {
        cargarIva();
        int rs = -1;

        String sql = "INSERT INTO FACTURAS (correoCliente, idPaquete, fecha, subtotal, iva, ivaPorcentaje, total, descripcionTarifa) VALUES ("
                + correoCliente + ", " + idPaquete + ", '" + fecha + "', " + subtotal + ", " + (subtotal * iva) + ", "
                + iva + ", " + total + ", '" + descripcionTarifa + "')";

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

    public static Factura obtenerFactura(int idFactura, String idPaquete) {
        Factura factura = null;
        String sql = String.format(
                "SELECT * FROM FACTURAS fa JOIN CLIENTES cl on fa.correoCliente = cl.correoCliente WHERE idFactura = %d OR idPaquete = %d",
                idFactura, idPaquete);

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);
            while (rs.next()) {
                factura = new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idPaquete"),
                        rs.getString("cl.correoCliente"),
                        rs.getString("nombreCliente"),
                        rs.getString("apellidoCliente"),
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
                    + "ID Paquete: " + factura.idPaquete + "<br>"
                    + "ID Cliente: " + factura.cedulaCliente + "<br>"
                    + "ID Cliente: " + factura.nombreCliente + "<br>"
                    + "ID Cliente: " + factura.apellidoCliente + "<br>"
                    + "Fecha: " + Factura.fecha + "<br>"
                    + "Subtotal: " + factura.subtotal + "<br>"
                    + "IVA (" + factura.ivaPorcentaje + "%): " + Factura.iva + "<br>"
                    + "Total: " + factura.total + "<br>"
                    + "Descripcion de la tarifa: " + factura.descripcionTarifa + "<br>"
                    + "</body></html>";
            JOptionPane.showMessageDialog(null, message, "Factura", JOptionPane.INFORMATION_MESSAGE);
        }

        return factura;
    }

    private static void cargarIva() {
        Properties props = new Properties();
        try {
            var in = Files.newInputStream(Paths.get("opciones.properties"));
            props.load(in);
            iva = Float.parseFloat(props.getProperty("IVA"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo de propiedades: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getIdFactura() {
        return idFactura;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public static String getFecha() {
        return fecha;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public static float getIva() {
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

}
