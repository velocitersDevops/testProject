package com.velociter.training.ankit.writingfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.velociter.training.ankit.writingfiles.DatesWriting.MONTH_ENUM;
public class WriteDateFilesBinary
{
public static String convertByteArraysToBinary(byte[] input)
{
    StringBuilder result = new StringBuilder();
    for (byte b : input) 
    {
        int val = b;
        for (int i = 0; i < 8; i++) 
        {
            result.append((val & 128) == 0 ? 0 : 1);      // 128 = 1000 0000
            val <<= 1;//Conversion left Shift.
        }
    }
    return result.toString();
}
public static String prettyBinary(String binary)
{
	return binary;
	
}


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
					datesWrite[count]=date+"st "+allMonth[month]+" "+(fullYear);
					count++;
				}
				
			}
			else if(date==29 && ((fullYear % 4 == 0)&&(fullYear % 100 == 0)&&(fullYear % 400 == 0))) 
			{
				datesWrite[count]=date+"th "+allMonth[month]+" "+(fullYear);
				count++;
				//System.out.println("Output Date="+date+"th "+allMonth[1]+" "+fullYear);
			}
				}
	
}



     String directoryName = "E:\\New folder";   
     String textDate = "date.txt"; 
     String binaryDate = "binarydate.bin"; 
     
     File textFile =  new File(directoryName,textDate);
     File binaryFile =  new File(directoryName,binaryDate);
     
		FileOutputStream textOutputStream = null;
		FileOutputStream binaryOutputStream = null;
		try
		{
			textOutputStream = new FileOutputStream(textFile,true);
			binaryOutputStream = new FileOutputStream(binaryFile,true);
			
		}catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		      System.exit(1);
		}
   
		
		//file will write here
		String newDate=null;
	try
	{
		FileWriter fileWriter = new FileWriter(textFile);
		FileWriter binaryData = new FileWriter(binaryFile);
		
		for(String date  : datesWrite)
		{
			if(date != null)
			{
				fileWriter.write(date +String.format("%n"));	
			}
			
			if(datesWrite !=null)
			{
				newDate =datesWrite.toString();
				String result = convertByteArraysToBinary(newDate.getBytes(StandardCharsets.UTF_8));
				System.out.println(prettyBinary(result));
				binaryData.write(prettyBinary(result));
//				System.out.println("Successfully written Binary data to the file");
			}
			
			
		}
		binaryData.close();
	
		fileWriter.close();
		System.out.println("Successfully wroted to the file.");
	}catch(IOException e)
		    {
		    	System.out.println("Have some issues related to IO.please try again");
		    	System.exit(0);
		    }
	
}

}
