package com.velociter.training.ankit.chapter6;
public abstract class Shape implements interfaceShape 
{
	// Method to move a shape:
	  public void move(double xDelta, double yDelta) {
	    // Move the shape by xDelta in x, and yDelta in y:
	    position.x += xDelta;		
	    position.y += yDelta;
	  }

	  public abstract void show();	// Abstract method to output a shape.

	  protected Point position;     // Position of a shape.
	}