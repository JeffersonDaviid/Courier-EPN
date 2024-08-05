/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Facturacion;

import BL.Facturacion.Factura;

/**
 *
 * @author TOMMY
 */
public class FacturaUI extends javax.swing.JFrame {

    /**
     * Creates new form Facturacion
     */
    public FacturaUI(Factura factura) {
        initComponents();
        String totalFormat = String.format("%.2f", factura.getTarifa().getTotal());
        String subtotalFormat = String.format("%.2f", factura.getTarifa().getSubtotal());
        String ivaFormat = String.format("%.2f",
                factura.getTarifa().getIva() * factura.getTarifa().getSubtotal() / 100);
        String ivaPorcentajeFormat = String.format("%.1f", factura.getTarifa().getIva());
        lblCodigoTracking.setText(factura.getPaquete().getId());
        lblFecha.setText(factura.getFecha());
        lblNombreRemitente.setText(factura.getPaquete().getNombreRemitente());
        lblDestinatario.setText(factura.getPaquete().getNombreDestinatario());
        lblCiudadOrigen.setText(factura.getPaquete().getAgenciaOrigen());
        lblCiudadDestino.setText(factura.getPaquete().getAgenciaDestino());
        lblDescripcionPaquete.setText(factura.getPaquete().getTamanio() + ", " + factura.getPaquete().getPeso() + "kg");
        lblDescripcionTarifa.setText(factura.getTarifa().getDescripcionTarifa());
        lblSubtotal.setText("$ " + subtotalFormat);
        lblIVA.setText("$ " + ivaFormat);
        lblIvaBdd.setText("Iva (" + ivaPorcentajeFormat + "%)");
        lblTotal.setText("$ " + totalFormat + "");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCodigoTracking = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNombreRemitente = new javax.swing.JLabel();
        lblCiudadOrigen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCiudadDestino = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDescripcionPaquete = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        lblIvaBdd = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblDescripcionTarifa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDestinatario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURA");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(34, 21, 19));
        jLabel1.setText("Tracking Number: ");

        lblCodigoTracking.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCodigoTracking.setForeground(new java.awt.Color(34, 21, 19));
        lblCodigoTracking.setText("JD92JL3J8DF8SJDFLJDF8");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Delivery Date: ");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setText("15 Julio 2024 12:15:32");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Delivery Details");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Remitente:");

        lblNombreRemitente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRemitente.setText("factura.getNombreRemitente");
        lblNombreRemitente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblCiudadOrigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudadOrigen.setText("Quito");
        lblCiudadOrigen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ciudad origen:");

        lblCiudadDestino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudadDestino.setText("Guayaquil");
        lblCiudadDestino.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Ciudad destino:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Paquete contenido:");

        lblDescripcionPaquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescripcionPaquete.setText("Grande, 42kg");
        lblDescripcionPaquete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Subtotal");

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtotal.setText("$ 100.00");
        lblSubtotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblIVA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIVA.setText("$ 15.00");
        lblIVA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblIvaBdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIvaBdd.setText("Iva (15%)");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(34, 21, 19));
        jLabel18.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(34, 21, 19));
        lblTotal.setText("$ 115.00");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Descripcion tarifas:");

        lblDescripcionTarifa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescripcionTarifa.setText("servicio a domicilio");
        lblDescripcionTarifa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Destinatario:");

        lblDestinatario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDestinatario.setText("Pepito");
        lblDestinatario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblDescripcionPaquete))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblCiudadOrigen))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblCiudadDestino))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblDescripcionTarifa))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblSubtotal))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(lblIvaBdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblIVA))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblTotal))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblCodigoTracking))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblFecha))
                                                        .addComponent(jLabel5))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNombreRemitente,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblDestinatario,
                                                                javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(lblCodigoTracking))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(lblFecha))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(lblNombreRemitente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblDestinatario))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(lblCiudadOrigen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(lblCiudadDestino))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(lblDescripcionPaquete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(lblDescripcionTarifa))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(lblSubtotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIvaBdd)
                                        .addComponent(lblIVA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(lblTotal))
                                .addContainerGap(33, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // /**
    // * @param args the command line arguments
    // * //
    // */
    // public static void main(String args[]) {
    // /* Set the Nimbus look and feel */
    // // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // // (optional) ">
    // /*
    // * If Nimbus (introduced in Java SE 6) is not available, stay with the
    // * default look and feel.
    // * For details see
    // * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    // */
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
    // .getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(
    // java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(
    // java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(
    // java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(
    // java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // // </editor-fold>

    // /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new Facturacion().setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCiudadDestino;
    private javax.swing.JLabel lblCiudadOrigen;
    private javax.swing.JLabel lblCodigoTracking;
    private javax.swing.JLabel lblDescripcionPaquete;
    private javax.swing.JLabel lblDescripcionTarifa;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblIvaBdd;
    private javax.swing.JLabel lblNombreRemitente;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
