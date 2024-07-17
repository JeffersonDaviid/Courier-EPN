package com.proyecto.courierepn;

import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Factura;
import BL.Facturacion.Tarifa;
import BL.Facturacion.TarifaDomicilio;
import BL.Facturacion.TarifaEnvio;
import UI.Facturacion.Facturacion;
import UI.Facturacion.FacturacionUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TOMMY
 */
public class CourierEPN {

    public static void main(String[] args) {
        Facturacion facturacion = new Facturacion();
        facturacion.setVisible(true);

        FacturacionUI facturacionUI = new FacturacionUI();
        facturacionUI.setVisible(true);

        // ejemploConsultaBaseDatos();
        // probarFacturacion();

    }

    public static void ejemploConsultaBaseDatos() {
        String sql = "SELECT * FROM prueba";

        try {
            ResultSet rs = DataHelper.getInstancia().executeQueryRead(sql);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, rs.getInt("id") + " " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }

    public static void probarFacturacion() {
        Tarifa envio = new TarifaEnvio(23, "pequeño", "Guayaquil", "Quito");
        envio.calcularPrecioEnvio();
        envio.mostrarCostoEnvio();

        envio = new TarifaDomicilio(envio);
        envio.calcularPrecioEnvio();
        envio.mostrarCostoEnvio();

        Factura.guardarFactura("correoCliente", "idPaquete", envio.getSubtotal(), envio.getTotal(),
                envio.getDescripcionTarifa());
        Factura.obtenerFactura(3, "idPaquete");
        Factura fa = Factura.obtenerFactura(3, "idPaquete");
        fa.getCorreoCliente();
    }
}
