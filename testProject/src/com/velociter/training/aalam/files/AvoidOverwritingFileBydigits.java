package com.velociter.training.aalam.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AvoidOverwritingFileBydigits
{

	public static void main(String[] args)
	{
		 String filepath = "e:/userfiles/userfile.txt";

		      
		    File userfile = new File(filepath);
		    FileOutputStream outputFile = null;             // Stores the stream reference
		    if (userfile.isFile()) {
		      File newFile = userfile;                      // Start with the original file

		      // We will append three digits to the file to make it unique
		      do {
		       
		    	//System.out.println(newFile.getName());
		        String name = newFile.getName();         // Get the name of the file
		        
		        int period =  name.indexOf('.');         // Find the separator for the extension
		        if(period == -1)
		        {           
		        	System.out.println("check");
		          newFile = new File(newFile.getParent(), extendName(name));       // ***
		        } 
		        else 
		        {
		        	
		        	//System.out.println("getparaent :"+newFile.getParent());   debug
		          
		        	newFile = new File(newFile.getParent(),                //it takes the path of folder
		                           extendName(name.substring(0, period))   //from first index to period index mean name of the file
		                           + name.substring(period));              //from . index to last index
		        }
		      } while(!userfile.renameTo(newFile));         // Stop when renaming works
		    } 

		    // Now we can create the new file
		    try {
		      // Create the stream opened to append data
		      outputFile = new FileOutputStream(userfile);
		      System.out.println(userfile.getName()+" output stream created");
		    } catch (FileNotFoundException e) {
		      e.printStackTrace(System.err);
		    } 
		    System.exit(0);
		  }
		  // *** new method to adding or increment three digits at the end of a name starting at "000"
		  private static String extendName(String name)
		  {
		    StringBuffer newName = new StringBuffer(name);              // We will create the new name in this buffer
		    String digits = newName.substring(newName.length()-3,newName.length());   // Get last three characters
		   
		    System.out.println("digit "+digits);
		    int number = 0;
		    try 
		    {
		      number = Integer.parseInt(digits);                                      // Parse the last 3 characters
		      System.out.println("number "+number);
		      ++number;                                                               // We got an integer so increment it
		      newName.delete(newName.length()-3,newName.length());                    //here delete last 3 digit for every time when new file will create
		    } catch(NumberFormatException nfe) 	                                      // This will be thrown if digits is not a parsable integer
		    {                                     
		    	System.out.println("have some issues.please try again");
		    }
		    digits = String.valueOf(number);                // Get number as a string 
		    assert digits.length() < 4;                     // Make sure we don't run over three digits!     
		    System.out.println("finaly digit is"+digits);
		    // We can now create the new name by appending "000" and replacing some or all of these
		    // by the digits in the String, digits.   
		    
		    return newName.append("000").replace(newName.length()-digits.length(),newName.length(), digits).toString();  //digit that will replace previous contents.  


	}

}
