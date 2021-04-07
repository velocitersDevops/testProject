package com.velociter.training.mukesh.chapter10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class DatesWriting {
        enum MONTH_ENUM{January,February, March, April, May, June, July, August, September, October, November, December}
    	int date,month,year,fullYear; 
	    String dateInput[]=new String[10];
	public void randomDate(int range)
	{
		String dateInput[]=new String[range];
		MONTH_ENUM[] monthsEnum= MONTH_ENUM.values();//return all values present inside the enum.
		String fetchMonth="";
		for (MONTH_ENUM monthName : monthsEnum) {
    
			fetchMonth=fetchMonth+monthName+" ";
      }
		String allMonth[]=fetchMonth.split(" ");
		int count=0;
		String datesWrite[]=new String[10];
	  for(int i=0;i<dateInput.length;i++) 
	  {
        date=(int)((31*Math.random())+1);
        month=(int)(12*Math.random());
       year=(int)(100*Math.random());
	     
	    dateInput[i]=""+(month+1)+"/"+date+"/"+year;
	    // System.out.println("Input Date ="+dateInput[i]+" ");
	     fullYear=1900+year;
	     
			if(month!=1)//except February
			{
				if(month==0||month==2||month==4||month==6||month==7||month==9||month==11)  //31 days Month
				{
					if(date==1 || date==21||date==31) {
						//System.out.println("Output Date="+date+"st "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"st "+allMonth[month]+" "+(fullYear);
						count++;
					}
					else if(date==2) {
						//System.out.println("Output Date="+date+"nd "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"nd "+allMonth[month]+" "+(fullYear);
						count++;
					}
					
					else if(date==3) {
						//System.out.println("Output Date="+date+"rd "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"rd "+allMonth[month]+" "+(fullYear);
						count++;
					
					}
					else if(date>=4 && date<=30 && date!=21) {
						//System.out.println("Output Date="+date+"th "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"th "+allMonth[month]+" "+(fullYear);
						count++;
					
					}
					else
						System.err.println("Invalid Date Input");
					
				}
				
				else if(month==3||month==5||month==8||month==10) //30 days Month
				{
					if(date==1 || date==21) {
						//System.out.println("Output Date="+date+"st "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"st "+allMonth[month]+" "+(fullYear);
						count++;
					}
					else if(date==2) {
						//System.out.println("Output Date="+date+"nd "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"nd "+allMonth[month]+" "+(fullYear);
						count++;
					}
					
					else if(date==3) {
						//System.out.println("Output Date="+date+"rd "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"rd "+allMonth[month]+" "+(fullYear);
						count++;
					}
					else if(date>=4 && date<=30 && date!=21) {
						//System.out.println("Output Date="+date+"th "+allMonth[month]+" "+(fullYear));
						datesWrite[count]=date+"th "+allMonth[month]+" "+(fullYear);
						count++;
					}
					else
						System.err.println("Invalid Date Input");
					
				}
				
		}
			
			else if(month==1) //For February
				{     
					
					if(date<=28) {
						if(date==1) {
							//System.out.println("Output Date="+date+"st "+allMonth[month]+" "+fullYear);
							datesWrite[count]=date+"st "+allMonth[month]+" "+(fullYear);
							count++;
						}
						else if(date==2) {
							//System.out.println("Output Date="+date+"nd "+allMonth[month]+" "+fullYear);
							datesWrite[count]=date+"nd "+allMonth[month]+" "+(fullYear);
							count++;
						}
						else if(date==3) {
							//System.out.println("Output Date="+date+"rd "+allMonth[month]+" "+fullYear);
							datesWrite[count]=date+"rd "+allMonth[month]+" "+(fullYear);
							count++;
						}
						else if(date>=4 && date<=28) {
							//System.out.println("Output Date="+date+"th "+allMonth[month]+" "+fullYear);
							datesWrite[count]=date+"th "+allMonth[month]+" "+(fullYear);
							count++;
						}
						else
							System.err.println("Invalid Date Input");
						
					}
					else if(date==29 && ((fullYear % 4 == 0)&&(fullYear % 100 == 0)&&(fullYear % 400 == 0))) 
					{
						datesWrite[count]=date+"st "+allMonth[month]+" "+(fullYear);
						count++;
						//System.out.println("Output Date="+date+"th "+allMonth[1]+" "+fullYear);
					}
					else
						{System.err.println("Invalid Date Input");}
				}
			else
				System.err.println("Invalid Date Input");
        }
	  
	  System.out.println();
	  for(String date :datesWrite)
	  {
		 System.out.println(date); 
	  }
	  String dirName = "E:\\Newfolder";   // Directory for the output file
	    String fileName = "WriteDates.txt";// Name of the output file
	    File newFile=new File(dirName, fileName);
	    try 
	    {
	    FileOutputStream outNewFile=new FileOutputStream(newFile);
	    System.out.println("File Created");
	    }
	    catch(FileNotFoundException ex)
	    {
	    	System.out.println("File not Found");
	    }
	    try {
	        FileWriter myWriter = new FileWriter(newFile);
	        for(String date :datesWrite) { 
	        	myWriter.write(date+String.format("%n"));
	        	
	        	}
	       myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    
}
public static void main(String ar[])
{   
	DatesWriting dateFormate=new DatesWriting();
	int range=10;
	dateFormate.randomDate(range);
}
}