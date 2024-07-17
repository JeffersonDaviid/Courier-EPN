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

    public void clasificarPaquete() {
        // Logica para clasificar paquetes
    }

    public void etiquetarPaquete() {
        // Logica para etiquetar paquetes
    }

    public void almacenarPaquete() {
        // Logica para almacenar paquetes
    }

    public void registrarTipoEntrega() {
        // Logica para registrar tipo de entrega
    }

    public void cargarPaquete() {
        // Logica para cargar paquetes
    }

    public void obtenerPaquete() {
        // Logica para obtener paquetes
    }

    public void descargarPaquete() {
        // Logica para descargar paquetes
    }

    public void buscarPaquetePorID() {
        // Logica para buscar paquetes por ID
    }
    
    @Override
    public JFrame verModulos(VentanaLogin login) {
        // Implementación específica para Cliente
        return new BodegueroMenuPrincipal(login, this);
    }

}
