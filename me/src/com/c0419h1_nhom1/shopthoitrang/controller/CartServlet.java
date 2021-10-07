package com.c0419h1_nhom1.shopthoitrang.controller;

import com.c0419h1_nhom1.shopthoitrang.entity.ChiTietHoaDon;
import com.c0419h1_nhom1.shopthoitrang.entity.HoaDon;
import com.c0419h1_nhom1.shopthoitrang.entity.Khachhang;
import com.c0419h1_nhom1.shopthoitrang.entity.SanPham;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private HoaDon hoadonDAO = new HoaDon();
    private ChiTietHoaDon ChiTietHoaDonDAO = new ChiTietHoaDon();
    private Khachhang khachhangDAO = new Khachhang();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "thanhtoan":
                try {
                    pay(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                break;
            default:
                ShowCart(request, response);
                break;
        }
    }

    private void ShowCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<SanPham> listSessionSanpham = (List<SanPham>) session.getAttribute("listSessionCartSanpham");

        double tongtien = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            listSessionSanpham.get(i).setTonggia(listSessionSanpham.get(i).getGia()*listSessionSanpham.get(i).getSoluongtronggio());
            tongtien += listSessionSanpham.get(i).getTonggia();
        }

        double vat = tongtien * 0.01;
        double thanhtien = tongtien + vat;
        Map<String, Double> hoadon = new HashMap<>();
        hoadon.put("tongtien", tongtien);
        hoadon.put("vat", vat);
        hoadon.put("thanhtien", thanhtien);
        session.setAttribute("hoadon", hoadon);
        Map<String, Double> hoadonView = (Map<String, Double>) session.getAttribute("hoadon");

        request.setAttribute("hoadonView", hoadonView);
        request.setAttribute("newShowCart", listSessionSanpham); // đổ dữ liệu giỏ hàng qua cart

        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Cart/index.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pay(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        String tenkh = request.getParameter("tenkh");
        String sodienthoaikh = request.getParameter("sodienthoaikh");
        String diachi = request.getParameter("diachi");
        String ghichu = request.getParameter("ghichu");

        LocalDate ngayban = LocalDate.now();
        java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
        String ngaybanValue = df.format(ngayban);


        // Lấy giỏ hàng về
        HttpSession session = request.getSession();
        List<SanPham> listSessionSanpham = (List<SanPham>) session.getAttribute("listSessionCartSanpham");

        // Tạo khách hàng
        Khachhang newKhachhang = new Khachhang(tenkh,sodienthoaikh,diachi,ghichu);
        this.khachhangDAO.createkhachhang(newKhachhang);
        int id_khachHang = this.khachhangDAO.getidkhachhang(newKhachhang);

        Map<String, Double> hoadon = (Map<String, Double>) session.getAttribute("hoadon");
        // tạo hóa đơn
        HoaDon newHoaDon = new HoaDon(ngaybanValue,id_khachHang,hoadon.get("tongtien"),hoadon.get("vat"),hoadon.get("thanhtien"));
        this.hoadonDAO.createHoaDon(newHoaDon);
        int id_hoadon = this.hoadonDAO.getidhoadon(newHoaDon);
        // Tạo chi tiết hóa đơn
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            ChiTietHoaDon newChiTietHoaDon = new ChiTietHoaDon(id_hoadon,listSessionSanpham.get(i).getId()
            ,listSessionSanpham.get(i).getSoluongtronggio(),listSessionSanpham.get(i).getTonggia());
            this.ChiTietHoaDonDAO.createChiTietHoaDon(newChiTietHoaDon);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Cart/index.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
