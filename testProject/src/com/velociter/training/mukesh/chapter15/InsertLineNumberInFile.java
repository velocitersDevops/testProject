package com.velociter.training.mukesh.chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InsertLineNumberInFile
{
		  public static File createCopyFile(File userFile) 
		  {
				 userFile = userFile.getAbsoluteFile();                 
			     
				 File parentDirectory = new File(userFile.getParent());    
			     String filename = userFile.getName();                 
			     int period = filename.indexOf('.');                  
			     
			     int copyNumber = 0;                              
			     String nameAdd = null;                                          
			     File copy = null;
			     do 
			     {
			       nameAdd = "_copy"+(++copyNumber);              // in String _copy to be appended
			       copy = new File(filename.substring(0,period) + nameAdd + filename.substring(period)); 
			     } while(copy.exists());                        
		
			     return copy;   
		    }
	  
		  public static void main(String[] args) 
		  {
				   
				    String filePath = "E:\\newfolder\\LineNUmber.txt";                
				    
				    File file = new File(filePath);
				    
				    FileInputStream fileInputStreamObject = null;
				   
				    // Create the file input stream
				    try 
				    {
				    	fileInputStreamObject = new FileInputStream(file); 
				    } 
				    catch(FileNotFoundException e)
				    {
				      e.printStackTrace(System.err);
				      System.exit(1);
				    }
			   
				    FileChannel fileInputObject = fileInputStreamObject.getChannel();     // File channel for input
				    ByteBuffer byteBufferInput = ByteBuffer.allocate(512);     
							        
				    // RegulerExpression for pattern
				    Pattern linePattern = Pattern.compile(".*\\r\\n",Pattern.MULTILINE); 
				    
				    File fileOutObject = createCopyFile(file);     // create one copy file
				    
				    FileOutputStream fileOutPutStreamObject = null;
				    
				    System.out.println("created Copy file is: "+fileOutObject.getName());               
				   
				    // Create the output file stream
				    try 
				    {
				    	fileOutPutStreamObject = new FileOutputStream(fileOutObject); 
				    } 
				    catch(FileNotFoundException e)
				    {
				     System.out.println("File Not Found Check");
				      System.exit(1);
				    }
    
				    // Channel for output 
				    FileChannel outChannelObject = fileOutPutStreamObject.getChannel();         
				    ByteBuffer outBufferObject = ByteBuffer.allocate(700);      
				    
			    Matcher lineMatch = null;                
			    String inputBufferData = null;                    
			    String NumberinString = null;                 
			    int lineAtEnd = 0;                                
			    byte[] bytesData = null;                        
			    int lineNumber = 0;                               
    
			try 
			{
        		// Read the file a buffer at a time
		      while(fileInputObject.read(byteBufferInput) != -1) 
		      {
		    	    // Flip the buffer ready to get the data
					byteBufferInput.flip();
					
					bytesData = new byte[byteBufferInput.remaining()];                //until end of the line
					
					byteBufferInput.get(bytesData);
					inputBufferData = new String(bytesData); 						//convert Byte Data into string
					outBufferObject.clear();
		
					// Match complete lines from the buffer data that is now in inStr
					lineMatch = linePattern.matcher(inputBufferData);
		       
					while(lineMatch.find())  
		             {       
							NumberinString = String.format("%04d ", ++lineNumber);
							outBufferObject.put(NumberinString.getBytes()).put(lineMatch.group().getBytes());
							lineAtEnd = lineMatch.end();   
		             }             
		        
						// Clear the space and ready for next byte
						byteBufferInput.clear();
						
						byteBufferInput.put(inputBufferData.substring(lineAtEnd).getBytes());
		
						// Write the contents of the output buffer to the file
						outBufferObject.flip();  
						outChannelObject.write(outBufferObject);         
		      	}

			     
	      			System.out.println("\n control reached to end of file.");
			     
	      			fileInputStreamObject.close();                                // Close the stream and the channel
			     
	      			fileOutPutStreamObject.close();
			
		    } 
		    catch(IOException e) 
		    {
		      e.printStackTrace(System.err);
		      System.exit(1);
		    }
  } 
}
