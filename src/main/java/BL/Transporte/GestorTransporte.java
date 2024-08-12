package BL.Transporte;



import java.util.ArrayList;
import java.util.HashMap;

import BL.Administracion.Transportista;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public class GestorTransporte {
    // yo solo cambio de estado cuando se carga un paquete en un camion
    // por asi decirlo hago una copia del paqute en mi lista de paquets del camion, y nunca saco el paquete de la lista de paquetes del inventario
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
        this.camiones = new ArrayList<Camion>(); // Incluir un metodo para cargar camiones quemados
        this.transportistas = new ArrayList<Transportista>(); // Incluir un metodo para cargar transportistas quemados
        this.camionTransportista = new HashMap<Camion, Transportista>(); // Consultar para quemar asignaciones
        this.camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>(); // Consultar para quemar asignaciones
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
    public void registrarCamion( String placa, String modelo, String marca, boolean disponibilidad,
             Ubicacion ubicacionDestino) {
        int idCamion = generarIdCamion();
        Camion camion = new Camion(idCamion, placa, modelo, marca, disponibilidad, ubicacionDestino);
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
    public void cargarPaqueteDesdeInventario(int idCamion, String trackingPaquete) {
        Camion camionAsignar = null;
        Paquete paqueteAsignar = null;
        // Buscar el camión por ID
        for (Camion camion : camiones) {
            if (camion.getIdCamion() == idCamion) {
                camionAsignar = camion;
                break;
            }
        }
        // Buscar el paquete por tracking
        for (Paquete paquete : inventario.getPaquetesParaEntregar()) { // obtengo paquetes para entregar
            if (paquete.getId().equals(trackingPaquete)) {
                paqueteAsignar = paquete;
                break;
            }
        }
        if (camionAsignar != null && paqueteAsignar != null) {
            if (camionAsignar.getUbicacionDestino().equals(paqueteAsignar.getAgenciaDestino())) { 
                // Esperando que paquete utilice clase enumerada de provincia
                cargarPaqueteACamion(camionAsignar, paqueteAsignar);
            } else {
                System.out.println("El Camión y el Paquete no están en la misma provincia.");
            }
            cargarPaqueteACamion(camionAsignar, paqueteAsignar);
        } else {
            System.out.println("El Camión o el Paquete no existen.");
        }
    }


    public void cargarPaqueteACamion(Camion camionAsignar, Paquete paqueteAsignar) {
        if (camiones != null && camiones.contains(camionAsignar)) {
            if (camionPaquetes == null) {
                camionPaquetes = new HashMap<Camion, ArrayList<Paquete>>();
            }
            if (camionPaquetes.containsKey(camionAsignar)) {
                // anadir logica para cambiar estado de paquete
                camionPaquetes.get(camionAsignar).add(paqueteAsignar);
                camionAsignar.incrementarCapacidadOcupada(camionAsignar.getCapacidadOcupada()+1);
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

    // Método para descargar un paquete de un camión a una sucursal 
    public Paquete descargarPaqueteEnSucursal(int idCamion, String trackingPaquete) {
        Camion camionAsignar = null;
        Paquete paqueteAsignar = null;
        // Buscar el camión por ID
        for (Camion camion : camiones) {
            if (camion.getIdCamion() == idCamion) {
                camionAsignar = camion;
                break;
            }
        }
        // Buscar el paquete por tracking
        for (Paquete paquete : camionPaquetes.get(camionAsignar)) {
            if (paquete.getId().equals(trackingPaquete)) {
                paqueteAsignar = paquete;
                break;
            }
        }
        if (camionAsignar != null && paqueteAsignar != null) {
            // verificar si el paquete se debe entregar a domicilio
            if (paqueteAsignar.getDomicilio() == null) {
                // cambiar el estado del paquete y retirarlo del camión
                camionPaquetes.get(camionAsignar).remove(paqueteAsignar);
                camionAsignar.reducirCapacidadOcupada(camionAsignar.getCapacidadOcupada() - 1);
                return paqueteAsignar;
            } else {
                System.out.println("El paquete se debe entregar a domicilio.");
            }
        } else {
            System.out.println("El Camión o el Paquete no existen.");
        }
        return null;
    }

   

    // Metodo para entregar paquetes Domicilio
    public void entregarPaqueteDomicilio(int idCamion, String trackingPaquete) {
        Camion camionAsignar = null;
        Paquete paqueteAsignar = null;
        // Buscar el camión por ID
        for (Camion camion : camiones) {
            if (camion.getIdCamion() == idCamion) {
                camionAsignar = camion;
                break;
            }
        }
        // Buscar el paquete por tracking
        for (Paquete paquete : camionPaquetes.get(camionAsignar)) {
            if (paquete.getId().equals(trackingPaquete)) {
                paqueteAsignar = paquete;
                break;
            }
        }
        if (camionAsignar != null && paqueteAsignar != null) {
            // verificar si el paquete se debe entregar a domicilio
            if (!paqueteAsignar.getDomicilio().equals(null)) {
                // anadir logica para cambiar estado de paquete
                camionPaquetes.get(camionAsignar).remove(paqueteAsignar);
                camionAsignar.reducirCapacidadOcupada(camionAsignar.getCapacidadOcupada() - 1);
            } else {
                System.out.println("El paquete se debe entregar en sucursal.");
            }
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
                        + camion.getUbicacionDestino());
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
