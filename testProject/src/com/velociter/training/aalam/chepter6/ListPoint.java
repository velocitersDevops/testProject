// Chapter 6 Exercise 3

package com.velociter.training.aalam.chepter6;
public class ListPoint extends Point 
{
	ListPoint next;    // Points to next point in the list.
  
  public ListPoint(double x, double y)  // Constructor to create an object from coordinates:
  {
    super(x, y);    // Call Point constructor.
    next = null;    // Set the next as end point.
  }

  
  public ListPoint(Point point)
  {
    super(point);
    next = null;
  }

  // Set the pointer to the next ListPoint:
  public void setNext(ListPoint next) 
  {
    this.next = next;
  }

  // Get the next point in the list:
  public ListPoint getNext()
  {
    return next;
  }

  // Return class name & coordinates:
  public String toString() {
    return "ListPoint " + x + "," + y;
  }
}
