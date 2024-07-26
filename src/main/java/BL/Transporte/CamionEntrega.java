package BL.Transporte;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionEntrega extends Camion {

    public CamionEntrega(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad,
            String agencia) {
        super(placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
    }

    public void cargarPaquete(String id) {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        Inventario inventario = Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario();
        for (Paquete p : inventario.getPaquetesParaEnvioDomicilio()) {
            if (p.getId().equals(id)) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino a domicilio"));
                JOptionPane.showMessageDialog(null,
                        "El paquete " + p.getId() + " ha sido cargado al camion de entregas");
                return;
            }
        }
        super.setPaquetesCamion(paquetesCamion);
    }

    public void entregarPaquete(String id) {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        for (Paquete p : paquetesCamion) {
            if (p.getId().equals(id)) {
                Estado estado = new Estado("Entregado");
                p.agregarEstado(estado);// tambien en la base de datos

                // paquetesCamion.remove(p); // COMENTADO PARA PRUEBAS
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido entregado");
                return;
            }
        }
        super.setPaquetesCamion(paquetesCamion);
    }
}
