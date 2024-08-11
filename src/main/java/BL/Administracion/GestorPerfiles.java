package BL.Administracion;

import BL.Transporte.Ubicacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPerfiles {

    private static final String FILE_NAME = "src\\main\\java\\BL\\Serializables\\perfiles.ser";
    private static GestorPerfiles instance;
    private List<Perfil> perfiles;

    // Private constructor to prevent instantiation
    private GestorPerfiles() {
        perfiles = new ArrayList<>();
        loadPerfiles();
        initializeDefaultRecepcionista();
    }

    // Public method to get the singleton instance
    public static synchronized GestorPerfiles getInstance() {
        if (instance == null) {
            instance = new GestorPerfiles();
        }
        return instance;
    }

    private void initializeDefaultRecepcionista() {
        if (verificarCedulaExistente("ADMIN001")) {
            return;
        }
        Perfil defaultRecepcionista = new Recepcionista("Admin", "Admin", "ADMIN001", "admin@example.com", "123", Ubicacion.QUITO);
        perfiles.add(defaultRecepcionista);
        savePerfiles();
        System.out.println("Recepcionista por defecto creado con éxito.");
    }

    // Método para registrar un perfil
    public synchronized void registrarPerfil(Perfil nuevoPerfil) {
        if (verificarCedulaExistente(nuevoPerfil.getCedula())) {
            System.out.println("No se pudo agregar el usuario. La cédula ya está registrada.");
            return;
        }
        perfiles.add(nuevoPerfil);
        savePerfiles();
    }

    // Método para realizar login
    public synchronized Perfil login(String nombre, String contrasena, String agencia, String rol) {
        for (Perfil perfil : perfiles) {
            if (perfil.getNombre().equals(nombre) && perfil.getContrasena().equals(contrasena)) {
                if (rol.equals(perfil.getClass().getSimpleName())) {
                    if (rol.equals("Recepcionista")) {
                        Recepcionista recepcionista = (Recepcionista) perfil;
                        if (recepcionista.getSucursal().name().equals(agencia)) {
                            return perfil;
                        }
                    } else {
                        return perfil;
                    }
                }
            }
        }
        return null;
    }

    // Método para obtener un Transportista por su cedula
    public synchronized Perfil obtenerTransportistaPorCedula(String cedula) {
        for (Perfil perfil : perfiles) {
            if (perfil instanceof Transportista && perfil.getCedula().equals(cedula)) {
                return perfil;
            }
        }
        return null;
    }

    // Método para verificar si una cédula ya está ingresada
    public synchronized boolean verificarCedulaExistente(String cedula) {
        for (Perfil perfil : perfiles) {
            if (perfil.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    private void loadPerfiles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            perfiles = (List<Perfil>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, which is expected for the first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los perfiles.");
            e.printStackTrace();
        }
    }

    private void savePerfiles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(perfiles);
        } catch (IOException e) {
            System.out.println("Error al guardar los perfiles.");
            e.printStackTrace();
        }
    }
}
