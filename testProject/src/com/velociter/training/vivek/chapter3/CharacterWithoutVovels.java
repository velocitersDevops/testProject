package com.velociter.training.vivek.chapter3;

public class CharacterWithoutVovels 
{
	  public static void main(String args[])   
	  {
		    int counter = 0;                
		    int numberToGenerate = 20;     
		    char alphabateSymbol = 0;               
		
		    
		    while( counter < numberToGenerate )
		    {
			      
			    alphabateSymbol = (char) (26*Math.random() + 'A');               //generate 0-25 randomly number and cast to character
			   
			      switch(alphabateSymbol) 
			      {
				        //Vowels are ignored if generated 
				        case 'A':
				        case 'E':
				        case 'I':
				        case 'O':
				        case 'U':
				          break;
				        
				        default:
				          
						        	//Consonant are displayed
						          System.out.print(alphabateSymbol + " ");
						          counter++;
						          break;
			      }
		    }
	  }
}
