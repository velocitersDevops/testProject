//Write a program that sets up a String variable containing a paragraph of text of your choice.
//Extract the words from the text and sort them into alphabetical order. Display the sorted list of
//words. You could use a simple sorting method called the bubble sort. To sort an array into
//ascending order the process is as follows:
//a. Starting with the first element in the array, compare successive elements (0 and 1, 1 and
//2, 2 and 3, and so on).
//b. If the first element of any pair is greater than the second, interchange the two elements.
//c. Repeat the process for the whole array until no interchanges are necessary. The array
//elements will now be in ascending order.


package com.velociter.training.ankit.chapter4;

public class AlphabeteOrder {
 public static void sortAlphabete(String text) 
  {
       String temprary;
       String newString[] = new String[text.length()];
       newString=text.split(" ");
      
      //Sorting the strings
      for (int i=0;i <newString.length-1; i++) 
        {
            for (int j = 0; j <newString.length-1-i; j++) { 
                if (newString[j].compareToIgnoreCase(newString[j+1])>0) 
                {
                	temprary= newString[j];
                    newString[j] = newString[j+1];
                    newString[j+1] = temprary;
                }
            }
 }
       System.out.println("Strings in Sorted Order:");
      for (int i =0; i<newString.length; i++) //Displaying the strings alphabetical order
      {
          System.out.print(newString[i]+" ");
      }
  }
	public static void main(String ar[])
	{  
		String textInput="therefore has a 29th of February";
		sortAlphabete(textInput);
	}
}