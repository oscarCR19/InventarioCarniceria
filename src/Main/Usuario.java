package Main;

import Modelos.Carniceria;
import java.awt.Toolkit;

public class Usuario extends javax.swing.JFrame {

    private String contra0 = "0";
    private String contra1 = "adminPuris1";
    private String contra2 = "adminPuris2";
    private String contra3 = "adminCiudadColon";
    private String contra4 = "adminSantaAna";
    private String contra5 = "adminEscazu";
    private String contra6 = "recep1";

    private String usuario0 = "0";
    private String usuario1 = "adminPuris1";
    private String usuario2 = "adminPuris2";
    private String usuario3 = "adminCiudadColon";
    private String usuario4 = "adminSantaAna";
    private String usuario5 = "adminEscazu+";
    private String usuario6 = "Recep1";

    public Usuario() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Multimedia/logochirriche.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        introUsuario = new javax.swing.JTextField();
        labelcontraseña = new javax.swing.JLabel();
        introContrasena = new javax.swing.JPasswordField();
        botonEntrarusuario = new javax.swing.JButton();
        BotonSalirUsuario = new javax.swing.JButton();
        labelAcceso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUsuario.setText("Usuario:");

        introUsuario.setFocusAccelerator('\u25cf');

        labelcontraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelcontraseña.setText("Contraseña:");

        botonEntrarusuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEntrarusuario.setText("Entrar");
        botonEntrarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarusuarioActionPerformed(evt);
            }
        });

        BotonSalirUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotonSalirUsuario.setText("Salir");
        BotonSalirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirUsuarioActionPerformed(evt);
            }
        });

        labelAcceso.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        labelAcceso.setText("Sistema de inventario carnicerias el chirriche ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelAcceso)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelcontraseña)
                    .addComponent(labelUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botonEntrarusuario)
                        .addGap(18, 18, 18)
                        .addComponent(BotonSalirUsuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(introUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(introContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(labelAcceso)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(introUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcontraseña)
                    .addComponent(introContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEntrarusuario)
                    .addComponent(BotonSalirUsuario))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private Carniceria obtenerAccesoCarniceriaporUsuario() {
        String usuario = this.introUsuario.getText();

        String contra = String.valueOf(this.introContrasena.getPassword());
        Carniceria carniceria = null;
        if (usuario.equals(this.usuario0) || usuario.equals(this.usuario1) || usuario.equals(this.usuario2)
                || usuario.equals(this.usuario3) || usuario.equals(this.usuario4) || usuario.equals(this.usuario5)
                || usuario.equals(this.usuario6)) {

            if (usuario.equals(this.usuario0) && contra.equals(this.contra0)) {
                SuperUsuario ventana = new SuperUsuario();
                ventana.setVisible(true);
                this.setVisible(false);
            } else if (usuario.equals(this.usuario1) && contra.equals(this.contra1)) {
                carniceria = new Carniceria();
                carniceria.setNombre("Puriscal Uno");
                setNombreDbCarniceria("inventarioPuriscalUno");
                setNombreSede("Puriscal Uno");
            } else if (usuario.equals(this.usuario2) && contra.equals(this.contra2)) {
                carniceria = new Carniceria();
                carniceria.setNombre("Puriscal Dos");
                setNombreDbCarniceria("inventarioPuriscalDos");
                setNombreSede("Puriscal Dos");
            } else if (usuario.equals(this.usuario3) && contra.equals(this.contra3)) {
                carniceria = new Carniceria();
                carniceria.setNombre("Ciudad Colón");
                setNombreDbCarniceria("inventarioCiudadColon");
                setNombreSede("Ciudad Colón");
            } else if (usuario.equals(this.usuario4) && contra.equals(this.contra4)) {
                carniceria = new Carniceria();
                carniceria.setNombre("Santa Ana");
                setNombreDbCarniceria("inventarioSantaAna");
                setNombreSede("Santa Ana");
            } else if (usuario.equals(this.usuario5) && contra.equals(this.contra5)) {
                carniceria = new Carniceria();
                carniceria.setNombre("Escazú");
                setNombreDbCarniceria("inventarioEscazu");
                setNombreSede("Escazú");
            } else if (usuario.equals(this.usuario6) && contra.equals(this.contra6)) {
                PlantaProcesadora pp = new PlantaProcesadora();
                          pp.setVisible(true);
            }

        }
        return carniceria;

    }
    String nombreDbCarniceria;

    public String getNombreDbCarniceria() {
        return nombreDbCarniceria;
    }

    public void setNombreDbCarniceria(String nombreDbCarniceria) {
        this.nombreDbCarniceria = nombreDbCarniceria;
    }
    String nombreSede;

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }


    private void botonEntrarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarusuarioActionPerformed
        Carniceria carniceria = obtenerAccesoCarniceriaporUsuario();
        if (carniceria != null) {
            CarniceriaMain ventana2 = new CarniceriaMain(carniceria, getNombreDbCarniceria(), getNombreSede());
            ventana2.setVisible(true);
            this.setVisible(false);

        }

        
    }//GEN-LAST:event_botonEntrarusuarioActionPerformed

    private void BotonSalirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirUsuarioActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BotonSalirUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonSalirUsuario;
    private javax.swing.JButton botonEntrarusuario;
    private javax.swing.JPasswordField introContrasena;
    private javax.swing.JTextField introUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAcceso;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelcontraseña;
    // End of variables declaration//GEN-END:variables
}
