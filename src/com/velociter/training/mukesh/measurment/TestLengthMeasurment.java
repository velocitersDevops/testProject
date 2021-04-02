
/*PROBLEM DISCREPTION:

Define a class, LengthMeasurment, to represent a length measured in meter, centimeter, and millimeter, each
stored as integers. 

Include methods:
 
1.	to add and subtract objects, 
2.	to multiply and divide an object by an integer value, 
3.	to calculate an area resulting from the product of two objects, 
4.	and to compare objects.

Include constructors:
 
1.	that accept three arguments — meter, centimeter, and millimeter; 
2.	one integer argument in millimeter; 
3.	one double argument in centimeter; 
4.	and no arguments, which creates an object with the length set to zero. 

Check the class by creating some objects and testing the class operations.
 */
 


package com.velociter.training.mukesh.measurment;

class LengthMeasurment 
{
	  public static final int CENTIMETER_PER_METER = 100;
	  public static final int MILLIMETER_PER_CENTIMETER = 10;
	  public static final int MILLIMETER_PER_METER = MILLIMETER_PER_CENTIMETER * CENTIMETER_PER_METER;
	 
	
	// Private member variables:
	  private int meter = 0;
	  private int centimeter = 0;
	  private int millimeter = 0;
	 
	// Constructors
	  
	  
	  public LengthMeasurment(double centiMeter)									//one argument constructor pass as double data type 
	  {
		    this((int)Math.round(centiMeter*MILLIMETER_PER_CENTIMETER));
		    
	  }
	 
	   
	  public LengthMeasurment(int milliMeter)										//one argument constructor pass as integer data type
	  {
		     
		  	meter = milliMeter/MILLIMETER_PER_METER;
		  
		    centimeter = (milliMeter - meter*MILLIMETER_PER_METER)/MILLIMETER_PER_CENTIMETER;
		  
		    millimeter = milliMeter - meter*MILLIMETER_PER_METER - centimeter*MILLIMETER_PER_CENTIMETER;
		 
	  }
	 
	  
	  public LengthMeasurment(int meters, int centimeters, int millimeters) 					//three argument constructor pass as integer type
	  {
		    this(meters*MILLIMETER_PER_METER + centimeters*MILLIMETER_PER_CENTIMETER + millimeters);
	  }
	  
	  public LengthMeasurment()																		//no-argument constructor
	  {
		  
	  }
	  
	  public String toString() 
	  {
		    return meter + "m " + centimeter + "cm " + millimeter + "mm";
	  }
	  
	  //methods 
	  
	  public int toMillimeter()
	  {
		    return meter*MILLIMETER_PER_METER + centimeter*MILLIMETER_PER_CENTIMETER + millimeter;
	  }
	  
	  public double toMeter() 
	  {
		    return meter + ((double)(centimeter))/CENTIMETER_PER_METER + ((double)(millimeter))/MILLIMETER_PER_METER;
	  }
	  
	  
	  public LengthMeasurment add(LengthMeasurment length)
	  {
	    return new LengthMeasurment(toMillimeter()+length.toMillimeter());
	  }
	 

	 
	  public LengthMeasurment subtract(LengthMeasurment length)
	  {
	    return new LengthMeasurment(toMillimeter()-length.toMillimeter());
	  }
	 
	  public LengthMeasurment multiply(int n)
	  {
	    return new LengthMeasurment(n*toMillimeter());
	  }
	 
	  public LengthMeasurment divide(int y)
	  {
	    return new LengthMeasurment(toMillimeter()/y);
	  }
	 
	  //Calculate area in square milliMeter
	  public long area(LengthMeasurment length) 
	  {
	    return (toMillimeter()*length.toMillimeter());
	  }
	  
	  
	// Compare two lengths
	  // Return value is 1 if current greater than argument
	  //                 0 if current equal to argument
	  //                -1 if current less than argument
	  public int compare(LengthMeasurment length) {
	    return greaterThan(length) ? 1 : (equals(length) ? 0 : -1);
	  }
	 
	  public boolean equals(LengthMeasurment length) {
	   return toMillimeter() == length.toMillimeter();
	  }
	 
	  public boolean lessThan(LengthMeasurment length) {
	   return toMillimeter() < length.toMillimeter();
	  }
	 
	  public boolean greaterThan(LengthMeasurment length) {
	   return toMillimeter() > length.toMillimeter();
	  }
	
}


 // TestLength class contain main method body
 public class TestLengthMeasurment
{
	public static void main(String[] args) 
	{
		LengthMeasurment[] lengths = new LengthMeasurment[4];
		
		// Test the constructors:
		    lengths[0] = new LengthMeasurment(274.65);				//double value  argument
		    lengths[1] = new LengthMeasurment(274);				//integer value argument
		    lengths[2] = new LengthMeasurment(274,2,3);			// integer value arguments 
		    lengths[3] = new LengthMeasurment();// no-arguments
		    
		    //Display the figures:
		    System.out.println("--------------------INPUT--------------------");
		    System.out.println();
		    for(int i = 0 ; i < lengths.length ; ++i) {
		      System.out.println("Length " + i + " is " + lengths[i]);
		    }
		    
		   
		    System.out.println("--------------------OUTPUT--------------------");
		    System.out.println();
		    System.out.println("Addition: " + "("+lengths[0]+")" + " + " +"("+ lengths[1]+")" + " = " + lengths[0].add(lengths[1]));
		    System.out.println();
		    System.out.println("Subtraction: " +"("+ lengths[0] +")"+ " - " + "("+lengths[1]+")"+ " = " + lengths[0].subtract(lengths[1]));
		    System.out.println();
		    System.out.println("Multiplication: " + "("+lengths[0] +")"+ " * 10 = " + lengths[0].multiply(10));
		    System.out.println();
		    System.out.println("Division: " +"("+ lengths[0] + ")"+" / 10 = " + lengths[0].divide(10));
		    System.out.println();
		    System.out.println("Area: "  +"(" +lengths[0] + ")"+" * " +"("+ lengths[1] +")"+ "= " + lengths[0].area(lengths[1]) + " square milliMeter");
		    System.out.println();
		 
		 // Test comparison methods
		    if(lengths[0].greaterThan(lengths[1])) {
		      System.out.println("Length "+ lengths[0] + " is greater than length " + lengths[1]);
		    } else if(lengths[0].lessThan(lengths[1])) {
		      System.out.println("Length "+ lengths[0] + " is less than length " + lengths[1]);
		    } else {
		      System.out.println("Length "+ lengths[0] + " is the same length as length " + lengths[1]);
		    }
		 
		    // Compare successive lengths using compare() method
		    String compareStr = null;
		    for(int i = 0 ; i < lengths.length-1 ; ++i) {
		      switch(lengths[i].compare(lengths[i+1])) {
		        case -1:
		         compareStr = " is less than length ";
		         break;
		        case 0:
		         compareStr = " is equal to length ";
		         break;
		        case 1:
		         compareStr = " is greater than length ";
		         break;
		      }
		      System.out.println("Length " + lengths[i] + compareStr + lengths[i+1]);
		    }
		  }
		    
	
	
	
	
	
}