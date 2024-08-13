package BL.Administracion;

import BL.Transporte.Ubicacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestorPerfiles {

    private static final String FILE_NAME = "src\\main\\java\\BL\\Serializables\\perfiles.ser";
    private static GestorPerfiles instance;
    private List<Perfil> perfiles;


    private GestorPerfiles() {
        perfiles = new ArrayList<>();
        loadPerfiles();
        initializeDefaultRecepcionista();
    }

    
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
        Perfil defaultRecepcionista = new Recepcionista("Admin", "Admin", "ADMIN001", "admin@example.com", "123", "0999999999" ,"QUITO");
        perfiles.add(defaultRecepcionista);
        savePerfiles();
        System.out.println("Recepcionista por defecto creado con éxito.");
    }


    public synchronized void registrarPerfil(Perfil nuevoPerfil) {
        if (verificarCedulaExistente(nuevoPerfil.getCedula())) {
            System.out.println("No se pudo agregar el usuario. La cédula ya está registrada.");
            return;
        }
        perfiles.add(nuevoPerfil);
        savePerfiles();
    }


    public synchronized Perfil login(String nombre, String contrasena, String rol) {
        List<Perfil> usuarios = getUsuarios();
        for (Perfil perfil : usuarios) {
            JOptionPane.showMessageDialog(null, perfil.getNombre()+" "+perfil.getContrasena());
            if (perfil.getNombre().equals(nombre) && perfil.getContrasena().equals(contrasena)) {
                if (rol.equals(perfil.getClass().getSimpleName())) {
                    return perfil;
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

    public synchronized List<Transportista> getTransportistas() {
        List<Transportista> transportistas = new ArrayList<>();
        for (Perfil perfil : this.perfiles) {
            if (perfil instanceof Transportista) {
                transportistas.add((Transportista)perfil);
            }
        }
        return transportistas;
    }

    public synchronized List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Perfil perfil : this.perfiles) {
            if (perfil instanceof Cliente) {
                clientes.add((Cliente)perfil);
            }
        }
        return clientes;
    }

    public synchronized Cliente getCliente(String cedula) {
        Cliente cliente = null;
        for (Perfil c : this.perfiles) {
            if (c instanceof Cliente && c.getCedula().equals(cedula)) {
                cliente = (Cliente) c;
            }
        }
        return cliente;
    }

    public synchronized List<Perfil> getUsuarios() {
        List<Perfil> usuarios = new ArrayList<>();
        for (Perfil perfil : this.perfiles) {
            if (perfil instanceof Cliente) {
                
            }else{
                usuarios.add(perfil);
            }
        }
        return usuarios;
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

    @SuppressWarnings("unchecked")
    private void loadPerfiles() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("No se encontró el archivo de perfiles o está vacío. Creando nuevo archivo.");
            savePerfiles(); 
            return;
        }
    
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            perfiles = (List<Perfil>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando un nuevo archivo.");
            savePerfiles(); 
        } catch (EOFException e) {
            System.out.println("El archivo de perfiles está vacío o corrupto. Se creará un nuevo archivo.");
            savePerfiles();
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
