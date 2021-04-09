package com.velociter.training.ankit.readingfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HexaDecimalValues 
{
	public static void main(String ar[]) throws FileNotFoundException
	{  
		String filePath = "E:\\hexa\\Hexadecimal.txt";
	   FileInputStream fileInputStream=new FileInputStream(filePath);
		int i = 0;
        int hexaValue = 0;
        int groupValue=0;
          try {
			while ((i = fileInputStream.read()) != -1)
			{
				 System.out.printf("%1X ", i);     //print element with 1space 
				 hexaValue++;
                if (hexaValue ==8)                 //condition for give extra space when group of 8 hexa value completed
                {
                	
			        System.out.print("    ");
			        hexaValue = 0;                //again hexaValue will be 0 to start from 0 to 8
			        groupValue++;                  //lineChange 
			    }
                
                if (groupValue==5)                //when group value 5 then jump to next line
                {
			        System.out.println();
			        groupValue = 0;               //again groupValue will be 0 to start from 0 to 5
			    }
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}
	
}
