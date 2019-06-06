<%@ page import="com.basicWeb.entity.Member" %><%--
  Created by IntelliJ IDEA.
  User: Le Thanh Tung
  Date: 05/06/2019
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Member member = (Member) request.getAttribute("member");
    if (member == null) {
        member = new Member();
    }%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form action="/member/login" method="post" class="w-25 m-auto">
    <h4 class="text-center">Login</h4>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label for="name">Password</label>
        <input type="password" class="form-control" name="password">
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Login">
    <a href="/member/register">Register</a>
</form>
</body>
</html>
