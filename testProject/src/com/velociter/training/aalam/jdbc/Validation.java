package com.velociter.training.aalam.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class Validation 
{
   String resultedString =null;
   String stringregex = "^[a-zA-Z]+$";                     //reguler expression to allow only character not number
   String numberregex = "[0-9]+";
   String dateregex = "^\\d{4}-\\d{2}-\\d{2}$";
   Scanner scanObject = new Scanner(System.in);
   //validation for allow only characters not allow numbers or symbals
	public String  stringValidation(String keyWord,String inputString)
	{
		
		if(inputString.matches(stringregex) == false)  //here performin inputString validation reexecute logic till not succeed
		{	
			 boolean inputStringStatus = true;
				while (inputStringStatus) {
					System.err.println("can not use number  or symbols Or spaces in "+keyWord +"! Try Again with valid "+keyWord+" .");
					System.out.println("Again Enter " +keyWord);
					inputString = scanObject.next();
					if (inputString.matches(stringregex) == true) {
						//System.out.println("inputString not include number " + inputString);
						 resultedString = inputString;
						inputStringStatus = false;
					} else {
						//System.out.println("inputString include number " + inputString);
				 }
				}//while close here
		}//if close here
		return resultedString;
	}//method close
	
	//===================================================================================================================
	
	public int intValidation(String keyWord,String inputString)
	{
		int resultedValue=0;
		if(inputString.matches(numberregex) == false)    //here performin age validation reexecute logic till not succeed
		{
			
		    boolean status = true;
			while (status) {
				System.err.println("can not use characters or Symbals in "+keyWord+" ! Try Again with valid "+keyWord);
				System.out.println("Again Enter Your "+keyWord);
				inputString = scanObject.next();
				if (inputString.matches(numberregex) == true) {
					
					resultedValue =  Integer.parseInt(inputString);
					System.out.println("id not include char " + resultedValue);
					 status = false;
					
				} else {
					System.out.println("id include char " + inputString);
				}

			}//while close here
		}//if close here
		return resultedValue;
	}
	
	//================================================Date validation==============================================================
	String validDate =null;
	public String validateDate(String KeyWord ,String inputString)
	{
		if(inputString.matches(dateregex) == false)    //here performin age validation reexecute logic till not succeed
	{
		
	    boolean status = true;
		while (status) {
			System.err.println("Date should be enter in 'YYYY - MM - DD' format  ! Try Again with valid "+KeyWord);
			System.out.println("Again Enter Your "+KeyWord);
			inputString = scanObject.next();
			if (inputString.matches(dateregex) == true) {
				validDate = inputString;
				 status = false;
				
			} else {
				
			}

		}//while close here
	}//if close here
	return validDate;
	}
	
	//============================================get Age ============================================================================
	public String getActualAge() 
	{
		System.out.println("Enter employee date of birth in 'yyyy-mm-dd'");
		String dateOfBirth = scanObject.next();
		String dob=null;
		 boolean b=false;
		if(dateOfBirth.matches(dateregex) == false)
		{
		     boolean status=true;
		   	 while (status) {
				System.err.println("Date should be enter in 'YYYY - MM - DD' format And age should be between 18 to 65   ! Try Again with valid date");
				System.out.println("Again Enter Your date of birth");
				dateOfBirth = scanObject.next();
				if (dateOfBirth.matches(dateregex) == true)
				{
				 
					 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				     Date date = null;
					try {
						date = formatter.parse(dateOfBirth);
					} catch (ParseException e) {
						System.out.println("Have som parsing issues");
						//e.printStackTrace();
					}
				     //Converting obtained Date object to LocalDate object
				     Instant instant = date.toInstant();
				     ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
				     LocalDate givenDate = zone.toLocalDate();
				     //Calculating the difference between given date to current date.
				     Period period = Period.between(givenDate, LocalDate.now());
				     
				     System.out.println(period.getYears());
				     int year=period.getYears();

					 if(year > EmployeeInterface.MIN_AGE && year < EmployeeInterface.MAX_AGE)
				     {
						 dob = dateOfBirth;
					     status=false; 
				     }
				     else  
				     {
				    	 status=true;//again repeat
				    	// getActualAge();
				     }
				} 
				else 
				{
					status=true;
				}
		} //while close
	}else
	{
		 dob = dateOfBirth;
	}
		return dob;  
    }//method close
}
