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

    public void registrarEntregasCompletas() {
        // Logica para registrar entregas completas
    }

    public boolean verificarDisponibilidad() {
        // Logica para verificar disponibilidad
        return this.disponible;
    }

    public void actualizarEstadoPaquetes() {
        // Logica para actualizar el estado de los paquetes
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarSesion'");
    }

}
