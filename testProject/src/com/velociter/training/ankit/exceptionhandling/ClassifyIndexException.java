package com.velociter.training.ankit.exceptionhandling;

public class ClassifyIndexException extends Throwable {
  private int index = -1;    		// Index of array element causing error.
  private String message;  		// String identifying exception.

  // Default Constructor:
  public ClassifyIndexException() {    
	  message = "Index value is not known.";  	// Set defaults for exception string. 
  }

  // Standard constructor:
  public ClassifyIndexException(String s) {
    super(s);                                         // Call the base constructor.
    message = "Index value is not known.";          // Set defaults for exception string. 
  }

  public ClassifyIndexException(int index) {
    super("Index is not within scope of array.\n");   
    this.index = index;                               
    if(index < 0) 
    { 
    	message = "Index to array is negative. Index = " + index;
    }
    else
    {                                          
    	message = "Index to array is beyond last array element. Index = "+index;
    }
  }
public int getIndex() {
    return index;  }

 public String toString() {
    return getMessage() + message;
  }
}
