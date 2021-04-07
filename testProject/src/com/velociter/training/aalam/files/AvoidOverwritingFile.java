package com.velociter.training.aalam.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AvoidOverwritingFile 
{
	  public static void main(String[] args)
	  {
	    String filepath = "e:/files/userFiles.txt";

	      
	    File aFile = new File(filepath);
	    FileOutputStream outputFile = null;          // Stores the stream reference
	    if (aFile.isFile()) 
	    {
	      File newFile = aFile;                      // Start with the original file

	      // We will append "_old" to the file
	      // name repeatedly until it is unique
	      do {
	        String name = newFile.getName();         // Get the name of the file
	        //System.out.println(name);
	        int period =  name.indexOf('.');         // Find the separator for the extension
	      
	        if(period == -1)                         //means  periods                                    
	        {                                                              // ***
	          newFile = new File(newFile.getParent(), name +"_old");                       // ***
	         }
	        else
	        {                                                                        // ***        
	          newFile = new File(newFile.getParent(), 
	                           name.substring(0, period) + "_old"   //concatinating the old word
	                           + name.substring(period));
	         }
	      } while (!aFile.renameTo(newFile));        // Stop when renaming works
	    } 
	    //if closed here

	    // Now we can create the new file
	    try {

	      // Create the stream opened to append data
	      outputFile = new FileOutputStream(aFile);
	      System.out.println("file is created "+aFile.getName()+" output stream created");
	    } catch (FileNotFoundException e) {
	      e.printStackTrace(System.err);
	    } 
	    System.exit(0);
	  }
	}
