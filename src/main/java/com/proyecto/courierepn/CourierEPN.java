package com.proyecto.courierepn;

import BL.BASEDEDATOS.DataHelper;
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
        String sql = "SELECT * FROM prueba";

        try {
            ResultSet rs = DataHelper.getInstancia().getResultSet(sql);
            
            while(rs.next()){
                JOptionPane.showMessageDialog(null, rs.getInt("id") + " " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }
}
