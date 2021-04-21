

package com.velociter.training.aalam.chepter6;

public class Line extends Shape 
{
  private Point end;                                    // Line end point.
  public Line(Point start, Point end) 
  {
    
    position = new Point(start);	                      // First point is position.
    this.end = new Point(end.x-start.x, end.y - start.y); // Get end point coords relative to start. 
  }

 
  public String toString() 
  {  
    return "Line: " + position + " to " + position.add(end);
  }


  public void show()                                        // Method to display a line:
  {
    System.out.println("\n"+toString());
  }

  // End point is defined relative to start point:
 
}
