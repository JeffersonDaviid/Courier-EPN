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
import javax.swing.table.DefaultTableModel;

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

    public DefaultTableModel consultarUsuario(String cedula) {
        String[] columnas = {"Cédula", "Correo", "Contraseña", "Nombre", "Apellido"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        ResultSet rsUsuario = null;
        String sql = String.format("SELECT cedula, correo, contrasena, nombre, apellido FROM Usuarios WHERE cedula = '%s'", cedula);

        try {
            rsUsuario = DataHelper.getInstancia().executeQueryRead(sql);
            if (rsUsuario.next()) {
                Object[] fila = new Object[columnas.length];

                // Populate data from the result set
                fila[0] = rsUsuario.getString("cedula");
                fila[1] = rsUsuario.getString("correo");
                fila[2] = rsUsuario.getString("contrasena");
                fila[3] = rsUsuario.getString("nombre");
                fila[4] = rsUsuario.getString("apellido");
                model.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el usuario: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources to prevent resource leaks
            try {
                if (rsUsuario != null) {
                    rsUsuario.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + ex.toString());
            }
        }
        return model;
    }

    /*public DefaultTableModel mostrarPaquetes() {
        String[] columnas = {"ID Paquete", "Origen Paquete", "Destino Paquete", "Fecha de Ingreso", "Hora Ingreso", "Fecha Limite"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        ResultSet rsPaquete = null, rsFecha = null;

        for (int idPaquete : idPaquetes) {
            String sql_paquete = "SELECT idPaquete, sucursalAceptoPaquete, sucursalParaRecoger FROM Paquetes WHERE idPaquete = '" + idPaquete + "'";
            String sql_fecha = "SELECT fecha, hora FROM Registros WHERE idPaquete = '" + idPaquete + "'";

            try {
                rsPaquete = DataHelper.getInstancia().executeQueryRead(sql_paquete);
                rsFecha = DataHelper.getInstancia().executeQueryRead(sql_fecha);

                if (rsPaquete.next() && rsFecha.next()) {
                    Object[] fila = new Object[columnas.length];

                    // Populate data from the first query
                    fila[0] = rsPaquete.getString("idPaquete");
                    fila[1] = rsPaquete.getString("sucursalAceptoPaquete");
                    fila[2] = rsPaquete.getString("sucursalParaRecoger");

                    // Populate data from the second query
                    fila[3] = rsFecha.getString("fecha");
                    fila[4] = rsFecha.getString("hora");
                    fila[5] = calcularFechaLimite(rsFecha.getString("fecha"));

                    model.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + ex.toString());
            } finally {
                // Close resources to prevent resource leaks
                try {
                    if (rsPaquete != null) {
                        rsPaquete.close();
                    }
                    if (rsFecha != null) {
                        rsFecha.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.toString());
                }
            }
        }

        return model;
    }*/
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
