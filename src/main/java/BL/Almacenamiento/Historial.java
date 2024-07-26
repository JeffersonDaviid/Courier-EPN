package BL.Almacenamiento;

import java.util.ArrayList;

public class Historial {
    private ArrayList<Registro> registros;

    public Historial() {
        registros = new ArrayList<>();
    }

    // Método que guarda los registros de ingreso y salida de cada Paquete
    public void registrarRegistro(Registro registro) {
        System.out.println(registro);
        registros.add(registro);
    }

    public void consultarHoy() {
        for (Registro registro : registros) {
            System.out.println("\n" + registro.toString());
        }
    }

    public Registro getRegistro(String idPaquete) {
        for (Registro registro : registros) {
            if (registro.getIdPaquete().equals(idPaquete)) {
                return registro;
            }
        }
        System.out.println("Registro no encontrado");
        return null;
    }

    public void filtrarHistorial(String parametro) {
        // Saber si filtrar por:
        // id
        // fecha de ingreso
        // fecha de salida
        System.out.println("Historial");
    }
}
