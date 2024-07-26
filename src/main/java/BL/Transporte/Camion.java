package BL.Transporte;

import java.util.ArrayList;

import BL.GestionPaquete.Paquete;

public abstract class Camion implements Cloneable {
    private String placa;
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int disponibilidad;
    private ArrayList<Paquete> paquetesCamion = new ArrayList<>();
    private String agencia;
    public Camion() {
    }

    public Camion(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad, String agencia) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.paquetesCamion = new ArrayList<>();
        this.agencia = agencia;
    }

    public String getPlaca() {
        return placa;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public ArrayList<Paquete> getPaquetesCamion() {
        return paquetesCamion;
    }

    public void setPaquetesCamion(ArrayList<Paquete> paquetesCamion) {
        this.paquetesCamion = paquetesCamion;
    }

}