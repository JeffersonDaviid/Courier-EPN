package BL.GestionPaquete;

import java.util.ArrayList;

public class Recepcion {
    private ArrayList<Paquete> paquetesRecepcion = new ArrayList<>();

    public Recepcion() {
    }

    public void agregarPaquete(Paquete paquete) {
        Estado estado = new Estado("En recepción");
        paquete.agregarEstado(estado);
        paquetesRecepcion.add(paquete);
    }

    public void eliminarPaquete(Paquete paquete) {
        paquetesRecepcion.remove(paquete);
    }

    public ArrayList<Paquete> getPaquetesRecepcion() {
        return paquetesRecepcion;
    }
}
