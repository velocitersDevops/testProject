

/* DEFINES A POLYLINE AT POINT POSITION IN THE BASE CLASS.
 We will define the second and subsequent points relative to
 position so that the inherited move() method works.
 This class now inherits the implementation of the ShapeInterface
 interface so it must implement the show() method, otherwise
 it would be an abstract class.
 */
package com.velociter.training.aalam.chepter6;

public class PolyLine extends Shape 
{
  private ListPoint start;                   // Second point in the polyline.
  private ListPoint end;                     // Last ListPoint in the list.
  
  public PolyLine(Point[] points) 
  {
    assert (points.length>=2);               // Must be atleast two points

   
    position = new Point(points[0]);         // First point is the reference point.

    // Create a one point list of the second point:
    start = new ListPoint(points[1].x-position.x, points[1].y-position.y);      
    end = start;                       

    // Now add the other points:
    for(int i = 2; i < points.length; i++) 
    {
      addPoint(points[i]);
    }
  }

  // Add a Point object to  list:
  //create object
  public void addPoint(Point point)
  {
    ListPoint newEnd = new ListPoint(point.x-position.x, point.y-position.y);
    end.setNext(newEnd);                    // Set next variable for old end as new end.
    end = newEnd;                           // Store new point as end.
  }

 
  public String toString() 
  {
    String str = "PolyLine:\n" + position + " ";
    
    int count = 1;                          
    ListPoint nextPoint = start;	       

    while(nextPoint != null)
    {
      str += nextPoint.add(position)+" ";   // Add the string representation of the next point.

      if(++count%4==0)
      {                                     
        str += "\n";                        
      }
      nextPoint = nextPoint.getNext();
    }
    return str;                            	
  }

  
  public void show() 
  {
    System.out.println("\n" + toString());
  }
}
