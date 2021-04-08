package com.velociter.training.ankit.readingfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HexaDecimalValues 
{
	public static void main(String ar[]) throws FileNotFoundException
	{  
		String filePath = "E:\\New folder\\Hexadecimal.txt";
	   FileInputStream fileInputStream=new FileInputStream(filePath);
		int i = 0;
         int count = 0;
         int lineChange=0;
          try {
			while ((i = fileInputStream.read()) != -1) {
				 System.out.printf("%1X ", i);
			    count++;
                if (count ==8) {
                	
			        System.out.print("    ");
			        count = 0;
			       lineChange++;
			    }
                
                if (lineChange==5) {
			        System.out.println();
			        lineChange = 0;
			    }
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}
	
}
