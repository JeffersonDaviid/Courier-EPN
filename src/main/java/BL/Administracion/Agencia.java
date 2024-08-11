package BL.Administracion;

import java.util.ArrayList;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Recepcion;

public class Agencia {
    private String nombre;
    private Recepcion recepcion = new Recepcion();
    private Inventario inventario = new Inventario();
    private ArrayList<CamionCarga> camionesCarga;
    private ArrayList<CamionEntrega> camionesEntrega;

    public Agencia(String nombre) {
        this.nombre = nombre;
        //this.camionesCarga = new ArrayList<>(); // Inicialización de la lista
        //this.camionesEntrega = new ArrayList<>(); // Inicialización de la lista
    }

    public String getNombre() {
        return nombre;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<CamionCarga> getCamionesCarga() {
        return camionesCarga;
    }

    public ArrayList<CamionEntrega> getCamionesEntrega() {
        return camionesEntrega;
    }

    public void agregarCamionCarga(CamionCarga camion) {
        this.camionesCarga.add(camion);
    }

    public void agregarCamionEntrega(CamionEntrega camion) {
        this.camionesEntrega.add(camion);
    }

    // Métodos para obtener un solo camión por algún criterio si es necesario
    public CamionCarga getCamionCarga(int index) {
        return camionesCarga.get(index);
    }

    public CamionEntrega getCamionEntrega(int index) {
        return camionesEntrega.get(index);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener el primer camión de cada tipo
    public CamionCarga getCamionCarga() {
        if (!camionesCarga.isEmpty()) {
            return camionesCarga.get(0); // Asumiendo que quieres el primer camión
        }
        return null; // O lanza una excepción si prefieres
    }

    public CamionEntrega getCamionEntrega() {
        if (!camionesEntrega.isEmpty()) {
            return camionesEntrega.get(0); // Asumiendo que quieres el primer camión
        }
        return null; // O lanza una excepción si prefieres
    }

}
