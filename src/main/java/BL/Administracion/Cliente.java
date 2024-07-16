/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Administracion;

/**
 *
 * @author PCM
 */
public class Cliente extends Perfil {
    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;

    public Cliente(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);
    }
    
    @Override
    public boolean ingresarSistema(String usuario, String pass) {
        // Logica especifica del cliente
        return super.ingresarSistema(usuario, pass);
    }

    @Override
    public void cerrarSesion() {
        // Logica especifica del cliente
        super.cerrarSesion();
    }

    public void consultarEnvio() {
        String nombre = this.nombre;
        String apellido = this.apellido;
        //Logica para consultar envio
    }
    
    public void reportarReclamo() {
        String nombre = this.nombre;
        String apellido = this.apellido;
        //Logica para reportar reclamo
    }
}
