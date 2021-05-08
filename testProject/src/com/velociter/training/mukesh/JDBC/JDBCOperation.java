package com.velociter.training.mukesh.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;


public class JDBCOperation 
{
	//-----------------display all records----------------------------- 	
	public static void  displayRecord()                       
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select * from emp_info";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING\tDEPT_ID");
			System.out.println("===========================================================================================================");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8)+"\t "+rs.getInt(9));
				
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	public static void evenDisplay()              // even record display method
	{
		Connection connection;
		Statement statement;
		Scanner input;
		
		try
		{
			 connection = DBConnection.getConnection();          // connection created
			 statement=connection.createStatement();
			 input=new Scanner(System.in);
			 
			 String sqlQuery="select * from emp_info where id IN(select id from emp_info where id%2 = 0)"; // query to fetch even records
			 ResultSet rs= statement.executeQuery(sqlQuery);
			 System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
				System.out.println("=====================================================================================");
			 while(rs.next())
			 {
				 System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
				 System.out.println("------------------------------------------------------------------------------------------");
			 }
			 connection.close();                          // close the connection
			 statement.close();
		}
		catch(CommunicationsException ex)
		{
			System.out.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.out.println("check your sql syntax");
			
		}
	}
	
	public static void oddDisplay()            // odd record data display method 
	{

		Connection connection;
		Statement statement;
		Scanner input;
		
		try
		{
			 connection = DBConnection.getConnection();            // connection created 
			 statement=connection.createStatement();
			 input=new Scanner(System.in);
			 
			 String sqlQuery="select * from emp_info where id IN(select id from emp_info where id%2<> 0)"; // query to fetch odd records
			 ResultSet rs= statement.executeQuery(sqlQuery);
			 System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
				System.out.println("-----------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
			}
			 connection.close();
			 statement.close();
		}
		catch(CommunicationsException ex)
		{
			System.out.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.out.println("check your sql syntax");
			
		}
	}
	
	//--------------- insert record-------------------------- 
	public  static void insertRecord()  
	{
		
		Connection connection;
		Statement statement;
		BufferedReader reader;
		try
		{
			 connection=DBConnection.getConnection();         // connection created
			 statement = connection.createStatement();
			
			 reader = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				
				System.out.println("Enter first name:");
				String firstname=reader.readLine();
				
				while(!firstname.matches("[A-Za-z]{3,10}"))
				{
				     System.err.println("not a valid name retype first name:");
				     firstname=reader.readLine();
					 
				}
				
				System.out.println("Enter last name:");
				String lastname=reader.readLine();
				
				while(!lastname.matches("[A-Za-z]{3,10}"))
				{
					System.err.println("not a valid so Enter retype last name:");
				    lastname=reader.readLine();
				    
				}
				System.out.println("Enter your age under 100");
				String age= reader.readLine();
				while(!age.matches("[0-9]{2}"))
				{
					System.err.println("not a valid so Enter retype age:");
					age= reader.readLine();
				}
				System.out.println("Enter city:");
				String city=reader.readLine();
				
				while(!city.matches("[A-Za-z]{3,10}"))
				{
					System.err.println("not a valid so Enter retype city name:");
				    city=reader.readLine();
				    
				}
				int status=1;
				
				System.out.println("Enter department:");
				String department=reader.readLine();
				
				while(!department.matches("[a-z]{2,10}"))
				{
					System.err.println("not a valid so Enter retype department name:");
				    department=reader.readLine();
				    
				}
				
				
				
				//-----------start inserting date of joining----------------
				
				System.out.println("Enter year of your joining (yyyy)");
				String year=reader.readLine();
				
				while(!year.matches("[0-9]{4}"))
				{
					System.err.println("not a valid so Enter retype year :");
					year=reader.readLine();
				}
				System.out.println("Enter month of your joining (mm)");
				String month=reader.readLine();
				 
				while(!month.matches("0[1-9]|1[0-2]"))
				{
					System.err.println("not a valid so Enter retype month:");
					month=reader.readLine();
				}
				System.out.println("Enter day of your joining (dd)");
				String day=reader.readLine();
				
				
				while(!day.matches("0[1-9]|[12][0-9]|3[01]"))
				{
					System.err.println("not a valid so Enter retype day:");
					day=reader.readLine();
				}
				String date_of_joining = year+"-"+month+"-"+day;
				//-----------end inserting date of joining----------------
				
				System.out.println("Enter department id:");
				String dept_id=reader.readLine();
				
				
					//inserting query
					String sqlQuery="insert into emp_info (first_name,last_name,age,city,status,department,date_of_joining,dept_id) values('"+firstname+"','"+lastname+"',"+age+",'"+city+"',"+status+",'"+department+"','"+date_of_joining+"','"+dept_id+"')";
					int result = statement.executeUpdate(sqlQuery);
				
				
				
				System.out.println("Record inserted successfully");
				System.out.println("Do you want to insert one more record[Yes/No]:");
				String option=reader.readLine();
				if(option.equalsIgnoreCase("No"))
				{
					break;	
				}	
			}
			connection.close();                //close the connection
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check sql syntax");
		}
		catch(IOException e)
		{
			System.err.println("invalid ! check input ");
		}catch(InputMismatchException ex)
		{
			System.err.println("invalid ! check input ");
		}
		
	}
	
	
	
	  // ----------------------update record--------------------------- 
	public static void updateRecord()                 
	{

		Connection connection;
		Statement statement;
		Scanner input;
		
		try
		{
			 connection = DBConnection.getConnection();      // connection created
			 statement=connection.createStatement();
			 input= new Scanner(System.in);
			System.out.println("Enter employee id which you want to update ");
			int id=input.nextInt();
			if(id<0)
			{
				System.out.println("invalid retype id");
				id=input.nextInt();
			}
			
			System.out.println("Enter column which you want to update : first_name,last_name,age,city,department,dept_id");
			String column=input.next();
			if(!column.equals("first_name")&&!column.equals("last_name")&&!column.equals("age")&&!column.equals("city")&&!column.equals("department")&&!column.equals("dept_id"))
			{
			
				System.out.println("invalid retype column name");
				column=input.next();
			}
			
			System.out.println("Enter data which you want to update ");
			String data=input.next();
			
			
				String sqlQuery="update emp_info set "+column+"='"+data+"'where id="+id+"";   // query to fetch update 
				int updateCount=statement.executeUpdate(sqlQuery);
				if(updateCount>0)
				{
					System.out.println("success ");
				}
				else
				{
					System.err.println("id not found ");
				}
			
			
			connection.close();
			
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check your sql synatx");
			
		}catch(InputMismatchException e)
		{
			System.err.println("invalid check youe input data");
			
		}
		
	}
	
	//--------------------delete record method---------------------
	
	public static void deleteRecord()       
	{


		Connection connection;
		Statement statement;
		Scanner input;
		try
		{
			 connection = DBConnection.getConnection();           // connection created
			 statement=connection.createStatement();
			 input= new Scanner(System.in);
				System.out.println("Enter id which you want to delete employee record");
				int id=input.nextInt();
				int updateCount = 0;
				if(id>0 ) 
				{
					
					String sqlQuery="update emp_info set status=0 where id="+id+"";					
				    updateCount=statement.executeUpdate(sqlQuery);
				    if(updateCount>0)
				    {
				    	System.out.println("deleted successfully");
				    	
				    }else
				    {
				    	System.err.println("id not found ");
				    }
				    
				}else
				{
					System.err.println("Enter valid positive integer this is not deleted ! ");
					
				}
				  
			      connection.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check your connection");
			
		}catch(InputMismatchException ex)
		{
	      System.err.println("check your input");
		}
		
	}
	
	//-----------------count total employee number in each department---------------------
	public static void countTotalEmployeInEachDepartment()
	{
		Connection connection;
		Statement statement;
		Scanner input;
		
		try
		{
			 connection = DBConnection.getConnection();      // connection created
			 statement=connection.createStatement();
			 input= new Scanner(System.in);
			 System.out.println("TOTALEMPLOYEE\tDEPSRTMENT");
			 String sqlQuery="select count(*) ,department from emp_info group by department ";
			 ResultSet rs= statement.executeQuery(sqlQuery);
			 System.out.println("-----------------------------");
			 while(rs.next())
			 {
				 System.out.println(rs.getInt(1)+ "\t\t " +rs.getString(2));
			 }
			connection.close();
			statement.close();
			
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check your sql synatx");
			
		}catch(InputMismatchException e)
		{
			System.err.println("check youe input data");
		}
		
		
		
	}
	
	//-------------------------fetching employee details start with first name  or any single character-----------------------
	
	public static void employeeDetalsStartWithFirstname()
	{
		Connection connection;
		Statement statement;
		Scanner input;
		
		try
		{
			 connection = DBConnection.getConnection();      // connection created
			 statement=connection.createStatement();
			 input= new Scanner(System.in);
			 System.out.println("enter firstname or any single character to get details of employee");
			
				String firstname=input.next();
				while(!firstname.matches("[A-Za-z]{1,10}"))
				{
				     System.out.println("not a valid name retype first name:");
					 firstname=input.next();
				}
			 String sqlQuery="select * from emp_info where first_name like '"+firstname+"%' ";
			 ResultSet rs= statement.executeQuery(sqlQuery);
			 System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
		     System.out.println("-----------------------------------------------------------------------------------------------------------");
			 while(rs.next())
			 {
				System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
			 }
			connection.close();
			statement.close();
			
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check your sql synatx");
			
		}catch(InputMismatchException e)
		{
			System.err.println("check youe input data");
		}
		
	}
	
	public static void fetchingEmployeefromDate()
	{
		Connection connection;
		Statement statement;
		Scanner  reader;
		
		try
		{
			 connection = DBConnection.getConnection();      // connection created
			 statement=connection.createStatement();
		     reader = new Scanner(System.in);
			 System.out.println("Enter date  to get details of employee");
			 System.out.println("Enter employee joining from date(yyyy-mm-dd)");
			 String startDate=reader.next();
			 while(!startDate.matches("^[0-9]{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12][0-9]|3[01])$"))
			 {
				 System.out.println("Invalid Retype date ");
				 startDate=reader.next();
			 }
			 System.out.println("Enter employee joining to date(yyyy-mm-dd)");
			 String endDate=reader.next();
			 while(!endDate.matches("^[0-9]{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12][0-9]|3[01])$"))
			 {
				 System.out.println("Invalid Retype date ");
				 endDate=reader.next();
			 }
			 String sqlQuery="select * from emp_info where date_of_joining between '"+startDate+"' and '"+endDate+"'";
			 ResultSet rs= statement.executeQuery(sqlQuery);
			 System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
			 System.out.println("-----------------------------------------------------------------------------------------------------------");
			 while(rs.next())
			 {
				System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
			 }
			connection.close();
			statement.close();
			
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("check your sql synatx");
			
		}catch(InputMismatchException e)
		{
			System.err.println("check youe input data");
		}
		
	}
	//===============================================================================
	//display employee details who has  added into family table
	
	public static void employeeDetailsAddedintofamilyTable()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select * from emp_info where id IN(select emp_id from family)";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	//==========================================================================================
	//display employee details who has not added into family table
	
	public static void employeeDetailsNotAddedintofamilyTable()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select * from emp_info where id NOT IN(select emp_id from family)";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.println("ID\tFIRSTNAME\tLASTNAME\tAGE\tCITY\tSTATUS\tDEPARTMENT\tDATE_OF_JOINING");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+ "\t " +rs.getString(2)+ "\t\t " +rs.getString(3)+ "\t\t" +rs.getInt(4)+ "\t" +rs.getString(5)+ "\t  " +rs.getInt(6)+ "\t  "+rs.getString(7)+ "\t\t"+rs.getDate(8));
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	//display total number of employee who has added into family table
	
	public static void totalemployeeWhoHasAddedIntofamilyDetails()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select count(*) as total_employee from emp_info where id  IN(select emp_id from family)";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.print("total no of employ who has  given their family detail : ");
			if(rs.next())
			{
				int total= rs.getInt("total_employee");
				 System.out.print(total);
				 System.out.println();
			}
			
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	//display total number of employee who has not added into family table
	
	public static void totalemployeeWhoHasNotAddedIntofamilyDetails()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select count(*) as total_employee from emp_info where id NOT IN(select emp_id from family)";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.print("total no of employ who has  given their family detail : ");
			if(rs.next())
			{
				int total= rs.getInt("total_employee");
				 System.out.print(total);
				
			}
			
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
		
	}
	
	//==============================================================================
	//insert family detail
	
	public static void insertFamilyDetail()
	{
		Connection connection;
		Statement statement;
		BufferedReader reader;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			 reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter employee id to store family table ");
			String id= reader.readLine();
			while(!id.matches("[0-9]"))
			{	
				System.out.println("invalid retype id");
				id= reader.readLine();
			}
			
			String QueryTocheckId="select count(id)as id from emp_info where id = "+id+"";
			ResultSet resultSet = statement.executeQuery(QueryTocheckId);
			int idcount=0;
			 while(resultSet.next())
			 {
				   idcount=resultSet.getInt("id");
			 }
			 
			 if(idcount==1)
			 {
				 String queryCheckFamilyId="select count(emp_id) as ID from family where emp_id = "+id;
				 resultSet=statement.executeQuery(queryCheckFamilyId);
				 int count=0;
				 while(resultSet.next())
				 {
					    count=resultSet.getInt("id");
				 }
				 if(count==1)
				 {
					 System.out.println("Already added family details for this employee"); 
				 }
				 else
				 {
					 
					 System.out.println("Enter father name");
					 String father_name= reader.readLine();
					 while(!father_name.matches("[a-zA-Z]{3,10}"))
					 {
						 System.err.println("invalid retype father name ");
						 father_name=reader.readLine();
					 }
					 
					 System.out.println("Enter mother name");
					 String mother_name= reader.readLine();
					 while(!mother_name.matches("[a-zA-Z]{3,10}"))
					 {
						 System.err.println("invalid retype mother name ");
						 mother_name=reader.readLine();
					 }
					 
					 String sqlQuery= "insert into family(father_name,mother_name,emp_id) values('"+father_name+"','"+mother_name+"',"+id+")";
					 int updatecount=statement.executeUpdate(sqlQuery);
					 if(updatecount>0)
					 {
						 System.out.println("record inserted sucessfully");
						
					 }
					
				 }
				 
			 }else
				 System.err.println("this id not exist  in employee table ");
			
			
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			System.err.println("please check your sql syntax !");
		}
		catch(IOException e)
		{
			System.err.println("check input");
		}
	}
	
	//===============================================================================
	//display family details 
	
	public static void displayFamilyDetails()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select emp_info.id,family.father_name,family.mother_name from emp_info,family where emp_info.id=family.emp_id ";     //  query for select 
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.println("ID\tFATHER NAME\tMOTHER NAME");
			System.out.println("------------------------------------");
			while(rs.next())
			{
			   System.out.println(rs.getInt("id")+"\t" +rs.getString("father_name")+"\t\t"+rs.getString("mother_name"));
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
		
		
	}
		
	//======================================================================
	// find department having minimum employee 
	
	public static void minimumEmployeeDepartment()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select DISTINCT dept_name from emp_info INNER JOIN department ON emp_info.dept_id=department.did IN"
					+ "(select dept_id from emp_info group by dept_id having count(*)IN"
					+ "(select min(dept_name) from (select count(*) as dept_name from emp_info group by dept_id)as mytable))";     
			ResultSet rs= statement.executeQuery(sql_query);
			System.out.println("Having minimum employee department name :");
			System.out.println();
			System.out.println("\tDEPARTMENT");
			System.out.println("\t============");
			while(rs.next())
			{
			   System.out.println("\t   "+rs.getString("dept_name"));
			   
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	public static void countEmployeeInEachDepartment()
	{
		Connection connection;
		Statement statement;
		try
		{
			connection=DBConnection.getConnection();     //connection created
			
			statement = connection.createStatement();     
			
			String sql_query="select count(*)as total,dept_name from emp_info INNER JOIN department ON emp_info.dept_id=department.did group by dept_name";     
			ResultSet rs= statement.executeQuery(sql_query);
			
			System.out.println();
			System.out.println("TOTAL\tDEPARTMENT");
			
			while(rs.next())
			{
			   System.out.println(rs.getInt("total")+"\t"+rs.getString("dept_name"));
			   
			}
			connection.close();
			statement.close();
		}catch(CommunicationsException ex)
		{
			System.err.println("connection failed problem");
			System.exit(0);
		}
		catch(SQLException ex)
		{
			
			System.err.println("please check your sql syntax !");
			
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
	
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			         System.out.println("==========JDBC PROJECT==========");
			         System.out.println("what you want to choose option :\n");
			            System.out.println(  "1.   To Display All Records\n"
					                       + "2.   To Get Even Record Display\n"
					                       + "3.   To Get Odd Record Display\n"
					                       + "4.   To Insert Record\n"
					                       + "5.   To Update Record\n"
					                       + "6.   To Delete Record\n"
					                       + "7.   To Count Total Employe In Each Department\n"
					                       + "8.   To Get Employee Details Search Start With Firstname or Single Character\n"
					                       + "9.   To Get Employee Details Between Given Joining Date to Date\n"
							               + "10.  To Get Employee Details Who Has Added into family Table\n"
							               + "11.  To Get Employee Details Who Has Not Added into family Table\n"
					                       + "12.  To Get Total Number of Employee Who Has Added Into family Details\n"
					                       + "13.  To Get Total Number of Employee Who Has Not Added Into family Details\n"
							               + "14.  To Insert Family Detail Of Employee\n"
							               + "15.  To Display Family Details\n"
							               + "16.  To Get Department name which have minimum employee\n"
							               + "17.  To Get Count Employee in Each Department");
			int choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
				displayRecord();
				break;
			case 2:
				evenDisplay();
				break;
			case 3:
				oddDisplay();
				break;
			case 4:
				insertRecord();
				break;
			case 5:
				updateRecord();
				break;
			case 6:
				deleteRecord();
				break;
			case 7:
				countTotalEmployeInEachDepartment();
				break;
			case 8:
				employeeDetalsStartWithFirstname();
				break;
			case 9:
				fetchingEmployeefromDate();
				break;
			case 10:
				employeeDetailsAddedintofamilyTable();
				break;
			case 11:
				employeeDetailsNotAddedintofamilyTable();
				break;
			case 12:
			    totalemployeeWhoHasAddedIntofamilyDetails();
				break;
			case 13:
				totalemployeeWhoHasNotAddedIntofamilyDetails();
				break;
			case 14:
				insertFamilyDetail();
				break;
			case 15:
				displayFamilyDetails();
				break;
			case 16:
				minimumEmployeeDepartment();
				break;
			case 17:
				countEmployeeInEachDepartment();
				break;
				
			default:
				System.out.println("invalid input!");	
				
			}
			System.out.println();
		}
		
		
	}
}
