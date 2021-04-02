package com.velociter.training.aalam;

public class Point 
{

	private double xCoordinate ;  //x ,y will used to hold upcoming values 
	private double yCoordinate ;
	
	// Create a Point object by using given  coordinate value x ,y
	  public Point(double xCoordinate, double yCoordinate)
	  {
	    this.xCoordinate = xCoordinate;
	    this.yCoordinate = yCoordinate;
	  }
	 
	  // Create a Point object by another Point reference ( constructor)
	  public Point(final Point oldPoint)
	  {
	   this.xCoordinate = oldPoint.xCoordinate;
	   this.yCoordinate = oldPoint.yCoordinate;
	  }
	
	 
	  // Get the value of the x coordinate
	  double getX() {
	    return xCoordinate;
	  }
	 
	  // Get the value of the y coordinate
	  double getY() {
	    return yCoordinate;
	  }
	 
	  //to return values to display
	  public String toString(){
	    return xCoordinate +","+yCoordinate;

	
   }
}
