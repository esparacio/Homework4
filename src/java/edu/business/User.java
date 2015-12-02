/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Elena
 */
public class User implements Serializable {
   private String firstName;
   private String lastName;
   private String emailAddress;
   private String bookTitle;
   private String date;
   private String duedate;


    public User() {
        firstName = "";
        lastName = "";
        emailAddress = "";
        bookTitle = "";
        date = "";
        
    }

    public User(String firstName, String lastName, String emailAddress, String bookTitle, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.bookTitle = bookTitle;
        this.date = date;
       
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getDueDate(){
        return duedate;
    }
    
    public void setDueDate(String duedate){
        this.duedate = duedate;
    }
   

}