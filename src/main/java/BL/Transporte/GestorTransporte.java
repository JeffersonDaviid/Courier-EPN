package BL.Transporte;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import BL.Administracion.Transportista;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public class GestorTransporte {

    private static GestorTransporte instancia;
    private Inventario inventario;
    private ArrayList<Camion> camiones;
    private ArrayList<Transportista> transportistas;
    private HashMap<Camion, Transportista> camionTransportista;
    private HashMap<Camion, ArrayList<Paquete>> camionPaquetes;


    // Constructor 
    private GestorTransporte() {
        this.inventario = Inventario.getInstancia();
        this.camiones = new ArrayList<Camion>(); // Incluir un metodo para cargar camiones quemados
        this.transportistas = new ArrayList<Transportista>(); // Incluir un metodo para cargar transportistas quemados
        this.camionTransportista = new HashMap<Camion, Transportista>(); // Consultar para quemar asignaciones
        this.camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>(); // Consultar para quemar asignaciones
    }

    public static GestorTransporte getInstancia() {
        if (instancia == null) {
            instancia = new GestorTransporte();
        }
        return instancia;
    }

    // Metodos para agregar y eliminar objetos Transportista
    public void agregarTransportista(Transportista transportista) {
        if (transportistas == null) {
            transportistas = new ArrayList<Transportista>();
        }
        transportistas.add(transportista);
    }

    public void eliminarTransportista(Transportista transportista) {
        if (transportistas != null) {
            transportistas.remove(transportista);
        }
    }


    // Metodo para agregar un nuevo objeto Camion
    public void registrarCamion(int idCamion, String placa, String modelo, String marca, boolean disponibilidad,
            Ubicacion ubicacionProvincia) {
        Camion camion = new Camion(idCamion, placa, modelo, marca, disponibilidad, ubicacionProvincia);
        if (camiones == null) {
            camiones = new ArrayList<Camion>();
        }
        camiones.add(camion);
    }

    // Metodo para eliminar un objeto Camion
    public void eliminarCamion(int idCamion) {
        if (camiones != null) {
            for (Camion camion : camiones) {
                if (camion.getIdCamion() == idCamion) {
                    camiones.remove(camion);
                    break;
                }
            }
        }
    }

    // Método para asignar un camión a un transportista por ID de camión y cédula de
    // transportista
    public void asignarCamionATransportista(int idCamion, String cedulaTransportista) {
        Camion camionAsignar = null;
        Transportista transportistaAsignar = null;
        // Buscar el camión por ID
        for (Camion camion : camiones) {
            if (camion.getIdCamion() == idCamion) {
                camionAsignar = camion;
                break;
            }
        }
        // Buscar el transportista por cédula
        for (Transportista transportista : transportistas) {
            if (transportista.getCedula().equals(cedulaTransportista)) {
                transportistaAsignar = transportista;
                break;
            }
        }
        if (camionAsignar != null && transportistaAsignar != null) {
            camionTransportista.put(camionAsignar, transportistaAsignar);
        } else {
            System.out.println("El Camión o el Transportista no existen.");
        }
    }

    // Método para eliminar un camión de un transportista por ID de camión
    public void eliminarCamionDeTransportista(int idCamion) {
        Camion camionEliminar = null;

        // Buscar el camión por ID
        for (Camion camion : camiones) {
            if (camion.getIdCamion() == idCamion) {
                camionEliminar = camion;
                break;
            }
        }

        if (camionEliminar != null && camionTransportista.containsKey(camionEliminar)) {
            camionTransportista.remove(camionEliminar);
        } else {
            System.out.println("La relación Camión-Transportista no existe.");
        }
    }

    // Cargar y descargar paquetes de camiones
    // Método para cargar un paquete desde el inventario a un camión usando índices
    public void cargarPaqueteDesdeInventario(int camionIndex, int paqueteIndex) {
        // Verificamos si el índice del camión es válido
        if (camionIndex >= 0 && camionIndex < camiones.size()) {
            Camion camion = camiones.get(camionIndex); // Obtenemos el camión basado en el índice

            // Obtenemos la lista de paquetes del inventario
            ArrayList<Paquete> paquetesInventario = inventario.getPaquetesInventario();

            // Verificamos si el índice del paquete es válido
            if (paqueteIndex >= 0 && paqueteIndex < paquetesInventario.size()) {
                Paquete paquete = paquetesInventario.get(paqueteIndex); // Obtenemos el paquete basado en el índice

                // Llamamos al método que carga un paquete al camión
                cargarPaqueteACamion(camion, paquete);
            } else {
                System.out.println("El índice de paquete es inválido.");
            }
        } else {
            System.out.println("El índice de camión es inválido.");
        }
    }

    public void cargarPaqueteACamion(Camion camion, Paquete paquete) {
        if (camiones != null && camiones.contains(camion)) {
            if (camionPaquetes == null) {
                camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>();
            }
            if (camionPaquetes.containsKey(camion)) {
                // anadir logica para cambiar estado de paquete
                camionPaquetes.get(camion).add(paquete);
            } else {
                ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
                // anadir logica para cambiar estado de paquete
                paquetes.add(paquete);
                camionPaquetes.put(camion, paquetes);
            }
        } else {
            System.out.println("El Camion no existe.");
        }
    }

    public void descargarPaqueteDeCamion(Camion camion, Paquete paquete) {
        if (camionPaquetes != null && camionPaquetes.containsKey(camion)) {
            // anadir logica para cambiar estado de paquete
            camionPaquetes.get(camion).remove(paquete);
        } else {
            System.out.println("El Camion no tiene paquetes.");
        }
    }

    // Metodos para mostrar informacion

    public void mostrarCamiones() {
        if (camiones != null) {
            for (Camion camion : camiones) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo() + ", Marca: "
                        + camion.getMarca() + ", Disponibilidad: " + camion.isDisponibilidad() + ", Provincia: "
                        + camion.getUbicacionProvincia());
            }
        } else {
            System.out.println("No hay camiones registrados.");
        }
    }

    public void mostrarTransportistas() {
        if (transportistas != null) {
            for (Transportista transportista : transportistas) {
                System.out.println("Nombre: " + transportista.getNombre() + ", Cedula: ");
            }
        } else {
            System.out.println("No hay transportistas registrados.");
        }
    }


    public void mostrarCamionesTransportistas() {
        if (camionTransportista != null) {
            for (Camion camion : camionTransportista.keySet()) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo()
                        + ", Transportista: " + camionTransportista.get(camion).getNombre());
            }
        } else {
            System.out.println("No hay camiones asignados a transportistas.");
        }
    }

    public void mostrarCamionesPaquetes() {
        if (camionPaquetes != null) {
            for (Camion camion : camionPaquetes.keySet()) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo());
                for (Paquete paquete : camionPaquetes.get(camion)) {
                    System.out.println("Paquete: " + paquete.getId());
                }
            }
        } else {
            System.out.println("No hay camiones con paquetes.");
        }
    }

}
