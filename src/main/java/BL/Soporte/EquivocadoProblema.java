/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.GestionPaquete.Paquete;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class EquivocadoProblema implements Problema{

    @Override
    public void resolverReclamo() {
        JOptionPane.showMessageDialog(null, "Resolviendo problema de paquete equivocado...");
    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0; 
    }
   
    public void corregirDestinatario(Paquete paquete) {
   
        JOptionPane.showMessageDialog(null, "Asignando el destinatario correcto para el paquete: " + paquete.getTracking());

        String nombreCorrecto = JOptionPane.showInputDialog("Ingrese el nombre correcto del destinatario:");
        if (nombreCorrecto != null && !nombreCorrecto.trim().isEmpty()) {
        paquete.setNombreDestinatario(nombreCorrecto);
        JOptionPane.showMessageDialog(null, "Paquete " + paquete.getTracking() + " cambiado al destinatario " + paquete.getNombreDestinatario());
        } else {
        JOptionPane.showMessageDialog(null, "El nombre del destinatario no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}
