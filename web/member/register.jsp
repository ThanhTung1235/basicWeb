<%@ page import="com.basicWeb.entity.Member" %><%--
  Created by IntelliJ IDEA.
  User: Le Thanh Tung
  Date: 05/06/2019
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Member member = (Member) request.getAttribute("member");
    if (member == null) {
        member = new Member();
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/member/register" class="w-25 m-auto">
    <h4 class="text-center">Register</h4>
    <div class="form-group">
        <label for="name">Username</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email">
    </div>

    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password">
    </div>
    <div class="form-group">
        <label for="address">Address</label>
        <input type="text" class="form-control" name="address">
    </div>
    <div class="form-group">
        <label for="phone">Phone</label>
        <input type="tel" class="form-control" name="phone">
    </div>
    <div class="form-group">
        <label for="phone">Phone</label>
        <select>
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="mercedes">Mercedes</option>
            <option value="audi">Audi</option>
        </select>
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Register">
    <a href="/member/login">Login</a>
</form>
</body>
</html>
