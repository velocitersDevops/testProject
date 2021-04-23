package com.velociter.training.ankit.chapter4;

public class WordsReverse {

	public  void reverseWord(String string)
	{
		
		String []wordString=string.split(" ");
		String reverseString="";
		for(String w:wordString)
		{
			String reverseWord="";
			for(int i=w.length()-1;i>=0;i--)
			{
				reverseWord=reverseWord+w.charAt(i);
			}
		     reverseString=reverseString+reverseWord+" ";
		}
		System.out.println(reverseString);

	}
		public static void main(String args[])
		{
			WordsReverse word = new WordsReverse();
			String inputString="the written form of a speech, interview, etc.";
			word.reverseWord(inputString);
	    }
}
