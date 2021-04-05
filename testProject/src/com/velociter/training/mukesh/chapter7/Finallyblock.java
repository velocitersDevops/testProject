package com.velociter.training.mukesh.chapter7;

public class Finallyblock 
{
		public static void main(String args[]) 
		{
			 int iteration = 0;    // Store the iteration number.                           
			 try 
			 {
			   test();            // Call the method that will throw the exception.
			 } 
			 catch(IteratedArithmeticException e) 
			 {
			   System.out.println(e);
			   iteration = e.getIteration();                                                
			 } 
			 finally 
			 {                                                                    
			   System.out.println("Arithmetic exception occurred at iteration "+iteration);
			 }                                                                              
		}

		static void test() throws IteratedArithmeticException
		{
			              // Iteration counter
			 int result;                  // Stores a result
			 int divisor;                 // Random divisor
			
			 // Loop will continue until an exception is thrown:
			 for(int i=0 ; ; i++)
			   try 
			 	{
				     divisor = (int)(100*Math.random());     // Generate a random divisor.
				     result = 1000/divisor;                  // If we hit zero - bingo!		
			 	} 
			 	catch(ArithmeticException e) 
			 	{
			     throw new IteratedArithmeticException(i);
			 	}
		}
}

