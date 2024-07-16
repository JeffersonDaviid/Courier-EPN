/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.GestionPaquete;

/**
 *
 * @author marlo
 */
public class Entrega {
    private String direccionInicial;
    private String direccionDestino;
    private double estado;
    private String fechaEntrega;

    public Entrega() {
    }

    public Entrega(String direccionInicial, String direccionDestino, double estado, String fechaEntrega) {
        this.direccionInicial = direccionInicial;
        this.direccionDestino = direccionDestino;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccionInicial() {
        return direccionInicial;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public double getEstado() {
        return estado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setDireccionInicial(String direccionInicial) {
        this.direccionInicial = direccionInicial;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
}
