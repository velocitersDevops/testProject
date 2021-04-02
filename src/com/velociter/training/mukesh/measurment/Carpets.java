package com.velociter.training.mukesh.measurment;
import com.velociter.training.mukesh.measurment.WeightMeasurment;
import com.velociter.training.mukesh.measurment.LengthMeasurment;
public class Carpets 
{
	  public static void main(String args[]) 
	  {
		  LengthMeasurment[] carpetLengths = { new LengthMeasurment(4,0,0), new LengthMeasurment(3,57,0) };
		  LengthMeasurment[] carpetWidths = { new LengthMeasurment(2,9,0), new LengthMeasurment(5,0,0) };
		      double[] carpetWeightPerSquareMeter = { 1.25, 1.05 };                          // Weight per sq m of carpets
		      int[] carpetCounts = { 200, 60 };
		 
			 
			    WeightMeasurment carpetWeight = null;                                    // Store for reference to weight of a carpet
			    double carpetArea = 0.0;                                          // Store for area of a carpet
			 
		 
		    for(int i = 0 ; i < carpetLengths.length ; ++i) 
		    {
		      // Since we want areas in square meters it is easiest to calculate them directly
		      carpetArea = carpetLengths[i].toMeter()*carpetWidths[i].toMeter();
		 
		      carpetWeight = new WeightMeasurment(carpetWeightPerSquareMeter[i]*carpetArea);
		 
		      System.out.println("\nCarpet " + (i + 1) + ": Size = " + carpetLengths[i] + " by "+ carpetWidths[i]);
		      System.out.println("        " + "  Weight per sq. m. = " + carpetWeightPerSquareMeter[i]);
		      System.out.println("        " + "  Area = " + carpetArea + " sq. m.");
		      System.out.println("        " + "  Weight = " + carpetWeight);
		 
		      System.out.println("        " + "  Weight of " + carpetCounts[i] + " carpets = " + carpetWeight.multiply(carpetCounts[i]));
		 
	         }
	  }
}
