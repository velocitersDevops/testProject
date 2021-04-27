/*
 *Define an array of ten String elements each containing an arbitrary string of the form
“month/day/year”; for example,”10/29/99” or “12/5/01”. Analyze each element in the
array and output the date represented in the form 29th October 1999.
 */

package com.velociter.training.aalam.arrayAndString;

public class TestDateProblem 
{
	
   public static void main(String[] args)
    {
	   
	   DateSolution object = new DateSolution();
	   System.out.print("      INPUT                      OUTPUT        ");
	   System.out.println();
	   System.out.print("================           =====================");
	   System.out.println();
	   System.out.print("( mm/dd/yyyy )                ( dd/mm/yyyy )");
	   System.out.println();
	   System.out.println();
	   object.dateFormate();
    }
}