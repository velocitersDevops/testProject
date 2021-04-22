

package com.velociter.training.aalam.collectionUseFullClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InsertLineNumbers
{
	  public static File createCopyFile(File userFile) 
	  {
		 userFile = userFile.getAbsoluteFile();                 
	     File parentDir = new File(userFile.getParent());    
	     String name = userFile.getName();                 
	     int period = name.indexOf('.');                  
	     // Create a File object that is unique by appending _copyn where n is an integer
	     int copyNumber = 0;                              // Copy number
	     String nameAdd = null;                           // String to be appended                
	     File copy = null;
	     do {
	       nameAdd = "_copy"+(++copyNumber);   // String to be appended
	       copy = new File(name.substring(0,period) + nameAdd + name.substring(period)); //start after.to end
	     } while(copy.exists());                        // If the name already exists, go again

	     return copy;   
	  }
	  
  public static void main(String[] args) 
  {
   
    String filePath = "e:/programingExample/files/insertLineNumber.txt";                
    File inputFileObject = new File(filePath);
    if(!inputFileObject.isFile()) 
    {                   
    	System.out.println("File "+filePath+" does not exist.");
        System.exit(1);
    }
    FileInputStream fileInputStreamObject = null;
   
    // Create the file input stream
    try 
    {
    	fileInputStreamObject = new FileInputStream(inputFileObject); 
    } 
    catch(FileNotFoundException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    FileChannel fileInputChannelObject = fileInputStreamObject.getChannel();     // File channel for input
    ByteBuffer byteBufferInputObject = ByteBuffer.allocate(512);  // Buffer for 512 ASCII characters   
        
    // RegulerExpression for pattern
    Pattern linePattern = Pattern.compile(".*\\r?\\n",Pattern.MULTILINE); 
    
    // Create a new file for Writing file with lineNumber
    //passing the input file to make it copy file
    File fileOutObject = createCopyFile(inputFileObject); 
    FileOutputStream fileOutPutStreamObject = null;
    System.out.println("created Copy file is: "+fileOutObject.getName());               
   
    // Create the output file stream
    try 
    {
    	fileOutPutStreamObject = new FileOutputStream(fileOutObject); 
    } 
    catch(FileNotFoundException e)
    {
     System.out.println("File Not Found .Please Check");
      System.exit(1);
    }
    
    // Channel for output 
    FileChannel outChannelObject = fileOutPutStreamObject.getChannel();         
    ByteBuffer outBufferObject = ByteBuffer.allocate(700);      
    
    Matcher matchCommpleteLine = null;                // Matcher for a complete line
    String inputBufferData = null;                    // Stores the input buffer data as Unicode
    String lineNumberinString = null;                 // Stores a line number as a string
    int lineAtEnd = 0;                                // Offset for part of a line at end of inStr
    byte[] asBytesData = null;                        // Input buffer contents as byte array
    int lineNumber = 0;                               // Line number counter
    
    try {
        // Read the file a buffer at a time
      while(fileInputChannelObject.read(byteBufferInputObject) != -1) 
      {
    	    // Flip the buffer ready to get the data
			byteBufferInputObject.flip();
			asBytesData = new byte[byteBufferInputObject.remaining()];//til end of the line
			byteBufferInputObject.get(asBytesData);
			inputBufferData = new String(asBytesData); //convert Byte Data into string
			outBufferObject.clear();

			// Match complete lines from the buffer data that is now in inStr
			matchCommpleteLine = linePattern.matcher(inputBufferData);
       
			// While we match a line
			//it will execute when givin pattern will match
			while(matchCommpleteLine.find())  
             {       
					lineNumberinString = String.format("%04d ", ++lineNumber);
					outBufferObject.put(lineNumberinString.getBytes()).put(matchCommpleteLine.group().getBytes());
					lineAtEnd = matchCommpleteLine.end();   // to indicate end of line
             }             
        
				// Clear the space and ready for next byte
				byteBufferInputObject.clear();
				
				// Put any leftover from instr (any part of a line) back in input buffer
				byteBufferInputObject.put(inputBufferData.substring(lineAtEnd).getBytes());

				// Write the contents of the output buffer to the file
				outBufferObject.flip();  //means efter each line it will be clear then again start for next line
				outChannelObject.write(outBufferObject);     //here is writing into copy file    
     }

     System.out.println("\n control reached to end of file.");
     fileInputStreamObject.close();                                // Close the stream and the channel
     fileOutPutStreamObject.close();

    } catch(IOException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

 
}