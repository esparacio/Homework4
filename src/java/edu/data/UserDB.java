/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data;

import edu.business.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Elena
 */
public class UserDB {
      public static long insert(User user) throws ClassNotFoundException {
          try{
              Class.forName("com.mysql.jdbc.Driver");
              
//              String dbURL = "jdbc:mysql://127.0.01:3307/library";
//                String username= "adminpPZdzW4";
//                String password = "_W_Gusvg84yP";
              
              String dbURL = "jdbc:mysql://localhost:3306/librarystuff";
              String username= "root";
              String password= "sesame";
              Connection connection = DriverManager.getConnection(dbURL,username,password);
              String query = "INSERT INTO library (firstName, lastName, emailAddress, bookTitle, date)" +
                      "VALUES ('"+ user.getFirstName() + "', " +
                      "'" + user.getLastName() + "', " +
                      "'" + user.getEmailAddress() + "', " +
                      "'" + user.getBookTitle() + "', " +
                      "'" +user.getDueDate() + "')";
             Statement statement2 = connection.createStatement();
             int result2 = statement2.executeUpdate(query);
                      
          }
          catch(SQLException e){
              for(Throwable t : e)
                  t.printStackTrace();
          }
          
         
          
          
          
        return 0;
    }
       public static long delete(String email) throws ClassNotFoundException {
          try{
              Class.forName("com.mysql.jdbc.Driver");
              String dbURL = "jdbc:mysql://localhost:3306/librarystuff";
              String username= "root";
              String password= "sesame";
              Connection connection = DriverManager.getConnection(dbURL,username,password);
              Statement statement = connection.createStatement();
              ResultSet results = statement.executeQuery(
                 "SELECT * FROM librarystuff.library"
          );
              String query = "DELETE FROM librarystuff.library WHERE emailAddress = '"+email+"';";  
             Statement statement2 = connection.createStatement();
             int result2 = statement2.executeUpdate(query);
                      
      

          }
          catch(SQLException e){
              for(Throwable t : e)
                  t.printStackTrace();
          }
          
         
          
          
          
        return 0;
    }
}
