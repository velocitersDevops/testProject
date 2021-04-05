package com.velociter.training.mukesh.chapter6.shape3;
public abstract class Shape implements ShapeInterface {
  // Method to move a shape:
  public void move(double xDelta, double yDelta) {
    // Move the shape by xDelta in x, and yDelta in y:
    position.x += xDelta;		
    position.y += yDelta;
  }

  protected Point position;     // Position of a shape.
}
