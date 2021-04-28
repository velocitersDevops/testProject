package com.velociter.training.aalam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Connection 
{
	public static Connection connection =null;
	Statement statementObject = null;
   public static Connection getDBConnection()  
   {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root123");

		} catch (ClassNotFoundException e) {
			System.err.println("Class Not Found ! Plases check");
			System.exit(0);
		} catch (SQLException sqle) {
			System.err.println("have some Database issues ! please Check");
			System.exit(0);
		}
		return connection;
   }
   	

}