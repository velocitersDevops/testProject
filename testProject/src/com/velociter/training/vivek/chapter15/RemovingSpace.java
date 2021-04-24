package com.velociter.training.vivek.chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemovingSpace 
{
	public static void main(String[] args) throws Exception
	{  File file = new File("C:\\AvoidFile\\abd.txt");
    
    
    String contents="";
    try
    {
    FileReader fr = new FileReader(file);
    
        int content;
        while ((content = fr.read()) != -1)
        {
           if(content==' ')
           {
        	 continue;  
           }
           else
           {
        	  
        	   contents=contents+(char)content;
           }
        }
        
        
        System.out.println(contents);
    } 
    catch (IOException e)
    {
        e.printStackTrace();
    }}


}
