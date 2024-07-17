/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Administracion;

import BL.BASEDEDATOS.DataHelper;
import UI.Administracion.VentanaLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase Perfil para la administración de usuarios
 * 
 */
public abstract class Perfil {
    private String cedula;
    private String correo;
    private String pass;
    private String nombre;
    private String apellido;

    public Perfil(String cedula, String correo, String pass, String nombre, String apellido) {
        this.cedula = cedula;
        this.correo = correo;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public abstract JFrame verModulos(VentanaLogin login);

    public String getCedula(){
        return cedula;
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
    
    
}
