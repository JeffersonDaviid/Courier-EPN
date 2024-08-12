/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Administracion;

import javax.swing.JOptionPane;

import com.proyecto.courierepn.CourierEPN;

import BL.Administracion.Recepcionista;
import BL.Administracion.GestorPerfiles;
import BL.Administracion.Perfil;
import javax.swing.DefaultListModel;

/**
 *
 * @author Emilio
 */
public class RegistroReclamacionUI extends javax.swing.JPanel {
    Recepcionista usuarioActual;

    /**
     * Creates new form RegistroUsuariosUI
     */
    public RegistroReclamacionUI(Perfil usuario) {
        initComponents();
        this.usuarioActual = (Recepcionista) usuario;
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Perfil perfil : GestorPerfiles.getInstance().getClientes()) {
            model.addElement(perfil.getCedula() + " - " + perfil.getNombre() + " " + perfil.getApellido());
        }
        listaPaquetes.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultarPaquetes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textBoxIdPaquete = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textBoxCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPaquetes = new javax.swing.JList<>();
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
                // btnConsultarPaquetesActionPerformed(evt);
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

        jScrollPane1.setViewportView(listaPaquetes);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(13, 71, 161));
        jLabel11.setText("Lista de Paquetes del Cliente");

        comboBoxReclamacion.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Retraso ", "Extravío", "Daño en el paquete", "Paquete equivocado" }));
        comboBoxReclamacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReclamacionActionPerformed(evt);
            }
        });

        btnRegistrarReclamacion.setBackground(new java.awt.Color(13, 71, 161));
        btnRegistrarReclamacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarReclamacion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarReclamacion.setText("Registrar Reclamación");
        btnRegistrarReclamacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarReclamacionActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(13, 71, 161));
        jLabel10.setText("Registrar una Reclamación");

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
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                .addGap(70, 70, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRegistrarReclamacion)
                                                .addGap(155, 155, 155)))));
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
                                                        .addComponent(btnRegistrarReclamacion))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 68, Short.MAX_VALUE))
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
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));

        textBoxCedula.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarPaquetesActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {// GEN-FIRST:event_btnConsultarPaquetesActionPerformed

        // listaPaquetes.setModel(model);

        // JOptionPane.showMessageDialog(this, "Registro exitoso", "Éxito",
        // JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_btnConsultarPaquetesActionPerformed

    private void textBoxIdPaqueteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textBoxIdPaqueteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textBoxIdPaqueteActionPerformed

    private void textBoxCedulaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textBoxCedulaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textBoxCedulaActionPerformed

    private void comboBoxReclamacionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comboBoxReclamacionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_comboBoxReclamacionActionPerformed

    private void btnRegistrarReclamacionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegistrarReclamacionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnRegistrarReclamacionActionPerformed

    // Método para verificar si una cédula ecuatoriana es válida
    private boolean esCedulaValida(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }

        try {
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) {
                return false;
            }

            int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
            int suma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                suma += (digito > 9) ? digito - 9 : digito;
            }

            int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
            int decenaSuperior = ((suma + 9) / 10) * 10;
            return (decenaSuperior - suma) == digitoVerificador;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarPaquetes;
    private javax.swing.JButton btnRegistrarReclamacion;
    private javax.swing.JComboBox<String> comboBoxReclamacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaPaquetes;
    private javax.swing.JTextField textBoxCedula;
    private javax.swing.JTextField textBoxIdPaquete;
    // End of variables declaration//GEN-END:variables
}
