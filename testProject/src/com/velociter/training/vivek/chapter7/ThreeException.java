package com.velociter.training.vivek.chapter7;

public class ThreeException {
	int a=10;
	int b=20;

	public static void main(String[] args)
	{
	
		ThreeException obj=null;
		    int result = 0;                              // Somewhere to store a result.
		    int arraySize = 3;		
		    int badSize = -1;                            // A negative size to generate NegativeArraySizeException.
		    String name="vivek";
		   // int[] array = null;                          // Define an integer array variable.

		    for(int choice = 0; choice<3 ; choice++)
		    try {
		      switch(choice) {
		        case 0:		
		         result = obj.a;                      // Generates a NullPointerException.
		         break;
		        case 1:		
		       int[]  array = new int[badSize];               // Generates a NegativeArraySizeException.
		         break;
		        case 2:		
		         //array = new int[arraySize];    
		         result = name.charAt(6);              // Generates an ArrayIndexOutOfBoundsException.
		         break;
		      }
		    } catch(NullPointerException e) {            // Catch the NullPointerException:
		      System.out.println("\nNullPointerException Exception caught. " +
		                         "Message in NullPointerException is:\n" +
		                         "\n" + e + "\n");
		      System.out.println("The contents of the stack trace are:\n");
		      e.printStackTrace();
		    } catch(NegativeArraySizeException e) {      // Catch the NegativeArraySizeException:
		      System.out.println("\nNegativeArraySizeException Exception caught. " + 
		                         "Message in NegativeArraySizeException is:\n" +
		                         "\n" + e + "\n");
		      System.out.println("The contents of the stack trace are:\n");
		      e.printStackTrace();
		    } catch(ArrayIndexOutOfBoundsException e) {  // Catch the ArrayIndexOutOfBoundsException:
		      System.out.println("\nArrayIndexOutOfBoundsException Exception caught. " +
		                         "Message in ArrayIndexOutOfBoundsException is:\n" +
		                         "\n" + e + "\n");
		      System.out.println("The contents of the stack trace are:\n");
		      e.printStackTrace();
		    }
	}

}
