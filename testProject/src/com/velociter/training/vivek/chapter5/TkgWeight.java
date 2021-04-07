package com.velociter.training.vivek.chapter5;

public class TkgWeight 
{
	public static final int KG_PER_TON = 1000;
	  public static final int GRAMS_PER_KG = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KG*KG_PER_TON;

	  // private member variables
	  private int tons = 0;
	  private int kilograms = 0;
	  private int grams = 0;

	  // Constructors:
	  public TkgWeight(double kg) {    
	    this((int)Math.round(kg*GRAMS_PER_KG));
	  }

	  public TkgWeight(int g) {
	    tons = g/GRAMS_PER_TON;    
	    kilograms = (g - tons*GRAMS_PER_TON)/GRAMS_PER_KG;
	    grams = g - tons*GRAMS_PER_TON - kilograms*GRAMS_PER_KG;
	  }

	  public TkgWeight(int t, int kg, int g) {
	    this(t*GRAMS_PER_TON + kg*GRAMS_PER_KG + g);
	  }

	  public TkgWeight(){}

	  // Methods
	  public String toString()  {
	    return Integer.toString(tons) + "t " + kilograms + "kg " + grams + "g";
	  }

	  public int toGrams() {
	    return tons*GRAMS_PER_TON + kilograms*GRAMS_PER_KG + grams;
	  }

	  public double toKilograms() {
	    return ((double)toGrams())/GRAMS_PER_KG;
	  }

	  public TkgWeight add(TkgWeight weight) {
	    return new TkgWeight(toGrams() + weight.toGrams());
	  }

	  public TkgWeight subtract(TkgWeight weight) {
	    return new TkgWeight(toGrams() - weight.toGrams());
	  }

	  public TkgWeight multiply(int n) {
	    return new TkgWeight(n*toGrams());
	  }

	  public TkgWeight divide(int n) {
	    return new TkgWeight(toGrams()/n);
	  }

	  // Compare two weights 
	  // Return value is 1 if current greater than arg
	  //                 0 if current equal to arg
	  //                -1 if current less than arg

	  public int compare(TkgWeight weight) {
	    return greaterThan(weight) ? 1 : (equals(weight) ? 0 : -1);
	  }

	  public boolean equals(TkgWeight weight) {
	  	return toGrams() == weight.toGrams();
	  }

	  public boolean lessThan(TkgWeight weight) {
	  	return toGrams() < weight.toGrams();
	  }

	  public boolean greaterThan(TkgWeight weight) {
	  	return toGrams() > weight.toGrams();
	  }
}
