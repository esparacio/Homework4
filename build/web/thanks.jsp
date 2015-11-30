<%-- 
    Document   : thanks
    Created on : Nov 9, 2015, 2:12:11 PM
    Author     : Elena
--%>

<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="utf-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <c:import url="/includes/header.html"/>
    <body>
        <section>
        <p class ="reg">Thank you for your patronage to Belk Library. You&#39;ve successfully checked out
            the book, <span>${bookTitle}</span>. Please note that this book is due back on
            <span>${duedate}</span>. A friendly email reminder will be sent to you if
        your book becomes overdue.</p>
        <b><a href="index.jsp">Return to Front Page </a></b>
        <br><br>
        </section>
        <br> 
    </body>
    <c:import url="/includes/footer.html"/>
</html>
