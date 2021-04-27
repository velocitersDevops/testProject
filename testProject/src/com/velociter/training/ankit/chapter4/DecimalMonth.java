//Create an array of String variables and initialize the array with the names of the months from
//January to December. Create an array containing 12 random decimal values between 0.0 and
//100.0. Display the names of each month along with the corresponding decimal value. Calculate
//and display the average of the 12 decimal values.
package com.velociter.training.ankit.chapter4;
import java.text.DecimalFormat;

public class DecimalMonth {
	static DecimalFormat decimalFormat = new DecimalFormat("0.00");
  enum MONTH_ENUM{January,February, March, April, May, June, July, August, September, October, November, December}
	public static void randomMonth()
  {   
		
		MONTH_ENUM[] monthsEnum= MONTH_ENUM.values();//return all values present inside the enum.
		String fetchMonth="";
		for (MONTH_ENUM monthName : monthsEnum) {
    
			fetchMonth=fetchMonth+monthName+" ";
      }
		String monthNames[]=fetchMonth.split(" ");
		
		double randomValue[]=new double[monthNames.length];
  	double averageValue=0.0;
  	for(int i=0;i<randomValue.length;i++)
  	{
  		randomValue[i]=(Math.random()*100.0);
  		averageValue +=randomValue[i];
  	}
  	for(int j=0;j<randomValue.length;j++)
  	{
  		System.out.print(monthNames[j]+"=");
  		int space= monthNames[8].length() - monthNames[j].length();
  		for(int k=0;k<=space;k++)
  		{
  			System.out.print(" ");
  		}
  		System.out.print(decimalFormat.format(randomValue[j]));
  		System.out.println();
  	}
  	System.out.println("Average of decimals"+"  ="+decimalFormat.format(averageValue/randomValue.length));
  	
  }
	public static void main(String ae[])
      {
      	randomMonth();
      }
}

