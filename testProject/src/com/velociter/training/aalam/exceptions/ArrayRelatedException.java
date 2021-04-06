package com.velociter.training.aalam.exceptions;

public class ArrayRelatedException
{
	String name=null;
	
	int [] arrayElements =null;
	public void arrayException(int arraySize)
	{
		int value=1;
	  try{
			arrayElements = new int[arraySize];
			for(int i=0;i<arrayElements.length;i++)
			{
				arrayElements[i]=value++;
			}
			//display
			System.out.println("name :"+name);
			name.charAt(0);
			System.out.println("Array Elements are");
			
			for(int i=0;i<=arrayElements.length;i++)
			{
				System.out.println(arrayElements[i]);
			}
			
		 }
	     catch(NegativeArraySizeException negativeArraySizeException)
		    {
		     	System.err.println("Sorry You Enterd Size In Negative.Please Try Again ");
		    }
		    
	     catch(ArrayIndexOutOfBoundsException aiobeObject )
		   {
			System.err.println("size  over please maintain size of elements");
		   }
	       
	      catch(NullPointerException e)
		   {
			System.err.println("in object data is not available");
		   }
	  
	  
	}

	
}
