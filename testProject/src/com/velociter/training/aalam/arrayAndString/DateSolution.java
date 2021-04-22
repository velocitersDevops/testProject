/*
 *Define an array of ten String elements each containing an arbitrary string of the form
“month/day/year”; for example,”10/29/99” or “12/5/01”. Analyze each element in the
array and output the date represented in the form 29th October 1999.
 */

package com.velociter.training.aalam.arrayAndString;

 class DateSolution
{

	 public static void dateFormate()
		{
			String allMonth[]= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		  for(int i=0;i<10;i++) 
		  {
			int date=(int)(31*Math.random() + 1); //12 
		    int month=(int)(12*Math.random() );   // January
		    int year=(int)(100*Math.random());    // 1958
		   
			System.out.print((month+1)+"/"+date+"/"+year);
			String numberofDigits =""+month+date+year;
			//System.out.print("number of digit "+numberofDigits.length());  debugging 
			int years = 1900+year;
			
			//if number of digit is decrease then number of space will be increase
			if(numberofDigits.length()== 5  && month == 9 )
			{
				System.out.print("                     "); //21 space
			}
			else if(numberofDigits.length()== 4  && month == 9 )
			{
				System.out.print("                       "); //23 space
			}
			else if(numberofDigits.length() ==5)
			{
				System.out.print("                      ");  //22 space
			}
			else if(numberofDigits.length()== 4)
			{
				System.out.print("                       "); //23 space
			}
			else if(numberofDigits.length()== 6)
			{
				System.out.print("                     ");  //21 space
			}else if(numberofDigits.length()== 3)
			{
				System.out.print("                        "); //24 space
			}
			
				
				
			if(month!=1)//except February
			{
				if(month==0||month==2||month==4||month==6||month==7||month==9)  // code for display dates (1 to 31 day)
				{
					if(date==1 || date==21||date==31) {
						System.out.println(date+"st "+allMonth[month]+" "+(years));
					}
					else if(date==2) {
						System.out.println(date+"nd "+allMonth[month]+" "+(years));
					}
					
					else if(date==3) {
						System.out.println(date+"rd "+allMonth[month]+" "+(years));
					}
					else if(date>=4 && date<=30 && date!=21) {
						System.out.println(date+"th "+allMonth[month]+" "+(years));
					}
					else
						System.err.println("Invalid Date ");
					
				}
				
				else if(month==3||month==5||month==8||month==10 || month==11) //30 days Month
				{
					if(date==1 || date==21) {
						System.out.println(date+"st "+allMonth[month]+" "+(years));
					}
					else if(date==2) {
						System.out.println(date+"nd "+allMonth[month]+" "+(years));
					}
					
					else if(date==3) {
						System.out.println(date+"rd "+allMonth[month]+" "+(years));
					}
					else if(date>=4 && date<=30 && date!=21) {
						System.out.println(date+"th "+allMonth[month]+" "+(years));
					}
					else
						System.err.println("Invalid Date ");
					}
			  	 }
			else if(month==1) //For February
				{     	
					if(date<=28) {
						if(date==1) {
							System.out.println(date+"st "+allMonth[month]+" "+years);
						}
						else if(date==2) {
							System.out.println(date+"nd "+allMonth[month]+" "+years);
						}
						else if(date==3) {
							System.out.println(date+"rd "+allMonth[month]+" "+years);
						}
						else if(date>=4 && date<=28) {
							System.out.println(date+"th "+allMonth[month]+" "+years);
						}
						else
							System.err.println("Invalid Date ");
						
					}
					else if(date==29 && ((years % 4 == 0)&&(years % 100 == 0)&&(years % 400 == 0))) 
					{
						System.out.println(date+"th "+allMonth[1]+" "+years);
					}
					else
						{
						System.err.println("Invalid Date");
						}
				}
			else
				         System.err.println("Invalid Date ");
        }
	  System.out.println();

	 }
	}
			  
		

	  




