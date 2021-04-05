package com.velociter.training.mukesh.chapter7;

public class TestExceptions 
{
 
	public static void main(String args[]) 
	{
    int result = 0;                              // Somewhere to store a result.
    int arraySize = 3;		
    int badSize = -1;                            // A negative size to generate NegativeArraySizeException.
    int[] array =null;                          // Define an integer array variable.

    for(int choice = 0; choice<3 ; choice++)
    try 
    {
      switch(choice) 
      {
        case 0:		
         result = array[0];                      // Generates a NullPointerException.
         break;
        case 1:		
         array = new int[badSize];               // Generates a NegativeArraySizeException.
         break;
        case 2:		
         array = new int[arraySize];    
         result = array[arraySize];              // Generates an ArrayIndexOutOfBoundsException.
         break;
      }
    } 
    catch(NullPointerException e) 
    {            													// Catch the NullPointerException:
      System.out.println("\nNullPointerException Exception caught. " );
                         
      System.out.println("The contents of the stack trace are:\n");
      e.printStackTrace();
    } 
    catch(NegativeArraySizeException e)
    {      															// Catch the NegativeArraySizeException:
      System.out.println("\nNegativeArraySizeException Exception caught. " );
                         
      System.out.println("The contents of the stack trace are:\n");
      e.printStackTrace();
    } 
    catch(ArrayIndexOutOfBoundsException e) 
    {  																// Catch the ArrayIndexOutOfBoundsException:
      System.out.println("\nArrayIndexOutOfBoundsException Exception caught. ");
                         
      System.out.println("The contents of the stack trace are:\n");
      e.printStackTrace();
    }
  }
}
