package com.velociter.training.aalam.streams;

import java.util.Formatter;

public class FormatToString
{

	public static void main(String[] args) 
	{ 
		double[] arraydata = new double[20];
    
    for (int i = 0 ; i<arraydata.length ; i++) 
    {
    	arraydata[i] = 100.0* Math.random()-50.0;
    }

             // Buffer to hold output
    Formatter formatter = new Formatter();         // Formatter to format data into buf
    int i = 0;
    for(double x : arraydata) 
    {
      formatter.format("%4d)%+7.2f", ++i, x);     // here x is a generated double value and i represent index value  
      if(i%5 == 0)
      {
        formatter.format("%n");
      }
    }
    System.out.println(formatter);                          // Output all the values in one go
  }
}
