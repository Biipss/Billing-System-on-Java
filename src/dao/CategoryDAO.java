
package dao;

import DB.ConnectionFactory;
import model.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoryDAO {
    Connection con = null;
    Statement stmt= null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    String[] searchColumnNames ={"ID"," Name"};
    
    public CategoryDAO(){
        con = new ConnectionFactory().getConnection();
    }
    
    public void saveCategory(Category category){
            String query="INSERT into category VALUES (?,?)";
            try{
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,category.getId());
            pstmt.setString(2,category.getName());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Category saved successfully");
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getQueryResult(){
        String sql = "SELECT * FROM category";
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
        String query = "SELECT id,name FROM category";
        return query;
    }
    
     public String returnQueryToGetCategoryNames(){
        String query = "SELECT name FROM category";
        return query;
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
    public String getCategoryID(String query) {
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
    public String returnQueryToGetCategoryID(String value) {
        String query = "SELECT id FROM category WHERE name LIKE '%" + value + "'";
        return query;
    }
    
//    public void delete(String value){
//        try{
//            String query ="DELETE FROM category where id=?";
//            pstmt = con.prepareStatement(query);
//            pstmt.setString(1,value);
//            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null,"One record deleted.");
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
   public Vector<String> getCName(){
       Vector<String> columnNames = new Vector<String>();
       columnNames.add("ID");
       columnNames.add("Category");
   
       return columnNames;
   }
   
    public  Vector<String>getCategoryName(String query){
        Vector<String> categoryNames = new Vector<String>();
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
             while(rs.next()){
                    
                    String name=rs.getString(1);
                   categoryNames.add(name);
                   
                   // System.out.println(name);
                }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return categoryNames;
    }
}
