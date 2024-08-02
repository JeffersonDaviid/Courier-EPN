package BL.Seguimiento;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BL.Administracion.Global;
import BL.GestionPaquete.Paquete;
import BL.BASEDEDATOS.DataHelper;

public class Seguimiento {

    public Seguimiento() {
    }

    public void verEstadoPaquete(String id, String destino) {
        Paquete paquete = null;

        // BUSQUEDA EN DESTINO Y ORIGEN
        paquete = buscarPaquete(id, destino);
        if (paquete == null) {
            paquete = buscarPaquete(id, Global.agenciaActual);
        }
        if (paquete == null) {
            ResultSet rs = obtenerDatosPaquete(id);
            if (rs != null) {
                try {
                    StringBuilder mensaje = new StringBuilder("Historial de estados del paquete " + id);
                    while (rs.next()) {
                        String estado = rs.getString("estado");
                        String fecha = rs.getString("fecha");
                        mensaje.append("\n").append(estado).append(" - ").append(fecha);
                    }
                    JOptionPane.showMessageDialog(null, mensaje.toString());
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al procesar los datos del paquete: " + e.getMessage());
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El paquete no se encuentra");
            }
        } else {
            String mensaje = "Historial de estados del paquete " + paquete.getId();
            for (int i = 0; i < paquete.getHistorialEstado().size(); i++) {
                mensaje += "\n" + paquete.getHistorialEstado().get(i).getEstado() + " - "
                        + paquete.getHistorialEstado().get(i).getFecha();
            }

            JOptionPane.showMessageDialog(null, mensaje);
        }
        /*
         * Paquete paquete = null;
         * // BUSQUEDA EN DESTINO
         * 
         * // buscar en recepcion
         * for (Paquete p : Global.getInstancia().buscarAgencia(destino).getRecepcion()
         * .getPaquetesRecepcion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * 
         * }
         * }
         * 
         * // buscar en inventario
         * for (Paquete p : Global.getInstancia().buscarAgencia(destino).getInventario()
         * .getPaquetesInventario()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * 
         * }
         * }
         * 
         * // buscar en camion carga
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(destino).getCamionCarga()
         * .getPaquetesCamion()) {
         * 
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         * 
         * // buscar en camion entrega
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(destino).getCamionEntrega()
         * .getPaquetesCamion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         * 
         * // BUSQUEDA EN ORIGEN
         * if (paquete == null) {
         * 
         * // buscar en recepcion
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion()
         * .getPaquetesRecepcion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * 
         * }
         * }
         * 
         * // buscar en inventario
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
         * .getPaquetesInventario()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * 
         * }
         * }
         * 
         * // buscar en camion carga
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionCarga()
         * .getPaquetesCamion()) {
         * 
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         * 
         * // buscar en camion entrega
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionEntrega()
         * .getPaquetesCamion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         * }
         * 
         * //CONSULTAR EN LA BASE DE DATOS UNA VEZ QUE SE ENTREGA EL PAQUETE
         * if (paquete==null){
         * obtenerDatosPaquete(id);
         * }
         * 
         * if (paquete != null) {
         * String mensaje = "Historial de estados del paquete " + paquete.getId();
         * for (int i = 0; i < paquete.getHistorialEstado().size(); i++) {
         * mensaje += "\n" + paquete.getHistorialEstado().get(i).getEstado() + " - "
         * + paquete.getHistorialEstado().get(i).getFecha();
         * }
         * 
         * JOptionPane.showMessageDialog(null, mensaje);
         * } else {
         * JOptionPane.showMessageDialog(null, "El paquete no se encuentra");
         * }
         */

    }

    public ResultSet obtenerDatosPaquete(String numeroGuia) {
        DataHelper dataHelper;
        ResultSet rs = null;
        try {
            dataHelper = DataHelper.getInstancia();
            String sql = "SELECT * FROM PaqueteEstados WHERE idPaquete = '"
                    + numeroGuia + "'";
            rs = dataHelper.executeQueryRead(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del paquete: " + e.getMessage());
        }
        return rs;
    }

    private Paquete buscarPaquete(String id, String agencia) {
        Paquete paquete = null;

        // buscar en recepcion
        for (Paquete p : Global.getInstancia().buscarAgencia(agencia).getRecepcion()
                .getPaquetesRecepcion()) {
            if (p.getId().equals(id)) {
                paquete = p;
                break;
            }
        }

        // buscar en inventario
        for (Paquete p : Global.getInstancia().buscarAgencia(agencia).getInventario()
                .getPaquetesInventario()) {
            if (p.getId().equals(id)) {
                paquete = p;
                break;
            }
        }

        // buscar en camion carga
        /*
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(agencia).getCamionCarga()
         * .getPaquetesCamion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         * 
         * // buscar en camion entrega
         * for (Paquete p :
         * Global.getInstancia().buscarAgencia(agencia).getCamionEntrega()
         * .getPaquetesCamion()) {
         * if (p.getId().equals(id)) {
         * paquete = p;
         * break;
         * }
         * }
         */

        return paquete;
    }
}