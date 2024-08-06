package BL.Almacenamiento;

public class Registro {
    private String fechaIngreso;
    private String fechaSalida;
    private String agencia;
    private String idPaquete;

    public Registro(String fechaIngreso, String agencia, String idPaquete) {
        this.fechaIngreso = fechaIngreso;
        this.agencia = agencia;
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

    public String getIdPaquete() {
        return idPaquete;
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
