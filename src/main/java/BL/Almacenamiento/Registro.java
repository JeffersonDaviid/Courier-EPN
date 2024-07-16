package BL.Almacenamiento;

public class Registro {
    private String fecha;
    private String hora;
    private String sucursal;
    private String idPaquete;

    /**
    *
    * @author BugsBusters
    */
    public Registro(String fecha, String hora, String sucursal, String idPaquete){
        this.fecha = fecha;
        this.hora = hora;
        this.sucursal = sucursal;
        this.idPaquete = idPaquete;
    }

    public String obtenerInformacion() {
        // Algoritmo
        return "";
    }

    public String getIdPaquete() {
        return String.valueOf(idPaquete);
    }

    @Override
    public String toString() {
        return "Registro -> " +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", sucursal='" + sucursal + '\'' +
                '}';
    }
}