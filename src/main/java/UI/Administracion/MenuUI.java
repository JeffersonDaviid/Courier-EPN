/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Administracion;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.proyecto.courierepn.CourierEPN;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 *
 * @author Antonio
 */
public class MenuUI extends javax.swing.JFrame {

    LoginUI loginUI;

    /**
     * Creates new form Dashboard
     */
    public MenuUI() {
        initComponents();
        InitStyles();
        InitContent();
    }

    private void InitStyles() {
    }

    private void InitContent() {
    }

    private void showPanel(JPanel panel) {
        panel.setSize(978, 720);
        panel.setLocation(0, 0);

        jPanel3.removeAll();
        jPanel3.add(panel, BorderLayout.CENTER);
        jPanel3.revalidate();
        jPanel3.repaint();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_op3 = new javax.swing.JButton();
        btn_op4 = new javax.swing.JButton();
        btn_op6 = new javax.swing.JButton();
        btn_op7 = new javax.swing.JButton();
        btn_op8 = new javax.swing.JButton();
        btn_op9 = new javax.swing.JButton();
        btn_op10 = new javax.swing.JButton();
        btn_op11 = new javax.swing.JButton();
        btn_op12 = new javax.swing.JButton();
        btn_op13 = new javax.swing.JButton();
        btn_op14 = new javax.swing.JButton();
        btn_op15 = new javax.swing.JButton();
        btn_op16 = new javax.swing.JButton();
        btn_op2 = new javax.swing.JButton();
        btn_op5 = new javax.swing.JButton();
        btn_op17 = new javax.swing.JButton();
        btn_op1 = new javax.swing.JButton();
        btn_op18 = new javax.swing.JButton();
        btn_op19 = new javax.swing.JButton();
        btn_op20 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 71, 161));

        btn_op3.setBackground(new java.awt.Color(32, 95, 193));
        btn_op3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op3.setForeground(new java.awt.Color(255, 255, 255));
        btn_op3.setText("Registrar Paquete Inventario");
        btn_op3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op3ActionPerformed(evt);
            }
        });

        btn_op4.setBackground(new java.awt.Color(32, 95, 193));
        btn_op4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op4.setForeground(new java.awt.Color(255, 255, 255));
        btn_op4.setText("Mostrar Paquete Inventario");
        btn_op4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op4ActionPerformed(evt);
            }
        });

        btn_op6.setBackground(new java.awt.Color(32, 95, 193));
        btn_op6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op6.setForeground(new java.awt.Color(255, 255, 255));
        btn_op6.setText("Cargar Paquetes a Camión Carga");
        btn_op6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op6ActionPerformed(evt);
            }
        });

        btn_op7.setBackground(new java.awt.Color(32, 95, 193));
        btn_op7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op7.setForeground(new java.awt.Color(255, 255, 255));
        btn_op7.setText("Descargar en Agencia Destino");
        btn_op7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op7ActionPerformed(evt);
            }
        });

        btn_op8.setBackground(new java.awt.Color(32, 95, 193));
        btn_op8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op8.setForeground(new java.awt.Color(255, 255, 255));
        btn_op8.setText("Cargar Paquetes a Camión Entrega");
        btn_op8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op8ActionPerformed(evt);
            }
        });

        btn_op9.setBackground(new java.awt.Color(32, 95, 193));
        btn_op9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op9.setForeground(new java.awt.Color(255, 255, 255));
        btn_op9.setText("Entregar Paquete desde Camión");
        btn_op9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op9ActionPerformed(evt);
            }
        });

        btn_op10.setBackground(new java.awt.Color(32, 95, 193));
        btn_op10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op10.setForeground(new java.awt.Color(255, 255, 255));
        btn_op10.setText("Entregar Paquete desde Recepción");
        btn_op10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op10ActionPerformed(evt);
            }
        });

        btn_op11.setBackground(new java.awt.Color(32, 95, 193));
        btn_op11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op11.setForeground(new java.awt.Color(255, 255, 255));
        btn_op11.setText("Seguimiento del Paquete");
        btn_op11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op11ActionPerformed(evt);
            }
        });

        btn_op12.setBackground(new java.awt.Color(32, 95, 193));
        btn_op12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op12.setForeground(new java.awt.Color(255, 255, 255));
        btn_op12.setText("Mostrar Historial");
        btn_op12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op12ActionPerformed(evt);
            }
        });

        btn_op13.setBackground(new java.awt.Color(32, 95, 193));
        btn_op13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op13.setForeground(new java.awt.Color(255, 255, 255));
        btn_op13.setText("Consultar Historial por ID");
        btn_op13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op13ActionPerformed(evt);
            }
        });

        btn_op14.setBackground(new java.awt.Color(32, 95, 193));
        btn_op14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op14.setForeground(new java.awt.Color(255, 255, 255));
        btn_op14.setText("Consultar Historial por Fecha Ingreso");
        btn_op14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op14ActionPerformed(evt);
            }
        });

        btn_op15.setBackground(new java.awt.Color(32, 95, 193));
        btn_op15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op15.setForeground(new java.awt.Color(255, 255, 255));
        btn_op15.setText("Consultar Historial por Fecha Salida");
        btn_op15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op15ActionPerformed(evt);
            }
        });

        btn_op16.setBackground(new java.awt.Color(32, 95, 193));
        btn_op16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op16.setForeground(new java.awt.Color(255, 255, 255));
        btn_op16.setText("Registrar Usuario");
        btn_op16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op16ActionPerformed(evt);
            }
        });

        btn_op2.setBackground(new java.awt.Color(32, 95, 193));
        btn_op2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op2.setForeground(new java.awt.Color(255, 255, 255));
        btn_op2.setText("Mostrar Paquetes en Recepción");
        btn_op2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op2ActionPerformed(evt);
            }
        });

        btn_op5.setBackground(new java.awt.Color(32, 95, 193));
        btn_op5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op5.setForeground(new java.awt.Color(255, 255, 255));
        btn_op5.setText("Organizar Paquetes");
        btn_op5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op5ActionPerformed(evt);
            }
        });

        btn_op17.setBackground(new java.awt.Color(32, 95, 193));
        btn_op17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op17.setForeground(new java.awt.Color(255, 255, 255));
        btn_op17.setText("Registrar Camión de Carga");
        btn_op17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op17ActionPerformed(evt);
            }
        });

        btn_op1.setBackground(new java.awt.Color(32, 95, 193));
        btn_op1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op1.setForeground(new java.awt.Color(255, 255, 255));
        btn_op1.setText("Registrar Paquete en Recepción");
        btn_op1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op1ActionPerformed(evt);
            }
        });

        btn_op18.setBackground(new java.awt.Color(32, 95, 193));
        btn_op18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op18.setForeground(new java.awt.Color(255, 255, 255));
        btn_op18.setText("Registrar Camión de Entrega");
        btn_op18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op18ActionPerformed(evt);
            }
        });

        btn_op19.setBackground(new java.awt.Color(32, 95, 193));
        btn_op19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_op19.setForeground(new java.awt.Color(255, 255, 255));
        btn_op19.setText("Mostrar Camiones Registrados");
        btn_op19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op19ActionPerformed(evt);
            }
        });

        btn_op20.setBackground(new java.awt.Color(32, 95, 193));
        btn_op20.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btn_op20.setForeground(new java.awt.Color(255, 255, 255));
        btn_op20.setText("SALIR");
        btn_op20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_op20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_op20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_op4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op8, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op9, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op10, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op12, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op13, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op14, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op15, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op16, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op6, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op11, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op17, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_op1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_op7, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op18, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op19, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btn_op20, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btn_op1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_op19)
                                .addGap(60, 60, 60)
                                .addComponent(btn_op20, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(77, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 978, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_op3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op3ActionPerformed

    private void btn_op4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op4ActionPerformed

    private void btn_op6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op6ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op6ActionPerformed

    private void btn_op7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op7ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op7ActionPerformed

    private void btn_op8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op8ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op8ActionPerformed

    private void btn_op9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op9ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op9ActionPerformed

    private void btn_op10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op10ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op10ActionPerformed

    private void btn_op11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op11ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op11ActionPerformed

    private void btn_op12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op12ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op12ActionPerformed

    private void btn_op13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op13ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op13ActionPerformed

    private void btn_op14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op14ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op14ActionPerformed

    private void btn_op15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op15ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op15ActionPerformed

    private void btn_op16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op16ActionPerformed
        // showPanel(new RegistroUsuariosUI());
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op16ActionPerformed

    private void btn_op2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op2ActionPerformed

    private void btn_op1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op1ActionPerformed

    private void btn_op5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op5ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op5ActionPerformed

    private void btn_op17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op17ActionPerformed
        showPanel(new RegistroCamionesCUI());
    }// GEN-LAST:event_btn_op17ActionPerformed

    private void btn_op18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op18ActionPerformed
        showPanel(new RegistroCamionesEUI());
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_op18ActionPerformed

    private void btn_op19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op19ActionPerformed
        CourierEPN.mostrarCamiones();
    }// GEN-LAST:event_btn_op19ActionPerformed

    private void btn_op20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_op20ActionPerformed
        this.setVisible(false);
        loginUI.setVisible(true);
        showPanel(new JPanel());
    }// GEN-LAST:event_btn_op20ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_op1;
    private javax.swing.JButton btn_op10;
    private javax.swing.JButton btn_op11;
    private javax.swing.JButton btn_op12;
    private javax.swing.JButton btn_op13;
    private javax.swing.JButton btn_op14;
    private javax.swing.JButton btn_op15;
    private javax.swing.JButton btn_op16;
    private javax.swing.JButton btn_op17;
    private javax.swing.JButton btn_op18;
    private javax.swing.JButton btn_op19;
    private javax.swing.JButton btn_op2;
    private javax.swing.JButton btn_op20;
    private javax.swing.JButton btn_op3;
    private javax.swing.JButton btn_op4;
    private javax.swing.JButton btn_op5;
    private javax.swing.JButton btn_op6;
    private javax.swing.JButton btn_op7;
    private javax.swing.JButton btn_op8;
    private javax.swing.JButton btn_op9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
