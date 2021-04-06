
/*
 * 1. Use a StreamTokenizer object to parse a string entered from the keyboard containing a series
of data items separated by commas and output each of the items on a separate line.
 */
package com.velociter.training.aalam.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class ParseString 
{
    public static void main(String[] args) throws IOException
    {
    	 String str = "first,impresssion,is,the,last,impresssion ";
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
