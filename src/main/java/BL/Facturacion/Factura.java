package BL.Facturacion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;
import UI.Facturacion.FacturaUI;

public class Factura {
    private int idFactura;
    private String fechaRegistro;
    private String fechaActualizacion;
    private String observacion;
    private static Factura factura = new Factura();
    private static ArrayList<Factura> facturas = new ArrayList<>();
    private Paquete paquete;
    private Precio precio = new Precio();

    private Factura() {
    }

    public static Factura getIntancia() {
        if (factura == null) {
            return new Factura();
        }
        return factura;
    }

    public void generarFactura(Paquete paquete) {
        this.paquete = paquete;
        facturas.add(this);
        FacturaUI facturaUI = new FacturaUI(factura);

        facturaUI.setSize(380, 480);
        facturaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        facturaUI.setLocationRelativeTo(null);
        facturaUI.setVisible(true);

        int i = 1;
        for (Factura factura : facturas) {
            System.out.println(i + ": " + factura.getPaquete().getId());
            i++;
        }

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
                facturaUI.setSize(380, 480);
                facturaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                facturaUI.setLocationRelativeTo(null);
                facturaUI.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro la factura");
    }

    public void procesarDevolucion(String id, String observacion) {
        for (Factura factura : facturas) {
            if (factura.getPaquete().getId().equals(id)) {
                factura.setObservacion(observacion);
                factura.setFechaActualizacion(String.format("%tF %tT", new java.util.Date(), new java.util.Date()));

                FacturaUI facturaUI = new FacturaUI(factura);
                facturaUI.setSize(380, 480);
                facturaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                facturaUI.setLocationRelativeTo(null);
                facturaUI.setVisible(true);
                return;
            }
        }
    }

    public int getIdFactura() {
        return idFactura;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
