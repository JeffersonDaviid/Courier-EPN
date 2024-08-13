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
public class ExtraviadoProblema implements Problema{

    @Override
    public void resolverReclamo() {
      JOptionPane.showMessageDialog(null, "Resolviendo problema de paquete equivocado...");
      
    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0.95 * precioPaquete;  // No se aplica reembolso, solo corrección
    }

    
}
