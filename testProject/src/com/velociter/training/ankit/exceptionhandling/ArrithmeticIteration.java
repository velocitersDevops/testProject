package com.velociter.training.ankit.exceptionhandling;

public class ArrithmeticIteration extends Throwable {
	  private int iteration = 0;              

	  // Default Constructor:
	  public ArrithmeticIteration(){}
      public ArrithmeticIteration(String s) {
	    super(s);                                    
	  }
      public ArrithmeticIteration(int iteration) {
	    super();                                    
      this.iteration = iteration;                 
	  }
      public int getIteration()	{                   
	    return iteration;                            
	  }
	}