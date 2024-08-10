/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.GestionPaquete;

import java.sql.SQLException;

import javax.swing.JFrame;

import BL.BASEDEDATOS.DataHelper;
import BL.Facturacion.Factura;
import BL.Facturacion.Precio;
import BL.GestionPaquete.Estado;
import BL.GestionPaquete.Paquete;
import UI.Facturacion.FacturaUI;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class GestionPaquete extends javax.swing.JPanel {

	/**
	 * Creates new form GestionPaquete
	 */
	private Paquete paquete;
	private Estado estado;

	private Factura factura;

	public GestionPaquete() {
		initComponents();
		paquete = new Paquete();

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

		jLabel1 = new javax.swing.JLabel();
		jLNombreRem = new javax.swing.JLabel();
		jtNombreRemitente = new javax.swing.JTextField();
		jtCorreoRemitente = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jtTelefonoRemitente = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jtTelefonoDestinatario = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jtCorreoDestinatario = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jtNombreDestinatario = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTsucursalRecibe = new javax.swing.JTextField();
		jTsucursalAcepto = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jSeparator3 = new javax.swing.JSeparator();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jTpeso = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jComboTamanio = new javax.swing.JComboBox<>();
		jComboTipoEnvio = new javax.swing.JComboBox<>();
		jSeparator4 = new javax.swing.JSeparator();
		jBaceptar = new javax.swing.JButton();
		jLabel17 = new javax.swing.JLabel();
		jTFechasalida = new javax.swing.JTextField();
		jLabel18 = new javax.swing.JLabel();
		jTFechaLlegada = new javax.swing.JTextField();
		jTdomicilio = new javax.swing.JTextField();
		jldomicilio = new javax.swing.JLabel();
		jBCalcular = new javax.swing.JButton();

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

		jtTelefonoRemitente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtTelefonoRemitenteActionPerformed(evt);
			}
		});

		jLabel4.setText("Teléfono");

		jtTelefonoDestinatario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtTelefonoDestinatarioActionPerformed(evt);
			}
		});

		jLabel5.setText("Teléfono");

		jtCorreoDestinatario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtCorreoDestinatarioActionPerformed(evt);
			}
		});

		jLabel6.setText("Correo");

		jtNombreDestinatario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtNombreDestinatarioActionPerformed(evt);
			}
		});

		jLabel7.setText("Nombre");

		jLabel8.setText("Información del destinatario");

		jLabel9.setText("TIPO DE ENVIO");

		jLabel10.setText("Sucursal para recoger");

		jLabel11.setText("Sucursal que acepto el paquete");

		jLabel12.setText("Información del Paquete");

		jLabel13.setText("Peso");

		jLabel14.setText("Tamaño");

		jComboTamanio
				.setModel(new javax.swing.DefaultComboBoxModel<>(
						new String[] { "pequeño", "mediano", "grande", " " }));

		jComboTipoEnvio.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Domicilio", "Agencia", " " }));
		jComboTipoEnvio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboTipoEnvioActionPerformed(evt);
			}
		});

		jBaceptar.setText("GUARDAR");
		jBaceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBaceptarActionPerformed(evt);
			}
		});

		jLabel17.setText("Fecha de salida");

		jLabel18.setText("Fecha de llegada");

		jldomicilio.setText("Direccion de domicilio");

		jBCalcular.setText("Calcular");
		jBCalcular.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBCalcularActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 700, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(444, 444,
																444)
														.addComponent(jBCalcular)
														.addGap(35, 35, 35)
														.addComponent(jBaceptar)
														.addGap(49, 49, 49))
												.addComponent(jSeparator4)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1)
																.addComponent(jLNombreRem)
																.addComponent(jtNombreRemitente,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel3)
																.addComponent(jtCorreoRemitente,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel4)
																.addComponent(jtTelefonoRemitente,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel8)
																.addComponent(jLabel7)
																.addComponent(jtNombreDestinatario,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel6)
																.addComponent(jtCorreoDestinatario,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel5)
																.addComponent(jtTelefonoDestinatario,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(121, 121,
																121))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel12)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel9)
																		.addGap(29, 29, 29)
																		.addComponent(jComboTipoEnvio,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(108, 108,
																				108)
																		.addGroup(layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jldomicilio)
																				.addComponent(jTdomicilio,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						349,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						false)
																						.addComponent(jLabel10)
																						.addComponent(jTsucursalAcepto)
																						.addComponent(jLabel11)
																						.addComponent(jTsucursalRecibe,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								349,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jSeparator3))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addGap(30, 30, 30)
																		.addComponent(jLabel13)
																		.addGap(86, 86, 86)
																		.addComponent(jLabel14))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jTpeso,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				87,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(44, 44, 44)
																		.addComponent(jComboTamanio,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(56, 56, 56)
																		.addGroup(layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel18)
																				.addComponent(jLabel17))
																		.addGap(18, 18, 18)
																		.addGroup(layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jTFechasalida,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						183,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jTFechaLlegada,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						183,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap())));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 529, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLNombreRem)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtNombreRemitente,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel3)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtCorreoRemitente,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtTelefonoRemitente,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel8)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel7)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtNombreDestinatario,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel6)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtCorreoDestinatario,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel5)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtTelefonoDestinatario,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(16, 16, 16)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel9)
																.addComponent(jComboTipoEnvio,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(35, 35, 35))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout
																.createSequentialGroup()
																.addComponent(jLabel11)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTsucursalAcepto,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18)))
										.addComponent(jLabel10)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTsucursalRecibe,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jldomicilio)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTdomicilio,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(2, 2, 2)
										.addComponent(jSeparator3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel12)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel13)
												.addComponent(jLabel14))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTpeso,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jComboTamanio,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel17)
												.addComponent(jTFechasalida,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel18)
												.addComponent(jTFechaLlegada,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jSeparator4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jBaceptar)
												.addComponent(jBCalcular))
										.addContainerGap())));
	}// </editor-fold>//GEN-END:initComponents

	private void jtNombreRemitenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtNombreRemitenteActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtNombreRemitenteActionPerformed

	private void jtCorreoRemitenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtCorreoRemitenteActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtCorreoRemitenteActionPerformed

	private void jtTelefonoRemitenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtTelefonoRemitenteActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtTelefonoRemitenteActionPerformed

	private void jtTelefonoDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtTelefonoDestinatarioActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtTelefonoDestinatarioActionPerformed

	private void jtCorreoDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtCorreoDestinatarioActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtCorreoDestinatarioActionPerformed

	private void jtNombreDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtNombreDestinatarioActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtNombreDestinatarioActionPerformed

	private void jComboTipoEnvioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboTipoEnvioActionPerformed
		// TODO add your handling code here:
		if (jComboTipoEnvio.getSelectedItem().toString().equals("Domicilio")) {
			jldomicilio.setVisible(true);
			jTdomicilio.setVisible(true);
			jTdomicilio.setText("");
		} else {
			jTdomicilio.setVisible(false);
			jldomicilio.setVisible(false);
			jTdomicilio.setText("NO");
		}
	}// GEN-LAST:event_jComboTipoEnvioActionPerformed

	private void jBaceptarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBaceptarActionPerformed
		// TODO add your handling code here:
		guardarPaquete();

		factura = Factura.getIntancia();
		factura.generarFactura(paquete);
	}// GEN-LAST:event_jBaceptarActionPerformed

	private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBCalcularActionPerformed
		// TODO: CREAR/CARGAR DATOS DEL OBJETO PAQUETE

		paquete = new Paquete("0", Float.parseFloat(jTpeso.getText()),
				jComboTamanio.getSelectedItem().toString(), jTsucursalAcepto.getText(),
				jTsucursalRecibe.getText(), jtNombreRemitente.getText(), jtCorreoRemitente.getText(),
				jtTelefonoRemitente.getText(), jtNombreDestinatario.getText(),
				jtCorreoDestinatario.getText(), jtTelefonoDestinatario.getText(), jTdomicilio.getText(),
				jTFechaLlegada.getText(), jTFechasalida.getText());

		factura = Factura.getIntancia();
		factura.getPrecio().calcularPrecio(paquete);

	}// GEN-LAST:event_jBCalcularActionPerformed

	private void guardarPaquete() {
		String nombreRemitente = jtNombreRemitente.getText();
		String correoRemitente = jtCorreoRemitente.getText();
		String telefonoRemitente = jtTelefonoRemitente.getText();
		String nombreDestinatario = jtNombreDestinatario.getText();
		String correoDestinatario = jtCorreoDestinatario.getText();
		String telefonoDestinatario = jtTelefonoDestinatario.getText();
		float peso = Float.parseFloat(jTpeso.getText());
		String tamanio = (String) jComboTamanio.getSelectedItem();
		String fechaSalida = jTFechasalida.getText();
		String fechaLlegada = jTFechaLlegada.getText();
		String tipoEnvio = (String) jComboTipoEnvio.getSelectedItem();
		String sucursalAceptoPaquete = jTsucursalAcepto.getText();
		String sucursalParaRecoger = jTsucursalRecibe.getText();
		String domicilio = jTdomicilio.getText();

		paquete.setId(generateId());
		paquete.setPeso(peso);
		paquete.setTamanio(tamanio);
		paquete.setFechaLlegada(fechaLlegada);
		paquete.setFechaSalida(fechaSalida);
		paquete.setNombreRemitente(nombreRemitente);
		paquete.setCorreoRemitente(correoRemitente);
		paquete.setTelefonoRemitente(telefonoRemitente);
		paquete.setNombreDestinatario(nombreDestinatario);
		paquete.setCorreoDestinatario(correoDestinatario);
		paquete.setTelefonoDestinatario(telefonoDestinatario);
		paquete.setDomicilio(tipoEnvio);
		paquete.setAgenciaOrigen(sucursalAceptoPaquete);
		paquete.setAgenciaDestino(sucursalParaRecoger);
		paquete.setDomicilio(domicilio);

		paquete.registrarPaquete(paquete);
		// paquete.guardarPaquete(paquete);

		paquete.guardarPaquete(paquete);

	}

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

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel.
		 * For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GestionPaquete.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GestionPaquete.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GestionPaquete.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GestionPaquete.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GestionPaquete().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jBCalcular;
	private javax.swing.JButton jBaceptar;
	private javax.swing.JComboBox<String> jComboTamanio;
	private javax.swing.JComboBox<String> jComboTipoEnvio;
	private javax.swing.JLabel jLNombreRem;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JTextField jTFechaLlegada;
	private javax.swing.JTextField jTFechasalida;
	private javax.swing.JTextField jTdomicilio;
	private javax.swing.JTextField jTpeso;
	private javax.swing.JTextField jTsucursalAcepto;
	private javax.swing.JTextField jTsucursalRecibe;
	private javax.swing.JLabel jldomicilio;
	private javax.swing.JTextField jtCorreoDestinatario;
	private javax.swing.JTextField jtCorreoRemitente;
	private javax.swing.JTextField jtNombreDestinatario;
	private javax.swing.JTextField jtNombreRemitente;
	private javax.swing.JTextField jtTelefonoDestinatario;
	private javax.swing.JTextField jtTelefonoRemitente;
	// End of variables declaration//GEN-END:variables
}
