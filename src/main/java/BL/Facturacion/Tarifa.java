package BL.Facturacion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JOptionPane;

public abstract class Tarifa {

    private float subtotal;
    private float total;
    private float ivaPorcentaje;

    private String descripcionTarifa;

    public abstract void calcularPrecioEnvio();

    public void mostrarCostoEnvio() {
        String total = String.format("%.2f", getTotal());
        String message = "<html><body>"
                + "Costo de envio total: " + total + "<br>"
                + "</body></html>";
        JOptionPane.showMessageDialog(null, message, "Descripcion del envio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cargarIvar() {
        Properties props = new Properties();
        try {
            var in = Files.newInputStream(Paths.get("opciones.properties"));
            props.load(in);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar el archivo de propiedades: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        ivaPorcentaje = Float.parseFloat(props.getProperty("IVA"));
    }

    public float getIvaPorcentaje() {
        return ivaPorcentaje;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDescripcionTarifa() {
        return descripcionTarifa;
    }

    public void setDescripcionTarifa(String descripcionTarifa) {
        this.descripcionTarifa = descripcionTarifa;
    }
}
