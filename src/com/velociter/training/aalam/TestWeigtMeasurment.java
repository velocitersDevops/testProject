/*
 * Define a class, tkgWeight, to represent a weight in tons, kilograms, and grams, and include a
similar range of methods and constructors as
 */

package com.velociter.training.aalam;

public class TestWeigtMeasurment {

	public static void main(String[] args) 
	{
		//creating 3 object
		WeightMeasurment weightMeasurmentObject1 = new WeightMeasurment(1,12,500);   // in ton,kg,g
		WeightMeasurment weightMeasurmentObject2 = new WeightMeasurment(15.80);      // in kg
		//WeightMeasurment weightMeasurmentObject3 = new WeightMeasurment(1500);       //in gram
		
		System.out.println("");
		System.out.println("=====================OUTPUT====================");
		System.out.println("");
		
		//displaying 3 object data
	    System.out.println("Weight of First object  " + weightMeasurmentObject1);
	    System.out.println("Weight of Second object " + weightMeasurmentObject2);
	  //System.out.println("Weight of Third object  " + weightMeasurmentObject3);
         
	    System.out.println("");
	    System.out.println("");
		System.out.println("=====================Arithematic Operations output====================");
		System.out.println("");
	    // Test the operations
	    System.out.println("Addition: " + weightMeasurmentObject1 + " + " + weightMeasurmentObject2 + " = " + weightMeasurmentObject1.add(weightMeasurmentObject2));
	    System.out.println("");
	    System.out.println("Subtraction: " + weightMeasurmentObject1 + " - " + weightMeasurmentObject2 + " = " + weightMeasurmentObject1.subtract(weightMeasurmentObject2));
	    System.out.println("");
	    System.out.println("Multiplication: "+ weightMeasurmentObject1 + " multiply by 5   = " + weightMeasurmentObject1.multiply(5));
	    System.out.println("");
	    System.out.println("Division: " + weightMeasurmentObject1 + " divided by 7   = " + weightMeasurmentObject1.divide(7));
	 
	}

}
