/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class RetrasoProblema implements Problema{

    @Override
    public void resolverReclamo() {
        
        JOptionPane.showMessageDialog(null, "Resolviendo problema de retraso...");
    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0.20 * precioPaquete;
    }

   
    
}
