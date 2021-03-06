/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servlet;

import edu.business.ConnectionPool;
import edu.business.SQLUtil;
import edu.data.UserDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elena
 */
public class management extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
       
        String url = "/manage.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  
        }
        if (action.equals("join")) {
            url = "/index.jsp";    
        } 
        if (action.equals("delete")){
            String email = request.getParameter("id");
            System.out.println(email);
            try {
                UserDB.delete(email);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(library.class.getName()).log(Level.SEVERE, null, ex);
            }
            url = "/management?action=add";
        }
        else if (action.equals("add")) {
        url = "/manage.jsp";
        
        String sqlResult = "bob";
        try{
            Class.forName("com.mysql.jdbc.Driver");
//              String dbURL = "jdbc:mysql://localhost:3306/librarystuff";
//              String username= "root";
//              String password= "sesame";
//               Connection connection = DriverManager.getConnection(dbURL,username,password);

            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection() ;
            Statement statement = connection.createStatement();
            String query = "SELECT CONCAT(firstName,' ', lastName) AS 'Patron Name',"
                      + " CONCAT(emailAddress,'') AS 'Email Address', CONCAT(bookTitle,'') AS 'Book Title', CONCAT(date,'') AS 'Due Date' "
                      + "FROM library.librarystuff;";
              
            ResultSet resultSet = statement.executeQuery(query);
            try {
                sqlResult= SQLUtil.getHTMLTable(resultSet);
            } catch (ParseException ex) {
                Logger.getLogger(management.class.getName()).log(Level.SEVERE, null, ex);
            }
              
              resultSet.close();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(management.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(management.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        HttpSession session = request.getSession();
        session.setAttribute("sqlResult",sqlResult);

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    
    
    }    
}