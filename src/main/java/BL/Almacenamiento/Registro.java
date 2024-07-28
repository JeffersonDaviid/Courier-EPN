package BL.Almacenamiento;

public class Registro {
    private String fechaIngreso;
    private String fechaSalida;
    private String agencia;
    private String idPaquete;

    public Registro(String fechaIngreso, String sucursal, String idPaquete) {
        this.fechaIngreso = fechaIngreso;
        this.agencia = sucursal;
        this.idPaquete = idPaquete;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String sucursal) {
        this.agencia = sucursal;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", sucursal='" + agencia + '\'' +
                ", idPaquete=" + idPaquete +
                '}';
    }
}
