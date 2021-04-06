package com.velociter.training.aalam.exceptions;



public class ArithmaticExceptions 
{
	int dividedBy=1 ;
	   int iteratioCount =0;
	   public int divide(int value)
	   {
		   if(value<'Z' && value>'A' && value<'z' && value>'a')
		   {
			   System.err.println("You Not Entered a Number,Please try again");
			   System.exit(3);
		   }
		   if(value<0)
		   {
			   System.err.println("You Enter Negative number,Please try again");
			   System.exit(3);
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
		       
		   

	         return iteratioCount;
   }
}
