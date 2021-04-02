package com.velociter.training.vivek.chapter5.unitMeasurement;

public class LengthMeasurment 
 {
	public static final int CENTIMETER_PER_METER = 100;
	  public static final int MILLIMETER_PER_CENTIMETER = 10;
	  public static final int MILLIMETER_PER_METER = MILLIMETER_PER_CENTIMETER*CENTIMETER_PER_METER;
	 
	  // Private member variables:
	  private int meters = 0;
	  private int centimeters = 0;
	  private int millimeters = 0;
	 
	  // Constructors:
	  public LengthMeasurment(double centi_meter)
	  {
	    this((int)Math.round(centi_meter*MILLIMETER_PER_CENTIMETER));
	  }
	 
	  public LengthMeasurment(int milli_meter)
	  {
	    meters = milli_meter/MILLIMETER_PER_METER;
	    centimeters = (milli_meter - meters*MILLIMETER_PER_METER)/MILLIMETER_PER_CENTIMETER;
	    millimeters = milli_meter - meters*MILLIMETER_PER_METER - centimeters*MILLIMETER_PER_CENTIMETER;
	  }
	 
	  // If we were to just store the argument values, we could
	  // end up with invalid milli_meter and centi_meter values in the object if the
	  // values passed as arguments are not valid.
	  // With the approach here we guarantee all values are valid
	  // in the object that is created.
	  public LengthMeasurment(int m, int centi_meter, int milli_meter)
	  {
	    this(m*MILLIMETER_PER_METER + centi_meter*MILLIMETER_PER_CENTIMETER + milli_meter);
	  }
	 
	  public LengthMeasurment()
	  {
		  
	  }
	 
	  // Methods
	  // Replaces the default toString method in Object:
	  public String toString()
	  {
	    return meters + "m " + centimeters + "cm " + millimeters + "mm";
	  }
	 
	  public int toMilliMeter() 
	  {
		  //System.out.println("return type of the to millimeter"+ meters*MILLIMETER_PER_METER + centimeters*MILLIMETER_PER_CENTIMETER + millimeters);
	    return meters*MILLIMETER_PER_METER + centimeters*MILLIMETER_PER_CENTIMETER + millimeters;
	    
	  }
	 
	 
	  public double toMeters() 
	  {
	    return meters + ((double)(centimeters))/CENTIMETER_PER_METER + ((double)(millimeters))/MILLIMETER_PER_METER;
	  }
	 
	  // All of the following methods use the toMilliMeter():
	  public LengthMeasurment add(LengthMeasurment length)
	  {
		System.out.println("measurement of To millim"+toMilliMeter());  
	    return new LengthMeasurment(toMilliMeter()+length.toMilliMeter());
	  }
	 
	  public LengthMeasurment subtract(LengthMeasurment length)
	  {
	    return new LengthMeasurment(toMilliMeter()-length.toMilliMeter());
	  }
	 
	  public LengthMeasurment multiply(int n)
	  {
	    return new LengthMeasurment(n*toMilliMeter());
	  }
	 
	  public LengthMeasurment divide(int y)
	  {
	    return new LengthMeasurment(toMilliMeter()/y);
	  }
	 
	  //Calculate area in square milli_meter
	  public long area(LengthMeasurment length)
	  {
	    return (toMilliMeter()*length.toMilliMeter());
	  }
	 
	  // Compare two lengths
	  // Return value is 1 if current greater than arg
	  //                 0 if current equal to arg
	  //                -1 if current less than arg
	  public int compare(LengthMeasurment length)
	  {
	    return greaterThan(length) ? 1 : (equals(length) ? 0 : -1);
	  }
	 
	  public boolean equals(LengthMeasurment length)
	  {
	   return toMilliMeter() == length.toMilliMeter();
	  }
	 
	  public boolean lessThan(LengthMeasurment length)
	  {
	   return toMilliMeter() < length.toMilliMeter();
	  }
	 
	  public boolean greaterThan(LengthMeasurment length)
	  {
	   return toMilliMeter() > length.toMilliMeter();
	  }
	}
	
 
