/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.GestionPaquete;

import java.util.Random;

import javax.swing.JOptionPane;

import BL.Administracion.Cliente;
import BL.Administracion.GestorPerfiles;
import BL.Administracion.Recepcionista;
import BL.Facturacion.Factura;
import BL.GestionPaquete.Default;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;

/**
 *
 * @author marlo
 */
public class GestionPaquete extends javax.swing.JPanel {

    private Paquete paquete;    
    private Estado estado;
    private Recepcionista recepcionista;
    private Factura factura;
    private Cliente cliente = null;
    public GestionPaquete(Recepcionista recepcionista) {
        initComponents();
        paquete =  null;
        this.recepcionista = recepcionista;
        this.recepcionista.eliminarPaqueteRegistrado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jtBuscarCedula = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLNombreRem = new javax.swing.JLabel();
        jtNombreRemitente = new javax.swing.JTextField();
        jtCorreoRemitente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtTelefonoRemitente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtNombreDestinatario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtCorreoDestinatario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtTelefonoDestinatario = new javax.swing.JTextField();
        jTdomicilio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboTipoEnvio = new javax.swing.JComboBox<>();
        jComboTamanio = new javax.swing.JComboBox<>();
        jBCalcular = new javax.swing.JButton();
        jBaceptar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboSucurcalRecoger = new javax.swing.JComboBox<>();
        jldomicilio = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTpeso = new javax.swing.JTextField();

        jTextField1.setText("Buscar Cliente");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jtBuscarCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarCedulaActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Información del remitente");

        jLNombreRem.setText("Nombre");

        jtNombreRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreRemitenteActionPerformed(evt);
            }
        });

        jtCorreoRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoRemitenteActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo");

        jLabel4.setText("Teléfono");

        jtTelefonoRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelefonoRemitenteActionPerformed(evt);
            }
        });

        jLabel8.setText("Información del destinatario");

        jLabel7.setText("Nombre");

        jtNombreDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreDestinatarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Correo");

        jtCorreoDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoDestinatarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Teléfono");

        jtTelefonoDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelefonoDestinatarioActionPerformed(evt);
            }
        });

        jLabel9.setText("TIPO DE ENVIO");

        jLabel28.setText("Tamaño");

        jComboTipoEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domicilio", "Agencia", " " }));
        jComboTipoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoEnvioActionPerformed(evt);
            }
        });

        jComboTamanio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pequeño", "mediano", "grande", " " }));

        jBCalcular.setText("CALCULAR");
        jBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularActionPerformed(evt);
            }
        });

        jBaceptar.setText("GUARDAR");
        jBaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarActionPerformed(evt);
            }
        });

        jLabel10.setText("Sucursal para recoger");

        jComboSucurcalRecoger.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AMBATO", "AZOGUES", "BABAHOYO", "CUENCA", "ESMERALDAS", "GUAYAQUIL", "GUARANDA", "IBARRA", "LATACUNGA", "LOJA", "MACARA", "MANTA", "PORTOVIEJO", "PUYO", "QUITO", "RIOBAMBA", "RUMICHACA", "SANTO_DOMINGO", "TENA", "TULCAN", "ZAMORA", "LAGO_AGRIO" }));
        jComboSucurcalRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSucurcalRecogerActionPerformed(evt);
            }
        });

        jldomicilio.setText("Direccion de domicilio");

        jLabel26.setText("Peso");

        jLabel27.setText("Información del Paquete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLNombreRem)
                    .addComponent(jtNombreRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtCorreoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtTelefonoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jtNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtCorreoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBCalcular)
                .addGap(43, 43, 43)
                .addComponent(jBaceptar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtBuscarCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(jComboTipoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboSucurcalRecoger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jldomicilio)
                                .addComponent(jTdomicilio)
                                .addComponent(jLabel26)
                                .addComponent(jTpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCorreoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtBuscarCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLNombreRem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNombreRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCorreoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTelefonoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboTipoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboSucurcalRecoger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jldomicilio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBaceptar)
                    .addComponent(jBCalcular))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jtBuscarCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarCedulaActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String cedula = jtBuscarCedula.getText();
        cliente = GestorPerfiles.getInstance().getCliente(cedula);
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return;
        }else{
            jtNombreRemitente.setText(cliente.getNombre());
            jtCorreoRemitente.setText(cliente.getCorreo());
            jtTelefonoRemitente.setText(cliente.getTelefono());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtNombreRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreRemitenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreRemitenteActionPerformed

    private void jtCorreoRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoRemitenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCorreoRemitenteActionPerformed

    private void jtTelefonoRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelefonoRemitenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelefonoRemitenteActionPerformed

    private void jtNombreDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreDestinatarioActionPerformed

    private void jtCorreoDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCorreoDestinatarioActionPerformed

    private void jtTelefonoDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelefonoDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelefonoDestinatarioActionPerformed

    private void jComboTipoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoEnvioActionPerformed
        // TODO add your handling code here:
         String tipoEnvio = (String) jComboTipoEnvio.getSelectedItem();
         if ("Agencia".equals(tipoEnvio)) {
            jTdomicilio.setVisible(false);
            jldomicilio.setVisible(false);
         }else{
             jTdomicilio.setVisible(true);
            jldomicilio.setVisible(true);
            
        }
    }//GEN-LAST:event_jComboTipoEnvioActionPerformed

    private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularActionPerformed
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "Primero debe buscar un cliente");
            return;
        }
        String dirDomicilio = null;

		if (jComboTipoEnvio.getSelectedItem().toString().equals("Domicilio"))
			dirDomicilio = jTdomicilio.getText();
        // Información del destinatario
        String nombreDestinatario = jtNombreDestinatario.getText();
        String correoDestinatario = jtCorreoDestinatario.getText();
        String telefonoDestinatario = jtTelefonoDestinatario.getText();

        // Información del paquete
        String sucursalOrigen = recepcionista.getSucursal().name();
        String sucursalDestino = (String) jComboSucurcalRecoger.getSelectedItem();
        String peso = jTpeso.getText(); // Debe convertir este valor a float más adelante si es necesario
        String tamanio = (String) jComboTamanio.getSelectedItem();
        paquete = new Paquete(generateId(), Float.parseFloat(peso), tamanio, cliente, sucursalOrigen, sucursalDestino, dirDomicilio, nombreDestinatario, correoDestinatario, telefonoDestinatario, null, null);
        recepcionista.registrarPaquete(paquete);
        float precio = recepcionista.previsualizarPrecioPaquete();
        JOptionPane.showMessageDialog(null, "El precio del paquete es: " + precio);
        
    }//GEN-LAST:event_jBCalcularActionPerformed

    private void jBaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarActionPerformed
        if(recepcionista.getPaqueteEnRegistro()==null){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar los datos del paquete");
            return;
        }
        recepcionista.generarFactura();
        recepcionista.registrarPaqueteEnInventario();
        recepcionista.eliminarPaqueteRegistrado();
        paquete = null;
    }//GEN-LAST:event_jBaceptarActionPerformed

    private String generateId() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10; // desired length of the generated string

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			char randomChar = characters.charAt(index);
			sb.append(randomChar);
		}

		return sb.toString();
	}

    private void jComboSucurcalRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSucurcalRecogerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboSucurcalRecogerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCalcular;
    private javax.swing.JButton jBaceptar;
    private javax.swing.JComboBox<String> jComboSucurcalRecoger;
    private javax.swing.JComboBox<String> jComboTamanio;
    private javax.swing.JComboBox<String> jComboTipoEnvio;
    private javax.swing.JLabel jLNombreRem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTdomicilio;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTpeso;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JLabel jldomicilio;
    private javax.swing.JTextField jtBuscarCedula;
    private javax.swing.JTextField jtCorreoDestinatario;
    private javax.swing.JTextField jtCorreoRemitente;
    private javax.swing.JTextField jtNombreDestinatario;
    private javax.swing.JTextField jtNombreRemitente;
    private javax.swing.JTextField jtTelefonoDestinatario;
    private javax.swing.JTextField jtTelefonoRemitente;
    // End of variables declaration//GEN-END:variables
}
