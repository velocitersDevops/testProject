package com.velociter.training.ankit.chapter6;
public class Circle extends Shape {
	  // Constructor
	  public Circle(Point center, double radius) {
	    // Center of the circle is the position:
	    position = new Point(center);  // Store position - new Point object for independence.
	    this.radius = radius;	         // Store the radius.
	  }
	 
	  // Overrides method inherited from Object:
	  public String toString() { 
	    // Create a string representation of the object:					
	    return "Circle: Center " + position + " Radius " + radius;
	  }

	  public void show() {					
	    System.out.println("\n" + toString());
	  }

	  private double radius;	// Radius of circle.
}
