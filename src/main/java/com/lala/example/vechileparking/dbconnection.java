package com.lala.example.vechileparking;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
   public Connection con;
   public Connection getCon(){
       String dbname="";
       String user="";
       String password="";
       String url="";
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con= DriverManager.getConnection(url,user,password);
       }catch (Exception e){
           e.printStackTrace();

       }
       return getCon();
   }
}
