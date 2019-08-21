/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoMailMain;

import static GoMailMain.LoginAndSignUp.LoggedEmail;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeami
 */
public final class MailBox extends javax.swing.JFrame {

    String c = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Connection con = ConnectDB.connect();
    static ArrayList<Mails> mails = new ArrayList<>();
    static int date[] = new int[100000];

    public MailBox() {
        initComponents();
        getMails();
        this.setLocationRelativeTo(null);

    }

    void SortByDate() {
        refreshTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < mails.size(); i++) {
            date[i] = mails.get(i).getDate();
        }

        int temp = 0;
        int n = mails.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (date[j - 1] > date[j]) {

                    temp = date[j - 1];
                    date[j - 1] = date[j];
                    date[j] = temp;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (date[i] == mails.get(j).getDate()) {
                    Object[] row = new Object[4];
                    row[0] = mails.get(j).getDate();
                    row[1] = mails.get(j).getSender();
                    row[2] = mails.get(j).getSubjectA();
                    row[3] = mails.get(j).getBodyA();
                    model.addRow(row);
                }
            }

        }
    }

    void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
    }

    void print() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < mails.size(); i++) {
            if ((mails.get(i).getSender().equalsIgnoreCase(jTextField1.getText()))) {

                Object[] row = new Object[4];
                row[0] = mails.get(i).getDate();
                row[1] = mails.get(i).getSender();
                row[2] = mails.get(i).getSubjectA();
                row[3] = mails.get(i).getBodyA();
                jTextPane1.setText(mails.get(i).getBodyA());
                model.addRow(row);
            }
        }
    }

    void getMails() {
        mails.clear();
        try {
            c = "Select * from mails where receiver='" + LoggedEmail + "'";
            stm = con.prepareStatement(c);
            rs = stm.executeQuery();
            while (rs.next()) {
                Mails mail = new Mails(rs.getString("sender"), rs.getString("receiver"), rs.getString("subject"), rs.getString("body"), rs.getInt("mailcode"), rs.getInt("date"));
                mails.add(mail);

            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            for (Mails mail : mails) {
                Object[] row = new Object[4];
                row[0] = mail.getDate();
                row[1] = mail.getSender();
                row[2] = mail.getSubjectA();
                row[3] = mail.getBodyA();
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void SwitchPanel(JPanel jp1) {
        jLayeredPane1.removeAll();

        jp1.repaint();
        jp1.validate();
        jLayeredPane1.add(jp1);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panel_inbox = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        panel_compose = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpEmailBody = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        txtEmail_Receiver = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail_Subject = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(43, 87, 151));

        jButton1.setText("Compose ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Inbox");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(421, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 290, 710);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        panel_inbox.setBackground(new java.awt.Color(218, 83, 44));
        panel_inbox.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "From", "Subject", "Body"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 102, 102));
        jTable1.setSelectionForeground(new java.awt.Color(102, 153, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        panel_inbox.add(jScrollPane2);
        jScrollPane2.setBounds(0, 86, 370, 624);

        jTextPane1.setBackground(new java.awt.Color(239, 244, 255));
        jScrollPane3.setViewportView(jTextPane1);

        panel_inbox.add(jScrollPane3);
        jScrollPane3.setBounds(366, 86, 400, 624);

        jTextField1.setText("search email by sender");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        panel_inbox.add(jTextField1);
        jTextField1.setBounds(470, 30, 210, 20);

        jButton4.setText("Search");
        panel_inbox.add(jButton4);
        jButton4.setBounds(780, 31, 65, 23);

        jButton5.setText("Sort");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel_inbox.add(jButton5);
        jButton5.setBounds(10, 50, 120, 23);

        jButton6.setText("search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel_inbox.add(jButton6);
        jButton6.setBounds(690, 30, 65, 23);

        jLayeredPane1.add(panel_inbox, "card2");

        panel_compose.setBackground(new java.awt.Color(0, 255, 204));

        jScrollPane1.setViewportView(txtpEmailBody);

        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtEmail_Receiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail_ReceiverActionPerformed(evt);
            }
        });

        jLabel1.setText("Receivers Email:");

        jLabel2.setText("Subject: ");

        javax.swing.GroupLayout panel_composeLayout = new javax.swing.GroupLayout(panel_compose);
        panel_compose.setLayout(panel_composeLayout);
        panel_composeLayout.setHorizontalGroup(
            panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panel_composeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_composeLayout.createSequentialGroup()
                        .addGap(0, 348, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(355, 355, 355))
                    .addGroup(panel_composeLayout.createSequentialGroup()
                        .addGroup(panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail_Receiver)
                            .addComponent(txtEmail_Subject, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel_composeLayout.setVerticalGroup(
            panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_composeLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail_Receiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_composeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLayeredPane1.add(panel_compose, "card3");

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(290, 0, 770, 710);

        setBounds(0, 0, 1072, 748);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SwitchPanel(panel_compose);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        SwitchPanel(panel_inbox);
        refreshTable();
        getMails();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtEmail_ReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail_ReceiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail_ReceiverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            java.util.Date d = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYYY");
            String s = formatter.format(d);
            int x=Integer.parseInt(s);
            
            c = "insert into mails(sender,receiver,subject,body,date) values (?,?,?,?,?)";
            stm = con.prepareStatement(c);
            stm.setString(1, LoginAndSignUp.LoggedEmail);
            stm.setString(2, txtEmail_Receiver.getText());
            stm.setString(3, txtEmail_Subject.getText());
            stm.setString(4, txtpEmailBody.getText());
            stm.setInt(5, x);

            stm.execute();
           
            JOptionPane.showMessageDialog(null, "Sent", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtEmail_Receiver.setText(null);
            txtEmail_Subject.setText(null);
            txtpEmailBody.setText(null);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        refreshTable();
        print();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SortByDate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed

    }//GEN-LAST:event_jTextField1MousePressed

    private void jTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseEntered
        jTextField1.setText(null);
    }//GEN-LAST:event_jTextField1MouseEntered

    private void jTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseExited
        jTextField1.setText("Search mail by sender");
    }//GEN-LAST:event_jTextField1MouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selected_row = jTable1.getSelectedRow();
        jTextPane1.setText(model.getValueAt(selected_row, 3).toString());

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel panel_compose;
    private javax.swing.JPanel panel_inbox;
    private javax.swing.JTextField txtEmail_Receiver;
    private javax.swing.JTextField txtEmail_Subject;
    private javax.swing.JTextPane txtpEmailBody;
    // End of variables declaration//GEN-END:variables
}
