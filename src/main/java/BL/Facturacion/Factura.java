package BL.Facturacion;

import BL.GestionPaquete.Paquete;

public class Factura {
    private String fechaRegistro;
    private String fechaActualizacion;
    private String observacion;
    private Paquete paquete;
    private Precio precio = new Precio();

    public Factura() {
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
