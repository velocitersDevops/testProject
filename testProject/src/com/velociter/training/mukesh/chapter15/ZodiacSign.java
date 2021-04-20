// Java program to display astrological sign
// or Zodiac sign for given date of birth
	
package com.velociter.training.mukesh.chapter15;

import java.util.Scanner;

public class ZodiacSign 
{
	
		static void zodiacSign(int day, int month )
		{
				String astroSign="";
				
				// checks month and date within the
				if (month == 12)
				{
					if (day < 22)
					astroSign = "Sagittarius";
					else
					astroSign ="capricorn";
				}
					
				else if (month == 1)
				{
					if (day < 20)
					astroSign = "Capricorn";
					else
					astroSign = "aquarius";
				}
					
				else if (month == 2)
				{
					if (day < 19)
					astroSign = "Aquarius";
					else
					astroSign = "pisces";
				}
					
				else if(month == 3)
				{
					if (day < 21)
					astroSign = "Pisces";
					else
					astroSign = "aries";
				}
				else if (month == 4)
				{
					if (day < 20)
					astroSign = "Aries";
					else
					astroSign = "taurus";
				}
					
				else if (month == 5)
				{
					if (day < 21)
					astroSign = "Taurus";
					else
					astroSign = "gemini";
				}
					
				else if( month == 6)
				{
					if (day < 21)
					astroSign = "Gemini";
					else
					astroSign = "cancer";
				}
					
				else if (month == 7)
				{
					if (day < 23)
					astroSign = "Cancer";
					else
					astroSign = "leo";
				}
					
				else if( month == 8)
				{
					if (day < 23)
					astroSign = "Leo";
					else
					astroSign = "virgo";
				}
					
				else if (month == 9)
				{
					if (day < 23)
					astroSign = "Virgo";
					else
					astroSign = "libra";
				}
					
				else if (month == 10)
				{
					if (day < 23)
					astroSign = "Libra";
					else
					astroSign = "scorpio";
				}
					
				else if (month == 11)
				{
					if (day < 22)
					astroSign = "scorpio";
					else
					astroSign = "sagittarius";
				}
				
			System.out.println(astroSign);
		}
			
	
			public static void main (String[] args)
			{
				
				Scanner keyboard= new Scanner(System.in);
				System.out.println("Enter day of your DOB");
				int day = keyboard.nextInt();
				
				
				System.out.println("Enter month value ");
				int month = keyboard.nextInt();
				if(day<=0 || month<=0)
				{
					System.out.println("Invalid ! please Enter valid positive number");
					System.exit(0);
				}	
				zodiacSign(day, month);
					
			}
}

