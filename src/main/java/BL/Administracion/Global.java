package BL.Administracion;

import java.util.ArrayList;

public class Global {

    private static Global instancia;
    private static ArrayList<Agencia> agencias = new ArrayList<Agencia>();
    public static String agenciaActual;
    // private static Agencia agenciaActual; //COMPLICADO DE IMPLEMENTAR

    private Global() {
        cargarAgencias();
    }

    public static Global getInstancia() {
        if (instancia == null) {
            instancia = new Global();
        }
        return instancia;
    }

    public void cargarAgencias() {
        Agencia agencia1 = new Agencia("Quito");
        Agencia agencia2 = new Agencia("Guayaquil");
        Agencia agencia3 = new Agencia("Cuenca");

        agencias.add(agencia1);
        agencias.add(agencia2);
        agencias.add(agencia3);
    }

    public Agencia buscarAgencia(String nombre) {
        for (Agencia agencia : agencias) {
            if (agencia.getNombre().equals(nombre)) {
                return agencia;
            }
        }
        return null;
    }

}
