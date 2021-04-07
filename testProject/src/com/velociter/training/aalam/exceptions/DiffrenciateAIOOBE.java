package com.velociter.training.aalam.exceptions;

public class DiffrenciateAIOOBE 
{
	int [] arrayElements =null;
	int value=0;
	public void divide(int arraySize)
	{
		arrayElements = new int[arraySize];
		//inserting element
		for(int i=0;i<arraySize;i++)
		{
			arrayElements[i]=value;
			value++;
		}
		
	
			
		//display elements
		System.out.println("Array Elements are");
		for(int i=0;i<=arrayElements.length;i++)
		{
			System.out.println(arrayElements[i]);
			 throw	new ArrayIndexOutOfBoundsException();
		}
     	
		
		
	}
}
