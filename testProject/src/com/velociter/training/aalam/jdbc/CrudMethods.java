package com.velociter.training.aalam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class CrudMethods {
	Connection connectionObject = DatabaseConnection.getDBConnection();
	Scanner scanObject = new Scanner(System.in);
	Statement statementObject = null;
	PreparedStatement preparedSatementObject = null;
	ResultSet resultSetObject = null;
	String query = null;
	String stringregex = "^[a-zA-Z]+$"; // reguler expression to allow only character not number
	String numberregex = "[0-9]+";
	String dateRegEx = "^\\d{4}-\\d{2}-\\d{2}$";
	
	int moreInsert = 1;
	Validation validationObject = new Validation(); // creating validatiob class objrct to access validation methdods

	public void display() {
		try {
			statementObject = connectionObject.createStatement();
			System.out.println("\tselect option to get Different Kinds of Employee Records");
			System.out.println(
					"\t'1' to get All Records \n\t'2' to get Records Between Range \n\t'3' to get Record Alphabaticaly \n\t'4' to get no_Of_Employee in each department"
							+ "\n\t'5' to get Employee details,if we enter current start date to end date. \n \t'6' Display added family \n\t'7' Display not added family \n"
							+ "\t'8' to Display Employe record who added family Details.\n\t'9' to check Employe already added family details or not.    \n\t'10' to display employee details whose age between range "
							+ "\n\t'11' to display expirence employee details.\n\t'12' display department information .\n\t'13' display 2nd highest employee in department"
							+ "\n\t'14'  Display employee details,based on department \n\t'15' to Go Back'");
			System.err.println("");
			String input = scanObject.next();
			
			int selectedQueryOption = 0;

			if (input.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				selectedQueryOption = validationObject.intValidation("Query Selection", input);
			} else {
				selectedQueryOption = Integer.parseInt(input);
			}
            
			if (selectedQueryOption > EmployeeInterface.MIN_QUERY
					&& selectedQueryOption <= EmployeeInterface.MAX_QUERY) 
			{
				
				if (selectedQueryOption == 1) 
				{
					query = "select * from employee"; // get all records
				} 
				
				else if (selectedQueryOption == 2) // validation Required
				{
					System.out.println("Enter from Employee Id");
					String fromEmpId = scanObject.next();
					int fempid = 0;
					if (fromEmpId.matches(numberregex) == false) // here performin age validation reexecute logic till
																	// not succeed
					{
						fempid = validationObject.intValidation("fromId", fromEmpId);
					} else {
						fempid = Integer.parseInt(fromEmpId);
					}
					System.out.println("Enter to Employee Id");
					String toEmpId = scanObject.next();
					int toEmpid = 0;
					if (toEmpId.matches(numberregex) == false) // here performin age validation reexecute logic till not
																// succeed
					{
						toEmpid = validationObject.intValidation("to EmpId", toEmpId);
					} else {
						toEmpid = Integer.parseInt(toEmpId);
					}

					query = "select * from employee where empId between" + " " + fempid + " AND " + toEmpid; // to get
																												// Records
																												// Between
																												// Range
				}
				
				 else if (selectedQueryOption == 3) // validation required
				{
					System.out.println("Enter some starting character of Your First Name ! Atleast 2 to 3  character");
					char someCharacter = scanObject.next().charAt(0);
					query = "select * from employee where first_Name like '" + someCharacter + "%'"; // to get Record
																										// Alphabaticaly
				}
				
				 else if (selectedQueryOption == 4) // validation required
				{
					query = "select department ,count(*) No_Of_Emp  from employee GROUP BY department"; // to get number
																										// of employee
																										// in eache
																										// department
					resultSetObject = statementObject.executeQuery(query);
					if (resultSetObject != null) {
						System.out.println("\t Department  \t No_Of_Emp ");
						System.out.println("\t===========================");
						while (resultSetObject.next()) {
							String department = resultSetObject.getString("department");
							String no_Of_Employees = resultSetObject.getString("No_Of_Emp");
							System.out.println("\t" + department + " \t " + no_Of_Employees + " ");
							System.out.println("\t---------------------------");
						}
					}
					// display();
				}
				
				 else if (selectedQueryOption == 5) // validation required
				{
					System.out.println("\tEnter From Date ");
					String fromDate = scanObject.next();

					System.out.println("\tEnter to Date ");
					String toDate = scanObject.next();
					// to get number of employee in eache department
					query = "select * from employee where Date_Of_Join between " + " '" + fromDate + "' AND ' " +toDate+"'";
				}
				
				 else if (selectedQueryOption == 6) // validation required
				{
					// to get number of employee in eache department
					query = "select count(*) as aadedEmployee from employee where empId in (select empId from family)";
					resultSetObject = statementObject.executeQuery(query);
					if (resultSetObject != null) {
						System.out.println("\t Faimly Details Added ");
						System.out.println("\t======================");
						while (resultSetObject.next()) {
							String no_Of_Employees = resultSetObject.getString("aadedEmployee");
							System.out.println(" \t " + no_Of_Employees + " "+"Employee Added Family Details" );
							System.out.println("\t----------------------------------\n");
						}
					}
					display();
				}
				
				 else if (selectedQueryOption == 7) // validation required
				{
					// to get number of employee in eache department
					query = "select count(*) as nonaadedEmployee from employee where empId Not in (select empId from family)";
					resultSetObject = statementObject.executeQuery(query);
					if (resultSetObject != null) {
						System.out.println("\t family Details Not Added ");
						System.out.println("\t============================");
						while (resultSetObject.next()) {
							String no_Of_Employees = resultSetObject.getString("nonaadedEmployee");
							System.out.println(" \t " + no_Of_Employees + " "+"Employee Not Added Family Details");
							System.out.println("\t-----------------------------------\n");
						}
					}
					display();
				}
				
				  else if (selectedQueryOption == 8)
				{
						query = "select * from employee where empId  in (select empId from family)";
						//System.exit(0);
				}
				
				  else if (selectedQueryOption == 9)
				{
					
					  {	  
						System.out.println("please Enter valid employee id ");
						String empId =scanObject.next();
						int empid =0;
						if (empId.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
						{
							empid = validationObject.intValidation("employee id", empId);
						} else {
							empid = Integer.parseInt(empId);
						}
						
						System.out.println("please Enter Your Father name ");
						String fatherName =scanObject.next();
						if (fatherName.matches(stringregex) == false) // here performin age validation reexecute logic till not
						{
							fatherName = validationObject.stringValidation("father name", fatherName); // here we have to pass keyword
						}
						
						System.out.println("please Enter Your mother name ");
						String motherName =scanObject.next();
						if (motherName.matches(stringregex) == false) // here performin age validation reexecute logic till not
						{
							motherName = validationObject.stringValidation("mother Name", motherName); // here we have to pass keyword
						}
						 //here checking the record already exist or not
						 String checkEmpId="select id from family where empId = "+empid;
						 ResultSet resultSet = statementObject.executeQuery(checkEmpId);
						  
						int newId=0;
						 while(resultSet.next())
					     {
							newId=resultSet.getInt("id");
						 }

						 if(newId  != 0)
						 {
							
							 System.err.println("Already family details added"+newId);
							 checkEmpId=null;
							 resultSet=null;
							 display();
						 }
						 else
						 {
							
							 System.out.println("we are adding your family details");
							 //left query to insert family details
							 String insertQuery = "insert into family(empId,father_name,mother_name)values("+empid+",'"+fatherName+"',+'"+motherName+"')";
								int queryStatus = statementObject.executeUpdate(insertQuery);
								if (queryStatus == 1) {
									System.out.println("Record inserted successfully ");
								} else {
									System.err.println("Record Not inserted ! ");
								}
							display();
						 }	
					  }
				}
				
				else if (selectedQueryOption == 10) {
					System.out.println("Enter from age to find records");
					String fromAge = scanObject.next();
					int fromage=0;
					 if (fromAge.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
						{
						 fromage = validationObject.intValidation("fromAge", fromAge);
						} else {
							fromage = Integer.parseInt(fromAge);
						}
					System.out.println("Enter To age to find records");
					String toAge = scanObject.next();
					int toage=0;
					 if (toAge.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
						{
						 toage = validationObject.intValidation("toAge", toAge);
						} else {
							toage = Integer.parseInt(toAge);
						}
					query = "select first_name from employee where (year(curdate())-year(date_of_birth)) between "
							+ fromage + " and " + toage;

					resultSetObject = statementObject.executeQuery(query);
					if (resultSetObject != null) {
						System.out.println("\t Employee deatils(First name) ");
						System.out.println("\t============================");
						while (resultSetObject.next()) {
							String firstname = resultSetObject.getString("first_name");
							System.out.println(" \t " + firstname + " ");
							System.out.println("\t-----------------------\n");
						}
					}
					display();
				}
					
				 //to go back
			      else	if(selectedQueryOption == 11)
				  {
			    	  System.out.println("Enter expirence of employee ");
					  String expirence =scanObject.next();
					  int exPirence=0;
					  if (expirence.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
						{
						  exPirence = validationObject.intValidation("expirence", expirence);
						} else {
							exPirence = Integer.parseInt(expirence);
						}
					  query ="select first_name from employee where (year(curdate())-year(Date_Of_Join)) ="+exPirence;
					  
					  resultSetObject = statementObject.executeQuery(query);
						if (resultSetObject != null) {
							System.out.println("\t Employee deatils(First name)  ");
							System.out.println("\t============================");
							while (resultSetObject.next()) {
								String firstname = resultSetObject.getString("first_name");
								System.out.println(" \t " + firstname + " ");
								System.out.println("\t-----------------------\n");
							}
						}
						display();
				  }
			      else	if(selectedQueryOption == 12)
				  {
					query ="select * from department";
					resultSetObject = statementObject.executeQuery(query);
					if (resultSetObject != null) {
						System.out.println("\t dpt_id \t dpt_name ");
						System.out.println("\t=========================");
						while (resultSetObject.next()) 
						{
							int dpt_id = resultSetObject.getInt("dpt_id");
							String dpt_name = resultSetObject.getString("dpt_name");
							System.out.println(" \t " + dpt_id + "\t\t"+dpt_name);
							System.out.println("\t--------------------------\n");
						}
					}
					display();
					
				  }
			      else	if(selectedQueryOption == 13)
				  {
						query="SELECT department, MAX(department)  AS department FROM employee WHERE department < (SELECT MAX(department) FROM employee)";
						resultSetObject = statementObject.executeQuery(query);
						if (resultSetObject != null) {
							System.out.println("\t department ( 2nd highest department)");
							System.out.println("\t=====================================");
							while (resultSetObject.next()) 
							{
								String scndHighestdpt1 = resultSetObject.getString("department");
								String scndHighestdpt2 = resultSetObject.getString("department");
								System.out.println("\t"+scndHighestdpt1+" \t"+scndHighestdpt2);
								System.out.println("\t---------------------------------\n");
							}
						}
						display();

				  }
			      else	if(selectedQueryOption == 14)
				  {
			    	  System.out.println("Enter department name Like:finanDpt , salesDpt ,ProdcDpt ,MaintDpt");
			    	  String dptName = scanObject.next();
			    	  if (dptName.matches(stringregex) == false)                                            
						{
			    		  dptName = validationObject.stringValidation("department name", dptName);                    
						}


			    	  query="SELECT * from employee where department='"+dptName+"'";
				  }
			      else	if(selectedQueryOption == 15)
				  {
						CRUDOperations.main(null);
				  }
				
			} else {
				System.err.println("You should Enter from given Option Only !");
				display();
			}
             
			resultSetObject = statementObject.executeQuery(query);
			// System.out.println("ResultSet");
			if (resultSetObject != null) {
				System.out.println(
						"\t empId \t FirstName \t lastName \t Age \t City \t\t Status \tJoin_Date \t Department \t\t Date_Of_Birth \t\tDpt_Id");
				System.out.println(
						"\t======================================================================================================================================================");
				// Retrieve by column name
				while (resultSetObject.next()) {
					int id = resultSetObject.getInt("empId");
					String firstname = resultSetObject.getString("first_Name");
					String lastName = resultSetObject.getString("last_Name");
					int age = resultSetObject.getInt("age");
					String city = resultSetObject.getString("city");
					int status = resultSetObject.getInt("status");
					String joinDate = resultSetObject.getString("Date_Of_Join");
					String department = resultSetObject.getString("department");
					String dob  =  resultSetObject.getString("date_Of_Birth");
					int dptId = resultSetObject.getInt("dpt_id");
					// display the data
					System.out.println("       " + "\t" + id + " \t " + firstname + " \t\t" + lastName + " \t\t" + age
							+ "\t" + city + "\t\t" + status + "\t\t" + joinDate + "\t" + department+"\t\t"+ dob+"\t\t"+dptId);
					System.out.println(
							"\t-------------------------------------------------------------------------------------------------------------------------------------------------------");
				}
				System.out.println();
				display();
			} else {
				System.err.println("Records Not Avaialable ");
			}
		} catch (CommunicationsException connectionFail) {
			System.err.println("Database Connection failed ! Please check Database Connection");
			// connectionFail.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("select option to get Different Kinds of Employee Records");
			System.out.println("\t'1' to get All Records \n\t'2' to get Records Between Range \n\t'3' to get Record Alphabaticaly\n");
		} catch (SQLException e) 
		{
			System.err.println("Have some Database issues ! Try Again");
			e.printStackTrace();
		}

	}// display() close here

	public void insert()
	{

		while (moreInsert == 1) {
			System.out.println("Enter First Name");
			String firstName = scanObject.nextLine();
			if (firstName.matches(stringregex) == false) // here performin age validation reexecute logic till not
			{
				firstName = validationObject.stringValidation("First name", firstName); // here we have to pass keyword
			}
			// System.out.println("first name :"+firstName);
			System.out.println("Enter last Name");
			String lastName = scanObject.nextLine();
			if (lastName.matches(stringregex) == false) // here performin age validation reexecute logic till not
			{
				lastName = validationObject.stringValidation("last name", firstName); // here we have to pass keyword
			}
			
			//here getting Date Of Birth
			String  dob = validationObject.getActualAge();
			System.out.println("DOB IS  : "+dob);
			
			
			System.out.println("Enter your Age ");
			String age = scanObject.next();
			int agee=0;
			if (age.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				agee = validationObject.intValidation("Age", age);
			} else {
				agee = Integer.parseInt(age);
			}
			//System.out.println("age cross check" + agee);
			if ((agee <= EmployeeInterface.MIN_AGE ) || (agee >= EmployeeInterface.MAX_AGE) ) {
				System.err.println(
						agee + " " + "is not valid Age ! Try again with valid Age which will be between 18 to 65");
				int aGe = 0;
				boolean ageStatus = true;
				boolean validAge = true;
				while (validAge) {
					System.out.println("Again Enter Your age");
					aGe = scanObject.nextInt();
					if (aGe > EmployeeInterface.MIN_AGE) {
						agee = aGe;
						validAge = false;
					} else {

					}

				} // while close here
			} // if close here

			System.out.println("Enter City Name");
			String city = scanObject.next();
			if (city.matches(stringregex) == false)                                              // here performin age validation reexecute logic till not succeed
			{
				city = validationObject.stringValidation("City name", city);                     // here we have to pass keyword and non
			}


			System.out.println("Enter Your joining Date");
			String dateOfJion = scanObject.next();
			String validJoinDate=null;
			String validDate=null;
			String currentDate =null;
			
			if (dateOfJion.matches(dateRegEx) == false) { // if(dateOfJion < currentDate)
				dateOfJion = validationObject.validateDate("joining Date", dateOfJion); // here we have to pass
				if (dateOfJion.matches(dateRegEx) == true) {
					boolean status = true;
					while (status) {
						try {
							Calendar cal = Calendar.getInstance();
							cal.add(Calendar.DATE, 1);
							Date date = cal.getTime();
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							String inActiveDate = null;
							inActiveDate = format1.format(date);
							currentDate = inActiveDate;
							// System.out.println("current date" +inActiveDate );
							// System.out.println("joining date "+dateOfJion );
							if (dateOfJion.compareTo(currentDate) < 0) {
								System.out.println("allow when date of join is less then current date  :" + dateOfJion
										+ "  " + currentDate);
								validDate = dateOfJion;
								status = false;
							} else {
								System.err.println(" not allowed  join date can not be accessed from current date :"
										+ dateOfJion + "  " + currentDate);
								System.out.println("again enter valid joining date ");
								dateOfJion = scanObject.next();
							}
						} catch (Exception e) {
							System.err.println("Have some Date related Issues ");
						}
					} // while close here
				}
		       
		       System.out.println("actual join date "+dateOfJion);
			}
			//======================================================
			
			System.out.println("Enter Your Department");
			String department = scanObject.next();
			if (department.matches(stringregex) == false)                                        // here performin age validation reexecute logic till not
			{
				department = validationObject.stringValidation("department name", department);   // here we have to pass
			}			
			
			String status = "0";
			query = "INSERT INTO employee (first_Name,last_Name,age,city,status,Date_Of_Join,department,date_Of_Birth) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			
			try {
				preparedSatementObject = connectionObject.prepareStatement(query);
				// set parameters for statement
				preparedSatementObject.setString(1, firstName);
				preparedSatementObject.setString(2, lastName);
				preparedSatementObject.setInt(3, agee);
				preparedSatementObject.setString(4, city);
				preparedSatementObject.setString(5, status);
				//System.out.println("befor inserting joindate :"+dateOfJion);
				preparedSatementObject.setString(6, dateOfJion);
				preparedSatementObject.setString(7, department);
				preparedSatementObject.setString(8, dob);

				int queryStatus = preparedSatementObject.executeUpdate();
				if (queryStatus == 1) {
					System.out.println("Record inserted successfully ");
				} else {
					System.err.println("Record Not inserted ! ");
				}
				
			} catch (CommunicationsException connectionFail) {
				System.err.println("Database Connection failed ! Please check Database Connection");
				// connectionFail.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Have some Database issues !Please Check");
				e.printStackTrace();
			}
			System.out.println("You Want to insert more Records press 1 insert or 2 To Go Back");
			moreInsert = scanObject.nextInt();
			String insertOption = Integer.toString(moreInsert);
			if (insertOption.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				moreInsert = validationObject.intValidation("insertOption", insertOption);
			} else {
				moreInsert = Integer.parseInt(insertOption);
			}
			
			if((moreInsert < 1  ) || (moreInsert > 2) ) {
				System.err.println(
						moreInsert + " " + "is not valid option ! Try again with valid Option which will be between 1 to 2");
				int inserOption = 0;
				boolean validOption = true;
				while (validOption) {
					System.out.println("Again Enter Your Insert Option");
					inserOption = scanObject.nextInt();
					if (inserOption > 0 || inserOption <3 ) {
						moreInsert = inserOption;
						validOption = false;
					} else {
                    
					}

				} // while close here
			} // if close here
            if(moreInsert ==1)
            {
            	insert();
            }else
            {
            	 CRUDOperations.main(null);
            }
		}//loop close
	}//method close

	public void update() {
		System.out.println("Enter Your Employee Id ");
		String UpdateData = null;
		String column = null;
		int moreUpdate = 1;
		String empId = null;
		int empid = 0;
		while (moreUpdate == 1) {
			try {
				empId = scanObject.nextLine();
				empid = validationObject.intValidation("Employee Id", empId);
				if (empId.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
				{
					empid = validationObject.intValidation("Employee Id", empId);
				} else {
					empid = Integer.parseInt(empId);
				}
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

			if ((column.equalsIgnoreCase("First_Name")) || (column.equalsIgnoreCase("Last_Name"))
					|| (column.equalsIgnoreCase("age")) || (column.equalsIgnoreCase("City")) || (column.equalsIgnoreCase("department")) == true) {
				System.out.println("Enter what You want to update  ");
				UpdateData = scanObject.next();
				try {
					query = "update employee set " + column + "='" + UpdateData + "'where empId=" + empid + "";

					statementObject = connectionObject.createStatement();
					int queryStatus = statementObject.executeUpdate(query);
					// System.out.print(queryStatus+" ");
					if (queryStatus == 1) {
						System.out.println("Record update successfully ");
					} else {
						System.err.println("Record Not  update ! ");
					}
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate = scanObject.nextInt();
				} catch (CommunicationsException connectionFail) // if during execution disturb the database connection
				{
					System.err.println("Database Connection failed ! Please check Database Connection");
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate = scanObject.nextInt();
				} catch (SQLException e) // if during database execution occure some issues like syntectical mistak in
											// query
				{
					System.err.println("Have some Syntactial  issues in Query  !Please Check You Query");
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate = scanObject.nextInt();
				} catch (InputMismatchException eee) // if input is not match according to data type
				{
					System.err.println("You Not Entered Valid input");
					System.out.println("You Want to insert more Records press 1 update or 2 no update");
					moreUpdate = scanObject.nextInt();
				}
			} else {
				System.err.println("Column name not Valid ! Please check");
				update();
			}
		} // loop close
	}

	// =============================================================update
	// close====================================
	public void delete() {
		int moreDelete = 1;
		while (moreDelete == 1) {
			System.out.println("enter 	Your employee	Id");
			String empId = scanObject.nextLine();
			// validation
			int empid =0;
			if (empId.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				empid = validationObject.intValidation("Employee id", empId);
			} else {
				empid = Integer.parseInt(empId);
			}
			System.out.println("empid is "+empid);
			if (empid > 0) {
				try {
					// 1 indicate deleted records
					query = "update employee set status ='" + 1 + "'where empId=" + empid + "";

					statementObject = connectionObject.createStatement();
					int queryStatus = statementObject.executeUpdate(query);
					// System.out.print(queryStatus+" ");
					if (queryStatus == 1) {
						System.out.println("Record deleted successfully ");
					} else {
						System.err.println("Record Not  Exist ! "); // if result set null then execute this else block
					}
					System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
					moreDelete = scanObject.nextInt();
					if (moreDelete < 0 && moreDelete > 2) {
						System.err.println("You Not enter valid Option ! Try Again With valid Option ");
						System.out
								.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
						moreDelete = scanObject.nextInt();
					}
				} catch (CommunicationsException connectionFail) // if during execution disturb the database connection
				{
					System.err.println("Database Connection failed ! Please check Database Connection");
					System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
					moreDelete = scanObject.nextInt();
				} catch (SQLException e) { // if during database execution occure some issues like syntectical mistak in
											// query
					System.err.println("Have some Database issues !Please Check");
					System.out.println("You Want to Delete another Records press '1' to Delete or '2' to no Delete");
					moreDelete = scanObject.nextInt();

				}

			} else {
				System.err.println("You Entered Employee id Is Negative ! entere Correct Employee id");
				System.out.println(
						"Try again ! \n entere Correct Employee id to delete Records press 1 Delete or 2 no Delete");
				moreDelete = scanObject.nextInt();
			}
		} // while loop close here

	}

	// ================================================Delete Record
	// end================================================
	public void evenRecords() {

		try {
			query = "select * from employee where empId  % 2 =" + 0;
			statementObject = connectionObject.createStatement();
			resultSetObject = statementObject.executeQuery(query);
			if (resultSetObject != null) {
				System.out.println("\t\t\t\t |Even Records | ");
				System.out.println("\t\t\t\t |=============| \n");
				System.out.println("\t empId \t FirstName \t lastName \t Age \t City \t\t Status");
				System.out.println("\t=============================================================================");
				// Retrieve by column name
				while (resultSetObject.next()) {
					int id = resultSetObject.getInt("empId");
					String firstname = resultSetObject.getString("first_Name");
					String lastName = resultSetObject.getString("last_Name");
					int age = resultSetObject.getInt("age");
					String city = resultSetObject.getString("city");
					int status = resultSetObject.getInt("status");
					// display the data
					System.out.println("       " + "\t" + id + " \t " + firstname + " \t\t" + lastName + " \t\t" + age
							+ "\t" + city + "\t\t" + status);
					System.out
							.println("\t-----------------------------------------------------------------------------");
				}
			} else {
				System.err.println("Records Not Avaialable "); // if result set null then execute this else block
			}
		} catch (CommunicationsException connectionFail) {
			System.err.println("Database Connection failed ! Please check Database Connection"); // if during execution
																									// disturb the
																									// database
																									// connection
			// connectionFail.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			System.err.println("Have some Database issues ! Try Again"); // if during database execution occure some
																			// issues like syntectical mistak in query
			// e.printStackTrace();
			System.exit(0);
		}

	}
	// ==========================================================even Record
	// End============================================

	public void oddRecords() {
		try {
			query = "select * from employee where empId  % 2 !=" + 0;
			statementObject = connectionObject.createStatement();
			resultSetObject = statementObject.executeQuery(query);
			if (resultSetObject != null) {
				System.out.println("\t\t\t\t | Odd Records | ");
				System.out.println("\t\t\t\t |=============| \n");
				System.out.println("\t empId \t FirstName \t lastName \t Age \t City \t\t Status");
				System.out.println("\t=============================================================================");
				// Retrieve by column name
				while (resultSetObject.next()) {
					int id = resultSetObject.getInt("empId");
					String firstname = resultSetObject.getString("first_Name");
					String lastName = resultSetObject.getString("last_Name");
					int age = resultSetObject.getInt("age");
					String city = resultSetObject.getString("city");
					int status = resultSetObject.getInt("status");
					// display the data
					System.out.println("       " + "\t" + id + " \t " + firstname + " \t\t" + lastName + " \t\t" + age
							+ "\t" + city + "\t\t" + status);
					System.out
							.println("\t-----------------------------------------------------------------------------");
				}
			} else {
				System.err.println("Records Not Avaialable "); // if result set null then execute this else block
			}
		} catch (CommunicationsException connectionFail) {
			System.err.println("Database Connection failed ! Please check Database Connection"); // if during execution
																									// disturb the
																									// database
																									// connection
			// connectionFail.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			System.err.println("Have some Database issues ! Try Again"); // if during database execution occure some
																			// issues like syntectical mistak in query
			// e.printStackTrace();
			System.exit(0);
		}

	}
}
