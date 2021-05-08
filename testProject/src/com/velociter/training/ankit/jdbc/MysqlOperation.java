package com.velociter.training.ankit.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MysqlOperation {
	static Scanner sc=new Scanner(System.in);
	static Scanner new_sc=new Scanner(System.in);
	static void insert()
	{
		System.out.println("Enter Your Choice \n1.Insert Into Employee Table\n2.Insert Into Family Table");
		int choice=new_sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("First Name");
		String first_name=sc.nextLine();
	    first_name=first_name.replaceAll("[^a-zA-Z]","");
		System.out.println("Last Name");
		String last_name=sc.nextLine();
		last_name=last_name.replaceAll("[^a-zA-Z]","");  
		int age=0;
		try
		{
		System.out.println("Age");
		age=new_sc.nextInt();
		//person_age=person_age.replaceAll("[^0-9]","");
		
      if(age>0 &&age<101);
		else
		{
			System.out.println("Enter Valid Age");
			Operate();
		}
		}
		catch (Exception e) {
			e.getMessage();
		}
		System.out.println("City");
		String city=sc.nextLine();
		city=city.replaceAll("[^a-zA-Z]","");
        
		System.out.println("Department");
		String department=sc.nextLine();
		department=department.replaceAll("[^a-zA-Z]","");
        
		System.out.println("Date Of Joining ");
		System.out.println("Please Enter in 'dd-mm-yyyy' Formate ");
		System.out.println("Enter Day");
		int date=new_sc.nextInt();
		String date_s=""+date;
		if(date_s.length()==1)
		{
			date_s="0"+date_s;
		}
		System.out.println("Enter Month");
		int month=new_sc.nextInt();
		String month_s=""+month;
		if(month_s.length()==1)
		{
			month_s="0"+month_s;
		}
		System.out.println("Enter full Year");
		int year=new_sc.nextInt();
		String dateOfJoin=null;
		if((date>0 && date<32)&&(month>0 && month<13)&&(year>1990))
		{
		dateOfJoin=year+""+month_s+""+date_s;
		dateOfJoin=dateOfJoin.replaceAll("[^0-9/-]","");
		//System.out.println(dateOfJoin);
		String dateregex = "^\\d{4}\\d{2}\\d{2}$";
		Pattern r = Pattern.compile(dateregex);
	    Matcher m = r.matcher(dateOfJoin);
	    if(m.find())
	    {
	    }
	    else
	    {
	    	System.out.println("Invalid Date Formate");
	    	Operate();
	    }
	    String currentTime=""+java.time.LocalDate.now();
	    currentTime=currentTime.replaceAll("[^0-9/-]","");
	    if(currentTime.compareTo(dateOfJoin)>0);
	    else
	    {
	    	System.out.println("Date should be before Today");
	    Operate();
		}
		}
		else
		{
			System.out.println("Invalid Date");
			Operate();
		}
		
		try
		{
        	 Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
			Statement statement = connection.createStatement();
			String query = "insert into emp_information(first_name,last_name,age,city,dept_name,date_Of_Joining) values('"+first_name+"','"+last_name+"','"+age+"','"+city+"','"+department+"','"+dateOfJoin+"')";
			statement.executeUpdate(query);
//			'"+identity+"'
			connection.close();
			System.out.println(">>>>>>>>>>>Data Inserted<<<<<<<<<<");
			}
		catch(Exception e)
		{
		System.out.println(e);
		}
		break;
		
		case 2:
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Father Name");
			String father_name=sc.nextLine();
		    father_name=father_name.replaceAll("[^a-zA-Z]","");
			System.out.println("Mother Name");
			String mother_name=sc.nextLine();
			mother_name=mother_name.replaceAll("[^a-zA-Z]","");  
			int emp_id=0;
			try
			{
			System.out.println("Employee Id");
			emp_id=sc.nextInt();
			//person_age=person_age.replaceAll("[^0-9]","");
			
	      if(emp_id>0);
			else
			{
				System.out.println("Enter Valid Identity");
				
			}
			}
			catch (Exception e) {
				e.getMessage();
			}
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
			String checkEmpId="select Family_Id from family_Table where emp_id = "+emp_id;
			 ResultSet resultSet = statement.executeQuery(checkEmpId);
			  
			int newId=0;
			 while(resultSet.next())
		     {
				newId=resultSet.getInt("Family_Id");
			 }
             if(newId  != 0)
			 {
				System.err.println("Already family details added at "+newId+"\n");
				 checkEmpId=null;
				 resultSet=null;
				 insert();
			 }
             else
             {
			String query = "insert into Family_Table(Father_Name,Mother_Name,emp_id) values('"+father_name+"','"+mother_name+"','"+emp_id+"')";
				statement.executeUpdate(query);
//				'"+identity+"'
				connection.close();
				System.out.println(">>>>>>>>>>>Data Inserted into Family Table<<<<<<<<<<");
				}
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
			
		default:
		  {  
			System.out.println("InValid Choice");
	      }
		}
		
	}
	 
	static void update()
	{
		System.out.println("___________Update Operation__________");
		display();
		System.out.println("Enter Employee Identity ");
		int id=new_sc.nextInt();
		if(id>0);
		else {
			System.out.println("Please Enter Valid id");
			id=-1;
			update();
			Operate();
		}
		System.out.println("Enter Column name");
		String column=sc.nextLine();
		System.out.println("Enter Data");
		String columnData=sc.nextLine();
         try
		{
        	 Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
            Statement statement = connection.createStatement();
			 //String query = "update emp_information set+"+s2+"="+'"+s3+"'+"where id="+s1;
		
            String query ="update emp_information set "+column+"='"+columnData+"'where id="+id+"";
			statement.executeUpdate(query);
			System.out.println(">>>>>>>>>>>Data Updated<<<<<<<<<<");
			connection.close();
			}
		catch(SQLException e)
		{
		System.err.println("ID not Found");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	static void display()
	{
		int operationChoice= 1;
		do
		{
		
		System.out.println("Enter Your Choice \n 1.displayAll\n2.Total Employee in Each Department\n3.employee details whose name starts with given first name or any single character\n4'Display Family Table\n5.Details of employees, who has added family details into the family table.\n6. Display total no. of employees, who has not added family details into the family table\n7.Display total no. of employees, who has added family details into the family table.\n8."
				+ "Employee details,from current start date to end date\n9.Exit");
		int choice=new_sc.nextInt();
		
		switch(choice)
		{
		case 1:
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/student?useSSL = false";
			//String db_url = "jdbc:mysql://localhost:3306/student";
			
			String db_uname = "root";
			String db_upass = "root";
			Connection connection = DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement statement = connection.createStatement();
			String query = "select * from emp_information";
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet == null)
			{
			System.out.println("Record Not Found");
			}
			else
			{
				System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
				 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
					
				  while(resultSet.next())
					{
					    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
					    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						  
					
					}

			}
			connection.close();
		    }
		catch(Exception e)
		{
		e.printStackTrace();
		}
		break;
		
		case 2:
			try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url = "jdbc:mysql://localhost:3306/student?useSSL = false";
				//String db_url = "jdbc:mysql://localhost:3306/student";
				
				String db_uname = "root";
				String db_upass = "root";
				Connection connection = DriverManager.getConnection(db_url,db_uname,db_upass);
				Statement statement = connection.createStatement();
				String query = "select count(*) as Total_No_of_employee,Dept_Name from emp_information group by Dept_Name";
				//"select count(*) as Total_No_of_emplyoe ,department from emp_information group by department"
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next())
				  {
					  int Total_No_Of_emplyee=resultSet.getInt("Total_No_of_employee");
					   String department=resultSet.getString("Dept_Name");
					   
					   System.out.println("  "+Total_No_Of_emplyee+" Employye Working in "+department);
				  }
				connection.close();
			    }
			catch(Exception e)
			{
			e.printStackTrace();
			}
		    break;
		    
		case 3:
			try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url = "jdbc:mysql://localhost:3306/student?useSSL = false";
				//String db_url = "jdbc:mysql://localhost:3306/student";
				
				String db_uname = "root";
				String db_upass = "root";
				Connection connection = DriverManager.getConnection(db_url,db_uname,db_upass);
				Boolean present=false;
				String empName="";
				  while(present==false)
				  {
					  System.out.println("Enter name ");
					  empName=sc.nextLine();
					  present=Pattern.matches("[A-Za-z]{1,10}", empName);
					  if(present==false)
					  {
						  System.out.println("Enter valid character again");
					  }
				  }
				  present=false;
				  String query="select * from emp_information where First_Name like '"+empName+"%'";
				  Statement statement =connection.createStatement();
				  ResultSet resultSet=statement.executeQuery(query);
				  System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
				 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
					
				  while(resultSet.next())
					{
					    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
					    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						  
					
					}
				connection.close();
			    }
			catch(Exception e)
			{
			e.printStackTrace();
			}
           break;
           
		case 4:
			try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url = "jdbc:mysql://localhost:3306/student?useSSL = false";
				//String db_url = "jdbc:mysql://localhost:3306/student";
				
				String db_uname = "root";
				String db_upass = "root";
				Connection connection = DriverManager.getConnection(db_url,db_uname,db_upass);
				Statement statement = connection.createStatement();
				String query = "select * from family_Table";
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet == null)
				{
				System.out.println("Record Not Found");
				}
				else
				{
					System.out.println("      \tIdentity\tFather Name   \tMother Name\tEmp_ID");
					 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
					
					  while(resultSet.next())
						{
						    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"      \t"+resultSet.getString(3)+"     \t"+resultSet.getString(4));
						}
		        }
				connection.close();
			    }
			catch(Exception e)
			{
			e.printStackTrace();
			}
			break;
			
		case 5:
			try
			  {
				  Class.forName("com.mysql.cj.jdbc.Driver");
		 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
					Statement statement = connection.createStatement();
					String query="select * from emp_information where id IN (select emp_id from family_Table )";
					ResultSet resultSet=statement.executeQuery(query);
					System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
					 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
						
					  while(resultSet.next())
						{
						    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
							  
						
						}
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
			
		case 6:
			try
			  {
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
		
				  Statement statement =connection.createStatement();
				  
				  String query="select count(*) as total_employee from emp_information where id not In (select emp_id from family_Table)";
				  ResultSet resultSet =statement.executeQuery(query);
				  
				  System.out.print("Number of Employee who Not given their family detail are : ");
				  while(resultSet.next())
				  {
					  int total=resultSet.getInt("total_employee");
					  
					  System.out.print(total);
				  }
			 }
			 
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
			
		case 7:
			try
			  {
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
		
				  Statement statement =connection.createStatement();
				  
				  String query="select count(*) as total_employee from emp_information where id In (select emp_id from family_Table)";
				  ResultSet resultSet =statement.executeQuery(query);
				  
				  System.out.print("Number of Employee who  given their family detail are : ");
				  while(resultSet.next())
				  {
					  int total=resultSet.getInt("total_employee");
					  
					  System.out.print(total);
				  }
			 }
			 
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
			
		case 8:
			
			try
			  {
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
		
				  Statement statement =connection.createStatement();
				  System.out.println("Enter Start Date ");
					String startDate = sc.next();

					System.out.println("Enter End Date ");
					String endDate = sc.next();
					
			      String query = "select * from emp_information where Date_Of_Joining between " + " '" + startDate + "' AND ' " +endDate+"'";
				  ResultSet resultSet =statement.executeQuery(query);
				  if(resultSet!=null) {
				  System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
				
				  while(resultSet.next())
					{
					 
				        System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
					}
			 }
				  else
					{
					  System.out.println("NO Data Found..");
						
					}
			  }
			
			 
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
		
		case 9:
		{
			System.out.println("Exit From Display Operation");
			 operationChoice= 2;
			 
		}
		break;


	    	default:
			{
				
				System.out.println("InValid Choice");
			}
		}
		}
		while(operationChoice== 1);
	}
	static void delete()
	{
		System.out.println("Delete");
         System.out.println("Enter identity number");
		String s1 = sc.nextLine();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL = false","root","root");
			Statement statement = connection.createStatement();
			
			String query = "delete from emp_information where id='"+s1+"'";
			System.out.println(">>>>>>>>>>>Data Deleted<<<<<<<<<<");
			statement.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	static void Operate()
	{
		int operationChoice= 1;
		do
		{
		System.out.println("\nOPeration Do you Want to Perform\n"
				+ "1.Display\n2.Insert\n3.Update\n4.Delete\n5.Exit");
		int choice=new_sc.nextInt();
		switch(choice)
     {
		case 1:
			display();
			break;
		case 2:
			insert();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			operationChoice=2;
//			System.exit(0);
			break;
		default:
			System.out.println("Please Enter Valid Choice");
			break;
	}
		}
		while(operationChoice==1);
		
		System.out.println("Thank you");
	
	}
	public static void main(String[] args) {
	Operate();	
	}
}
