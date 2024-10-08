package BL.Facturacion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;
import UI.Facturacion.FacturaUI;

public class GestorFacturas {
    private static GestorFacturas gestorFacturas;
    private ArrayList<Factura> facturas = new ArrayList<>();
    private Factura factura = new Factura();

    private GestorFacturas(){
    }

    public static GestorFacturas getInstancia() {
        if (gestorFacturas == null) {
            gestorFacturas = new GestorFacturas();
            return gestorFacturas;
        }
        return gestorFacturas;
    }

    public void generarFactura(Paquete paquet) {
        factura.setPaquete(paquet);
        factura.setFechaRegistro(String.format("%tF %tT", new java.util.Date(), new java.util.Date()));
        facturas.add(factura);

        FacturaUI facturaUI = new FacturaUI(factura);
        facturaUI.setSize(380, 490);
        facturaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        facturaUI.setLocationRelativeTo(null);
        facturaUI.setVisible(true);
    }

    /**
     * 
     * @param tracking puede ser el ID de la factura o el ID del paquete
     * @return
     */
    public void buscarFactura(String tracking) {
        for (Factura factura : facturas) {
            if (factura.getPaquete().getTracking().equals(tracking)) {
                FacturaUI facturaUI = new FacturaUI(factura);
                facturaUI.setSize(380, 490);
                facturaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                facturaUI.setLocationRelativeTo(null);
                facturaUI.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro la factura");
    }

    public void actualizarFactura(String tacking, String observacion) {

        for (Factura factura : facturas) {
            if (factura.getPaquete().getTracking().equals(tacking)) {
                factura.setObservacion(observacion);
                factura.setFechaActualizacion(String.format("%tF %tT", new java.util.Date(), new java.util.Date()));
                JOptionPane.showMessageDialog(null, "Factura actualizada");
                return;
            }
        }
    }

    public Factura geFactura() {
        return factura;
    }

}
