/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.GestionPaquete;

import java.io.Serializable;

/**
 *
 * @author marlo
 */
public abstract class EstadoPaquete implements Serializable{

    private final Paquete paquete;
    
     public EstadoPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public abstract void gestionarPaquete(Paquete paquete);
    public abstract void realizarEnvio(Paquete paquete);
    
}

    

