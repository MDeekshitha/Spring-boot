package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.demo.exception.DepartmentException;

public class DbUtil {
	public static Connection getConnection() {
		String url= "jdbc:mysql://localhost:3306/wipro";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			return con;
		}catch(ClassNotFoundException e){
			throw new DepartmentException(e.getMessage());
		}catch(SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
	}
}
