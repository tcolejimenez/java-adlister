<%--
  Created by IntelliJ IDEA.
  User: kohlburgz
  Date: 10/16/18
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register" />
    </jsp:include>
</head>
<body>
    <main class="container">
        <h1>Register</h1>
        <p>Please enter your email, username, and password.</p>
        <hr class="hr-4">

        <form action="/register" method="POST">
            <article class="row">
                <label for="email" class="col-5">Enter your email: </label>
            <input type="text" name="email" id="email" class="col-6">
            </article>

            <article class="row">
                <label for="username" class="col-5">Enter your username: </label>
                <input type="text" name="username" id="username" class="col-6">
            </article>

            <article class="row">
                <label for="password" class="col-5">Enter your password:</label>
                <input type="password" name="password" id="password" class="col-6">
            </article>

            <input type="submit">
        </form>
    </main>
</body>
</html>
