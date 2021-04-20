package com.velociter.training.mukesh.chapter14;

import java.util.Scanner;
import java.util.Vector;

public class PrimeStoreInVector 
{
	public static void main(String[] args)
	{
	    Vector<Integer> primes = new Vector<Integer>();          //to store prime value
	    
	    System.out.println("Enter limit to print prime number:");
		Scanner input = new Scanner(System.in);
		int nthPrime= input.nextInt();
	    
		int count=0;
		int startNumber=2;
		
		if(nthPrime>0)
		{
				
				while(count!=nthPrime)
				{
						boolean prime= true;
						for(int i=2;i<=Math.sqrt(startNumber);i++)     //starting from number 2 
						{
							if(startNumber%i==0)
							{
								prime= false;
								break;
							}
						}
						if(prime)
						{
							count++;
							primes.addElement(startNumber);				
								
						}
						
						startNumber++;
						
					}
				System.out.println(primes);
				System.out.println(primes.size());
		}
		else
			System.out.println("invalid number");
		
	}

}
