package com.xxx.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.xxx.entity.Product;
import com.xxx.dbcp.DbcpConnection;

public class Test {

    public static void main(String[] args) {
    			
        Product product = new Product();
        product.setId(15);
        product.setName("金桔");
        product.setPrice(22);
      
        //saveProduct(product);
        
        //updateProduct(product);
        findProductByName("金桔");
        //deleteProductById(7);
        findProductById(3);
        findProductByPrice(1999);
    }
    /*
     * 实现添加商品的方法
     */
    public static void saveProduct(Product product){
        Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement("insert into product(id,name,price) values(?,?,?)");
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setInt(3, product.getPrice());
            int rs = pstmt.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    /*
     * 实现删除商品的方法(根据id)
     */
    public static void deleteProductById(int id){
    	Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement("delete from product where id=?");
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    /*
     * 实现修改商品的方法(根据id)
     */
    public static void updateProduct(Product product){
        Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement("update product set name=?,price=? where id=?");
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getId());
            int rs = pstmt.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    /*
     * 实现根据id查询商品的方法
     */
    public static Product findProductById(Integer id){
        Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        Product product = new Product();
        try {
            pstmt = conn.prepareStatement("select * from product where id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	product.setId(rs.getInt("id"));
            	product.setName(rs.getString("name"));
            	product.setPrice(rs.getInt("price"));
               
                System.out.println(product);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return product;
    }
    
    /*
     * 实现根据商品名查询商品的方法
     */
    public static Product findProductByName(String name){
        Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        Product product = new Product();
        try {
            pstmt = conn.prepareStatement("select * from product where name = ?");
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                
                System.out.println(product);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

        return product;
    }
    
    /*
     * 实现根据价格查询商品的方法
     */
    public static List<Product> findProductByPrice(int price){
        Connection conn = DbcpConnection.getConnection();
        PreparedStatement pstmt;
        List<Product> list = new ArrayList<Product>();
        Product product = new Product();
        try {
            pstmt = conn.prepareStatement("select * from product where price = ?");
            pstmt.setInt(1, price);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                list.add(product);
                System.out.println(product);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return list;
    }
    
   

}
