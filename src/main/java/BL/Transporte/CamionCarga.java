package BL.Transporte;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionCarga {
    private String placa;
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int disponibilidad;
    private String agencia;
    private ArrayList<Paquete> paquetesCamion = new ArrayList<>();

    public CamionCarga(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad,
            String agencia) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.agencia = agencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void cargarPaquete(String id) {
        Inventario inventario = Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario();
        for (Paquete p : inventario.getPaquetesParaCarga()) {
            if (p.getId().equals(id)) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino agencia destino"));
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido cargado al camion de carga");
                return;
            }
        }
    }

    public void descargarPaquete() {
        Inventario inventario = Global.getInstancia().buscarAgencia(paquetesCamion.get(0).getAgenciaDestino())
                .getInventario();
        for (Paquete p : paquetesCamion) {
            inventario.agregarPaqueteDeCamionCarga(p);
            paquetesCamion.remove(p);
            JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido descargado del camion");
            return;
        }
    }

    public ArrayList<Paquete> getPaquetesCamion() {
        return paquetesCamion;
    }

}