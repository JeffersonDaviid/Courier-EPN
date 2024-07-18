/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Transporte;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import BL.GestionPaquete.Paquete;
import BL.Transporte.Vehiculo;

/**
 *
 * @author saidl
 */
public class UITransporte extends javax.swing.JPanel {

    Vehiculo vehiculo = new Vehiculo();
    /**
     * Creates new form UITransporte
     */
    public UITransporte() {
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

        Panel_InfoCamion = new javax.swing.JPanel();
        ImgCamion = new javax.swing.JLabel();
        TxtCamion = new javax.swing.JLabel();
        txtModeloUIT = new javax.swing.JLabel();
        TxtMarca = new javax.swing.JLabel();
        TxtDisponible = new javax.swing.JLabel();
        txtMarcaCamion = new javax.swing.JLabel();
        txtModeloCamion = new javax.swing.JLabel();
        txtDisponibleCamion = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JLabel();
        BtnActualizar = new javax.swing.JButton();
        TxtInventario = new javax.swing.JLabel();
        TablaInventario = new javax.swing.JScrollPane();
        TablaListaInventario = new javax.swing.JTable();
        TxtInventario1 = new javax.swing.JLabel();
        TablaCargarPaquete = new javax.swing.JScrollPane();
        TablaListaInventarioCamion = new javax.swing.JTable();
        BtnAgrergar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();

        Panel_InfoCamion.setBackground(new java.awt.Color(37, 98, 234));

        ImgCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Transporte/Imagenes/camion.jpg"))); // NOI18N

        TxtCamion.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TxtCamion.setForeground(new java.awt.Color(255, 255, 255));
        TxtCamion.setText("CAMIÓN");

        txtModeloUIT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtModeloUIT.setForeground(new java.awt.Color(255, 255, 255));
        txtModeloUIT.setText("Modelo");

        TxtMarca.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        TxtMarca.setForeground(new java.awt.Color(255, 255, 255));
        TxtMarca.setText("Marca");

        TxtDisponible.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        TxtDisponible.setForeground(new java.awt.Color(255, 255, 255));
        TxtDisponible.setText("Disponible");

        txtMarcaCamion.setBackground(new java.awt.Color(255, 255, 255));
        txtMarcaCamion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMarcaCamion.setForeground(new java.awt.Color(255, 255, 255));

        txtModeloCamion.setBackground(new java.awt.Color(255, 255, 255));
        txtModeloCamion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtModeloCamion.setForeground(new java.awt.Color(255, 255, 255));

        txtDisponibleCamion.setBackground(new java.awt.Color(255, 255, 255));
        txtDisponibleCamion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDisponibleCamion.setForeground(new java.awt.Color(255, 255, 255));

        txtCapacidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCapacidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Panel_InfoCamionLayout = new javax.swing.GroupLayout(Panel_InfoCamion);
        Panel_InfoCamion.setLayout(Panel_InfoCamionLayout);
        Panel_InfoCamionLayout.setHorizontalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtMarca)
                            .addComponent(txtModeloUIT))
                        .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMarcaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InfoCamionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtModeloCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(TxtDisponible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDisponibleCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgCamion)
                            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(TxtCamion)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        Panel_InfoCamionLayout.setVerticalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(ImgCamion)
                .addGap(28, 28, 28)
                .addComponent(TxtCamion)
                .addGap(34, 34, 34)
                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModeloUIT)
                    .addComponent(txtModeloCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtMarca)
                                    .addComponent(txtMarcaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(TxtDisponible))
                            .addComponent(txtDisponibleCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 397, Short.MAX_VALUE))
                    .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        BtnActualizar.setBackground(new java.awt.Color(37, 101, 234));
        BtnActualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        TxtInventario.setBackground(new java.awt.Color(37, 98, 234));
        TxtInventario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TxtInventario.setText("CAMION");

        TablaListaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Paquete", "Traking Number", "Peso", "Tamanio", "Tipo de Envio", "Direccion Destino", "Sucursal Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaInventario.setViewportView(TablaListaInventario);

        TxtInventario1.setBackground(new java.awt.Color(37, 98, 234));
        TxtInventario1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TxtInventario1.setText("INVENTARIO");

        TablaListaInventarioCamion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Paquete", "Traking Number", "Peso", "Tamanio", "Tipo de Envio", "Direccion Destino", "Sucursal Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCargarPaquete.setViewportView(TablaListaInventarioCamion);

        BtnAgrergar.setBackground(new java.awt.Color(37, 101, 234));
        BtnAgrergar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnAgrergar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgrergar.setText("Agregar");
        BtnAgrergar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgrergarActionPerformed(evt);
            }
        });

        BtnGuardar.setBackground(new java.awt.Color(37, 101, 234));
        BtnGuardar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnActualizar)
                            .addComponent(TxtInventario)
                            .addComponent(TablaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TablaCargarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAgrergar))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardar)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(332, 332, 332)
                    .addComponent(TxtInventario1)
                    .addContainerGap(490, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnActualizar)
                .addGap(60, 60, 60)
                .addComponent(TablaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(TxtInventario)
                .addGap(18, 18, 18)
                .addComponent(TablaCargarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAgrergar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(BtnGuardar)
                .addGap(17, 17, 17))
            .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(TxtInventario1)
                    .addContainerGap(706, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgrergarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgrergarActionPerformed
        vehiculo.cambiarEstadoPaquete("Listo para Cargar", "En Transito");
        //vehiculo.cambiarEstadoPaquete("Entregado", "recibido");
        List<Paquete> paquetes = vehiculo.listarPaquetes("En Transito");

        // Obtener el modelo de la tabla de inventario del camión
        DefaultTableModel camionModel = (DefaultTableModel) TablaListaInventarioCamion.getModel();
        camionModel.setRowCount(0); // Limpiar la tabla de inventario del camión

        // Obtener el modelo de la tabla de inventario principal
        DefaultTableModel inventarioModel = (DefaultTableModel) TablaListaInventario.getModel();
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
    }//GEN-LAST:event_BtnAgrergarActionPerformed


    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
   // UITransportePaquetes uitp = new UITransportePaquetes();
    //AdminMenuPrincipal.ShowJPanel(uitp);
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        Vehiculo vehiculo = new Vehiculo(); 
        // Obtener la lista de paquetes con el estado "recibido"
        List<Paquete> paquetes = vehiculo.listarPaquetes("Listo para Cargar");

        // Crear el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) TablaListaInventario.getModel();
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

    }//GEN-LAST:event_BtnActualizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgrergar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JLabel ImgCamion;
    private javax.swing.JPanel Panel_InfoCamion;
    private javax.swing.JScrollPane TablaCargarPaquete;
    private javax.swing.JScrollPane TablaInventario;
    private javax.swing.JTable TablaListaInventario;
    private javax.swing.JTable TablaListaInventarioCamion;
    private javax.swing.JLabel TxtCamion;
    private javax.swing.JLabel TxtDisponible;
    private javax.swing.JLabel TxtInventario;
    private javax.swing.JLabel TxtInventario1;
    private javax.swing.JLabel TxtMarca;
    private javax.swing.JLabel txtCapacidad;
    private javax.swing.JLabel txtDisponibleCamion;
    private javax.swing.JLabel txtMarcaCamion;
    private javax.swing.JLabel txtModeloCamion;
    private javax.swing.JLabel txtModeloUIT;
    // End of variables declaration//GEN-END:variables
}
