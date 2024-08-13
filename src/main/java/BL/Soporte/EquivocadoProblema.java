/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.GestionPaquete.Paquete;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class EquivocadoProblema implements Problema{

    @Override
    public void resolverReclamo() {
        JOptionPane.showMessageDialog(null, "Resolviendo problema de paquete extraviado...");
    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0; 
    }
   
    public void corregirDestinatario(Paquete paquete) {
        /*System.out.println("Asignando el destinatario correcto para el paquete: " + paquete.obtenerEstadoActual());
        Scanner sc=new Scanner(System.in);
        String nombreCorrecto=sc.nextLine();
        paquete.setNombreDestinatario(nombreCorrecto);
        System.out.println("Paquete "+paquete.getTracking()+ "cambiado al destinatario"+paquete.getCliente());
        sc.close();*/
        JOptionPane.showMessageDialog(null, "Asignando el destinatario correcto para el paquete: " + paquete.obtenerEstadoActual());

        String nombreCorrecto = JOptionPane.showInputDialog("Ingrese el nombre correcto del destinatario:");
        if (nombreCorrecto != null && !nombreCorrecto.trim().isEmpty()) {
        paquete.setNombreDestinatario(nombreCorrecto);
        JOptionPane.showMessageDialog(null, "Paquete " + paquete.getTracking() + " cambiado al destinatario " + paquete.getCliente());
        } else {
        JOptionPane.showMessageDialog(null, "El nombre del destinatario no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}
