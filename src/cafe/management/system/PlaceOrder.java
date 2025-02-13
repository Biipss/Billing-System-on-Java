/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.management.system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import model.*;
import dao.*;
import java.io.FileOutputStream;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import cafe.management.system.Login;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfImage;
import java.sql.SQLException;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DELL
 */
public class PlaceOrder extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    public static String userEmail;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();

        loadData("Momo");

    }

    public PlaceOrder(String email) {
        userEmail = email;
    }

//    public void validateField() {
//        String customerName = txtCustoName.getText();
//        String customerMobileNumber = txtCustoMobileNumber.getText();
//      //  String customerEmail = txtCustoEmail.getText();
//        if (customerMobileNumber.matches(mobileNumberPattern) && customerMobileNumber.length() == 10) {
//            btnGenerateBill.setEnabled(true);
//        } else {
//            btnGenerateBill.setEnabled(false);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb1Category = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnATC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCustoTableNo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rrrrrr.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.png"))); // NOI18N
        jLabel8.setText("Category");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 180, -1));

        CategoryDAO categoryDAO = new CategoryDAO();
        cb1Category.setModel(new javax.swing.DefaultComboBoxModel(categoryDAO.getCategoryName(categoryDAO.returnQueryToGetCategoryNames())));
        cb1Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1CategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cb1Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 286, -1));

        table1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 560, 560, 280));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 220, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setText("Quantity");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setText("Price");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, -1, -1));

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 140, 205, -1));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 230, 205, -1));
        getContentPane().add(jSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 220, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 16, -1, 37));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 130, 40));

        btnATC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnATC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnATC.setText("Add");
        btnATC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATCActionPerformed(evt);
            }
        });
        getContentPane().add(btnATC, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, 130, 40));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 340, 670, 480));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setText("Grand Total: Rs.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 840, -1, -1));

        lblGrandTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblGrandTotal.setText("0000");
        getContentPane().add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 840, -1, -1));

        btnGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnGenerateBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnGenerateBill.setText("Generate Bill & Print");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 830, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Bill Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 163, -1));

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.setText("Search");
        getContentPane().add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 280, -1));

        table3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane3.setViewportView(table3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 280, 560, 260));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Table No.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        getContentPane().add(txtCustoTableNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/order.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1CategoryActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        String selected = cb1Category.getSelectedItem().toString();
        loadData(selected);

    }//GEN-LAST:event_cb1CategoryActionPerformed


    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new PlaceOrder().setVisible(true);
    }//GEN-LAST:event_btnClearActionPerformed
    static int grandTotal;


    private void btnATCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATCActionPerformed
        // TODO add your handling code here:
        String name;
        double price, quantity, total;
        name = txtName.getText();
        price = Double.parseDouble(txtPrice.getText());
        quantity = Double.parseDouble(jSpinner.getValue().toString());
        total = Double.parseDouble(txtTotal.getText());

        DefaultTableModel model = (DefaultTableModel) table2.getModel();

        // Add a new row to the table
        model.addRow(new Object[]{name, price, quantity, total});
        grandTotal += total;

        lblGrandTotal.setText("" + grandTotal);

    }//GEN-LAST:event_btnATCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        // TODO add your handling code here:
        int billId = Integer.parseInt(txtId.getText());
        //String customerName = txtCustoName.getText();
        //String customerMobileNumber = txtCustoMobileNumber.getText();
        String customerTableNo = txtCustoTableNo.getText();
       // String customerEmail = txtCustoEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
       System.out.println("CB: " + createdBy);
      
        Bill bill = new Bill();
        bill.setId(billId);
     // bill.String selected = cb1Category.getSelectedItem().toString();
        //bill.setName(customerName);
        //bill.setMobileNumber(customerMobileNumber);
        //bill.setEmail(customerEmail);
        bill.setDate(todaydate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
        bill.setTableNo(customerTableNo);
         System.out.println("TB: " + customerTableNo);
        try {
            BillDAO.save(bill);
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Create document
        String path = "E:\\PDF\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                Magic Hot Momo and Fast Food\n                                                    ");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("****************************************************************************************************************");
            doc.add(starLine);
            Paragraph para3 = new Paragraph("\tTableNo:\t"+ customerTableNo + "\nTotal Payment:\t Rs." + grandTotal);
            doc.add(para3);
            doc.add(starLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < table2.getRowCount(); i++) {
                String n = table2.getValueAt(i, 0).toString();
                String d = table2.getValueAt(i, 1).toString();
                String r = table2.getValueAt(i, 2).toString();
                String q = table2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);
            }
            // Specify the file path for the image
            String imagePath = "B:/Jyoti.jpg";

            // Create an Image object from the file path
            Image image = Image.getInstance(imagePath);

            // Adjust the image size as needed
            image.scaleAbsolute(350f, 350f);

            // Add the image to the document
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thankmsg = new Paragraph("Thankyou, Please Visit Again");
            doc.add(thankmsg);
            doc.add(image);
              // Close the document
            doc.close();

            // Display the PDF using the default PDF viewer
           OpenPdf.openPdfFile(path + billId + ".pdf");
            //OpenPdf.openById(String.valueOf(txtId));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String selected = txtSearch.getText();
        loadData(selected);
        cb1Category.setSelectedItem(selected);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
       int index = table2.getSelectedRow();
    if (index != -1) { // Check if a row is selected
    TableModel model = table2.getModel();
    String name = model.getValueAt(index, 0).toString();
    int a = JOptionPane.showConfirmDialog(null, "Do you want to Delete " + name + "?", "Select", JOptionPane.YES_NO_OPTION);
    if (a == 0) {
        // Assuming your ProductDAO has a method to delete by name
        String productName = model.getValueAt(index, 0).toString();
        ProductDAO productDAO = new ProductDAO(); 
        productDAO.delete(productName); // Pass the name or any unique identifier to delete
        ((DefaultTableModel) model).removeRow(index); // Remove the row from the table model
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
}

        
    }//GEN-LAST:event_table2MouseClicked

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnATC;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JComboBox<String> cb1Category;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTextField txtCustoTableNo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    private void loadData(String selected) {
       SpinnerModel model = new SpinnerNumberModel(1.0,0.0,100.0,0.5);// Initial value, minimum, maximum, step size
       jSpinner.setModel(model);
        try {
            // PlaceOrder po = new PlaceOrder();
            ProductDAO userDAO = new ProductDAO();
            BillDAO billID = new BillDAO();
            int bill = billID.getMaxBillId();
            bill++;
            txtId.setText(""+bill);
            txtName.setText("");
            txtPrice.setText("");
            table3.setModel(userDAO.buildTableModel(userDAO.getFilterCategoryName(selected)));
            //selectedData(price,quantity);
            table3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        int selectedRow = table3.getSelectedRow();

                        // Check if a row is selected
                        if (selectedRow != -1 && selectedRow < table3.getRowCount()) {
                            Object value = table3.getValueAt(selectedRow, 0); // Get value of the first cell
                            int id = Integer.parseInt(value.toString());
                            try {
                                table1.setModel(userDAO.buildTableModel(userDAO.getFilterQueryResult(id)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    int selectedRow = table1.getSelectedRow();

                    // Check if a row is selected
                    if (selectedRow != -1 && selectedRow < table1.getRowCount()) {
                        txtName.setText(table1.getValueAt(selectedRow, 1).toString());
                        txtPrice.setText(table1.getValueAt(selectedRow, 2).toString());

                        // Handle selected row here
                        price = Double.parseDouble(table1.getValueAt(selectedRow, 2).toString());
                        quantity = Double.parseDouble(jSpinner.getValue().toString());
                        selectedData(price, quantity);
                    }
                }
            });

            jSpinner.addChangeListener(new ChangeListener() { // add a change listener

                public void stateChanged(ChangeEvent e) {

                    quantity = Double.parseDouble(jSpinner.getValue().toString());
                    selectedData(price, quantity);
                    //System.out.println("s");
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void tableData() {
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = table1.getSelectedRow();

                // System.out.println(""+table1.getColumnName(selectedRow));
                txtName.setText(table1.getValueAt(selectedRow, 1).toString());
                txtPrice.setText(table1.getValueAt(selectedRow, 3).toString());
                // Handle selected row here

                price = Integer.parseInt(table1.getValueAt(selectedRow, 3).toString());
                quantity = Integer.parseInt(jSpinner.getValue().toString());
                //PlaceOrder po = new PlaceOrder(price,quantity);

                selectedData(price, quantity);

            }
        });
    }

    private void selectedData(double price, double quantity) {
        double total = price * quantity;
        txtTotal.setText("" + total);
    }
    static double price, quantity;
}
