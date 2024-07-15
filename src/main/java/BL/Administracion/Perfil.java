/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Administracion;

/**
 *
 * @author TOMMY
 */
public class Perfil {
    private String correo;
    private String pass;
    private String nombre;
    private String apellido;
    private String rol;

    public Perfil(String correo, String pass, String nombre, String apellido, String rol) {
        this.correo = correo;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

  
    
    public boolean ingresarSistema(String usuario, String pass) {
        return "usuario".equals(usuario) && "pass".equals(pass);
    }
    
    public void cerrarSesion() {
        System.out.println("Sesión cerrada.");
    }

 
}

