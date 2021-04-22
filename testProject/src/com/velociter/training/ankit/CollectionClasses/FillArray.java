package com.velociter.training.ankit.CollectionClasses;

import java.util.*;

public class FillArray {
	public static void fillArray(char[] array, int value) 
	  {
	    Arrays.fill(array, (char)value);
	    
	  }

	  public static void main(String[] ar) 
	  {
		  Scanner input=new Scanner(System.in);
		    
		    System.out.println("Enter a Value...");
		    int value = input.nextInt();   
		    char[] charArray = new char[10];
		    if((value>=65 && value<=90)||(value>=97 && value<=122))
		    fillArray(charArray, value);
		    else
		    {
		    	System.err.println("Invalid Character value");
		    	main(ar);
		    }
		    System.out.print("filled Array of characters : ");
		    for(char character : charArray) 
		    {
		      System.out.print(character);
		    }
	  }

	
		  
	}
	
	
	
	
