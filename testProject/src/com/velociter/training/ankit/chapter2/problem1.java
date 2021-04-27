//Write a console program to define and initialize a variable of type byte to 1, and then successively
//multiply it by 2 and display its value 8 times. Explain the reason for the last result.
package com.velociter.training.ankit.chapter2;
public class problem1 {
	public static void main(String aa[])
	{
		byte number=1;
		int  range=8;
		while(range>0)
		{
			number=(byte)(number*2);
			range--;
			System.out.println(number);
		}
	}
}
