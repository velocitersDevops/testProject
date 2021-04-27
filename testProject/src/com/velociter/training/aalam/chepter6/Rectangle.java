// Chapter 6 Exercise 3

// This class now inherits implementation of the ShapeInterface
// interface so it must implement the show() method, otherwise
// it would be and abstract class.

package com.velociter.training.aalam.chepter6;

public class Rectangle extends Shape
{
  private Point bottomRight;        // Bottom right of rectangle. 

  public Rectangle(Point startDiag, Point endDiag)
  {
    // Position of rectangle is top left corner - minimum x and y:
    position = new Point(Math.min(startDiag.x,endDiag.x),Math.min(startDiag.y,endDiag.y));
    // Bottom right is relative to top left:
    bottomRight = new Point(Math.max(startDiag.x,endDiag.x) - position.x,
                            Math.max(startDiag.y,endDiag.y) - position.y);
  }

  
  public String toString() 
  { 
    // Return a string representation of the object:
    return "Rectangle: Top Left: " + position + " Bottom Right: " +  position.add(bottomRight);                                              
  }

  // Display the rectangle:  
  public void show()
  {				
    System.out.println("\n" + toString());
  }
}
