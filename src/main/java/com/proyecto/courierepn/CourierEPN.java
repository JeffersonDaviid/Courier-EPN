package com.proyecto.courierepn;

import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Factura;
import BL.Facturacion.TarifaDomicilio;
import BL.Facturacion.TarifaEnvio;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TOMMY
 */
public class CourierEPN {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        probarFacturacion();
        String sql = "SELECT * FROM prueba";

        try {
            ResultSet rs = DataHelper.getInstancia().getResultSet(sql);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, rs.getInt("id") + " " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }

    public static void probarFacturacion() {
        Factura.obtenerFactura(1);

        TarifaEnvio envio = new TarifaEnvio();
        envio.calcularPrecioEnvio();

    }
}
