/*
 * Define a class, WeightMeasurment, to represent a weight in tons, kilograms, and grams, and include a
similar range of methods and constructors as the previous example. Demonstrate this class by
creating and combining some class objects.
 */
package com.velociter.training.aalam.measures;

public class WeightMeasurment
{

	  public static final int KILOGRAM_PER_TON = 1000;
	  public static final int GRAMS_PER_KILOGRAM = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KILOGRAM * KILOGRAM_PER_TON;
	
	  // private member variables
	  private int tons = 0;
	  private int kilograms = 0;
	  private int grams = 0;
	  
	  // Constructors:
	  public WeightMeasurment()
	  {
		  //0- argument constructor
	  }
	  
	  // this is recursive constructors
	  public WeightMeasurment(double kiloGram)
	  {
		    this((int)kiloGram * GRAMS_PER_KILOGRAM);
	  }
	  
	  public WeightMeasurment(int gram) 
	  {
		  if(gram >=0)
		  {
		    tons = gram/GRAMS_PER_TON;
		    kilograms = (gram - tons * GRAMS_PER_TON) / GRAMS_PER_KILOGRAM;
		    grams = gram - tons * GRAMS_PER_TON - kilograms *  GRAMS_PER_KILOGRAM;
		  }
		  else
		  {
			  System.out.println("Invalid Values.Please Try Again With Valid Values");
			  System.exit(1); 
		  }
	  }
	  
	  public WeightMeasurment(int ton, int kiloGram, int gram) 
	  {
		    this(ton*GRAMS_PER_TON + kiloGram * GRAMS_PER_KILOGRAM + gram);
	  }
	 
	  // Display Object Data
	  public String toString()  
	  {
	    return (tons) +" "+ "ton " +"  "+ kilograms +" "+ "kilogram " + grams +" "+"grams";
	  }

	  //change into grams
	  public int toGrams() 
	  {
		  return tons * GRAMS_PER_TON + kilograms * GRAMS_PER_KILOGRAM + grams;
	  }
		 
	  public WeightMeasurment add(WeightMeasurment weightObject) 
	  {
		  return new WeightMeasurment(toGrams() + weightObject.toGrams());
	  }
		 
	  public WeightMeasurment subtract(WeightMeasurment weightObject) 
	  {
		  return new WeightMeasurment(toGrams() - weightObject.toGrams());
	  }
		 
	  public WeightMeasurment multiply(int multiplyByValue) 
	  {
		  return new WeightMeasurment(multiplyByValue * toGrams());
	  }
		 
	  public WeightMeasurment divide(int divideByValue) 
	  {
		  return new WeightMeasurment(toGrams()/divideByValue);
	  }
		   
}
