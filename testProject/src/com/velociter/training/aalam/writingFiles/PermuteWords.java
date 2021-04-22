package com.velociter.training.aalam.writingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class PermuteWords
{

	  // These are static class members so we can reference them in all the methods in the class
	  static String inputString = "you we are";
	  static ByteBuffer byteBufferObject = null;
	  static FileChannel fileChannelWriteObject = null;
	  static String[] words = null;                              //to hold actual string what we passed
	  static String[] permutationWord = null;                    //to hold actual permutation
	  static int numberOfWords = -1;                             // to represent how many word 

		private static void permute(int index) 
		{
			 //System.out.println(words[numberOfWords - 1]);
			if( ++numberOfWords == 0)
			{
				permutationWord[index] = null;
			}else
			{
				permutationWord[index] =  words[numberOfWords - 1];	//inserting permutation string in Array
			}
			
			
			if (numberOfWords == words.length)    //means 3 == 3
			{
				write();
			} 
			else   //it execute when no words
			{
				for (int i = 0; i < words.length; i++) 
				{
					if (permutationWord[i] == null)
					{
						permute(i);
					}
				}
			}
			numberOfWords--;  //its a temprary var.again initialize
			permutationWord[index] = null;
		}

	// Writes a permutation to the file
		  private static void write() 
		  {
				CharBuffer charBuffer = byteBufferObject.asCharBuffer(); // taking character one by one from byteBufferObject												
				System.out.println(charBuffer);
				for (int i = 0; i < permutationWord.length; i++)
				{
					charBuffer.put(i == 0 ? '\n' : ' ').put(permutationWord[i]);
				}
		    try {
		    	fileChannelWriteObject.write(byteBufferObject);           //here writeng Permutation s String into file
		    } catch (IOException e) {
		       System.out.println("Have some issues.please try later");
		        System.exit(1);
		    } 
		    byteBufferObject.clear();
		  }


	  public static void main(String args[]) 
	  {
		//get the word from inputString(actual string) into an array
			words = inputString.split(" ");                 //to get size of array
			int wordCount = words.length;
			//System.out.println(wordCount);
			words =new String[wordCount];
			words = inputString.split(" ");
			permutationWord = new String[wordCount];         //initialize both arrays
			
///============================================================================================	    
			// Now get the words from begining
			int fromIndex = 0;                               //to hold starting index
			int toIndex = 0;                                 // Word end position
			int index = 0;                                   // to hold current possition
	    while((toIndex = inputString.indexOf(' ', fromIndex)) != -1)  //index of ' ' after 0 index(means next '')
	    {
	      words[index++] = inputString.substring(fromIndex,toIndex); //from here take string
	      fromIndex = toIndex;
	      while(inputString.charAt(++fromIndex) == ' ');         // Skip contiguous spaces /java.lang.StringIndexOutOfBoundsException:
	        
	    }

	    // Now create and write the file
	    String filePath = "e:/programingExample/files/permuted.txt";
        File fileObject = new File(filePath);
        FileOutputStream fileOutputStreamObject =null;	 
       
        try 
        {
        	fileOutputStreamObject = new FileOutputStream(fileObject);
	    } 
        catch (FileNotFoundException e) 
        {
	     System.out.println("File Not Found.Please Check");
	     System.exit(1);
	    }
	    fileChannelWriteObject = fileOutputStreamObject.getChannel();
	    byteBufferObject = ByteBuffer.allocate(512);          // We add one to allow for '\n' at the beginning
	    permute(0);                                           // Create and write all permutations of words array

	    try {
	    	fileOutputStreamObject.close();
	    } catch (IOException e) {
	      e.printStackTrace(System.err);
	      System.exit(1);
	    }
	  }
}
