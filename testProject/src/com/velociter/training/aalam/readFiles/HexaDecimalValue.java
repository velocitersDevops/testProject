package com.velociter.training.aalam.readFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HexaDecimalValue 
{

	public static void main(String[] args) 
	{
		int i=0;
		int hexa8value = 0;
		int groupValue=0;
		String filePath = "e:\\hexa\\Hexadecimal.txt";
		FileInputStream fileInputStreamObject = null;
		
		try
		{
			fileInputStreamObject = new FileInputStream(filePath);
			try {
				while((i=fileInputStreamObject.read())!=-1)
				{
					System.out.printf("%3X",i);
					hexa8value++;
					if(hexa8value == 8)
					{
						System.out.print("   ");  //3space
						hexa8value=0;
						groupValue++;
					}
					if(groupValue == 5)
					{
						System.out.println();  //jump to next line
						groupValue=0;
					}
					
				}
			} catch (IOException ioException) 
			{
				
				System.err.println("Have some issues Related to I/O Operation");
				System.exit(0);
			}
		}catch(FileNotFoundException e)
		{
			System.err.println("File not found Please verify");
			System.exit(0);
		}

	}

}
