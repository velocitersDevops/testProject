package com.velociter.training.ankit.chapter6;
public class PolyLine extends Shape {
   
	private ListPoint start;                // Second point in the polyline.
	  private ListPoint end;                  // Last ListPoint in the list.
	public PolyLine(Point[] points) {
	    if(points.length<2) {
	      System.out.println("\nAt least two points are required to define a polyline"+
	                         "\nProgram terminated");
	      System.exit(1);                   // Exit the program.
	    }
      position = new Point(points[0]);    // 1st point is the reference point.
       start = new ListPoint(points[1].x-position.x, points[1].y-position.y);      
	    end = start;                        // end is the same as the start.
         for(int i = 2; i < points.length; i++) {
	      addPoint(points[i]);
	    }
	  }
      public void addPoint(Point point) {
	    ListPoint newEnd = new ListPoint(point.x-position.x, point.y-position.y);
	    end.setNext(newEnd);    // Set next variable for old end as new end.
	    end = newEnd;           // Store new point as end.
	  }

	  public String toString() {
	    String str = "PolyLine:\n" + position + " ";
	    
	    int count = 1;                        // Count of points.
	    ListPoint nextPoint = start;	  // Set the 1st point as start.

	    while(nextPoint != null) {
	      str += nextPoint.add(position)+" "; // Add the string representation of the next point.

	      if(++count%4==0) {                  // After every fourth point
	        str += "\n";                      // add a newline character.
	      }
	      nextPoint = nextPoint.getNext();    // Get the reference to the next ListPoint.
	    }
	    return str;                           // Return the string.	
	  }

	  public void show() {
	    System.out.println("\n" + toString());
	  }

	}
