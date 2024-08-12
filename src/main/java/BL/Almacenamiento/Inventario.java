package BL.Almacenamiento;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BL.Administracion.Global;
import BL.GestionPaquete.Paquete;

public class Inventario implements Serializable {
    private static Inventario inventario;
    private Map<String, Paquete> paquetes;
    private Historial historial;
    private int diasMaximo;

    private Inventario() {
        this.diasMaximo = 15;
        this.paquetes = new HashMap<String, Paquete>();
        this.historial = new Historial();
    }

    public static Inventario getInstancia() {
        if (inventario == null) {
            inventario = new Inventario();
        }
        return inventario;
    }

    // Metodo que ingresar un paquete
    public void agregarPaquete(Paquete paquete) {
        paquetes.put(paquete.getId(), paquete);
        //paquete.cambiarEstado(new EnBodega());
        ingresarRegistro(paquete, paquete.getAgenciaOrigen());
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    // Metodo que guarda el ingreso de un paquete al invetario para el Historial
    private void ingresarRegistro(Paquete paquete, String agencia) {
        historial.registrarRegistro(new Registro(getFecha(), agencia, paquete.getId()));
    }

    //Metodo que buscar un paquete en todo el inventario
    public Paquete buscarPaquete(String trackingABuscar){
        if(!paquetes.containsKey(trackingABuscar)){
            JOptionPane.showMessageDialog(null, "Paquete no encontrado");
            return null;
        }
        return paquetes.get(trackingABuscar);
    }

    // Metodo que devuelve toda la lsita de paquetes del invetario
    public ArrayList<Paquete> getPaquetesInventario() {
        ArrayList<Paquete> paq = new ArrayList<>();
        paq.addAll(paquetes.values());
        return paq;
    }

    // Metodo que obtiene la fecha para el registro de ingreso o salida
    private String getFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // Metodo que calcula la fecha o dias que le faltan a un paquete, sin ser reclamado
    public String calcularFechaLimite(String fechaIngreso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime fechaHoraIngreso = LocalDateTime.parse(fechaIngreso, formatter);
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            long diasTranscurridos = ChronoUnit.DAYS.between(fechaHoraIngreso, fechaHoraActual);
            long diasRestantes = diasMaximo - diasTranscurridos;
            return String.valueOf(diasRestantes);
        } catch (Exception e) {
            System.out.println("Error al calcular los días restantes: " + e.getMessage());
            return "Error";
        }
    }

    public Historial getHistorial() {
        return historial;
    }

    // Metodo que muestra todos los paquetes del inventario
    public DefaultTableModel mostrarPaquetes(int index) {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = { "ID", "Peso","Tamaño","Remitente","Destinatario","Agencia de Origen", "Agencia de Destino", "Estado", "Tiempo Restante" };
        int cntidadCol = columnas.length;
        for (int i = 0; i < cntidadCol; i++) {
            model.addColumn(columnas[i]);
        }
        Collection<Paquete> paquetes;
        paquetes = this.paquetes.values();
        for (Paquete p : paquetes) {
            model.addRow(new Object[] { p.getId(),
                    p.getPeso(),
                    p.getTamanio(),
                    p.getNombreRemitente(),
                    p.getNombreDestinatario(),
                    p.getAgenciaOrigen(),
                    p.getAgenciaDestino(),
                    p.getHistorialEstado().get(p.getHistorialEstado().size() - 1).getEstado(),
                    calcularFechaLimite(historial.getRegistro(p.getId()).getFechaIngreso())});
        }
        return model;
    }

    public ArrayList<Paquete> getPaquetesParaEntregar(){
        ArrayList<Paquete> paquetesParaEnvio = new ArrayList<>();
        for(Paquete paquete: paquetes.values()){
            if(paquete.getEstado() == "En bodega"){
                paquetesParaEnvio.add(paquete);
            }
        }
        return paquetesParaEnvio;
    }
}