<%-- 
    Document   : checkout
    Created on : Nov 9, 2015, 12:48:57 PM
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:import url="/includes/header.html"/>
  <body>
      <section>
          <h2> Checkout a Book </h2>
          <form action="library" method="post">
        <input type="hidden" name="action" value="add"> 
        <p><i>${message}</i></p>
        <p><label>First Name: </label><input name="firstName" type="text" value="${firstName}" required /></p>
        <p><label>Last Name:</label><input name="lastName" type="text" value="${lastName}" required /></p>
        <p><label>Email Address: </label><input name="emailAddress" type="email" value="${emailAddress}" required /></p>
        <p><label>Book Title: </label><input class="book" name="bookTitle" type="text" value="${bookTitle}" required/> </p>
        <label>         </label><input class= "butt" type="submit" value="Checkout">
      </form>
        <br>
      </section>
        <br>
      
        <c:import url="/includes/footer.html"/>
  </body>
</html>  