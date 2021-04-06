package com.velociter.training.mukesh.chapter10;
import java.io.*;

public class WriteProverb 
{
	
	 public static void main(String[] args) {
	    String dirName = "E:\\Newfolder";   // Directory for the output file
	    String fileName = "Proverbs.txt";       // Name of the output file
	    String[] input = {
	      "I am Mukesh Tiwari .",
	      "Things will be better for a while.",
	      "This is Example of FileChannel.",
	      "importaint topic in file handling.",
	      
	    };
	    File newFile=new File(dirName, fileName);
	   
	    try {
	    FileOutputStream outNewFile = new FileOutputStream(newFile);
	    System.out.println("File Created");
	  
	    }
	    catch(FileNotFoundException ex)
	    {
	    	System.out.println("File not Found");
	    }
	   
		
	     try 
	    {
	        FileWriter myWriter = new FileWriter(newFile);
	        for (String value : input)
	        { 
	        	myWriter.write(value +"* ");
	        	System.out.println();
	          }
	        
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } 
	    catch(IOException e)
	    {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    
	    
	    
	}
}




