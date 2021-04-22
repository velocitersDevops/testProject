/* 
  Create an array of String variables and initialize the array with the names of the months from
January to December. Create an array containing 12 random decimal values between 0.0 and
100.0. Display the names of each month along with the corresponding decimal value. Calculate
and display the average of the 12 decimal values
  
  */

package com.velociter.training.aalam.arrayAndString;
import java.text.DecimalFormat;

public class MonthWithDecimalValue 
{
	enum  MONTHS
	{
		January, February, March, April, May, June, July, August, September, October, November, December;
	}
	
	static DecimalFormat decimalFormat = new DecimalFormat("0.0"); 
	public static void main(String[] args) 
	{
		MONTHS getEnumMonth[] = MONTHS.values();
		String months ="";
		for(MONTHS enumMonth : getEnumMonth)
		{
			months = months+enumMonth+" ";
		}
		
		String month[] =months.split(" ");
        float randomNumber[] = new float[12];
        float sumOfNumbers =0;
        
        for(int i =0; i<randomNumber.length ; i++)     
        {
        	randomNumber[i] = (float)(100.0 *Math.random() + 0.0);    // Random class for generating 12 decimal value which is b/w 0.0 to 100.0
        	sumOfNumbers +=randomNumber[i]; 
           // System.out.println("number "+randomNumber[i]);  //debugging purpose
        }
        for(int i= 0 ; i<month.length ; i++)
        {
        	int space = month[8].length()-month[i].length();
        	StringBuilder stringbuilder = new StringBuilder();
        	for(int k=0;k<space;k++)
        	{
        		stringbuilder.append(" ");
        	}
        	System.out.println(month[i]+"   "+ stringbuilder +decimalFormat.format(randomNumber[i]));
        }
        
        float average =sumOfNumbers /randomNumber.length; 
        System.out.println("average "+"    "+average);
       
        
	}

}
