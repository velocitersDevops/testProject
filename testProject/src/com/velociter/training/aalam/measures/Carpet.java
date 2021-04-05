
/*
 *Put both the previous classes in a package called Measures. Import this package into a program
that will calculate and display the total weight of the following: 200 carpets—size: 4 meters by
2 meters 9 centimeters, that weigh 1.25 kilograms per square meter; and 60 carpets—size: 3
meters 57 centimeters by 5 meters, that weigh 1.05 kilograms per square meter. */

package com.velociter.training.aalam.measures;
import java.util.Scanner;

import com.velociter.training.aalam.measures.LengthMeasurment;

public class Carpet {
	public static void main(String args[]) 
	{
        
		LengthMeasurment[] carpetLengths = new LengthMeasurment[2];
		carpetLengths[0] = new LengthMeasurment(4, 0, 0); // call for carpet length
		carpetLengths[1] = new LengthMeasurment(3,57 ,0 ); // call 1 int argument constructor
		System.out.println("");
		System.out.println("===================================INPUT=================================");
		System.out.println("");
		System.out.println("first carpet length is :"+4 +" "+"meter");
		System.out.println("second carpet length is :"+3 +" "+"meter"+" "+57+ " "+"centimeter");
		System.out.println("");
		// width

		LengthMeasurment[] carpetWidths = new LengthMeasurment[2];
		
			carpetWidths[0] = new LengthMeasurment(2,9,0); // call 1 int argument constructor
			carpetWidths[1] = new LengthMeasurment(5,0,0); // call 1 int argument constructor
			System.out.println("first carpet width is :"+2 +" "+"meter"+" "+9+ " "+"centimeter");
			System.out.println("second carpet width is :"+5 +" "+"meter");

		// Weight per sq m of carpets
		double[] carpetWtPerSqM = new double[2];
		System.out.print("first carpet weight per square meter");
		double firstWeightSqPerMeter = 1.25;
		System.out.println(firstWeightSqPerMeter);
		System.out.print("second carpet weight per square meter");
		double secondWeightSqPerMeter = 1.5;
		System.out.println(secondWeightSqPerMeter);
		if(firstWeightSqPerMeter >0  && secondWeightSqPerMeter >0)
		{
			 carpetWtPerSqM[0] = firstWeightSqPerMeter  ;
			 carpetWtPerSqM[1] = secondWeightSqPerMeter ;	
		}else
		{
			System.out.println("Invalid Input ,please try again with valid input");
			System.exit(0);
		}
			
		
		
		System.out.println();
		//  carpets quantity
		int[] carpetCounts = new int [2];
		
			carpetCounts[0]=  200 ;
			carpetCounts[1]=  60 ;
		
		System.out.println();
		// Store for reference to weight of a carpet
		WeightMeasurment carpetWeight = null;

		// Store for area of a carpet
		double carpetArea = 0.0;

		System.out.println("==================================OUTPUT==================================");
		for (int i = 0; i < carpetLengths.length; ++i) {
			// Since we want areas in square meters it is easiest to calculate them directly
			carpetArea = carpetLengths[i].toMeters() * carpetWidths[i].toMeters(); // length * width

			carpetWeight = new WeightMeasurment(carpetWtPerSqM[i] * carpetArea);

			System.out.println("\nCarpet " + (i + 1) + ": Size = " + carpetLengths[i] + " by " + carpetWidths[i]);
			System.out.println("        " + "  Weight per sq. m. = " + carpetWtPerSqM[i]);
			System.out.println("        " + "  Area = " + carpetArea + " sq. m.");
			System.out.println("        " + "  Weight = " + carpetWeight);
			System.out.println("        " + "  Weight of " + carpetCounts[i] + " carpets = "+ carpetWeight.multiply(carpetCounts[i]));

		}
	}

}
