//Write a program to generate a random sequence of capital letters that does not include vowels
package com.velociter.training.ankit.chapter3;
public class problem3 {
	public static void main(String ar[])
	{
		char Alphabets[]=new char[5];
		for(int i =0;i<5;i++)
		{
			Alphabets[i]=(char)(26*Math.random()+'A');
			System.out.println(Alphabets[i]);
		}
		for(int i=0;i<5;i++)
		{
			if(Alphabets[i]=='A'||Alphabets[i]=='E'||Alphabets[i]=='I'||Alphabets[i]=='O'||Alphabets[i]=='U') {
				System.out.println(Alphabets[i]+"=It is Vowels");
			}
			else
			{
				System.out.println(Alphabets[i]+"=It is Consonent");
			}
		}
	}

}
