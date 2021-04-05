package com.velociter.training.ankit.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
public class TestParseInput {
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String ");
		String str = sc.nextLine();
	    char separator = '/';
	    char separater = '@';
	   
	
	        Reader reader = new StringReader(str);
	        StreamTokenizer token = new StreamTokenizer(reader);
	        token.whitespaceChars(separator,separater);  
	        while(token.nextToken()!=StreamTokenizer.TT_EOF)
	        {
	        	if(token.ttype == token.TT_WORD)
	        	{
	        		  System.out.printf("\"");
	        		  System.out.print(token.sval);
	        		  System.out.printf("\"");
	        		  System.out.println();
	        	}
	        	if(token.ttype == token.TT_NUMBER)
	        	{
	        		//System.out.println(tokenizer.nval);
	        		System.out.printf("\"");
	        		 System.out.printf("%.0f", token.nval);
	        		 System.out.printf("\"");
	        		 System.out.println();
	        	}
	            
	        }
		
	
    	
        
        
        
        
        
        
        
        
        
//        //creating ParseInput object
//        ParseInput parseInputObject = new ParseInput();
//        
//        //calling getInput(String input) method to pass argument
//        parseInputObject.getInput(input);
	}

}
