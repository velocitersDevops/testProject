package com.velociter.training.mukesh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
public class DBConnection
{
	
	public static Connection getConnection()
	{
		Connection connection=null;
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException ex) 
			{
				
				System.out.println("Driver not Found please check");
				System.out.println(ex);
			}
			try
			{
				 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			}catch(CommunicationsException ex)
			{
				System.out.println("connection failed problem");
			}
			catch (SQLException ex) 
			{
				
				System.out.println("Connection not establish check the connection ");
				System.out.println(ex);
			}
		
		
		return connection ;
		
	}
}
