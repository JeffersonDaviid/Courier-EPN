package BL.Administracion;


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

    @Override
    public boolean ingresarSistema(String usuario, String pass) {
        // Logica especifica del transportista para ingresar al sistema
        return super.ingresarSistema(usuario, pass);
    }

    @Override
    public void cerrarSesion() {
        // Logica especifica del transportista para cerrar sesión
        super.cerrarSesion();
    }
}

