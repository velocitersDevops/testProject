package com.velociter.training.mukesh.chapter8;

import java.io.StreamTokenizer;

import java.io.InputStreamReader;
import java.io.IOException;

public class ParseInput {
  private StreamTokenizer tokenizer;
  private char separator = ',';

  // Constructor requires the separator character as the argument
  public ParseInput(char separator)
  {
    this.separator = separator;
    tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
    setTokenizerState();
  }

  // Sets the tokenizer to accept anything except the separator and end-of-line as
  
  private void setTokenizerState()
  {
    tokenizer.resetSyntax();              
    tokenizer.wordChars('\u0000',(char)(separator-1));    // Everything is a word character
    tokenizer.wordChars((char)(separator+1),'\u00ff');    // except for the separator
    tokenizer.whitespaceChars('\n','\n');                 // Make end-of-line whitespace(and therefore a word delimiter)
    tokenizer.whitespaceChars(separator,separator);       // Delimiter passed to constructor seaparates words
    tokenizer.eolIsSignificant(true);                     // End-of-line to be reported as TT_EOL
    
  }

  // Read tokens from the input
  public String[] readTokens() 
  {
    int type = 0;                                         // Store the value returned by nextToken()
    int stringCount = 5;                                     // String capacity increment
    String[] tokens = new String[stringCount];               // Will store the tokens that we find
    int numberOfTokens = 0;                                      // Number of tokens stored
    try {
      if(numberOfTokens == tokens.length)
      {
        String[] newTokens = new String[tokens.length+stringCount];
        // Copy old array contents to new array
        for(int i = 0 ; i<numberOfTokens ; i++) 
        {
          newTokens[i] = tokens[i];
        }
        tokens = newTokens;                                // Replace old array by new array
      }
      while((type = tokenizer.nextToken()) != StreamTokenizer.TT_EOL) 
      {   
        
        if(type == StreamTokenizer.TT_WORD)
        {                             // Check for a word
          tokens[numberOfTokens++] = tokenizer.sval;                             // and save it in the vector

        } else 
        {
          assert false;                                                   // We only expect words
        }
      }
      // Store tokens in array of exactly the right size
      if(numberOfTokens<tokens.length) 
      {
        String[] newTokens = new String[numberOfTokens];
        // Copy old array contents to new array
        for(int i = 0 ; i<numberOfTokens ; i++) 
        {
          newTokens[i] = tokens[i];
        }
        tokens = newTokens;                                               // Replace old array by new array
      }
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    return tokens;    
  }

  // Convenience method to change the separator
  // We don't use this in the test program
  public void setSeparator(char separator) {
    this.separator = separator;
    setTokenizerState();
  }
}