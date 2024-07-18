package BL.Administracion;

//import UI.Administracion.VentanaPrincipal;
import javax.swing.JFrame;

import BL.Transporte.Vehiculo;
import UI.Administracion.TransportistaMenuPrincipal;
import UI.Administracion.VentanaLogin;

public class Transportista extends Perfil {
    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;
    boolean disponible;
    Vehiculo camion;

    public Transportista(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);
        this.camion = null;
    }

    public Vehiculo getCamion() {
        return camion;
    }

    public void setCamion(Vehiculo camion) {
        this.camion = camion;
    }

    @Override
    public JFrame verModulos(VentanaLogin login) {
        return new TransportistaMenuPrincipal(login, this);
    }

    @Override
    public void cerrarSesion(VentanaLogin login) {
        login.setVisible(true);
    }

}
