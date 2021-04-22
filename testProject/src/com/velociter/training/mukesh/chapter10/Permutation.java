package com.velociter.training.mukesh.chapter10;

public class Permutation 
{
	static public void StringPermutation(String input)
	{
		System.out.println("Permutation of strings: "+input);
		StringPermutation("",input);
	}
	
	static public void StringPermutation(String permutation, String data)
	{
		if(data.length()==0)
		{
			System.out.println(permutation);
		}
		else
		{
			for(int i=0;i<data.length();i++)
			{
				StringPermutation(permutation+data.charAt(i), data.substring(0,i)+data.substring(i+1,data.length()));
			}
		}
	}
	
	public static void main(String args [])
	{
		
		StringPermutation("abc");
	}
}
