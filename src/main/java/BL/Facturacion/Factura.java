package BL.Facturacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import BL.BASEDEDATOS.DataHelper;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idPaquete;
    private String fecha;
    private double subtotal;
    private double iva;
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
    public Factura(int idCliente, int idPaquete, double subtotal, double iva, double total,
            String descripcionTarifa) {
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    public Factura(int idFactura, int idCliente, int idPaquete, String fecha, double subtotal, double iva, double total,
            String descripcionTarifa) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.descripcionTarifa = descripcionTarifa;
    }

    public void guardarFactura() {
        String sql = String.format(
                "INSERT INTO FACTURA (subtotal, iva, total, descripcionTarifa) VALUES (%f, %f, %f, '%s')",
                subtotal, iva, total, descripcionTarifa);

        try {
            ResultSet rs = DataHelper.getInstancia().getResultSet(sql);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Factura obtenerFactura(int idFactura) {
        Factura factura = null;
        String sql = String.format("SELECT * FROM FACTURAS WHERE idFactura = %d", idFactura);

        try {
            ResultSet rs = DataHelper.getInstancia().getResultSet(sql);
            System.out.println(rs);
            while (rs.next()) {
                factura = new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idCliente"),
                        rs.getInt("idPaquete"),
                        rs.getString("fecha"),
                        rs.getDouble("subtotal"),
                        rs.getDouble("iva"),
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
                    + "ID Factura: " + factura.idFactura + ".<br>"
                    + "ID Cliente: " + factura.idCliente + ".<br>"
                    + "ID Paquete: " + factura.idPaquete + ".<br>"
                    + "Fecha: " + factura.fecha + ".<br>"
                    + "Subtotal: " + factura.subtotal + ".<br>"
                    + "IVA: " + factura.iva + ".<br>"
                    + "Total: " + factura.total + ".<br>"
                    + "Descripcion de la tarifa: " + factura.descripcionTarifa + ".<br>"
                    + "</body></html>";
            JOptionPane.showMessageDialog(null, message, "Factura", JOptionPane.INFORMATION_MESSAGE);
        }

        return factura;
    }
}
