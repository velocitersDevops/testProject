
/*
 * Write a console program to define and initialize a variable of type byte to 1, and then successively
multiply it by 2 and display its value 8 times. Explain the reason for the last result.
 */
package com.velociter.training.aalam.programsdataVariables;
public class ByteTest 
{
	public static void main(String[] args)
	{
		byte  a=1;
		for(int i=1;i<=8;i++)
		{
			a *=2;
			System.out.println(a);
		}
		
	}

}
