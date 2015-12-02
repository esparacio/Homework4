/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.data;

import edu.business.ConnectionPool;
import edu.business.User;
import java.sql.Connection;
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
              
//              String dbURL = "jdbc:mysql://localhost:3306/librarystuff";
//              String username= "root";
//              String password= "sesame";
//            
//              Connection connection = DriverManager.getConnection(dbURL,username,password);
              
              
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection() ;
              String query = "INSERT INTO library.librarystuff (firstName, lastName, emailAddress, bookTitle, date)" +
                      "VALUES ('"+ user.getFirstName() + "', " +
                      "'" + user.getLastName() + "', " +
                      "'" + user.getEmailAddress() + "', " +
                      "'" + user.getBookTitle() + "', " +
                      "'" +user.getDueDate() + "')";
             Statement statement2 = connection.createStatement();
             int result2 = statement2.executeUpdate(query);
            pool.freeConnection(connection);
            statement2.close();
            connection.close();
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
//              String dbURL = "jdbc:mysql://localhost:3306/librarystuff";
//              String username= "root";
//              String password= "sesame";
//              Connection connection = DriverManager.getConnection(dbURL,username,password);
              
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection() ;
              Statement statement = connection.createStatement();
              ResultSet results = statement.executeQuery(
                 "SELECT * FROM library.librarystuff"
          );
              String query = "DELETE FROM library.librarystuff WHERE emailAddress = '"+email+"';";  
             Statement statement2 = connection.createStatement();
             int result2 = statement2.executeUpdate(query);
           statement2.close();
            connection.close();
                  pool.freeConnection(connection);


          }
          catch(SQLException e){
              for(Throwable t : e)
                  t.printStackTrace();
          }
          
         
          
          
          
        return 0;
    }
}
