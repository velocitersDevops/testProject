package com.velociter.training.ankit.readingfiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HexaDecimalValues 
{
	public static void main(String ar[]) throws FileNotFoundException
	{  
		String filePath = "E:\\New folder\\HexadecimalFormate.txt";
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
		
  /*       
         String inputFilePath = "E:\\New folder\\HexadecimalInput.txt";  
          try {
			FileWriter writer=new FileWriter(inputFilePath);
			FileReader fr=new FileReader(filePath);
			//BufferedReader br=new BufferedReader(fr);
			int index = 0;
            int counting = 0;
            String strData;
            try
            {
                  while ((i=fileInputStream.read()) !=-1) {
                    // System.out.printf("hellooo ");
     				
     				String strdata=String.format("%02x",Integer.valueOf(i));
     				writer.write(strdata);    //
     			    //counting++;

					
     			}
            	
            	
            	
            }
            catch(Exception e)
            {
               e.printStackTrace();	
            }
            
            writer.close();
            
		}

	catch (IOException e) {
			e.printStackTrace();
		}
    */      
         
          
}
	
}
