/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itpm;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author abinath
 */
public class statistics1 extends javax.swing.JFrame {

    Connection connect=null;
    /**
     * Creates new form statistics1
     */
    public statistics1() {
        initComponents();
        LectureName.setEditable(false);
        SubjectName.setEditable(false);
        Group.setEditable(false);
        getDetails();
    }

    private void getDetails(){
        double lech = 0;
        double labh = 0;
      try 
                {
                Class.forName("com.mysql.jdbc.Driver");
                connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","");
                System.out.println("database is connected");
                
            
            PreparedStatement sql=connect.prepareStatement("SELECT COUNT(ID) as ID FROM `locationdetails`");
        
                ResultSet Q=sql.executeQuery();
                 while(Q.next())
                 {
                    
                  System.out.println(Q.getString(1));                
                     
             
                  Room.setLabel(Q.getString(1));
                 
                 } 
                  PreparedStatement sql1=connect.prepareStatement("SELECT COUNT(`Employeeid`) AS Id FROM `lecturers details`");
        
                ResultSet Q1=sql1.executeQuery();
                 while(Q1.next())
                 {
                    
                  System.out.println(Q1.getString(1));                
                     
           
                  Lecturer.setLabel(Q1.getString(1));
                 
                 } 
                 
                   PreparedStatement sql2=connect.prepareStatement("SELECT COUNT(`ID`) AS Id FROM `student details`");
        
                ResultSet Q2=sql2.executeQuery();
                 while(Q2.next())
                 {
                    
                  System.out.println(Q2.getString(1));                
                     
                 
                  Student.setLabel(Q2.getString(1));
                 
                 } 
                 
                 
                  PreparedStatement sql3=connect.prepareStatement("SELECT COUNT(`subjectcode`) AS Id FROM `subject details`");
        
                ResultSet Q3=sql3.executeQuery();
                 while(Q3.next())
                 {
                    
                  System.out.println(Q3.getString(1));                
                     
                 
                  Subject.setLabel(Q3.getString(1));
                 
                 } 
                 
                 
                 
                 
                 
                 
                 PreparedStatement sql4=connect.prepareStatement("SELECT `Lecturername` FROM `lecturers details` ORDER BY `Employeeid` DESC LIMIT 1");
        
                ResultSet Q4=sql4.executeQuery();
                 while(Q4.next())
                 {
                    
                  System.out.println(Q4.getString(1));                
                     
                 
                  LectureName.setText(Q4.getString(1));
                 
                 } 
                 
                 
                 
                 
                 
                 
                 
                  PreparedStatement sql5=connect.prepareStatement("SELECT `Groupid` FROM `student details` ORDER BY `Groupid` DESC LIMIT 1");
        
                ResultSet Q5=sql5.executeQuery();
                 while(Q5.next())
                 {
                    
                  System.out.println(Q5.getString(1));                
                     
                 
                  Group.setText(Q5.getString(1));
                 
                 } 
                 
                 
       
                 
                 
                  PreparedStatement sql6=connect.prepareStatement("SELECT `subjectcode` FROM `subject details` ORDER BY `subjectcode` DESC LIMIT 1");
        
                ResultSet Q6=sql6.executeQuery();
                 while(Q6.next())
                 {
                    
                  System.out.println(Q6.getString(1));                
                     
                 
                  SubjectName.setText(Q6.getString(1));
                 
                 } 
                 
                 //SELECT COUNT(Capacity) AS cap FROM `location` WHERE `Room Type`="Lecturehall"
                 
                 PreparedStatement sql7=connect.prepareStatement("SELECT COUNT(capacity) AS cap FROM `locationdetails` WHERE `roomtype`='Lecture Hall'");
                 
                ResultSet Q7=sql7.executeQuery();
                 while(Q7.next())
                 {
                    
                  System.out.println(Q7.getString(1));                
                     
                 
                 lech=Double.parseDouble(Q7.getString(1));
                 
                 } 
                 
                 PreparedStatement sql8=connect.prepareStatement("SELECT COUNT(capacity) AS cap FROM `locationdetails` WHERE `roomtype`='Laboratory'");
                 
                ResultSet Q8=sql8.executeQuery();
                 while(Q8.next())
                 {
                    
                  System.out.println(Q8.getString(1));                
                     
                 
                 labh=Double.parseDouble(Q8.getString(1));
                 
                 } 
       DefaultPieDataset pie=new  DefaultPieDataset();
       
       pie.setValue( "laboratory",labh);
       pie.setValue("lecturehall",lech);
       JFreeChart piechart=ChartFactory.createPieChart3D("Hall Detail", pie,false,true,false);
      
       PiePlot h=(PiePlot)piechart.getPlot();
     

       ChartPanel p=new ChartPanel(piechart);
      jPanel2.removeAll();
      jPanel2.add(p);
      jPanel2.updateUI();
                 
                 
                }
        catch(Exception a){
                System.out.println("uuuuu");
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
        Room = new javax.swing.JButton();
        Subject = new javax.swing.JButton();
        Student = new javax.swing.JButton();
        Lecturer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LectureName = new javax.swing.JTextField();
        Group = new javax.swing.JTextField();
        SubjectName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Room.setText("0");
        Room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(evt);
            }
        });

        Subject.setText("0");
        Subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectActionPerformed(evt);
            }
        });

        Student.setText("0");
        Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentActionPerformed(evt);
            }
        });

        Lecturer.setText("0");
        Lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LecturerActionPerformed(evt);
            }
        });

        jLabel1.setText("Registered Lecturers");

        jLabel2.setText("Registered Students");

        jLabel3.setText("Registered Subjects");

        jLabel4.setText("Registered Rooms");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setText("Latest Lecturer");

        jLabel6.setText("Latest Group");

        jLabel7.setText("Latest Subject");

        LectureName.setText(" ");
        LectureName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LectureNameActionPerformed(evt);
            }
        });

        Group.setText(" ");

        SubjectName.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Group, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(LectureName)
                    .addComponent(SubjectName))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LectureName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(303, 303, 303))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 40, 1039, 472);

        btn_back.setBackground(new java.awt.Color(255, 102, 255));
        btn_back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_back.setText("Back to main manu ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(20, 0, 163, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomActionPerformed

    private void SubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectActionPerformed

    private void StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentActionPerformed

    private void LecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LecturerActionPerformed
       
    }//GEN-LAST:event_LecturerActionPerformed

    private void LectureNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LectureNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LectureNameActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        mainMenu mm = new mainMenu();
        mm.show();
        dispose();
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
            java.util.logging.Logger.getLogger(statistics1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(statistics1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(statistics1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(statistics1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statistics1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Group;
    private javax.swing.JTextField LectureName;
    private javax.swing.JButton Lecturer;
    private javax.swing.JButton Room;
    private javax.swing.JButton Student;
    private javax.swing.JButton Subject;
    private javax.swing.JTextField SubjectName;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
