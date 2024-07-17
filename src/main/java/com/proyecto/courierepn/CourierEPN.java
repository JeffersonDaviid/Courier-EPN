package com.proyecto.courierepn;

import BL.Administracion.Cliente;
import BL.Almacenamiento.Inventario;
import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Factura;
import BL.Facturacion.Tarifa;
import BL.Facturacion.TarifaDomicilio;
import BL.Facturacion.TarifaEnvio;
import BL.GestionPaquete.Paquete;
import BL.Transporte.CamionCarga;
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
        // LOGICA DE NEGOCIO

        // REGISTRAMOS UN CLIENTE
        Cliente cliente = new Cliente("1723456789", "pruebas@gmail.com", "1234", "Juan", "Perez");
        // cliente.guardarCliente(); // guarda en la base de datos

        Paquete paquete = new Paquete();
        paquete.setPeso(234);
        // set..... todos los atributos (se puede mejorar)

        // CALCULAR TARIFA DE ENVIO
        TarifaEnvio envio = new TarifaEnvio(paquete.getPeso(), paquete.getTamanio(), paquete.getSucursalAceptoPaquete(),
                paquete.getSucursalParaRecoger());
        envio.calcularPrecioEnvio();
        envio.mostrarCostoEnvio();

        // SI ACEPTA EL PRECIO DE ENVIO
        // guardar en db
        paquete.guardarPaquete(paquete);
        Factura.guardarFactura(cliente.getCorreo(), paquete.getId_paquete(), envio.getSubtotal(), envio.getTotal(),
                envio.getDescripcionTarifa());
        Inventario inventario = new Inventario();
        inventario.registrarPaquete("idPaquete");
        InventarioHistorial inventarioHistorial = new InventarioHistorial();
        inventarioHistorial.registrarPaquete("idPaquete");
        paquete.setEstado("EN INVENTARIO REMITENTE");

        // ENVIOS A SUCURSAL
        CamionCarga camion = new CamionCarga("modelo", "marca", 1000, true, null, null);
        camion.agregarPaquete("idPaquete"); // varios paquetes
        inventario.eliminarPaquete("idPaquete"); // varios paquetes
        inventarioHistorial.setFechaHoraSalida("idPaquete");
        camion.comerzarViaje("sucursalDestino"); // algo asi
        paquete.setEstado("EN CAMINO A SUCURSAL DESTINO");

        // LLEGA A SUCURSAL DESTINO
        paquete.setEstado("EN SUCURSAL DESTINO");
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

}
