package com.velociter.training.mukesh.chapter3;

public class LotteryLuckyNumbers 
{
  public static void main(String[]args) 
  {
	    int countNumberOfSets = 5;        // Number of sets of lucky numbers.
	    int sizeOfSet = 6;               // each set has 6 lucky numbers 
	    int rangeOfSets = 49;                 //select the number from 1 to 49	                 
	           

	    for(int i = 0; i < countNumberOfSets; i++) 
	    {
		      int lucky1 = 0;                  // Lucky numbers for the set of 6.
		      int lucky2 = 0;                   
		      int lucky3 = 0;                   
		      int lucky4 = 0;
		      int lucky5 = 0;                   
		      int lucky6 = 0;    
		
		      int luckyNumberCount = 0;                   // Count of numbers found in the current set
		     
		      while(luckyNumberCount < sizeOfSet) 
		      {
			      // Generate a lucky number between 0 and 48 and add 1:
			       int luckyNumber = (int)(rangeOfSets*Math.random())+1	;
			        
			        switch(luckyNumberCount) 
			        {
				          case 0:                      
						            lucky1 = luckyNumber;            
						            luckyNumberCount++;              
						            break;
				          
				          case 1:                      
						            if(luckyNumber != lucky1) 
						            {     						// check that it is different from the first
						              lucky2 = luckyNumber;         
						              luckyNumberCount++;            
						            }
						            break;
				          case 2:                      // For the third we check aginst the previous two
				            
						        	if(luckyNumber != lucky1 && luckyNumber != lucky2) 
						            {
						              lucky3 = luckyNumber;
						              luckyNumberCount++;
						            }
						            break;
				           case 3:                     
						            
						        	 if(luckyNumber != lucky1 && luckyNumber != lucky2 && luckyNumber != lucky3) 
						            {
						              lucky4 = luckyNumber;
						              luckyNumberCount++;
						            }
						            break;
				           case 4:                     
						            if(luckyNumber != lucky1 && luckyNumber != lucky2 && luckyNumber != lucky3 && luckyNumber != lucky4) 
						            {
						              lucky5 = luckyNumber;
						              luckyNumberCount++;
						            }
						            break;
				           case 5:                   
						            if(luckyNumber != lucky1 && luckyNumber != lucky2 && luckyNumber != lucky3 && luckyNumber != lucky4 && luckyNumber != lucky5)
						            {
						              lucky6 = luckyNumber;
						              luckyNumberCount++;
						            }
						            break;
	                  }				//end of switch case 
		      	}					//end of while loop

		      	System.out.print("\nSet " + (i + 1) + ":");                       

		      	System.out.print(" " + lucky1 + " " + lucky2  + " " + lucky3  + " " + lucky4  + " " + lucky5  + " " + lucky6);

	    	}					//end of for loop
  
  	}							//end of main method

}								//end of class 

