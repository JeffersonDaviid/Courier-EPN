package BL.Administracion;

import UI.Administracion.VentanaPrincipal;
import javax.swing.JFrame;


public class Transportista extends Perfil {
    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;
    boolean disponible;

    public Transportista(String cedula, String correo, String pass, String nombre, String apellido, boolean disponible) {
        super(cedula, correo, pass, nombre, apellido);
        this.disponible = disponible;
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
    
    
}

