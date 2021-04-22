package com.velociter.training.aalam.measures;


public class TestRectangleShape 
{
	public static void main(String[] args) 
	{
		
		    RectangleShape[] rects = new RectangleShape[4];
		    RectangleShape enclosing;
		 
		    // Initialize the RectangleShapes as arbitrary sizes and at arbitrary positions:
		    for(int i = 0 ; i < rects.length ; ++i) {
		      rects[i] = new RectangleShape(Math.random()*100, Math.random()*100, Math.random()*100, Math.random()*100);
		      System.out.print("Coords of RectangleShape " + i + " are: ");
		      System.out.println(rects[i]);
		    }
		 
		    // Initialize the enclosing RectangleShape to be first RectangleShape
		    enclosing = rects[0];
		 
		    // Combine it with each the other RectangleShapes in turn.
		    // This will result in the RectangleShape that encloses them all.
		    for(RectangleShape rect : rects)  {
		      enclosing = enclosing.enclosesing(rect);
		    }
		 
		    System.out.println("\nCoords of Enclosing RectangleShape are ");
		    System.out.println(enclosing);
		  }
		
	}


