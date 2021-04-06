package com.velociter.training.ankit.measurment;

public class TestLengthMeasurment {
	
	  public static  final int CENTIMETER_PER_METER = 100;
	  public static final int MILLIMETER_PER_CENTIMETER = 10;
	  public static final int MILLIMETER_PER_METER = 1000;
	 
	int meter=0,centimeter=0,millimeter=0;
	TestLengthMeasurment()
	{}
	TestLengthMeasurment(double centiMeter)
	{
		 this((int)(centiMeter*MILLIMETER_PER_CENTIMETER)); 
	}
	TestLengthMeasurment(int milliMeter)
	{
		meter = milliMeter/MILLIMETER_PER_METER;
	    centimeter = (milliMeter - meter*MILLIMETER_PER_METER)/MILLIMETER_PER_CENTIMETER;
	    millimeter = milliMeter - meter*MILLIMETER_PER_METER - centimeter*MILLIMETER_PER_CENTIMETER;
	}
	
	 public TestLengthMeasurment(int meters, int centimeters, int millimeters) {
		    this(meters*MILLIMETER_PER_METER + centimeters*MILLIMETER_PER_CENTIMETER + millimeters);
		  }
	
	 public String toString() {
		    return Integer.toString(meter) + " Meter " + centimeter + " centiMeter " + millimeter + " milliMeter";
		  }
	 
	 public int toMillimeter()
      { 
		  return meter*MILLIMETER_PER_METER + centimeter*MILLIMETER_PER_CENTIMETER + millimeter;  //milliMeter is millimeter
	  }
	 
	 public double toMeter()
	 {
		 return meter + ((double)(centimeter))/CENTIMETER_PER_METER + ((double)(millimeter))/MILLIMETER_PER_METER;
	 }
	 
	 
	 public TestLengthMeasurment add(TestLengthMeasurment length)
	  {
	    return new TestLengthMeasurment(toMillimeter()+length.toMillimeter());    
	  }
	 
	 public TestLengthMeasurment subtract(TestLengthMeasurment length)
	  {
	    return new TestLengthMeasurment(toMillimeter()-length.toMillimeter());    
	  }
	 
	 public TestLengthMeasurment multiply(int multipleValue)
	  {
	    return new TestLengthMeasurment(multipleValue * toMillimeter());                             
	  }
	 

	  public TestLengthMeasurment divide(int divideValue)
	  {
	    return new TestLengthMeasurment(toMillimeter() / divideValue);
	  }
	  
	  public long area(TestLengthMeasurment length) {
		    return (toMillimeter()*length.toMillimeter());
		  }
	  

	public static void main(String ar[])
	{
		TestLengthMeasurment value = new TestLengthMeasurment(12.4);
		TestLengthMeasurment value1=new TestLengthMeasurment(858581);
		System.out.println(value.toString());
		System.out.println(value1.toString());
		System.out.println("Addition of :"+value+" to "+value1+" = "+value.add(value1));
		System.out.println("subtraction :"+value+" to "+value1+" = "+value.subtract(value1));
		System.out.println("multiplication of  "+value.toString()+" by 10 ="+value.multiply(20));
		System.out.println("multiplication of  "+value1.toString()+" by 10 ="+value1.multiply(20));
		System.out.println("Division :"+value.divide(10));
		System.out.println("Division :"+value1.divide(10));
		System.out.println("Area: "  + value + " by " + value1 + " is " + value.area(value1) + " square mm");
	
	}
	
}