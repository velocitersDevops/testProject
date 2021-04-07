package com.velociter.training.aalam.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

public class TestParseInput
{
	static String inputdata []=new String[12];
	public static void main(String[] args)  
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String with specific delimeter");
		String enterdString = sc.nextLine();
		System.out.println("Enter saprator");
	    String separater = sc.next();
	    char separator =separater.charAt(0);//returns  seprator 
	   
	try {
	        Reader reader = new StringReader(enterdString);
	        StreamTokenizer tokenizer = new StreamTokenizer(reader);
	        tokenizer.whitespaceChars(separator,separator); 
	        
	      
	        while(tokenizer.nextToken()!=StreamTokenizer.TT_EOF)
	        {
	        	if(tokenizer.ttype == tokenizer.TT_WORD)
	        	{
	        		  
	        		 System.out.printf("\"");
	        		 System.out.printf(tokenizer.sval);
	        		 System.out.printf("\"");
	        		 System.out.println();
	        	}
	        	 
	        	if(tokenizer.ttype == tokenizer.TT_NUMBER)
	        	{
	        		System.out.printf("\"");
	        		 System.out.printf("%.0f", tokenizer.nval);
	        		 System.out.printf("\"");
	        		 System.out.println();
	        	}
	        	
	        }
	 
	}catch(IOException ioException)
	{
     System.err.println("Have some issues,pleade try again");		
	}
		
	}
}
	
