//Write a console program to declare and initialize a double variable with some value such as
//1234.5678. Then retrieve the integral part of the value and store it in a variable of type long, and
//the first four digits of the fractional part and store them in an integer of type short. Display the
//value of the double variable by outputting the two values stored as integers.
package com.velociter.training.ankit.chapter2;
public class problem2 {
	public static void main(String a[])
	{
	double value=1234.5678;
	long integral =(long)(value);
	short fraction= (short)(value-integral);
	//short f=(short) (1234.5678-1234);
	System.out.println(fraction);
	System.out.println(integral);	
	}

}
