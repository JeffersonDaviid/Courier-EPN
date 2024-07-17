package BL.Administracion;

import UI.Administracion.VentanaPrincipal;
import javax.swing.JFrame;

public class Administrador extends Perfil {

    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;

    public Administrador(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);
    }

    @Override
    public void cerrarSesion() {
        // Logica especifica de administrador
        super.cerrarSesion();
    }

    public void registrarEmpleado() {
        // Logica para registrar empleado
    }

    public void consultarEmpleado() {
        // Logica para consultar empleado
    }

    public void actualizarEmpleado() {
        // Logica para modificar empleado
    }
    
    public void darDeBajaEmpleado() {
        // Logica para modificar empleado
    }

    public void asignarChoferACamion() {
        // Logica para asignar chofer a camion
    }

    public void registrarCamion() {
        // Logica para registrar camion
    }

    public void eliminarCamion() {
        // Logica para eliminar camion
    }

    public void registrarRuta() {
        // Logica para registrar ruta
    }

    public void eliminarRuta() {
        // Logica para eliminar ruta
    }

    public void gestionarParametrosDeEnvio() {
        // Logica para gestionar parametros de envio
    }
    
    @Override
    public JFrame verModulos() {
        // Implementación específica para Cliente
        return new VentanaPrincipal(this);
    }

}
