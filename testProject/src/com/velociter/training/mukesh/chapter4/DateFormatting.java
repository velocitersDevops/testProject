//Define an array of ten String elements each containing an arbitrary string of the form “month/day/year”;
//INPUT:example,”10/29/99”.

//OUTPUT: 29th October 1999.


package com.velociters.chapter4;
public class DateFormatting 
{
	public static void main(String[] args)
	{
		String[] dates = new String[10];    // for storing 10 date values.
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		char separator='/';
		int day   =0;
		int month =0;
		int year  =0;
		int daysIncreament=0;
		int monthArray[] =new int[monthNames.length];
		for(int i=0;i<dates.length;i++)               // for printing 10 date values  
		{
				year=(int) (100.0*Math.random());	        
			
				month=(int)(12.0*Math.random())+1;			
			    monthArray[i]=month;
				
			    // for leap year increase by 1 in February month
				
				daysIncreament=((year %4 == 0) && !(year %100 == 0)||(year % 400 == 0)) && (month==2) ? 1 : 0;
				day=(int)(Math.random()* (daysInMonth[month-1] + daysIncreament)) +1;
				
				dates[i]= "" + month + separator+ day + separator + (year<10?"0":"")+ year ;
				
				System.out.println("date is = " +dates[i]);			//	 print 10 dates
		}
		 
		int start = 0;
		int end = 0;
		String dayString=null;
		String monthString=null;
		String yearString=null;
		String ending="th";
		int index=0;
		System.out.println();
		 
		for(String date:dates)
		{
			start = 0;
			end=date.indexOf(separator, start);
			monthString= date.substring(start, end);
			 
			start=end+1;
			end = date.indexOf(separator, start);
			dayString=date.substring(start, end);
			
			start=end+1;
			yearString=date.substring(start);
			
			if(dayString.length()==1)
			{
					switch(dayString.charAt(0))
					{
					case '1': 
						ending ="st ";
						break;
					case '2':
						ending ="nd ";
						break;
					case '3':
						ending ="rd ";
						break;
					default :
						ending ="th ";
					}
			}
			else if(dayString.charAt(0)=='1')
			{
						ending ="th";
			}
			else
			{
					switch(dayString.charAt(1))
					{
					case '1':
						ending = "st";
						break;
					case '2':
						ending = "nd";
						break;
					case '3':
						ending = "rd";
						break;
					default :
						ending = "th";
						
					}
			}
			
			StringBuilder stringBuilder = new StringBuilder();
			int lengthOfSept=(monthNames[8].length())+5; 				//length of September 
			int lengthOfMonth=(monthNames[monthArray[index]-1]).length();  //find length of generated month randomly
			int space=lengthOfSept-lengthOfMonth;
			index++;
			for(int k=1;k<space;k++)
			{
				stringBuilder.append(" ");
			}
			
			
			System.out.println(dayString + ending  +" "+ monthNames[monthString.length()==1 ? monthString.charAt(0) -'1'   : 9 + monthString.charAt(1)-'0'] +stringBuilder+ "19" + yearString);
			
			
		}
		
	}

}
