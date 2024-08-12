package BL.Almacenamiento;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;

public class Historial implements Serializable {
    private ArrayList<Registro> registros;

    public Historial() {
        registros = new ArrayList<>();
    }

    //Método que guarda los registros de ingreso y salida de cada Paquete
    public void registrarRegistro(Registro registro) {
        registros.add(registro);
    }

    //Metodo que busca un registro expecifico en toda la lista
    public Registro getRegistro(String trackingPaquete) {
        for (Registro registro : registros) {
            if (registro.getTrackinPaquete().equals(trackingPaquete)) {
                return registro;
            }
        }
        System.out.println("Registro no encontrado");
        return null;
    }

    public DefaultTableModel mostrarHistorial(int index, String parametro) {
        DateTimeFormatter formatterFechaYHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DefaultTableModel model = new DefaultTableModel();
            String[] columnas = { "Tracking Paquete", "Fecha Ingreso","Fecha Salida","Sucursal" };
            int cntidadCol = columnas.length;
            for (int i = 0; i < cntidadCol; i++) {
                model.addColumn(columnas[i]);
            }
            Collection<Registro> registrosMostrar = new ArrayList<>();
            
            switch (index) {
                case -1:
                    registrosMostrar = registros;
                    break;
                case 0:
                    for (Registro registro : registros) {
                        if(registro.getTrackinPaquete() == parametro){
                            registrosMostrar.add(registro);
                        }
                    }                
                    break;
                case 1:
                    for (Registro registro : registros) {
                        LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaIngreso(), formatterFechaYHora);
                        LocalDate fecha = LocalDate.parse(parametro, formatterFecha);
                        if(fechaYHora.toLocalDate().equals(fecha)){
                            registrosMostrar.add(registro);
                        }
                    }
                    break;
                case 2:
                    for (Registro registro : registros) {
                        if(registro.getFechaSalida() == null){
                            continue;
                        }
                        LocalDateTime fechaYHora = LocalDateTime.parse(registro.getFechaSalida(), formatterFechaYHora);
                        LocalDate fecha = LocalDate.parse(parametro, formatterFecha);
                        if(fechaYHora.toLocalDate().equals(fecha)){
                            registrosMostrar.add(registro);
                        }
                    }
                    break;
                }
            for (Registro p : registrosMostrar) {
                model.addRow(new Object[] { 
                        p.getTrackinPaquete(),
                        p.getFechaIngreso(),
                        (p.getFechaSalida() != null)? p.getFechaSalida(): ""});
            }
            return model;
        }
}
