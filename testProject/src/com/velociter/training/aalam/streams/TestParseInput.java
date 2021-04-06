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
		String str = sc.nextLine();
		System.out.println("Enter saprator");
	    String separater = sc.next();
	    char separator =separater.charAt(0);//returns  seprator 
	   
	try {
	        Reader reader = new StringReader(str);
	        StreamTokenizer tokenizer = new StreamTokenizer(reader);
	        tokenizer.whitespaceChars(separator,separator); 
	        
	        int i=0;
	        while(tokenizer.nextToken()!=StreamTokenizer.TT_EOF)
	        {
	        	if(tokenizer.ttype == tokenizer.TT_WORD)
	        	{
	        		inputdata[i] = tokenizer.sval;
	        	}
	        	 
	        	if(tokenizer.ttype == tokenizer.TT_NUMBER)
	        	{
	        		double data = tokenizer.nval;
	        		inputdata[i] = Double. toString(data);
	        	}
	        	i++;
	        }
	       // Object item[] =null;
	}catch(IOException ioException)
	{
     System.err.println("Have some issues,pleade try again");		
	}
	        for(int j=0;j<inputdata.length-1;j++)
	        {
	        	
	    	 // int numericValue = Integer.parseInt(inputdata[j]); 
	    	 // System.out.println(numericValue);
        		System.out.printf("\"");
        		 System.out.printf(inputdata[j]);
        		 System.out.printf("\"");
        		 System.out.println();
        		
        		 
	        }
		
	}
}
	
