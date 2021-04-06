/*
 * Define a class, tkgWeight, to represent a weight in tons, kilograms, and grams, and include a
similar range of methods and constructors as
 */

package com.velociter.training.aalam;

import java.util.Scanner;

public class TestWeigtMeasurment {

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
	    System.out.println("========================INPUT==============================");
        System.out.println("");
		System.out.println("Enter 1 st weight value in kilogram ");
		double kilograms = sc.nextDouble();
		WeightMeasurment weightMeasurmentObject1 =null;
		WeightMeasurment weightMeasurmentObject2 =null;
		if(kilograms >= 0)
		{
			 System.out.println("first input weight value is :"+kilograms+"  "+"kilograms");
		     weightMeasurmentObject1 = new WeightMeasurment(kilograms);
		}
		else
		{
			System.err.println("Invalid Input ,Try again With Valid Input");
			System.exit(1);
		}
		
		System.out.println("Enter 2 nd weight value in tons,kilograms , grams ");
		System.out.println("enter value in tons");
		int ton = sc.nextInt();
		System.out.println("enter value in kilograms");
		int kilogram = sc.nextInt();
		System.out.println("enter value in grams");
		int gram = sc.nextInt();
		  if(ton>=0 && kilogram >=0 && gram >=0 )
		  {
			  System.out.println("second input length value is :"+ton+"  "+"ton"+"   "+kilogram+" "+"kilogram   "+gram+"  "+"gram");
			  weightMeasurmentObject2 = new WeightMeasurment(ton,kilogram,gram);         // call 1 int argument constructor
		  }
		  else
		  {
			  System.err.println("Invalid Input ,Try again With Valid Input");
				System.exit(1); 
		  }
   	
				      // in kg
		//WeightMeasurment weightMeasurmentObject3 = new WeightMeasurment(1500);       //in gram
		
		System.out.println("");
		System.out.println("=====================OUTPUT====================");
		System.out.println("");
		
//		//displaying 3 object data
//	    System.out.println("Weight of First object  " + weightMeasurmentObject1);
//	    System.out.println("Weight of Second object " + weightMeasurmentObject2);
//	  //System.out.println("Weight of Third object  " + weightMeasurmentObject3);
//         
	    System.out.println("");
	    System.out.println("");
		System.out.println("=====================Arithematic Operations output====================");
		System.out.println("");
	    // Test the operations
	    System.out.println("Addition: " + weightMeasurmentObject1 + "    (+)    " + weightMeasurmentObject2 + " = " + weightMeasurmentObject1.add(weightMeasurmentObject2));
	    System.out.println("");
	    System.out.println("Subtraction: " + weightMeasurmentObject1 + "   (-)   " + weightMeasurmentObject2 + " = " + weightMeasurmentObject1.subtract(weightMeasurmentObject2));
	    System.out.println("");
	    System.out.println("Multiplication: "+ weightMeasurmentObject1 + " (multiply by 5)   = " + weightMeasurmentObject1.multiply(5));
	    System.out.println("");
	    System.out.println("Division: " + weightMeasurmentObject1 + " (divided by 7  )  = " + weightMeasurmentObject1.divide(7));
	 
	}

}
