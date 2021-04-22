package com.velociter.training.mukesh.chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveLineNumbersOfStatement 
{
			public static File createCopyFile(File file) 
			{
			     file = file.getAbsoluteFile();                 
			     File parentDirectrory = new File(file.getParent());   
			     String name = file.getName();                   
			     int period = name.indexOf('.');                      
			     int copyNumber = 0;                              
			     String nameAdd = null;                                           
			     File copy = null;
			     do {
			       nameAdd = "_copy"+(++copyNumber);   
			       copy = new File(name.substring(0,period) + nameAdd + name.substring(period));
			     } while(copy.exists());                        
		
			     return copy;   
			  }

			
			public static void main(String[] args) 
			{
			   
				    String filePath = "E:\\newfolder\\lineNumber_copy1.txt";                 
				    
				    File fileObject = new File(filePath);
				   
				    FileInputStream fileInputStreamObject = null;
				   
				    // Create the file input stream
				    try 
				    {
				    	fileInputStreamObject = new FileInputStream(fileObject); 
				    } 
				    catch(FileNotFoundException e) 
				    {
					      System.out.println("File Not Found.Please check Your File");
					      System.exit(1);
				    }
				    //prepare both object to perform the reading data from the file
				    FileChannel fileInputChannelObject = fileInputStreamObject.getChannel();     
				    ByteBuffer byteBufferInputObject = ByteBuffer.allocate(512);   
				        
				    // The regular expression to match a line and 
				    Pattern linePattern = Pattern.compile("(^\\d+ )?(.*\\r?\\n)",Pattern.MULTILINE); 
				    
				    // Create a new file for output after delete line number
				    File fileOutputObject = createCopyFile(fileObject);
				    
				    FileOutputStream fileOutputStreamObject = null;              
				    System.out.println("Copy file is: "+fileOutputObject.getName());               
				  
				    try {
				    	fileOutputStreamObject = new FileOutputStream(fileOutputObject); 
				    } 
				    catch(FileNotFoundException e) 
				    {
				    	 System.out.println("File Not Found");
				    	 System.exit(0);
				    }

		
			    FileChannel fileOutputChannelObject = fileOutputStreamObject.getChannel();          
			    ByteBuffer byteBufferOutputObject = ByteBuffer.allocate(512);       
					    
			    Matcher lineMatchofString = null;                
			    String byteDataIntoString = null;          
			    int lineEnd = 0;                          
			    byte[] dataInBytes = null;              
	    try {
	     
	      while(fileInputChannelObject.read(byteBufferInputObject) != -1)
	      {
				byteBufferInputObject.flip(); // Flip the buffer ready to get the data
				dataInBytes = new byte[byteBufferInputObject.remaining()];
				byteBufferInputObject.get(dataInBytes);
				byteDataIntoString = new String(dataInBytes); 
				byteBufferOutputObject.clear();

				// Match complete lines from the buffer data that is now in inputBufferdData
				lineMatchofString = linePattern.matcher(byteDataIntoString);
	      
				while(lineMatchofString.find())  
	            {       
					//writing allline data into  byteBufferOutputObject
					byteBufferOutputObject.put(lineMatchofString.group(2).getBytes());
					lineEnd = lineMatchofString.end();                 
	             }             
	       
			  
				byteBufferInputObject.clear(); 

				// Write the contents of the output buffer to the file
				byteBufferOutputObject.flip();
				

				fileOutputChannelObject.write(byteBufferOutputObject);
	         }

			    
			     if(byteBufferInputObject.flip().hasRemaining())
			     {
						byteBufferOutputObject.clear();
						dataInBytes = new byte[byteBufferInputObject.remaining()];
						byteBufferInputObject.get(dataInBytes, 0, dataInBytes.length);
						lineMatchofString = Pattern.compile("(^\\d+ )?(.*)").matcher(new String(dataInBytes)); 
			       
				   if(lineMatchofString.matches())
			       {
			    	   byteBufferOutputObject.put(lineMatchofString.group(2).getBytes());
			       } 
			       else 
			       {
			    	   byteBufferOutputObject.put(byteBufferInputObject);
			       }
			 
			       byteBufferOutputObject.flip();
			    
			       fileOutputChannelObject.write(byteBufferOutputObject); 
			      }
			    
			     System.out.println("\ncontrol reached to End of file.");
			     
			     fileInputStreamObject.close();                                
			     fileOutputStreamObject.close();
			    
	    }
	    catch(IOException e) 
	    {
	      e.printStackTrace(System.err);
	      System.exit(1);
	    }
	  }	
}
