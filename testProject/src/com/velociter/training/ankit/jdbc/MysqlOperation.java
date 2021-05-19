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
		int operationChoice= 1;
        do
		{
		System.out.println("\nEnter Your Choice \n1.Insert Into Employee Table\n2.Insert Into Family Table\n3.Exit");
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
		String dept_id="";
		
		if(department.contains("Account"))
		{
			dept_id=""+1;
		}
		else if(department.contains("Hacking"))
		{
			dept_id=""+2;
		}
		else if(department.contains("Develop"))
		{
			dept_id=""+3;
		}
		else if(department.contains("Pharma"))
		{
			dept_id=""+4;
		}
		else if(department.contains("Testing"))
		{
			dept_id=""+5;
		}
		else if(department.contains("CSE"))
		{
			dept_id=""+6;
		}
		
		
        
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
			String query = "insert into emp_information(first_name,last_name,age,city,dept_name,date_Of_Joining,dept_id) values('"+first_name+"','"+last_name+"','"+age+"','"+city+"','"+department+"','"+dateOfJoin+"','"+dept_id+"')";
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
			String checkId="select Family_Id from family_Table where emp_id = "+emp_id;
			 ResultSet resultSet = statement.executeQuery(checkId);
			  
			int newId=0;
			 while(resultSet.next())
		     {
				newId=resultSet.getInt("Family_Id");
			 }
             if(newId  != 0)
			 {
				System.err.println("Family details already  added at "+newId+"\n");
				 checkId=null;
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
			
		case 3:
			System.out.println("Exit From Insert Operation");
		
			operationChoice= 2;
			break;
		default:
		  {  
			System.out.println("InValid Choice");
	      }
		}
		}
		while(operationChoice== 1);
		
		
	}
	 
	static void update()
	{
		System.out.println("___________Update Operation__________");
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
		
		System.out.println("\nEnter Your Choice \n1.DisplayAll\n2.Total Employee in Each Department\n3.Employee details whose name starts with given first name or any single character\n4.Display Family Table\n5.Details of employees, who has added family details into the family table.\n6.Display total no. of employees, who has not added family details into the family table\n7.Display total no. of employees, who has added family details into the family table.\n8."
				+"Employee details,from current start date to end date\n9.Display department name, where the highest number of employees working in that department"
				+ "\n10.Display department name, where the lowest number of employees working in that department"
				+ "\n11.Name.of employees, who are working in the  department in the location"
				+ "\n12.Name of employees,who have joined current month and find name after give input options where users can give month,year and location"
				+ "\n13.list of the employees, who has experience  and  location.(user to enter location)"
				+ "\n15.Display employee details where the 2nd highest no.of employees hired in the pune location.(user to enter location)."
				+ "\n16.To get 3 maximum department names, where the highest strength of the  employees is in X location."
				+ "\n17.Exit");
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
				  
                  int check=0;   
                  System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
				 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
			
				  while(resultSet.next())
					{
					    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
					    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						  check++;
					
					}
				  if(check==0)
				  {
					  System.out.println("No Data Present");
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
				int check=0;
				System.out.println("      \tIdentity\tFather Name   \tMother Name\tEmp_ID");
				 // System.out.println("\tid "+"\tfname "+"\t\tlname "+"\t\tage"+"\t\tcity"+"\t\tdepartment"+"\t\tdate_of_joining");
				 while(resultSet.next())
						{
						    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"      \t"+resultSet.getString(3)+"     \t"+resultSet.getString(4));
						    check++;
						}
		        if(check==0)
		        {
		        	System.err.println("No Data Present...");
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
						int check=0;
					  while(resultSet.next())
						{
						    //System.out.println("\t\t"+resultSet.getString(1)+"  "+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
						    System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
							  check++;
						
						}
					  if(check==0)
					  {
						  System.err.println("No Data Present...");
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
					  
					  System.out.print(total+"\n");
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
					  
					  System.out.print(total+"\n");
					  
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
		
				    Statement statement=connection.createStatement();
				    System.out.println("Enter Start Date ");
					String startDate = sc.next();

					System.out.println("Enter End Date ");
					String endDate = sc.next();
					
					String dateregex = "^\\d{4}\\d{2}\\d{2}$";
					Pattern r = Pattern.compile(dateregex);
				    Matcher m = r.matcher(startDate);
				    Matcher m1 = r.matcher(endDate);
				    if(m.find())
				    {
				    }
				    else if(m1.find())
				    {
				    }
				    else
				    {
				    	System.out.println("Invalid Date Formate");
				    	display();
				    }
				   String query = "select * from emp_information where Date_Of_Joining between " + " '" +startDate+ "' AND ' " +endDate+"'";
				   ResultSet resultSet =statement.executeQuery(query);
				   int check=0;
				   System.out.println("       \tIdentity\tFirst Name\tLast Name\tAge\tCity     \tDepartment\tDate Of Joining");
				  while(resultSet.next())
					{
					 
				        System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7));
				        check++;
					}
				  if(check==0)
				  {
					  System.err.println("No Data Present...");
				  }
			 }
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
		
		case 9:
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				//String checkEmpId="select  Dept_Name from emp_information join Department on emp_information.dept_id=Department.dept_id group by Department_Name order by count(*) desc limit 1;"

				String checkEmpId="SELECT *FROM Department WHERE dept_id IN(SELECT dept_id FROM emp_information GROUP BY dept_id HAVING count(*) IN (SELECT Max(Dept_Name) FROM (SELECT COUNT(*) as  Dept_Name FROM emp_information GROUP BY dept_id) alias));";
			 ResultSet resultSet = statement.executeQuery(checkEmpId);
				System.out.println("Highest Employee on Department");
				
			
			 while(resultSet.next())
		     {
				//newId=resultSet.getString("Dept_Name");
				System.out.println(resultSet.getString(2));
			 }
	         
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			System.out.println();
			break;
			
		case 10:
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				//String checkEmpId="select  Dept_Name from emp_information join Department on emp_information.dept_id=Department.dept_id group by Department_Name order by count(*) asc it 1;"

				String checkEmpId="SELECT *FROM Department WHERE dept_id IN(SELECT dept_id FROM emp_information GROUP BY dept_id HAVING count(*) IN (SELECT Min(Dept_Name) FROM (SELECT COUNT(*) as  Dept_Name FROM emp_information GROUP BY dept_id) alias));";
			 ResultSet resultSet = statement.executeQuery(checkEmpId);
				System.out.println("Lowest Employee on Department");
			
			 while(resultSet.next())
		     {
				//newId=resultSet.getString("Dept_Name");
				System.out.println(resultSet.getString(2));
			 }
	         
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			System.out.println();
			break;
		case 11:
			System.out.println("City Name");
			String city_name=sc.nextLine();
		    city_name=city_name.replaceAll("[^a-zA-Z]","");
			System.out.println("Department Name");
			String dept_name=sc.nextLine();
			dept_name=dept_name.replaceAll("[^a-zA-Z]","");  
			
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				String checkEmpId="SELECT id,First_name FROM emp_information e JOIN city c ON  c.city_name='"+city_name+"' And e.dept_name='"+dept_name+"';";	
				//String checkEmpId="SELECT id,First_name, city_name,dept_name FROM emp_information e JOIN city c ON  c.city_name='"+city_name+"' AND e.dept_name='"+dept_name+"';";
			   ResultSet resultSet = statement.executeQuery(checkEmpId);
			  if(resultSet.equals(null))
			   {}
			   else
			   {boolean b=false;
			 while(b=resultSet.next())
		     {  
				 if(resultSet.getString(1)==null)
				 {
					 
				 }
				 else
				 {
				
				System.out.println(resultSet.getString(1)+"   "+resultSet.getString(2));
			 }

		     }
			   }
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
		break;
		
		case 12:
			Scanner sc=new Scanner(System.in);
			String month="",year="",city="";
			int x=1;
			do
			{
			System.out.println("Month");
			 month=sc.nextLine();
			month=month.replaceAll("[^0-9]","");
			System.out.println("Year");
			year=sc.nextLine();
			year=year.replaceAll("[^0-9]","");  
			
			System.out.println("City");
			city=sc.nextLine();
			city=city.replaceAll("[^a-zA-Z]","");  
		 }
			while(month.equals("")&&year.equals("")&&city.equals(""));
			
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				//String query="select date(date_of_joining),count(*) from emp_information where MONTH(date_of_joining)=MONTH(now()) and YEAR(date_of_joining)=YEAR(now()) group by date(date_of_joining);";	
				//String query="select First_Name ,Last_Name from emp_information where MONTH(date_of_joining)=MONTH(now()) and YEAR(date_of_joining)=YEAR(now()) group by date(date_of_joining);";
				String query="select First_Name,Last_Name from emp_information where MONTH(date_of_joining)='"+month+"' and YEAR(date_of_joining)='"+year+"' and city ='"+city+"' group by date(date_of_joining);";

				ResultSet resultSet = statement.executeQuery(query);
				int i=0;
	             System.out.println("Name of the Employee :");
			 while(resultSet.next())
		     {
				i++;
				System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)); // Date and Count
				//System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)); // Name and Surname 
			 }

			 if(i==0)
			 {
				 System.out.println("NO DATA Present");
			 }
			   
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
	        break;
	        
		case 13:
			
			String experience="",cityName="",city_id="";
			Scanner scan=new Scanner(System.in);
			do
			{
			System.out.println("Experience");
			experience=scan.nextLine();
			experience=experience.replaceAll("[^0-9]","");
			System.out.println("City");
			cityName=scan.nextLine();
			cityName=cityName.replaceAll("[^a-zA-Z]","");  
		 }
			while(experience.equals("")&&cityName.equals(""));
			 if(cityName.equals("Pune")||cityName.equals("pune"))
			 {
				 city_id=""+2;
			 }
			 
			 else if(cityName.equals("Noida")||cityName.equals("noida"))
			 {
				 city_id=""+3;
			 }
			 
			 else if(cityName.equals("Indore")||cityName.equals("indore"))
			 {
				 city_id=""+1;
			 }
			
			 
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				
				//String query="select * from emp_information e,city c where c.city_name='"+city+"' and (year(curdate())-year(date_of_Joining))>="+experience;;
	             
				String query="select id,FIRST_NAME,Last_name,Date_of_Joining from emp_information e join city c on (c.city_id='"+city_id+"' and E.city_id='"+city_id+"') where (year(curdate())-year(date_of_Joining))>="+experience;;
				ResultSet resultSet = statement.executeQuery(query);
				int i=0;
	             System.out.println("id\tFirst Name\tLast Name\tDate_of Joining");
			 while(resultSet.next())
		     {
				i++;
				System.out.println(resultSet.getString(1)+"  \t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)); // Date and Count
				//System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)); // Name and Surname 
			 }

			 if(i==0)
			 {
				 System.out.println("NO DATA Present");
			 }
			   
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			break;
	        
		case 14:
			
			String dept="",cityN="",city_Id="",dateOfCom="";
			Scanner scanner=new Scanner(System.in);
			do
			{
			System.out.println("Department");
			dept=scanner.nextLine();
			dept=dept.replaceAll("[^a-zA-Z]","");
			System.out.println("City");
			cityN=scanner.nextLine();
			cityN=cityN.replaceAll("[^a-zA-Z]","");  
			
			
			System.out.println("Enter Day");
			int date=scanner.nextInt();
			String date_s=""+date;
			if(date_s.length()==1)
			{
				date_s="0"+date_s;
			}
			System.out.println("Enter Month");
			int monthEntry=scanner.nextInt();
			String month_s=""+monthEntry;
			if(month_s.length()==1)
			{
				month_s="0"+month_s;
			}
			System.out.println("Enter full Year");
			int yearEntry=scanner.nextInt();
			
			if((date>0 && date<32)&&(monthEntry>0 && monthEntry<13)&&(yearEntry>1990))
			{
				dateOfCom=yearEntry+""+month_s+""+date_s;
				dateOfCom=dateOfCom.replaceAll("[^0-9/-]","");
			//System.out.println(dateOfJoin);
			String dateregex = "^\\d{4}\\d{2}\\d{2}$";
			Pattern r = Pattern.compile(dateregex);
		    Matcher m = r.matcher(dateOfCom);
		    if(m.find())
		    {
		    }
		    else
		    {
		    	System.out.println("Invalid Date Formate");
		    	
		    }
			
		 }
			}
			while(dept.equals("")&&cityN.equals(""));
			 if(cityN.equals("Pune")||cityN.equals("pune"))
			 {
				 city_Id=""+2;
			 }
			 
			 else if(cityN.equals("Noida")||cityN.equals("noida"))
			 {
				 city_Id=""+3;
			 }
			 
			 else if(cityN.equals("Indore")||cityN.equals("indore"))
			 {
				 city_Id=""+1;
			 }
			
			 
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				
				//String query="select * from emp_information e,city c where c.city_name='"+city+"' and (year(curdate())-year(date_of_Joining))>="+experience;;
	             

				 String query="select id,FIRST_NAME,Last_name,Date_of_Joining from emp_information e join city c on (c.city_id='"+city_Id+"' and E.city_id='"+city_Id+"') where date_of_joining<'"+dateOfCom+"' and e.dept_name='"+dept+"';";
				ResultSet resultSet = statement.executeQuery(query);
				int i=0;
	             System.out.println("id\tFirst Name\tLast Name\tDate_of Joining");
			 while(resultSet.next())
		     {
				i++;
				System.out.println(resultSet.getString(1)+"  \t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)); // Date and Count
				//System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)); // Name and Surname 
			 }

			 if(i==0)
			 {
				 System.out.println("NO DATA Present");
			 }
			   
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			scanner.close();			
			break;
		
		case 15:
			Scanner scanner1=new Scanner(System.in);
			String city_n="",city_i="",position_s="";
			System.out.println("City");
			city_n=scanner1.nextLine();
			city_n=city_n.replaceAll("[^a-zA-Z]","");  
	 		
	 		if(city_n.equals("Pune")||city_n.equals("pune"))
			 {
				 city_id=""+2;
			 }
			 
			 else if(city_n.equals("Noida")||city_n.equals("noida"))
			 {
				 city_id=""+3;
			 }
			 
			 else if(city_n.equals("Indore")||city_n.equals("indore"))
			 {
				 city_id=""+1;
			 }
			
			 
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
				Statement statement = connection.createStatement();
				
				//String query="select * from emp_information e,city c where c.city_name='"+city+"' and (year(curdate())-year(date_of_Joining))>="+experience;;
	            
	             //String query="SELECT id,First_Name,Last_Name,dept_name ,MAX(dept_name)  FROM emp_information WHERE dept_name < (SELECT MAX(dept_name) FROM emp_information where city_id='"+city_id+"') and city_id='"+city_id+"';";
	             //String query="SELECT MAX(dept_name)  FROM emp_information WHERE dept_name not in (SELECT MAX(dept_name) FROM emp_information where city_id='"+city_id+"') and city_id='"+city_id+"';";
	            //String query="select max(dept_name) from emp_information e1 where '"+position_s+"'-1=(select count(Distinct dept_name)from emp_information e2 where (e2.dept_name>e1.dept_name) and city_id='"+city_id+"') and city_id='"+city_id+"';";
	            String query="select max(dept_name) from emp_information e1 where 1-1=(select count(Distinct dept_name)from emp_information e2 where (e2.dept_name>e1.dept_name) and city_id='"+city_i+"') and city_id='"+city_i+"';";
	              
	             //String query="select id,FIRST_NAME,Last_name,Date_of_Joining from emp_information e join city c on (c.city_id='"+city_id+"' and E.city_id='"+city_id+"') where date_of_joining<'"+dateOfCom+"' and e.dept_name='"+dept+"';";
				ResultSet resultSet = statement.executeQuery(query);
				int i=0;
				//System.out.println("       \tIdentity\tFirst Name\tLast Name\tDepartment");
				//System.out.println("2nd highest no.of employees hired in the "+city+" location :");
				 while(resultSet.next())
					{
					 System.out.println("2nd highest no.of employees hired in "+resultSet.getString(1)+" department in the "+city_n+" location.");
					    //System.out.println(resultSet.getString(1));
				        //System.out.println("\t\t"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"     \t"+resultSet.getString(4));
				        i++;
					}

			 if(i==0)
			 {
				 System.out.println("NO DATA Present");
			 }
			   
				connection.close();

			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			break;
			
		case 16:
			
			String city="",city_id="";
		    System.out.println(" Enter City Name.....");
			city=sc.nextLine();
			city=city.replaceAll("[^a-zA-Z]","");  
			
			if(city.equals("Pune")||city.equals("pune"))
		 {
			 city_id=""+2;
		 }
		 
		 else if(city.equals("Noida")||city.equals("noida"))
		 {
			 city_id=""+3;
		 }
		 
		 else if(city.equals("Indore")||city.equals("indore"))
		 {
			 city_id=""+1;
		 }

		 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSl=false","root","root");
			Statement statement = connection.createStatement();
			
			//String query="select max(dept_name) from emp_information e1 where 1-1=(select count(Distinct dept_name)from emp_information e2 where (e2.dept_name>e1.dept_name) and city_id='"+city_id+"') and city_id='"+city_id+"';";
		    String query="SELECT Dept_Name, city_name AS 'City',COUNT(*) AS 'No of Employees'  FROM city INNER JOIN emp_information ON emp_information.city_id =city.city_id where emp_information.city_id='"+city_id+"'GROUP BY emp_information.dept_id,Dept_Name ORDER BY 3 desc limit 3;";
			ResultSet resultSet = statement.executeQuery(query);
			int i=0;
			System.out.println("\tDepartment\tCity Name\tNo Of Employee");
			//System.out.println("2nd highest no.of employees hired in the "+city+" location :");
			 while(resultSet.next())
				{
				    //System.out.println(resultSet.getString(1));
			        System.out.println("\t"+resultSet.getString(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
			        i++;
				}

		 if(i==0)
		 {
			 System.out.println("NO DATA Present");
		 }
		   
			connection.close();

		}
		catch(Exception e)
		{
		System.out.println(e);
		}
					
			
			break;
		case 17:
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
