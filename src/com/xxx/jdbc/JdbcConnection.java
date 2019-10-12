package com.xxx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xxx.entity.Product;

public class JdbcConnection {

	public static void main(String[] args) {
		//注意mysql数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
			Connection conn=DriverManager.getConnection(url,"root","189219");
			PreparedStatement ps=conn.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			Product product = new Product();
			while(rs.next()){
				//打印所有商品的名字
				//String name=rs.getString("name");
				//System.out.println(name);
				product.setId(rs.getInt("id"));
            	product.setName(rs.getString("name"));
            	product.setPrice(rs.getInt("price"));
                System.out.println(product);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
