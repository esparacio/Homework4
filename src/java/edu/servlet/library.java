/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servlet;

import edu.business.User;
import edu.data.UserDB;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elena
 */
public class library extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        
        else if (action.equals("add")) {
          
            try{
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                String bookTitle = request.getParameter("bookTitle");
                Date today = Calendar.getInstance().getTime();
                String date = new SimpleDateFormat("MM-dd-yyyy").format(today);
                User user = new User(firstName, lastName, emailAddress, bookTitle,date);
                Calendar c = Calendar.getInstance();
                c.setTime(today); 
                c.add(Calendar.DATE, 14); 
                String duedate = new SimpleDateFormat("MM-dd-yyyy").format(c.getTime());
                user.setDueDate(duedate);
          
                
                String message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
                request.setAttribute("user", user);
                request.setAttribute("message", message);
                
    
      
      request.setAttribute("firstName", firstName);
      request.setAttribute("lastName", lastName);
      request.setAttribute("emailAddress", emailAddress);
      request.setAttribute("bookTitle", bookTitle);
      request.setAttribute("date", date);
      request.setAttribute("duedate",duedate);

      
      HttpSession session = request.getSession();
      session.setAttribute("firstName", firstName);
      session.setAttribute("lastName", lastName);
      session.setAttribute("emailAddress", emailAddress);
      session.setAttribute("bookTitle", bookTitle);

      
            }
            catch(NumberFormatException nfe){
                String message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            request.setAttribute("message", message);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(library.class.getName()).log(Level.SEVERE, null, ex);
            }
   
       
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}