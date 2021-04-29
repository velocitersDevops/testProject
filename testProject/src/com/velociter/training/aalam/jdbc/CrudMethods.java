package com.velociter.training.aalam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class CrudMethods 
{
    Connection connectionObject  = 	DatabaseConnection.getDBConnection();
    Scanner scanObject = new Scanner(System.in);
    Statement statementObject =null;
    PreparedStatement preparedSatementObject =null;
    ResultSet resultSetObject=null;
    String query =null;
    String stringregex = "^[a-zA-Z]+$";                     //reguler expression to allow only character not number
	String numberregex = "[0-9]+";
	int moreInsert =1;
	public void display() 
	{
		  try {
			  System.out.println("select option to get Different Kinds of Employee Records");
			  System.out.println("\t'1' to get All Records \n\t'2' to get Records Between Range \n\t'3' to get Record Alphabaticaly\n");
		      query = "select * from employee";
		      statementObject=  connectionObject.createStatement();
		      resultSetObject =  statementObject.executeQuery(query);
		      if(resultSetObject !=null)
		      {
		    	  System.out.println("\t empId \t FirstName \t lastName \t Age \t City \t\t Status \tJoin_Date \t Department");
		    	  System.out.println("\t=====================================================================================================================");
		         	 //Retrieve by column name
		      	 while(resultSetObject.next())
				   {
		      		 int id  = resultSetObject.getInt("empId");
		      		 String firstname = resultSetObject.getString("first_Name");
		      		 String lastName = resultSetObject.getString("last_Name");
		      		 int age = resultSetObject.getInt("age");
		      		 String city = resultSetObject.getString("city");
		      	     int status = resultSetObject.getInt("status");
		      	     String joinDate =resultSetObject.getString("Date_Of_Join");
		      	     String department  = resultSetObject.getString("department");
		      		 //display the data
		      		 System.out.println("       "+"\t"+id+" \t "+firstname+" \t\t"+lastName+" \t\t"+age+"\t"+city+"\t\t"+status+"\t\t"+joinDate+"\t"+department);
		      		System.out.println("\t----------------------------------------------------------------------------------------------------------------------"); 
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
		
		while(moreInsert == 1)
		{
			System.out.println("Enter First Name");
			String firstName = scanObject.nextLine();
			if(firstName.matches(stringregex) == false)
			{
				System.err.println("can not use number in first name ! Try Again with valid name");
				insert();
			}
			System.out.println("Enter last Name");
			String lastName = scanObject.nextLine();
			if(lastName.matches(stringregex) == false)  //here performin lastname validation reexecute logic till not succeed
			{	
				 boolean lastNameStatus = true;
					while (lastNameStatus) {
						System.err.println("can not use number in last name ! Try Again with valid name");
						System.out.println("Again Enter Your lastName");
						lastName = scanObject.next();
						if (lastName.matches(stringregex) == true) {
							//System.out.println("lastName not include number " + lastName);
							lastNameStatus = false;
						} else {
							//System.out.println("lastName include number " + lastName);
						}
					}//while close here
			}//if close here
			
			
			System.out.println("Enter your Age ");
			String age = scanObject.next();
			if(age.matches(numberregex) == false)    //here performin age validation reexecute logic till not succeed
			{
			  
			    boolean ageStatus = true;
				while (ageStatus) {
					System.err.println("can not use characters in age ! Try Again with valid age");
					System.out.println("Again Enter Your age");
					age = scanObject.next();
					if (age.matches(numberregex) == true) {
						//System.out.println("age not include char " + age);
						ageStatus = false;
					} else {
						//System.out.println("age include char " + age);
					}

				}//while close here
			}//if close here
			
			int agee =Integer.parseInt(age);
		    if((agee <EmployeeInterface.MIN_AGE)  && (agee >EmployeeInterface.MAX_AGE) )
			{				
			  System.err.println(agee+" "+"is Over Age ! Try again with valid Age which will be between 18 to 85");

			    boolean ageStatus = true;
				while (ageStatus) {
					System.out.println("Again Enter Your age");
					age = scanObject.next();
					if (age.matches(numberregex) == true) {
						//System.out.println("age not include char " + age);
						ageStatus = false;
					} else {
						//System.out.println("age include char " + age);
					}

				}//while close here 
			}//if close here
		     agee =Integer.parseInt(age);
		     if((agee <EmployeeInterface.MIN_AGE)  || (agee >EmployeeInterface.MAX_AGE) )
				{
		    	 System.err.println(agee+" "+"is Over Age ! Try again with valid Age which will be between 18 to 85");
				}
			System.out.println("Enter City Name");
			String city = scanObject.next();
			if(city.matches(stringregex) == false)
			{
				
				 boolean cityStatus = true;
					while (cityStatus) {
						System.err.println("can not use number in city name ! Try Again with valid City name");
						System.out.println("Again Enter Your lastName");
						city = scanObject.next();
						if (city.matches(stringregex) == true) {
							//System.out.println("city not include number " + city);
							cityStatus = false;
						} else {
							//System.out.println("city include number " + city);
						}
					}//while close here

			}
			//validation Required
			System.out.println("Enter Your Joining Date");
			String joinDate = scanObject.next();
			
		/*	if(joinDate.matches(numberregex) == false)    //here performin age validation reexecute logic till not succeed
			{
			  
			    boolean ageStatus = true;
				while (ageStatus) {
					System.err.println("can not use characters in age ! Try Again with valid age");
					System.out.println("Again Enter Your age");
					age = scanObject.next();
					if (age.matches(numberregex) == true) {
						//System.out.println("age not include char " + age);
						ageStatus = false;
					} else {
						//System.out.println("age include char " + age);
					}

				}//while close here
			}//if close here
        */
			
			
			System.out.println("Enter Your Department");
			String department = scanObject.next();
			
			if(department.matches(stringregex) == false)  //here performin lastname validation reexecute logic till not succeed
			{	
				 boolean departmentStatus = true;
					while (departmentStatus) {
						System.err.println("can not use number in department name ! Try Again with department name");
						System.out.println("Again Enter Your department");
						department = scanObject.next();
						if (department.matches(stringregex) == true) {
							//System.out.println("lastName not include number " + lastName);
							departmentStatus = false;
						} else {
							//System.out.println("lastName include number " + lastName);
						}
					}//while close here
			}//if close here
			
			System.out.println("Enter employee status");
			String status = "0";
			query ="INSERT INTO employee (first_Name,last_Name,age,city,status,Date_Of_Join,department) "+ "VALUES(?,?,?,?,?,?,?)";
			
			try {
				preparedSatementObject=  connectionObject.prepareStatement(query);
				// set parameters for statement
				preparedSatementObject.setString(1, firstName);
				preparedSatementObject.setString(2, lastName);
				preparedSatementObject.setInt(3, agee);
				preparedSatementObject.setString(4, city);
				preparedSatementObject.setString(5, status);
				preparedSatementObject.setString(6, joinDate);
				preparedSatementObject.setString(7, department);
				
				int queryStatus = preparedSatementObject.executeUpdate();
				if(queryStatus  == 1)
				{
					System.out.println("Record inserted successfully ");
				}else
				{
					System.err.println("Record Not inserted ! ");
				}
				System.out.println("You Want to insert more Records press 1 insert or 2 no exit");
				moreInsert =scanObject.nextInt();
			}catch(CommunicationsException connectionFail)
			{
				System.err.println("Database Connection failed ! Please check Database Connection");
				//connectionFail.printStackTrace();
				
			}
			catch (SQLException e)
			{
				System.err.println("Have some Database issues !Please Check");
				//e.printStackTrace();
				
			}
			System.out.println("You Want to insert more Records press 1 insert or 2 no exit");
			moreInsert =scanObject.nextInt();
		}
	}
	
	public void update()
	{
		System.out.println("Enter Your Employee Id ");
	    String UpdateData=null;
	    String column = null;
	    int moreUpdate=1;
		String empId =null; 
		int empid=0;
		while(moreUpdate ==1) 
		{
			try {
				empId = scanObject.nextLine();
				if (empId.matches(numberregex) == false) {

					boolean empidStatus = true;
					while (empidStatus) {
						System.err.println("can not use characters in employee id ! Try Again with valid id");
						System.out.println("Again Enter Your employee Id");
						empId = scanObject.next();
						if (empId.matches(numberregex) == true) {
							// System.out.println("employee id not include char " + empId);
							empidStatus = false;
						} else {
							// System.out.println("employee id include char " + empId);
						}

					} // while close here
				}
				empid = Integer.parseInt(empId);
				if ((empid < 0)) {
					System.err.println("Employee id cant be negative ! try again with valid Employee id");
					update();
				}
			} catch (InputMismatchException e) {
				System.err.println("You should Entered Valid Employee Id");
				update();
			}

			System.out.println("Enter  In which column  you want to update : first_name,last_name,age,city");
			column = scanObject.next();
			
		  if((column.equalsIgnoreCase("First_Name")) || (column.equalsIgnoreCase("Last_Name")) || (column.equalsIgnoreCase("age")) || (column.equalsIgnoreCase("City")) == true)    
			{
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
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate =scanObject.nextInt();
				}catch(CommunicationsException connectionFail)                                            // if during execution disturb the database connection
				{
					System.err.println("Database Connection failed ! Please check Database Connection");
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate =scanObject.nextInt();
				}
				catch (SQLException e)                                                                    //if during database execution occure some issues like syntectical mistak in query 
                {
					System.err.println("Have some Syntactial  issues in Query  !Please Check You Query");
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate =scanObject.nextInt();
				}
                catch(InputMismatchException eee)                                                         // if input is not match according to data type
		        {
			        System.err.println("You Not Entered Valid input");
			        System.out.println("You Want to insert more Records press 1 update or 2 no update");
			        moreUpdate =scanObject.nextInt();
		        }	
			}
		  else
		  {
			  System.err.println("Column name not Valid ! Please check");
			 update();
		  }
	}//loop close
}
	//=============================================================update close====================================
	public void delete()
	{
		int moreDelete =1;
	  while(moreDelete ==1)
	  {
			System.out.println("enter 	Your employee	Id");
			String empId = scanObject.nextLine();
			//validation  
		    
		     if(empId.matches(numberregex) == false)
		     {
		    	
		    	 boolean empidStatus = true;
					while (empidStatus) {
						 System.err.println("can not use characters in employee id ! Try Again with valid id");
						System.out.println("Again Enter Your employee Id");
						empId = scanObject.next();
						if (empId.matches(numberregex) == true) {
							//System.out.println("employee id not include char " + empId);
							empidStatus = false;
						} else {
							//System.out.println("employee id include char " + empId);
						}

					}//while close here
		     }
		     int empid = Integer.parseInt(empId);
			if((empid >0) )
			{
				try {
				//1 indicate deleted records
				query="update employee set status ='"+ 1 +"'where empId="+empid+"";
				

				 statementObject=  connectionObject.createStatement();
				int queryStatus = statementObject.executeUpdate(query);
				//System.out.print(queryStatus+" ");
				if(queryStatus  == 1)
				{
					System.out.println("Record deleted successfully ");
				}else
				{
					System.err.println("Record Not  Exist ! ");                                                            // if result set null then execute this else block
				}
				System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
				moreDelete =scanObject.nextInt();
				if(moreDelete <0  && moreDelete >2)
				{
					System.err.println("You Not enter valid Option ! Try Again With valid Option ");
					System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
					moreDelete =scanObject.nextInt();
				}
			}catch(CommunicationsException connectionFail)                                                                // if during execution disturb the database connection
			{
				System.err.println("Database Connection failed ! Please check Database Connection");
				System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
				moreDelete =scanObject.nextInt();
			} 
			catch (SQLException e) {                                                                                      //if during database execution occure some issues like syntectical mistak in query 
				System.err.println("Have some Database issues !Please Check");
				System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
				moreDelete =scanObject.nextInt();
			
			}

			}else
			{
				System.err.println("You Entered Employee id Is Negative ! entere Correct Employee id");
				System.out.println("Try again ! \n entere Correct Employee id to delete Records press 1 Delete or 2 no Delete");
				moreDelete =scanObject.nextInt();
			}
	  }//while loop close here
			
	}
	//================================================Delete Record end================================================
       public void evenRecords()
       {
    	 
    	   try {
 		      query = "select * from employee where empId  % 2 ="+0;
 		      statementObject=  connectionObject.createStatement();
 		      resultSetObject =  statementObject.executeQuery(query);
 		      if(resultSetObject !=null)
 		      {
 		    	  System.out.println("\t\t\t\t |Even Records | ");
 		    	  System.out.println("\t\t\t\t |=============| \n");
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
 		      	System.err.println("Records Not Avaialable ");                                          // if result set null then execute this else block
 		      }
 		 }catch(CommunicationsException connectionFail)
 			{
 				System.err.println("Database Connection failed ! Please check Database Connection");    // if during execution disturb the database connection
 				//connectionFail.printStackTrace();
 				System.exit(0);
 			}
 	     catch(SQLException e)
 		  {
 			System.err.println("Have some Database issues ! Try Again");                                //if during database execution occure some issues like syntectical mistak in query 
 			//e.printStackTrace();
 			System.exit(0);
 		   }  
    	   
       }
       //==========================================================even Record End============================================
       
       public void oddRecords()
       {
    	   try {
  		      query = "select * from employee where empId  % 2 !="+0;
  		      statementObject=  connectionObject.createStatement();
  		      resultSetObject =  statementObject.executeQuery(query);
  		      if(resultSetObject !=null)
  		      {
  		    	  System.out.println("\t\t\t\t | Odd Records | ");
 		    	  System.out.println("\t\t\t\t |=============| \n");
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
  		      	System.err.println("Records Not Avaialable ");                                          // if result set null then execute this else block
  		      }
  		 }catch(CommunicationsException connectionFail)
  			{
  				System.err.println("Database Connection failed ! Please check Database Connection");    // if during execution disturb the database connection
  				//connectionFail.printStackTrace();
  				System.exit(0);
  			}
  	     catch(SQLException e)
  		  {
  			System.err.println("Have some Database issues ! Try Again");                                //if during database execution occure some issues like syntectical mistak in query 
  			//e.printStackTrace();
  			System.exit(0);
  		   }  

    	   
       }
}
