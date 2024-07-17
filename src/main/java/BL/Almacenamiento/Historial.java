package BL.Almacenamiento;

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
    public ArrayList<String[]> consultarHoy(){
        //Dataframe de todos los dato de registro
        //Id - fecha ingreso - hora ingreso - fecha salida - hora salida
        ArrayList<String[]> datosRegistros = new ArrayList<>();
        String[] registroDatos = new String[5];
        int i = 0;
        List<Registro> registro;
        for (String clave : registros.keySet()) {
            registro = registros.get(clave);

            registroDatos[0] = registro.get(0).getIdPaquete();

            if(registro.size() == 2){
                registroDatos[1] = registro.get(0).getFecha();
                registroDatos[2] = registro.get(0).getHora();
                registroDatos[3] = registro.get(1).getFecha();
                registroDatos[4] = registro.get(1).getHora();
            }else{
                registroDatos[1] = registro.get(0).getFecha();
                registroDatos[2] = registro.get(0).getHora();
            }
            i++;
            datosRegistros.add(registroDatos);
        }
        return datosRegistros;
    }

    public void filtrarHistorial(String parametro){
        //Algoritmo para mostrar los registros segun el parametro
        //Consulta a la base
    }

    public void mostrarRegistros() {
        System.out.println(registros.size());
        for (Map.Entry<String, List<Registro>> entry : registros.entrySet()) {
            String clave = entry.getKey();
            List<Registro> lista = entry.getValue();

            System.out.println("Clave: " + clave);

            for (Registro registro : lista) {
                System.out.println("\t" + registro);
            }
        }
    }
}
