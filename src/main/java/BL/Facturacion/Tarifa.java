package BL.Facturacion;

public abstract class Tarifa {

    private float precio;
    private String descripcionTarifa;

    public abstract void calcularPrecioEnvio();

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcionTarifa() {
        return descripcionTarifa;
    }

    public void setDescripcionTarifa(String descripcionTarifa) {
        this.descripcionTarifa = descripcionTarifa;
    }
}
