/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL.GestionPaquete;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlo
 */
public class Agencia extends Entrega{
 private String direccion;
    private String horarioAtencion;
    private List<Paquete> paquetes;

    // Constructor

    public Agencia(String direccion, String horarioAtencion, List<Paquete> paquetes) {
        this.direccion = direccion;
        this.horarioAtencion = horarioAtencion;
        this.paquetes = paquetes;
    }

    public Agencia(String direccion, String horarioAtencion, List<Paquete> paquetes, String direccionInicial, String direccionDestino, double estado, String fechaEntrega) {
        super(direccionInicial, direccionDestino, estado, fechaEntrega);
        this.direccion = direccion;
        this.horarioAtencion = horarioAtencion;
        this.paquetes = paquetes;
    }
   

    // Getters and setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    // Métodos para gestionar paquetes
    public void addPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    public void removePaquete(Paquete paquete) {
        paquetes.remove(paquete);
    }
/*
    public Paquete getPaquete(String idPaquete) {
        for (Paquete paquete : paquetes) {
            if (paquete.getId_paquete()== idPaquete) {
                return paquete;
            }
        }
        return null; // Retorna null si no encuentra el paquete
    }
    */
}
