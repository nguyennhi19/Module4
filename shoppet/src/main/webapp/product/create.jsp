<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2021
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/product">List All Product</a>
    </h2>
    <h3>
        ${message}
    </h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Product Price</th>:</th>
                <td>
                    <input type="number" name="price" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Product Quantity</th>:</th>
                <td>
                    <input type="number" name="quantity" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Product Description</th>:</th>
                <td>
                    <input type="text" name="image" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="category">
                        <c:forEach var="country" items='${requestScope["data"]}'>
                            <option value="${country.id}">${country.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Save"/>
                </td>
                <td><a href="http://localhost:8080/product">Back to customer list</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

