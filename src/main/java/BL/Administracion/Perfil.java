package BL.Administracion;

import java.io.Serializable;


import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public abstract class Perfil implements Serializable {
    protected String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String telefono;
    
    public Perfil(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        
    }

    public Paquete obtenerPaquete(String idPaquete) {
        return Inventario.getInstancia().buscarPaquete(idPaquete);
    }

    public abstract void reportarProblema(String idPaquete, String problema);

    public String getCedula() {
        return cedula;
    }



    public void setCedula(String cedula) {
        this.cedula = cedula;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getCorreo() {
        return correo;
    }



    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getContrasena() {
        return contrasena;
    }



    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

}
