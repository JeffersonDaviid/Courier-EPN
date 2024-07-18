package BL.SeguimientoPaquete;

import BL.BASEDEDATOS.DataHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Alex
 */
public class Seguimiento {
     Envio envios; 

    public Seguimiento() {
    }

    // Métodos
    // Getters y Setters según sea necesario
    public ResultSet obtenerDatosPaquete(String numeroGuia) {
        DataHelper dataHelper;
        ResultSet rs = null;
        try {
            dataHelper = DataHelper.getInstancia();
            String sql = "SELECT idPaquete, Origen, Destino, sucursalAceptoPaquete, sucursalParaRecoger, estado FROM Paquetes WHERE numeroGuia = '" + numeroGuia + "'";
            rs = dataHelper.executeQueryRead(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del paquete: " + e.getMessage());
        }
        return rs;
    }

}
