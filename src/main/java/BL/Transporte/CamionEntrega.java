package BL.Transporte;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import BL.Administracion.Agencia;
import BL.Administracion.Global;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

public class CamionEntrega extends Camion {

    // constructor
    public CamionEntrega(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad,
            String agencia) {
        super(placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
    }

    // Métodos
    // Método para cargar paquete al camión
    public void cargarPaquete(String id) {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        Inventario inventario = Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario();
        for (Paquete p : inventario.getPaquetesParaEnvioDomicilio()) {
            if (p.getId().equals(id) && p.getDomicilio() != null) {
                paquetesCamion.add(inventario.retirarPaquete(id));
                p.agregarEstado(new Estado("En camino a domicilio"));
                JOptionPane.showMessageDialog(null,
                        "El paquete " + p.getId() + " ha sido cargado al camión de entregas");
                super.cambiarEstadoPaquetePorId(p.getId(), "En camino a domicilio");
                return;
            } else if (p.getId().equals(id) && p.getDomicilio() == null) {
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " no tiene un domicilio válido", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        super.setPaquetesCamion(paquetesCamion);
    }

    // Método para descargar paquete del camión
    public void entregarPaquete(String id) {
        ArrayList<Paquete> paquetesCamion = new ArrayList<>();
        paquetesCamion = super.getPaquetesCamion();
        for (Paquete p : paquetesCamion) {
            if (p.getId().equals(id)) {
                Estado estado = new Estado("Entregado");
                p.agregarEstado(estado);// tambien en la base de datos

                // paquetesCamion.remove(p); // COMENTADO PARA PRUEBAS
                JOptionPane.showMessageDialog(null, "El paquete " + p.getId() + " ha sido entregado");
                super.cambiarEstadoPaquetePorId(p.getId(), "Entregado a domicilio");
                return;
            }
        }
        super.setPaquetesCamion(paquetesCamion);
    }

    public void mostrarListaCamionesEntrega() {
        Agencia agencia = Global.getInstancia().buscarAgencia(Global.agenciaActual);
        ArrayList<CamionEntrega> camionesEntrega = agencia.getCamionesEntrega();

        // Iterar sobre la lista y mostrar la información de los camiones
        for (CamionEntrega camion : camionesEntrega) {
            System.out.println("Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo());
        }
}

}
