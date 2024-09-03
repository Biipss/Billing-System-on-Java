package dao;

import java.sql.*;

public class DbOperation{
     DbOperation(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //connection using url
            String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            Statement stmt=con.createStatement();
            if(con!=null){
                System.out.println("Connection succesful");
            }else{
                System.out.println("Error creating connection");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static void createTable() throws Exception{
        String sql="CREATE TABLE User("
                + " id int AUTO_INCREMENT primary key,"
                + " name varchar(100),"
                + "email varchar(200),"
                + "mobileNumber varchar(10),"
                + "address varchar(200),"
                + "password varchar(200),"
                + "status varchar(20)"
               + ")";
        try{
               Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            if(con!=null){
                Statement stmt= con.createStatement();
                int result=stmt.executeUpdate(sql);
                if(result!=-1){
                    System.out.println("Table Created Successfully");
                }else{
                    System.out.println("Couldn't create table");
                }
                stmt.close();
                con.close();
            } else{
                System.out.println("Unable to get the connection");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
}
     static void categoryTable() throws Exception{
        String sql="CREATE TABLE category("
                + " id int AUTO_INCREMENT primary key,"
                + " name varchar(100)"
               + ")";
        try{
               Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            if(con!=null){
                Statement stmt= con.createStatement();
                int result=stmt.executeUpdate(sql);
                if(result!=-1){
                    System.out.println("Category Table Created Successfully");
                }else{
                    System.out.println("Couldn't create table");
                }
                stmt.close();
                con.close();
            } else{
                System.out.println("Unable to get the connection");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
}
      static void productTable() throws Exception{
        String sql="CREATE TABLE product("
                 + " id int primary key,"
                + " name varchar(100),"
                + " category varchar(100),"
                + " price bigint"
               + ")";
        try{
               Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            if(con!=null){
                Statement stmt= con.createStatement();
                int result=stmt.executeUpdate(sql);
                if(result!=-1){
                    System.out.println("Product Table Created Successfully");
                }else{
                    System.out.println("Couldn't create table");
                }
                stmt.close();
                con.close();
            } else{
                System.out.println("Unable to get the connection");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
}
      
      
        static void billTable() throws Exception{
        String sql="CREATE TABLE bill("
                 + " id int primary key,"
//                + " name varchar(100),"
//                + " mobileNumber varchar(100),"
                + " date varchar(50),"
                + " total varchar(500),"
                + " createdBy varchar(200),"
                + " tableNo varchar(200)"
               + ")";
        try{
               Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cms";
            Connection con=DriverManager.getConnection(url,"root","");
            if(con!=null){
                Statement stmt= con.createStatement();
                int result=stmt.executeUpdate(sql);
                if(result!=-1){
                    System.out.println("Bill Table Created Successfully");
                }else{
                    System.out.println("Couldn't create table");
                }
                stmt.close();
                con.close();
            } else{
                System.out.println("Unable to get the connection");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
}
      
      
    public static void main(String[] args)throws Exception {
       DbOperation  obj=new DbOperation();
     // createTable();
      //categoryTable();
      //productTable();
     
     //billTable();
           }
} 