package BL.Administracion;

import java.sql.ResultSet;

//import UI.Administracion.VentanaPrincipal;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.Transporte.Ruta;
import BL.Transporte.Vehiculo;
import UI.Administracion.AdminMenuPrincipal;
import UI.Administracion.VentanaLogin;

public class Administrador extends Perfil {

    String cedula;
    String correo;
    String pass;
    String nombre;
    String apellido;
    char rol;

    public Administrador(String cedula, String correo, String pass, String nombre, String apellido) {
        super(cedula, correo, pass, nombre, apellido);
    }


    public void registrarUsuario(Perfil perfil) {
        int rs = -1;

        String sql = "INSERT INTO Usuarios (cedula, correo, contrasena, nombre, apellido, rol) VALUES ('"
                + perfil.getCedula() + "', '" + perfil.getCorreo() + "', '" + perfil.getPass() + "', '" + perfil.getNombre() 
                + "', '" + perfil.getApellido() + "', '" + perfil.getClass().getSimpleName() + "')";
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarUsuario(String cedula) {
        Perfil perfil = null;
        String sql = String.format("SELECT * FROM Usuarios WHERE cedula = %s", cedula);

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);
            while (rs.next()) {
                perfil = PerfilFactory.crearPerfil(rs.getString("rol"),
                        rs.getString("cedula"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("nombre"),
                        rs.getString("apellido"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (perfil != null) {
            System.out.println("Cédula: " + perfil.getCedula());
            System.out.println("Correo: " + perfil.getCorreo());
            System.out.println("Contraseña: " + perfil.getPass());
            System.out.println("Nombre: " + perfil.getNombre());
            System.out.println("Apellido: " + perfil.getApellido());
        }
    }

    public void actualizarEmpleado() {
        // Logica para modificar empleado
    }

    public void asignarChoferACamion(Transportista transportista, Vehiculo camion) {
        transportista.setCamion(camion);
    }

    public void registrarCamion(Vehiculo camion) {
        int rs = -1;

        String sql = "INSERT INTO ";
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Camión registrado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el camión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el camión: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarRuta(Ruta ruta) {
        int rs = -1;

        String sql = "INSERT INTO ";
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Ruta registrada con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la ruta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la ruta: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public JFrame verModulos(VentanaLogin login) {
        return new AdminMenuPrincipal(login, this);
    }
    
    @Override
    public void cerrarSesion(VentanaLogin login) {
        login.setVisible(true);
    }
}


