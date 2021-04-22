
/* 
 When testing whether an integer is a prime, it is sufficient to try to divide by integers up to the
square root of the number being tested. Rewrite the program example from this chapter to use
this approach.
 
    */

package com.velociter.training.aalam.loopsAndLogic;

import java.util.Scanner;

public class Primes
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number witch you want to check prime or not  ");
		int number = sc.nextInt();
		int count = 1;
		int squreRoot = (int) Math.sqrt(number);
		System.out.println("square root  of given number  is :" + Math.sqrt(number));
		if (number % squreRoot != 0)
		{
			System.out.println("enterd number" + " " + number + " " + " is prime number  ");
		} else 
		{
			System.out.println("enterd number" + number + "    " + " is not prime number ");
		} 

	}

}
