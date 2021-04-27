package com.velociter.training.vivek.chapter3;

public class PrimeNoGenerate 
{
	 public static void main(String args[]) 
	  {
		    int limitValue = 30;         
		
		    if(limitValue>0) 
		    {
		    	System.out.println("prime numbers are");
			    OuterLoop:
			    for(int i=2 ; i<=limitValue ; i++)
			    {
			    	
				      for(int j=2 ; j<=Math.sqrt(i) ; j++)
				      {
				          if(i%j == 0)                      
				          continue OuterLoop;             
				      }
				      
				      System.out.println(i);            
			    }
		    }
		    else
		    	System.out.println("Number is not valid");
	  }
}
