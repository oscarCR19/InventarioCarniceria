/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelos.Carniceria;
import Main.CarniceriaMain;
import java.awt.Toolkit;

public class SuperUsuario extends javax.swing.JFrame {

    /**
     * Creates new form SuperUsuario
     */
    public SuperUsuario() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Multimedia/logochirriche.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonIrcarni1 = new javax.swing.JButton();
        BotonIrcarni2 = new javax.swing.JButton();
        BotonIrcarni3 = new javax.swing.JButton();
        BotonIrcarni4 = new javax.swing.JButton();
        BotonIrcarni5 = new javax.swing.JButton();
        botonIrCentro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonInventario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(850, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Centros de Distribución");

        BotonIrcarni1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/carniceria.png"))); // NOI18N
        BotonIrcarni1.setPreferredSize(new java.awt.Dimension(665, 521));
        BotonIrcarni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrcarni1ActionPerformed(evt);
            }
        });

        BotonIrcarni2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/carniceria.png"))); // NOI18N
        BotonIrcarni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrcarni2ActionPerformed(evt);
            }
        });

        BotonIrcarni3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/carniceria.png"))); // NOI18N
        BotonIrcarni3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrcarni3ActionPerformed(evt);
            }
        });

        BotonIrcarni4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/carniceria.png"))); // NOI18N
        BotonIrcarni4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrcarni4ActionPerformed(evt);
            }
        });

        BotonIrcarni5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/carniceria.png"))); // NOI18N
        BotonIrcarni5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrcarni5ActionPerformed(evt);
            }
        });

        botonIrCentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/box.png"))); // NOI18N
        botonIrCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIrCentroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Puriscal Uno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Puriscal Dos");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Santa Ana");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Escazú");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ciudad Colón");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Centro Distribución");

        botonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/inventario.png"))); // NOI18N
        botonInventario.setMaximumSize(new java.awt.Dimension(123, 99));
        botonInventario.setMinimumSize(new java.awt.Dimension(123, 99));
        botonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInventarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Inventario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(botonIrCentro)
                        .addGap(92, 92, 92)
                        .addComponent(botonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel7)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel8)))
                .addContainerGap(259, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(BotonIrcarni2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotonIrcarni3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonIrcarni4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel5)))
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(BotonIrcarni1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(BotonIrcarni5)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonIrcarni3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIrcarni4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIrcarni2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIrcarni1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIrcarni5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonIrCentro))
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInventarioActionPerformed
        EntradaInventario p = new EntradaInventario();
        p.setVisible(true);
    }//GEN-LAST:event_botonInventarioActionPerformed

    private void botonIrCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrCentroActionPerformed
        PlantaProcesadora ventana = new PlantaProcesadora();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonIrCentroActionPerformed

    private void BotonIrcarni5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrcarni5ActionPerformed
        Carniceria c = new Carniceria();
        c.setNombre("Escazú");
        CarniceriaMain ventana = new CarniceriaMain(c, "inventarioEscazu", "Escazú");
        ventana.establecerDb("inventarioEscazu");
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonIrcarni5ActionPerformed

    private void BotonIrcarni4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrcarni4ActionPerformed
        Carniceria c = new Carniceria();
        c.setNombre("Santa Ana");
        CarniceriaMain ventana = new CarniceriaMain(c, "inventarioSantaAna", "Santa Ana");
        ventana.establecerDb("inventarioSantaAna");
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonIrcarni4ActionPerformed

    private void BotonIrcarni3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrcarni3ActionPerformed
        Carniceria c = new Carniceria();
        c.setNombre("Ciudad Colón");
        CarniceriaMain ventana = new CarniceriaMain(c, "inventarioCiudadColon", "Ciudad Colón");
        ventana.establecerDb("inventarioCiudadColon");
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonIrcarni3ActionPerformed

    private void BotonIrcarni2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrcarni2ActionPerformed
        Carniceria c = new Carniceria();
        c.setNombre("Puriscal Dos");
        CarniceriaMain ventana = new CarniceriaMain(c, "inventarioPuriscalDos", "Puriscal Dos");
        ventana.establecerDb("inventarioPuriscalDos");
        ventana.setVisible(true);
    }//GEN-LAST:event_BotonIrcarni2ActionPerformed

    private void BotonIrcarni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrcarni1ActionPerformed
        Carniceria c = new Carniceria();
        c.setNombre("Puriscal Uno");
        CarniceriaMain ventana = new CarniceriaMain(c, "inventarioPuriscalUno", "Puriscal Uno");
        ventana.establecerDb("inventarioPuriscalUno");
        ventana.setVisible(true);


    }//GEN-LAST:event_BotonIrcarni1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuperUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIrcarni1;
    private javax.swing.JButton BotonIrcarni2;
    private javax.swing.JButton BotonIrcarni3;
    private javax.swing.JButton BotonIrcarni4;
    private javax.swing.JButton BotonIrcarni5;
    private javax.swing.JButton botonInventario;
    private javax.swing.JButton botonIrCentro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
