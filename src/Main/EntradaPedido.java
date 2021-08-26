/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EntradaPedido extends javax.swing.JFrame {

    DefaultTableModel modeloTablaPedido;

    public EntradaPedido(String nombreCarniceria) {
        initComponents();
        this.modeloTablaPedido = (DefaultTableModel) this.tablaPedido.getModel();
        cargarComboBox();
        cargarTabla();
        ultimoPedido();
        limpiarArrayTabla();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Multimedia/logochirriche.png")));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////// 
    private String nombreCarniceria;

    public void establecerNombrecarniceria(String db) {
        nombreCarniceria = db;
    }

    public String obtenerNombrecarniceria() {
        return nombreCarniceria;
    }

    public int getSaberIdPedido() {
        return saberIdPedido;
    }

    public void setSaberIdPedido(int saberIdPedido) {
        this.saberIdPedido = saberIdPedido;
    }
    int saberIdPedido;

///////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////métodos///////////////////////////////////////////////////////
    public void cargarComboBox() {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                            "postgres", "root1234");
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from carniceria.\"inventarioCentral\"");
            while (rs.next()) {
                int id = rs.getInt("idProducto");
                String name = rs.getString("nombreProducto");
                this.comboBoxProductos.addItem(name);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void Agregar() {

        try {
            Producto p = new Producto();

            if (this.textFieldcantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Falta seleccionar la cantidad");
                return;
            }
            for (int i = 0; i < Productos.arrayPedidos.size(); i++) {
                if (String.valueOf(Productos.arrayPedidos.get(i).getNombre()).equals(this.comboBoxProductos.getSelectedItem())) {
                    JOptionPane.showMessageDialog(rootPane, "Producto ya se encuentra en el inventario");
                    return;
                }
            }
            p.setNombre(String.valueOf(this.comboBoxProductos.getSelectedItem()));
            p.setCantidad(Double.parseDouble(this.textFieldcantidad.getText()));
            p.setId(saberId());

            Productos.arrayPedidos.add(p);

            this.modeloTablaPedido.addRow(new Object[]{saberId(), p.getNombre(), p.getCantidad()});
            this.textFieldcantidad.setText("");
            this.textFieldid.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());

        }
    }

//esta variable es para saber el id
    private int idProd;

    public int saberId() {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs;
        Object nombreSelect = this.comboBoxProductos.getSelectedItem();

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                            "postgres", "root1234");

            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from carniceria.\"inventarioCentral\"");
            while (rs.next()) {
                int id = rs.getInt("idProducto");
                String name = rs.getString("nombreProducto");
                if (name.equals(nombreSelect)) {
                    idProd = id;

                }

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return idProd;
    }

    public void cargarTabla() {
        for (int i = 0; i < Productos.arrayPedidos.size(); i++) {
            this.modeloTablaPedido.addRow(new Object[]{
                Productos.arrayPedidos.get(i).getId(),
                Productos.arrayPedidos.get(i).getNombre(),
                Productos.arrayPedidos.get(i).getCantidad(),});
        }

    }

    public void BorrarRegistro() {
        try {
            int p = this.tablaPedido.getSelectedRow();
            if (p >= 0) {
                Productos.arrayPedidos.remove(p);
                this.modeloTablaPedido.removeRow(p);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No se encontraron elementos para borrar");

        }
    }

    public void enviarPedido() {

        Connection c = null;
        Statement stmt = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                            "postgres", "root1234");
            if (Productos.arrayPedidos.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No hay datos para solicitar un pedido");
                return;
            }

            String sql = "INSERT INTO carniceria.\"Pedidos\" (\"fechaPedido\", \"Sede\") VALUES (" + "'" + sqlDate + "'" + "," + "'" + obtenerNombrecarniceria() + "'" + ") returning \"idPedido\";";
            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(rootPane, "Producto ingresado con éxito");

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {

        }

    }

    public void segundoPedido() {

        Connection c = null;
        Statement stmt = null;

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                            "postgres", "root1234");
            if (Productos.arrayPedidos.isEmpty()) {
                return;
            }
            int pedido = this.getSaberIdPedido() + 1;
            for (int i = 0; i < Productos.arrayPedidos.size(); i++) {
                String sql = "INSERT INTO carniceria.\"Pedidos_detalles\" (\"idPedido\", fecha, \"sede\", \"idProducto\", \"nombreProducto\", \"cantidadProducto\") VALUES ("
                        + pedido + "," + "'" + sqlDate + "'" + "," + "'" + obtenerNombrecarniceria() + "'" + ", " + Productos.arrayPedidos.get(i).getId()
                        + ", '" + Productos.arrayPedidos.get(i).getNombre() + "', " + Productos.arrayPedidos.get(i).getCantidad() + ");";
                stmt = c.createStatement();
                stmt.executeUpdate(sql);
            }

            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(rootPane, "Pedido solicitado ha sido enviado");
            this.setVisible(false);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }

    public void ultimoPedido() {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                            "postgres", "root1234");
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM carniceria.\"Pedidos\" ORDER BY \"idPedido\" DESC LIMIT 1;");
            while (rs.next()) {
                setSaberIdPedido(rs.getInt("idPedido"));

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void limpiarArrayTabla() {

        for (int i = 0; i < Productos.arrayPedidos.size(); i++) {
            this.modeloTablaPedido.removeRow(0);
        }
        Productos.arrayPedidos.clear();
        
    }
//////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        botonBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldid = new javax.swing.JTextField();
        textFieldcantidad = new javax.swing.JTextField();
        comboBoxProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        labelVisiitante = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setEnabled(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenidos a la Ventana de Pedidos");

        botonAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedido);

        botonBorrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Cantidad(Kg)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Id");

        textFieldid.setEditable(false);

        comboBoxProductos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBoxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Sede:");

        labelVisiitante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Hacer Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVisiitante, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(comboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textFieldcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(28, 28, 28)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(labelVisiitante, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        BorrarRegistro();


    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        Agregar();

        //limpiarCampos();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void comboBoxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductosActionPerformed
        this.textFieldid.setText(String.valueOf(saberId()));
    }//GEN-LAST:event_comboBoxProductosActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        this.labelVisiitante.setText(obtenerNombrecarniceria());
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enviarPedido();
        segundoPedido();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EntradaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaPedido(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JComboBox<String> comboBoxProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelVisiitante;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JTextField textFieldcantidad;
    private javax.swing.JTextField textFieldid;
    // End of variables declaration//GEN-END:variables
}
