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
public class Session_NotAvai_lem extends javax.swing.JFrame {

    /**
     * Creates new form Session_NotAvailableTime
     */
    public Session_NotAvai_lem() {
        initComponents();
        Connect();
        notAviLec_load();
        combol();
        sesCombL();
        grupCombL();
        subCombL();
        
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
    void  notAviLec_load(){
        int c;
        try {
            pst=con.prepareStatement("select* from notavailablelecture");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
                Vector v2= new Vector();
                for(int i=1;i<=c;i++){
                   
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("lectureName"));
                    v2.add(rs.getString("groupId"));
                    v2.add(rs.getString("subgroupId"));
                    v2.add(rs.getString("sessionId"));
                    v2.add(rs.getString("time"));
                    
                }
                d.addRow(v2);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    void combol(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_manage","root","");
            pst = con.prepareStatement("Select distinct L_Name from lecturer");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
              cmb_lec.addItem(rs.getString("l_name"));
              cmb_lec.setSelectedItem("");
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void sesCombL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_manage","root","");
            pst = con.prepareStatement("Select distinct id from sessiondetails");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
              cmb_session.addItem(rs.getString("id"));
              cmb_session.setSelectedItem("");
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void grupCombL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_manage","root","");
            pst = con.prepareStatement("Select distinct groupid from student_group");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
              cmb_gid.addItem(rs.getString("groupid"));
              cmb_gid.setSelectedItem("");
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    void subCombL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_manage","root","");
            pst = con.prepareStatement("Select distinct subgroupid from student_group");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
              cmb_sid.addItem(rs.getString("subgroupid"));
              cmb_sid.setSelectedItem("");
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
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
        ABC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_Lecture = new javax.swing.JButton();
        Btn_Student = new javax.swing.JButton();
        Btn_Subject = new javax.swing.JButton();
        Btn_Location = new javax.swing.JButton();
        Btn_Tag = new javax.swing.JButton();
        Btn_Session = new javax.swing.JButton();
        Btn_Day = new javax.swing.JButton();
        Btn_Graph = new javax.swing.JButton();
        btn_con = new javax.swing.JButton();
        btn_nonOver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_lec = new javax.swing.JComboBox<>();
        cmb_gid = new javax.swing.JComboBox<>();
        cmb_sid = new javax.swing.JComboBox<>();
        cmb_time = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_dl = new javax.swing.JButton();
        btn_cnl = new javax.swing.JButton();
        cmb_session = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        ABC.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        ABC.setText("ABC");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Insitution");

        Btn_Lecture.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Lecture.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Lecture.setText("Lecturer");
        Btn_Lecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LectureActionPerformed(evt);
            }
        });

