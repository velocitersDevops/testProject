
/* 
     A lottery requires that you select six different numbers from the integers 1 to 49. Write a program
to do this for you and generate five sets of entries.
   
 */


package com.velociter.training.aalam.loopsAndLogic;

import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		
		int numbers[] =new int[6] ;
		for(int i=0;i<6; i++)
		{
			numbers[i]=  (int) (49 *Math.random() + 1);
		}
		
		for(int i=0;i<numbers.length; i++)
		{
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
		int lucknumber =0;
		for(int i=0;i<1; i++)
		{
			lucknumber=  (int) (49 *Math.random() + 1);
			System.out.println("lottery number"+"  "+lucknumber);
		}
		System.out.println();
		//matching lucky number with option numbers
		for(int i=0;i<6; i++)
		{
			if(lucknumber == numbers[i])
			{
				System.out.println("lottery number matced "+"  "+lucknumber);
			}
		}
		

	}

}
