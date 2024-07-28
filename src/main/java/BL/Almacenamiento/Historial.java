package BL.Almacenamiento;

import java.util.ArrayList;

public class Historial {
    private ArrayList<Registro> registros;

    public Historial() {
        registros = new ArrayList<>();
    }

    //Método que guarda los registros de ingreso y salida de cada Paquete
    public void registrarRegistro(Registro registro) {
        registros.add(registro);
        //guardar en la base
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
        //TODO ESTO ES CONSULTA A LA BASE DE DATOS
        //Saber si filtrar por:
        // id
        // fecha de ingreso
        // fecha de salida
        System.out.println("Historial");
    }
    
    public void actualizarFechaDeSalida(String id) {
        String fechaDeSalida = getRegistro(id).getFechaSalida();
        //Logica para actualizar la tabla
    }
}
