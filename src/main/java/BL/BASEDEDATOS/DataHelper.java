package BL.BASEDEDATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataHelper {
    private static DataHelper dh;
    private Connection conexion;
    private static final String URLDB = "jdbc:sqlite:courier.db";

    private DataHelper() throws SQLException {
        try {
            this.conexion = DriverManager.getConnection(URLDB);
            Statement stmt = conexion.createStatement();
            stmt.execute("PRAGMA foreign_keys = ON");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos." + ex);
        }
    }

    public static DataHelper getInstancia() throws SQLException {
        if (dh == null || dh.conexion.isClosed()) {
            dh = new DataHelper();
        }  
        return dh;
    }

    /***
     * Método ESTÁTICO que realiza una petición a la base de datos
     * 
     * @param sql : es la petición a la Base de Datos
     * @return : retorna la respuesta de la Base de Datos, objeto de tipo ResultSet
     * @throws SQLException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getResultSet(String sql) throws SQLException {
        Statement stmt;
        ResultSet rs = null;

        try {
            stmt = conexion.createStatement(); // CRUD : select * ...
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener respuesta en : getResultSet(String sql) " + e.getMessage());
        }
        return rs;
    }

    public void closeConnection() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
