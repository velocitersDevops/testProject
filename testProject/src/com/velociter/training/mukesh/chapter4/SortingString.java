//Program is Extract the words from the text and sort them into alphabetical order by using bubble sort.
//example 
//INPUT: This string want to sort 
//OUTPUT: sort string This to want 


package com.velociters.chapter4;
public class SortingString
{
			public static void sortString(String string)
			{
					String stringArray[] = string.split(" ");
					
					String temprory;
					
					for (int i = 0; i < stringArray.length-1; i++)					
					{
					   	   for (int j = 0; j < stringArray.length-1-i; j++)	
					   	   {
					   		   		// comparing adjacent strings and swap through first character of word
									if (stringArray[j].compareToIgnoreCase(stringArray[j+1]) >0) 	//compare method subtract the ASCII value of first character in word and return value  
									{
										temprory=stringArray[j+1];
										stringArray[j+1] = stringArray[j];
										stringArray[j] = temprory;
									}
						  
					   	   }  // end inner loop
					
					}	//end outer loop 
				
					for(int i=0;i<stringArray.length;i++)
					{
						System.out.print(stringArray[i]+" ");    // print string which is sorted words
					}
			 
				}			// sortString method ending
		
				public static void main(String []args)
				{
					String inputString ="This string want to sort ";
					sortString(inputString);
				}

}
