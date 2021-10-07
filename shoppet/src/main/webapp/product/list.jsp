<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2021
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
    <h1>Product Management</h1>
    <h2>
        <a href="/product?action=create">Add New Product</a>
    </h2>
    <h3>Tìm kiếm</h3>
    <form action="" method="get">
        <input type="hidden" name="action" value="find" />
        <input type="search" name="key" placeholder="search" />
        <input type="submit" value="Search">
        <caption><h2>List of Product</h2></caption>
    </form>
</center>
<table class="table">

    <thead class="thead-dark">
    <tr>
        <th>Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
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
<%--                <a href="/product?action=edit&id=${product.id}">Edit</a>--%>
<%--                <a href="/product?action=delete&id=${product.id}">Delete</a>--%>
                ư<a href="/product?action=info&id=${product.id}" title="Information" class="btn-me"><i class="fas fa-info-circle"></i></a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1>Product Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/product?action=create">Add New User</a>--%>
<%--    </h2>--%>
<%--    <h3>Tìm kiếm</h3>--%>
<%--    <form action="" method="get">--%>
<%--        <input type="hidden" name="action" value="find" />--%>
<%--        &lt;%&ndash;        vì khi này nó chưa hiểu đường dẫn đang nằm ở đâu, nhưng th edit nó vẫn ở địa chỉ /user?action=edit nên nó sẽ tự hiểu là trỏ đến edit&ndash;%&gt;--%>
<%--        <input type="search" name="key" />--%>
<%--        <input type="submit">--%>
<%--    </form>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Users</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>Id</th>--%>
<%--            <th>Product Name</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>Quantity</th>--%>
<%--            <th>Color</th>--%>
<%--            <th>des</th>--%>
<%--            <th>Category</th>--%>
<%--            <th>Action</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="product" items="${list}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${product.id}"/></td>--%>
<%--                <td><c:out value="${product.productName}"/></td>--%>
<%--                <td><c:out value="${product.price}"/></td>--%>
<%--                <td><c:out value="${product.quantity}"/></td>--%>
<%--                <td><c:out value="${product.color}"/></td>--%>
<%--                <td><c:out value="${product.des}"/></td>--%>
<%--                <td><c:out value="${product.cateGoryName}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/product?action=edit&id=${product.id}">Edit</a>--%>
<%--                    <a href="/product?action=delete&id=${product.id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>

<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

