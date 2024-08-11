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
        //this.inventario = Inventario.getInstance();
        this.inventario = inventario;
        this.camiones = camiones;
        this.transportistas = transportistas;
        this.camionTransportista = camionTransportista;
        this.camionPaquetes = camionPaquetes;
    }

    // Metodo para agregar un nuevo objeto Transportista
    // Este metodo deberia recibir los parametros necesarios para crear un objeto Transportista desde GUI
    public void registrarTransportista(String cedula, String usuario, String contrasena, String nombre, String apellido, String agencia) {
        // Error por constructor de Transportista, esperando que modifiquen el constructor 
        Transportista transportista = new Transportista(cedula, usuario, contrasena, nombre, apellido, agencia);
        if (transportistas == null) {
            transportistas = new ArrayList<Transportista>();
        }
        transportistas.add(transportista);
    }

    // Metodo para eliminar un objeto Transportista
    // Este metodo deberia recibir la cedula del transportista a eliminar
    public void eliminarTransportista(String cedula) {
        if (transportistas != null) {
            for (Transportista transportista : transportistas) {
                if (transportista.getCedula().equals(cedula)) {
                    transportistas.remove(transportista);
                    break;
                }
            }
        }
    }

    // Metodo para agregar un nuevo objeto Camion
    public void registrarCamion(int idCamion, String placa, String modelo, String marca, boolean disponibilidad, Ubicacion ubicacionProvincia) {
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

    // Asignar y eliminar camiones a transportistas
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
