package com.xxx.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpConnection {
	private static DataSource ds=null;
	static{
		try {
			FileInputStream in=new FileInputStream("resource/dbcp.properties");
			Properties p=new Properties();
			p.load(in);
			ds=BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=ds.getConnection();
			return conn;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	

}
