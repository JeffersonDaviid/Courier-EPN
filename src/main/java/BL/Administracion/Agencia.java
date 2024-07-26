package BL.Administracion;

import java.util.ArrayList;

// import java.util.ArrayList;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Recepcion;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;

public class Agencia {
    private String nombre;
    private Recepcion recepcion = new Recepcion();
    private Inventario inventario = new Inventario();
    private ArrayList<CamionCarga> camionesCarga = new ArrayList<CamionCarga>();
    private ArrayList<CamionEntrega> camionesEntrega = new ArrayList<CamionEntrega>();
    // ArrayList<CamionEntrega>();
    // private CamionCarga camionCarga = new CamionCarga();
    // private CamionEntrega camionEntrega = new CamionEntrega();

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.camionesCarga = agregarFlotaCarga(nombre);
        this.camionesEntrega = agregarFlotaEntrega(nombre);
    }

    public ArrayList<CamionCarga> agregarFlotaCarga(String nombre) {
        ArrayList<CamionCarga> camionesCarga = new ArrayList<>();
        CamionCarga camionCarga1 = new CamionCarga("ABC-123", "Volvo", "Tuti", 50, 1, nombre);
        CamionCarga camionCarga2 = new CamionCarga("DEF-456", "IDK", "Toyota", 100, 1, nombre);
        camionesCarga.add(camionCarga1);
        camionesCarga.add(camionCarga2);
        return camionesCarga;
    }

    public ArrayList<CamionEntrega> agregarFlotaEntrega(String nombre) {
        ArrayList<CamionEntrega> camionesEntrega = new ArrayList<>();
        CamionEntrega camionEntrega1 = new CamionEntrega("ABC-123", "Volvo", "Tuti", 50, 1, nombre);
        // CamionEntrega camionEntrega2 = new CamionEntrega("DEF-456", "IDK",
        // "Toyota", 100, 1);
        camionesEntrega.add(camionEntrega1);
        // camionesEntrega.add(camionEntrega2);
        return camionesEntrega;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
