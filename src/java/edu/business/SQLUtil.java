/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.business;

import java.sql.*;

/**
 *
 * @author Elena
 */
public class SQLUtil {


    public static String getHTMLTable(ResultSet resultSet)  throws SQLException{
        
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columncount = metaData.getColumnCount();
        
        htmlTable.append("<table>");
        
        htmlTable.append("<tr>");
        for (int i = 1; i <= columncount; i++){
            htmlTable.append("<th>");
            htmlTable.append(metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append("<th>Overdue</th>");
        htmlTable.append("</tr>");
        
        while(resultSet.next()) {
            htmlTable.append("<tr>");
            
            for (int i = 1; i <= columncount; i++){
            htmlTable.append("<td>");
            htmlTable.append(resultSet.getString(i));
            htmlTable.append("</td>");
        }
            String email = resultSet.getString(2);
            htmlTable.append("<td> <form action=\"management\" method=\"post\">\n" +
"        <input type=\"hidden\" name=\"action\" value=\"delete\"> <input type=\"hidden\" name=\"id\" value="+email+">  <input class= \"butt\" type=\"submit\" value=\"Check In\"></td></form>");
            htmlTable.append("</tr>");
              
        }
        
        htmlTable.append("</table>");
        return htmlTable.toString();
   
    
           }
    
}
