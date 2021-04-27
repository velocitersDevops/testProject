package com.velociter.training.vivek.chapter15;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveLlineNo
{
	 public static void main(String[] args) throws Exception
	    {
	        File file = new File("C:\\AvoidFile\\abc.txt");
	        
	        
	        String contents="";
	        try (FileReader fr = new FileReader(file))
	        {
	            int content;
	            while ((content = fr.read()) != -1)
	            {
	               if(content>=47 && content<=57)
	               {
	            	 continue;  
	               }
	               else
	               {
	            	  
	            	   contents=contents+(char)content;
	               }
	            }
	            
	            
	            System.out.print(contents);
	        } 
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	    }
}
