package com.velociter.training.mukesh.chapter3;

public class PrimesNumbersGenerate 
{
	  public static void main(String args[]) 
	  {
		    int limitValue = 50;         
		
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
		    }else
		    	System.out.println("Invalid number");
	  }
}

