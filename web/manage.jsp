<%-- 
    Document   : manage
    Created on : Nov 9, 2015, 3:57:04 PM
    Author     : Elena
--%>


<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="utf-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <c:import url="/includes/header.html"/>
    <body>
        <section>
            <h2>Currently Checked Out Books</h2>
            <span>${sqlResult}</span>
            <br>
        <b><a href="index.jsp">Return to Front Page </a></b>
        <br><br>
        </section>
        <br> 
    </body>
    <c:import url="/includes/footer.html"/>
</html>
