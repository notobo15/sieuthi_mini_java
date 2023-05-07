/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Order;
import BUS.BUS_OrderDetail;
import DTO.DTO_Customer;
import DTO.DTO_Order;
import DTO.DTO_OrderDetail;
import DTO.DTO_Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import GUI.*;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextArea;
/**
 *
 * @author ADMIN
 */
public class InHoaDon extends javax.swing.JFrame {

    private ArrayList<DTO_Product> list = new ArrayList<>();
    private Session session = new Session();
    private DTO_Customer cus = null;
    /**
     * Creates new form CustomerGUI
     */
    public InHoaDon(ArrayList<DTO_Product> list, DTO_Customer cus) throws SQLException {
        initComponents();
        this.list = list;
         this.cus = cus;
        writeDetail();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DonHangLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        btnPrint = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DonHangLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        DonHangLbl.setText("IN HÓA ĐƠN");

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        btnPrint.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnPrint.setText("ĐẶT HÀNG");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("HỦY");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(DonHangLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DonHangLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void displayDate() throws ParseException {
        Calendar ca = new GregorianCalendar();
        String day = ca.get(Calendar.DAY_OF_MONTH) + "";
        String month = ca.get(Calendar.MONTH) + 1 + "";
        String year = ca.get(Calendar.YEAR) + "";

        if (day.length() == 1) {
            day = "0" + day;
        }
        if (month.length() == 1) {
            month = "0" + month;
        }

        String dd = year + "-" + month + "-" + day;

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
    }

    private void writeDetail() throws SQLException {
        ta1.setText("");
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
        ta1.setText(ta1.getText() + "                      PHẦN MỀM QUẢN LÝ SIÊU THỊ MINI                      \n\n");
        ta1.setText(ta1.getText() + "    ĐỊA CHỈ: 123, Phường 5, Quận 5, Hồ Chí Minh                           \n");
        ta1.setText(ta1.getText() + "    SỐ ĐIỆN THOẠI: 0987654321                                             \n");
        ta1.setText(ta1.getText() + "                               --------------------------                        \n");
        ta1.setText(ta1.getText() + "                                       HÓA ĐƠN                                 \n\n");
        ta1.setText(ta1.getText() + "    ID:   1122312                                                         \n");
        ta1.setText(ta1.getText() + "    THỜI GIAN:  "+dateFormat.format(date)+"                                           \n");
        ta1.setText(ta1.getText() + "    NHÂN VIÊN: "+session.getName()+"                                              \n");
        ta1.setText(ta1.getText() + "    KHÁCH HÀNG: "+cus.getName()+"                                             \n");

        ta1.setText(ta1.getText() + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        ta1.setText(ta1.getText() + "   STT\tĐƠN GIÁ\tSỐ LƯỢNG\tTHÀNH TIỀN\t\n");
        ta1.setText(ta1.getText() + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        float sum = 0;
        for (int i = 0; i < list.size(); i++) {
            float thanh_tien = list.get(i).getQuantity() * list.get(i).getPrice();
            sum += thanh_tien;
            int stt = i + 1;
            ta1.setText(ta1.getText() + list.get(i).getName() + "\n");
            ta1.setText(ta1.getText() + "    " + (stt) + "\t" + list.get(i).getPrice() + "\t" + list.get(i).getQuantity() + "\t" + thanh_tien + "\t\n");

            ta1.setText(ta1.getText() + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        }

        ta1.setText(ta1.getText() + "    TỔNG TIỀN: \t\t" + sum + " VNĐ\n");
        ta1.setText(ta1.getText() + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        ta1.setText(ta1.getText() + "                   XIN CẢM ƠN QUÝ KHÁC.HEN GẶP LẠI.    \n");
    }

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (ta1.getText().equals("")) {
            AlertWarning aw = new AlertWarning("Chưa chọn hóa đơn!");
            aw.setVisible(true);
        } else
        try {
             
            ta1.print();
            BUS_Order bus_order = new BUS_Order();
            BUS_OrderDetail bus_order_detail = new BUS_OrderDetail();
            
            DTO_Order order = new DTO_Order(session.getId(), cus.getCustomerId());
            try {
                int id = Integer.parseInt(bus_order.add(order));
                
                for (int i = 0; i < list.size(); i++) {
                     DTO_OrderDetail detail = new DTO_OrderDetail(id, list.get(i).getProductId(), list.get(i).getPrice(), list.get(i).getQuantity());
                    bus_order_detail.add(detail);
                }
                this.dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (PrinterException ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

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
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DonHangLbl;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta1;
    // End of variables declaration//GEN-END:variables
}
