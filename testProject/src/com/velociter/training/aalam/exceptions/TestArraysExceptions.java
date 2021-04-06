package com.velociter.training.aalam.exceptions;

import java.util.Scanner;

public class TestArraysExceptions 
{

	public static void main(String[] args) 
	{
		ArrayRelatedException exceptionObject = new ArrayRelatedException();
		
        
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size for Array whitch we going to create");
		int arraySize = sc.nextInt();
		exceptionObject.arrayException(arraySize);
		
	}

}
