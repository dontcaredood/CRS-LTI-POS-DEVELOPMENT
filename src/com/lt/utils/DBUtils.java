package com.lt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	public static final String user = "root";
	public static final String pass="root";
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/testLTI";
	
	public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
		
	return con;
	}
	
}