package com.velociter.training.vivek.rectangle;

public class Point

{
	
	// Fields store the point coordinates
	  private double x;
	  private double y;
	  
	  public Point()
	  {
		  
	  }
	  public Point(double x, double y)
	  
	     {
		
		  System.out.println(x+" "+y);
		    this.x = x;
		    this.y = y;
		   
		  }
	  
		 
		  // Create a Point object from another Point
		  public Point(Point p)
		  {
			
			  System.out.println(x+" "+y);
		    x = p.x;
		    y = p.y;
		    System.out.println(x+" "+y);
		  
		   
		  }
		 
		  // Get the value of the x coordinate
		  double getX()
		  {
			
		    return x;
		  }
		 
		  // Get the value of the y coordinate
		  double getY()
		  {
			 
		    return y;
		  }
		 
		  public String toString()
		  {
			  
		    return x +","+y;
		    //System.out.println("vivek");
		  }
		 
		 
		}


