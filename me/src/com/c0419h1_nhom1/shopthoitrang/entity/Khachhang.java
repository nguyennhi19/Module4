package com.c0419h1_nhom1.shopthoitrang.entity;

import com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Khachhang extends DBConnection {
    private int id;
    private String ten;
    private String sodienthoai;
    private String diachi;
    private String ghichu;

    public Khachhang() {
    }

    public Khachhang(String ten, String sodienthoai, String diachi, String ghichu){
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public Khachhang(int id, String ten, String sodienthoai, String diachi, String ghichu) {
        this.id = id;
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public boolean createkhachhang(Khachhang khachhang) throws SQLException {
        String sql = "INSERT INTO khachhang (ten,sodienthoai,diachi,ghichu) VALUES (?,?,?,?)";

        //L?y chu?i k?t n?i t?i CSDL truy?n vào bi?n conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setString(1, khachhang.getTen());
        statement.setString(2, khachhang.getSodienthoai());
        statement.setString(3, khachhang.getDiachi());
        statement.setString(4, khachhang.getGhichu());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        // region Gi?i phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public int getidkhachhang(Khachhang khachhang) throws SQLException {
        String sql = "SELECT * FROM khachhang WHERE ten = ? and sodienthoai = ? and diachi = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setString(1, khachhang.getTen());
        statement.setString(2,khachhang.getSodienthoai());
        statement.setString(3,khachhang.getDiachi());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            int id = resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();

        return id;
    }
}
