/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Administracion;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import BL.Administracion.Administrador;
import BL.Administracion.Usuario;
import UI.GestionPaquete.GestionPaquete;
import UI.SeguimientoPaquete.UISeguimiento;
import UI.Transporte.UICamionCarga;
import UI.Transporte.UICamionCargaDespachar;
import UI.Transporte.UICamionEntrega;
import UI.Transporte.UICamionEntregaDespachar;
import UI.Almacenamiento.HistorialnewUI;
import UI.Almacenamiento.InventarioUI;
import UI.Facturacion.FacturaUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Menu;

import javax.swing.JPanel;

/**
 *
 * @author Antonio
 */
public class MenuModulosUI extends javax.swing.JFrame {

    LoginUI loginUI;
    Usuario usuario; 

    /**
     * Creates new form Dashboard
     */
    public MenuModulosUI(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        InitStyles();
        InitContent();
    }
    
    private void InitStyles() {
        this.btn_admin.hide();
        this.btn_paquetes1.hide();
        this.btn_inv.hide();
        this.btn_hist.hide();
        this.btn_carga.hide();
        this.btn_cargaDespachar.hide();
        this.btn_camionEntrega.hide();
        this.btn_entregaDespachar.hide();
        this.btn_fact.hide();
        this.btn_env.hide();
        this.btn_seguimiento.hide();
        this.btn_regCamion.hide();
    }
    
    
    private void InitContent() {
        if(usuario.getClass().toString().equals("class BL.Administracion."+"Administrador")){
            this.btn_admin.show();
            this.btn_regCamion.show();
        }else if(usuario.getClass().toString().equals("class BL.Administracion."+"Recepcionista")){
            this.btn_seguimiento.show();
            this.btn_paquetes1.show();
            this.btn_fact.show();
            this.btn_env.show();
        }else if(usuario.getClass().toString().equals("class BL.Administracion."+"Bodeguero")){
            this.btn_hist.show();
            this.btn_inv.show();
        }else if(usuario.getClass().toString().equals("class BL.Administracion."+"Transportista")){
            this.btn_carga.show();
            this.btn_cargaDespachar.show();
            this.btn_camionEntrega.show();
            this.btn_entregaDespachar.show();
        }
    }

