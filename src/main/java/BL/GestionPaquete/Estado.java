package BL.GestionPaquete;

public class Estado {

    private String estado;
    private String fecha;

    public Estado(String estado) {
        this.estado = estado;
        // insertar fecha y hora actual en formato dd/mm/yyyy hh:mm:ss
        this.fecha = String.format("%tF %tT", new java.util.Date(), new java.util.Date());
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

}
