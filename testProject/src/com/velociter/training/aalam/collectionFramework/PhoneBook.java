package com.velociter.training.aalam.collectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Map<String , String> mapObject = new HashMap<String , String>();
		System.out.println("How many records You Want to Enter ");
		int recordsLimit =scan.nextInt();
        String sirName =null;
        String name = null;
		for (int i = 1; i <= recordsLimit; i++) {
			
			System.out.println("Enter your Name  ");
			name  = scan.next();
			
			System.out.println("Enter your SirName ");
			sirName = scan.next();
			if (true == mapObject.containsKey(sirName)) 
			{
				System.err.println("this sir name  already exist");
			    System.exit(i);
			}
			mapObject.put(sirName, name);
		}
		System.out.println("Your Deatils Saved ");
		System.out.println();
		System.out.println("Enter  SirName to Get Name ");
		sirName = scan.next();
		System.out.println(sirName+"  "+"CorresPonding Name is  :"+mapObject.get(sirName));
		
	}

	}


