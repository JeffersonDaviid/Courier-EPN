package BL.Transporte;

import java.util.ArrayList;
import java.util.HashMap;

import BL.Administracion.Transportista;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Transportandose;

public class GestorTransporte {
    // yo solo cambio de estado cuando se carga un paquete en un camion
    // por asi decirlo hago una copia del paqute en mi lista de paquets del camion,
    // y nunca saco el paquete de la lista de paquetes del inventario
    private static GestorTransporte instancia;
    private Inventario inventario;
    private ArrayList<Camion> camiones;
    private ArrayList<Transportista> transportistas;
    private HashMap<Camion, Transportista> camionTransportista;
    private HashMap<Camion, ArrayList<Paquete>> camionPaquetes;

    private static int siguienteIdCamion = 1;

    // Constructor
    private GestorTransporte() {
        this.inventario = Inventario.getInstancia();
        this.camiones = new ArrayList<Camion>(); // metodo para cargar camiones desde .ser
        this.transportistas = new ArrayList<Transportista>(); // metodo para cargar transportistas desde .ser
        this.camionTransportista = new HashMap<Camion, Transportista>(); // Metodo para cargar asignacion de camiones transportistas .ser
        this.camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>(); // Metodo para cargar asignacion de paquetes a
                                                                         // camiones .ser
    }

    // Metodo para obtener la instancia de la clase
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

    // Metodo para generar un nuevo ID de camión
    private int generarIdCamion() {
        return siguienteIdCamion++;
    }

    // Metodo para agregar un nuevo objeto Camion
    public void registrarCamion(String placa, String modelo, String marca, boolean disponibilidad,
            Ubicacion ubicacion) {
        int idCamion = generarIdCamion();
        Camion camion = new Camion(idCamion, placa, modelo, marca, disponibilidad, ubicacion);
        if (camiones == null) {
            camiones = new ArrayList<Camion>();
        }
        camiones.add(camion);
        camionPaquetes.put(camion, new ArrayList<Paquete>());
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
    // Metodo para obtener el objeto camion por placa

    public Camion obtenerCamionPorPlaca(String placa) {
        if (camiones != null) {
            for (Camion camion : camiones) {
                if (camion.getPlaca().equals(placa)) {
                    return camion;
                }
            }
        }
        return null;
    }

    // Metodo para obtener el objeto Transportista por cédula
    public Transportista obtenerTransportistaPorCedula(String cedula) {
        if (transportistas != null) {
            for (Transportista transportista : transportistas) {
                if (transportista.getCedula().equals(cedula)) {
                    return transportista;
                }
            }
        }
        return null;
    }

    // Metodo para obtener los paquetes de inventario por la ciudad de destino
    @SuppressWarnings("unlikely-arg-type")
    private ArrayList<Paquete> obtenerPaquetesPorDestino(Ubicacion destino) {
        ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
        for (Paquete paquete : inventario.getPaquetesParaEntregar()) {
            if (paquete.getSucursalDestino().equals(destino)) {
                paquetes.add(paquete);
            }
        }
        return paquetes;
    }

    // Metodo para asignar un paquete a un camion por su ciudad de destino
    public boolean asignarPaqueteACamion(Camion camion, Ubicacion destino) {
        if (camion != null) {
            ArrayList<Paquete> paquetes = obtenerPaquetesPorDestino(destino);
            if (paquetes.size() > 0) {
                for (Paquete paquete : paquetes) {
                    inventario.buscarPaquete(paquete.getTracking()).cambiarEstado(new Transportandose(paquete));
                    cargarPaqueteACamion(camion, paquete);
                    // Incluir la logica para notificar a Inventario que se cambio el estado de los paquetes 
                }
                return true;
            } else {
                System.out.println("No hay paquetes para cargar en el camión.");
            }
        } else {
            System.out.println("El Camión no existe.");
        }
        return false;
    }

    // Metodo auxiliaar cargar paquete a camion en hashmap
    public void cargarPaqueteACamion(Camion camionAsignar, Paquete paqueteAsignar) {
        if (camiones != null && camiones.contains(camionAsignar)) {
            if (camionPaquetes == null) {
                camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>();
            }
            if (camionPaquetes.containsKey(camionAsignar)) {
                // anadir logica para cambiar estado de paquete
                camionPaquetes.get(camionAsignar).add(paqueteAsignar);
                camionAsignar.incrementarCapacidadOcupada(camionAsignar.getCapacidadOcupada() + 1);
            } else {
                ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
                // anadir logica para cambiar estado de paquete
                paquetes.add(paqueteAsignar);
                camionPaquetes.put(camionAsignar, paquetes);
                camionAsignar.incrementarCapacidadOcupada(camionAsignar.getCapacidadOcupada() + 1);

            }
        } else {
            System.out.println("El Camion no existe.");
        }
    }

    // Método para asignar un camión a un transportista por ID de camión y cédula de
    // transportista
    public void asignarTransportistaACamion(Transportista transportista, Camion camion) {
        if (camiones != null && camiones.contains(camion) && transportistas != null
                && transportistas.contains(transportista)) {
            if (camionTransportista == null) {
                camionTransportista = new HashMap<Camion, Transportista>();
            }
            camionTransportista.put(camion, transportista);
        } else {
            System.out.println("El Camión o el Transportista no existen.");
        }
    }

    // Método para eliminar un camión de un transportista por ID de camión
    public void eliminarCamionDeTransportista(Camion camion) {
        if (camion != null && camionTransportista.containsKey(camion)) {
            camionTransportista.remove(camion);
        } else {
            System.out.println("La relación Camión-Transportista no existe.");
        }
    }

    // Método para descargar un paquete de un camión a una sucursal
    public void eliminarPaqueteAsignado(Camion camion, String tracking) {
        Paquete paqueteABorrar = null;
        // Buscar el paquete por tracking
        for (Paquete paquete : camionPaquetes.get(camion)) {
            if (paquete.getTracking().equals(tracking)) {
                paqueteABorrar = paquete;
                break;
            }
        }
        if (camion != null && paqueteABorrar != null) {
            // cambiar el estado del paquete y retirarlo del camión
            camionPaquetes.get(camion).remove(paqueteABorrar);
            camion.reducirCapacidadOcupada(camion.getCapacidadOcupada() - 1);
        } else {
            System.out.println("El Camión o el Paquete no existen.");
        }
    }

    // Metodos para mostrar informacion

    public void mostrarCamiones() {
        if (camiones != null) {
            for (Camion camion : camiones) {
                System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo() + ", Marca: "
                        + camion.getMarca() + ", Disponibilidad: " + camion.isDisponibilidad() + ", Provincia: "
                        + camion.getUbicacion());
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
                    System.out.println("Paquete: " + paquete.getTracking());
                }
            }
        } else {
            System.out.println("No hay camiones con paquetes.");
        }
    }

}