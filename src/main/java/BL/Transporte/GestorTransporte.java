package BL.Transporte;

import java.util.ArrayList;
import java.util.HashMap;

import BL.Administracion.Transportista;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public class GestorTransporte {
    

    private Inventario inventario;
    private ArrayList<Camion> camiones;
    private ArrayList<Transportista> transportistas;
    private HashMap<Camion, Transportista> camionTransportista;
    private HashMap<Camion, ArrayList<Paquete>> camionPaquetes;

    public GestorTransporte(Inventario inventario, ArrayList<Camion> camiones, ArrayList<Transportista> transportistas,
            HashMap<Camion, Transportista> camionTransportista, HashMap<Camion, ArrayList<Paquete>> camionPaquetes) {
        this.inventario = inventario;
        this.camiones = camiones;
        this.transportistas = transportistas;
        this.camionTransportista = camionTransportista;
        this.camionPaquetes = camionPaquetes;
    }

    public void addTransportista(Transportista transportista) {
        if (transportistas == null) {
            transportistas = new ArrayList<Transportista>();
        }
        transportistas.add(transportista);
    }

    public void deleteTransportista(Transportista transportista) {
        if (transportistas != null) {
            transportistas.remove(transportista);
        }
    }

    public void addCamion(Camion camion) {
    if (camiones == null) {
        camiones = new ArrayList<Camion>();
    }
    camiones.add(camion);
    }

    public void deleteCamion(Camion camion) {
        if (camiones != null) {
            camiones.remove(camion);
        }
    }
    public void asignarCamionATransportista(Camion camion, Transportista transportista) {
        if (camiones != null && transportistas != null &&
            camiones.contains(camion) && transportistas.contains(transportista)) {
            
            if (camionTransportista == null) {
                camionTransportista = new HashMap<Camion, Transportista>();
            }
            camionTransportista.put(camion, transportista);
        } else {
            System.out.println("El Camion o el Transportista no existen.");
        }
    }

    public void eliminarCamionDeTransportista(Camion camion) {
        if (camionTransportista != null && camionTransportista.containsKey(camion)) {
            camionTransportista.remove(camion);
        } else {
            System.out.println("La relación Camion-Transportista no existe.");
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

    public void mostrarCamiones() {
        if (camiones != null) {
            for (Camion camion : camiones) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo());
            }
        } else {
            System.out.println("No hay camiones registrados.");
        }
    }

    public void mostrarTransportistas() {
        if (transportistas != null) {
            for (Transportista transportista : transportistas) {
                System.out.println("Nombre: " + transportista.getNombre() + ", Cedula: " );
            }
        } else {
            System.out.println("No hay transportistas registrados.");
        }
    }

    public void mostrarCamionesTransportistas() {
        if (camionTransportista != null) {
            for (Camion camion : camionTransportista.keySet()) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo() + ", Transportista: " + camionTransportista.get(camion).getNombre());
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
