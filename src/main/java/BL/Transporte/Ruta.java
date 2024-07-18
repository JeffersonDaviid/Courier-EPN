package BL.Transporte;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import BL.BASEDEDATOS.DataHelper;

public class Ruta {

    String sector;
    String direccion;

    public Ruta(String sector, String direccion) {
        this.sector = sector;
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void consultarRuta() {
        String sql = "SELECT * FROM Ruta";
        ResultSet rs = null;

        try {
            rs = DataHelper.getInstancia().executeQueryRead(sql);
            StringBuilder rutasInfo = new StringBuilder();

            rutasInfo.append("\n*************************************\n")
                     .append("         INFORMACION DE LAS RUTAS          \n")
                     .append("*************************************\n");

            while (rs.next()) {
                String sector = rs.getString("sector");
                String direccion = rs.getString("direccion");

                rutasInfo.append("Sector:       ").append(sector).append("\n")
                         .append("Direccion:    ").append(direccion).append("\n")
                         .append("*************************************\n");
            }

            System.out.println(rutasInfo.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar las rutas: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                DataHelper.getInstancia().closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void registrarRuta(Ruta ruta) {
        int rs = -1;
        String sql = "INSERT INTO Ruta (sector, direccion) VALUES ('"
            + ruta.getSector() + "', '" + ruta.getDireccion() + "')";

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
}
