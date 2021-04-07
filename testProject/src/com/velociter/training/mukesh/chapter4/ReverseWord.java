//program that will reverse the sequence of letters in each word.

//INPUT:  “To be or not to be.”

//OUTPUT: “oT eb ro ton ot eb.”


package com.velociters.chapter4; 

public class ReverseWord 
{
		public static void reverse(String string)
		{
			String stringArray[] = string.split(" ");
			String reverseString="";
			for(int i=0;i<stringArray.length;i++)	// outer loop for printing string is reversed
			{
				String words= stringArray[i];
				String reverseWord="";
				for(int j=words.length()-1;j>=0;j--)		//inner loop for printing  each word are reversed
				{
					reverseWord = reverseWord + words.charAt(j);        
				}													//inner loop close
				
			     reverseString = reverseString + reverseWord +" ";
			
			}															// outer loop close
			
			System.out.println(reverseString);						//print string which all words are reversed
		
		}  // end method body named reverse

		public static void main(String args[])
		{
			String inputString="To be or not to be ";
			reverse(inputString);
		}

}
