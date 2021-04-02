package com.velociter.training.vivek.chapter5.weightMeaurement;

public class WeightMeasurement

 { 
	public static final int KILOGRAMS_PER_TON = 1000;
	  public static final int GRAMS_PER_KILOGRAM = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KILOGRAM*KILOGRAMS_PER_TON;
	 
	  // private member variables
	  private int tons = 0;
	  private int kilograms = 0;
	  private int grams = 0;
	 
	  // Constructors:
	  public WeightMeasurement(double kg) 
	  {
	    this((int)Math.round(kg*GRAMS_PER_KILOGRAM));
	  }
	 
	  public WeightMeasurement(int g)
	  {
	    tons = g/GRAMS_PER_TON;
	    kilograms = (g - tons*GRAMS_PER_TON)/GRAMS_PER_KILOGRAM;
	    grams = g - tons*GRAMS_PER_TON - kilograms*GRAMS_PER_KILOGRAM;
	  }
	 
	  public WeightMeasurement(int t, int kg, int g) 
	  {
	    this(t*GRAMS_PER_TON + kg*GRAMS_PER_KILOGRAM + g);
	  }
	 
	  public WeightMeasurement(){}
	 
	  // Methods
	  public String toString() 
	  {
	    return Integer.toString(tons) + "t " + kilograms + "kg " + grams + "g";
	  }
	 
	  public int toGrams()
	  {
	    return tons*GRAMS_PER_TON + kilograms*GRAMS_PER_KILOGRAM + grams;
	  }
	 
	  public double toKilograms()
	  {
	    return ((double)toGrams())/GRAMS_PER_KILOGRAM;
	  }
	 
	  public WeightMeasurement add(WeightMeasurement weight)
	  {
	    return new WeightMeasurement(toGrams() + weight.toGrams());
	  }
	 
	  public WeightMeasurement subtract(WeightMeasurement weight)
	  {
	    return new WeightMeasurement(toGrams() - weight.toGrams());
	  }
	 
	  public WeightMeasurement multiply(int n)
	  {
	    return new WeightMeasurement(n*toGrams());
	  }
	 
	  public WeightMeasurement divide(int n)
	  {
	    return new WeightMeasurement(toGrams()/n);
	  }
	 
	  // Compare two weights
	  // Return value is 1 if current greater than arg
	  //                 0 if current equal to arg
	  //                -1 if current less than arg
	  public int compare(WeightMeasurement weight)
	  {
	    return greaterThan(weight) ? 1 : (equals(weight) ? 0 : -1);
	  }
	 
	  public boolean equals(WeightMeasurement weight)
	  {
	    return toGrams() == weight.toGrams();
	  }
	 
	  public boolean lessThan(WeightMeasurement weight) 
	  {
	    return toGrams() < weight.toGrams();
	  }
	 
	  public boolean greaterThan(WeightMeasurement weight) {
	    return toGrams() > weight.toGrams();
	  }
	}


 
