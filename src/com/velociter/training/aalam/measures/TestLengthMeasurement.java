
/*
 * Define a class, mcmLength, to represent a length measured in meters, centimeters, and millimeters,
each stored as integers. Include methods to add and subtract objects, to multiply and
divide an object by an integer value, to calculate an area resulting from the product of two
objects, and to compare objects. Include constructors that accept three arguments—meters, centimeters,
and millimeters; one integer argument in millimeters; one double argument in centimeters;
and no arguments, which creates an object with the length set to zero. Check the class
by creating some objects and testing the class operations.
 */
package com.velociter.training.aalam.measures;

public class TestLengthMeasurement {

	public static void main(String[] args) 
	{
		//creating array for LengthMeasurement[] class with size 4 witch hold 4 objects
		LengthMeasurement[] lengths  = new LengthMeasurement[4];
		
		//Testing all the constructor what we created inside the LengthMeasurement class
		lengths[0]   = new LengthMeasurement(1,40,5);    //call 3 arguments constructors
		lengths[1]   = new LengthMeasurement(339);         // call 1 int argument constructor
//		lengths[2]   = new LengthMeasurement(480.78);      // call 1 double argument constructor
//		lengths[3]   = new LengthMeasurement();            //call no-argument constructors
         System.out.println("========================INPUT==============================");
         System.out.println("");
		//display the object data
		for(int i = 0 ; i < lengths.length ; ++i) 
		{
		      System.out.println("Length of " + i +" "+"object is " + lengths[i]);
		}
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