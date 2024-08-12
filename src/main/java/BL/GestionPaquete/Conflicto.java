/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.GestionPaquete;

/**
 *
 * @author marlo
 */
public class Conflicto extends EstadoPaquete {

    public Conflicto(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void gestionarPaquete(Paquete paquete) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarEnvio(Paquete paquete) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Conflicto";
    }
    
}
