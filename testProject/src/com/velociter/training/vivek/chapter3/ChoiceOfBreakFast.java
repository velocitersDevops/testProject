package com.velociter.training.vivek.chapter3;

public class ChoiceOfBreakFast
{
	 public static void main(String args[]) 
	  {	
		  int choiceForBreakfast = 0;
	
		  
		  choiceForBreakfast = (int)(6.0*Math.random());
	    
		  System.out.println("your generated number for breakfast="+choiceForBreakfast);
		   
		  switch(choiceForBreakfast) 
		    {
		      case 0:
			        System.out.println("Breakfast choice is mango");
			        break;
		      
		      case 1:
			        System.out.println("Breakfast choice is bread");
			        break;
		      
		      case 2:
			        System.out.println("Breakfast choice is fruit");
			        break;
		      
		      case 3:
			        System.out.println("Breakfast choice is juice");
			        break;
		      
		      case 4:
			        System.out.println("Breakfast choice is fried Rice");
			        break;
		      
		      case 5:
			        System.out.println("Breakfast choice is yogurt");
			        break;
		    }
	  }	

}
