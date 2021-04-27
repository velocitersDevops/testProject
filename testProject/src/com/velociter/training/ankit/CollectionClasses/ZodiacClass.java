package com.velociter.training.ankit.CollectionClasses;
import java.util.Scanner;
   public class ZodiacClass {
	 public static void main (String[] ar)
	  {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter day of your Date Of Birth");
		int date =input.nextInt();
		System.out.println("Enter month value ");
		int month =input.nextInt();
		if(date<=0 || month<=0)
		{
			System.err.println("Invalid ! please Enter Correct Date And Month");
			main(ar);
		}
		
//		else
//		{
//		zodiacSign(date,month);
//        }
		if((date<=31) && (month<=12))
		{
			zodiacSign(date,month);
		}
		else
		{
			System.err.println("Invalid ! please Enter Correct Date And Month");
			main(ar);
		}	
			
	}
	static void zodiacSign(int date,int month )
	{
			String rashi="";
			
			// checks month and date within the
		      if(month == 3)
			{
				if (date< 21)
				rashi = "Pisces";
				else
				rashi = "aries";
			}
			else if (month == 4)
			{
				if (date< 20)
				rashi = "Aries";
				else
				rashi = "taurus";
			}
				
			else if (month == 5)
			{
				if (date< 21)
				rashi = "Taurus";
				else
				rashi = "gemini";
			}
				
			else if( month == 6)
			{
				if (date< 21)
				rashi = "Gemini";
				else
				rashi = "cancer";
			}
				
			else if (month == 7)
			{
				if (date< 23)
				rashi = "Cancer";
				else
				rashi = "leo";
			}
				
			else if( month == 8)
			{
				if (date< 23)
				rashi = "Leo";
				else
				rashi = "virgo";
			}
				
			else if (month == 9)
			{
				if (date< 23)
				rashi = "Virgo";
				else
				rashi = "libra";
			}
				
			else if (month == 10)
			{
				if (date< 23)
				rashi = "Libra";
				else
				rashi = "scorpio";
			}
				
			else if (month == 11)
			{
				if (date< 22)
				rashi = "scorpio";
				else
				rashi = "sagittarius";
			}
			else if (month == 12)
			{
				if (date < 22)
				rashi = "Sagittarius";
				else
				rashi ="capricorn";
			}
				
			else if (month == 1)
			{
				if (date < 20)
				rashi = "Capricorn";
				else
				rashi = "aquarius";
			}
				
			else if (month == 2)
			{
				if (date< 19)
				rashi = "Aquarius";
				else
				rashi = "pisces";
			}
		 System.out.println("Your Zodiac is :"+rashi);
	}
}
