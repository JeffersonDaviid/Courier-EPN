package BL.Facturacion;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;

public class Factura {
    private String id;
    private String fecha;
    private String total;

    public Factura() {
    }

    public Factura(String id, String fecha, String total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public void guardarFactura(Paquete paquete, Tarifa tarifa) {
        float subtotal = tarifa.getSubtotal();
        float total = tarifa.getTotal();
        float iva = tarifa.getIva();

        JOptionPane.showMessageDialog(null, "Factura guardada");

    }

    public void mostrarFactura() {
        String mensaje = "Factura: " + id + "\nFecha: " + fecha + "\nTotal: " + total;
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
