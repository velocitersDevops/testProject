package com.velociter.training.ankit.exceptionhandling;

public class Exception4 {

	public static void main(String args[]) {
		int iterationOfException=0;
		try {
		   Iteration();
		 } 
		catch(ArrithmeticIteration exception) {
		   iterationOfException =   exception.getIteration();
		 }
		 finally
		 {
			 System.out.println("Total Iterations till Exception is "+iterationOfException);
		 }
		}

		static void Iteration() throws ArrithmeticIteration {
		 int iteration= 0;
		 int value=500;
		  for(iteration=0;;iteration++)
		   try {
		    int  divisor = (int)(100*Math.random()); 
		     int result = value/divisor;                   		
		   } catch(ArithmeticException exception) {
		     throw new ArrithmeticIteration(iteration);
		   }
		}
}
