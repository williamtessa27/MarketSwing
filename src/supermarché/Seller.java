/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarché;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tessa
 */
public class Seller extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    public Seller() {
        initComponents();
        selectSeller();
    }
    
    
    public void selectSeller(){
        
        try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from User1.SELLERTBL");
             
             while(rs.next()){
                 int sellid = rs.getInt("SELLID");
                 String name = rs.getString("SELLNAME");
                 String pass = rs.getString("SELLPASS");
                 String gender = rs.getString("SELLGENDER");
                 
                 Object[] obj = new Object [] {sellid,name,pass,gender};
                 DefaultTableModel model = (DefaultTableModel) sellerTable.getModel();
                 model.addRow(obj);
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addSeller(){
       
          if (sellId.getText().isEmpty() || sellName.getText().isEmpty() || sellPass.getText().isEmpty()){
               
            JOptionPane.showMessageDialog(this, "Information manquante");
          }
          else{
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "insert into SELLERTBL values(?,?,?,?)";
            PreparedStatement add = con.prepareStatement(sql);
            
            add.setInt(1, Integer.parseInt(sellId.getText()));
            add.setString(2, sellName.getText());
            add.setString(3, sellPass.getText());
            add.setString(4, genderCh.getSelectedItem().toString());
            
            int row = add.executeUpdate();
            if(row > 0){
           JOptionPane.showMessageDialog(this, "Vendeur Ajouter");
           con.close();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
          }
    }
    
    public void delete(){
        if (sellId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer un vendeur");
        }
        else{
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "delete from User1.SELLERTBL where SELLID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(sellId.getText()));
      
            int count = st.executeUpdate();
            
            if (count > 0) {
                JOptionPane.showMessageDialog(this, "Supprimer Avec Success");   
            }else
            {
                JOptionPane.showMessageDialog(this, "Echec de Suppression");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    public boolean updateSeller(){
        
        boolean isUpdate = false;
        if (sellName.getText().isEmpty() || sellPass.getText().isEmpty() || sellId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer un vendeur");
        }
        else {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "update User1.SELLERTBL set SELLNAME = ?, SELLPASS = ?, SELLGENDER = ? where SELLID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sellName.getText());
            st.setString(2, sellPass.getText());
            st.setString(3, genderCh.getSelectedItem().toString());
            st.setInt(4, Integer.parseInt(sellId.getText()));
            int count = st.executeUpdate();
            if (count > 0){
                isUpdate = true;
            }
            else {
                isUpdate = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return isUpdate;
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) sellerTable.getModel();
        model.setRowCount(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sellId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sellName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sellPass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        genderCh = new javax.swing.JComboBox<>();
        clearTb = new javax.swing.JButton();
        addTb = new javax.swing.JButton();
        editTb = new javax.swing.JButton();
        deleteTb = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sellerTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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
        jLabel6.setText("Listes Des vendeurs");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 230, -1));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("N° VENDEUR :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 40));

        sellId.setBackground(new java.awt.Color(255, 255, 255));
        sellId.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        sellId.setForeground(new java.awt.Color(255, 0, 0));
        sellId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel2.add(sellId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 270, 40));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText(" NOM :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 40));

        sellName.setBackground(new java.awt.Color(255, 255, 255));
        sellName.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        sellName.setForeground(new java.awt.Color(255, 0, 0));
        sellName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel2.add(sellName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, 40));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("MOT DE PASSE :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, 40));

        sellPass.setBackground(new java.awt.Color(255, 255, 255));
        sellPass.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        sellPass.setForeground(new java.awt.Color(255, 0, 0));
        sellPass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel2.add(sellPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 270, 40));

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("GENRE");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 90, 40));

        genderCh.setBackground(new java.awt.Color(255, 255, 255));
        genderCh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        genderCh.setForeground(new java.awt.Color(255, 0, 0));
        genderCh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMME", "FEMME" }));
        jPanel2.add(genderCh, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 270, 40));

        clearTb.setBackground(new java.awt.Color(255, 0, 0));
        clearTb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearTb.setForeground(new java.awt.Color(255, 255, 255));
        clearTb.setText("Effacer");
        clearTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearTbMouseClicked(evt);
            }
        });
        clearTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTbActionPerformed(evt);
            }
        });
        jPanel2.add(clearTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 140, 40));

        addTb.setBackground(new java.awt.Color(255, 0, 0));
        addTb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addTb.setForeground(new java.awt.Color(255, 255, 255));
        addTb.setText("Ajouter");
        addTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTbMouseClicked(evt);
            }
        });
        addTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTbActionPerformed(evt);
            }
        });
        jPanel2.add(addTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, 40));

        editTb.setBackground(new java.awt.Color(255, 0, 0));
        editTb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editTb.setForeground(new java.awt.Color(255, 255, 255));
        editTb.setText("Editer");
        editTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTbMouseClicked(evt);
            }
        });
        jPanel2.add(editTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 140, 40));

        deleteTb.setBackground(new java.awt.Color(255, 0, 0));
        deleteTb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteTb.setForeground(new java.awt.Color(255, 255, 255));
        deleteTb.setText("Supprimer");
        deleteTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTbMouseClicked(evt);
            }
        });
        jPanel2.add(deleteTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 140, 40));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("GESTION DES VENDEURS");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 290, -1));

        sellerTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sellerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "NOM", "MOT DE PASSE", "GENRE"
            }
        ));
        sellerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sellerTable.setRowHeight(30);
        sellerTable.setSelectionBackground(new java.awt.Color(255, 0, 0));
        sellerTable.setShowGrid(true);
        sellerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sellerTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 920, 280));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 1140, 670));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 30, 30));

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PRODUITS");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 110, -1));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DECONNEXION");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 710));

        setSize(new java.awt.Dimension(1329, 709));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void addTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTbMouseClicked
               addSeller();
                clearTable();
                selectSeller();
        
    }//GEN-LAST:event_addTbMouseClicked

    private void addTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTbActionPerformed

    private void sellerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellerTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)sellerTable.getModel();
        int rowCount = sellerTable.getSelectedRow();
        
        sellId.setText(model.getValueAt(rowCount, 0).toString());
        sellName.setText(model.getValueAt(rowCount, 1).toString());
        sellPass.setText(model.getValueAt(rowCount, 2).toString());
        genderCh.setSelectedItem(model.getValueAt(rowCount, 3));
       
    }//GEN-LAST:event_sellerTableMouseClicked

    private void clearTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearTbActionPerformed

    private void clearTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTbMouseClicked
        sellId.setText("");
        sellName.setText("");
        sellPass.setText("");
    }//GEN-LAST:event_clearTbMouseClicked

    private void deleteTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTbMouseClicked
        delete();
        clearTable();
        selectSeller();
    }//GEN-LAST:event_deleteTbMouseClicked

    private void editTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTbMouseClicked
        if(updateSeller() == true){
            JOptionPane.showMessageDialog(this, "Vendeur éditer");
            clearTable();
            selectSeller();
        }
        
    }//GEN-LAST:event_editTbMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Products pro = new Products();
        pro.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

   
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
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTb;
    private javax.swing.JButton clearTb;
    private javax.swing.JButton deleteTb;
    private javax.swing.JButton editTb;
    private javax.swing.JComboBox<String> genderCh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sellId;
    private javax.swing.JTextField sellName;
    private javax.swing.JTextField sellPass;
    private javax.swing.JTable sellerTable;
    // End of variables declaration//GEN-END:variables
}
