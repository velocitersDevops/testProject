package com.velociter.training.aalam.collectionUseFullClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ZodiacSigns {

	  static void zodiac_sign(int day, int month) 

	    { 

	        String astro_sign=""; 
	        // according to  month and date within the  
	        // valid range of a specified zodiac 

	        if (month == 12)
	        {
	            if (day < 22) 
	            astro_sign = "Sagittarius"; 
	            else
	            astro_sign ="capricorn"; 
	        }
	        else if (month == 1)
	        { 
	            if (day < 20) 
	            astro_sign = "Capricorn"; 
	            else
	            astro_sign = "aquarius";
	        }     
	        else if (month == 2)
	        { 
	            if (day < 19) 
	            astro_sign = "Aquarius"; 
	            else
	            astro_sign = "pisces"; 
	        } 
	        else if(month == 3)
	        { 
	            if (day < 21)  
	            astro_sign = "Pisces"; 
	            else
	            astro_sign = "aries"; 
	        } 
	        else if (month == 4)
	        { 
	            if (day < 20) 
	            astro_sign = "Aries"; 
	            else
	            astro_sign = "taurus"; 
	        } 
	         else if (month == 5)
	        { 
	            if (day < 21) 
	            astro_sign = "Taurus"; 
	            else
	            astro_sign = "gemini";
	        } 
	        else if( month == 6)
	        { 
	            if (day < 21) 
	            astro_sign = "Gemini"; 
	            else
	            astro_sign = "cancer"; 
	        } 
	        else if (month == 7)
	        { 
	            if (day < 23) 
	            astro_sign = "Cancer"; 
	            else
	            astro_sign = "leo"; 
	        } 
	        else if( month == 8)
	        { 
	            if (day < 23)  
	            astro_sign = "Leo"; 
	            else
	            astro_sign = "virgo"; 
	        } 
	        else if (month == 9)
	        { 
	            if (day < 23) 
	            astro_sign = "Virgo"; 
	            else
	            astro_sign = "libra"; 
	        }
	        else if (month == 10)
	        { 
	            if (day < 23) 
	            astro_sign = "Libra"; 
	            else
	            astro_sign = "scorpio"; 
	        } 
	        else if (month == 11)
	        { 
	            if (day < 22) 
	            astro_sign = "scorpio"; 
	            else
	            astro_sign = "sagittarius"; 
	        } 
	        System.out.println(astro_sign); 
	    }   

    public static void main (String[] args)  
    { 
    	Scanner sc =new Scanner(System.in); 
    	
        int day = 0;
   
        int month =0;
        try
        {
        	System.out.println("Enter your Date of birth (only date)");
        	day = sc.nextInt();
            System.out.println("Enter your Birth Month (Like 1 for jaunuary)");
            month = sc.nextInt();
        	
        }catch(InputMismatchException e)
        {
        	System.err.println("You not Entered A valid Number");
        	System.exit(0);
        }
        System.out.println();
        System.out.print("Zodiac corresponding to a birth date is "+" = ");
        zodiac_sign(day, month); 
	}

}
