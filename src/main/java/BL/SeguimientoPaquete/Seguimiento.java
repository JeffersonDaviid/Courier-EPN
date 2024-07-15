/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.SeguimientoPaquete;

/**
 *
 * @author Alex
 */
public class Seguimiento {
    private String ubicacion;
    private int id;

    // Constructor
    public Seguimiento(int id,String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
    }

    // Métodos
    public void generarCodigoSeguimiento() {
            this.id = id+1;
    }

    public void consultarUbicacion() {
        // Implementación
    }

    public void actualizarUbicacion(String nuevaUbicacion) {
        this.ubicacion = nuevaUbicacion;
    }

    // Getters y Setters según sea necesario

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    

}
