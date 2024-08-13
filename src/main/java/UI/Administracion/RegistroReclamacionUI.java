/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Administracion;

import BL.GestionPaquete.Paquete;
import BL.Administracion.Cliente;
import BL.Administracion.GestorPerfiles;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emilio
 */
public class RegistroReclamacionUI extends javax.swing.JPanel {
    Cliente cliente = null;
    ArrayList<Paquete> paquetes = new ArrayList<>();

    /**
     * Creates new form RegistroUsuariosUI
     */
    public RegistroReclamacionUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnConsultarPaquetes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textBoxIdPaquete = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textBoxCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        comboBoxReclamacion = new javax.swing.JComboBox<>();
        btnRegistrarReclamacion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        btnConsultarPaquetes.setBackground(new java.awt.Color(13, 71, 161));
        btnConsultarPaquetes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConsultarPaquetes.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarPaquetes.setText("Consultar Paquetes");
        btnConsultarPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnConsultarPaquetesActionPerformed(evt);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(13, 71, 161));
        jLabel6.setText("Consultar Paquetes del Cliente");

        jLabel7.setText("Id del Paquete:");

        textBoxIdPaquete.setToolTipText("");
        textBoxIdPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBoxIdPaqueteActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de Reclamación:");

        jLabel9.setText("Cédula:");

        textBoxCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBoxCedulaActionPerformed(evt);
            }
        });

        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Tracking", "Cédula", "Nombre Destinatario", "Sucursal Destino", "Estado"
                }));
        jScrollPane1.setViewportView(tablaPaquetes);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(13, 71, 161));
        jLabel11.setText("Lista de Paquetes del Cliente");

        comboBoxReclamacion.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Extraviado", "Dañado", "Retraso", "Equivocado" }));
        comboBoxReclamacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReclamacionActionPerformed(evt);
            }
        });

        btnRegistrarReclamacion.setBackground(new java.awt.Color(13, 71, 161));
        btnRegistrarReclamacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarReclamacion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarReclamacion.setText("Registrar Reclamo");
        btnRegistrarReclamacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarReclamacionActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(13, 71, 161));
        jLabel10.setText("Registrar una Reclamo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textBoxCedula, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(btnConsultarPaquetes))
                                        .addComponent(jLabel11)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRegistrarReclamacion)
                                                .addGap(155, 155, 155))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel7,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                100,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(textBoxIdPaquete,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                197,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                121,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(comboBoxReclamacion,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                197,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(70, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(textBoxCedula,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnConsultarPaquetes)
                                                .addGap(33, 33, 33)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(btnRegistrarReclamacion)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(textBoxIdPaquete,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(comboBoxReclamacion,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE)));
    }

    private void btnConsultarPaquetesActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {
        String cedula = textBoxCedula.getText();
        if (!esCedulaValida(cedula)) {
            JOptionPane.showMessageDialog(this, "Cédula inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cliente = GestorPerfiles.getInstance().getCliente(cedula);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        paquetes = cliente.obtenerPaquetes();
        DefaultTableModel model = (DefaultTableModel) tablaPaquetes.getModel();
        model.setRowCount(0); // Limpiar los datos anteriores

        for (Paquete paquete : paquetes) {
            model.addRow(new Object[] {
                    paquete.getTracking(),
                    paquete.getCliente().getCedula(),
                    paquete.getNombreDestinatario(),
                    paquete.getSucursalDestino(),
                    paquete.getEstado().toString()
            });
        }
    }

    private boolean esCedulaValida(String cedula) {
        // Validar cédula
        return true;
    }

    private void textBoxCedulaActionPerformed(java.awt.event.ActionEvent evt) {
        // Acciones al escribir la cédula
    }

    private void textBoxIdPaqueteActionPerformed(java.awt.event.ActionEvent evt) {
        // Acciones al escribir el ID del paquete
    }

    private void comboBoxReclamacionActionPerformed(java.awt.event.ActionEvent evt) {
        // Acciones al seleccionar el tipo de reclamación
    }

    private void btnRegistrarReclamacionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegistrarReclamacionActionPerformed
        String idPaquete = textBoxIdPaquete.getText();
        String problema = comboBoxReclamacion.getSelectedItem().toString();
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Primero debe ingresar una cedula y consultar sus paquetes", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        cliente.reportarProblema(idPaquete, problema);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnConsultarPaquetes;
    private javax.swing.JButton btnRegistrarReclamacion;
    private javax.swing.JComboBox<String> comboBoxReclamacion;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaquetes;
    private javax.swing.JTextField textBoxCedula;
    private javax.swing.JTextField textBoxIdPaquete;
    // End of variables declaration
}
