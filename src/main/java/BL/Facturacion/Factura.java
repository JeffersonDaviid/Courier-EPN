package BL.Facturacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class Factura {
    private int idFactura;
    private String fecha;
    private Paquete paquete;
    private Tarifa tarifa;

    public Factura() {
    }

    /**
     * Constructor para obtener una factura de la base de datos
     */
    public Factura(Paquete paquete, Tarifa tarifa) {
        this.paquete = paquete;
        this.tarifa = tarifa;
    }

    public void guardarFactura() {
        fecha = String.format("%tF %tT", new java.util.Date(), new java.util.Date());
        int rs = -1;

        String sql = "INSERT INTO FACTURAS ( idPaquete, fecha, subtotal, iva, ivaPorcentaje, total, descripcionTarifa) VALUES ("
                + paquete.getId() + ", '" + fecha + "', " + tarifa.getSubtotal() + ", "
                + (tarifa.getSubtotal() * tarifa.getIva() / 100) + ", "
                + tarifa.getIva() + ", " + tarifa.getTotal() + ", '" + tarifa.getDescripcionTarifa() + "')";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Factura guardada con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);

                int idFactura = DataHelper.getInstancia().executeQueryReadLastId();
                this.idFactura = idFactura;

            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param codigo puede ser el ID de la factura o el ID del paquete
     * @return
     */
    public Factura buscarFactura(String codigo) {
        Factura factura = null;
        Paquete paquete = null;
        String sql = String.format(
                "SELECT * FROM FACTURAS fa JOIN PAQUETES pa on fa.idPaquete = pa.idPaquete WHERE fa.idFactura = %d OR fa.idPaquete = %d",
                codigo, codigo);

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {
                paquete = new Paquete(
                        rs.getString("pa.idPaquete"),
                        rs.getFloat("peso"),
                        rs.getString("tamanio"),
                        rs.getString("agenciaOrigen"),
                        rs.getString("agenciaDestino"),
                        rs.getString("nombreRemitente"),
                        rs.getString("correoRemitente"),
                        rs.getString("telefonoRemitente"),
                        rs.getString("nombreDestinatario"),
                        rs.getString("correoDestinatario"),
                        rs.getString("telefonoDestinatario"),
                        rs.getString("domicilio"),
                        rs.getString("fechaHoraLlegada"), rs.getString("fechaHoraSalida"));

                tarifa.setSubtotal(rs.getFloat("subtotal"));
                tarifa.setIva(rs.getFloat("ivaPorcentaje"));
                tarifa.setTotal(rs.getFloat("total"));
                tarifa.setDescripcionTarifa(rs.getString("descripcionTarifa"));

                factura = new Factura(paquete, tarifa);
                factura.idFactura = rs.getInt("idFactura");
                factura.fecha = rs.getString("fecha");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return factura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

}
