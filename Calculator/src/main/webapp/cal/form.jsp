<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2021
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<from action="/cal" method="post">
    <input type="number" name="num1" >
    <input type="number" name="num2" >
    <input type="button" name="cal" value="+">
    <input type="button" name="cal" value="-">
    <input type="button" name="cal" value="x">
    <input type="button" name="cal" value="/">
</from>
</body>
</html>
