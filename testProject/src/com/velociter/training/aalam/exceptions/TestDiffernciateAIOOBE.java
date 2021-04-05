package com.velociter.training.aalam.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDiffernciateAIOOBE 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arraySize =0;
		DiffrenciateAIOOBE  aioobeObject = new DiffrenciateAIOOBE();
		System.out.println("Enter a size for Array whitch we going to create");
		try {
			arraySize = sc.nextInt();
			aioobeObject.divide(arraySize);   //here we will get ArrayIndexOutOfBoundsException
		}catch(InputMismatchException immExbject)
        {
	         System.err.println("You Not Entered a Number,Please try again");
	         System.exit(1);
         } 
		
		catch(ArrayIndexOutOfBoundsException aiobeObject )
		 {
			System.err.println("size  over please maintain size of elements");
		 }
	}

}
