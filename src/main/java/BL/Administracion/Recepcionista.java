/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Administracion;

import UI.Administracion.ClienteMenuPrincipal;
import UI.Administracion.RecepcionistaMenuPrincipal;
import UI.Administracion.VentanaLogin;
import javax.swing.JFrame;

/**
 *
 * @author PCM
 */
public class Recepcionista extends Perfil {
    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;

    public Recepcionista(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);
    }
    
    @Override
    public JFrame verModulos(VentanaLogin login) {
        // Implementación específica para Cliente
        return new RecepcionistaMenuPrincipal(login, this);
    }
}
