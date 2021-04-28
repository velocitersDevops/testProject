package com.velociter.training.aalam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class Crud_Methods 
{
    Connection connectionObject  = 	Database_Connection.getDBConnection();
    Scanner scanObject = new Scanner(System.in);
    Statement statementObject =null;
    PreparedStatement preparedSatementObject =null;
    ResultSet resultSetObject=null;
    String query =null;
	public void display() 
	{
		  try {
		      query = "select * from employee";
		      statementObject=  connectionObject.createStatement();
		      resultSetObject =  statementObject.executeQuery(query);
		      if(resultSetObject !=null)
		      {
		    	  System.out.println("\t empId \t FirstName \t lastName \t Age \t City \t\t Status");
		    	  System.out.println("\t=============================================================================");
		         	 //Retrieve by column name
		      	 while(resultSetObject.next())
				   {
		      		 int id  = resultSetObject.getInt("empId");
		      		 String firstname = resultSetObject.getString("first_Name");
		      		 String lastName = resultSetObject.getString("last_Name");
		      		 int age = resultSetObject.getInt("age");
		      		 String city = resultSetObject.getString("city");
		      	     int status = resultSetObject.getInt("status");
		      		 //display the data
		      		 System.out.println("       "+"\t"+id+" \t "+firstname+" \t\t"+lastName+" \t\t"+age+"\t"+city+"\t\t"+status);
		      		System.out.println("\t-----------------------------------------------------------------------------"); 
				   }
		      }else
		      {
		      	System.err.println("Records Not Avaialable ");
		      }
		 }catch(CommunicationsException connectionFail)
			{
				System.err.println("Database Connection failed ! Please check Database Connection");
				//connectionFail.printStackTrace();
				System.exit(0);
			}
	     catch(SQLException e)
		  {
			System.err.println("Have some Database issues ! Try Again");
			System.exit(0);
		   }  
	}// display() close here
	
	public void insert()
	{
		int moreInsert =1;
		while(moreInsert == 1)
		{
			System.out.println("Enter First Name");
			String firstName = scanObject.nextLine();
			
			System.out.println("Enter last Name");
			String lastName = scanObject.nextLine();
			System.out.println("Enter Age ");
			int age = scanObject.nextInt();
			if(age <0)
			{
				System.err.println("Invalid Age ! Try again with valid Age");
				System.exit(0);
			}
			System.out.println("Enter City Name");
			String city = scanObject.next();
			
			System.out.println("Enter employee status");
			String status = "0";
			query ="INSERT INTO employee (first_Name,last_Name,age,city,status) "+ "VALUES(?,?,?,?,?)";
			
			try {
				preparedSatementObject=  connectionObject.prepareStatement(query);
				// set parameters for statement
				preparedSatementObject.setString(1, firstName);
				preparedSatementObject.setString(2, lastName);
				preparedSatementObject.setInt(3, age);
				preparedSatementObject.setString(4, city);
				preparedSatementObject.setString(5, status);
				
				int queryStatus = preparedSatementObject.executeUpdate();
				if(queryStatus  == 1)
				{
					System.out.println("Record inserted successfully ");
				}else
				{
					System.err.println("Record Not inserted ! ");
				}
				System.out.println("You Want to insert more Records press 1 insert or 2 no insert");
				moreInsert =scanObject.nextInt();
			}catch(CommunicationsException connectionFail)
			{
				System.err.println("Database Connection failed ! Please check Database Connection");
				//connectionFail.printStackTrace();
				System.exit(0);
			}
			catch (SQLException e)
			{
				System.err.println("Have some Database issues !Please Check");
				//e.printStackTrace();
				System.exit(0);
			}
		}
	}
	
	public void update()
	{
	    String UpdateData=null;
	    int ageData = 0;
	    String column = null;
		
		int empid =0; 
		try{
			System.out.println("Enter Your Employee Id ");
			empid = scanObject.nextInt();
			if(empid <0 )
			{
				System.err.println("You not entered Valid Employee id ! try again with valid Employee id");
				System.exit(0);
			}
			System.out.println("Enter  In which column  you want to update : first_name,last_name,age,city");
			column = scanObject.next();
			
		/*  if(!(column.equalsIgnoreCase("First_Name") == true))    
			{
				System.err.println("Column name not Valid ! Please check");
				System.exit(0);
			}
			if(!(column.equalsIgnoreCase("Last_Name") )) 
			{
				System.err.println("Column name not Valid ! Please check");
				System.exit(0);
			}
			if(!(column.equalsIgnoreCase("age") )) 
			{
				System.err.println("Column name not Valid ! Please check");
				System.exit(0);
			}
			if(!(column.equalsIgnoreCase("City") )) 
			{
				System.err.println("Column name not Valid ! Please check");
				System.exit(0);
			}
		*/
			System.out.println("Enter what You want to update  ");
		    UpdateData  = scanObject.next();	
			
			
				try {
					
					query="update employee set "+column+"='"+UpdateData+"'where empId="+empid+"";

					statementObject=  connectionObject.createStatement();
					int queryStatus = statementObject.executeUpdate(query);
					//System.out.print(queryStatus+" ");
					if(queryStatus  == 1)
					{
						System.out.println("Record update successfully ");
					}else
					{
						System.err.println("Record Not  update ! ");
					}
				}catch(CommunicationsException connectionFail)
				{
					System.err.println("Database Connection failed ! Please check Database Connection");
					//connectionFail.printStackTrace();
					System.exit(0);
				}
				catch (SQLException e) {
					System.err.println("Have some Syntactial  issues in Query  !Please Check You Query");
					//e.printStackTrace();
					System.exit(0);
				}

		}catch(InputMismatchException eee)
		{
			System.err.println("You Not Entered Valid input");
			System.exit(0);
		}	
	}
	//=============================================================update close====================================
	public void delete()
	{
		int moreDelete =1;
	  while(moreDelete ==1)
	  {
			System.out.println("enter 	Your employee	Id");
			int empid = scanObject.nextInt();
			//validation
			if(empid >0)
			{
				try {
				//query = "delete  from employee where empId="+empid;
				query="update employee set status ='"+ 1 +"'where empId="+empid+"";
				//query="update employee set status='"+UpdateData+"'where empId="+empid+"";

				 statementObject=  connectionObject.createStatement();
				int queryStatus = statementObject.executeUpdate(query);
				//System.out.print(queryStatus+" ");
				if(queryStatus  == 1)
				{
					System.out.println("Record deleted successfully ");
				}else
				{
					System.err.println("Record Not  Exist ! ");
				}
				System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
				moreDelete =scanObject.nextInt();
			}catch(CommunicationsException connectionFail)
			{
				System.err.println("Database Connection failed ! Please check Database Connection");
				//connectionFail.printStackTrace();
				System.exit(0);
			} 
			catch (SQLException e) {
				//System.err.println("Have some Database issues !Please Check");
				e.printStackTrace();
				System.exit(0);
			}

			}else
			{
				System.err.println("You Entered Employee id Is Negative ! entere Correct Employee id");
				System.out.println("Try again ! \nentere Correct Employee id to delete Records press 1 Delete or 2 no Delete");
				moreDelete =scanObject.nextInt();
			}
	  }//while loop close here
			
	}

}
