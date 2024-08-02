package BL.Administracion;

import javax.swing.JOptionPane;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasena, String agencia) {
        super(nombre, contrasena, agencia);
    }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario() {
        // Solicitar datos del nuevo usuario usando JOptionPane
        String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo usuario:");
        String nuevaContrasena = JOptionPane.showInputDialog(null, "Ingrese la contraseña del nuevo usuario:");
        String nuevaAgencia = JOptionPane.showInputDialog(null, "Ingrese la agencia del nuevo usuario:");
        String nuevoRol = JOptionPane.showInputDialog(null, "Ingrese el rol del nuevo usuario (Administrador o Recepcionista):");

        // Crear y agregar el nuevo usuario
        Usuario nuevoUsuario;
        if (nuevoRol.equalsIgnoreCase("Administrador")) {
            nuevoUsuario = new Administrador(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else if (nuevoRol.equalsIgnoreCase("Recepcionista")) {
            nuevoUsuario = new Recepcionista(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else {
            JOptionPane.showMessageDialog(null, "Rol desconocido. No se pudo agregar el usuario.");
            return;
        }

        GlobalPerfil.getInstancia().agregarUsuario(nuevoUsuario);
        JOptionPane.showMessageDialog(null, "Nuevo usuario agregado exitosamente: " + nuevoUsuario.getNombre());
    }
}
