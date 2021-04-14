/*
 * Extend the program from this chapter that used a map to store names and telephone numbers
such that you can enter a number to retrieve the name.
 */
package com.velociter.training.aalam.collectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookEntry 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Map<Long , String> mapObject = new HashMap<Long , String>();  //according to test we can use any DataType(primitive) exapt char
		System.out.println("How many records You Want to Enter ");
		int recordsLimit =scan.nextInt();
        Long mobileNumberAsKey =0l;
        String name = null;
		for (int i = 1; i <= recordsLimit; i++) {
			System.out.println("Enter user mobile number ");
			mobileNumberAsKey = scan.nextLong();
			if (true == mapObject.containsKey(mobileNumberAsKey)) {    //this condition will check that Enterd user Mobile number is already register or not
				System.err.println("this Mobile number already exist");
				System.out.println("Enter another user's mobile number ");
				mobileNumberAsKey = scan.nextLong();
				if (true == mapObject.containsKey(mobileNumberAsKey)) {
					System.err.println("this Mobile number already exist");
					System.out.println("Enteranother user's  mobile number ");
					mobileNumberAsKey = scan.nextLong();
					System.exit(0);
				}
			}
			System.out.println("Enter your Name  ");
			name  = scan.next();
			mapObject.put(mobileNumberAsKey, name);
		}
		System.out.println("Your Deatils Saved ");
		System.out.println();
		Set setObject = mapObject.keySet();
		Iterator setItr = setObject.iterator();
		System.out.println("Enter  mobile number to Get Name ");
		mobileNumberAsKey = scan.nextLong();
	
		while(setItr.hasNext())
		{
			Object key = setItr.next();
			Object value = mapObject.get(mobileNumberAsKey);
			System.out.println();
			System.out.println(key+"  "+"CorresPonding Name is  :"+value);		
		}
		

		
		
	}

}
