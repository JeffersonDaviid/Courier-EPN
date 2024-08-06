/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Transporte;

/**
 *
 * @author saidl
 */
public class UICamionEntrega extends javax.swing.JPanel {

    /**
     * Creates new form UICamionEntrega
     */
    public UICamionEntrega() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAgrergarCE = new javax.swing.JButton();
        Panel_InfoCamion = new javax.swing.JPanel();
        ImgCamion = new javax.swing.JLabel();
        TxtCamion = new javax.swing.JLabel();
        BtnGuardarCCD = new javax.swing.JButton();
        BtnActualizarCE = new javax.swing.JButton();
        TxtInventarioCE1 = new javax.swing.JLabel();
        TablaInventario = new javax.swing.JScrollPane();
        TablaListaInventarioCE = new javax.swing.JTable();
        TxtInventarioCE = new javax.swing.JLabel();
        TablaCargarPaquete = new javax.swing.JScrollPane();
        TablaListaInventarioCamionCE = new javax.swing.JTable();

        BtnAgrergarCE.setBackground(new java.awt.Color(37, 101, 234));
        BtnAgrergarCE.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnAgrergarCE.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgrergarCE.setText("Agregar");
        BtnAgrergarCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgrergarCEActionPerformed(evt);
            }
        });

        Panel_InfoCamion.setBackground(new java.awt.Color(37, 98, 234));

        ImgCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Transporte/Imagenes/camion.jpg"))); // NOI18N

        TxtCamion.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TxtCamion.setForeground(new java.awt.Color(255, 255, 255));
        TxtCamion.setText("CAMIÓN ENTREGA");

        javax.swing.GroupLayout Panel_InfoCamionLayout = new javax.swing.GroupLayout(Panel_InfoCamion);
        Panel_InfoCamion.setLayout(Panel_InfoCamionLayout);
        Panel_InfoCamionLayout.setHorizontalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(ImgCamion))
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(TxtCamion)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        Panel_InfoCamionLayout.setVerticalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(ImgCamion)
                .addGap(33, 33, 33)
                .addComponent(TxtCamion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnGuardarCCD.setBackground(new java.awt.Color(37, 101, 234));
        BtnGuardarCCD.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnGuardarCCD.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarCCD.setText("Guardar");
        BtnGuardarCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarCCDActionPerformed(evt);
            }
        });

        BtnActualizarCE.setBackground(new java.awt.Color(37, 101, 234));
        BtnActualizarCE.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnActualizarCE.setForeground(new java.awt.Color(255, 255, 255));
        BtnActualizarCE.setText("Actualizar");
        BtnActualizarCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarCEActionPerformed(evt);
            }
        });

        TxtInventarioCE1.setBackground(new java.awt.Color(37, 98, 234));
        TxtInventarioCE1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TxtInventarioCE1.setText("CAMION");

        TablaListaInventarioCE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_Paquete", "Peso", "Tamanio", "Remitente", "Agencia Origen", "Agencia Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaInventario.setViewportView(TablaListaInventarioCE);

        TxtInventarioCE.setBackground(new java.awt.Color(37, 98, 234));
        TxtInventarioCE.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TxtInventarioCE.setText("INVENTARIO");

        TablaListaInventarioCamionCE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_Paquete", "Peso", "Tamanio", "Remitente", "Agencia Origen", "Agencia Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCargarPaquete.setViewportView(TablaListaInventarioCamionCE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardarCCD)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnActualizarCE)
                            .addComponent(TxtInventarioCE1)
                            .addComponent(BtnAgrergarCE)
                            .addComponent(TxtInventarioCE)
                            .addComponent(TablaInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                            .addComponent(TablaCargarPaquete))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnActualizarCE)
                .addGap(22, 22, 22)
                .addComponent(TxtInventarioCE)
                .addGap(18, 18, 18)
                .addComponent(TablaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(TxtInventarioCE1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TablaCargarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BtnAgrergarCE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(BtnGuardarCCD)
                .addGap(17, 17, 17))
            .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgrergarCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgrergarCEActionPerformed
        vehiculo.cambiarEstadoPaquete("Listo para Cargar", "En Transito");
        //vehiculo.cambiarEstadoPaquete("Entregado", "recibido");
        //vehiculo.cambiarEstadoPaquete("Entregado", "recibido");
        List<Paquete> paquetes = vehiculo.listarPaquetes("En Transito"); // Obtener los paquet

        // Obtener el modelo de la tabla de inventario del camión
        DefaultTableModel camionModel = (DefaultTableModel) TablaListaInventarioCamionCE.getModel();
        camionModel.setRowCount(0); // Limpiar la tabla de inventario del camión

        // Obtener el modelo de la tabla de inventario principal
        DefaultTableModel inventarioModel = (DefaultTableModel) TablaListaInventarioCE.getModel();
        inventarioModel.setRowCount(0); // Limpiar la tabla de inventario principal

        // Agregar las filas correspondientes a TablaListaInventarioCamion
        for (Paquete paquete : paquetes) {
            Object[] row = new Object[7];
            row[0] = paquete.getId_paquete();
            row[1] = paquete.getTrackingNumber();
            row[2] = paquete.getPeso();
            row[3] = paquete.getTamanio();
            row[4] = paquete.getTipoEnvio();
            row[5] = paquete.getSucursalParaRecoger();
            row[6] = paquete.getSucursalAceptoPaquete();
            camionModel.addRow(row);
        }
        //vehiculo.cambiarEstadoPaquete("Retiro Transporte", "En Transito");
        //  List Vehiculo = vehiculo.listarPaquetes("En Transito");
        // cargar tabla 1(limpiar) y 2 (Cargar)
    }//GEN-LAST:event_BtnAgrergarCEActionPerformed

    private void BtnGuardarCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarCCDActionPerformed
        // UITransportePaquetes uitp = new UITransportePaquetes();
        //AdminMenuPrincipal.ShowJPanel(uitp);
    }//GEN-LAST:event_BtnGuardarCCDActionPerformed

    private void BtnActualizarCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarCEActionPerformed
        Vehiculo vehiculo = new Vehiculo();
        // Obtener la lista de paquetes con el estado "recibido"
        List<Paquete> paquetes = vehiculo.listarPaquetes("Listo para Cargar");

        // Crear el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) TablaListaInventarioCE.getModel();
        model.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con la información de los paquetes
        for (Paquete paquete : paquetes) {
            Object[] row = new Object[7]; // Ajusta este tamaño según el número de columnas en tu tabla
            row[0] = paquete.getId_paquete();
            row[1] = paquete.getTrackingNumber();
            row[2] = paquete.getPeso();
            row[3] = paquete.getTamanio();
            row[4] = paquete.getTipoEnvio();
            row[5] = paquete.getSucursalParaRecoger();
            row[6] = paquete.getSucursalAceptoPaquete();
            model.addRow(row);
        }
    }//GEN-LAST:event_BtnActualizarCEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizarCE;
    private javax.swing.JButton BtnAgrergarCE;
    private javax.swing.JButton BtnGuardarCCD;
    private javax.swing.JLabel ImgCamion;
    private javax.swing.JPanel Panel_InfoCamion;
    private javax.swing.JScrollPane TablaCargarPaquete;
    private javax.swing.JScrollPane TablaInventario;
    private javax.swing.JTable TablaListaInventarioCE;
    private javax.swing.JTable TablaListaInventarioCamionCE;
    private javax.swing.JLabel TxtCamion;
    private javax.swing.JLabel TxtInventarioCE;
    private javax.swing.JLabel TxtInventarioCE1;
    // End of variables declaration//GEN-END:variables
}
