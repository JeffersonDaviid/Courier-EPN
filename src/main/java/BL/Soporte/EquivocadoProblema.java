/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.Soporte;

import BL.GestionPaquete.Paquete;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class EquivocadoProblema implements Problema{

    @Override
    public void resolverReclamo() {
        System.out.println("Resolviendo problema de paquete extraviado...");

    }

    @Override
    public double calcularReembolso(double precioPaquete) {
        return 0; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public void corregirDestinatario(Paquete paquete) {
        System.out.println("Asignando el destinatario correcto para el paquete: " + paquete.obtenerEstadoActual());
        Scanner sc=new Scanner(System.in);
        String nombreCorrecto=sc.nextLine();
        paquete.setCliente(nombreCorrecto);
        System.out.println("Paquete "+paquete.getTracking()+ "cambiado al destinatario"+paquete.getCliente());
        sc.close();
    }
    
    
}
