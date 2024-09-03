/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class ConnectionFactory {
    Connection con;
    Statement stmt;
    ResultSet rs;
    boolean flag=false;
    
    public ConnectionFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
            stmt=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static ResultSet getData(String query) {
       try{
           String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.ERROR_MESSAGE);
            return null;
    }
    }
    
    public boolean checkLogin(String email,String password){
        try {
            String query="SELECT * FROM user where email='"+email+"'and password='"+password+"'";
           rs=stmt.executeQuery(query);
           while(rs.next()){
               return true;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     
    }
    public Connection getConnection(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}


