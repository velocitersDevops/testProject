

// This class now inherits implementation of the ShapeInterface interface 
// from the Shape class so it must implement the show() method, otherwise
// it would be an abstract class.

package com.velociter.training.aalam.chepter6;
public class Circle extends Shape
{
	private double radius; // Radius of circle.

	public Circle(Point center, double radius) // Center of the circle is the position:
	{
		position = new Point(center);          // Store position - new Point object for independence.
		this.radius = radius;                  // Store the radius.
	}

	// Overrides method inherited from Object:
	public String toString() 
	{
		return "Circle: Center " + position + " Radius " + radius;
	}

	public void show()
	{
		System.out.println("\n" + toString());
	}
 
}
