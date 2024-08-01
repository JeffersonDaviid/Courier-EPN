package BL.Agencia;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Recepcion;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;

public class Agencia {
    private String nombre;
    private Recepcion recepcion = new Recepcion();
    private Inventario inventario = new Inventario();
    // private ArrayList<CamionCarga> camionesCarga = new ArrayList<CamionCarga>();
    // private ArrayList<CamionEntrega> camionesEntrega = new
    // ArrayList<CamionEntrega>();
    private CamionCarga camionCarga = new CamionCarga();
    private CamionEntrega camionEntrega = new CamionEntrega();

    public Agencia(String nombre) {
        this.nombre = nombre;
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

    // public ArrayList<CamionCarga> getCamionesCarga() {
    // return camionesCarga;
    // }

    // public ArrayList<CamionEntrega> getCamionesEntrega() {
    // return camionesEntrega;
    // }

    public CamionCarga getCamionCarga() {
        return camionCarga;
    }

    public CamionEntrega getCamionEntrega() {
        return camionEntrega;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
