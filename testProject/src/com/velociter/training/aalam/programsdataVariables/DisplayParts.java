package com.velociter.training.aalam.programsdataVariables;

public class DisplayParts
{
  public static void main(String[] args)
	{
	  
	  // Initialize a double variable to some value (1234.5678):
	    double doubleValue = 1234.5678;
	    long integralValue = 0;
	    short fractionalValue = 0;
	    int decimalPlaces = 4;

	    // Find the integer part:
	    integralValue = (long)doubleValue;
	    // Find the number of Decimal places:
	 
	    fractionalValue = (short)((doubleValue-integralValue)*Math.pow(10,decimalPlaces));	   
	    System.out.println("The integral part of " + doubleValue + " is " + integralValue); 
	    System.out.println("The fractional part to "+ decimalPlaces +" decimal places is " + fractionalValue);
	}

}
