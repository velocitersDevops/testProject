package com.velociter.training.vivek.crud.jdbc;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.naming.CommunicationException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;


public class CrudOperation

{
	
	
	public static  boolean isName(String name)
	{
		return Pattern.matches("[A-Za-z]{3,10}", name);
	}
	
	public static boolean isID(String id)
	{
		boolean b;
		
		b=Pattern.matches("[0-9]+", id);
		
		
		
		//b=Pattern.matches("[0-9]+", id);
		return b;
		
		
	}
	
	public static boolean dateValidation(String date)
	{
		return Pattern.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", date);
	}
	
	
	
	
	
   public static void main(String args []) throws Exception
   {
	  String continueData="";
	  System.out.println("Welcome");      //Displaying Welcome message
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");     
	  
	 // String connectionUrl="jdbc:mysql://localhost:3306/student_table,"+"root,"+"root";
	  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_table","root","root");
	  
	  Scanner scanner=new Scanner(System.in);
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
				  
				   fname=scanner.next();
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
				   lname=scanner.next();
				  
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
				   age=scanner.next();
				  
				  b=CrudOperation.isID(age);
				  
				  if(b==true)
					{
						//b=false;
						int ageValidation=Integer.parseInt(age);
						if(ageValidation<18 || ageValidation>63)
						{
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
				  
				  city=scanner.next();
				  
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
						 String month=date_of_joining.substring(0, 1);
						 int monthLimit=Integer.parseInt(month);
						 if(monthLimit<1||monthLimit>12)
						 {
							System.out.println("Please enter valid month");
							b=false;
							break;
						 }
						 
						 else if(b==true)
						 {
							 String date=date_of_joining.substring(3, 4);
							 int dateLimit=Integer.parseInt(date);
							 if(dateLimit<1||dateLimit>31)
							 {
								 System.out.println("Please enter valid date");
								 b=false;
								 break;
							 }
						 }
						 
						 else if(b==true)
						 {
							 String year=date_of_joining.substring(6, 9);
							 int yearLimit=Integer.parseInt(year);
							 if(yearLimit<2018||yearLimit>2021)
							 {
								 System.out.println("Please enter valid year");
								 b=false;
								 break;
							 }
						 }
					 }
				 }
				 
				 b=false;
				 
				                                                //user input on department and validate it
				 String department="";
				 System.out.println("Enter  department ");
				// department=scanner.next();
				 while(b==false)
				 {
					 department=scanner.next();
					b=CrudOperation.isName(department);
					
					if(b==false)
					{
						System.out.println("Please enter valid department");
					}
					 
				 }
				 
				 
				 
				  int status=1;                             //set status =1
				  
	              Statement st=connection.createStatement();
	              String sql="insert into emp_info (fname ,lname,age,city,date_of_joining,department,Status) values ('"+fname+"','"+lname+"',"+age+",'"+city+"','"+date_of_joining+"' , '"+department+"' , "+status+")";
				
	              st.executeUpdate(sql);
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
