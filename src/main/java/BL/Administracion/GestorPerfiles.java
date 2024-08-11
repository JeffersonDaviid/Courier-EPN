package BL.Administracion;

import java.io.*;
import java.util.ArrayList;

public class GestorPerfiles {

    // Método para registrar un perfil
    public static void registrarPerfil(Perfil nuevoPerfil) {
        ArrayList<Perfil> perfiles = deserializarPerfiles();
        
        // Verificar si el perfil ya existe antes de agregarlo
        for (Perfil perfil : perfiles) {
            if (perfil.getNombre().equals(nuevoPerfil.getNombre()) &&
                perfil.getAgencia().equals(nuevoPerfil.getAgencia())) {
                System.out.println("El perfil ya existe.");
                return;
            }
        }

        // Agregar el nuevo perfil a la lista
        perfiles.add(nuevoPerfil);

        // Serializar la lista de vuelta en el archivo
        serializarPerfiles(perfiles);
    }

    // Método para realizar login
    public static Perfil login(String nombre, String contrasena, String agencia, String rol) {
        ArrayList<Perfil> perfiles = deserializarPerfiles();

        // Buscar el perfil en la lista deserializada
        for (Perfil perfil : perfiles) {
            if (perfil.getNombre().equals(nombre) &&
                perfil.getContrasena().equals(contrasena) &&
                perfil.getAgencia().equals(agencia)) {

                // Determinar la clase hija a retornar
                if (perfil instanceof Cliente && rol.equals("Cliente")) {
                    return perfil;
                } else if (perfil instanceof Recepcionista && rol.equals("Recepcionista")) {
                    return perfil;
                } else if (perfil instanceof Transportista && rol.equals("Transportista")) {
                    return perfil;
                }
            }
        }

        return null; // Si no se encuentra un perfil coincidente, retornar null
    }

    // Método auxiliar para deserializar la lista de perfiles
    private static ArrayList<Perfil> deserializarPerfiles() {
        ArrayList<Perfil> perfiles = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\main\\java\\BL\\serializables\\perfiles.ser"))) {
            perfiles = (ArrayList<Perfil>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error, retornamos una lista vacía
        }

        return perfiles;
    }

    // Método auxiliar para serializar la lista de perfiles
    private static void serializarPerfiles(ArrayList<Perfil> perfiles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\BL\\serializables\\perfiles.ser"))) {
            oos.writeObject(perfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para deserializar la lista de clientes
    private static ArrayList<Cliente> deserializarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\main\\java\\BL\\serializables\\clientes.ser"))) {
            clientes = (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error, retornamos una lista vacía
        }

        return clientes;
    }

    // Método auxiliar para serializar la lista de clientes
    private static void serializarClientes(ArrayList<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\BL\\serializables\\clientes.ser"))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para registrar un perfil
    public static void registrarCLiente(Cliente nuevoCliente) {
        if(checkCliente(nuevoCliente.getCedula())) {
            return;
        }
        ArrayList<Cliente> clientes = deserializarClientes();
        // Agregar el nuevo perfil a la lista
        clientes.add(nuevoCliente);

        // Serializar la lista de vuelta en el archivo
        serializarClientes(clientes);
    }

    public static boolean checkCliente(String cedula) {
        ArrayList<Cliente> clientes = deserializarClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                System.out.println("El cliente ya existe.");
                return true;
            }
        }
        return false;
    }

    // public static void main(String[] args) {
    //     // Código para registrar un perfil
    //     Perfil nuevoPerfil = new Recepcionista("Damaris", "Suquillo", "123456789", "damaris@example.com", "123", "Quito");
    //     GestorPerfiles.registrarPerfil(nuevoPerfil);

    //     // Código para hacer login
    //     Perfil perfil = GestorPerfiles.login("Damaris", "123", "Quito", "Recepcionista");
    //     if (perfil != null) {
    //         System.out.println("Login exitoso: " + perfil.getClass().getSimpleName());
    //     } else {
    //         System.out.println("Login fallido");
    //     }
    // }
}
