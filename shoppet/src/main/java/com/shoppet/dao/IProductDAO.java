package com.shoppet.dao;

import com.shoppet.model.Category;
import com.shoppet.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;
    public Product selectProduct(int id);
    public Product InfoProduct(int id);
    public List<Product> selectAllProduct();
    public List<Category> selectAllCategory();
    public boolean deleteProduct(int id) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;
    public List<Product> findData(String keyWord);
}
