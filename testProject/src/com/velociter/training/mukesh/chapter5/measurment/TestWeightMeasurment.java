package com.velociter.training.mukesh.measurment;

class WeightMeasurment {
	  public static final int KILOGRAMS_PER_TON = 1000;
	  public static final int GRAMS_PER_KILOGRAM = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KILOGRAM*KILOGRAMS_PER_TON;
	 
	  // private member variables
	  private int tons = 0;
	  private int kilograms = 0;
	  private int grams = 0;
	 
	  // Constructors:
	  public WeightMeasurment(double kg) 
	{
	    this((int)Math.round(kg*GRAMS_PER_KILOGRAM));
	  }
	 
	  public WeightMeasurment(int g)
	 {
	    tons = g/GRAMS_PER_TON;
	    kilograms = (g - tons*GRAMS_PER_TON)/GRAMS_PER_KILOGRAM;
	    grams = g - tons*GRAMS_PER_TON - kilograms*GRAMS_PER_KILOGRAM;
	  }
	 
	  public WeightMeasurment(int t, int kg, int g)
	 {
	    this(t*GRAMS_PER_TON + kg*GRAMS_PER_KILOGRAM + g);
	  }
	 
	  public WeightMeasurment()
	{
	}
	 
	  // Methods
	  public String toString()  {
	    return Integer.toString(tons) + "t " + kilograms + "kg " + grams + "g";
	  }
	 
	  public int toGrams() {
	    return tons*GRAMS_PER_TON + kilograms*GRAMS_PER_KILOGRAM + grams;
	  }
	 
	  public double toKilograms() {
	    return ((double)toGrams())/GRAMS_PER_KILOGRAM;
	  }
	 
	  public WeightMeasurment add(WeightMeasurment weight) {
	    return new WeightMeasurment(toGrams() + weight.toGrams());
	  }
	 
	  public WeightMeasurment subtract(WeightMeasurment weight) {
	    return new WeightMeasurment(toGrams() - weight.toGrams());
	  }
	 
	  public WeightMeasurment multiply(int n) {
	    return new WeightMeasurment(n*toGrams());
	  }
	 
	  public WeightMeasurment divide(int n) {
	    return new WeightMeasurment(toGrams()/n);
	  }
	 
	  // Compare two weights
	  // Return value is 1 if current greater than arg
	  //                 0 if current equal to arg
	  //                -1 if current less than arg
	  public int compare(WeightMeasurment weight) {
	    return greaterThan(weight) ? 1 : (equals(weight) ? 0 : -1);
	  }
	 
	  public boolean equals(WeightMeasurment weight) {
	    return toGrams() == weight.toGrams();
	  }
	 
	  public boolean lessThan(WeightMeasurment weight) {
	    return toGrams() < weight.toGrams();
	  }
	 
	  public boolean greaterThan(WeightMeasurment weight) {
	    return toGrams() > weight.toGrams();
	  }
	}

public class TestWeightMeasurment 
{
	public static void main(String args[]) {
		   // Test the constructors
		    WeightMeasurment[] weights = {
		                             new WeightMeasurment(274.65) , new WeightMeasurment(274),
		                             new WeightMeasurment(274,2,3), new WeightMeasurment()
		                          };
		 
		    //Display the weights
		    for(int i = 0 ; i < weights.length ; ++i)
		    System.out.println("Weight " + i + " is " + weights[i]);
		 
		   // Test the operations
		    System.out.println("Addition: " + weights[0] + " plus " + weights[1] + " is " + weights[0].add(weights[1]));
		    System.out.println("Subtraction: " + weights[0] + " minus " + weights[1] + " is " + weights[0].subtract(weights[1]));
		    System.out.println("Multiplication: "+ weights[0] + " times 10 is " + weights[0].multiply(10));
		    System.out.println("Division: " + weights[0] + " divided by 10 is " + weights[0].divide(10));
		 
		    // Test comparison methods
		    if(weights[0].greaterThan(weights[1])) {
		      System.out.println("Weight "+ weights[0] + " is greater than length " + weights[1]);
		    } else if(weights[0].lessThan(weights[1])) {
		      System.out.println("Weight "+ weights[0] + " is less than length " + weights[1]);
		    } else {
		      System.out.println("Weight "+ weights[0] + " is the same length as length " + weights[1]);
		    }
		 
		    // Compare successive weights using compare() method
		    String compareStr = null;
		    for(int i = 0 ; i < weights.length - 1 ; ++i) {
		      switch(weights[i].compare(weights[i+1])) {
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
		      System.out.println("Weight " + weights[i] + compareStr + weights[i+1]);
		    }
		  }
	
}
