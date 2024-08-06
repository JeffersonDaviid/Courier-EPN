package BL.Administracion;

import javax.swing.JOptionPane;

import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasena, String agencia) {
        super(nombre, contrasena, agencia);
    }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario(String nuevaAgencia, String nuevoNombre, String nuevaContrasena, String nuevoRol) {
        //String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo usuario:");
        //String nuevaContrasena = JOptionPane.showInputDialog(null, "Ingrese la contraseña del nuevo usuario:");
        //String nuevaAgencia = JOptionPane.showInputDialog(null, "Ingrese la agencia del nuevo usuario:");
        //String nuevoRol = JOptionPane.showInputDialog(null,
        //        "Ingrese el rol del nuevo usuario (Administrador, Recepcionista, Bodeguero o Transportista):");
        if(nuevoNombre == null || nuevaContrasena == null || nuevaAgencia == null || nuevoRol == null || nuevoNombre.equals("") || nuevaContrasena.equals("") || nuevaAgencia.equals("") || nuevoRol.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario. Verificar entradas.");
            return;
        }
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
    }

    // Método para agregar un nuevo camión
    public void agregarCamionCarga(String placa, String modelo, String marca, String capacidadCargaStr, String disponibilidadStr) {
        // String placa = JOptionPane.showInputDialog("Ingrese la placa:").trim();
        // String modelo = JOptionPane.showInputDialog("Ingrese el modelo:").trim();
        // String marca = JOptionPane.showInputDialog("Ingrese la marca:").trim();
        int capacidadCarga = 0;
        int disponibilidad = 0;

        if(placa == null || modelo == null || marca == null || capacidadCargaStr == null || disponibilidadStr == null || placa.equals("") || modelo.equals("") || marca.equals("") || capacidadCargaStr.equals("") || disponibilidadStr.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el camión. Verificar entradas.");
            return;
        }

        try {
            capacidadCarga = Integer.parseInt(capacidadCargaStr);
            disponibilidad = Integer.parseInt(disponibilidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Capacidad de carga y disponibilidad deben ser números.");
            return;
        }
        CamionCarga nuevoCamion = new CamionCarga(placa, modelo, marca, capacidadCarga, disponibilidad,
                Global.agenciaActual);
        Global.getInstancia().buscarAgencia(Global.agenciaActual).agregarCamionCarga(nuevoCamion);
        JOptionPane.showMessageDialog(null, "Camión de carga agregado exitosamente.");
    }

    // Método para agregar un nuevo camión
    public void agregarCamionEntrega(String placa, String modelo, String marca, String capacidadCargaStr, String disponibilidadStr) {
        // String placa = JOptionPane.showInputDialog("Ingrese la placa:").trim();
        // String modelo = JOptionPane.showInputDialog("Ingrese el modelo:").trim();
        // String marca = JOptionPane.showInputDialog("Ingrese la marca:").trim();
        int capacidadCarga = 0;
        int disponibilidad = 0;

        if(placa == null || modelo == null || marca == null || capacidadCargaStr == null || disponibilidadStr == null || placa.equals("") || modelo.equals("") || marca.equals("") || capacidadCargaStr.equals("") || disponibilidadStr.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el camión. Verificar entradas.");
            return;
        }

        try {
            capacidadCarga = Integer.parseInt(capacidadCargaStr);
            disponibilidad = Integer.parseInt(disponibilidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Capacidad de carga y disponibilidad deben ser números.");
            return;
        }

        CamionEntrega nuevoCamion = new CamionEntrega(placa, modelo, marca, capacidadCarga,
                disponibilidad, Global.agenciaActual);
        Global.getInstancia().buscarAgencia(Global.agenciaActual).agregarCamionEntrega(nuevoCamion);
        JOptionPane.showMessageDialog(null, "Camión de entrega agregado exitosamente.");
    }
}
