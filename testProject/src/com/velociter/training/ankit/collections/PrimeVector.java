package com.velociter.training.ankit.collections;
//Problem 1
import java.util.Vector;
public class PrimeVector
{
public static void main(String[] ar) 
	{
		Vector<Long> primes = new Vector<Long>();
	
		int nthPrime=20;
		int count=0;
		int number=2;
		

		if(nthPrime>0)
		{
		//System.out.println("your prime numbers are");
		while(count!= nthPrime)
		{

		  boolean prime = true;
		  for (int i = 2; i <= Math.sqrt(number);i++)
		  {
		      if (number % i == 0)
		      {
		          prime = false;
		          break;
		      }
		    }
		  if (prime)
		  {
		   count++;
		       //System.out.println(number);
		   primes.add((long) number);
		     //System.out.println(primenumbers[index]);
		    
		  }
         number++;
		}
       }
		System.out.println("Data in Vector is :");
		 for(Long prime : primes) {
		     System.out.println(prime);
	}
}
}

	



////////////////////////////////////////////


//public static void main(String[] args) 
