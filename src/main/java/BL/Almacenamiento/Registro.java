package BL.Almacenamiento;

public class Registro {
    private String fecha;
    private String hora;
    private String sucursal;
    private String idPaquete;
    private TipoRegistro tipo;

    /**
    *
    * @author BugsBusters
    */
    public Registro(String fecha, String hora, String sucursal, String idPaquete, TipoRegistro tipoRegistro ){
        this.fecha = fecha;
        this.hora = hora;
        this.sucursal = sucursal;
        this.idPaquete = idPaquete;
        this.tipo = tipoRegistro;
    }

    public String obtenerInformacion() {
        // Algoritmo
        return "";
    }

    public String getIdPaquete() {
        return String.valueOf(idPaquete);
    }

    public String getFecha(){
        return fecha;
    }

    public String getHora(){
        return hora;
    }

    public String getSucursal(){
        return sucursal;
    }

    public String getTipo(){
        return String.valueOf(tipo);
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