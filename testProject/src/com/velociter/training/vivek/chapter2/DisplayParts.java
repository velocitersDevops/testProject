package com.velociter.training.vivek.chapter2;

public class DisplayParts
{
	 public static void main(String args[]) 
	  {
	    double myNumber = 1234.5678;
	    long integerPart = 0;
	    short fractionPart = 0;
	    int decimalPlaces = 4;

	    // Find the integer part:
	    integerPart = (long)myNumber;
	    
	    // Find the number of Decimal places:
	    fractionPart = (short)((myNumber-integerPart)*(10000));

	    System.out.println("The integral part of " + myNumber + " is " + integerPart); 
	    
	    System.out.println("The fractional part to "+ decimalPlaces +" decimal places is " + fractionPart);
	    
	  }
}
