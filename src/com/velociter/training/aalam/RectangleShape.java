
/*
 * 
 * Define a class for rectangle objects defined by two points, the top-left and bottom-right corners
of the rectangle. Include a constructor to copy a rectangle, a method to return a rectangle object
that encloses the current object and the rectangle passed as an argument, and a method to display
the defining points of a rectangle. Test the class by creating four rectangles and combining
these cumulatively to end up with a rectangle enclosing them all. Output the defining points of
all the rectangles you create.
 */

//1 -two points, the top-left and bottom-right corners of the rectangle
//2 -Include a constructor to copy a rectangle
//3 -a method to return a rectangle object that encloses the current object and the rectangle passed as an argument,
//4 -and a method to display the defining points of a rectangle
//5 -Test the class by creating four rectangles and combining these cumulatively to end up with a rectangle enclosing them all
//6 -Output the defining points of all the rectangles you create.


package com.velociter.training.aalam;

public class RectangleShape 
{

	 //1 -two points, the top-left and bottom-right corners of the rectangle
	private Point topLeft;
    private Point bottomRight;
    
    //here we are using constructor overloading
    //in below constructor   will get minimum and maximum coordinate point for rectangle from main()

    public RectangleShape(double x1, double y1, double x2, double y2) 
    {
        topLeft =  new Point(Math.min(x1,x2),Math.min(y1,y2));      //here we will get (minimum x1 and y1 coordinate)
        bottomRight = new Point(Math.max(x1,x2),Math.max(y1,y2));   //here we will get (maximum x2 and y2 coordinate)
    }
    
    
   
    public RectangleShape(Point tl, Point br) 
    {
        this(tl.getX(), tl.getY(), br.getX(), br.getY());
     }
    
    public RectangleShape(RectangleShape rect) 
    {
        topLeft = new Point(rect.topLeft);
        bottomRight = new Point(rect.bottomRight);
    }
    
    // Return a new rectangle defined by the minimum x,y for to topLeft and the and maximum x,y for bottomRight
    //purpose -to get actual minimum x1,y1 axis and maximum x2 and y2 axis 
  //3 -a method to return a rectangle object that encloses the current object and the rectangle passed as an argument,
    public RectangleShape enclosing(RectangleShape rect)
    {
        
        return new RectangleShape(Math.min(topLeft.getX(), rect.topLeft.getX()), //here we are calling RectanleShape constructor with 2 parameter 1 from Point class 2nd from Rectangle class
         Math.min(topLeft.getY(), rect.topLeft.getY()),                          // for axis 2 min xcoordinate and 2 max ycoordinate and it will return Rectangle object 
         Math.max(bottomRight.getX(), rect.bottomRight.getX()),
         Math.max(bottomRight.getY(), rect.bottomRight.getY()));
     }
    
    //4 -and a method to display the defining points of a rectangle
    public String toString()  {
        return "Rectangle: " + topLeft + " : " + bottomRight;
      }

}
