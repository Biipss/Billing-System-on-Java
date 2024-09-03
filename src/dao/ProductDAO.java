/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.ConnectionFactory;
import model.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductDAO {
    Connection con = null;
    Statement stmt= null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    String[] searchColumnNames ={"ID","Name","Category","Price"};
    
    public ProductDAO(){
        con = new ConnectionFactory().getConnection();
    }
    
    public void saveProduct(Product product){
            String query="INSERT into product VALUES (?,?,?,?)";
            try{
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,product.getId());
            pstmt.setString(2,product.getName());
            pstmt.setInt(3,product.getPrice());
            pstmt.setInt(4,product.getSub_category_id());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Product saved successfully");
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getQueryResult(){
        String sql = "SELECT * FROM product";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }
    
    public ResultSet getFilterQueryResult(int selected){
        String sql = "SELECT * FROM `product` where  sub_category_id = "+selected+"";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }
    public ResultSet getFilterCategoryName(String selected){
        String sql = "SELECT * FROM `sub_category` where  name LIKE '"+"%"+selected+"'";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }
    
    public ResultSet getSearchQueryResult(String selected){
        String sql = "SELECT * FROM `product` where  category LIKE '"+selected+"'";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs; 
    }
    
    public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        
        for(int i=1; i<=columnCount; i++){
            columnNames.add(metaData.getColumnName(i));
        }
        
    Vector<Vector<Object>> data = new  Vector<Vector<Object>>();
    while(rs.next()){
        Vector<Object> vector = new Vector<Object>();
        for(int i=1; i<=columnCount; i++){
            vector.add(rs.getObject(i));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
    }    
    public String returnQueryToGetColumnNames(){
        String query = "SELECT id,name,category,price FROM product";
        return query;
    }
    
    
      public void delete(String value){
        try{
            String query ="DELETE FROM product where id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,value);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"One record deleted.");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Product editUser(JTable table){
        Product userEdit = new Product();
       userEdit.setId((Integer)table.getValueAt(table.getSelectedRow(),0));
        userEdit.setName((String)table.getValueAt(table.getSelectedRow(),1));
        userEdit.setPrice((Integer) table.getValueAt(table.getSelectedRow(),2));
        userEdit.setSub_category_id((Integer)table.getValueAt(table.getSelectedRow(),3));
        return userEdit;
    }

    public void updateUser(Product userUpdate) {
        try{
            String query = "UPDATE product set name=?,sub_category_id=?, price=? where id=?";
            pstmt= con.prepareStatement(query);
            pstmt.setInt(4,userUpdate.getId());
            pstmt.setString(1,userUpdate.getName());    
            pstmt.setInt(2,userUpdate.getSub_category_id());
            pstmt.setInt(3,userUpdate.getPrice());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"One record updated");
    }catch (Exception e) {
            e.printStackTrace();
        }
               
    }
    
    
    
    public  Vector<String>getColumnName(String query){
        Vector<String> columnNames = new Vector<String>();
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int column = 1; column <=columnCount; column++){
                columnNames.add(metaData.getColumnName(column));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return columnNames;
    }
   public Vector<String> getCName(){
       Vector<String> columnNames = new Vector<String>();
      // columnNames.add("ID");
       columnNames.add("Name");
       columnNames.add("Category");
       columnNames.add("Price");
   
       return columnNames;
   }
    
}
