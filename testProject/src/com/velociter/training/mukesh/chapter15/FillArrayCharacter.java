package com.velociter.training.mukesh.chapter15;
import java.util.Arrays;

public class FillArrayCharacter
{
	  public static void fillArray(char[] array, int value) 
	  {
	    Arrays.fill(array, (char)value);
	    
	  }

	  public static void main(String[] args) 
	  {
		    char[] charArray = new char[10];
		    int value = 65;     						
		    fillArray(charArray, value);
		    
		    System.out.print("filled Array of characters : ");
		    for(char data : charArray) 
		    {
		      System.out.print(data);
		    }
	  }
}