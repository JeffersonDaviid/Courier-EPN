package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
        Recepcionista perfil3 = new Recepcionista("Pedro", "123", "Cuenca");

        perfiles.add(perfil1);
        perfiles.add(perfil2);
        perfiles.add(perfil3);
    }
       // Nuevo método para agregar usuarios
       public void agregarUsuario(Usuario nuevoUsuario) {
        perfiles.add(nuevoUsuario);
    }

    public Usuario loginPerfil(String nombre, String contrasena, String rol) {
        for (Usuario perfil : perfiles) {
            JOptionPane.showMessageDialog(null, "Perfil: " + perfil.getNombre() + " " + perfil.getContrasena() + " " + perfil.getClass().toString());
            JOptionPane.showMessageDialog(null, "Datos: " + nombre + " " + contrasena + " " + rol);
            if (perfil.getNombre().equals(nombre) && perfil.getContrasena().equals(contrasena) && perfil.getClass().toString().equals("class BL.Administracion."+rol)) {
                return perfil;
            }
        }
        return null;
    }

}