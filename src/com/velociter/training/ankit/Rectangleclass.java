package com.velociter.training.ankit;

 class Point {
  //Points for coordinate  store the point coordinates from rectangle
	  private double x;
	  private double y;
   //First Constructor get new coordinates
   public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
 
  // Second constructor fixed value of coordinate
  public Point(final Point point) {
    x = point.x;
    y = point.y;
  }
 
  // x coordinate current 
  double getX() {
    return x;
  }
 
  // y coordinate current
  double getY() {
    return y;
  }
 
  public String toString(){
    return x +","+y;
  }
}


 class Rectangle 
 {
  private Point topLeft;
  private Point bottomRight;
 
 public Rectangle(double x1, double y1, double x2, double y2) {
    topLeft = new Point(Math.min(x1,x2),Math.min(y1,y2)); //topleft uses the smaller of x1,x2 and y1,y2
    bottomRight = new Point(Math.max(x1,x2),Math.max(y1,y2)); //bottomright uses the larger value x1,x2 and y1,y2
  }

  public Rectangle(Rectangle rect) {
    topLeft     = new Point(rect.topLeft);
    bottomRight = new Point(rect.bottomRight);
  }
  
  public Rectangle(Point topL, Point bottomR) {
	    this(topL.getX(), topL.getY(), bottomR.getX(), bottomR.getY());
	  }
 
  // Methods to create a rectangleEnClosing the current rectangle and the argument
  public Rectangle encloses(Rectangle rect) {
  
    return new Rectangle(Math.min(topLeft.getX(), rect.topLeft.getX()),Math.min(topLeft.getY(), rect.topLeft.getY()),
                         Math.max(bottomRight.getX(), rect.bottomRight.getX()),Math.max(bottomRight.getY(), rect.bottomRight.getY()));
 }
 
  public String toString()  {
    return "" + topLeft + " : " + bottomRight;
  }
}

 public class Rectangleclass
	{
	  
    	  public static void main(String args[]) 
		  {
	      Rectangle[] rectangle = new Rectangle[4];
	      Rectangle enClosing;
	 
	   
	    for(int i = 0 ; i < rectangle.length; ++i) {
	      rectangle[i] = new Rectangle(Math.random()*100, Math.random()*100, Math.random()*100, Math.random()*100);
	      System.out.print("Coords of rectangle " + i + " are: ");
	     // System.out.println(rectangle[i].toString());
	      System.out.println(rectangle[i]+"\n");
	    }
	  
	    enClosing = rectangle[0];
	    for(Rectangle rect : rectangle) //result  
	    {
	     enClosing =enClosing.encloses(rect);
	    }
	 
	    System.out.print("Coords of enClosing rectangle are ");
	    System.out.println(enClosing);
	  }
	}