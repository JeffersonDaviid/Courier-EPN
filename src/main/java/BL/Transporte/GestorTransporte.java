package BL.Transporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private static final String FILE_NAMEC = "src\\main\\java\\BL\\Serializables\\camiones.ser";
    private static final String FILE_NAMET = "src\\main\\java\\BL\\Serializables\\transportistas.ser";
    private static final String FILE_NAMECT = "src\\main\\java\\BL\\Serializables\\camionTransportista.ser";
    private static final String FILE_NAMECP = "src\\main\\java\\BL\\Serializables\\camionPaquetes.ser";
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
        inicializarArchivos();
        this.camiones = loadCamiones();  // Carga camiones desde el archivo
        this.transportistas = loadTransportistas();  // Carga transportistas desde el archivo
        this.camionTransportista = loadCamionTransportista();  // Carga asignación de camiones a transportistas desde el archivo
        this.camionPaquetes = loadCamionPaquete();  // Carga asignación de paquetes a camiones desde el archivo
    }

    // Método para verificar e inicializar archivos
    private void inicializarArchivos() {
        crearArchivoSiNoExiste(FILE_NAMEC);
        crearArchivoSiNoExiste(FILE_NAMET);
        crearArchivoSiNoExiste(FILE_NAMECT);
        crearArchivoSiNoExiste(FILE_NAMECP);
    }

    // Método para crear un archivo si no existe
    private void crearArchivoSiNoExiste(String archivo) {
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + archivo);
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Camion> loadCamiones() {
        // Carga los paquetes
        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(FILE_NAMEC))) {
            return (ArrayList<Camion>) ois1.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los camiones.");
            e.printStackTrace();
        }
        return new ArrayList<Camion>();
    }

    private void saveCamiones() {
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(FILE_NAMEC))) {
            oos1.writeObject(camiones);
        } catch (IOException e) {
            System.out.println("Error al guardar los transportistas.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Transportista> loadTransportistas() {
        // Carga los paquetes
        try (ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(FILE_NAMET))) {
            return (ArrayList<Transportista>) ois2.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los camiones.");
            e.printStackTrace();
        }
        return new ArrayList<Transportista>();
    }

    private void saveTransportistas() {
        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(FILE_NAMET))) {
            oos2.writeObject(transportistas);
        } catch (IOException e) {
            System.out.println("Error al guardar los transportistas.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private HashMap<Camion, Transportista> loadCamionTransportista() {
        // Carga los paquetes
        try (ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(FILE_NAMECT))) {
            return (HashMap<Camion, Transportista>) ois3.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los camiones.");
            e.printStackTrace();
        }
        return new HashMap<Camion, Transportista>();
    }

    private void saveCamionTransportista() {
        try (ObjectOutputStream ois3 = new ObjectOutputStream(new FileOutputStream(FILE_NAMECT))) {
            ois3.writeObject(camionTransportista);
        } catch (IOException e) {
            System.out.println("Error al guardar camiona transportista.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private HashMap<Camion, ArrayList<Paquete>> loadCamionPaquete() {
        // Carga los paquetes
        try (ObjectInputStream ois4 = new ObjectInputStream(new FileInputStream(FILE_NAMECP))) {
            return (HashMap<Camion, ArrayList<Paquete>>) ois4.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los camiones.");
            e.printStackTrace();
        }
        return new HashMap<Camion, ArrayList<Paquete>>();
    }

    private void saveCamionPaquete() {
        try (ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream(FILE_NAMECP))) {
            oos4.writeObject(camionPaquetes);
        } catch (IOException e) {
            System.out.println("Error al guardar paquete a camion.");
            e.printStackTrace();
        }
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
        saveTransportistas();
    }

    public void eliminarTransportista(Transportista transportista) {
        if (transportistas != null) {
            transportistas.remove(transportista);
            saveTransportistas();
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
        saveCamiones();
        camionPaquetes.put(camion, new ArrayList<Paquete>());
    }

    // Metodo para eliminar un objeto Camion
    public void eliminarCamion(Camion camion) {
        if (camiones != null) {
            camiones.remove(camion);
            saveCamiones();
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
    private ArrayList<Paquete> obtenerPaquetesPorDestino(Ubicacion destino) {
        ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
        for (Paquete paquete : inventario.getPaquetesParaEntregar()) {
            if (paquete.getSucursalDestino().equals(destino.name())) {
                paquetes.add(paquete);
            }
        }
        return paquetes;
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
            saveCamionTransportista();
        } else {
            System.out.println("El Camión o el Transportista no existen.");
        }
    }

    // Método para eliminar un camión de un transportista por ID de camión
    public void eliminarCamionDeTransportista(Camion camion) {
        if (camion != null && camionTransportista.containsKey(camion)) {
            camionTransportista.remove(camion);
            saveCamionTransportista();
        } else {
            System.out.println("La relación Camión-Transportista no existe.");
        }
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
                    inventario.notificarCambioEstado(paquete.getTracking());
                }
                saveCamionPaquete();
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
            } else {
                ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
                // anadir logica para cambiar estado de paquete
                paquetes.add(paqueteAsignar);
                camionPaquetes.put(camionAsignar, paquetes);
            }
            camionAsignar.incrementarCapacidadOcupada(1);
            saveCamionPaquete();
        } else {
            System.out.println("El Camion no existe.");
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
            camion.reducirCapacidadOcupada(1);
            saveCamionPaquete();
        } else {
            System.out.println("El Camión o el Paquete no existen.");
        }
    }

    // metodo para obtener la lista de paquetes que tiene asignado un transportista
    public ArrayList<Paquete> consultarAsignacionPaquetes(Transportista transportista) {
        ArrayList<Paquete> paquetes = new ArrayList<Paquete>();

        if (transportista != null) {
            // Itera sobre la relación camión-transportista
            for (Camion camion : camionTransportista.keySet()) {
                if (camionTransportista.get(camion).equals(transportista)) {
                    // Si el transportista está asignado a este camión, añade los paquetes del
                    // camión a la lista
                    if (camionPaquetes.containsKey(camion)) {
                        paquetes.addAll(camionPaquetes.get(camion));
                    }
                }
            }
        } else {
            System.out.println("El transportista proporcionado es nulo.");
        }

        return paquetes;
    }

    // Metodo para obtener el camion asignado a un transportista
    public Camion consultarCamionAsignado(Transportista transportista) {
        if (transportista != null) {
            // Itera sobre la relación camión-transportista
            for (Camion camion : camionTransportista.keySet()) {
                if (camionTransportista.get(camion).equals(transportista)) {
                    return camion;
                }
            }
        } else {
            System.out.println("El transportista proporcionado es nulo.");
        }
        return null;
    }

    public Transportista obtenerTransportistaPorPlacaCamion(String placa) {
        // Obtén el camión utilizando la placa
        Camion camion = obtenerCamionPorPlaca(placa);

        // Verifica si el camión existe y si está asociado a un transportista
        if (camion != null && camionTransportista.containsKey(camion)) {
            return camionTransportista.get(camion);
        } else {
            System.out.println("No se encontró un transportista asociado al camión con placa: " + placa);
            return null;
        }
    }

    // Metodos para mostrar informacion
    public void mostrarCamiones() {
        if (camiones != null && !camiones.isEmpty()) {
            for (Camion camion : camiones) {
                System.out.println("Placa: " + camion.getPlaca()
                        + ", Modelo: " + camion.getModelo()
                        + ", Marca: " + camion.getMarca()
                        + ", Disponibilidad: " + camion.isDisponibilidad()
                        + ", Provincia: " + camion.getUbicacion()
                        + ", Capacidad Total: " + camion.getCapacidadCarga()
                        + ", Capacidad Ocupada: " + camion.getCapacidadOcupada());
            }
        } else {
            System.out.println("No hay camiones registrados.");
        }
    }

    public void mostrarTransportistas() {
        if (transportistas != null && !transportistas.isEmpty()) {
            for (Transportista transportista : transportistas) {
                System.out.println("Nombre: " + transportista.getNombre()
                        + ", Apellido: " + transportista.getApellido()
                        + ", Cédula: " + transportista.getCedula()
                        + ", Correo: " + transportista.getCorreo()
                        + ", Contraseña: " + transportista.getContrasena());
            }
        } else {
            System.out.println("No hay transportistas registrados.");
        }
    }

    public void mostrarCamionesTransportistas() {
        if (camionTransportista != null && !camionTransportista.isEmpty()) {
            for (Camion camion : camionTransportista.keySet()) {
                Transportista transportista = camionTransportista.get(camion);
                System.out.println("Placa: " + camion.getPlaca()
                        + ", Modelo: " + camion.getModelo()
                        + ", Marca: " + camion.getMarca()
                        + ", Disponibilidad: " + camion.isDisponibilidad()
                        + ", Provincia: " + camion.getUbicacion()
                        + ", Transportista: " + transportista.getNombre()
                        + " " + transportista.getApellido()
                        + ", Cédula: " + transportista.getCedula()
                        + ", Correo: " + transportista.getCorreo());
            }
        } else {
            System.out.println("No hay camiones asignados a transportistas.");
        }
    }

    public void mostrarCamionesPaquetes() {
        if (camionPaquetes != null && !camionPaquetes.isEmpty()) {
            for (Camion camion : camionPaquetes.keySet()) {
                System.out.println("Placa: " + camion.getPlaca()
                        + ", Modelo: " + camion.getModelo()
                        + ", Marca: " + camion.getMarca()
                        + ", Disponibilidad: " + camion.isDisponibilidad()
                        + ", Provincia: " + camion.getUbicacion()
                        + ", Capacidad Total: " + camion.getCapacidadCarga()
                        + ", Capacidad Ocupada: " + camion.getCapacidadOcupada());
                for (Paquete paquete : camionPaquetes.get(camion)) {
                    System.out.println("  Paquete Tracking: " + paquete.getTracking()
                            + ", Peso: " + paquete.getPeso()
                            + ", Tamaño: " + paquete.getTamanio()
                            + ", Cliente: " + paquete.getCliente()
                            + ", Sucursal Origen: " + paquete.getSucursalOrigen()
                            + ", Sucursal Destino: " + paquete.getSucursalDestino()
                            + ", Dirección: " + paquete.getDireccion()
                            + ", Estado: " + paquete.getEstado());
                }
            }
        } else {
            System.out.println("No hay camiones con paquetes.");
        }
    }
}
