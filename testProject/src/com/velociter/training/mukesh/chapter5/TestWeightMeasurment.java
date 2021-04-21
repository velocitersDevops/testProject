package com.velociter.training.mukesh.chapter5;

class WeightMeasurment {
	  public static final int KILOGRAMS_PER_TON = 1000;
	  public static final int GRAMS_PER_KILOGRAM = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KILOGRAM*KILOGRAMS_PER_TON;
	 
	  // private member variables
	  private int tons = 0;
	  private int kilograms = 0;
	  private int grams = 0;
	 
	  // Constructors:
	  public WeightMeasurment(double kilogram) 
	{
	    this((int)Math.round(kilogram*GRAMS_PER_KILOGRAM));
	  }
	 
	  public WeightMeasurment(int gram)
	 {
		  if(gram>0)
		  {
			    tons = gram/GRAMS_PER_TON;
			    kilograms = (gram - tons*GRAMS_PER_TON)/GRAMS_PER_KILOGRAM;
			    grams = gram - tons*GRAMS_PER_TON - kilograms*GRAMS_PER_KILOGRAM;
		  }else
			  System.out.println("provide only positive number");
	  }
	 
	  public WeightMeasurment(int ton, int kilogram, int gram)
	 {
	    this(ton*GRAMS_PER_TON + kilogram*GRAMS_PER_KILOGRAM + gram);
	  }
	 
	  public WeightMeasurment()
	{
	}
	 
	  // Methods
	  public String toString()  {
	    return tons + "t " + kilograms + "kg " + grams + "g";
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
	  // Return value is 1 if current greater than argument
	  //                 0 if current equal to argument
	  //                -1 if current less than argument
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
	public static void main(String args[])
	{
			
		    WeightMeasurment[] weights = new WeightMeasurment[4];
		    weights[0]=	new WeightMeasurment(274.65);	
		    weights[1]=	new WeightMeasurment(274);                         
		    weights[2]=	new WeightMeasurment(274,2,3);
		    weights[3]=	new WeightMeasurment();                     
		 
		    //Display the weights
		    System.out.println("--------------------INPUT--------------------");
		    for(int i = 0 ; i < weights.length ; ++i)
		    System.out.println("Weight " + i + " is " + weights[i]);
		 
		   // Test the operations
		    System.out.println("--------------------OPERATIONs--------------------");
		    System.out.println("Addition: " +"("+ weights[0] + ")"+" + " + "("+weights[1] +")"+ " =" + weights[0].add(weights[1]));
		    System.out.println("Subtraction: " +"("+ weights[0] +")"+ " - " +"("+ weights[1] +")"+ " = " + weights[0].subtract(weights[1]));
		    System.out.println("Multiplication: "+"("+ weights[0] + ")"+" * 10 = " + weights[0].multiply(10));
		    System.out.println("Division: " + "("+weights[0] +")"+ " / 10 = " + weights[0].divide(10));
		    System.out.println();
		 
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
