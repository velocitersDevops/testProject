package com.velociter.training.aalam.streams;

public class FormatDoubleData 
{
	 public static void main(String[] args) 
	 {
		    double[] arraydata = new double[20];
		    
		    for (int i = 0 ; i<arraydata.length ; i++) 
		    {
		    	arraydata[i] = 100.0*Math.random() -50.0;   // after generate a value substrect 50  
		    }
		    int i = 0;
		    for(double x : arraydata) 
		    {
		      System.out.printf("%4d)%+9.2f", ++i, x);  // here 4 means 4space d reprect int value  
		      if(i%5 == 0)                              //and 9 represent after ')' 9 digit space with value
		                     {                          // and .2f represent after . 2 value can display 
		        System.out.println();                   
		      }
		    }
		  }

}
