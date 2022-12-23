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
public class Products extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Products() {
        initComponents();
        selectProduct();
        getCat();
    }
    
    public void selectProduct(){
        
        try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from User1.PRODUCTTBL");
             
             while(rs.next()){
                 int cid = rs.getInt("PRODUCTID");
                 String name = rs.getString("PRODUCTNAME");
                 int qty = rs.getInt("PRODUCTQTY");
                 int prix = rs.getInt("PRODUCTPRICE");
                 String cat = rs.getString("PRODUCTCATEGORIE");
                
                 
                 Object[] obj = new Object [] {cid,name,qty,prix,cat};
                 DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
                 model.addRow(obj);
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getCat(){
        
        try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from User1.CATEGORYTBL");
             
             while(rs.next()){
                 String name = rs.getString("CATNAME");
                 proCat.addItem(name);
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void addProduct(){
       
          if (proId.getText().isEmpty() || proQuantite.getText().isEmpty() || proNom.getText().isEmpty() || proPrix.getText().isEmpty()){
               
            JOptionPane.showMessageDialog(this, "Information manquante");
          }
          else{
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "insert into PRODUCTTBL values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(1, Integer.parseInt(proId.getText()));
            st.setString(2, proNom.getText());
            st.setInt(3, Integer.parseInt(proQuantite.getText()));
            st.setInt(4, Integer.parseInt(proPrix.getText()));
            st.setString(5, proCat.getSelectedItem().toString());
           
            
            int row = st.executeUpdate();
            if(row > 0){
           JOptionPane.showMessageDialog(this, "Produit Ajouter");
           con.close();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
          }
    }

    public void deleteProduct(){
        if (proId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer un produit");
        }
        else{
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "delete from User1.PRODUCTTBL where PRODUCTID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(proId.getText()));
      
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
    
    public void updateProduct(){
        
     
        if (proQuantite.getText().isEmpty() || proQuantite.getText().isEmpty() || proId.getText().isEmpty() || proPrix.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Entrer un produit");
        }
        else {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SuperMarketdb","User1","1234");
            String sql = "update User1.PRODUCTTBL set PRODUCTNAME = ?, PRODUCTQTY = ?, PRODUCTPRICE = ?, PRODUCTCATEGORIE = ? where PRODUCTID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, proNom.getText());
            st.setInt(2, Integer.parseInt(proQuantite.getText()));
            st.setInt(3, Integer.parseInt(proPrix.getText()));
            st.setString(4, proCat.getSelectedItem().toString());
            st.setInt(5, Integer.parseInt(proId.getText()));
            int count = st.executeUpdate();
            if (count > 0){
                JOptionPane.showMessageDialog(this, "Produit modifier avec success");
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
  
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
        model.setRowCount(0);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        proId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        proQuantite = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        addPro = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePro = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        proNom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        proPrix = new javax.swing.JTextField();
        proCat = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

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
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 240, -1));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("N° PRODUITS :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 40));

        proId.setBackground(new java.awt.Color(255, 255, 255));
        proId.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proId.setForeground(new java.awt.Color(255, 0, 0));
        proId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proIdActionPerformed(evt);
            }
        });
        jPanel2.add(proId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 270, 40));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Quantité :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, 40));

        proQuantite.setBackground(new java.awt.Color(255, 255, 255));
        proQuantite.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proQuantite.setForeground(new java.awt.Color(255, 0, 0));
        proQuantite.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proQuantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proQuantiteActionPerformed(evt);
            }
        });
        jPanel2.add(proQuantite, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 270, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Effacer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 140, 40));

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
        jPanel2.add(addPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 140, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Editer");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 140, 40));

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
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 140, 40));

        tablePro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablePro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "NOM DU PRODUIT ", "QUANTITE (KGS)", "PRIX (FCFA)", "CATEGORIE"
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 990, 280));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("NOM :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 40));

        proNom.setBackground(new java.awt.Color(255, 255, 255));
        proNom.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proNom.setForeground(new java.awt.Color(255, 0, 0));
        proNom.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proNomActionPerformed(evt);
            }
        });
        jPanel2.add(proNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 270, 40));

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Prix :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, -1, 40));

        proPrix.setBackground(new java.awt.Color(255, 255, 255));
        proPrix.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        proPrix.setForeground(new java.awt.Color(255, 0, 0));
        proPrix.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        proPrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proPrixActionPerformed(evt);
            }
        });
        jPanel2.add(proPrix, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 270, 40));

        proCat.setBackground(new java.awt.Color(255, 255, 255));
        proCat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        proCat.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(proCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 270, 40));

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Categorie");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 90, 40));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("GESTIONS DES PRODUITS");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 300, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 1140, 710));

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

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FACTURATION");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 140, -1));

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DECONNEXION");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 160, -1));

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("VENDEUR");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel16.setBackground(new java.awt.Color(255, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CATEGORIE");
        jLabel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel16MouseDragged(evt);
            }
        });
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 750));

        setSize(new java.awt.Dimension(1330, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void proNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proNomActionPerformed

    private void addProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProActionPerformed

    private void addProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProMouseClicked
        addProduct();
        clearTable();
        selectProduct();
    }//GEN-LAST:event_addProMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        proId.setText("");
        proQuantite.setText("");
        proNom.setText("");
        proPrix.setText("");
    }//GEN-LAST:event_jButton2MouseClicked

    private void tableProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProMouseClicked
        DefaultTableModel model = (DefaultTableModel) tablePro.getModel();
        int rowCount = tablePro.getSelectedRow();
        
        proId.setText(model.getValueAt(rowCount, 0).toString());
        proNom.setText(model.getValueAt(rowCount, 1).toString());
        proQuantite.setText(model.getValueAt(rowCount, 2).toString());
        proPrix.setText(model.getValueAt(rowCount, 3).toString());
       
    }//GEN-LAST:event_tableProMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        deleteProduct();
        clearTable();
        selectProduct();
    }//GEN-LAST:event_jButton5MouseClicked

    private void proQuantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proQuantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proQuantiteActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        updateProduct();
        clearTable();
        selectProduct();
    }//GEN-LAST:event_jButton4MouseClicked

    private void proPrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proPrixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proPrixActionPerformed

    private void proIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proIdActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Seller sell = new Seller();
        sell.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Selling sel = new Selling();
        sel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
         Login login = new Login();
         login.setVisible(true);
         dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked

      Category cat = new Category();
      cat.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseDragged

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
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPro;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> proCat;
    private javax.swing.JTextField proId;
    private javax.swing.JTextField proNom;
    private javax.swing.JTextField proPrix;
    private javax.swing.JTextField proQuantite;
    private javax.swing.JTable tablePro;
    // End of variables declaration//GEN-END:variables
}
