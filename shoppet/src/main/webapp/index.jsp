<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/8/2021
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div class="wpb_text_column wpb_content_element  ">
    <div class="wpb_wrapper">
      <h2 class="font-coiny" style="text-align: center;">
        <a href="http://localhost:8080/"><strong>SHOP
          BÁN CHÓ MÈO CẢNH</strong></a>
      </h2>
    </div>
  </div>
  <div class="row justify-content-around">
    <%--                          chạy vòng lặp for chỉ 8 sản phẩm--%>
    <c:forEach var="pet" items="${listPet}" begin="0" end="7">
      <div class="col-3">

        <div class="product-thumb">
          <a href="?action=info&id=${pet.getId()}"
             class="product-thumb-link zoom-thumb">
            <img src="${pet.getImage()}" style="width: 300px; height: 300px"
                 class="attachment-270x270 size-270x270 wp-post-image"
                 alt="" />
          </a>
        </div>
        <div class="product-info">
          <span class="title12 text-uppercase color font-bold">ID:${pet.getId()}</span>
          <h3
                  class="title18 text-uppercase product-title dosis-font font-bold">
            <a title="dd"
               href="?action=info&id=${pet.getId()}"
               class="black">${pet.getName()}</a>
          </h3>
          <div class="product-price simple">
                                  <span
                                          class="woocommerce-Price-amount amount">${pet.getPrice()}
                                      <span
                                              class="woocommerce-Price-currencySymbol">&#8363;
                                      </span>
<%--                                    <a class="shop-button bg-color arrow-right block-right"--%>
<%--                                       href="cart?action=buy">Đặt hàng</a>--%>
                                    <a href="${pageContext.request.contextPath}/?action=buyp&id=${pet.id}">Buy</a>
<%--                                    <input type="submit" name="submit" class="btn btn-success" style="margin-left: 100px" value="addCard">--%>
                                  </span>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
  <div class="wpb_raw_code wpb_content_element wpb_raw_html">
    <div class="wpb_wrapper">
      <a class="shop-button bg-color arrow-right block-right"
         href="?action=1">Xem thêm</a>
    </div>
  </div>
  </div>
  </div>
  </div>
  </div>
  <div class="vc_row wpb_row">
    <div class="wpb_column column_container col-sm-12">
      <div class="vc_column-inner vc_custom_1576307249231">
        <div class="wpb_wrapper">
          <div class="wpb_text_column wpb_content_element ">
            <div class="wpb_wrapper">
              <h2 class="font-coiny" style="text-align: center;">
                <a href="http://localhost:8080/"><strong>PHỤ
                  KIỆN THÚ CƯNG</strong></a>
              </h2>

            </div>
          </div>
          <div class="row justify-content-around">
            <c:forEach var="product" items="${listP}" begin="0" end="7">
              <div class="col-3">

                <div class="product-thumb">
                  <a href="?action=infop&id=${product.getId()}"
                     class="product-thumb-link zoom-thumb">
                    <img src="${product.getImage()}" style="width: 300px; height: 300px"
                         class="attachment-270x270 size-270x270 wp-post-image"
                         alt="" />
                  </a>
                </div>
                <div class="product-info">
                  <span class="title12 text-uppercase color font-bold">ID:${product.getId()}</span>
                  <h3 class="title18 text-uppercase product-title dosis-font font-bold">
                    <a title="dd"  href="?action=infop&id=${product.getId()}" class="black">${product.getName()}</a>
                  </h3>
                  <div class="product-price simple">
                    <span
                            class="woocommerce-Price-amount amount">${product.getPrice()}
                        <span
                                class="woocommerce-Price-currencySymbol">&#8363;
                        </span>
<%--                                      <input type="submit" name="submit" class="btn btn-success" style="margin-left: 100px" value="addCard">--%>
                       <a href="${pageContext.request.contextPath}/?action=buy&id=${product.id}">Buy</a>
                    </span>
                  </div>
                </div>

              </div>
            </c:forEach>
          </div>
          <div class="wpb_raw_code wpb_content_element wpb_raw_html">
            <div class="wpb_wrapper">
              <a class="shop-button bg-color arrow-right block-right"
                 href="?action=2">Xem thêm</a>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="vc_row wpb_row">
    <div class="wpb_column column_container col-sm-12">
      <div class="vc_column-inner vc_custom_1576307254892">
        <div class="wpb_wrapper">
          <div class="wpb_text_column wpb_content_element ">
            <div class="wpb_wrapper">
              <h2 class="font-coiny" style="text-align: center;">
                <a href="http://localhost:8080/"><strong>SPA
                  &#8211; KHÁCH SẠN THÚ CƯNG</strong></a>
              </h2>

            </div>
          </div>
          <div class="row justify-content-around">
            <c:forEach var="product" items="${listS}" begin="0" end="3">
              <div class="col-3">

                <div class="product-thumb">
                  <a href="?action=infos&id=${product.getId()}"
                     class="product-thumb-link zoom-thumb">
                    <img src="${product.getImage()}" style="width: 300px; height: 300px"
                         class="attachment-270x270 size-270x270 wp-post-image"
                         alt="" />
                  </a>
                </div>
                <div class="product-info">
                  <span class="title12 text-uppercase color font-bold">ID:${product.getId()}</span>
                  <h3 class="title18 text-uppercase product-title dosis-font font-bold">
                    <a title="dd"  href="?action=infos&id=${product.getId()}" class="black">${product.getName()}</a>
                  </h3>
                  <div class="product-price simple">
                                    <span
                                            class="woocommerce-Price-amount amount">${product.getPrice()}
                                        <span
                                                class="woocommerce-Price-currencySymbol">&#8363;
                                        </span>
<%--                                        <input type="submit" name="submit" class="btn btn-success" style="margin-left: 100px" value="addCard">--%>
                                      <a href="${pageContext.request.contextPath}/?action=buys&id=${product.id}">Buy</a>
                                    </span>
                  </div>
                </div>

              </div>
            </c:forEach>
          </div>
          <div class="wpb_raw_code wpb_content_element wpb_raw_html">
            <div class="wpb_wrapper">
              <a class="shop-button bg-color arrow-right block-right"
                 href="?action=3">Xem thêm</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
