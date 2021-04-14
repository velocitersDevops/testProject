package com.velociter.training.mukesh.chapter14;

import java.util.HashMap;
import java.util.Scanner;

public class SearchNameFromPhoneNumber 
{
	public static void main(String[] args)
	{
		Scanner scanner =new Scanner(System.in);
		HashMap<Long,String> telephoneBook =new HashMap<Long,String>();
		System.out.println("Enter number you want how many record");
		int limit=scanner.nextInt();
		
		
		for(int i=0;i<limit;i++)
		{
			System.out.println("Enter 10 digit phone number");
			Long phone=scanner.nextLong();
			System.out.println("Enter name");
			String name=scanner.next();
			telephoneBook.put(phone,name );
		}
		
		System.out.println("Enter number to find name");
		
		Long number=scanner.nextLong();
		
		if(telephoneBook.containsKey(number))
		{
			System.out.println("name ="+telephoneBook.get(number));
		}
		
	}

}
