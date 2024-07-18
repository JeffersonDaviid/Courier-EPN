package com.proyecto.courierepn;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import UI.Administracion.VentanaLogin;

/**
 *
 * @author TOMMY
 */
public class CourierEPN {

    public static void main(String[] args) {

        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);

    }

    public static void ejemploConsultaBaseDatos() {
        String sql = "SELECT * FROM prueba";

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, rs.getInt("id") + " " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }

}
