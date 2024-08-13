/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Administracion;

import BL.Administracion.Recepcionista;


/**
 *
 * @author Emilio
 */
public class RegistroCamionesCUI extends javax.swing.JPanel {

    /**
     * Creates new form RegistroUsuariosUI
     */
    Recepcionista recepcionista;
    public RegistroCamionesCUI(Recepcionista usuario) {
        initComponents();
        recepcionista = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        field_modelo = new javax.swing.JTextField();
        field_placa = new javax.swing.JTextField();
        btn_registrarCamion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        field_marca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jLabel2.setText("Placa:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Marca:");

        field_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_modeloActionPerformed(evt);
            }
        });

        field_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_placaActionPerformed(evt);
            }
        });

        btn_registrarCamion.setBackground(new java.awt.Color(13, 71, 161));
        btn_registrarCamion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_registrarCamion.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrarCamion.setText("Registrar Camión");
        btn_registrarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarCamionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(13, 71, 161));
        jLabel6.setText("Registro Camiones Carga");

        field_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_marcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btn_registrarCamion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(field_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(field_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addComponent(btn_registrarCamion)
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addContainerGap(385, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void field_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_modeloActionPerformed

    private void field_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_placaActionPerformed

    private void btn_registrarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarCamionActionPerformed
        String placa = field_placa.getText();
        String modelo = field_modelo.getText();
        String marca = field_marca.getText();
       

        if (validarPlaca(placa)) {
            recepcionista.agregarCamion(placa, modelo, marca, true, recepcionista.getSucursal());
            javax.swing.JOptionPane.showMessageDialog(this, "Camión registrado exitosamente.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Placa inválida. Asegúrate de que cumpla con el formato requerido.");
        }

        field_placa.setText("");
        field_modelo.setText("");
        field_marca.setText("");
        
    }//GEN-LAST:event_btn_registrarCamionActionPerformed

    private boolean validarPlaca(String placa) {
        // Longitud mínima
        if (placa.length() < 7) {
            return false;
        }

        // Contar letras y números
        int letras = 0;
        int numeros = 0;

        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (Character.isLetter(c)) {
                letras++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        // Validar que haya al menos 3 letras y 4 números
        return letras >= 3 && numeros >= 4;
    }

    private void field_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_marcaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrarCamion;
    private javax.swing.JTextField field_marca;
    private javax.swing.JTextField field_modelo;
    private javax.swing.JTextField field_placa;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}