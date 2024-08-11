package BL.Administracion;

import java.io.Serializable;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public abstract class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String agencia;
    protected Inventario inventario;
    
    public Perfil(String nombre, String apellido, String cedula, String correo, String contrasena){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
        //this.inventario = Inventario.obtenerInstancia();
    }

    // public Paquete obtenerPaquete(String idPaquete) {
    //     return Inventario.obtenerInstancia().obtenerPaquete(idPaquete);
    // }

    public abstract void reportarProblema(String idPaquete);

    // public Paquete obtenerPaquete(String idPaquete) {
    //     //return Inventario.obtenerInstancia().obtenerPaquete(idPaquete);
    // }

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



    public String getAgencia() {
        return agencia;
    }



    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

}
