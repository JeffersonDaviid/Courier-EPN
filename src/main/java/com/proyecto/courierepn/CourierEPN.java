package com.proyecto.courierepn;

import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Factura;
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
        TarifaEnvio envio = new TarifaEnvio();
        envio.calcularPrecioEnvio();
        System.out.println("Precio envio: " + envio.getPrecio());
        System.out.println("Descripcion: " + envio.getDescripcionTarifa());

        TarifaDomicilio envioDom = new TarifaDomicilio(envio);
        envioDom.calcularPrecioEnvio();
        System.out.println("Precio envio: " + envioDom.getPrecio());
        System.out.println("Descripcion: " + envioDom.getDescripcionTarifa());

        Factura factura = new Factura(1, 1, envioDom.getPrecio(), 15.0f, 115.0, "Envio express");
        // factura.guardarFactura();
        Factura.obtenerFactura(7);
    }
}
