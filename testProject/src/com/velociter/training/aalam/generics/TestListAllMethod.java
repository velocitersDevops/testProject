package com.velociter.training.aalam.generics;

public class TestListAllMethod 
{

	public static void main(String[] args) 
	{
		
		//we insert int elements into stack by using generic type arguments
		Stack<Integer>  stackObject = new Stack<Integer>();
		int[] arrayOfintValues = new int[10];
		
		//inserting numeric values in array 
		int initialValue = 1;
		for(int i=0; i<arrayOfintValues.length;i++ )
		{
			arrayOfintValues[i] = initialValue;
			 initialValue++;
		}
		
		//push operation
		System.out.println("pushing numeric values into the stack");
		System.out.println("");
		for(int values : arrayOfintValues )
		{
			System.out.print( values+"  , ");
			stackObject.push(values);
		}
         
		System.out.println("");
		System.out.println("");
		System.out.println("dispaly all elements of stack by using listAll()");
		System.out.println("");
		stackObject.listAll();
	}

}
