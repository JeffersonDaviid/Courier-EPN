package BL.Administracion;

public class Recepcionista {

    private String nombre;
    private String contrasena;
    private String agencia;

    public Recepcionista(String nombre, String contrasena, String agencia) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.agencia = agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getAgencia() {
        return agencia;
    }

}
