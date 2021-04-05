package com.velociter.training.ankit.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class ParseString {
public static void main(String[] args) throws IOException
	    {
	    	 String str = "Ankit,ankit,shekh /mukesh";
	    	    char separator = ',';
	    	    
			        Reader reader = new StringReader(str);
			        
			        StreamTokenizer tokenizer = new StreamTokenizer(reader);
			        
			        tokenizer.whitespaceChars(separator,separator);  
			       // System.out.println(tokenizer.nextToken());
			        while(tokenizer.nextToken()!=StreamTokenizer.TT_EOF)
			        {
			            System.out.println(tokenizer.sval);
			        }
		 }
	}
