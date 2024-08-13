package BL.Almacenamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BL.GestionPaquete.Conflicto;
import BL.GestionPaquete.EnBodega;
import BL.GestionPaquete.Entregado;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Transportandose;

public class Inventario implements Serializable {
    private static final String FILE_NAME_HISTORIAL = "src\\main\\java\\BL\\Serializables\\historial.ser";
    private static final String FILE_NAME_PAQUETES = "src\\main\\java\\BL\\Serializables\\paquetes.ser";
    private static Inventario inventario;
    private ArrayList<Paquete> paquetes;
    private Historial historial;
    private int diasMaximo;

    private Inventario() {
        this.diasMaximo = 15;
        this.paquetes = new ArrayList<>();
        this.historial = new Historial();
    }

    @SuppressWarnings("unchecked")
    private void loadInventario() {
        //Carga el Historial
        try (ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(FILE_NAME_HISTORIAL))) {
            historial = (Historial) ois2.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el Historial.");
            e.printStackTrace();
        }
        // Carga los paquetes
        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(FILE_NAME_PAQUETES))) {
            paquetes = (ArrayList<Paquete>) ois1.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los Paquetes.");
            e.printStackTrace();
        }
    }

    public void saveInventario(){
        //Guarda los paquetes
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(FILE_NAME_PAQUETES))) {
            oos1.writeObject(paquetes);
        } catch (IOException e) {
            System.out.println("Error al guardar los Paquetes.");
            e.printStackTrace();
        }
        //Guarda el historial
        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(FILE_NAME_HISTORIAL))) {
            oos2.writeObject(historial);
        } catch (IOException e) {
            System.out.println("Error al guardar el Historial.");
            e.printStackTrace();
        }
    }

    public static Inventario getInstancia() {
        if (inventario == null) {
            inventario = new Inventario();
            inventario.loadInventario();
        }
        return inventario;
    }

    // Metodo que ingresar un paquete
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
        paquete.cambiarEstado(new EnBodega(paquete));
        ingresarRegistro(paquete, paquete.getSucursalOrigen());
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro", JOptionPane.INFORMATION_MESSAGE);
        saveInventario();
    }

    // Metodo que guarda el ingreso de un paquete al invetario para el Historial
    private void ingresarRegistro(Paquete paquete, String agencia) {
        historial.registrarRegistro(new Registro(getFecha(), agencia, paquete.getTracking()));
    }

    //Metodo que buscar un paquete en todo el inventario
    public Paquete buscarPaquete(String trackingABuscar){
        for (Paquete paquete : paquetes) {
            if(paquete.getTracking().equals(trackingABuscar)){
                return paquete;
            }
        }
        JOptionPane.showMessageDialog(null, "Paquete no encontrado");
        return null;        
    }

    // Metodo que devuelve toda la lsita de paquetes del invetario
    public ArrayList<Paquete> getPaquetesInventario() {
        return paquetes;
    }

    // Metodo que obtiene la fecha para el registro de ingreso o salida
    private String getFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // Metodo que calcula la fecha o dias que le faltan a un paquete, sin ser reclamado
    private String calcularFechaLimite(String fechaIngreso) {
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

    // Metodo que muestra todos los paquetes del inventario en la UI
    public DefaultTableModel mostrarPaquetes(int index) {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = { "ID", "Peso","Tamaño","Remitente","Destinatario","Sucursal de Origen", "Sucursal de Destino", "Estado", "Tiempo Restante" };
        int cntidadCol = columnas.length;
        for (int i = 0; i < cntidadCol; i++) {
            model.addColumn(columnas[i]);
        }
        Collection<Paquete> paquetesMostrar = new ArrayList<>();
        
        switch (index) {
            case 0:
                paquetesMostrar = getPaquetesInventario();
                break;
            case 1:
                paquetesMostrar = getPaquetesParaEntregar();
                break;
            case 2:
                for (Paquete paquete : paquetes) {
                    if(paquete.getEstado() instanceof Entregado){
                        paquetesMostrar.add(paquete);
                    }
                }
                break;
            case 3:
            for (Paquete paquete : paquetes) {
                if(paquete.getEstado() instanceof Transportandose){
                    paquetesMostrar.add(paquete);
                }
            }
                break;
            case 4:
            for (Paquete paquete : paquetes) {
                if(paquete.getEstado() instanceof Conflicto){
                    paquetesMostrar.add(paquete);
                }
            }
            break;
        }
        //this.paquetes.values();
        for (Paquete p : paquetesMostrar) {
            model.addRow(new Object[] { 
                    p.getTracking(),
                    p.getPeso(),
                    p.getTamanio(),
                    p.getCliente().getNombre(),
                    p.getNombreDestinatario(),
                    p.getSucursalOrigen(),
                    p.getSucursalDestino(),
                    p.getEstado().toString(),
                    calcularFechaLimite(historial.getRegistro(p.getTracking()).getFechaIngreso())});
        }
        return model;
    }

    public ArrayList<Paquete> getPaquetesParaEntregar(){
        ArrayList<Paquete> paquetesParaEnvio = new ArrayList<>();
        for(Paquete paquete: paquetes){
            if(paquete.getEstado() instanceof EnBodega){
                paquetesParaEnvio.add(paquete);
            }
        }
        return paquetesParaEnvio;
    }

    //Metodo que notifica cuando un paquete se ha cargado a los camniones y poder registrar su fecha de Salida
    public void notificarCambioEstado(String trackingPaquete){
        for (Paquete paquete : paquetes) {
            if(paquete.getTracking().equals(trackingPaquete)){
                if(paquete.getEstado() instanceof Transportandose){
                    historial.getRegistro(trackingPaquete).setFechaSalida(getFecha());
                }
            }
        }
    }

    //Metodo que devuelve una lista de paquetes asociado a un cliente
    public ArrayList<Paquete> getPaquetesDeCliente(String cedula){
        ArrayList<Paquete> paquetesEncontrados = new ArrayList<Paquete>();
        for (Paquete paquete : paquetes) {
            if(paquete.getCliente().getCedula().equals(cedula)){
                paquetesEncontrados.add(paquete);
            }
        }
        return paquetesEncontrados;
    }
}