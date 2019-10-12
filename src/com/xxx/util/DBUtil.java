package com.xxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * 数据库连接工具类
 *
 */
public class DBUtil {
	//类加载只执行一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		String sql="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
		Connection conn;
		try {
			conn = DriverManager.getConnection(sql,"root","");
			return conn;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void close(Connection conn){
		try {
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps){
		try {
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
