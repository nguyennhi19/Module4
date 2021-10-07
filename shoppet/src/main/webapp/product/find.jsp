<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2021
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<center>
    <h1>Find User</h1>
    <h2>
        <a href="/product">List All User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.image}"/></td>
                <td><c:out value="${product.cateGoryName}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.id}" class="btn-sm btn-primary" title="Edit" size="30"><i class="fa fa-edit"></i></a>
                    <a href="/product?action=delete&id=${product.id}" class="btn-sm btn-danger " title="Delete" size="30"><i class="fa fa-trash"></i></a>
                    <a href="/products?action=info&id=${product.getId()}" title="Information" class="btn-me"><i class="fas fa-info-circle"></i></a>

                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>

