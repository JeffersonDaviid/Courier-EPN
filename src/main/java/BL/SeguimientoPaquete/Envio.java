package BL.SeguimientoPaquete;

import BL.GestionPaquete.Paquete;
import BL.BASEDEDATOS.DataHelper;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;

public class Envio {
    private int id;
    private List<Paquete> paquetes;
    public Envio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public void guardarEnvio(int idPaquete) {
        DataHelper dataHelper;
        try {
            dataHelper = DataHelper.getInstancia();
            String sql = "INSERT INTO Envio (idPaquete) VALUES (" + idPaquete + ")";
            int result = dataHelper.executeQueryInsertUpdateDelete(sql);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Envio guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el envio");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el envio: " + e.getMessage());
        }
    }
     public void actualizarEstadoPaquete(int idPaquete, String estado) {
        DataHelper dataHelper;
        try {
            dataHelper = DataHelper.getInstancia();
            String sql = "UPDATE PAQUETES SET estado = '" + estado + "' WHERE idPaquete = " + idPaquete;
            int result = dataHelper.executeQueryInsertUpdateDelete(sql);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Estado del paquete actualizado a " + estado);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado del paquete");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del paquete: " + e.getMessage());
        }
    }
      public int obtenerIdPaquete(String criterio) {
        DataHelper dataHelper;
        int idPaquete = -1;
        try {
            dataHelper = DataHelper.getInstancia();
            String sql = "SELECT idPaquete FROM PAQUETES WHERE estado = '" + criterio + "'";
            ResultSet rs = dataHelper.executeQueryRead(sql);
            if (rs.next()) {
                idPaquete = rs.getInt("idPaquete");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el id del paquete: " + e.getMessage());
        }
        return idPaquete;
    }
    
}
