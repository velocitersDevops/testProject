package com.velociter.training.ankit.measurment;
import com.velociter.training.ankit.measurment.TestLengthMeasurment;
import com.velociter.training.ankit.measurment.TestWeightMeasurment;
public class Carpet  {

	public static void main(String args[]) {
		TestLengthMeasurment[] carpetLengths = { new TestLengthMeasurment(4,0,0), new TestLengthMeasurment(3,57,0) };
		TestLengthMeasurment[] carpetWidths = { new TestLengthMeasurment(2,9,0), new TestLengthMeasurment(5,0,0) };
	    double[] carpetWeightPerSqMeter ={ 1.25, 1.05 };                          
	    int[] carpetCounts ={200,60};
	    TestWeightMeasurment carpetWeight = null;                        
	    double carpetArea =0.0;                                          
	  for(int i=0; i< carpetLengths.length ; ++i) {
	      carpetArea = carpetLengths[i].toMeter()*carpetWidths[i].toMeter();
	      carpetWeight = new TestWeightMeasurment(carpetWeightPerSqMeter[i]*carpetArea);
	      System.out.println("\nCarpet " + (i + 1) + ": Size = " + carpetLengths[i] + " by "+ carpetWidths[i]);
	      System.out.println("        " + "  Weight per Square Meter = " + carpetWeightPerSqMeter[i]);
	      System.out.println("        " + "  Area = " + carpetArea + " sq. m.");
	      System.out.println("        " + "  Weight = " + carpetWeight);
	      System.out.println("        " + "  Weight of " + carpetCounts[i] + " carpets = " + carpetWeight.multiply(carpetCounts[i]));
	 
	    }
	  }
	
}
