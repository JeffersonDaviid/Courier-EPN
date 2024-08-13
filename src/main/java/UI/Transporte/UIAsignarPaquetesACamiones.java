/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Transporte;

import BL.Administracion.Cliente;
import BL.Administracion.Recepcionista;
import BL.Administracion.Transportista;
import BL.GestionPaquete.Paquete;
import BL.Transporte.Camion;
import BL.Transporte.GestorTransporte;
import BL.Transporte.Ubicacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*; 
import java.util.Scanner; 
import javax.swing.SwingUtilities;

/**
 *
 * @author saidl
 */
public class UIAsignarPaquetesACamiones extends javax.swing.JPanel {

    /**
     * Creates new form UIAsignarPaquetesACamiones
     */

     Recepcionista recepcionista;
    public UIAsignarPaquetesACamiones(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
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
        jPanel1 = new javax.swing.JPanel();
        TxtCamion1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePaquetesPorDestino = new javax.swing.JTable();
        cmbxSucursal = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        TextFieldIDCCamion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TextFieldMarcaCamion = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TextFieldPlacaCamion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        TextFieldModeloCamion = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        Ubicacion = new javax.swing.JLabel();
        txtUbicacionCamion = new javax.swing.JTextField();
        jButtonAsignarCamionPaquete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaquetesAsigandos = new javax.swing.JTable();

        Panel_InfoCamion.setBackground(new java.awt.Color(37, 98, 234));

        ImgCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Transporte/Imagenes/camion.jpg"))); // NOI18N

        TxtCamion.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TxtCamion.setForeground(new java.awt.Color(255, 255, 255));
        TxtCamion.setText("TRANSPORTE");

        javax.swing.GroupLayout Panel_InfoCamionLayout = new javax.swing.GroupLayout(Panel_InfoCamion);
        Panel_InfoCamion.setLayout(Panel_InfoCamionLayout);
        Panel_InfoCamionLayout.setHorizontalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InfoCamionLayout.createSequentialGroup()
                        .addComponent(ImgCamion)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InfoCamionLayout.createSequentialGroup()
                        .addComponent(TxtCamion)
                        .addGap(35, 35, 35))))
        );
        Panel_InfoCamionLayout.setVerticalGroup(
            Panel_InfoCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoCamionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(ImgCamion)
                .addGap(18, 18, 18)
                .addComponent(TxtCamion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(37, 98, 234));

        TxtCamion1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TxtCamion1.setForeground(new java.awt.Color(255, 255, 255));
        TxtCamion1.setText("ASIGNACIÓN DE PAQUETES ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(TxtCamion1)
                .addGap(253, 253, 253))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtCamion1)
                .addGap(23, 23, 23))
        );

        jPanel11.setBackground(new java.awt.Color(229, 255, 255));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setText("PAQUETE");

        jTablePaquetesPorDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tracking", "Peso", "Tamanio", "Origen", "Destino", "Direccion", "Destinatario", "Email", "Telefono", "Fecha de Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePaquetesPorDestino);

        cmbxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AMBATO", "AZOGUES", "BABAHOYO", "CUENCA", "ESMERALDAS", "GUAYAQUIL", "GUARANDA", "IBARRA", "LATACUNGA", "LOJA", "MACARA", "MANTA", "PORTOVIEJO", "PUYO", "QUITO", "RIOBAMBA", "RUMICHACA", "SANTO_DOMINGO", "TENA", "TULCAN", "ZAMORA", "LAGO_AGRIO" }));
        cmbxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel18))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(cmbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(229, 255, 255));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel20.setText("ID Camión");

        TextFieldIDCCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIDCCamionActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel21.setText("Placa");

        TextFieldMarcaCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldMarcaCamionActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel22.setText("Modelo");

        TextFieldPlacaCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPlacaCamionActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel23.setText("Marca");

        TextFieldModeloCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldModeloCamionActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel24.setText("CAMIÓN");

        Ubicacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Ubicacion.setText("Ubicación");

        txtUbicacionCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionCamionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(Ubicacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUbicacionCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldMarcaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldModeloCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(58, 58, 58)
                                .addComponent(TextFieldPlacaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldIDCCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(TextFieldPlacaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldIDCCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldModeloCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldMarcaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacionCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ubicacion))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButtonAsignarCamionPaquete.setBackground(new java.awt.Color(0, 0, 151));
        jButtonAsignarCamionPaquete.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonAsignarCamionPaquete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsignarCamionPaquete.setText("Asignar");
        jButtonAsignarCamionPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarCamionPaqueteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel14.setText("PAQUETES ASIGNADOS ");

        jTablePaquetesAsigandos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tracking", "Peso", "Tamanio", "Origen", "Destino", "Direccion", "Destinatario", "Email", "Telefono", "Fecha de Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablePaquetesAsigandos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAsignarCamionPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_InfoCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAsignarCamionPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldIDCCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIDCCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldIDCCamionActionPerformed

    private void TextFieldMarcaCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldMarcaCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldMarcaCamionActionPerformed

    private void TextFieldPlacaCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPlacaCamionActionPerformed
        // Ejecutar en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Obtener la placa del camión ingresada en el campo de texto
            String placaCamion = TextFieldPlacaCamion.getText().trim();

            // Obtener la instancia única de GestorTransporte
            GestorTransporte gestorTransporte = GestorTransporte.getInstancia();

            // Buscar el camión por placa
            Camion camion = gestorTransporte.obtenerCamionPorPlaca(placaCamion);

            // Si el camión es encontrado, mostrar su información en los campos de texto
            if (camion != null) {
                TextFieldIDCCamion.setText(String.valueOf(camion.getIdCamion()));
                TextFieldModeloCamion.setText(camion.getModelo());
                TextFieldMarcaCamion.setText(camion.getMarca());
                txtUbicacionCamion.setText(camion.getUbicacion());
            } else {
                // Limpiar los campos si el camión no es encontrado
                TextFieldIDCCamion.setText("");
                TextFieldModeloCamion.setText("");
                TextFieldMarcaCamion.setText("");
                txtUbicacionCamion.setText("");

                // Mostrar un mensaje indicando que el camión no se encontró
                JOptionPane.showMessageDialog(this, "Camión no encontrado.");
            }
        });
    }//GEN-LAST:event_TextFieldPlacaCamionActionPerformed

    private void TextFieldModeloCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldModeloCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldModeloCamionActionPerformed

    private void jButtonAsignarCamionPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarCamionPaqueteActionPerformed
        
        // Obtener la placa del camión seleccionado desde el ComboBox
        String placaCamion = (String) TextFieldPlacaCamion.getText();
        Ubicacion ubicacion = (Ubicacion) cmbxSucursal.getSelectedItem();
        recepcionista.asignarPaqueteACamion(placaCamion, ubicacion);
        Transportista transportista = GestorTransporte.getInstancia().obtenerTransportistaPorPlacaCamion(placaCamion);
        String cedulaTransportista = transportista.getCedula();
        // Paso 1: Obtener la lista de paquetes
        ArrayList<Paquete> listaPaquetes = recepcionista.consultarAsignacionPaquetesTransportista(cedulaTransportista);

        // Paso 2: Definir las columnas
        String[] columnas = {
            "Tracking", "Peso", "Tamanio", "Origen", "Destino", "Direccion", "Destinatario", "Email", "Telefono", "Fecha de Salida"
        };

        // Crear el modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Paso 3: Llenar el modelo con los datos de la lista
        for (Paquete paquete : listaPaquetes) {
            Object[] fila = {
                paquete.getTracking(),  // Asume que 'Paquete' tiene un método getTracking()
                paquete.getPeso(),      // Asume que 'Paquete' tiene un método getPeso()
                paquete.getTamanio(),   // Asume que 'Paquete' tiene un método getTamanio()
                paquete.getSucursalOrigen(),    // Asume que 'Paquete' tiene un método getOrigen()
                paquete.getSucursalDestino(),   // Asume que 'Paquete' tiene un método getDestino()
                paquete.getDireccion(), // Asume que 'Paquete' tiene un método getDireccion()
                paquete.getNombreDestinatario(), // Asume que 'Paquete' tiene un método getDestinatario()
                paquete.getCorreoDestinatario(),     // Asume que 'Paquete' tiene un método getEmail()
                paquete.getTelefonoDestinatario(),  // Asume que 'Paquete' tiene un método getTelefono()
                paquete.getFechaSalida() // Asume que 'Paquete' tiene un método getFechaSalida()
        };
        modelo.addRow(fila);
    }

    // Paso 4: Asignar el modelo al JTable
    jTablePaquetesAsigandos.setModel(modelo);
        
    }//GEN-LAST:event_jButtonAsignarCamionPaqueteActionPerformed
    
        
    private void txtUbicacionCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionCamionActionPerformed

    private void cmbxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxSucursalActionPerformed
    String ubicacion = (String) cmbxSucursal.getSelectedItem();
    if (ubicacion != null) {
        ArrayList<Paquete> paquetes = GestorTransporte.getInstancia().obtenerPaquetesPorDestino(ubicacion);
        actualizarTablaPaquetes(paquetes);
    }
} 

