/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.Facturacion.GestorFacturas;
import BL.GestionPaquete.Paquete;

/**
 *
 * @author Alex
 */
public class Gestor_Problema {
     private Paquete paquete;
    private Problema problema;
    private double precioPaquete;
    

    public Gestor_Problema(Paquete paquete, Problema problema) {
        this.paquete = paquete;
        this.precioPaquete = GestorFacturas.getInstancia().geFactura().getPrecio().calcularPrecio(paquete);
        this.problema = problema;
    }

    public void solucionarReclamo() {
    problema.resolverReclamo();

        if (problema instanceof RetrasoProblema) {
            double reembolso = ((RetrasoProblema) problema).calcularReembolso(precioPaquete);
            System.out.println("Reembolso calculado: " + reembolso);
        } else if (problema instanceof ExtraviadoProblema) {
            double reembolso = ((ExtraviadoProblema) problema).calcularReembolso(precioPaquete);
            System.out.println("Reembolso calculado: " + reembolso);
        } else if (problema instanceof DanadoProblema) {
            double reembolso = ((DanadoProblema) problema).calcularReembolso(precioPaquete);
            System.out.println("Reembolso calculado: " + reembolso);
        } else if (problema instanceof EquivocadoProblema) {
            ((EquivocadoProblema) problema).corregirDestinatario(paquete);
        }

        System.out.println("Reclamo solucionado para el paquete: " + paquete.obtenerEstadoActual() + " con un precio de: " + precioPaquete);
    }   
    
}
