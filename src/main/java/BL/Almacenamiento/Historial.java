package BL.Almacenamiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;
import java.util.List;
import java.util.stream.Collectors;

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
    public void consultar(int index) {
        System.out.print("Agencia: " + Global.getInstancia().agenciaActual.toUpperCase());
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

   // Método que filtra el historial según los parámetros proporcionados
    public List<Registro> filtrarHistorial(String idPaquete, String fechaIngreso, String fechaSalida, String agencia) {
        DateTimeFormatter formatterFechaYHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return registros.stream().filter(registro -> {
            boolean matches = true;

            if (idPaquete != null && !idPaquete.isEmpty()) {
                matches &= registro.getIdPaquete().equals(idPaquete);
            }

            if (fechaIngreso != null && !fechaIngreso.isEmpty()) {
                LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaIngreso(), formatterFechaYHora);
                LocalDate fecha = LocalDate.parse(fechaIngreso, formatterFecha);
                matches &= fechaYHora.toLocalDate().equals(fecha);
            }

            if (fechaSalida != null && !fechaSalida.isEmpty() && registro.getFechaSalida() != null) {
                LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaSalida(), formatterFechaYHora);
                LocalDate fecha = LocalDate.parse(fechaSalida, formatterFecha);
                matches &= fechaYHora.toLocalDate().equals(fecha);
            }

            if (agencia != null && !agencia.isEmpty()) {
                matches &= Global.getInstancia().agenciaActual.equalsIgnoreCase(agencia);
            }

            return matches;
        }).collect(Collectors.toList());
    }

    //Método que actualiza la fecha de salida de un registro
    public void actualizarFechaDeSalida(String id, String fechaSalida) {
    Registro registro = getRegistro(id);
    if (registro != null) {
        registro.setFechaSalida(fechaSalida);
    } else {
        System.out.println("Registro no encontrado");
    }
    }
}
