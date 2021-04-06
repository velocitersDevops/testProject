package com.velociter.training.aalam.exceptions;

public class FinallyBlock
{
	int dividedBy=1 ;
	   int iteratioCount =0;
	   public int divide(int value)
	   {
		   if(value<0)
		   {
			   System.err.println("You Enter Negative number,Please try again");
		   }
		         System.out.println("value                dividedBy");
		   try {
			   
			   for(int i =1 ;i<=3; i++)
			     {
				   dividedBy = (int) (2 *Math.random() );
				   System.out.println(+value+"                      "+dividedBy);
				  int result= value / dividedBy;
				  dividedBy--;
				  iteratioCount++;
			     }
		        }catch(ArithmeticException aeObject)
		        {
			       System.err.println("Execution stop due to divide by '0' value");
		        }
		   finally 
		   {
			   System.out.println("iteration count ="+iteratioCount);
		   }
		         return iteratioCount;
	   }
}
