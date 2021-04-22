
/*     
 * Write a program that sets up a String variable containing a paragraph of text of your choice.
Extract the words from the text and sort them into alphabetical order. Display the sorted list of
words. You could use a simple sorting method called the bubble sort. To sort an array into
ascending order the process is as follows:
a. Starting with the first element in the array, compare successive elements (0 and 1, 1 and
2, 2 and 3, and so on).

b. If the first element of any pair is greater than the second, interchange the two elements.
c. Repeat the process for the whole array until no interchanges are necessary. The array
elements will now be in ascending order.
 * */
package com.velociter.training.aalam.arrayAndString;

public class ParagraphSorting 
{

	public static void main(String argr[]) {
		
		System.out.println(" Enter a paragraph");
		System.out.println("====================");
		String inputparagrph = "My Name is abhishekh ";
		
		
		System.out.println("paragrap :" + inputparagrph);
		System.out.println();
		System.out.println("   OUTPUT  ");
		System.out.println("===========");
		
		
		// convert string into String array
		String paragrapg[] = inputparagrph.split(" ");
	
		// temp is variable to old value for swapping
		String temp;
		
		
		/*if first character of first word is greater then first character of second word
		 * then it will return +ve value(in number of difference) and execute the code
		 * otherwise it will not execute because it will return -ve value
		 * if both word which going to compare are same then it will return 0 value
		 */
		for (int i =0;i < paragrapg.length-1; i++) 
        {
            for (int j = 0; j < paragrapg.length-1; j++) 
              { 
                if (paragrapg[j].compareToIgnoreCase(paragrapg[j+1])>0) 
                {
                    temp = paragrapg[j];
                    paragrapg[j] = paragrapg[j+1];
                    paragrapg[j+1] = temp;
                }
            }
       }
		 
        System.out.println("in alphabetical  Order:");
        System.out.println();
       for (int i = 0; i < paragrapg.length; i++) 
       {
           System.out.print(paragrapg[i]+" ");
       }
	}

}
