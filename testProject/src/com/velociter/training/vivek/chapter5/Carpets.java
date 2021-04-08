package com.velociter.training.vivek.chapter5;


public class Carpets
{
	 public static void main(String args[]) {
		    mcmLength[] carpetLengths = { new mcmLength(4,0,0),
		                                  new mcmLength(3,57,0)};
		    mcmLength[] carpetWidths = { new mcmLength(2,9,0),
		                                 new mcmLength(5,0,0)};
		    double[] carpetWtPerSqM = { 1.25, 1.05 };    // Weight per sq m of carpets
		    int[] carpetCounts = { 200, 60 };
		  

		    TkgWeight carpetWeight = null;              // Store for reference to weight of a carpet  
		    double carpetArea = 0.0;                    // Store for area of a carpet


		    for(int i = 0 ; i<carpetLengths.length ; i++) {
		      // Since we want areas in square meters it is easiest to calculate them directly
		      carpetArea = carpetLengths[i].toMeters()*carpetWidths[i].toMeters();

		      carpetWeight = new TkgWeight(carpetWtPerSqM[i]*carpetArea);

		      System.out.println("\nCarpet "+(i + 1) + ": Size = " + carpetLengths[i] + 
		                                                           " by "+ carpetWidths[i]);
		      System.out.println("        " + "  Weight per sq. m. = " + carpetWtPerSqM[i]);
		      System.out.println("        " + "  Area = " + carpetArea + " sq. m.");
		      System.out.println("        " + "  Weight = " + carpetWeight);

		      System.out.println("        " + "  Weight of "+carpetCounts[i] + " carpets = "
		                                                   + carpetWeight.multiply(carpetCounts[i]));

		    }
		  }
}
