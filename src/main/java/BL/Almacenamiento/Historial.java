package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    }

    //Metodo que muestra el historial de ingresos y salidas del dia que se lo llame
    public void consultar() {
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
    }

    public void filtrarPorId(String idPaquete){
        System.out.println("Filtro por id Paquete");
        for (Registro registro : registros) {
            if (registro.getIdPaquete().equals(idPaquete)) {
                System.out.println(registro);
            }
        }
    }

    public void filtrarPorFechaSalida(String fechaSalida){
        System.out.println("Filtro por Fecha de Salida");
        DateTimeFormatter formatterFechaYHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Registro registro : registros) {
            if(registro.getFechaSalida() != null){
                LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaSalida(), formatterFechaYHora);
                LocalDate fecha = LocalDate.parse(fechaSalida, formatterFecha); 
                if (fechaYHora.toLocalDate().equals(fecha)) {
                    System.out.println(registro);
                } 
            }
        }
    }

    public void filtrarPorFechaIngreso(String fechaIngreso){
        System.out.println("Filtro por Fecha de Ingreso");
        DateTimeFormatter formatterFechaYHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Registro registro : registros) {
            LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaIngreso(), formatterFechaYHora);
            LocalDate fecha = LocalDate.parse(fechaIngreso, formatterFecha);
            if (fechaYHora.toLocalDate().equals(fecha)) {
                System.out.println(registro);
            } 
        }
    }

    //Método que actualiza la fecha de salida de un registro
    public void actualizarFechaDeSalida(String id, String fechaSalida) {
        getRegistro(id).setFechaSalida(fechaSalida);;
    }
}
