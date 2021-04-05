package com.velociter.training.aalam.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestArithmeticException
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ArithmaticExceptions arithmaticExceptionsObject = new ArithmaticExceptions();
		System.out.println("enter a value which you want to divide");
		int value=0;
		try {
			value = sc.nextInt();
		}catch(InputMismatchException immExbject)
        {
	         System.err.println("You Not Entered a Number,Please try again");
	         System.exit(1);
         }
		int iterationCount = arithmaticExceptionsObject.divide(value);
		System.out.println("iteration count :"+iterationCount);
		

	}

}
