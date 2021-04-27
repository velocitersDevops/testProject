package com.velociter.training.vivek.chapter8;




import java.util.StringTokenizer;

public class ParseString 
{
	public static void main (String args [])
	{
	 StringTokenizer st1 = new StringTokenizer("Hello 11  Geeks How are you", " ");
        while (st1.hasMoreTokens())
            System.out.println(st1.nextToken());
	}
}
