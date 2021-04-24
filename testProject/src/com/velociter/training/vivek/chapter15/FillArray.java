package com.velociter.training.vivek.chapter15;

public class FillArray 
{
	public static void fill(char [] array,int value)
	{
		java.util.Arrays.fill(array,(char)value);
	}

	public static void main(String[] args) 
	 {
	   char [] array=new char[20];
	   int ch=65;
	   fill(array,ch);
	 
	   for(char c:array)
	   {
		System.out.println(c);   
	   }

	 }

}
