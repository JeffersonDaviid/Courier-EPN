package BL.Transporte;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class FlotaCamiones {
    private static FlotaCamiones instancia;
    private Map<String, Camion> camiones;

    private FlotaCamiones() {
        camiones = new HashMap<>();
    }

    public static FlotaCamiones getInstance() {
        if (instancia == null) {
            instancia = new FlotaCamiones();
        }
        return instancia;
    }

    public void agregarCamion(String sucursal, Camion camion) {
        camiones.put(sucursal + "-" + camion.getPlaca(), camion);
    }

    public Camion obtenerCamion(String sucursal, String placa) {
        return camiones.get(sucursal + "-" + placa);
    }

     public void mostrarCamiones(String sucursal) {
        StringBuilder info = new StringBuilder("Camiones de la sucursal " + sucursal + ":\n");
        for (Map.Entry<String, Camion> entry : camiones.entrySet()) {
            if (entry.getKey().startsWith(sucursal)) {
                info.append(entry.getValue().toString()).append("\n");
            }
        }
        // Muestra la información en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, info.toString(), "Camiones en la Sucursal", JOptionPane.INFORMATION_MESSAGE);
    }
}