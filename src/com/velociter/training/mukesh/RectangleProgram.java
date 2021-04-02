/*Problem Descriptions:
=============================
1. Define a class for rectangle objects defined by two points, the top-left and bottom right corners of the rectangle.

2. Include a constructor to copy a rectangle, a method to return a rectangular object that encloses the current object and the rectangle 
passed as an argument.

3. Include a method to display the defining points of the rectangle.

4. Finally test the class by creating 4 rectangles and combining these cumulatively to end up with a rectangle enclosing them all.

5. Output the defining points of the rectangle you create.
===============================
*/


package com.velociter.training.mukesh;


class Point 
{
	//these two variables declare to store the coo-ordinate points
	 private double firstPoint;
	 private double secondPoint;
	
	public Point(double firstPointValue , double secondPointValue)
	{
		firstPoint=firstPointValue;
		secondPoint=secondPointValue;
	}
	// Create a point from another Point object
	
	public Point(final Point oldPoint) 					//copy constructor
	{
		firstPoint=oldPoint.firstPoint;					// Copy firstPoint coordinate
		secondPoint=oldPoint.secondPoint;				//// Copy secondPoint coordinate
	}
	//Get the value of the first coordinate
	double getfirstPoint()
	{
		return firstPoint;
	}
	//Get the value of the second coordinate
	double getsecondPoint()
	{
		return secondPoint;
	}
	
	public String toString()
	{
		return firstPoint +","+secondPoint;
	}
	
}


class Rectangle 
{
		private Point topLeft;
		private Point bottomRight;
		
		public Rectangle(double topLeft1, double bottomRight1, double topLeft2, double bottomRight2) 
		{
			topLeft = new Point(Math.min(topLeft1,topLeft2),Math.min(bottomRight1,bottomRight2));
			bottomRight = new Point(Math.max(topLeft1,topLeft2),Math.max(bottomRight1,bottomRight2));
		}
		
		public Rectangle(Point topLeftData, Point bottomRightData) 
		{
		    topLeftData.getfirstPoint();
		    topLeftData.getsecondPoint();
		    bottomRightData.getfirstPoint();
		    bottomRightData.getsecondPoint();
		  }

		 public Rectangle(Rectangle rectangleValue) 
		 {
				    topLeft = new Point(rectangleValue.topLeft);
				    bottomRight = new Point(rectangleValue.bottomRight);
		 }
		
		 	// Methods to create a rectangle enclosing the current rectangle and the argument
		  public Rectangle encloses(Rectangle rectangleValue) 
		  {
		    // Return a new rectangle defined by the minimum firstPoint,secondPoint for to left and the and maximum firstPoint,secondPoint for bottom right
		    return new Rectangle(Math.min(topLeft.getfirstPoint(), rectangleValue.topLeft.getfirstPoint()),
		                         Math.min(topLeft.getsecondPoint(), rectangleValue.topLeft.getsecondPoint()),
		                         Math.max(bottomRight.getfirstPoint(), rectangleValue.bottomRight.getfirstPoint()),
		                         Math.max(bottomRight.getsecondPoint(), rectangleValue.bottomRight.getsecondPoint()));
		  }
		 
		  public String toString() 
		  {
			    return "Rectangle: " + topLeft + " : " + bottomRight;
		  }

}



//this class contain main method body

public class RectangleProgram 				
{
	
	
		  public static void main(String[] args) 
		  {
				  Rectangle[] rectAngleArray = new Rectangle[4];
				  Rectangle enclosing;
		 
			    for(int i = 0 ; i < rectAngleArray.length ; i++) 
			    {
			        rectAngleArray[i] = new Rectangle(Math.random()*100, Math.random()*100, Math.random()*100, Math.random()*100);
			        System.out.print("Co-ordinates of rectangle " + i + " are: ");
			        System.out.println(rectAngleArray[i]);
			    }

		    // Initialize the enclosing rectangle to be first rectangle
			   
			    enclosing = rectAngleArray[0];
			    for(Rectangle rectValue : rectAngleArray)  
			    {
			        enclosing = enclosing.encloses(rectValue);
			    }
		  
			    System.out.println("\nCoordinates of Enclosing rectangle are ");
			    System.out.println(enclosing);
			  
		  }
}

	


