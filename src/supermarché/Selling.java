/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarché;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tessa
 */
public class Selling extends javax.swing.JFrame {

    public Selling() {
        initComponents();
        selectProduct();
        getCat();
    }
    public void filtrer(){
    try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb", "User1", "1234");
           PreparedStatement st = con.prepareStatement("select * from User1.PRODUCTTBL where PRODUCTCATEGORIE = ?");
           
            st.setString(1 ,proCat.getSelectedItem().toString());
            
             ResultSet rs = st.executeQuery();
             
            while (rs.next()) { 
                int cid = rs.getInt("PRODUCTID");
                String name = rs.getString("PRODUCTNAME");
                int qty = rs.getInt("PRODUCTQTY");
                int prix = rs.getInt("PRODUCTPRICE");
                String cat = rs.getString("PRODUCTCATEGORIE");

                Object[] obj = new Object[]{cid, name, qty, prix, cat};
                DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void selectProduct() {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb", "User1", "1234");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from User1.PRODUCTTBL");

            while (rs.next()) {
                int cid = rs.getInt("PRODUCTID");
                String name = rs.getString("PRODUCTNAME");
                int qty = rs.getInt("PRODUCTQTY");
                int prix = rs.getInt("PRODUCTPRICE");
                String cat = rs.getString("PRODUCTCATEGORIE");

                Object[] obj = new Object[]{cid, name, qty, prix, cat};
                DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int Prid;

    public void updateProduct() {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb", "User1", "1234");
            String sql = "update User1.PRODUCTTBL set PRODUCTQTY = ? where PRODUCTID = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, availQty);
            st.setInt(2, Prid);

            int count = st.executeUpdate();
            if (count > 0) {
                //JOptionPane.showMessageDialog(this, "Produit modifier avec success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            getCat();
        }
    }

    public void clear() {
        DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
        model.setRowCount(0);
    }

    private void getCat() {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb", "User1", "1234");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from User1.CATEGORYTBL");

            while (rs.next()) {
                String name = rs.getString("CATNAME");
                proCat.addItem(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        proQuantite = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        addPro = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        filtrer = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePro = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        proNom = new javax.swing.JTextField();
        proCat = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        grdTotal = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Listes Des Produits");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 240, -1));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("QUANTITE :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        proQuantite.setBackground(new java.awt.Color(255, 255, 255));
        proQuantite.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proQuantite.setForeground(new java.awt.Color(255, 0, 0));
        proQuantite.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proQuantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proQuantiteActionPerformed(evt);
            }
        });
        jPanel2.add(proQuantite, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Imprimer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 780, 140, 30));

        addPro.setBackground(new java.awt.Color(255, 0, 0));
        addPro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addPro.setForeground(new java.awt.Color(255, 255, 255));
        addPro.setText("Ajouter");
        addPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProMouseClicked(evt);
            }
        });
        addPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProActionPerformed(evt);
            }
        });
        jPanel2.add(addPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Effacer");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 140, 40));

        filtrer.setBackground(new java.awt.Color(255, 0, 0));
        filtrer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filtrer.setForeground(new java.awt.Color(255, 255, 255));
        filtrer.setText("Filtrer");
        filtrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrerMouseClicked(evt);
            }
        });
        filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrerActionPerformed(evt);
            }
        });
        jPanel2.add(filtrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 120, 40));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("FACTURATION");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 170, -1));

        tablePro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablePro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "NOM DU PRODUIT ", "QUANTITE (KGS)", "PRIX  (FCFA)", "CATEGORIE"
            }
        ));
        tablePro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablePro.setRowHeight(30);
        tablePro.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tablePro.setShowGrid(true);
        tablePro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePro);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 670, 680));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("PRODUITS :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 40));

        proNom.setBackground(new java.awt.Color(255, 255, 255));
        proNom.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proNom.setForeground(new java.awt.Color(255, 0, 0));
        proNom.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proNomActionPerformed(evt);
            }
        });
        jPanel2.add(proNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 270, 40));

        proCat.setBackground(new java.awt.Color(255, 255, 255));
        proCat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        proCat.setForeground(new java.awt.Color(255, 0, 0));
        proCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                proCatItemStateChanged(evt);
            }
        });
        proCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proCatMouseClicked(evt);
            }
        });
        proCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proCatActionPerformed(evt);
            }
        });
        jPanel2.add(proCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 300, 40));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.setRows(5);
        textArea.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane2.setViewportView(textArea);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 550, 430));

        grdTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        grdTotal.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(grdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 780, 330, 30));

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Actualiser");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 1260, 840));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DECONNEXION");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 30, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 870));

        setSize(new java.awt.Dimension(1421, 867));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void proQuantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proQuantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proQuantiteActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        try {
            textArea.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2MouseClicked

    Double uPrice, prodTot = 0.0, grandTotal = 0.0;
    int availQty, i = 0;
    private void addProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProMouseClicked

        if (proNom.getText().isEmpty() || proQuantite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information Manquante");
        } else if (availQty <= Integer.parseInt(proQuantite.getText())) {
            JOptionPane.showMessageDialog(this, "Stock Insuffisant");
        } else {
            i++;
            prodTot = uPrice * Double.parseDouble(proQuantite.getText());
            grandTotal = grandTotal + prodTot;
            if (i == 1) {
                textArea.setText(textArea.getText() + "===================== POINT FAMILLIAL =================== \n" + "NUM      PRODUIT      PRIX      QUANTITE      TOTAL\n" + i + "             " + proNom.getText() + "              " + uPrice + "             " + proQuantite.getText() + "            " + prodTot + "\n");
            } else {
                textArea.setText(textArea.getText() + i + "             " + proNom.getText() + "                " + uPrice + "             " + proQuantite.getText() + "            " + prodTot + "\n");
            }

            grdTotal.setText("Grand Total : " + grandTotal);

            availQty = availQty - Integer.parseInt(proQuantite.getText());
            updateProduct();
            clear();
            filtrer();
        }
    }//GEN-LAST:event_addProMouseClicked

    private void addProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        proNom.setText("");
        proQuantite.setText("");
    }//GEN-LAST:event_jButton4MouseClicked

    private void filtrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrerMouseClicked
            
        clear(); 
        filtrer();
          
    }//GEN-LAST:event_filtrerMouseClicked

    private void filtrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrerActionPerformed
    
    private void tableProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProMouseClicked

        DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
        int rowCount = tablePro.getSelectedRow();

        // proId.setText(model.getValueAt(rowCount, 0).toString());
        proNom.setText(model.getValueAt(rowCount, 1).toString());
        Prid = Integer.parseInt(model.getValueAt(rowCount, 0).toString());
        availQty = Integer.parseInt(model.getValueAt(rowCount, 2).toString());
        uPrice = Double.parseDouble(model.getValueAt(rowCount, 3).toString());
        proQuantite.setText("");

    }//GEN-LAST:event_tableProMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void proNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proNomActionPerformed

    private void proCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proCatActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void proCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proCatMouseClicked


    }//GEN-LAST:event_proCatMouseClicked

    private void proCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_proCatItemStateChanged

        
    }//GEN-LAST:event_proCatItemStateChanged

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        clear();
        selectProduct();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPro;
    private javax.swing.JButton filtrer;
    private javax.swing.JLabel grdTotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> proCat;
    private javax.swing.JTextField proNom;
    private javax.swing.JTextField proQuantite;
    private javax.swing.JTable tablePro;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
