<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/8/2021
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="post">
    <h1>Convert Currency</h1>
    USD :
    <input type="text" name="number"/><br>
    Rate :
    <input type="text" name="rate" value="20000"><br>
    <button type="submit">Convert</button>
</form>
</body>
</html>
