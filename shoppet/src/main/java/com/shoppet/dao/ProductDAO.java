package com.shoppet.dao;

import com.shoppet.model.Category;
import com.shoppet.model.Product;
import com.shoppet.utils.ConfigConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    public ProductDAO(){

    }

    Connection connection = ConfigConnection.getConnection();

    private static final String SELECT_ALL_PS = "SELECT p.id,p.name,p.price,p.quantity,p.image,c.name as category from sanpham p left join category c on p.category=c.id";
        private static final String SELECT_ALL_Pet = "SELECT p.id,p.name,p.price,p.quantity,p.image,c.name as category from shoppetmap.sanpham p left join shoppetmap.category c on p.category=c.id where p.category = 1";
    private static final String SELECT_ALL_Product = "SELECT p.id,p.name,p.price,p.quantity,p.image,c.name as category from shoppetmap.sanpham p left join shoppetmap.category c on p.category=c.id where p.category = 2";
    private static final String SELECT_ALL_Service = "SELECT p.id,p.name,p.price,p.quantity,p.image,c.name as category from shoppetmap.sanpham p left join shoppetmap.category c on p.category=c.id where p.category = 3";
    private static final String INSERT_PS_SQL = "insert into sanpham(name,price,quantity,image,category) values (?,?,?,?,?)";
    private static final String UPDATE_P_SQL = "update sanpham set name = ?, price = ?, quantity = ?, image = ?, category = ? where id = ?;";
    private static final String SELECT_P_BY_ID = "select name,price,quantity,image,category from sanpham where id = ?";
    private static final String DELETE_PS_SQL = "delete from sanpham where id = ?;";
    final String FIND_DATA = "select * from products where name like ? OR price like ? OR species like ?  OR quantity like ?;";
    final String FIND = "SELECT p.name as name,p.price as price,p.quantity as quantity,p.image as image,c.name as category from sanpham p left join category c on p.category=c.id where p.id = ?";
    @Override
    public void insertProduct(Product product) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PS_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setInt(5, product.getCateGory());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_P_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int category = result.getInt("category");
                product = new Product(name,price,quantity,image,category);
                product.setId(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

//    public Product InfoProduct(int id) {
//        Product product = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND);) {
//            preparedStatement.setInt(1,id);
//            ResultSet result = preparedStatement.executeQuery();
//            while (result.next()) {
//                String name = result.getString("name");
//                float price = result.getFloat("price");
//                int quantity = result.getInt("quantity");
//                String image = result.getString("image");
//                String category = result.getString("category");
//                product =   new Product(name,price,quantity,image,category);
//                product.setId(id);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return product;
//    }


    public Product InfoProduct(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_P_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int category = result.getInt("category");
                product = new Product(name,price,quantity,image,category);
                product.setId(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }


    @Override
    public List<Product> selectAllProduct() {
        List<Product> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,image,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<Product> selectAllPet() {
        List<Product> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,image,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<Product> selectAllPro() {
        List<Product> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,image,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<Product> selectAllService() {
        List<Product> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,image,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    final String SELECT_ALL_CATEGORY = "select * from category";
    @Override
    public List<Category> selectAllCategory() {
        List<Category> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                list.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PS_SQL);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

     @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate;
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_P_SQL);) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getImage());
            preparedStatement.setInt(5,product.getCateGory());
            preparedStatement.setInt(6,product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }


    @Override
    public List<Product> findData(String keyWord) {
        List<Product> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_DATA);) {
            preparedStatement.setString(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,image,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}

//
//package com.shoppet.dao;
//
//        import com.shoppet.model.Category;
//        import com.shoppet.model.Product;
//        import com.shoppet.utils.ConfigConnection;
//
//        import java.sql.*;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class ProductDAO implements IProductDAO{
//    public ProductDAO(){
//
//    }
//
//    Connection connection = ConfigConnection.getConnection();
//
//    private static final String SELECT_ALL_PS = "SELECT p.id,p.name,p.price,p.quantity,p.image,c.name as category from sanpham p left join category c on p.category=c.id";
//    private static final String INSERT_PS_SQL = "insert into sanpham(name,price,quantity,image,category) values (?,?,?,?,?)";
//    private static final String UPDATE_P_SQL = "update sanpham set name = ?, price = ?, quantity = ?, image = ?, category = ? where id = ?;";
//    private static final String SELECT_P_BY_ID = "select name,price,quantity,image,category from sanpham where id = ?";
//    private static final String DELETE_PS_SQL = "delete from sanpham where id = ?;";
//    final String FIND_DATA = "select * from products where name like ? OR price like ? OR species like ?  OR quantity like ?;";
//    final String FIND = "SELECT p.name,p.price,p.quantity,p.image,c.name as category from sanpham p left join category c on p.category=c.id where p.id = ?";
//    @Override
//    public void insertProduct(Product product) throws SQLException {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PS_SQL);) {
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setFloat(2, product.getPrice());
//            preparedStatement.setInt(3, product.getQuantity());
//            preparedStatement.setString(4, product.getImage());
//            preparedStatement.setInt(5, product.getCateGory());
//            preparedStatement.executeUpdate();
//        }catch (SQLException e) {
//            printSQLException(e);
//        }
//    }
//
//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//
//
//    @Override
//    public Product selectProduct(int id) {
//        Product product = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_P_BY_ID);) {
//            preparedStatement.setInt(1,id);
//            ResultSet result = preparedStatement.executeQuery();
//            while (result.next()) {
//                String name = result.getString("name");
//                float price = result.getFloat("price");
//                int quantity = result.getInt("quantity");
//                String image = result.getString("image");
//                int category = result.getInt("category");
//                product = new Product(name,price,quantity,image,category);
//                product.setId(id);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return product;
//    }
//    @Override
//    public Product InfoProduct(int id) {
//        Product product = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND);) {
//            preparedStatement.setInt(1,id);
//            ResultSet result = preparedStatement.executeQuery();
//            while (result.next()) {
//                String name = result.getString("name");
//                float price = result.getFloat("price");
//                int quantity = result.getInt("quantity");
//                String image = result.getString("image");
////                int category = result.getInt("category");
//                String category = result.getString("category");
//                product =   new Product(name,price,quantity,image,category);
////                product.setId(id);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return product;
//    }
//
//
//    @Override
//    public List<Product> selectAllProduct() {
//        List<Product> list = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PS);) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                float price = resultSet.getFloat("price");
//                int quantity = resultSet.getInt("quantity");
//                String image = resultSet.getString("image");
//                String category = resultSet.getString("category");
//                Product product = new Product(id,name,price,quantity,image,category);
//                list.add(product);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return list;
//    }
//
//    final String SELECT_ALL_CATEGORY = "select * from category";
//    @Override
//    public List<Category> selectAllCategory() {
//        List<Category> list = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
//            System.out.println(preparedStatement);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                Category category = new Category(id,name);
//                list.add(category);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return list;
//    }
//
//
//    @Override
//    public boolean deleteProduct(int id) throws SQLException {
//        boolean rowDelete;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PS_SQL);) {
//            preparedStatement.setInt(1,id);
//            rowDelete = preparedStatement.executeUpdate() > 0;
//        }
//        return rowDelete;
//    }
//
//    @Override
//    public boolean updateProduct(Product product) throws SQLException {
//        boolean rowUpdate;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_P_SQL);) {
//            preparedStatement.setString(1,product.getName());
//            preparedStatement.setFloat(2,product.getPrice());
//            preparedStatement.setInt(3,product.getQuantity());
//            preparedStatement.setString(4,product.getImage());
//            preparedStatement.setInt(5,product.getCateGory());
//            preparedStatement.setInt(6,product.getId());
//            rowUpdate = preparedStatement.executeUpdate() > 0;
//        }
//        return rowUpdate;
//    }
//
//
//    @Override
//    public List<Product> findData(String keyWord) {
//        List<Product> list = new ArrayList<>();
//        String key = "%" + keyWord + "%";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_DATA);) {
//            preparedStatement.setString(1,key);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                float price = resultSet.getFloat("price");
//                int quantity = resultSet.getInt("quantity");
//                String image = resultSet.getString("image");
//                String category = resultSet.getString("category");
//                Product product = new Product(id,name,price,quantity,image,category);
//                list.add(product);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return list;
//    }
//}
