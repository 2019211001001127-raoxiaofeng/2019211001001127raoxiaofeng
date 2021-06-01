package com.raoxiaofeng.dao;

import com.raoxiaofeng.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into Product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "delete from Product where productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        n = pt.executeUpdate();
        if(n>0){
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update Product set ProductName = ?,ProductDescription = ?,Picture=?,Price = ?,CategoryID = ? where ProductId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,instance.getProductName());
        pt.setString(2,instance.getProductDescription());
        if(instance.getPicture()!=null) {
            pt.setBinaryStream(3, instance.getPicture());
        }
        pt.setDouble(4,instance.getPrice());
        pt.setInt(5,instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        n = pt.executeUpdate();
        if(n>0){
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from Product where productId="+productId;
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        Product product = null;
        while (rs.next()){
            product = new Product();
            product.setProductId(productId);
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getInt("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql = " select productId,productName,ProductDescription,picture,price,CategoryId from Product where CategoryId="+categoryId;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Product> Product = new ArrayList<Product>();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            Product.add(product);
        }
        return Product;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = " select productId,productName,ProductDescription,picture,price,CategoryId from Product where price>"+minPrice+"and price<"+maxPrice;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Product> Product = null;
        Product product;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getInt("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            Product.add(product);
        }
        return Product;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = " select productId,productName,ProductDescription,picture,price,CategoryId from Product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Product> list = new ArrayList<Product>();
        Product product;
        while(rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getInt("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql ="select productId,productName,ProductDescription,picture,price,CategoryId from Product where productName="+productName;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Product> Product = null;
        Product product;
        while(rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getInt("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            Product.add(product);
        }
        return Product;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql = "select productId,picture where productId="+productId;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Product> Product = null;
        Product product;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setPicture(rs.getBinaryStream("picture"));
            Product.add(product);
        }
        return Product;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws SQLException {
        byte[] imgBytes = null;
        String sql = "select picture from product where productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Blob blob = rs.getBlob("picture");
            imgBytes = blob.getBytes(1,(int)blob.length());
        }
        return imgBytes;
    }
}
