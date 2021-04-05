
/*
 * Define a class, mcmLength, to represent a length measured in meters, centimeters, and millimeters,
each stored as integers. Include methods to add and subtract objects, to multiply and
divide an object by an integer value, to calculate an area resulting from the product of two
objects, and to compare objects. Include constructors that accept three arguments—meters, centimeters,
and millimeters; one integer argument in millimeters; one double argument in centimeters;
and no arguments, which creates an object with the length set to zero. Check the class
by creating some objects and testing the class operations.
 */
package com.velociter.training.aalam;

import java.util.Scanner;

public class TestLengthMeasurement {

	public static void main(String[] args) 
	{
		//creating array for LengthMeasurement[] class with size 4 witch hold 4 objects
		LengthMeasurement[] lengths  = new LengthMeasurement[2];
		
		//Testing all the constructor what we created inside the LengthMeasurement class
		Scanner sc = new Scanner(System.in);
		 System.out.println("========================INPUT==============================");
         System.out.println("");
		System.out.println("Enter 1 st Length value in centimeter ");
		double centimeter = sc.nextDouble();
		if(centimeter >= 0)
		{
			 System.out.println("first input weight value is :"+centimeter+"  "+"kilograms");
		     lengths[0]   = new LengthMeasurement(centimeter);
		}
		else
		{
			System.err.println("Invalid Input ,Try again With Valid Input");
			System.exit(1);
		}
		
		System.out.println("Enter 2 nd Length value in meter,centimeter , millimeter ");
		System.out.println("enter value in meter");
		int meter = sc.nextInt();
		System.out.println("enter value in centimeters");
		int centemeter = sc.nextInt();
		System.out.println("enter value in millimeter");
		int millimeter = sc.nextInt();
		  if(meter>=0 && centemeter >=0 && millimeter >=0 )
		  {
			  System.out.println("second input weight value is :"+meter+"  "+"meter"+"   "+centemeter+" "+"centiMeter   "+millimeter+"  "+"milliMeter");
			  lengths[1]   = new LengthMeasurement(meter,centemeter,millimeter);         // call 1 int argument constructor
		  }
		  else
		  {
			  System.err.println("Invalid Input ,Try again With Valid Input");
				System.exit(1); 
		  }
    	
//		//display the object data
//		for(int i = 0 ; i < lengths.length ; ++i) 
//		{
//		      System.out.println("Length of " + i +" "+"object is " + lengths[i]);
//		}
		 System.out.println("");
		 System.out.println("===========================OUTPUT=============================");
		 System.out.println("");
		 // Test the arithmetic and area operations
		
		 System.out.println("Addition of 2 length objects : ("+lengths[0]+" +  " +lengths[1] +")  = "+ lengths[0].add(lengths[1]));
		 System.out.println("Substraction of 2 length objects : ("+lengths[0]+" -  " +lengths[1] +")  = "+ lengths[0].subtract(lengths[1]));
		 System.out.println("Multiplication  of  : ("+lengths[0]+" *  " +5  +")  = "+ lengths[0].multiply(5));   //multiply by 5
		 System.out.println("Division : ("+lengths[0]+" /  " +8  +")  = "+ lengths[0].divide(8));
		  System.out.println("Area of 2 object "  + lengths[0] + " by " + lengths[1] + " is " + lengths[0].area(lengths[1]) + " square mm");
	
	}

}