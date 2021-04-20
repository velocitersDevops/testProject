package com.velociter.training.vivek.chapter10;

public class Permutation 
{
 public static void main(String args[])
 {
	 String str="abc";
	 
	 for(int i=0;i<str.length();i++)
	 {
		for(int j=i;j<=str.length();j++)
		{
			System.out.println(str.substring(i, j));
		}
	 }
 }
}
