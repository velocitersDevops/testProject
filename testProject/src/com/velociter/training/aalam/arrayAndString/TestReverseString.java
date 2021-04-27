/* Write a program that will reverse the sequence of letters in each word of your chosen paragraph
from Exercise 3. For instance, “To be or not to be.” would become
“oT eb ro ton ot eb.”
*/
package com.velociter.training.aalam.arrayAndString;

public class TestReverseString
{

	public static void main(String[] args) 
	{
		
		String paragrap = "To be or not to be";       //oT eb ro ton ot eb.”
		ReverseString reverseStringObject = new ReverseString();
		reverseStringObject.getParagrap(paragrap);
		
	}

}
