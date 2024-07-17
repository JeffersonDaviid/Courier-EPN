/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Administracion;

/**
 *
 * @author PCM
 */
public class PerfilFactory {
    public static Perfil crearPerfil(String rol, String cedula, String correo, String pass, String nombre, String apellido) {
        switch (rol) {
            case "Cliente":
                return new Cliente(cedula, correo, pass, nombre, apellido);
            //case "Recepcionista":
                //return new Recepcionista(cedula, correo, pass, nombre, apellido);
            case "Bodeguero":
                return new Bodeguero(cedula, correo, pass, nombre, apellido);
            case "Administrador":
                return new Administrador(cedula, correo, pass, nombre, apellido);
            case "Transportista":
                return new Transportista(cedula, correo, pass, nombre, apellido);
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }
    }
    
    /*public static Perfil crearPerfil(String rol, String cedula, String correo, String pass, String nombre, String apellido, boolean disponible) {
        if (rol.equals("Transportista")) {
            return new Transportista(cedula, correo, pass, nombre, apellido, disponible);
        } else {
            throw new IllegalArgumentException("Rol no compatible con atributo disponible: " + rol);
        }
    }*/
}
