package com.lala.example.vechileparking;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
   public Connection con;
   public Connection getCon(){
       String dbname="parkingmanagment ";
       String user="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/parkingmanagment";
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con= DriverManager.getConnection(url,dbname,password);
       }catch (Exception e){
           e.printStackTrace();

       }
       return getCon();
   }
}
