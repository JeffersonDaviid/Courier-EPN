package BL.Transporte;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import BL.Administracion.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionCarga extends Camion {

    // Constructor
    public CamionCarga(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad,
            String agencia) {
        super(placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
    }

    // Métodos

    // Método para cargar paquete al camión
    public void cargarPaquete(String id) {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        Inventario inventario = Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario();
        for (Paquete p : inventario.getPaquetesParaCarga()) {
            if (p.getId().equals(id) && p.getDomicilio() == null) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino agencia destino"));
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido cargado al camión de carga");
                super.cambiarEstadoPaquetePorId(p.getId(), "En camino agencia destino");
                return;
            } else if (p.getId().equals(id) && p.getDomicilio() != null) {
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " tiene un domicilio asignado y no puede ser cargado al camión de carga", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        super.setPaquetesCamion(paquetesCamion);
    }

    // Método para descargar paquete del camión
    public void descargarPaquete() {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        Inventario inventario = Global.getInstancia().buscarAgencia(paquetesCamion.get(0).getAgenciaDestino())
                .getInventario();
        for (Paquete p : paquetesCamion) {
            inventario.agregarPaqueteDeCamionCarga(p);
            paquetesCamion.remove(p);
            JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido descargado del camión");
            super.cambiarEstadoPaquetePorId(p.getId(), "En agencia destino");
            return;
        }
        super.setPaquetesCamion(paquetesCamion);
    }
}
