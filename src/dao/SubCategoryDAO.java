/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DB.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author DELL
 */
public class SubCategoryDAO {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String[] searchColumnNames = {"ID", " Name", "Category_ID"};

    public SubCategoryDAO() {
        con = new ConnectionFactory().getConnection();
    }

    public String returnQueryToGetSubCategoryNames() {
        String query = "SELECT name FROM sub_category";
        return query;
    }

    public String returnQueryToGetSubCategoryValue(String value) {
        String query = "SELECT name FROM sub_category WHERE name LIKE '%" + value + "'";
        return query;
    }

    public String returnQueryToGetSubCategoryID(String value) {
        String query = "SELECT id FROM sub_category WHERE name LIKE '%" + value + "'";
        return query;
    }
    
    public void saveSubCategory(SubCategory category){
            String query="INSERT into sub_category VALUES (?,?,?)";
            try{
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,category.getId());
            pstmt.setString(2,category.getName());
            pstmt.setInt(3,category.getCategory_id());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Sub-Category saved successfully");
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getSubCategoryID(String query) {
        String categoryID = "";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String name = rs.getString(1);
                categoryID = name;

                // System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryID;
    }

    public ResultSet getQueryResult() {
        String sql = "SELECT * FROM sub_category";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public Vector<String> getSubCategoryName(String query) {
        Vector<String> categoryNames = new Vector<String>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String name = rs.getString(1);
                categoryNames.add(name);

                // System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryNames;
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
     
}
