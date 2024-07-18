package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;

import java.util.List;


/**
 *
 * @author BugsBusters
 */
public class Historial {

    private Map<String, List<Registro>> registros;

    public Historial(){
        registros = new HashMap<>();
    }

    //Método que guarda los registros de ingreso y salida de cada Paquete
    public void registrarRegistro(Registro registro){
        guardarRegistro(registro);          //Guardar en la base
        //Guardar en la lista de registros - Si no hay nigun registro, se crea uno nuevo
        if (!registros.containsKey(registro.getIdPaquete())) {
            registros.put(registro.getIdPaquete(), new ArrayList<>());
        }
        //Si lo hubiera, se lo apila a los demas registros
        registros.get(registro.getIdPaquete()).add(registro);
    }

    //Método para guardar los registros de cada paquete en la base de datos
    private void guardarRegistro(Registro registro) {
        int rs = -1;
        String sql = "INSERT INTO Registros(idPaquete, fecha, hora, sucursal,tipo) VALUES("+Integer.parseInt(registro.getIdPaquete())+",'"+
        registro.getFecha()+"','"+registro.getHora()+"','"+registro.getSucursal()+"','"+registro.getTipo()+"')";
        System.out.println(sql);
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);
            if (!(rs > 0)) {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Método que consulta todo el historial de la bodega el dia que se lo ejecute
    public String[][] consultarHoy(){
        String[][] registrosDatos = new String[registros.size()][5];
        int i = 0;
        List<Registro> registro;
        for (String clave : registros.keySet()) {
            registro = registros.get(clave);
            registrosDatos[i][0] = registro.get(0).getIdPaquete();
            if(registro.size() == 2){
                registrosDatos[i][1] = registro.get(0).getFecha();
                registrosDatos[i][2] = registro.get(0).getHora();
                registrosDatos[i][3] = registro.get(1).getFecha();
                registrosDatos[i][4] = registro.get(1).getHora();
            }else{
                registrosDatos[i][1] = registro.get(0).getFecha();
                registrosDatos[i][2] = registro.get(0).getHora();
            }
            i++;
        }
        return registrosDatos;
    }


    public String[][] filtrarHistorial(String parametro){
        //-------------------------------------------------------
        //Si es un idPaquete
        String[][] datosFiltroId = filtrarPorId(parametro);
        //-------------------------------------------------------
        //Si es una fecha
        //String[][] datosFiltroFechaIngreso = filtarPorFechaIngreso(parametro);
        //String[][] datosFiltroFechaSalida = filtarPorFechaSalida(parametro);

        return datosFiltroId; 
        }

    public String[][] filtarPorFechaIngreso(String parametro) {
        String[][] datos = new String[1][5];
        String sql = "SELECT "+
                        "ingreso.idPaquete,\n"+
                        "ingreso.fecha AS fechaIngreso,\n"+
                        "ingreso.hora AS horaIngreso,\n"+
                        "COALESCE(salida.fecha, '') AS fechaSalida,\n"+
                        "COALESCE(salida.hora, '') AS horaSalida\n"+
                    "FROM Registros ingreso\n"+
                    "LEFT JOIN\n"+ 
                        "Registros salida\n"+
                    "ON\n"+ 
                        "ingreso.idPaquete = salida.idPaquete\n"+ 
                        "AND salida.tipo = 'SALIDA'\n"+
                    "WHERE\n"+ 
                        "ingreso.tipo = 'INGRESO'\n"+
                        "AND ingreso.fecha = '"+parametro+"'"+
                    "ORDER BY ingreso.idPaquete";
        try {
        DataHelper dataHelper = DataHelper.getInstancia();
        ResultSet rs = dataHelper.executeQueryRead(sql);

        if (rs.next()) {
            String idPaquete = rs.getString("idPaquete");
            String fechaIngreso = rs.getString("fechaIngreso");
            String horaIngreso = rs.getString("horaIngreso");
            String fechaSalida = rs.getString("fechaSalida");
            String horaSalida = rs.getString("horaSalida");
            datos[0][0] = idPaquete;
            datos[0][1] = fechaIngreso;
            datos[0][2] = horaIngreso;
            datos[0][3] = fechaSalida;
            datos[0][4] = horaSalida;
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public String[][] filtarPorFechaSalida(String parametro) {
        String[][] datos = new String[1][5];
        String sql = "SELECT " +
                        "ingreso.idPaquete, \n" +
                        "ingreso.fecha AS fechaIngreso, \n"+
                        "ingreso.hora AS horaIngreso, \n"+
                        "COALESCE(salida.fecha, '') AS fechaSalida,\n"+
                        "COALESCE(salida.hora, '') AS horaSalida \n"+
                    "FROM Registros ingreso \n" +
                    "LEFT JOIN \n " +
                        "Registros salida \n" +
                    "ON \n"+
                        "ingreso.idPaquete = salida.idPaquete \n"+
                        "AND salida.tipo = 'SALIDA'\n"+
                    "WHERE \n"+
                        "ingreso.tipo = 'INGRESO'\n"+
                        "AND salida.fecha = '"+parametro+"'"+
                    "ORDER BY \n" +
                        "ingreso.idPaquete";

        try {
        DataHelper dataHelper = DataHelper.getInstancia();
        ResultSet rs = dataHelper.executeQueryRead(sql);

        if (rs.next()) {
            String idPaquete = rs.getString("idPaquete");
            String fechaIngreso = rs.getString("fechaIngreso");
            String horaIngreso = rs.getString("horaIngreso");
            String fechaSalida = rs.getString("fechaSalida");
            String horaSalida = rs.getString("horaSalida");
            datos[0][0] = idPaquete;
            datos[0][1] = fechaIngreso;
            datos[0][2] = horaIngreso;
            datos[0][3] = fechaSalida;
            datos[0][4] = horaSalida;
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public String[][] filtrarPorId(String parametro) {
        System.out.println("Entro al metodo  + " + parametro);
        String[][] datosFiltroId = new String[1][5];
        String sql = "SELECT idPaquete, fecha, hora, tipo FROM Registros WHERE idPaquete = "+parametro;
        System.out.println(sql);
        ResultSet rs = null;
        try {
        rs = DataHelper.getInstancia().executeQueryRead(sql);
        if (rs.next()) {
            String fecha = rs.getString("fecha");
            String hora = rs.getString("hora");
            String tipo = rs.getString("tipo");
            datosFiltroId[0][0] = parametro;
            if(tipo == "INGRESO"){
                datosFiltroId[0][1] = fecha;
                datosFiltroId[0][2] = hora;
            }else{
                datosFiltroId[0][3] = fecha;
                datosFiltroId[0][4] = fecha;
            }
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datosFiltroId;
    }

   /* public DefaultTableModel mostrarPaquetes(String[][] dato) {
        String columnas = {"idPaquete", "Fecha Ingreso", "Hora Ingreso", "Fecha Salida"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        
        for (String columna : columnas) {
            model.addColumn(columna);
        }
        
        for(String[] fila: dato){
            model.addRow(fila);
        }

    }*/
}
