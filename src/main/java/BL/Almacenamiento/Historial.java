package BL.Almacenamiento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

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

    public void registrarRegistro(Registro registro){
        //Guardar en la base
        guardarRegistro(registro);
        //Guardar en la lista de registros
        //Si no hay nigun registro, se crea uno nuevo
        if (!registros.containsKey(registro.getIdPaquete())) {
            registros.put(registro.getIdPaquete(), new ArrayList<>());
        }
        //Si lo hubiera, se lo apila a los demas registros
        registros.get(registro.getIdPaquete()).add(registro);
    }

    private void guardarRegistro(Registro registro) {
        int rs = -1;
        String sql = "INSERT INTO Registro(fecha, hora, sucursal, idPaquete, tipo) VALUES('"+
        registro.getFecha() + "', '" + registro.getHora() + "', '" + registro.getSucursal() + "',' " +
        registro.getIdPaquete() + "', '" + registro.getTipo() +"';";
        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Método que consulta todo el historial de la bodega, indicando de cada paquete
    public void consultar(){
    }

    //Método que muestra el historial de todos los paquete recibidos o ingresados a la bodega
    public void consultarIngresos(){
    }

    //Método que muestra el historial de todos los paquete enviados o que salieron de la bodega
    public void consultarSalidas(){
    }

    public void filtrarHistorial(String fecha){
        //Algoritmo para mostrar los registros segun la fecha
    }
}
