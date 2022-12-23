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
public class Category extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Category() {
        initComponents();
        selectSeller();
    }
    
    public void selectSeller(){
        
        try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from User1.CATEGORYTBL");
             
             while(rs.next()){
                 int cid = rs.getInt("CATID");
                 String name = rs.getString("CATNAME");
                 String description = rs.getString("CATDESC");
                
                 
                 Object[] obj = new Object [] {cid,name,description};
                 DefaultTableModel model = (DefaultTableModel) tableCat.getModel();
                 model.addRow(obj);
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addSeller(){
       
          if (cId.getText().isEmpty() || cName.getText().isEmpty() || cDescription.getText().isEmpty()){
               
            JOptionPane.showMessageDialog(this, "Information manquante");
          }
          else{
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "insert into CATEGORYTBL values(?,?,?)";
            PreparedStatement add = con.prepareStatement(sql);
            
            add.setInt(1, Integer.parseInt(cId.getText()));
            add.setString(2, cName.getText());
            add.setString(3, cDescription.getText());
           
            
            int row = add.executeUpdate();
            if(row > 0){
           JOptionPane.showMessageDialog(this, "Categorie Ajouter");
           con.close();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
          }
    }

    public void deleteCtegory(){
        if (cId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer une categorie");
        }
        else{
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "delete from User1.CATEGORYTBL where CATID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(cId.getText()));
      
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
    
    public void updateCategorie(){
        
     
        if (cName.getText().isEmpty() || cName.getText().isEmpty() || cId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer une categorie");
        }
        else {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "update User1.CATEGORYTBL set CATNAME = ?, CATDESC = ?where CATID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cName.getText());
            st.setString(2, cDescription.getText());
            st.setInt(3, Integer.parseInt(cId.getText()));
            int count = st.executeUpdate();
            if (count > 0){
                JOptionPane.showMessageDialog(this, "Categorie modifier avec success");
            }
            else {
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
  
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tableCat.getModel();
        model.setRowCount(0);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCat = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cDescription = new javax.swing.JTextField();
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
        jLabel6.setText("Listes Des Categories");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 240, -1));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("N° CATEGORIE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 40));

        cId.setBackground(new java.awt.Color(255, 255, 255));
        cId.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        cId.setForeground(new java.awt.Color(255, 0, 0));
        cId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel2.add(cId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 270, 40));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("NOM");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, 40));

        cName.setBackground(new java.awt.Color(255, 255, 255));
        cName.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        cName.setForeground(new java.awt.Color(255, 0, 0));
        cName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        cName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameActionPerformed(evt);
            }
        });
        jPanel2.add(cName, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 270, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Effacer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 140, 40));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ajouter");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Editer");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 140, 40));

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Supprimer");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 140, 40));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("GESTIONS DES CATEGORIES");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 320, -1));

        tableCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tableCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "NOM", "DESCRIPTION"
            }
        ));
        tableCat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableCat.setRowHeight(30);
        tableCat.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tableCat.setShowGrid(true);
        tableCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCat);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 780, 280));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("DESCRIPTION");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 40));

        cDescription.setBackground(new java.awt.Color(255, 255, 255));
        cDescription.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        cDescription.setForeground(new java.awt.Color(255, 0, 0));
        cDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        cDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDescriptionActionPerformed(evt);
            }
        });
        jPanel2.add(cDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 270, 40));

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
        jLabel12.setText("DECONNEXION");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 150, -1));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PRODUIT");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 730));

        setSize(new java.awt.Dimension(1330, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void cDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDescriptionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        addSeller();
        clearTable();
        selectSeller();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        cId.setText("");
        cName.setText("");
        cDescription.setText("");
    }//GEN-LAST:event_jButton2MouseClicked

    private void tableCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCatMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableCat.getModel();
        int rowCount = tableCat.getSelectedRow();
        
        cId.setText(model.getValueAt(rowCount, 0).toString());
        cName.setText(model.getValueAt(rowCount, 1).toString());
        cDescription.setText(model.getValueAt(rowCount, 2).toString());
    }//GEN-LAST:event_tableCatMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        deleteCtegory();
        clearTable();
        selectSeller();
    }//GEN-LAST:event_jButton5MouseClicked

    private void cNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        updateCategorie();
        clearTable();
        selectSeller();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Products pro = new Products();
        pro.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cDescription;
    private javax.swing.JTextField cId;
    private javax.swing.JTextField cName;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCat;
    // End of variables declaration//GEN-END:variables
}
