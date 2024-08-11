package BL.Administracion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;

public class GestorPerfiles {

    private static final String DB_NAME = "perfiles.db";
    private static final String DB_PATH = "src" + File.separator + "main" + File.separator + "java" + File.separator + "BL" + File.separator + "BD";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH + File.separator + DB_NAME;
    private static GestorPerfiles instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private GestorPerfiles() {
        try {
            // Ensure the directory exists
            File dbDirectory = new File(DB_PATH);
            if (!dbDirectory.exists()) {
                dbDirectory.mkdirs();
            }
            
            connection = DriverManager.getConnection(DB_URL);
            initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Public method to get the singleton instance
    public static synchronized GestorPerfiles getInstance() {
        if (instance == null) {
            instance = new GestorPerfiles();
        }
        return instance;
    }

    private void initializeDatabase() {
        try (Statement stmt = connection.createStatement()) {
            // Create Perfiles table
            stmt.execute("CREATE TABLE IF NOT EXISTS Perfiles (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "nombre TEXT NOT NULL," +
                         "apellido TEXT NOT NULL," +
                         "cedula TEXT UNIQUE NOT NULL," +
                         "email TEXT," +
                         "contrasena TEXT NOT NULL," +
                         "agencia TEXT," +
                         "tipo TEXT NOT NULL)");

            // Check if default Recepcionista exists
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Perfiles WHERE nombre = 'Admin' AND tipo = 'Recepcionista'");
            if (rs.next() && rs.getInt(1) == 0) {
                // Insert default Recepcionista
                String sql = "INSERT INTO Perfiles (nombre, apellido, cedula, email, contrasena, agencia, tipo) " +
                             "VALUES ('Admin', 'Admin', 'ADMIN001', 'admin@example.com', '123', 'Quito', 'Recepcionista')";
                stmt.execute(sql);
                System.out.println("Default Recepcionista (Admin) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para registrar un perfil
    public void registrarPerfil(Perfil nuevoPerfil) {
        String sql = "INSERT INTO Perfiles (nombre, apellido, cedula, email, contrasena, agencia, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nuevoPerfil.getNombre());
            pstmt.setString(2, nuevoPerfil.getApellido());
            pstmt.setString(3, nuevoPerfil.getCedula());
            pstmt.setString(4, nuevoPerfil.getCorreo());
            pstmt.setString(5, nuevoPerfil.getContrasena());
            pstmt.setString(6, nuevoPerfil instanceof Recepcionista ? ((Recepcionista) nuevoPerfil).getSucursal() : null);
            pstmt.setString(7, nuevoPerfil.getClass().getSimpleName());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("El perfil ya existe.");
            } else {
                e.printStackTrace();
            }
        }
    }

    // Método para realizar login
    public Perfil login(String nombre, String contrasena, String agencia, String rol) {
        String sql;
        if (rol.equals("Recepcionista")) {
            sql = "SELECT * FROM Perfiles WHERE nombre = ? AND contrasena = ? AND agencia = ? AND tipo = ?";
        } else {
            sql = "SELECT * FROM Perfiles WHERE nombre = ? AND contrasena = ? AND tipo = ?";
        }
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            if (rol.equals("Recepcionista")) {
                pstmt.setString(3, agencia);
                pstmt.setString(4, rol);
            } else {
                pstmt.setString(3, rol);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return createPerfilFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    // ... (other methods remain the same)

    private Perfil createPerfilFromResultSet(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String cedula = rs.getString("cedula");
        String email = rs.getString("email");
        String contrasena = rs.getString("contrasena");
        String agencia = rs.getString("agencia");

        switch (tipo) {
            case "Cliente":
                return new Cliente(nombre, apellido, cedula, email, contrasena);
            case "Recepcionista":
                return new Recepcionista(nombre, apellido, cedula, email, contrasena, agencia);
            case "Transportista":
                return new Transportista(nombre, apellido, cedula, email, contrasena);
            default:
                throw new IllegalArgumentException("Tipo de perfil desconocido: " + tipo);
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GestorPerfiles gestor = GestorPerfiles.getInstance();

        // Test login with default Recepcionista
        Perfil adminPerfil = gestor.login("Admin", "123", "Quito", "Recepcionista");
        if (adminPerfil != null) {
            System.out.println("Login exitoso para Admin: " + adminPerfil.getClass().getSimpleName());
        } else {
            System.out.println("Login fallido para Admin");
        }

        // Test login for a non-Recepcionista user
        Perfil clientePerfil = gestor.login("ClienteTest", "password", null, "Cliente");
        if (clientePerfil != null) {
            System.out.println("Login exitoso para Cliente: " + clientePerfil.getClass().getSimpleName());
        } else {
            System.out.println("Login fallido para Cliente");
        }

        // Close the connection when done
        gestor.closeConnection();
    }
}