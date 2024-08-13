/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.Facturacion.GestorFacturas;
import BL.GestionPaquete.EnBodega;
import BL.GestionPaquete.Entregado;
import BL.GestionPaquete.Paquete;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class GestorProblema {
     private Paquete paquete;
    private Problema problema;
    private double precioPaquete;
    

    public GestorProblema(Paquete paquete, Problema problema) {
        this.paquete = paquete;
        this.precioPaquete = GestorFacturas.getInstancia().geFactura().getPrecio().calcularPrecio(paquete);
        this.problema = problema;
    }

    public void solucionarReclamo() {
    problema.resolverReclamo();
    double reembolso = problema.calcularReembolso(precioPaquete);
    this.paquete.cambiarEstado(new Entregado(paquete));
    if (problema instanceof EquivocadoProblema) {
        ((EquivocadoProblema) problema).corregirDestinatario(paquete);
        this.paquete.cambiarEstado(new EnBodega(paquete));
    } else {
        JOptionPane.showMessageDialog(null, "Reembolso calculado: " + reembolso);
    }
    JOptionPane.showMessageDialog(null, "Reclamo solucionado para el paquete: "+paquete.getTracking() + " Estado Actual del paquete: " + paquete.getEstado());
    
    }   
    
}
