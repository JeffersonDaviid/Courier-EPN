package BL.Administracion;

import UI.Administracion.BodegueroMenuPrincipal;
import UI.Administracion.VentanaLogin;
import javax.swing.JFrame;

public class Bodeguero extends Perfil {
    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;
    boolean disponible;

    public Bodeguero(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);

    }

    @Override
    public JFrame verModulos(VentanaLogin login) {
        // Implementación específica para Cliente
        return new BodegueroMenuPrincipal(login, this);
    }
    
    @Override
    public void cerrarSesion(VentanaLogin login) {
        login.setVisible(true);
    }

}
