/*
 * Define a class for rectangle objects defined by two points, the top-left and bottom-right corners
of the rectangle. Include a constructor to copy a rectangle, a method to return a rectangle object
that encloses the current object and the rectangle passed as an argument, and a method to display
the defining points of a rectangle. Test the class by creating four rectangles and combining
these cumulatively to end up with a rectangle enclosing them all. Output the defining points of
all the rectangles you create.
 */

package com.velociter.training.aalam.measures;

public class RectangleShape 
{

	private Point topLeft;
    private Point bottomRight;
    
    //here we are using constructor overloading
    //int below constructor we will get minimum and maximum coordinate point for rectangle
    public RectangleShape(double x1, double y1, double x2, double y2) 
    {
       
        topLeft =  new Point(Math.min(x1,x2),Math.min(y1,y2));
        bottomRight = new Point(Math.max(x1,x2),Math.max(y1,y2));
    }
    
    
    public RectangleShape(Point tl, Point br) 
    {
        this(tl.getX(), tl.getY(), br.getX(), br.getY());
     }
    
    
    public RectangleShape(RectangleShape rect) {
        topLeft = new Point(rect.topLeft);
        bottomRight = new Point(rect.bottomRight);
      }
    
    // Return a new rectangle defined by the minimum x,y for to left and the and maximum x,y for bottom right
  //3 -a method to return a rectangle object that encloses the current object and the rectangle passed as an argument,
    public RectangleShape enclosesing(RectangleShape rect)
    {
        
        return new RectangleShape(Math.min(topLeft.getX(), rect.topLeft.getX()),
         Math.min(topLeft.getY(), rect.topLeft.getY()),
         Math.max(bottomRight.getX(), rect.bottomRight.getX()),
         Math.max(bottomRight.getY(), rect.bottomRight.getY()));
     }
    
    //4 -and a method to display the defining points of a rectangle
    public String toString()  {
        return "Rectangle: " + topLeft + " : " + bottomRight;
      }
}
