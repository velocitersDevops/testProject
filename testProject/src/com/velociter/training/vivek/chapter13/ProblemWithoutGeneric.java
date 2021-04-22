package com.velociter.training.vivek.chapter13;

import java.util.ArrayList;
import java.util.Iterator;

public class ProblemWithoutGeneric {

	public static void main(String[] args)
	{
	
		ArrayList al= new ArrayList();
		
		al.add("vivek");
		al.add(10);
		al.add(20);
		al.add(30);
		
		System.out.println(al.toString());
		Iterator i =al.iterator();
		
		while(i.hasNext())
		{
			String s=(String)i.next();
			System.out.println(s);
			
		}

	}

}
