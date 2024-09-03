/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.ConnectionFactory;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author DELL
 */
public class BillDAO {
    Connection con = null;
    Statement stmt= null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

//    public static String getID(){
//        int id=1;
//        try{
//            ResultSet rs = ConnectionFactory.getData("SELECT max(id) from bill");
//            if(rs.next()){
//                id=rs.getInt(1);
//                id=id+1;
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e); 
//        }
//        return String.valueOf(id);
//    }
    public BillDAO(){
        con = new ConnectionFactory().getConnection();
    }
    public static void save(Bill bill) throws Exception {
        System.out.println("TB:"+bill.getTableNo());
        String sql = "INSERT INTO bill VALUES('" + bill.getId() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "','" + bill.getTableNo() + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cms";
            Connection con = DriverManager.getConnection(url, "root", "");
            if (con != null) {
                Statement stmt = con.createStatement();
                int result = stmt.executeUpdate(sql);
                if (result != -1) {
                    JOptionPane.showMessageDialog(null, "Bill Added Successfully");
                    System.out.println("Bill Added Successfully");
                } else {
                    System.out.println("Couldn't add bill");
                }
                stmt.close();
                con.close();
            } else {
                System.out.println("Unable to get the connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getQueryResult(){
        String sql = "SELECT * FROM bill";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }
    public int getMaxBillId(){
        int maxId=0;
        String sql = "SELECT MAX(id) AS max_id FROM bill";
        try{
            stmt = con.createStatement();
            rs=stmt.executeQuery(sql);
              if (rs.next()) {
                    maxId = rs.getInt("max_id");
                    //System.out.println("Max ID: " + maxId);
                } else {
                    System.out.println("No data found in the table.");
                }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return maxId; 
    }
    
    public ResultSet getFilterDate(String date){
        String sql = "SELECT * FROM bill WHERE date LIKE '%"+date+"%'";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }

    public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int i = 1; i <= columnCount; i++) {
                vector.add(rs.getObject(i));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}
