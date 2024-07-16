/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.GestionPaquete;

/**
 *
 * @author marlo
 */
public class Domicilio extends Entrega{
   private String direccionDomicilio;
   private String numeracion;

    public Domicilio(String direccionDomicilio, String numeracion) {
        this.direccionDomicilio = direccionDomicilio;
        this.numeracion = numeracion;
    }

    public Domicilio(String direccionDomicilio, String numeracion, String direccionInicial, String direccionDestino, double estado, String fechaEntrega) {
        super(direccionInicial, direccionDestino, estado, fechaEntrega);
        this.direccionDomicilio = direccionDomicilio;
        this.numeracion = numeracion;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }
   
}
