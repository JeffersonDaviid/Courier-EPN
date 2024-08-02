package BL.Administracion;

import javax.swing.JOptionPane;

import BL.Agencia.Global;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasena, String agencia) {
        super(nombre, contrasena, agencia);
    }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario() {
        String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo usuario:");
        String nuevaContrasena = JOptionPane.showInputDialog(null, "Ingrese la contraseña del nuevo usuario:");
        String nuevaAgencia = JOptionPane.showInputDialog(null, "Ingrese la agencia del nuevo usuario:");
        String nuevoRol = JOptionPane.showInputDialog(null,
                "Ingrese el rol del nuevo usuario (Administrador, Recepcionista, Bodeguero o Transportista):");

        Usuario nuevoUsuario;
        if (nuevoRol.equalsIgnoreCase("Administrador")) {
            nuevoUsuario = new Administrador(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else if (nuevoRol.equalsIgnoreCase("Recepcionista")) {
            nuevoUsuario = new Recepcionista(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else if (nuevoRol.equalsIgnoreCase("Bodeguero")) {
            nuevoUsuario = new Bodeguero(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else if (nuevoRol.equalsIgnoreCase("Transportista")) {
            nuevoUsuario = new Transportista(nuevoNombre, nuevaContrasena, nuevaAgencia);
        } else {
            JOptionPane.showMessageDialog(null, "Rol desconocido. No se pudo agregar el usuario.");
            return;
        }

        GlobalPerfil.getInstancia().agregarUsuario(nuevoUsuario);
        JOptionPane.showMessageDialog(null, "Nuevo usuario agregado exitosamente: " + nuevoUsuario.getNombre());
    }

    // Método para agregar un nuevo camión
    public void agregarCamion() {
        String tipoCamion = JOptionPane.showInputDialog("Ingrese el tipo de camión (carga/entrega):").trim();
        String placa = JOptionPane.showInputDialog("Ingrese la placa:").trim();
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:").trim();
        String marca = JOptionPane.showInputDialog("Ingrese la marca:").trim();
        int capacidadCarga = 0;
        int disponibilidad = 0;

        try {
            capacidadCarga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga:").trim());
            disponibilidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la disponibilidad:").trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Capacidad de carga y disponibilidad deben ser números.");
            return;
        }

        if (tipoCamion.equalsIgnoreCase("carga")) {
            CamionCarga nuevoCamion = new CamionCarga(tipoCamion, placa, modelo, marca, capacidadCarga, disponibilidad,
                    Global.agenciaActual);
            Global.getInstancia().buscarAgencia(Global.agenciaActual).agregarCamionCarga(nuevoCamion);
            JOptionPane.showMessageDialog(null, "Camión de carga agregado exitosamente.");
        } else if (tipoCamion.equalsIgnoreCase("entrega")) {
            CamionEntrega nuevoCamion = new CamionEntrega(tipoCamion, placa, modelo, marca, capacidadCarga,
                    disponibilidad, Global.agenciaActual);
            Global.getInstancia().buscarAgencia(Global.agenciaActual).agregarCamionEntrega(nuevoCamion);
            JOptionPane.showMessageDialog(null, "Camión de entrega agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de camión no reconocido.");
        }
    }
}
