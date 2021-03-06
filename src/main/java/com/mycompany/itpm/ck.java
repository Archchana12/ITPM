/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itpm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WindowsUser
 */
public class ck extends javax.swing.JFrame {

    /**
     * Creates new form ck
     */
    public ck() {
        initComponents();
        Connect();
        ck_Load();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_manage","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void ck_Load(){
        
        int c;
        try {
            pst=con.prepareStatement("select* from workiing_days");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
                Vector v2= new Vector();
                for(int i=1;i<=c;i++){
                   
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("lec_id"));
                    v2.add(rs.getString("l_name"));
                    v2.add(rs.getString("time_day"));
                    v2.add(rs.getString("no_days"));
                    v2.add(rs.getString("time_week"));
                    
                }
                d.addRow(v2);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_lecid = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_whw = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_up = new javax.swing.JButton();
        btn_dl = new javax.swing.JButton();
        btn_cnl = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_adw = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        cmb_wh = new javax.swing.JComboBox<>();
        cmb_wd = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Lec_ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Lecturer Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Working hours per day");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Number of working days");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Working time per week");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Lecture_ID", "Name", "Working time", "working   Days", "Working Hours per week"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        btn_add.setBackground(new java.awt.Color(255, 255, 102));
        btn_add.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_add.setText("add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_up.setBackground(new java.awt.Color(102, 255, 51));
        btn_up.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_up.setText("update");
        btn_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upActionPerformed(evt);
            }
        });

        btn_dl.setBackground(new java.awt.Color(255, 102, 51));
        btn_dl.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_dl.setText("delete");
        btn_dl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlActionPerformed(evt);
            }
        });

        btn_cnl.setBackground(new java.awt.Color(102, 51, 255));
        btn_cnl.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_cnl.setText("cancel");
        btn_cnl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cnlActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("ABC");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setText("Insitution");

        btn_adw.setBackground(new java.awt.Color(153, 255, 153));
        btn_adw.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_adw.setText("AddWorkingDays");
        btn_adw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adwActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setText("Add Working Duration");

        btn_back.setBackground(new java.awt.Color(255, 102, 255));
        btn_back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_back.setText("Back to main manu ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        cmb_wh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "7", "6", "5", "4", "3", "2", "1" }));

        cmb_wd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "5", "4", "2" }));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setText("Manage working days");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btn_adw, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4))
                                        .addGap(54, 54, 54)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_lecid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_wh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_wd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_whw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_up, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_cnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_dl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(136, 136, 136))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 173, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2)
                    .addComponent(btn_adw)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_lecid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_up)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btn_dl)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_wd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cnl)
                            .addComponent(txt_whw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_wh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(30, 30, 30)
                .addComponent(btn_back)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 970, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void AddRowToJTable(Object[] dataRow){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.addRow(dataRow);
    }
    
    
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String lec_id= txt_lecid.getText();
        String l_name= txt_name.getText();
        String time_day= cmb_wh.getSelectedItem().toString();
        String no_days= cmb_wd.getSelectedItem().toString();
        String time_week= txt_whw.getText();
        
        try {
            pst=con.prepareStatement("insert into workiing_days(lec_id,l_name,time_day,no_days,time_week)values(?,?,?,?,?)");
           
            pst.setString(1, lec_id);
            pst.setString(2, l_name);
            pst.setString(3, time_day);
            pst.setString(4, no_days);
            pst.setString(5, time_week);
           int k = pst.executeUpdate();
           
           if(k==1){
               JOptionPane.showMessageDialog(this," Added");
             
                txt_lecid.setText("");
                txt_name.setText("");
                cmb_wh.setSelectedItem("");
                cmb_wd.setSelectedItem("");
                txt_whw.setText("");
               txt_lecid.requestFocus();
               ck_Load();
               
               
           }
           else{
               JOptionPane.showMessageDialog(this,"Error");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
         int selectIndex= jTable1.getSelectedRow();
         
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
         
         txt_lecid.setText(d1.getValueAt(selectIndex, 1).toString());
         txt_name.setText(d1.getValueAt(selectIndex, 2).toString());
         cmb_wh.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
         cmb_wd.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
         txt_whw. setText(d1.getValueAt(selectIndex, 5).toString());       
         
         
        btn_add.setEnabled(false);
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upActionPerformed
        // TODO add your handling code here:
          DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
         int selectIndex= jTable1.getSelectedRow();
         
         int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
         
           
        String lec_id= txt_lecid.getText();
        String l_name= txt_name.getText();
        String time_day= cmb_wh.getSelectedItem().toString();
        String no_days= cmb_wd.getSelectedItem().toString();
        String time_week= txt_whw.getText();
        
        
        
        try {
            pst=con.prepareStatement("update workiing_days set lec_id=?,l_name=?,time_day=?,no_days=?,time_week=? where id=? ");
            
            pst.setString(1, lec_id);
            pst.setString(2, l_name);
            pst.setString(3, time_day);
            pst.setString(4, no_days);
            pst.setString(5, time_week);
            pst.setInt(6,id);
            
           int k = pst.executeUpdate();
           
           if(k==1){
               JOptionPane.showMessageDialog(this,"Updated");
             
                txt_lecid.setText("");
               txt_name.setText("");
                cmb_wh.setSelectedItem("");
                cmb_wd.setSelectedItem("");
               txt_name.requestFocus();
               btn_add.setEnabled(true);
               ck_Load();
               
               
           }
           else{
               JOptionPane.showMessageDialog(this,"Error");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_upActionPerformed

    private void btn_dlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlActionPerformed
        // TODO add your handling code here:
        
           DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
         int selectIndex= jTable1.getSelectedRow();
         
         int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
         
           
           
       
        
        
        try {
            pst=con.prepareStatement("delete from workiing_days  where id=?");
          
             pst.setInt(1, id);
            
           int k = pst.executeUpdate();
           
           if(k==1){
               JOptionPane.showMessageDialog(this,"Member Updated");
             
                 txt_lecid.setText("");
                 txt_name.setText("");
                 cmb_wh.setSelectedItem("");
                 cmb_wd.setSelectedItem("");
                 txt_whw.setText("");
                 txt_name.requestFocus();
               btn_add.setEnabled(true);
               ck_Load();
               
               
           }
           else{
               JOptionPane.showMessageDialog(this,"Error");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_dlActionPerformed

    private void btn_cnlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cnlActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_cnlActionPerformed

    private void btn_adwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adwActionPerformed
        // TODO add your handling code here:
        workingDays wd= new workingDays();
        
        wd.show(); // Display mainMenu here
        
        dispose(); // close current frame homepage
        
    }//GEN-LAST:event_btn_adwActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        
         mainMenu mm = new mainMenu();
        
            mm.show(); // Display mainMenu here
        
            dispose(); // close current frame homepage
    }//GEN-LAST:event_btn_backActionPerformed

                         
                     
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
            java.util.logging.Logger.getLogger(ck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ck().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_adw;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cnl;
    private javax.swing.JButton btn_dl;
    private javax.swing.JButton btn_up;
    private javax.swing.JComboBox<String> cmb_wd;
    private javax.swing.JComboBox<String> cmb_wh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_lecid;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_whw;
    // End of variables declaration//GEN-END:variables
}
