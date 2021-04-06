package com.velociter.training.mukesh.chapter6.shape3;


// This class now inherits implementation of the ShapeInterface interface 
// from the Shape class so it must implement the show() method, otherwise
// it would be an abstract class.

public class Circle extends Shape {
  // Constructor
  public Circle(Point center, double radius) {
    // Center of the circle is the position:
    position = new Point(center);	// Store position - new Point object for independence.
    this.radius = radius;		// Store the radius.
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
