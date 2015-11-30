<%-- 
  Document   : index
  Author     : (c) Elena Sparacio 

Things that need to be fixed:
    Need to add a primary key to the table.
    Need to figure out how to delete a row.
    Need to figure out how to send information from a button to servlet 

--%>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:import url="/includes/header.html"/>
  <body>
      <section>
          <br>
          <b><a href = "checkout.jsp"> Check out a book</a></b>
              <br>
            <b><a href = "${pageContext.request.contextPath}/management?action=add"> Manage checked out books </a></b>
            <br>
            <br>
      </section>
      <br>
        <c:import url="/includes/footer.html"/>
  </body>
</html>  