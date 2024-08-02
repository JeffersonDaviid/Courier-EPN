package BL.Transporte;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Agencia.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionEntrega {
    private String tipo;
    private String placa;
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int disponibilidad;
    private String agencia;
    private ArrayList<Paquete> paquetesCamion = new ArrayList<>();

    public CamionEntrega(String tipo, String placa, String modelo, String marca, int capacidadCarga, int disponibilidad,
            String agencia) {
        this.tipo = tipo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        for (Paquete p : inventario.getPaquetesParaEnvioDomicilio()) {
            if (p.getId().equals(id)) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino a domicilio"));
                JOptionPane.showMessageDialog(null,
                        "El paquete " + p.getId() + " ha sido cargado al camion de entregas");
                return;
            }
        }
    }

    public void entregarPaquete(String id) {
        for (Paquete p : paquetesCamion) {
            if (p.getId().equals(id)) {
                Estado estado = new Estado("Entregado");
                p.agregarEstado(estado);// tambien en la base de datos

                // paquetesCamion.remove(p); // COMENTADO PARA PRUEBAS
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido entregado");
                return;
            }
        }
    }

    public ArrayList<Paquete> getPaquetesCamion() {
        return paquetesCamion;
    }

}
