package com.velociter.training.vivek.crud.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.naming.CommunicationException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.util.*;

public class CrudOperation

{
	
	
	public static  boolean isName(String name)
	{
		boolean b;
		b=Pattern.matches("[A-Za-z]{3,10}", name);
		
		//System.out.println(name);
		
		if(b==true)
		{
			b=	name.indexOf(' ') >= 0;
			
			if(b==false)
			{
				b=true;
			}
			else
			{
				b=false;
			}
		}
		
		return b;
	}
	
	public static boolean isID(String id)
	{
		boolean b;
		
		b=Pattern.matches("[0-9]+", id);
		
		if(b==true)
		{
			b=	id.indexOf(' ') >= 0;  //it returns false if string not contain space
			
			if(b==false)
			{
				b=true;
			}
			else
			{
				b=false;
			}
		}
		
		
		//b=Pattern.matches("[0-9]+", id);
		return b;
		
		
	}
	
	  public static boolean date_of_birthValidation(String date_of_birth) throws ParseException 
	  {
		  boolean b=false;
		  SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	      Date date = formatter.parse(date_of_birth);
	      //Converting obtained Date object to LocalDate object
	      Instant instant = date.toInstant();
	      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	      LocalDate givenDate = zone.toLocalDate();
	      //Calculating the difference between given date to current date.
	      Period period = Period.between(givenDate, LocalDate.now());
	      
	      System.out.println(period.getYears());
	      int year=period.getYears();
	      {
	    	  if(year<18||year>45)
	    	  {
	    		 b=false; 
	    	  }
	    	  else
	    	  {
	    		  b=true;
	    	  }
	      }
	      
	      return b;
		    		
	  }
	  
	  public static boolean date_of_joining(String date_of_joining) throws ParseException 
	  {
		  boolean b=false;
		  SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	      Date date1 = formatter.parse(date_of_joining);
	   // LocalDate newDate=LocalDate.now();
	      Date date2=formatter.parse("03-05-2021");      //Converting obtained Date object to LocalDate object
	      Instant instant = date1.toInstant();
	      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	      LocalDate givenDate = zone.toLocalDate();
	      //Calculating the difference between given date to current date.
	     // Period period = Period.between(givenDate, LocalDate.now());
	      
	     // System.out.println(period.getYears());
	      if(date1.after(date2))
	      {
	    	 // System.out.println("vivek");
	    	  b=false;
	      }
	      else if(date1.before(date2))
	      {
	    	  //System.out.println("mukesh");
	    	  b=true;
	      }
	      
	      
	      return b;
		    		
	  }
	
	public static boolean dateValidation(String date) 
	{
		return Pattern.matches("^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$", date);
	}
	
	
	
	
	
