package com.velociter.training.aalam.exceptions;

import java.util.Scanner;

public class TestFinally 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		FinallyBlock  finallyBlockObject = new FinallyBlock();
		System.out.println("enter a value which you want to divide");
		int value = sc.nextInt();
		int iterationCount = finallyBlockObject.divide(value);

	}

}
