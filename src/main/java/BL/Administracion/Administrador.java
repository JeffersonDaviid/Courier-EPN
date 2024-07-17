package BL.Administracion;

//import UI.Administracion.VentanaPrincipal;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;

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


    public void registrarEmpleado(Perfil perfil) {
        int rs = -1;

        String sql = "INSERT INTO Usuarios (cedula, correo, contrasena, nombre, apellido, rol) VALUES ("
                + perfil.getCedula() + ", " + perfil.getCorreo() + ", '" + perfil.getPass() + "', " + perfil.getNombre() + ", " + perfil.getApellido() + ", "
                + perfil.getClass().getSimpleName() + "')";
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Factura guardada con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
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
        return new JFrame();
    }

    public static void main(String[] args) {
        Administrador admin = new Administrador("123456789", "N/A", "1234", "Admin", "Admin");
        System.out.println(admin.getClass().getSimpleName());
    }

}