   public static void main(String args []) throws Exception
   {
	  String continueData="";
	  System.out.println("Welcome");      //Displaying Welcome message
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");     
	  
	 // String connectionUrl="jdbc:mysql://localhost:3306/student_table,"+"root,"+"root";
	  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");
	  
	  Scanner scanner=new Scanner(System.in);
	  
	  BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	  Boolean b=false;
	  
	  
	 do
	 {
		  System.out.println("select option from below menu :");
		  System.out.println("Press 1 : select data \nPress 2 : insert data \nPress 3 : delete data \nPress 4 : update data");
		  System.out.println("press 5 : even rows\npress 6 : odd rows\npress 7: How many employ in each department\npress 8 : Search by name of Employee");
		  System.out.println("press 9 : To find detail of employee who has given their family datail");
		  System.out.println("press 10 : To find detail of employee who has not given their family id");
		  System.out.println("press 11: total no of employee who has not given their family detail");
		  System.out.println("press 12: tota no of employee who has not given their family detail");
		  System.out.println("press 13: to add family datil of employee");
		  
		//  Scanner scanner = new Scanner(System.in);
		  
		  //int  dataInput=scanner.nextInt();
		 
		  int dataInput=0;
		   try
		   {
			   int  dataInputs=scanner.nextInt();
			   dataInput=dataInputs;
		   }
		  catch(InputMismatchException e)
		   {
			  System.out.println("You have selectd wrong input try again");
			  System.exit(0);;
		   }
		
		
		  switch(dataInput)
		  {
		  
		  case 1:                      //Displaying record from database
			  
			 // ResultSet resultSet=null;
			  
			  try
			  {
				//Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");  
				
				Statement statement = connection.createStatement();
				
				String selectSql= "select * from emp_info where age between 22 and 56";
				
				ResultSet resultSet=statement.executeQuery(selectSql);
				
				System.out.print("\tid ");
				System.out.print("\tfname ");
				System.out.print("\t\tlname ");
				System.out.print("\t\tage");
				System.out.print("\t\tcity");
				System.out.print("\t\tdate_of_joining");
				System.out.print("\t\t\t\tdepartment");
				System.out.println("\t\tStatus");
				//System.out.println();
				System.out.println("\t===============================================================================================================================================");
				
				
				while(resultSet.next())
				{
					
					   int id=resultSet.getInt("id");
					   String fname=resultSet.getString("fname");
					   String lname=resultSet.getString("lname");
					   int age=resultSet.getInt("age");
					   String city=resultSet.getString("city");
					   String date_of_joining=resultSet.getString("date_of_joining");
					   String department=resultSet.getString("department");
					   
					   int status=resultSet.getInt("Status");
					   
					   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+date_of_joining+"\t\t\t\t"+department+"\t\t\t"+status);
					  
					   
					   System.out.println();
					
				}
				System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------");
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database is not reachable");
				  System.exit(0);
			  }
			
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
		  case 2:                                     // Inserting new element in database
			 
			  try
			  {
				  String fname="";
				//  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");
				  while(b==false)
				  {
				  System.out.print("Enter First name ");
				 // String fadname=scanner.nextLine();
				  
				   //fname=scanner.nextLine();
				  
				  fname=reader.readLine();
				b=CrudOperation.isName(fname);
				if(b==false)
				{
					System.out.println("Please enter valid  name it should start with capital letters and it can not be digit and minimum character is 3 ");
					
				}
				  }
				  
				b=false;
				  
				String lname="";
				while(b==false)
				{
				  System.out.println("Enter last name ");
				  // lname=scanner.nextLine();
				  
				  lname=reader.readLine();
				  
				  b=CrudOperation.isName(lname);
				  if(b==false)
				  {
					  System.out.println("Please enter valid  name it should start with capital letters and it can not be digit and minimum character is 3 ");
					 
				  }
				}
				
				
				b=false;
				
				String age="";
				while(b==false)
				{
				  System.out.println("Enter your age");
				 //  age=scanner.nextLine();
				  
				  age=reader.readLine();
				  
				  b=CrudOperation.isID(age);
				 
				  
				  if(b==true)
					{
						//b=false;
						int ageValidation=Integer.parseInt(age);
						if(ageValidation<18 || ageValidation>63)
						{
							System.out.println("");
							b=false;
						}
						
					}
				 
				  if(b==false)
				  {
					  System.out.println(" Please Enter valid age");
					  
				  }
				  
				
				  
				}
				 
				 b=false;
				 
				
				 
				 
				 String city="";
				 while(b==false)
				 {
				  System.out.println("Enter your city");
				  
				 // city=scanner.nextLine();
				  
				  city=reader.readLine();
				  
				 b= CrudOperation.isName(city);    //valildation of city
				 if(b==false)
				  {
                      System.out.println("Please enter valid city");
                      
				  }
				 }
				 
				 b=false;
				 
				 
				 
				 String date_of_joining="";
				 while(b==false)
				 {
					 System.out.println("Enter your date of joining");  //logic for date_of_joining_validation
					  date_of_joining=scanner.next();
					 
					 b=CrudOperation.dateValidation(date_of_joining);
					 
					 if(b==true)
					 {
						 b=CrudOperation.date_of_joining(date_of_joining);
					 }
					
				 }
				 
				 b=false;
				 
				                                                //user input on department and validate it
				 String department="";
				 System.out.println("Enter  department ");
				// department=scanner.next();
				 while(b==false)
				 {
					 //department=scanner.next();
					 
					 department=reader.readLine();
					b=CrudOperation.isName(department);
					
					if(b==false)
					{
						System.out.println("Please enter valid department");
					}
					 
				 }
				 
				 b=false;
				 
				  int status=1;                             //set status =1
				  
				  String date_of_birth="";
				  
				  System.out.println("enter date of birth in MM/dd/YYYY");
				  
				  while(b==false)
				  {
					 date_of_birth=reader.readLine();
					 
					b= CrudOperation.dateValidation(date_of_birth);
					System.out.println(b);
					 
					 if(b==true)
					 {
						 b=CrudOperation.date_of_birthValidation(date_of_birth);
						 
					 }
					 if(b==false)
					 {
						 System.out.println("Please enter valid date MM/dd/yyyy   or your age should greater than 18 and less than 62");
					 }
				  }
				  
				  b=false;
				  
	             Statement st=connection.createStatement();
	              String sql="insert into emp_info (fname ,lname,age,city,date_of_joining,department,Status,date_of_birth) values ('"+fname+"','"+lname+"',"+age+",'"+city+"','"+date_of_joining+"' , '"+department+"' , "+status+", '"+date_of_birth+"')";
				
	             int rowCount= st.executeUpdate(sql);
				  System.out.println("Data enterd successfully ");
				  
				 
			  }
			  
			 
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database is not reachable");
				  System.exit(0);
			  }
			  
			  catch(InputMismatchException enp)
			  {
				  System.out.println("Please enter valid input");
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
				  
			  
			  break;
			  
			  
		  case 3:    //deleting row from table
			  
			  try
			  {
				  
				//  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");  
				  
				  Statement stmt=connection.createStatement();
				  
				  System.out.println("Enter an ID you want to DELETE");
				  
				  String id="";
				  
				  while(b==false)
				  {
				   id=scanner.next();
				  
				  b= Pattern.matches("[0-9]+", id);  //validate id is digit or not
				  if(b==false)
				  {
					  System.out.println("Please enter valid id it can be only  positive numeric value");
					  
				  }
				  }
				  b=false;
				  
				  String deleteQuery="update emp_info set status=0  where id = "+id;  //query for set status =0
				  
				 int i= stmt.executeUpdate(deleteQuery);       //
				 
				 if(i>0)
				 {
				  System.out.println("Data deleted successfully");
				 }
				 else
				 {
					 System.out.println("you have entered wrong id");
					 //System.out.println("0 row are deleted");
				 }
				  
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("Database is not reachable");
				  System.exit(0);
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  
			  break;
			  
		  case 4:                       //updating database
			  
			  try
			  {
				//  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");
				  Statement statement = connection.createStatement();
				  
				
				  System.out.println("enter id which you want to update");
				  
				  String id="";
				  
				  while(b==false)
				  {
				   id=scanner.next();
				  
				  b=Pattern.matches("[0-9]+", id);           //check that given id is valid or not
				  
				  if(b==false)
				  
				  {
					  System.out.println("Please enter valid id it can be only  positive numeric value");
					  
				  }
				  }

				 
				  System.out.println("enter the col which you want to updae :fname,lname,age,city");
				  
				  String updateCol=scanner.next();
				  
				  if(updateCol.equals("fname")||updateCol.equals("lname")||updateCol.equals("age")||updateCol.equals("city")) //validate that user entered correct column or not
				  {
					  continue;
				  }
				  
				  else
				  {
					  System.out.println("Please enter the valid column");
					  updateCol=scanner.next();
				  }
				  
				  
				  System.out.println("enter data :");
				  String data=scanner.next();
				  
				 if(data.equals("age"))
				 {
					 
				 }
				 else if(CrudOperation.isName(data)==false)
				 {                                                                //validate age 
					 System.out.println("Please Enter valid data");
					 data=scanner.next();
				 }
				  
				 
				  
				  String updateQuery=" update emp_info set   "+updateCol+"  =  '"+data+" ' where id = "+id;
				  
				 
				  
				 
				  
				 int row= statement.executeUpdate(updateQuery);
				 
				 if(row>0)
				 {
				  
				  System.out.println("data updated successfully");
				 }
				 else
				 {
					 System.out.println("You have entered wrong id try again ");
				 }
				  
				
				  
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("Database is not reachable");
				  System.exit(0);
			  }
			  catch(SQLException e)
			  {
				 e.printStackTrace(); 
			  }
			
			  break;
			  
		  case 5:
			  
			  try
			  {
                 // Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");  
				  
				  Statement statement=connection.createStatement();
				  
				  String evenQuery="select * from emp_info  where id%2 = 0";  //query for printing even id row
				  
				   ResultSet resultSet=statement.executeQuery(evenQuery);
					
					System.out.print("\tid ");                 //heading of table started
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.print("\t\tage");
					System.out.print("\t\tcity");
					System.out.println("\t\tStatus");
					//System.out.println();
					System.out.println("\t================================================================================");     //heading of  table closed
					
					
					while(resultSet.next())
					{
						
						   int id=resultSet.getInt("id");                                        //Display data of table
						   String fname=resultSet.getString("fname");
						   String lname=resultSet.getString("lname");
						   int age=resultSet.getInt("age");
						   String city=resultSet.getString("city");
						   int status=resultSet.getInt("Status");
						   
						   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+status);
						  
						   
						   System.out.println();
						
					}
					System.out.println("\t--------------------------------------------------------------------------------");  //end of table
				  
				  
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database is not reachable");
				  System.exit(0);
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
				  
			  }
			  break;
			  
		  case 6:
			      try
			     {
				  
                  //  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");  
				  
				  Statement statement=connection.createStatement();
				  
				  String evenQuery="select * from emp_info  where id%2 != 0";  //query for printing odd id row
				  
				   ResultSet resultSet=statement.executeQuery(evenQuery);
					
					System.out.print("\tid ");    //heading of table started
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.print("\t\tage");
					System.out.print("\t\tcity");
					System.out.println("\t\tStatus");
					//System.out.println();
					System.out.println("\t================================================================================");  //heading of table closed
					
					
					while(resultSet.next())
					{
						
						   int id=resultSet.getInt("id");                               //data of table started 
						   String fname=resultSet.getString("fname");
						   String lname=resultSet.getString("lname");
						   int age=resultSet.getInt("age");
						   String city=resultSet.getString("city");
						   int status=resultSet.getInt("Status");
						   
						   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+status);  
						  
						   
						   System.out.println();
						
					}
					System.out.println("\t--------------------------------------------------------------------------------");  //data of table closed
				  
				  
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("Database is not reachable");
				  System.exit(0);
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
				  
			  }
			  
			  break;
			  
		  case 7:
			  
			  try
			  {
				  Statement statement=connection.createStatement();
				  String s="select count(*) as Total_No_of_emplyoe ,department from emp_info group by department";
				  
				  ResultSet resultSet=statement.executeQuery(s);
				  
				  System.out.println("\t\tTotal_No_Of_employee\t\t\tdepartment");
				  System.out.println("\t\t======================================================");
				  
				  while(resultSet.next())
				  {
					  int Total_No_Of_emplyee=resultSet.getInt("Total_No_of_emplyoe");
					   String department=resultSet.getString("department");
					   
					   System.out.println("\t\t"+Total_No_Of_emplyee+"\t\t\t\t\t"+department);
					   System.out.println("\t\t-----------------------------------------------------");
				  }
			  }
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database can not reachable");
				  System.exit(0);
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
		
		  break;
		      
		  case 8:
			  
			  try
			  {
				  System.out.println("Enter The name or character for searching the name of employee");
				  String empName="";
				  while(b==false)
				  {
					  empName=scanner.next();
					  b=Pattern.matches("[A-Za-z]{1,10}", empName);
					  if(b==false)
					  {
						  System.out.println("Enter valid character again");
					  }
				  }
				  
				  b=false;
				  
				  
				  String searchQuery="select * from emp_info where fname like '"+empName+"%'";
				  Statement statement =connection.createStatement();
				  
				  ResultSet resultSet=statement.executeQuery(searchQuery);
				  
				  System.out.print("\tid ");
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.print("\t\tage");
					System.out.print("\t\tcity");
					System.out.print("\t\tdate_of_joining");
					System.out.print("\t\t\tdepartment");
					System.out.println("\t\tStatus");
					//System.out.println();
					System.out.println("\t=======================================================================================================================================");
					
				  
					while(resultSet.next())
					{
						
						   int id=resultSet.getInt("id");
						   String fname=resultSet.getString("fname");
						   String lname=resultSet.getString("lname");
						   int age=resultSet.getInt("age");
						   String city=resultSet.getString("city");
						   String date_of_joining=resultSet.getString("date_of_joining");
						   String department=resultSet.getString("department");
						   int status=resultSet.getInt("Status");
						   
						   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+date_of_joining+"\t\t\t"+department+"\t\t\t"+status);
						  
						   
						   System.out.println();
						
					}
					System.out.println("\t----------------------------------------------------------------------------------------------------------------------------------------");
				  }
				  
				  
			  
