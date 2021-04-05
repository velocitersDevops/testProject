package com.velociter.training.ankit.measurment;

public class TestWeightMeasurment {
	
	public static final int KILOGRAMS_PRT_TON = 1000;
	  public static final int GRAMS_PER_KILOGRAM = 1000;
	  public static final int GRAMS_PER_TON = GRAMS_PER_KILOGRAM*KILOGRAMS_PRT_TON;
	 int tons=0,kilograms=0,grams=0;
	 TestWeightMeasurment(){}
	TestWeightMeasurment(double kg)
	{
		 this((int)(kg*GRAMS_PER_KILOGRAM)); 
	}
	TestWeightMeasurment(int g)
	{
		    tons = g/GRAMS_PER_TON;
		    kilograms = (g - tons*GRAMS_PER_TON)/GRAMS_PER_KILOGRAM;
		    grams = g - tons*GRAMS_PER_TON - kilograms*GRAMS_PER_KILOGRAM;

	}
	
	  public TestWeightMeasurment(int t, int kg, int g) {
		    this(t*GRAMS_PER_TON + kg*GRAMS_PER_KILOGRAM + g);
		  }

	
	 public String toString() 
	 {
		    return Integer.toString(tons) + " tons " + kilograms + " kilogram " + grams + " gram";
     }
	 public int toGram()
     { 
		  return tons*GRAMS_PER_TON + kilograms*GRAMS_PER_KILOGRAM + grams;  //mm is millimeter
	  }
	 
	 public TestWeightMeasurment add(TestWeightMeasurment weigth)
	  {
	    return new TestWeightMeasurment(toGram()+weigth.toGram());    
	  }
	 
	 public TestWeightMeasurment subtract(TestWeightMeasurment weigth)
	  {
	    return new TestWeightMeasurment(toGram()-weigth.toGram());    
	  }
	 
	 public TestWeightMeasurment multiply(int multipleValue)
	  {
	    return new TestWeightMeasurment(multipleValue * toGram());                             
	  }
	 

	  public TestWeightMeasurment divide(int divideValue)
	  {
	    return new TestWeightMeasurment(toGram() / divideValue);
	  }
	
	public static void main(String ar[])
	{
		TestWeightMeasurment weight1 =new TestWeightMeasurment(12.00);
		TestWeightMeasurment weight2=new TestWeightMeasurment(12025);
		
		System.out.println(weight1.toString());
		System.out.println(weight2.toString());
		System.out.println("add :"+weight1.add(weight2));
		System.out.println("subtraction :"+weight1.subtract(weight2));
		System.out.println("multiplication of  "+weight1.toString()+" by 25 :"+weight1.multiply(25));
		System.out.println("multiplication of  "+weight2.toString()+" by 25 :"+weight2.multiply(25));
		System.out.println("Division :"+weight1.divide(9));
		System.out.println("Division :"+weight2.divide(9));
		
	}
}