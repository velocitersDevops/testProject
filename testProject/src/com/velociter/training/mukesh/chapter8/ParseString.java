package com.velociter.training.mukesh.chapter8;

import java.io.StreamTokenizer;

import java.io.StringReader;
import java.io.IOException;

public class ParseString 
{
  public static void main(String[] args) 
  {
    String input = "mukesh,vivek,31,ankit,alam,kunal,rahul,21";
   
    StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(input));
    char separator = ',';     
                       
    streamTokenizer.whitespaceChars(separator,separator);                       // Whitespace separates words so just the separator
  
    try 
    {
      while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) 
      {   
        if(streamTokenizer.ttype== StreamTokenizer.TT_WORD) { // Check for a word
          System.out.println(streamTokenizer.sval);               // and output it 
        } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            System.out.println(streamTokenizer.nval);
         
        }
        
      }
    } 
    catch(IOException e) 
    {
      e.printStackTrace();
      System.exit(1);
    }
  }
}