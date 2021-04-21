package com.velociter.training.aalam.collectionUseFullClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveLineNumbers 
{
	public static File createCopyFile(File aFile) 
	{
	     aFile = aFile.getAbsoluteFile();                 
	     File parentDir = new File(aFile.getParent());   
	     String name = aFile.getName();                   
	     int period = name.indexOf('.');                      
	     int copyNumber = 0;                              // Copy number
	     String nameAdd = null;                           // String to be appended                
	     File copy = null;
	     do {
	       nameAdd = "_copy"+(++copyNumber);   // String which will  be appended
	       copy = new File(name.substring(0,period) + nameAdd + name.substring(period));
	     } while(copy.exists());                        // If the name already exists, go again

	     return copy;   
	  }

	
	public static void main(String[] args) 
	{
	   
	    String filePath = "f:/velociters/testProject/testProject/insertLineNumber_copy1.txt";                 // Get the file path
	    File fileObject = new File(filePath);
	    if(!fileObject.isFile())    // Check that there is a file for the path
	    {                   
	      System.out.println("File "+filePath+" does not exist.");
	      System.exit(1);
	    }
	    FileInputStream fileInputStreamObject = null;
	   
	    // Create the file input stream
	    try 
	    {
	    	fileInputStreamObject = new FileInputStream(fileObject); 
	    } catch(FileNotFoundException e) 
	    {
	     System.out.println("File Not Found.Please check Your File");
	      System.exit(1);
	    }
	    //prepare both object to perform the reading data from the file
	    FileChannel fileInputChannelObject = fileInputStreamObject.getChannel();     // File channel for input
	    ByteBuffer byteBufferInputObject = ByteBuffer.allocate(512);  // Buffer for 512 ASCII characters   
	        
	    // The regular expression to match a line and 
	    Pattern linePattern = Pattern.compile("(^\\d+ )?(.*\\r?\\n)",Pattern.MULTILINE); 
	    
	    // Create a new file for output after delete line number
	    File fileOutputObject = createCopyFile(fileObject);
	    FileOutputStream fileOutputStreamObject = null;              
	    System.out.println("Copy file is: "+fileOutputObject.getName());               
	    // System.out.println("check file name  :"+fileOutputObject.getName());
	    // Create the output file stream
	    try {
	    	fileOutputStreamObject = new FileOutputStream(fileOutputObject); 
	    } 
	    catch(FileNotFoundException e) 
	    {
	    	 System.out.println("File Not Found.Please check Your File");
	    	 System.exit(0);
	    }

	    //prepare both object to perform the write data into file
	    FileChannel fileOutputChannelObject = fileOutputStreamObject.getChannel();         // Channel for output 
	    ByteBuffer byteBufferOutputObject = ByteBuffer.allocate(512);       // Buffer holds 512 ASCII characters
	    
	    Matcher lineMatch = null;                // Matcher for a Patternline
	    String byteDataIntoString = null;          // Stores input the buffer data as Unicode
	    int atLineEnd = 0;                          // Offset for part of a line at end of inStr
	    byte[] dataInBytes = null;               // Input buffer contents as byte array
	    try {
	      // Read the file a buffer at a time
	      while(fileInputChannelObject.read(byteBufferInputObject) != -1)
	      {
				byteBufferInputObject.flip(); // Flip the buffer ready to get the data
				dataInBytes = new byte[byteBufferInputObject.remaining()];
				byteBufferInputObject.get(dataInBytes);
				byteDataIntoString = new String(dataInBytes);  //convert byte into string
				byteBufferOutputObject.clear();

				// Match complete lines from the buffer data that is now in inputBufferdData
				lineMatch = linePattern.matcher(byteDataIntoString);
	      
				while(lineMatch.find())   // While we match a line with a line (till last line
	            {       
					//writing allline data into  byteBufferOutputObject
					byteBufferOutputObject.put(lineMatch.group(2).getBytes());
					atLineEnd = lineMatch.end();                  // Record where unprocessed data starts
	             }             
	       
			    // We are finished with the input buffer contents
				byteBufferInputObject.clear(); // Clear the input buffer ready for next cycle

				// Write the contents of the output buffer to the file
				byteBufferOutputObject.flip();
				
				//writing byteBufferOutputObject data into File fileOutputChannelObject
				fileOutputChannelObject.write(byteBufferOutputObject);
	     }

	    
	     if(byteBufferInputObject.flip().hasRemaining())
	     {
				byteBufferOutputObject.clear();
				dataInBytes = new byte[byteBufferInputObject.remaining()];
				byteBufferInputObject.get(dataInBytes, 0, dataInBytes.length);
				lineMatch = Pattern.compile("(^\\d+ )?(.*)").matcher(new String(dataInBytes)); 
	       if(lineMatch.matches())
	       {
	    	   byteBufferOutputObject.put(lineMatch.group(2).getBytes());
	       } 
	       else 
	       {
	    	   byteBufferOutputObject.put(byteBufferInputObject);
	       }
	 
	       byteBufferOutputObject.flip();
	       //writing file data into fileOutputChannelObject after delete linenumber
	       fileOutputChannelObject.write(byteBufferOutputObject); 
	      }
	     System.out.println("\ncontrol reached to End of file.");
	     fileInputStreamObject.close();                                // Close the stream and the channel
	     fileOutputStreamObject.close();
	    } catch(IOException e) {
	      e.printStackTrace(System.err);
	      System.exit(1);
	    }
	  }

	
}
