<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kohlburgz
  Date: 10/11/18
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%--When a user visits /login.jsp, they should see a form for logging in
            This form should have a 'username' and 'password' field.
            This form should submit a POST request to /login.jsp
            Inside of login.jsp write some code to check the submmitted values.
            If the username submitted is "admin", and the password is "password",
            redirect the user to the profile page, otherwise, redirect back to the login form. --%>

    <%-- login form --%>
    <p>
    <form action="login.jsp" method="POST">
        <label for="username">Please enter your username: </label>
        <input type="text" id="username" name="username">
        <label for="password">Please enter your password: </label>
        <input type="password" id="password" name="password">
        <input type="submit">
    </form>
    </p>


    <%--form handling--%>

    <%! String username = ""; String password = ""; %>
    <% username = request.getParameter("username"); password = request.getParameter("password"); %>
    <p>username entered: <%=username%> <br>password entered: <%=password%> </p>

    <% request.setAttribute("username", username); %>
    <% request.setAttribute("password", password); %>
    <% request.setAttribute("admin", "admin"); %>

    <p>admin username is: ${admin}</p>
    <c:if test="${username == admin && password == 'password'}">
        <p>test is true!</p>
        <% response.sendRedirect("/profile.jsp"); %>
    </c:if>
</body>
</html>
