<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/8/2021
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-12">
    <h2 class="page-title">Thông tin Pet</h2>
</div>
<div class="col-12">
    <a href="/products">Trở về trang quản lý</a>
</div>
<div class="row">
    <div class="col-12 col-sm-12 col-md-8">
        <div class="row">
            <figure class="figure">
                <img src="${product.image}" class="figure-img img-fluid rounded"
                     style="width: 350px; height: 350px; margin-left: 20px" alt="">
            </figure>
        </div>
        <div class="row">
            <label class="col-8"><span class="font-weight-bold">Tên:</span> ${product.name}</label>
        </div>
        <div class="row">
            <label class="col-8"><span class="font-weight-bold">Gía:</span> ${product.price}</label>
        </div>
        <div class="row">
            <label class="col-8"><span class="font-weight-bold">Số lượng:</span> ${product.quantity}</label>
        </div>
        <div class="row">
            <label class="col-8"><span class="font-weight-bold">Loại:</span>${product.cateGoryName}</label>
        </div>
    </div>
</div>

</body>
</html>
