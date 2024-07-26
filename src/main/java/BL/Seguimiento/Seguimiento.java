package BL.Seguimiento;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.GestionPaquete.Paquete;

public class Seguimiento {

    public Seguimiento() {
    }

    public void verEstadoPaquete(String id, String destino) {
        Paquete paquete = null;
        // BUSQUEDA EN DESTINO

        // buscar en recepcion
        for (Paquete p : Global.getInstancia().buscarAgencia(destino).getRecepcion()
                .getPaquetesRecepcion()) {
            if (p.getId().equals(id)) {
                paquete = p;
                break;

            }
        }

        // buscar en inventario
        for (Paquete p : Global.getInstancia().buscarAgencia(destino).getInventario()
                .getPaquetesInventario()) {
            if (p.getId().equals(id)) {
                paquete = p;
                break;

            }
        }

        // buscar en camion carga
        for (Paquete p : Global.getInstancia().buscarAgencia(destino).getCamionCarga()
                .getPaquetesCamion()) {

            if (p.getId().equals(id)) {
                paquete = p;
                break;
            }
        }

        // buscar en camion entrega
        for (Paquete p : Global.getInstancia().buscarAgencia(destino).getCamionEntrega()
                .getPaquetesCamion()) {
            if (p.getId().equals(id)) {
                paquete = p;
                break;
            }
        }

        // BUSQUEDA EN ORIGEN
        if (paquete == null) {

            // buscar en recepcion
            for (Paquete p : Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion()
                    .getPaquetesRecepcion()) {
                if (p.getId().equals(id)) {
                    paquete = p;
                    break;

                }
            }

            // buscar en inventario
            for (Paquete p : Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                    .getPaquetesInventario()) {
                if (p.getId().equals(id)) {
                    paquete = p;
                    break;

                }
            }

            // buscar en camion carga
            for (Paquete p : Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionCarga()
                    .getPaquetesCamion()) {

                if (p.getId().equals(id)) {
                    paquete = p;
                    break;
                }
            }

            // buscar en camion entrega
            for (Paquete p : Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionEntrega()
                    .getPaquetesCamion()) {
                if (p.getId().equals(id)) {
                    paquete = p;
                    break;
                }
            }
        }

        // CONSULTAR EN LA BASE DE DATOS UNA VEZ QUE SE ENTREGA EL PAQUETE
        if (paquete != null) {
            String mensaje = "Historial de estados del paquete " + paquete.getId();
            for (int i = 0; i < paquete.getHistorialEstado().size(); i++) {
                mensaje += "\n" + paquete.getHistorialEstado().get(i).getEstado() + " - "
                        + paquete.getHistorialEstado().get(i).getFecha();
            }

            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "El paquete no se encuentra");
        }
    }
}