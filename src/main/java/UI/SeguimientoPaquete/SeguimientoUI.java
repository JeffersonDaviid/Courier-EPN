/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SeguimientoPaquete;

import BL.Administracion.Recepcionista;
import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Seguimiento;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlo
 */
public class SeguimientoUI extends javax.swing.JPanel {

    /**
     * Creates new form SeguimientoUI
     */
    private Recepcionista recepcionista;

    public SeguimientoUI(Recepcionista recepcionista) {
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

        jTextFieldIdPaquete = new javax.swing.JTextField();
        jBConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSeguimiento = new javax.swing.JTable();

        jBConsultar.setText("CONSULTAR");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jTableSeguimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableSeguimiento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIdPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBConsultar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        // TODO add your handling code here:
        String trackingId = jTextFieldIdPaquete.getText();

        // Buscar el paquete por su número de tracking en el inventario
        Paquete paquete = Inventario.getInstancia().buscarPaquete(trackingId);

        if (paquete != null) {
            Seguimiento seguimiento = paquete.getSeguimiento();

            // Obtener el historial completo de estados
            String historial = seguimiento.verHistorial();

            // Mostrar datos del paquete en la tabla
            DefaultTableModel model = (DefaultTableModel) jTableSeguimiento.getModel();
            model.setRowCount(0); // Limpiar la tabla

            // Llenar la tabla con los datos del paquete
            model.addRow(new Object[]{
                paquete.getTracking(),
                paquete.getNombreDestinatario(),
                paquete.getDireccion(),
                paquete.getSucursalDestino(),
                paquete.obtenerEstadoActual().toString()
            });

            // Llenar el historial de estados en la tabla
            // Llenar la tabla con el último estado del historial
            DefaultTableModel historialModel = (DefaultTableModel) jTableSeguimiento.getModel();
            historialModel.setRowCount(0); // Limpiar la tabla de historial

            // Asumiendo que el historial se separa por líneas (una línea por estado)
            String[] estados = historial.split("\n");
            if (estados.length > 0) {
                // Mostrar solo el último estado
                String ultimoEstado = estados[estados.length - 1];
                historialModel.addRow(new Object[]{ultimoEstado});
            }

        } else {
            //JOptionPane.showMessageDialog(null, "Paquete no encontrado");
        }


    }//GEN-LAST:event_jBConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSeguimiento;
    private javax.swing.JTextField jTextFieldIdPaquete;
    // End of variables declaration//GEN-END:variables
}
