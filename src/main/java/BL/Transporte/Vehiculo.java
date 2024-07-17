package BL.Transporte;

import java.util.List;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;

public class Vehiculo {
    String modelo;
    String marca;
    int capacidadCarga;
    boolean disponibilidad;
    List<Paquete> paquetesCamionCarga;
    Ruta ruta;

    public Vehiculo(String modelo, String marca, int capacidadCarga, boolean disponibilidad, List<Paquete> paquetes, Ruta ruta) {
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.paquetesCamionCarga = paquetes;
        this.ruta = ruta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Paquete> getPaquetes() {
        return paquetesCamionCarga;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        paquetesCamionCarga = paquetes;
    }


    protected void verificarDisponibilidad() {
        if (!disponibilidad) {
            JOptionPane.showMessageDialog(null, "El vehiculo no esta disponible");
        }   
    }
    
}
