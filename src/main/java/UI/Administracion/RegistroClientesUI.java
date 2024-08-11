/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Administracion;

import javax.swing.JOptionPane;

import com.proyecto.courierepn.CourierEPN;

import BL.Administracion.Recepcionista;
import BL.Administracion.Perfil;

/**
 *
 * @author Emilio
 */
public class RegistroClientesUI extends javax.swing.JPanel {
    Recepcionista usuarioActual;

    /**
     * Creates new form RegistroUsuariosUI
     */
    public RegistroClientesUI(Perfil usuario) {
        initComponents();
        this.usuarioActual = (Recepcionista) usuario;
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_pass = new javax.swing.JTextField();
        comboBox_agencia = new javax.swing.JComboBox<>();
        btn_regUsuario = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        field_pass1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        field_pass2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        field_pass3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        field_pass4 = new javax.swing.JTextField();

        jLabel3.setText("Contraseña:");

        jLabel5.setText("Agencia:");

        field_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_passActionPerformed(evt);
            }
        });

        comboBox_agencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quito", "Guayaquil", "Cuenca" }));
        comboBox_agencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_agenciaActionPerformed(evt);
            }
        });

        btn_regUsuario.setBackground(new java.awt.Color(13, 71, 161));
        btn_regUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_regUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_regUsuario.setText("Registrar Usuario");
        btn_regUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(13, 71, 161));
        jLabel6.setText("Registro Clientes");

        jLabel7.setText("Nombre:");

        field_pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_pass1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Apellido:");

        field_pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_pass2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Cédula:");

        field_pass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_pass3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Correo:");

        field_pass4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_pass4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBox_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(321, 321, 321))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(field_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(field_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(field_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(field_pass3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(field_pass4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btn_regUsuario)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(field_pass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(field_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(field_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(field_pass4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(field_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBox_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(btn_regUsuario)
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void field_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_passActionPerformed

    private void btn_regUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regUsuarioActionPerformed
        String cedula = field_pass3.getText();
        String nombre = field_pass1.getText();
        String apellido = field_pass2.getText();
        String correo = field_pass4.getText();
        String pass = field_pass.getText();
        String rol = comboBox_rol.getSelectedItem().toString();
        String agencia = comboBox_agencia.getSelectedItem().toString();
    
        // Comprobación de cédula ecuatoriana válida
        if (!esCedulaValida(cedula)) {
            JOptionPane.showMessageDialog(this, "Cédula ecuatoriana no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener ejecución si la cédula no es válida
        }
    
        // Comprobación de correo válido
        if (!correo.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Correo no válido. Asegúrese de que contenga '@' y termine en un dominio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener ejecución si el correo no es válido
        }
    
        // Si todas las validaciones son correctas, proceder con el registro
        usuarioActual.agregarNuevoUsuario(agencia, pass, rol, cedula, nombre, apellido, correo);
       // JOptionPane.showMessageDialog(this, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_regUsuarioActionPerformed
      
    private void field_pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_pass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_pass1ActionPerformed

    private void field_pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_pass2ActionPerformed

    private void field_pass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_pass3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_pass3ActionPerformed

    private void field_pass4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_pass4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_pass4ActionPerformed

    private void comboBox_agenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_agenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_agenciaActionPerformed

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
            
            int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
            int suma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i+1)) * coeficientes[i];
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
    private javax.swing.JButton btn_regUsuario;
    private javax.swing.JComboBox<String> comboBox_agencia;
    private javax.swing.JTextField field_pass;
    private javax.swing.JTextField field_pass1;
    private javax.swing.JTextField field_pass2;
    private javax.swing.JTextField field_pass3;
    private javax.swing.JTextField field_pass4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
