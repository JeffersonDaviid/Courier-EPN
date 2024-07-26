package BL.Transporte;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionCarga {
    private ArrayList<Paquete> paquetesCamion = new ArrayList<>();

    public CamionCarga() {
    }

    public void cargarPaquete(String id) {
        Inventario inventario = Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario();
        for (Paquete p : inventario.getPaquetesParaCarga()) {
            if (p.getId().equals(id)) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino agencia destino"));
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido cargado al camion de carga");
                return;
            }
        }
    }

    public void descargarPaquete() {
        Inventario inventario = Global.getInstancia().buscarAgencia(paquetesCamion.get(0).getAgenciaDestino())
                .getInventario();
        for (Paquete p : paquetesCamion) {
            inventario.agregarPaqueteDeCamionCarga(p);
            paquetesCamion.remove(p);
            JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido descargado del camion");
            return;
        }
    }

    public ArrayList<Paquete> getPaquetesCamion() {
        return paquetesCamion;
    }

}
