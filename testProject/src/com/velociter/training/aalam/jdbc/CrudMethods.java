package com.velociter.training.aalam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;
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
							+ "\n\t'5' to get Employee details,if we enter current start date to end date. \n \t'6' Display added family \n\t'7' Display not added family \n\t'8' to Display Employe record who added family Details.\n\t'9' to Go Back");
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
					query = "select * from employee where Date_Of_Join between " + " " + fromDate + " AND " + toDate;
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
				
				//to go back
			      else	if(selectedQueryOption == 9)
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
						"\t empId \t FirstName \t lastName \t Age \t City \t\t Status \tJoin_Date \t Department \t Date_Of_Birth ");
				System.out.println(
						"\t=====================================================================================================================");
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
					// display the data
					System.out.println("       " + "\t" + id + " \t " + firstname + " \t\t" + lastName + " \t\t" + age
							+ "\t" + city + "\t\t" + status + "\t\t" + joinDate + "\t" + department+"\t"+ dob);
					System.out.println(
							"\t----------------------------------------------------------------------------------------------------------------------");
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
			System.out.println(
					"\t'1' to get All Records \n\t'2' to get Records Between Range \n\t'3' to get Record Alphabaticaly\n");
		} catch (SQLException e) {
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
			// validation Required
			System.out.println("Enter Your Joining Date");
			String joinDate = scanObject.next();
			int joindate=0;
			if (joinDate.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				joindate = validationObject.intValidation("join Date", joinDate);
			} else {
				joindate = Integer.parseInt(joinDate);
			}
			if ((joindate < EmployeeInterface.MIN_DATE) || (joindate > EmployeeInterface.MAX_DATE) ) {
				System.err.println(
						joindate + " " + "is not valid date ! Try again with valid joindate which will be between 1 to 31");
				int datee = 0;
				boolean validdate = true;
				while (validdate) {
					System.out.println("Again Enter Your joining date");
					datee = scanObject.nextInt();
					if (datee > EmployeeInterface.MIN_DATE) {
						joindate = datee;
						validdate = false;
					} else {

					}

				} // while close here
			} // if close here
			
			System.out.println("Enter Your Joining Month(In numbers  like march '03'");
			String joinMonth = scanObject.next();
			int joinmonth=0;
			if (joinMonth.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				joinmonth = validationObject.intValidation("join Month", joinMonth);
			} else {
				joinmonth = Integer.parseInt(joinMonth);
			}
			
			if ((joinmonth < 1) || (joinmonth > 12) ) {
				System.err.println(
						joinmonth + " " + "is not valid month ! Try again with valid month which will be between 1 to 12");
				int month = 0;
				boolean validmonth = true;
				while (validmonth) {
					System.out.println("Again Enter Your joining month");
					month = scanObject.nextInt();
					if (month >= 1) {
						joinmonth = month;
						validmonth = false;
					} else {

					}

				} // while close here
			} // if close here

			System.out.println("Enter Your Joining year");
			String joinYear = scanObject.next();
			int joinyear=0;
			if (joinYear.matches(numberregex) == false) // here performin age validation reexecute logic till not succeed
			{
				joinyear = validationObject.intValidation("join Year", joinYear);
			} else {
				joinyear = Integer.parseInt(joinYear);
			}
			
			//getting current year
			int currentyear = Calendar.getInstance().get(Calendar.YEAR);
		    System.out.println("current year :"+currentyear);
			if ((joinyear < 0) || (joindate > currentyear ) ) {
				System.err.println(
						joinyear+ " " + "is not valid Year ! Try again with valid year");
				int year = 0;
				boolean validYear = true;
				while (validYear) {
					System.out.println("Again Enter Your joining year");
					year = scanObject.nextInt();
					if (year >= 1  && year <=currentyear) {
						joindate = joinyear;
						validYear = false;
					} else {

					}

				} // while close here
			} // if close here

			System.out.println("joinind date is :"+joinyear+"-"+joinmonth+"-"+joindate+"");
			joinDate=""+joinyear+"-"+joinmonth+"-"+joindate+"";
	
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
				preparedSatementObject.setString(6, joinDate);
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
					|| (column.equalsIgnoreCase("age")) || (column.equalsIgnoreCase("City")) == true) {
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
