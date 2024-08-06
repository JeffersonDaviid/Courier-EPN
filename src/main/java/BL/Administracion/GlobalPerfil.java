package BL.Administracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;

public class GlobalPerfil {

    private static GlobalPerfil instancia;
    private static ArrayList<Usuario> perfiles = new ArrayList<Usuario>();
    public static String rol;
    // private static Perfil perfilActual; //COMPLICADO DE IMPLEMENTAR

    private GlobalPerfil() {
        cargarPerfiles();
    }

    public static GlobalPerfil getInstancia() {
        if (instancia == null) {
            instancia = new GlobalPerfil();
        }
        return instancia;
    }

    public void cargarPerfiles() {
        Administrador perfil1 = new Administrador("Damaris", "123", "Quito");
        Recepcionista perfil2 = new Recepcionista("Juan", "123", "Guayaquil");
        Bodeguero perfil3 = new Bodeguero("Pedro", "123", "Cuenca");
        Transportista perfil4 = new Transportista("Maria", "123", "Quito");

        perfiles.add(perfil1);
        perfiles.add(perfil2);
        perfiles.add(perfil3);
        perfiles.add(perfil4);
    }

    // Nuevo método para agregar usuarios
    public void agregarUsuario(Usuario nuevoUsuario) {
        if (!usuarioExistente(nuevoUsuario.getNombre())) {
            perfiles.add(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Nuevo usuario agregado exitosamente: " + nuevoUsuario.getNombre());
        } else
            JOptionPane.showMessageDialog(null, "El usuario ya existe.");
    }

    public Usuario loginPerfil(String nombre, String contrasena, String rol, String agencia) {
        for (Usuario perfil : perfiles) {
            // JOptionPane.showMessageDialog(null, "Perfil: " + perfil.getNombre() + " " +
            // perfil.getContrasena() + " " + perfil.getClass().toString());
            // JOptionPane.showMessageDialog(null, "Datos: " + nombre + " " + contrasena + "
            // " + rol);
            if (perfil.getNombre().equals(nombre) && perfil.getContrasena().equals(contrasena)
                    && perfil.getClass().toString().equals("class BL.Administracion." + rol)
                    && perfil.getAgencia().equals(rol)) {
                return perfil;
            }
        }
        return null;
    }

    public void guardarPerfiles() {
        try {
            FileWriter writer = new FileWriter("perfiles.txt");
            for (Usuario perfil : perfiles) {
                writer.write(perfil.toString() + "\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Perfiles guardados exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los perfiles.");
            e.printStackTrace();
        }
    }

    public void leerPerfiles() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("perfiles.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and create a new Usuario object
                // Add the Usuario object to the perfiles list
            }
            reader.close();
            JOptionPane.showMessageDialog(null, "Perfiles cargados exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los perfiles.");
            e.printStackTrace();
        }
    }

    private boolean usuarioExistente(String usuario) {
        for (Usuario perfil : perfiles) {
            if (perfil.getNombre().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

}