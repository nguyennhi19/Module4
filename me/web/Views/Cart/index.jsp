<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/25/2019
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.png">
    <title>Welcome to FlatShop</title>
    <!--linkcss-->
    <jsp:include page="../Shared/_linkcss.jsp"></jsp:include>
    <!--linkcss-->
</head>

<body>
<div class="wrapper">
    <!-- header-->
    <jsp:include page="../Shared/_header.jsp"></jsp:include>
    <!-- header-->

    <div class="clearfix">
    </div>
    <!--   body contact-->
    <div class="container_fullwidth">
        <div class="container shopping-cart">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="title">Shopping Cart</h3>
                    <div class="clearfix">
                    </div>
                    <form action="/cart?action=thanhtoan" method="post">
                        <table class="shop-table">
                            <thead>
                            <tr>
                                <th>Hình ảnh</th>
                                <th>Thông tin</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Thành tiền</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items='${requestScope["newShowCart"]}' var="sanpham">
                                <tr>
                                    <td>
                                        <img src="${pageContext.request.contextPath}/Content/images/products/${sanpham.getHinhanh()}"
                                             alt="">
                                    </td>
                                    <td>
                                        <div class="shop-details">
                                            <div class="productname">${sanpham.getTensp()}</div>
                                            <p>
                                                Product Code :<strong class="pcode">Dress 120</strong>
                                            </p>
                                        </div>
                                    </td>
                                    <td>
                                        <h5 id="giasp${sanpham.getId()}">${sanpham.getGia()}</h5>
                                    </td>

                                    <td>
                                            ${sanpham.getSoluongtronggio()}
                                    </td>

                                    <td>
                                        <h5><a class="red">${sanpham.getTonggia()}</a>
                                        </h5>
                                    </td>
                                    <td>
                                        <a href="/cart"><img
                                                src="${pageContext.request.contextPath}/Content/images/remove.png"
                                                alt=""></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6">
                                    <button class=" pull-right"><a href="/homes">Tiếp tục mua sắm</a></button>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                        <!-- Contact -->
                        <div class="col-lg-6">
                            <div class="checkout-page">
                                <ol class="checkout-steps">
                                    <li class="steps active">
                                        <a class="step-title">Điền Thông tin liên hệ</a>
                                        <div class="step-description">
                                            <div class="row">
                                                <div class="run-customer">
                                                    <h5>Thông tin liên hệ</h5>
                                                    <div class="form-row">
                                                        <label class="lebel-abs">Tên<strong
                                                                class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="tenkh">
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Số điện
                                                        thoại<strong
                                                                class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="sodienthoaikh">
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Địa chỉ<strong
                                                            class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="diachi">
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Ghi chú<strong
                                                            class="red">*</strong></label>
                                                        <textarea type="text" class="input namefild" name="ghichu"
                                                                  rows="5" cols="72"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="checkout-page">
                                <ol class="checkout-steps">
                                    <li class="steps active">
                                        <a class="step-title">Bản Thanh Toán</a>
                                        <div class="step-description">
                                            <div class="row">
                                                <div class="run-customer" style="margin-top: 158px;">
                                                    <h5>Xin cảm ơn hẹn gặp lại!</h5>
                                                        <h3>Tổng tiền:</h3><span>${requestScope["hoadonView"].get("tongtien")}</span><br>
                                                        <h3>Thuế VAT: </h3><span>${requestScope["hoadonView"].get("vat")}</span> <br>
                                                        <h3>Thành tiền:</h3><span>${requestScope["hoadonView"].get("thanhtien")}</span>
                                                    <div>
                                                    </div>
                                                </div>
                                                <button class="btn-cart btn-success" style="margin-top: 20px" type="submit">
                                                    Thanh Toán
                                                </button>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </form>
                    <!--End Contact -->
                </div>
            </div>
        </div>
    </div>

    <!--    body contact-->
    <div class="clearfix">
    </div>
    <!--    footer-->
    <jsp:include page="../Shared/_footer.jsp"></jsp:include>
    <!--    footer-->
</div>
<!-- Bootstrap core JavaScript===============================================-->
<!--linkjs-->
<!--linkjs-->
</body>

</html>