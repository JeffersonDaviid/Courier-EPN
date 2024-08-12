package BL.Transporte;

import java.io.Serializable;

public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    // atributos
    private int idCamion;
    private String placa;
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int capacidadOcupada;
    private boolean disponibilidad; // 1 libre y 0 ocupado
    private Ubicacion ubicacionOrigen;
    private Ubicacion ubicacionDestino;

    // constructor

    public Camion(int idCamion, String placa, String modelo, String marca,
            boolean disponibilidad, Ubicacion ubicacionOrigen, Ubicacion ubicacionDestino) {
        this.idCamion = idCamion;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = 50;
        this.capacidadOcupada = 0;
        this.disponibilidad = disponibilidad;
        this.ubicacionOrigen = ubicacionOrigen;
        this.ubicacionDestino = ubicacionDestino;
    }

    public Camion() {
        this.idCamion = 0;
        this.placa = null;
        this.modelo = null;
        this.marca = null;
        this.capacidadCarga = 0;
        this.capacidadOcupada = 0;
        this.disponibilidad = true;
        this.ubicacionOrigen = null;
        this.ubicacionDestino = null;
    }

    public void viajar() {
        Ubicacion temp = this.ubicacionOrigen;
        this.ubicacionOrigen = this.ubicacionDestino;
        this.ubicacionDestino = temp;
    }

    public void incrementarCapacidadOcupada(int cantidad) {
        if (this.capacidadOcupada + cantidad <= this.capacidadCarga) {
            this.capacidadOcupada += cantidad;
        } else {
            System.out.println("No hay suficiente capacidad en el camión.");
        }
    }

    public void reducirCapacidadOcupada(int cantidad) {
        if (this.capacidadOcupada - cantidad >= 0) {
            this.capacidadOcupada -= cantidad;
        } else {
            System.out.println("No se puede reducir la capacidad ocupada por más de lo que está ocupado.");
        }
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getPlaca() {
        return placa;
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

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(int capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Ubicacion getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(Ubicacion ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public Ubicacion getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(Ubicacion ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

}
