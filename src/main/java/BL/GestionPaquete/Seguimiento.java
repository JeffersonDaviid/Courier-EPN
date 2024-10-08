package BL.GestionPaquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seguimiento implements Serializable{
    private Paquete paquete;
    private List<EstadoPaquete> historialEstados;

    public Seguimiento(Paquete paquete) {
        this.paquete = paquete;
        this.historialEstados = new ArrayList<>();
        
    }

    // Método para realizar seguimiento del paquete
    public void realizarSeguimiento() {
        // Obtener el estado actual del paquete y añadirlo al historial
        EstadoPaquete estadoActual = paquete.obtenerEstadoActual();
        this.historialEstados.add(estadoActual);
        System.out.println("Seguimiento: " + estadoActual.toString());
    }

    // Método para ver el estado actual del paquete
    public EstadoPaquete verEstado() {
        return paquete.obtenerEstadoActual();
    }

    // Método para ver el historial completo de estados con el paquete
    public String verHistorial() {
        StringBuilder historialCompleto = new StringBuilder("Historial de estados del paquete:\n");
        for (EstadoPaquete estado : historialEstados) {
            historialCompleto.append(estado.toString()).append("\n");
        }
        return historialCompleto.toString();
    }
}