// Método para actualizar la tabla con los paquetes obtenidos
private void actualizarTablaPaquetes(ArrayList<Paquete> paquetes) {
    DefaultTableModel model = (DefaultTableModel) jTablePaquetesPorDestino.getModel();
    model.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas

    for (Paquete paquete : paquetes) {
        model.addRow(new Object[]{
            paquete.getTracking(),
            paquete.getPeso(),
            paquete.getTamanio(),
            paquete.getSucursalOrigen(),
            paquete.getSucursalDestino(),
            paquete.getDireccion(),
            paquete.getNombreDestinatario(), // Asume que 'Paquete' tiene un método getDestinatario()
            paquete.getCorreoDestinatario(),     // Asume que 'Paquete' tiene un método getEmail()
            paquete.getTelefonoDestinatario(),  // Asume que 'Paquete' tiene un método getTelefono()
            paquete.getFechaSalida() // Asume que 'Paquete' tiene un método getFechaSalida()
        });
    }
        
        
    }//GEN-LAST:event_cmbxSucursalActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgCamion;
    private javax.swing.JPanel Panel_InfoCamion;
    private javax.swing.JTextField TextFieldIDCCamion;
    private javax.swing.JTextField TextFieldMarcaCamion;
    private javax.swing.JTextField TextFieldModeloCamion;
    private javax.swing.JTextField TextFieldPlacaCamion;
    private javax.swing.JLabel TxtCamion;
    private javax.swing.JLabel TxtCamion1;
    private javax.swing.JLabel Ubicacion;
    private javax.swing.JComboBox<String> cmbxSucursal;
    private javax.swing.JButton jButtonAsignarCamionPaquete;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablePaquetesAsigandos;
    private javax.swing.JTable jTablePaquetesPorDestino;
    private javax.swing.JTextField txtUbicacionCamion;
    // End of variables declaration//GEN-END:variables
}
