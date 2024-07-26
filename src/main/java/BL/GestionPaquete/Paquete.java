package BL.GestionPaquete;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;

public class Paquete {
    private String id;
    private float peso;
    private String tamanio;
    private ArrayList<Estado> historialEstado = new ArrayList<>();
    private String agenciaOrigen;
    private String agenciaDestino;
    private String domicilio;

    public Paquete(String id, String agenciaOrigen, String agenciaDestino, String domicilio,
            float peso, String tamanio) {
        this.id = id;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.domicilio = domicilio;
        this.peso = peso;
        this.tamanio = tamanio;
    }

    public void registrarPaquete(Paquete paquete) {
        Recepcion recepcion = Global.getInstancia().buscarAgencia(paquete.getAgenciaOrigen()).getRecepcion();
        recepcion.agregarPaquete(paquete);
        JOptionPane.showMessageDialog(null, "El paquete: " + paquete.getId() + " ha sido registrado");
    }

    public void agregarEstado(Estado estado) {
        historialEstado.add(estado);
    }

    public String getId() {
        return id;
    }

    public String getAgenciaOrigen() {
        return agenciaOrigen;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public float getPeso() {
        return peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public ArrayList<Estado> getHistorialEstado() {
        return historialEstado;
    }

    public void setId(String id) {
        this.id = id;
    }

}
