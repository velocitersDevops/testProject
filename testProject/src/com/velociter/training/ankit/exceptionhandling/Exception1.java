package com.velociter.training.ankit.exceptionhandling;

public class Exception1 {

	public static void main(String ar[])
	{
	int []array=null;
	
	int choice=(int)(Math.random()*3);
	System.out.println("Random Choice is "+choice);
	try
	{
	switch(choice)
	{
	case 0:               //NullPointer
       int x=array[0];
		break;
	
	case 1:               //NegaativeArraySixzzeException
		array= new int[-1];
		break;
	case 2:              ////IndexOutOfBondException
		int y=Integer.parseInt(ar[0]);
	}
	}
	catch(NullPointerException e)
	{
		System.out.println("NullPointerException");
		System.out.println("PrintStackTree is");
		e.printStackTrace();
	}
	catch(NegativeArraySizeException e)
	{
		System.out.println("NegativeArraySizeException");
		System.out.println("PrintStackTree is");
		e.printStackTrace();
	}
	catch(IndexOutOfBoundsException e)
	{
		System.out.println("IndexOutOfBoundsException");
		System.out.println("PrintStackTree is");
		e.printStackTrace();
	}
}
}