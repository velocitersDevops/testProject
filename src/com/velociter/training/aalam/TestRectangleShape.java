/*
 *  Define a class for rectangle objects defined by two points, the top-left and bottom-right corners
of the rectangle. Include a constructor to copy a rectangle, a method to return a rectangle object
that encloses the current object and the rectangle passed as an argument, and a method to display
the defining points of a rectangle. Test the class by creating four rectangles and combining
these cumulatively to end up with a rectangle enclosing them all. Output the defining points of
all the rectangles you create.
 */
package com.velociter.training.aalam;

public class TestRectangleShape 
{
	public static void main(String[] args) 
	{
		
		    RectangleShape[] rects = new RectangleShape[4]; //array to old rectangle object
		    RectangleShape rectangleObject;    //create reference object of type RectangleShape 
		 
		    // Initialize the RectangleShapes as arbitrary sizes and at arbitrary positions:
		    for(int i = 0 ; i < rects.length ; ++i) 
		    {
		      rects[i] = new RectangleShape(Math.random()*100, Math.random()*100, Math.random()*100, Math.random()*100);
		      System.out.print("Coords of RectangleShape " + i + " are: ");
		      System.out.println(rects[i]);
		    }
		 
		    // Initialize the enclosing RectangleShape to be first RectangleShape
		    rectangleObject = rects[0];
		    
		    // This will give  result in the RectangleShape that encloses them all.
		    for(RectangleShape rect : rects)  
		    {
		    	rectangleObject = rectangleObject.enclosing(rect);     //here enclosing is a reference veriable 
		    }
		 
		    System.out.println("\nCoords of Enclosing RectangleShape are ");
		    System.out.println(rectangleObject);
		  }
		  
		
	}


