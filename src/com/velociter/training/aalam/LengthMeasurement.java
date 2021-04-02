
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

public class LengthMeasurement 
{

	public static final int CENTIMETER_PER_METER = 100;
	public static final int MILLIMETER_PER_CENTIMETER = 10;
	public static final int MILLIMETER_PER_METER = 1000;
	
	// Private member variables:
	  private int meter ,centimeter, millimeter;

	  public LengthMeasurement()     
	  {
		//no-argument constructor
	  }
	  public LengthMeasurement(int meter ,int centimeter ,int millimeter )
	  {
		  if(meter>=0 && centimeter >=0 && millimeter >=0 )
		  {
			 meter = this.meter;
			 centimeter= this.centimeter;
			 millimeter = this.millimeter;
		  }else
		  {
			  System.out.println("Invalid Values.Please Try Again With Valid Values");
			  System.exit(1);
		  }
		 
	  }
	 
	  //to make it in Round figure value
	  public LengthMeasurement(double centiMeter )
	  {
		 
		 this((int)centiMeter * MILLIMETER_PER_CENTIMETER);
	  }
	   
	  public LengthMeasurement(int milliMeter)
	  {   
		if(milliMeter >=0)
		 {
		  meter = milliMeter / MILLIMETER_PER_METER;
		  centimeter = (milliMeter -meter * MILLIMETER_PER_METER)/ MILLIMETER_PER_CENTIMETER;
		  millimeter = milliMeter - meter * MILLIMETER_PER_METER - centimeter * MILLIMETER_PER_CENTIMETER;
		 }else
		 {
			 System.out.println("Invalid Values.Please Try Again With Valid Values");
			  System.exit(1); 
		 }
		  
	  }
	  
	 //override toString to display output in M,CM,MM
	  public String toString()
	  {
		  return Integer.toString(meter) + "m " + centimeter + "cm " + millimeter + "mm";
		                                                               
	  }
	  
	  
	  public int toMillimeter()
	  { 
		  
		  return meter * MILLIMETER_PER_METER + centimeter * MILLIMETER_PER_CENTIMETER + millimeter;  //mm is millimeter
	  }
	  
	 
	  
	  // All methods (add() ,substract(),divide(), multiply() use the changeIntoMillimeter()
	  //add()
	  public LengthMeasurement add(LengthMeasurement length)
	  {
	    return new LengthMeasurement(toMillimeter()+length.toMillimeter());    //14009 mm + 14.009 meter == 28m,1cm,8mm
	  }
	  
	  
	  //substract()
	  public LengthMeasurement subtract(LengthMeasurement length)
	  {
	    return new LengthMeasurement(toMillimeter()-length.toMillimeter());   // 14009 mm -14.009 meter ==
	  }
	  
	  //multiplication
	  public LengthMeasurement multiply(int multiplyValue)
	  {
	    return new LengthMeasurement(multiplyValue * toMillimeter());                             //  14009 mm * inputValue(eg.2)  ==28018
	  }
	  
	  //division
	  public LengthMeasurement divide(int divisibleValue)
	  {
	    return new LengthMeasurement(toMillimeter() / divisibleValue);
	  }
	  
	//Calculate area in square mm
	  public long area(LengthMeasurement length) {
	    return (toMillimeter() * length.toMillimeter());
	  }
	 
	
}
