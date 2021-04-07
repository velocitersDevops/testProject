package com.velociter.training.aalam.writingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class Proverbs 
{
	public static void main(String[] args) 
	{
		String directoryName = "e:/proverbs";   //we ave to create folder with name proverbs in same location
		String fileName = "proverbs.txt";
		String[] qouts =
				
			{"first impression is the  last impression.",
			 "Practice make man perfect.",
			};
		
		
		File userFile =  new File(directoryName,fileName);
		FileOutputStream outputStream = null;
		try
		{
			outputStream = new FileOutputStream(userFile,true);
		}catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		      System.exit(1);
		}
      
	try
	{
		FileWriter fileWriterObject = new FileWriter(userFile);
		for(String qout  : qouts)
		{
			fileWriterObject.write(qout +"*");
		}
		fileWriterObject.close();
		System.out.println("Successfully wroted to the file.");
	}catch(IOException e)
		    {
		    	System.out.println("Have some issues related to IO.please try again");
		    	System.exit(0);
		    }
	


		    }
		    
	}


