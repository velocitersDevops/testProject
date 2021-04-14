package com.velociter.training.mukesh.chapter14;

import java.util.HashMap;
import java.util.Scanner;

public class SearchName {
	public static void main(String[] args)
	{
		Scanner inputs= new Scanner(System.in);
		HashMap<String,String> TelephoneBook =new HashMap<String,String>();
		
		System.out.println("Enter number you want how many record");
		int numbers =inputs.nextInt();
		
		for(int i=0;i<numbers;i++)
		{
			System.out.println("Enter name");
			String name=inputs.next();
			System.out.println("Enter surname with mobile number ");
			String surname=inputs.next();
			TelephoneBook.put(surname,name);
		}
		
		System.out.println("Enter surname with mobile number  to find there name");
		
		String surName=inputs.next();
		
		if(TelephoneBook.containsKey(surName))
		{
			System.out.println("name ="+TelephoneBook.get(surName));
		}
		
	}

}
