
/*
 * Implement a version of the program to calculate prime numbers that you saw in Chapter 4 to
use a Vector<> object instead of an array to store the primes. (Hint: Remember the Integer
class.)
 */
package com.velociter.training.aalam.collectionFramework;

import java.util.Scanner;
import java.util.Vector;

public class MorePrimes
{
   public static void main(String[] args)
	{
	  Scanner scan =new Scanner(System.in);
	   Vector<Integer> vectorObject = new Vector<Integer>();   //creating Vector object to store prime number those are  Integer type
	   System.out.println("Enter limit to find prime numbers");
	    int end = scan.nextInt();
		int count=0;
		int start=2;
		
		//loop for finding and printing all prime numbers between given range
		for(int i = start ; i <= end ; i++)
		{
			//logic for checking number is prime or not
			count = 0;
			for(int j = 1 ; j <= i ; j++)	
			{
				if(i % j == 0)
					count = count+1;
			}
			if(count == 2)
			{
				//System.out.println(i);
				vectorObject.add(i);
			}
		} 
		//display all prime number
		for(Integer v :  vectorObject )
		{
			System.out.print(v+"  " );
		}
	}
}
		