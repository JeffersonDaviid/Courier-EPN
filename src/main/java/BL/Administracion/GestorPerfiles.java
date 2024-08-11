package BL.Administracion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPerfiles {
    private static final String ARCHIVO = "perfiles.ser";

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

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            perfiles = (ArrayList<Perfil>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error, retornamos una lista vacía
        }

        return perfiles;
    }

    // Método auxiliar para serializar la lista de perfiles
    private static void serializarPerfiles(ArrayList<Perfil> perfiles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(perfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los Transportistas
    public static ArrayList<Transportista> obtenerTodosLosTransportistas() {
        ArrayList<Perfil> perfiles = deserializarPerfiles();
        ArrayList<Transportista> transportistas = new ArrayList<>();

        // Filtrar las instancias de Transportista
        for (Perfil perfil : perfiles) {
            if (perfil instanceof Transportista) {
                Transportista transportista = (Transportista) perfil;
                transportistas.add(transportista);
            }
        }
        return transportistas;
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
