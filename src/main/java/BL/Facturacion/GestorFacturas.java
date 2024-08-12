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

    public static GestorFacturas getInstancia() {
        if (gestorFacturas == null) {
            return new GestorFacturas();
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
     * @param codigo puede ser el ID de la factura o el ID del paquete
     * @return
     */
    public void buscarFactura(String codigo) {
        for (Factura factura : facturas) {
            if (factura.getPaquete().getId().equals(codigo)) {
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

    public Factura geFactura() {
        return factura;
    }

}
