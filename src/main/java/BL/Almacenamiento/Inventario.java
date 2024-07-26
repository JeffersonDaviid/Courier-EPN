package BL.Almacenamiento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Recepcion;

public class Inventario {
    private Recepcion recepcion;
    private Map<String, Paquete> paquetesAlmacenados;
    private Map<String, Paquete> paquetesParaCargaSucursal;
    private Map<String, Paquete> paquetesParaCargaDomicilio;
    private int capacidadTotal;
    private int capacidadOcupada;
    private Historial historial;
    private int tiempoMaximo;
    private final int CAPACIDAD_PAQUETE_PEQUENIO = 1;
    private final int CAPACIDAD_PAQUETE_MEDIANO = 2;
    private final int CAPACIDAD_PAQUETE_GRANDE = 3;

    public Inventario() {
        this.tiempoMaximo = 15;
        this.capacidadTotal = 100;
        this.paquetesAlmacenados = new HashMap<String, Paquete>();
        this.paquetesParaCargaSucursal = new HashMap<String, Paquete>();
        this.paquetesParaCargaDomicilio = new HashMap<String, Paquete>();
        this.capacidadOcupada = calcularCapacidadOcupada();
        this.historial = new Historial();
    }

    //
    public void agregarPaqueteDeRecepcion(String id) {
        recepcion = Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion();
        for (Paquete p : recepcion.getPaquetesRecepcion()) {
            if (p.getId().equals(id)) {
                int capacidadPaquete = clasificarCapacidad(p.getTamanio());
                // Verifica que hay espacio suficiente en el inventario
                if (!hayEspacioSuficiente(capacidadPaquete)) {
                    notificarCapacidadCompleta();
                    return;
                }
                p.agregarEstado(new Estado("En bodega agencia remitente"));
                paquetesAlmacenados.put(p.getId(), p);
                ingresarRegistro(p, capacidadPaquete);
                recepcion.eliminarPaquete(p);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El paquete no existe o no esta en recepcion");

    }

    public void agregarPaqueteDeCamionCarga(Paquete paquete) {
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        // Verifica que hay espacio suficiente en el inventario
        if (!hayEspacioSuficiente(capacidadPaquete)) {
            notificarCapacidadCompleta();
            return;
        }
        paquetesAlmacenados.put(paquete.getId(), paquete);
        paquete.agregarEstado(new Estado("En bodega agencia destino"));
        ingresarRegistro(paquete, capacidadPaquete);
    }

    private void ingresarRegistro(Paquete paquete, int capacidadPaquete) {
        historial.registrarRegistro(new Registro(getFecha(), "Quito", paquete.getId()));
        JOptionPane.showMessageDialog(null, "Paquete registrado con éxito", "Registro",
                JOptionPane.INFORMATION_MESSAGE);
        actualizar(capacidadPaquete);
    }

    public void organizarPaquetes(String idPaquete) {
        for (Paquete paquete : paquetesAlmacenados.values()) {
            // Verifica que el paquete es para envio a otra sucursal
            if (paquete.getId().equals(idPaquete) && !paquete.getAgenciaDestino().equals(Global.agenciaActual)) {
                Estado estado = new Estado("Listo para envio agencia destino");
                paquete.agregarEstado(estado);
                paquetesParaCargaSucursal.put(paquete.getId(), paquetesAlmacenados.remove(idPaquete));
                return;
            } else {
                System.out.println(paquete.getDomicilio());
                // Si el paquete ya se encuentra en la sucursal de destino entonces verificamos
                // si tiene entrega a domicilio
                if (paquete.getDomicilio() == null) {
                    Estado estado = new Estado("Listo para retiro de bodega");
                    paquete.agregarEstado(estado);
                } else {
                    // si lo tiene se lo coloca como listo para enviar
                    Estado estado = new Estado("Listo para envio a domicilio");
                    paquete.agregarEstado(estado);
                    paquetesParaCargaDomicilio.put(paquete.getId(), paquetesAlmacenados.remove(paquete.getId()));
                }
            }
        }
        mostrarInventario();
    }

    // Metodo para entregar al cliente - Llama el bodeguero
    public void entregarPaquete(String id) {
        if (!paquetesAlmacenados.containsKey(id)) {
            System.out.println("Paquete no encontrado");
            return;
        }
        Paquete paquete = paquetesAlmacenados.remove(id);
        paquete.agregarEstado(new Estado("Entregado"));
    }

    public ArrayList<Paquete> getPaquetesInventario() {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes.addAll(paquetesAlmacenados.values());
        paquetes.addAll(paquetesParaCargaSucursal.values());
        paquetes.addAll(paquetesParaCargaDomicilio.values());
        return paquetes;
    }

    private int calcularCapacidadOcupada() {
        int cantidadOcupada = 0;
        for (Paquete paquete : paquetesAlmacenados.values()) {
            cantidadOcupada += clasificarCapacidad(paquete.getTamanio());
        }
        return cantidadOcupada;
    }

    private int clasificarCapacidad(String tamanio) {
        switch (tamanio) {
            case "grande":
                return CAPACIDAD_PAQUETE_GRANDE;
            case "mediano":
                return CAPACIDAD_PAQUETE_MEDIANO;
        }
        return CAPACIDAD_PAQUETE_PEQUENIO;
    }

    private String getFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public void actualizar(int cantidad) {
        capacidadOcupada += cantidad;
    }

    private void notificarCapacidadCompleta() {
        JOptionPane.showMessageDialog(null, "Capacidad de la bodega alcanzado", "Alerta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean hayEspacioSuficiente(int capacidadPaquete) {
        return (capacidadOcupada + capacidadPaquete) < capacidadTotal;
    }

    public void actualizarCapacidadTotal(int capacidad) {
        this.capacidadTotal = capacidad;
    }

    private String calcularFechaLimite(String fechaIngreso) {
        // Calcular fecha limite para cada paquete
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime fechaHoraActual = LocalDateTime.parse(fechaIngreso, formatter);
            LocalDateTime fechaHoraFutura = fechaHoraActual.plusDays(15);
            return fechaHoraFutura.format(formatter);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void consultarHistorial() {
        historial.consultarHoy();
    }

    public Paquete retirarPaquete(String idPaquete) {
        Paquete paquete = null;
        // Verifica que el paquete este en el inventario para poder retirarlo
        if (paquetesParaCargaDomicilio.containsKey(idPaquete)) {
            paquete = paquetesParaCargaDomicilio.remove(idPaquete);
        } else if (paquetesParaCargaSucursal.containsKey(idPaquete)) {
            paquete = paquetesParaCargaSucursal.remove(idPaquete);
        } else if (paquetesAlmacenados.containsKey(idPaquete)) {
            paquete = paquetesAlmacenados.remove(idPaquete);
        } else {
            System.out.println("Paquete no encontrado");
            return null;
        }
        // Se guarda la fecha de salida del paquete en el registro
        historial.getRegistro(idPaquete).setFechaSalida(getFecha());
        actualizar(-clasificarCapacidad(paquete.getTamanio())); // Se actualiza la capacidad ocupada del inventario
        return paquete;
    }

    public void mostrarInventario() {
        System.out.println("------\nPaquetes Almacenados - Retiro Agencia");
        for (Paquete paquete : paquetesAlmacenados.values()) {
            System.out.println(paquete);
        }
        System.out.println("------\nPaquetes para Camion a Sucursal");
        for (Paquete paquete : paquetesParaCargaSucursal.values()) {
            System.out.println(paquete);
        }
        System.out.println("------\nPaquetes para Camion a Domicilio");
        for (Paquete paquete : paquetesParaCargaDomicilio.values()) {
            System.out.println(paquete);
        }
    }

    public void mostrarPaquetes() {
        // Algoritmo para mostrar todos los paquetes
    }

    public ArrayList<Paquete> getPaquetesParaCarga() {
        return new ArrayList<>(paquetesParaCargaSucursal.values());
    }

    public ArrayList<Paquete> getPaquetesParaEnvioDomicilio() {
        return new ArrayList<>(paquetesParaCargaDomicilio.values());
    }
}