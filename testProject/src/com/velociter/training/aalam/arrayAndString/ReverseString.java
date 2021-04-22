
/*  
 * Write a program that will reverse the sequence of letters in each word of your chosen paragraph
from Exercise 3. For instance, “To be or not to be.” would become
“oT eb ro ton ot eb.”
 * */
package com.velociter.training.aalam.arrayAndString;

public class ReverseString 
{
	
   public String getParagrap(String paragraph)
  {
	   String getParagraph =paragraph;
	
	String paragraphInArray[] = getParagraph.split(" ");
	for(int i=0;i<=paragraphInArray.length-1;i++)
	{
		getParagraph = paragraphInArray[i].toString();
		
		//this loop for making reverse string from selected string
		for(int j=getParagraph.length()-1; j >= 0 ; j-- )
		{
			System.out.print(getParagraph.charAt(j));
		}
		System.out.print(" ");
	}
	
	return getParagraph;
  }
}