        Btn_Student.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Student.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Student.setText("Student");
        Btn_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_StudentActionPerformed(evt);
            }
        });

        Btn_Subject.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Subject.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Subject.setText("Subject");
        Btn_Subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SubjectActionPerformed(evt);
            }
        });

        Btn_Location.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Location.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Location.setText("Location");
        Btn_Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LocationActionPerformed(evt);
            }
        });

        Btn_Tag.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Tag.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Tag.setText("Tag");

        Btn_Session.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Session.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Session.setText("Session");
        Btn_Session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SessionActionPerformed(evt);
            }
        });

        Btn_Day.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Day.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Day.setText("Day & Time");
        Btn_Day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DayActionPerformed(evt);
            }
        });

        Btn_Graph.setBackground(new java.awt.Color(255, 255, 51));
        Btn_Graph.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Btn_Graph.setText("Graph");
        Btn_Graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GraphActionPerformed(evt);
            }
        });

        btn_con.setBackground(new java.awt.Color(153, 153, 255));
        btn_con.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_con.setText("Consecutive");

        btn_nonOver.setBackground(new java.awt.Color(153, 153, 255));
        btn_nonOver.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_nonOver.setText("Non Overlapping");
        btn_nonOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nonOverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Not available time");

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setText("Student");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton5.setText("Location");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Lecture");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer Name", "Group ID", "Sub Group ID", "Session ID", "Time"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Lecturer Name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Group ID");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Sub Group ID");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Time");

        cmb_lec.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cmb_gid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cmb_sid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cmb_time.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmb_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8.30", "9.30", "10.30", "11.30", "12.30", "1.30", "2.30", "" }));

        btn_add.setBackground(new java.awt.Color(255, 255, 102));
        btn_add.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 255, 102));
        btn_update.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
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

        cmb_session.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Session ID");

        btn_back.setBackground(new java.awt.Color(255, 102, 255));
        btn_back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btn_back.setText("Back to main manu ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_nonOver)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(143, 143, 143))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Tag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Day, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(Btn_Lecture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Btn_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(btn_con, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(405, 405, 405))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(160, 160, 160)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cmb_gid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmb_lec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmb_sid, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmb_time, javax.swing.GroupLayout.Alignment.LEADING, 0, 198, Short.MAX_VALUE)
                                                    .addComponent(cmb_session, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn_dl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_cnl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(btn_back))
                                        .addContainerGap(133, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ABC, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ABC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_con)
                    .addComponent(btn_nonOver)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_lec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Lecture)
                        .addGap(51, 51, 51)
                        .addComponent(Btn_Subject)
                        .addGap(61, 61, 61)
                        .addComponent(Btn_Student)
                        .addGap(46, 46, 46)))
                .addComponent(Btn_Location)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_gid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_Tag)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cmb_sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_cnl))))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Session)
                            .addComponent(btn_add)
                            .addComponent(jLabel8)
                            .addComponent(cmb_session, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Btn_Day))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(btn_back)
                        .addGap(142, 142, 142))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Btn_Graph)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public  void AddRowToJTable(Object[] dataRow){
         
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.addRow(dataRow);
    }

    
    private void Btn_LectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LectureActionPerformed
        // TODO add your handling code here:
        Addlecturer al =new Addlecturer();
        al.show();
        dispose();
    }//GEN-LAST:event_Btn_LectureActionPerformed

    private void btn_nonOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nonOverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nonOverActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
         DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
         int selectIndex= jTable1.getSelectedRow();
         
         int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
         
           
        String LectureName= cmb_lec.getSelectedItem().toString();
        String GroupID= cmb_gid.getSelectedItem().toString();
        String SubGroupID= cmb_sid.getSelectedItem().toString();
        String SessionID= cmb_session.getSelectedItem().toString();
        String Time= cmb_time.getSelectedItem().toString();
        
        
        try {
            pst=con.prepareStatement("update notavailablelecture set lectureName=?,groupId=?,subgroupId=?,sessionId=?,time=? where id=? ");
            
            pst.setString(1, LectureName);
            pst.setString(2, GroupID);
            pst.setString(3, SubGroupID);
            pst.setString(4, SessionID);
            pst.setString(5, Time);
            pst.setInt(6,id);
            
           int k = pst.executeUpdate();
           
           if(k==1){
               JOptionPane.showMessageDialog(this,"Updated");
             
                cmb_lec.setSelectedItem("");
                cmb_gid.setSelectedItem("");
                cmb_sid.setSelectedItem("");
                cmb_session.setSelectedItem("");
                cmb_time.setSelectedItem("");
                btn_add.setEnabled(true);
                notAviLec_load();
               
               
           }
           else{
               JOptionPane.showMessageDialog(this,"Error");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_dlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlActionPerformed
        // TODO add your handling code here:

        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex= jTable1.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        try {
            pst=con.prepareStatement("delete from notavailablelecture  where id=?");

            pst.setInt(1, id);

            int k = pst.executeUpdate();

            if(k==1){
                JOptionPane.showMessageDialog(this,"Not available lecture Updated");

               
                cmb_lec.setSelectedItem("");
                cmb_gid.setSelectedItem("");
                cmb_sid.setSelectedItem("");
                cmb_session.setSelectedItem("");
                cmb_time.setSelectedItem("");
                btn_add.setEnabled(true);
                notAviLec_load();

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
         // TODO add your handling code here:
         DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
         int selectIndex= jTable1.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
         
      
         cmb_lec.setSelectedItem(d1.getValueAt(selectIndex, 1).toString());
         cmb_gid.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
         cmb_sid.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
         cmb_session.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
         cmb_time.setSelectedItem(d1.getValueAt(selectIndex, 5).toString());
        btn_add.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        String LectureName= cmb_lec.getSelectedItem().toString();
        String GroupID= cmb_gid.getSelectedItem().toString();
        String SubGroupID= cmb_sid.getSelectedItem().toString();
        String SessionID= cmb_session.getSelectedItem().toString();
        String Time= cmb_time.getSelectedItem().toString();
        
        try {
            pst=con.prepareStatement("insert into notavailablelecture(lectureName,groupId,subgroupId,sessionId,time)values(?,?,?,?,?)");
           
            pst.setString(1, LectureName);
            pst.setString(2, GroupID);
            pst.setString(3, SubGroupID);
            pst.setString(4, SessionID);
            pst.setString(5, Time);
           int k = pst.executeUpdate();
           
           if(k==1){
               JOptionPane.showMessageDialog(this," Added");
             
                cmb_lec.setSelectedItem("");
                cmb_gid.setSelectedItem("");
                cmb_sid.setSelectedItem("");
                cmb_session.setSelectedItem("");
                cmb_time.setSelectedItem("");
                cmb_lec.requestFocus();
                notAviLec_load();
               
               
           }
           else{
               JOptionPane.showMessageDialog(this,"Error");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void Btn_SubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SubjectActionPerformed
        // TODO add your handling code here:
          Addsubject adl = new  Addsubject();
        adl.show();
        dispose();
    }//GEN-LAST:event_Btn_SubjectActionPerformed

    private void Btn_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_StudentActionPerformed
        // TODO add your handling code here:
        add_student  as =new add_student();
        as.show();
        dispose();
    }//GEN-LAST:event_Btn_StudentActionPerformed

    private void Btn_LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LocationActionPerformed
        // TODO add your handling code here:
        Addkocation adl = new Addkocation();
        adl.show();
        dispose();
    }//GEN-LAST:event_Btn_LocationActionPerformed

    private void Btn_DayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DayActionPerformed
        // TODO add your handling code here:
        addWorking ad = new addWorking();
        ad.show();;
        dispose();
    }//GEN-LAST:event_Btn_DayActionPerformed

    private void Btn_SessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SessionActionPerformed
        // TODO add your handling code here:
        AddSession  as =new AddSession();
        as.show();
        dispose();
    }//GEN-LAST:event_Btn_SessionActionPerformed

    private void Btn_GraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GraphActionPerformed
        // TODO add your handling code here:
         statistics1 s =new statistics1();
        s.show();
        dispose();
        
    }//GEN-LAST:event_Btn_GraphActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Session_NotAvai_sm nsm=new Session_NotAvai_sm();
        nsm.show();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Session_NotAvai_ml nsm=new Session_NotAvai_ml();
        nsm.show();
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here
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
            java.util.logging.Logger.getLogger(Session_NotAvai_lem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Session_NotAvai_lem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Session_NotAvai_lem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Session_NotAvai_lem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Session_NotAvai_lem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ABC;
    private javax.swing.JButton Btn_Day;
    private javax.swing.JButton Btn_Graph;
    private javax.swing.JButton Btn_Lecture;
    private javax.swing.JButton Btn_Location;
    private javax.swing.JButton Btn_Session;
    private javax.swing.JButton Btn_Student;
    private javax.swing.JButton Btn_Subject;
    private javax.swing.JButton Btn_Tag;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cnl;
    private javax.swing.JButton btn_con;
    private javax.swing.JButton btn_dl;
    private javax.swing.JButton btn_nonOver;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_gid;
    private javax.swing.JComboBox<String> cmb_lec;
    private javax.swing.JComboBox<String> cmb_session;
    private javax.swing.JComboBox<String> cmb_sid;
    private javax.swing.JComboBox<String> cmb_time;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