			  catch(CommunicationsException ex)
			  {
				  System.out.println("database can not reachable");
				  System.exit(0);
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
		  case 9:
			  
			  try
			  {
				  String No_family_Detail="select * from emp_info where id IN (select emp_info_id from family )";
				  
				  Statement statement =connection.createStatement();
				  ResultSet resultSet=statement.executeQuery(No_family_Detail);
				  
				  
				  
				  System.out.print("\tid ");
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.print("\t\tage");
					System.out.print("\t\tcity");
					System.out.print("\t\tdate_of_joining");
					System.out.print("\t\t\tdepartment");
					System.out.println("\t\tStatus");
					//System.out.println();
					System.out.println("\t=======================================================================================================================================");
					
					while(resultSet.next())
					{
						
						   int id=resultSet.getInt("id");
						   String fname=resultSet.getString("fname");
						   String lname=resultSet.getString("lname");
						   int age=resultSet.getInt("age");
						   String city=resultSet.getString("city");
						   String date_of_joining=resultSet.getString("date_of_joining");
						   String department=resultSet.getString("department");
						   int status=resultSet.getInt("Status");
						   
						   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+date_of_joining+"\t\t\t"+department+"\t\t\t"+status);
						  
						   
						   System.out.println();
						
					}
					System.out.println("\t----------------------------------------------------------------------------------------------------------------------------------------");
				  
				  
				  
			  }
			  
			  
			  
			  
			  catch(CommunicationsException ex)
			  {
				  System.out.println("database can not reachable");
				  System.exit(0);
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
		  case 10:
			  
			  try
			  {
				  String No_family_Detail="select * from emp_info where id not in (select emp_info_id from family )";
				  
				  Statement statement =connection.createStatement();
				  ResultSet resultSet=statement.executeQuery(No_family_Detail);
				  
				  
				  
				  System.out.print("\tid ");
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.print("\t\tage");
					System.out.print("\t\tcity");
					System.out.print("\t\tdate_of_joining");
					System.out.print("\t\t\tdepartment");
					System.out.println("\t\tStatus");
					//System.out.println();
					System.out.println("\t=======================================================================================================================================");
					
					while(resultSet.next())
					{
						
						   int id=resultSet.getInt("id");
						   String fname=resultSet.getString("fname");
						   String lname=resultSet.getString("lname");
						   int age=resultSet.getInt("age");
						   String city=resultSet.getString("city");
						   String date_of_joining=resultSet.getString("date_of_joining");
						   String department=resultSet.getString("department");
						   int status=resultSet.getInt("Status");
						   
						   System.out.print("\t"+id+"\t"+fname+"\t\t"+lname+"\t\t"+age+"\t\t"+city+"\t\t"+date_of_joining+"\t\t\t"+department+"\t\t\t"+status);
						  
						   
						   System.out.println();
						
					}
					System.out.println("\t----------------------------------------------------------------------------------------------------------------------------------------");
				  
				  
				  
			  }
			  
			  
			  
			  
			  catch(CommunicationsException ex)
			  {
				  System.out.println("database can not reachable");
				  System.exit(0);
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
			  
		  case 11:
			  
			  try
			  {
				  Statement statement =connection.createStatement();
				  
				  String No_family_Detail="select count(*) as total_emp from emp_info where id not In (select emp_info_id from family )";
				  ResultSet resultSet =statement.executeQuery(No_family_Detail);
				  
				  System.out.print("total no of employ who has not given their family detail : ");
				  while(resultSet.next())
				  {
					  int total=resultSet.getInt("total_emp");
					  
					  System.out.print(total);
				  }
				  
				  
				  
			  }
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database not reachable");
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
		  case 12:
			  try
			  {
                  Statement statement =connection.createStatement();
				  
				  String No_family_Detail="select count(*) as total_emp from emp_info where id in (select emp_info_id from family )";
				  ResultSet resultSet =statement.executeQuery(No_family_Detail);
				  
				  System.out.print("total no of employ who has  given their family detail : ");
				  while(resultSet.next())
				  {
					  int total=resultSet.getInt("total_emp");
					  
					  System.out.print(total);
					  System.out.println();
				  }
			  }
			  
			  
			  
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database not reachable");
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
			  
		  case 13 :
			  
			  try
			  {
				  Statement statement =connection.createStatement();
				  
				  String id="";
				  
				//  System.out.println("Please enter valid emp_id");
				  
				  while(b==false)
				  {
					  System.out.println("Please enter valid emp_id");
					  id=scanner.next();
					  b=CrudOperation.isID(id);
					  if(b==true)
					  {
						  String checkEmpId="select count(id)as id from emp_info where id = "+id;
						  ResultSet resultSet = statement.executeQuery(checkEmpId);
						  
						  int newId=0;
						 while(resultSet.next())
						 {
							   newId=resultSet.getInt("id");
						 }
							 if(newId==1)
							 {
								 
								 String checkIdQuery="select count(emp_info_id) as ID from family where emp_info_id = "+id;
								 Statement statement1 =connection.createStatement();
								  resultSet=statement1.executeQuery(checkIdQuery);
								// System.out.println("vivek");
								 
								 int newID=0;
								 while(resultSet.next())
								 {
									  newID=resultSet.getInt(1);
									  //newID=1;
								 } 
								// System.out.println(newID);
									 if(newID==1)
									 {
										 System.out.println("This employ is already given family datail");
										 System.out.println("Do you want to update it");
										 System.out.println("press 1: for Update otherwise get exit ThanKyou");
										 //String caseInput="";
										 
										int caseInput=scanner.nextInt();
										
										switch(caseInput)
										{
										case 1:
											System.out.println("enter father name");
											String newFatherName=scanner.next();
											System.out.println("enter mother name");
											String newMotherName=scanner.next();
											
											String updateFamily="update family set father_name = '"+newFatherName+"', mother_name ='"+newMotherName+"' where id = "+id;
											int rowCount=statement.executeUpdate(updateFamily);
											
											if(rowCount>0)
											{
												System.out.println("details updated successfully Thankyou ");
												System.exit(0);
											}
											else
											{
												System.out.println("data not updated successfully Please try again");
												System.exit(0);
											}
											break;
											
											default :
												System.exit(0);
												break;
										}
										
										 
										 
										 
										 
									 }
									 
								 
								 System.out.println("Please Enter father name");
								 b=false;
								 
								 String father_name="";
								 while(b==false)
								 {
									 father_name=scanner.next();
									 b=CrudOperation.isName(father_name);
									 if(b==false)
									 {
										 System.out.println("Please enter valid father name");
									 }
								 }
								 b=false;
								 String mother_name="";
								 
								 System.out.println("Please enter mother name");
								 while(b==false)
									 
								 {
									 
									 mother_name=scanner.next();
									 b=CrudOperation.isName(mother_name);
									 if(b==false)
									 {
										 System.out.println("Please Enter valid mother_name");
									 }
								 }
								 b=false;
								 
								 String insertQuery="insert into family (emp_info_id,father_name,mother_name) values ("+id+", '"+father_name+"' ,'"+mother_name+"') ";
							     int i =statement.executeUpdate(insertQuery);
							     
							     if(i>0)
							     {
							    	 System.out.println("data inserted successfully Thanks");
							    	 break;
							     }
							    
							 }
							 else
							 {
								 System.out.println("THIS EMPLOYEE ID  DOES NOT EXIST ");
								 b=false;
							 }
								 
						  
					  }
					  else
					  {
						  System.out.println("YOU HAVE ENTERED WRONG ID SEQUENCE IT WILL BE ONLY NUMBER ");
					  }
					  
				  }
			  }
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database not reachable");
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  
			  
			  
		  case 14:
			  
			  try
			  {
				  Statement statement =connection.createStatement();
				  
				  String details_info=" select emp_info.id,family.father_name,family.mother_name from emp_info,family where emp_info.id=family.emp_info_id ";
				  
				  ResultSet resultSet = statement.executeQuery(details_info);
				  
				  System.out.print("\tid ");
					System.out.print("\tfname ");
					System.out.print("\t\tlname ");
					System.out.println();
					System.out.println("\t==========================================");
					
					while(resultSet.next())
					{
						int eid=resultSet.getInt("id");
						String father_name=resultSet.getString("father_name");
						String mother_name=resultSet.getString("mother_name");
						
						System.out.println("\t"+eid+"\t"+father_name+"\t\t"+mother_name);
						System.out.println("\t------------------------------------------");
						
					}
				  
				  
			  }
			  
			  catch(CommunicationsException ee)
			  {
				  System.out.println("database not reachable");
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  break;
			  default :
				  System.out.println("You have selected wrong Input ");
				  break;
		  
		  }
		  
		  
		  
		  
		  System.out.println("Enter y to continue : else perss any other key to exit the program");
		  
		  continueData=scanner.next();
		  
		
	  }
	 while(continueData.equalsIgnoreCase("y"));
	  
	
	   
	   
	   
   }
}
