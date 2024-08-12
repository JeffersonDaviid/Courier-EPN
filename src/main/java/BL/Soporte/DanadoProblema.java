/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.GestionPaquete.Paquete;

/**
 *
 * @author Alex
 */
public class DanadoProblema implements Problema{

    @Override
    public void resolverReclamo() {
         System.out.println("Resolviendo problema de paquete dañado...");
    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0.30 * precioPaquete; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
