package BL.Facturacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;

/**
 *
 * @author TOMMY
 */
public class Factura {
    private Precio precio;

    public Factura(Precio precio) {
        this.precio = precio;
    }

    public void generarFactura() {
        precio.calcularPrecioEnvio();

        guardarFactura();
    }

    private void guardarFactura() {

        String sql = "INSERT INTO FACTURA";

        try {
            ResultSet rs = DataHelper.getInstancia().getResultSet(sql);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
