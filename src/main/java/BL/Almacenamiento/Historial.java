package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class Historial {
    private ArrayList<Registro> registros;

    public Historial() {
        registros = new ArrayList<>();
    }

    //Método que guarda los registros de ingreso y salida de cada Paquete
    public void registrarRegistro(Registro registro) {
        registros.add(registro);
        guardarRegistroEnBD(registro);        //guardar en la base
    }

    //Método para guardar el registro de ingreso en la base de datos
    private void guardarRegistroEnBD(Registro registro) {
        String sql = "INSERT INTO Registros (idPaquete, fechaIngreso, fechaSalida, sucursal) VALUES ("
            + registro.getIdPaquete() + ", '" + registro.getFechaIngreso() + "', '" + registro.getFechaSalida() + "', '"
            + registro.getSucursal() + "')";
        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo que muestra el historial de ingresos y salidas del dia que se lo llame
    public void consultarHoy() {
        for (Registro registro: registros) {
            System.out.println("\n" + registro.toString());
        }
    }

    //Metodo que busca un registro expecifico en toda la lista
    public Registro getRegistro(String idPaquete) {
        for (Registro registro : registros) {
            if (registro.getIdPaquete().equals(idPaquete)) {
                return registro;
            }
        }
        System.out.println("Registro no encontrado");
        return null;
    }

    //Metodo que filtra el hitorial segun un parametro de busqueda
    public void filtrarHistorial(String parametro){
        // id
        filtrarPorId(parametro);
        // fecha de ingreso
        filtrarPorFechaIngreso(parametro);
        // fecha de salida
        filtrarPorFechaSalida(parametro);
    }

    public void filtrarPorId(String idPaquete){
        String sql = "SELECT * FROM Registros WHERE idPaquete = " + idPaquete;
        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {

                //Se crea el objeto y se lo coloca en el hashmap
            } 
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }

    public void filtrarPorFechaSalida(String fechaSalida){
        String sql = "SELECT * FROM Registros WHERE DATE(fechaSalida) = '"+ fechaSalida +"';";
        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {

                //Se crea el objeto y se lo coloca en el hashmap
            } 
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }

    public void filtrarPorFechaIngreso(String fechaIngreso){
        String sql = "SELECT * FROM Registros WHERE DATE(fechaIngreso) = '"+ fechaIngreso +"';";
        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {

                //Se crea el objeto y se lo coloca en el hashmap
            } 
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }

    //Método que actualiza la fecha de salida de un registro
    public void actualizarFechaDeSalida(String id, String fechaSalida) {
        getRegistro(id).setFechaSalida(fechaSalida);;
        guadarFechaSalida(id,fechaSalida);                  //Guardar en la base
    }

    //Método que actualiza la fecha de salida de un paquete del inventario
    private void guadarFechaSalida(String id, String fechaDeSalida) {
        String sql = "UPDATE Registros SET fechaSalida = '" + fechaDeSalida + "' WHERE idPaquete = "+id+";";
        try {
            int rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
