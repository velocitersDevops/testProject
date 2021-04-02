
/*
 *Put both the previous classes in a package called Measures. Import this package into a program
that will calculate and display the total weight of the following: 200 carpets—size: 4 meters by
2 meters 9 centimeters, that weigh 1.25 kilograms per square meter; and 60 carpets—size: 3
meters 57 centimeters by 5 meters, that weigh 1.05 kilograms per square meter. */

package com.velociter.training.aalam.measures;

public class Carpet 
{
	public static void main(String args[]) 
	{
		//this is for  length of carpet object
		LengthMeasurement[] carpetLengths = {
				                             new LengthMeasurement(4,0,0),
				                             new LengthMeasurement(3,57,0) 
				                             };  
		//this is for  width of carpet object
		LengthMeasurement[] carpetWidths = { 
				                             new LengthMeasurement(2,9,0), 
				                             new LengthMeasurement(5,0,0) 
				                            };
		
		 // Weight per sq m of carpets
	    double[] carpetWtPerSqM = { 1.25, 1.05 };                         
	    int[] carpetCounts = { 200, 60 };
	 
	    
	    // Store for reference to weight of a carpet
	    WeightMeasurment carpetWeight = null;      
	    
	    // Store for area of a carpet
	    double carpetArea = 0.0;                                         
	 
	 
	    for(int i = 0 ; i < carpetLengths.length ; ++i)
	    {
	      // Since we want areas in square meters it is easiest to calculate them directly
	      carpetArea = carpetLengths[i].toMeters() * carpetWidths[i].toMeters();  //length * width
	 
	      carpetWeight = new WeightMeasurment(carpetWtPerSqM[i]*carpetArea);
	 
	      System.out.println("\nCarpet " + (i + 1) + ": Size = " + carpetLengths[i] + " by "+ carpetWidths[i]);
	      System.out.println("        " + "  Weight per sq. m. = " + carpetWtPerSqM[i]);
	      System.out.println("        " + "  Area = " + carpetArea + " sq. m.");
	      System.out.println("        " + "  Weight = " + carpetWeight);
	      System.out.println("        " + "  Weight of " + carpetCounts[i] + " carpets = " + carpetWeight.multiply(carpetCounts[i]));
	 
	    }
	  }

}