    private void showPanel(JPanel panel) {
    panel.setSize(978, 720);
    panel.setLocation(0, 0);

    jPanel2.removeAll();
    jPanel2.add(panel, BorderLayout.CENTER);
    jPanel2.revalidate();
    jPanel2.repaint();
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_inv = new javax.swing.JButton();
        btn_paquetes1 = new javax.swing.JButton();
        btn_admin = new javax.swing.JButton();
        btn_hist = new javax.swing.JButton();
        btn_carga = new javax.swing.JButton();
        btn_cargaDespachar = new javax.swing.JButton();
        btn_camionEntrega = new javax.swing.JButton();
        btn_entregaDespachar = new javax.swing.JButton();
        btn_fact = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_env = new javax.swing.JButton();
        btn_seguimiento = new javax.swing.JButton();
        btn_regCamion = new javax.swing.JButton();
        btn_regCamion1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 71, 161));

        btn_inv.setBackground(new java.awt.Color(13, 118, 207));
        btn_inv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_inv.setForeground(new java.awt.Color(255, 255, 255));
        btn_inv.setText("Inventario");
        btn_inv.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_invActionPerformed(evt);
            }
        });

        btn_paquetes1.setBackground(new java.awt.Color(13, 118, 207));
        btn_paquetes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_paquetes1.setForeground(new java.awt.Color(255, 255, 255));
        btn_paquetes1.setText("Gestión de Paquetes");
        btn_paquetes1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_paquetes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paquetes1ActionPerformed(evt);
            }
        });

        btn_admin.setBackground(new java.awt.Color(13, 118, 207));
        btn_admin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_admin.setForeground(new java.awt.Color(255, 255, 255));
        btn_admin.setText("Registro de Usuarios");
        btn_admin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminActionPerformed(evt);
            }
        });

        btn_hist.setBackground(new java.awt.Color(13, 118, 207));
        btn_hist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_hist.setForeground(new java.awt.Color(255, 255, 255));
        btn_hist.setText("Historial");
        btn_hist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_hist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_histActionPerformed(evt);
            }
        });

        btn_carga.setBackground(new java.awt.Color(13, 118, 207));
        btn_carga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_carga.setForeground(new java.awt.Color(255, 255, 255));
        btn_carga.setText("Camión Carga");
        btn_carga.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargaActionPerformed(evt);
            }
        });

        btn_cargaDespachar.setBackground(new java.awt.Color(13, 118, 207));
        btn_cargaDespachar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cargaDespachar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cargaDespachar.setText("Despachar paquetes Camión Carga");
        btn_cargaDespachar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_cargaDespachar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargaDespacharActionPerformed(evt);
            }
        });

        btn_camionEntrega.setBackground(new java.awt.Color(13, 118, 207));
        btn_camionEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_camionEntrega.setForeground(new java.awt.Color(255, 255, 255));
        btn_camionEntrega.setText("Camión Entrega");
        btn_camionEntrega.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_camionEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_camionEntregaActionPerformed(evt);
            }
        });

        btn_entregaDespachar.setBackground(new java.awt.Color(13, 118, 207));
        btn_entregaDespachar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_entregaDespachar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entregaDespachar.setText("Despachar paquetes Camión Entrega");
        btn_entregaDespachar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_entregaDespachar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entregaDespacharActionPerformed(evt);
            }
        });

        btn_fact.setBackground(new java.awt.Color(13, 118, 207));
        btn_fact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_fact.setForeground(new java.awt.Color(255, 255, 255));
        btn_fact.setText("Facturación");
        btn_fact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_factActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COURIER EPN");

        btn_env.setBackground(new java.awt.Color(13, 118, 207));
        btn_env.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_env.setForeground(new java.awt.Color(255, 255, 255));
        btn_env.setText("Envío");
        btn_env.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_env.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envActionPerformed(evt);
            }
        });

        btn_seguimiento.setBackground(new java.awt.Color(13, 118, 207));
        btn_seguimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_seguimiento.setForeground(new java.awt.Color(255, 255, 255));
        btn_seguimiento.setText("Seguimiento");
        btn_seguimiento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_seguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seguimientoActionPerformed(evt);
            }
        });

        btn_regCamion.setBackground(new java.awt.Color(13, 118, 207));
        btn_regCamion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_regCamion.setForeground(new java.awt.Color(255, 255, 255));
        btn_regCamion.setText("Registro de Camiones");
        btn_regCamion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_regCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regCamionActionPerformed(evt);
            }
        });

        btn_regCamion1.setBackground(new java.awt.Color(13, 118, 207));
        btn_regCamion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_regCamion1.setForeground(new java.awt.Color(255, 255, 255));
        btn_regCamion1.setText("Salir");
        btn_regCamion1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_regCamion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regCamion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_inv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_paquetes1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addComponent(btn_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addComponent(btn_hist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_carga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_cargaDespachar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_camionEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_entregaDespachar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_fact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_seguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_regCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_env, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btn_regCamion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(btn_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_paquetes1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hist, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargaDespachar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_camionEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_entregaDespachar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_env, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_seguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_regCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btn_regCamion1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_factActionPerformed
        showPanel(new FacturaUI(null));
    }//GEN-LAST:event_btn_factActionPerformed

    private void btn_entregaDespacharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entregaDespacharActionPerformed
        // TODO add your handling code here:
        showPanel(new UICamionEntregaDespachar());
    }//GEN-LAST:event_btn_entregaDespacharActionPerformed

    private void btn_camionEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_camionEntregaActionPerformed
        // TODO add your handling code here:
        showPanel(new UICamionEntrega());
    }//GEN-LAST:event_btn_camionEntregaActionPerformed
    

    private void btn_cargaDespacharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargaDespacharActionPerformed
        // TODO add your handling code here:
        showPanel(new UICamionCargaDespachar());
    }//GEN-LAST:event_btn_cargaDespacharActionPerformed

    private void btn_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargaActionPerformed
        // TODO add your handling code here:
        showPanel(new UICamionCarga());
    }//GEN-LAST:event_btn_cargaActionPerformed

    private void btn_histActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_histActionPerformed
        // TODO add your handling code here:
        showPanel(new HistorialnewUI());
    }//GEN-LAST:event_btn_histActionPerformed

    private void btn_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminActionPerformed
        showPanel(new RegistroUsuariosUI((Administrador) usuario));
    }//GEN-LAST:event_btn_adminActionPerformed

    private void btn_paquetes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paquetes1ActionPerformed
        // TODO add your handling code here:
        showPanel(new GestionPaquete());
    }//GEN-LAST:event_btn_paquetes1ActionPerformed

    private void btn_invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_invActionPerformed
        // TODO add your handling code here:
        showPanel(new InventarioUI());
    }//GEN-LAST:event_btn_invActionPerformed

    private void btn_envActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envActionPerformed
        showPanel(new );
    }//GEN-LAST:event_btn_envActionPerformed

    private void btn_seguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seguimientoActionPerformed
        showPanel(new UISeguimiento());
    }//GEN-LAST:event_btn_seguimientoActionPerformed

    private void btn_regCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regCamionActionPerformed
        showPanel(new RegistroCamionesUI((Administrador) usuario));
    }//GEN-LAST:event_btn_regCamionActionPerformed

    private void btn_regCamion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regCamion1ActionPerformed
        usuario = null;
        loginUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_regCamion1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuModulosUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_admin;
    private javax.swing.JButton btn_camionEntrega;
    private javax.swing.JButton btn_carga;
    private javax.swing.JButton btn_cargaDespachar;
    private javax.swing.JButton btn_entregaDespachar;
    private javax.swing.JButton btn_env;
    private javax.swing.JButton btn_fact;
    private javax.swing.JButton btn_hist;
    private javax.swing.JButton btn_inv;
    private javax.swing.JButton btn_paquetes1;
    private javax.swing.JButton btn_regCamion;
    private javax.swing.JButton btn_regCamion1;
    private javax.swing.JButton btn_seguimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
