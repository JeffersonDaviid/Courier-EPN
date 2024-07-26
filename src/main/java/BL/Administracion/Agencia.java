package BL.Administracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Recepcion;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;
import BL.Transporte.Camion;
import BL.Transporte.CamionFactory;
import BL.Transporte.FlotaCamiones;

public class Agencia {
    private String nombre;
    private Recepcion recepcion = new Recepcion();
    private Inventario inventario = new Inventario();
    private List<CamionCarga> camionesCarga;
    private List<CamionEntrega> camionesEntrega;

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.camionesCarga = new ArrayList<>();
        this.camionesEntrega = new ArrayList<>();
        agregarFlotaInicial();
    }

    private void agregarFlotaInicial() {
        for (int i = 0; i < 3; i++) {
            agregarCamion("carga", generarPlaca(), "Volvo", "Tuti", 50, 1);
            agregarCamion("entrega", generarPlaca(), "Mercedes", "Sprinter", 30, 1);
        }
    }

    private String generarPlaca() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder placa = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            placa.append(letras.charAt(random.nextInt(letras.length())));
        }

        placa.append("-");
        for (int i = 0; i < 4; i++) {
            placa.append(random.nextInt(10));
        }

        return placa.toString();
    }

    public void agregarCamion(String tipo, String placa, String modelo, String marca, int capacidadCarga,
            int disponibilidad) {
        if (tipo.equals("carga")) {
            CamionCarga camionCarga = new CamionCarga(placa, modelo, marca, capacidadCarga, disponibilidad, nombre);
            camionesCarga.add(camionCarga);
        } else if (tipo.equals("entrega")) {
            CamionEntrega camionEntrega = new CamionEntrega(placa, modelo, marca, capacidadCarga, disponibilidad,
                    nombre);
            camionesEntrega.add(camionEntrega);
        }
        Camion camion = CamionFactory.crearCamion(tipo, placa, modelo, marca, capacidadCarga, disponibilidad, nombre);
        FlotaCamiones.getInstance().agregarCamion(nombre, camion);
    }

    public Camion obtenerCamion(String placa) {
        return FlotaCamiones.getInstance().obtenerCamion(nombre, placa);
    }

    public String getNombre() {
        return nombre;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public List<CamionCarga> getCamionesCarga() {
        return camionesCarga;
    }

    public List<CamionEntrega> getCamionesEntrega() {
        return camionesEntrega;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

     public void mostrarCamionesPorTipo() {
        StringBuilder cargaInfo = new StringBuilder("Camiones de Carga:\n");
        for (CamionCarga camion : camionesCarga) {
            cargaInfo.append(camion).append("\n");
        }

        StringBuilder entregaInfo = new StringBuilder("Camiones de Entrega:\n");
        for (CamionEntrega camion : camionesEntrega) {
            entregaInfo.append(camion).append("\n");
        }

        JOptionPane.showMessageDialog(null, cargaInfo.toString(), "Camiones de Carga", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, entregaInfo.toString(), "Camiones de Entrega", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarCamiones() {
        FlotaCamiones.getInstance().mostrarCamiones(nombre);
    }

}
