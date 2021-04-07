package com.velociter.training.aalam.writingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDateFile
{

	public static void main(String[] args) 
	{
		
    String allMonth[]= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		String[] dates = new String[10]; // Stores dates  in stringsArray
		int increementValue = 0;
		for(int i=0;i<10;i++) 
	  {
		int date=(int)(31*Math.random() + 1); //12 
	    int month=(int)(12*Math.random() );   // January
	    int year=(int)(100*Math.random());    // 1958
	   
		//System.out.print((month+1)+"/"+date+"/"+year);
		String numberofDigits =""+month+date+year;
		//System.out.print("number of digit "+numberofDigits.length());  debugging 
		int years = 1900+year;
		
			
			
		if(month!=1)//except February
		{
			if(month==0||month==2||month==4||month==6||month==7||month==9)  // code for display dates (1 to 31 day)
			{
				if(date==1 || date==21||date==31) {
					//System.out.println(date+"st "+allMonth[month]+" "+(years));
					dates[increementValue] = date+"st "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else if(date==2) {
					//System.out.println(date+"nd "+allMonth[month]+" "+(years));
					dates[increementValue] = date+"nd "+allMonth[month]+" "+(years);
					increementValue++;
				}
				
				else if(date==3) {
					//System.out.println(date+"rd "+allMonth[month]+" "+(years));
					dates[increementValue] = date+"rd "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else if(date>=4 && date<=30 && date!=21) {
					dates[increementValue] = date+"th "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else
				    System.err.println(" ");
				
			}
			
			else if(month==3||month==5||month==8||month==10 || month==11) //30 days Month
			{
				if(date==1 || date==21) {
					
					dates[increementValue] = date+"st "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else if(date==2) {
					
					dates[increementValue] = date+"nd "+allMonth[month]+" "+(years);
					increementValue++;
				}
				
				else if(date==3) {
					
					dates[increementValue] = date+"rd "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else if(date>=4 && date<=30 && date!=21) {
					
					dates[increementValue] = date+"th "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else
					System.err.println(" ");
				}
		  	 }
		else if(month==1) //For February
			{     	
				if(date<=28) {
					if(date==1) {
						
						dates[increementValue] = date+"st "+allMonth[month]+" "+(years);
						increementValue++;
					}
					else if(date==2) {
						
						dates[increementValue] = date+"nd "+allMonth[month]+" "+(years);
						increementValue++;
					}
					else if(date==3) {
						dates[increementValue] = date+"rd "+allMonth[month]+" "+(years);
						increementValue++;
					}
					else if(date>=4 && date<=28) {
						dates[increementValue] = date+"th "+allMonth[month]+" "+(years);
						increementValue++;
					}
					else
						System.err.println("Invalid Date ");
					
				}
				else if(date==29 && ((years % 4 == 0)&&(years % 100 == 0)&&(years % 400 == 0))) 
				{
					
					dates[increementValue] = date+"th "+allMonth[month]+" "+(years);
					increementValue++;
				}
				else
					{
					System.err.println(" ");
					}
			}
		else
			         System.err.println(" ");
    }
  System.out.println();

         String directoryName = "e:/datess";   //we ave to create folder with name proverbs in same location
         String textDate = "date.txt"; 
         String binaryDate = "binarydate.txt"; 
         
         File textFile =  new File(directoryName,textDate);
         File binaryFile =  new File(directoryName,binaryDate);
         
 		FileOutputStream textOutputStream = null;
 		FileOutputStream binaryOutputStream = null;
 		try
 		{
 			textOutputStream = new FileOutputStream(textFile,true);
 			textOutputStream = new FileOutputStream(binaryFile,true);
 			
 		}catch(FileNotFoundException e)
 		{
 			System.out.println("File not found");
 		      System.exit(1);
 		}
       
 		
 		//file will write here
 		String[] newDate=new String[dates.length];
 	try
 	{
 		FileWriter fileWriterObject = new FileWriter(textFile);
 		for(String date  : dates)
 		{
 			if(date != null)
 			{
 				fileWriterObject.write(date +String.format("%n"));	
 			}
 			
 			if(dates !=null)
 			{
 		     
 		    for(int i=0;i<dates.length;i++)
 		    {
 		    	//write logic for change order
 		    	String temp;
 		    	newDate[i] = dates.split(" ");
 		    	
 		    }
 			  
 			}
 			
 			
 		}
 		fileWriterObject.close();
 		System.out.println("Successfully wroted to the file.");
 	}catch(IOException e)
 		    {
 		    	System.out.println("Have some issues related to IO.please try again");
 		    	System.exit(0);
 		    }



		
		
	}

}
