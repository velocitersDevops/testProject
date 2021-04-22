

/*
 *  BASE CLASS FOR SHAPES - it is still an abstract class since it does not
 implement the show() method declared in the ShapeInterface. 
 The move() method that  is implemented here assumes shapes are defined 
 relative to the reference point, position, so subclasses of this class
 must be defined in this way. Where this is not convenient an alternative is
 to implement a separate move() method in each derived class.
 * */
 

package com.velociter.training.aalam.chepter6;
public abstract class Shape implements ShapeInterface 
{
	protected Point position;     
  public void move(double xDelta, double yDelta) 
  {
   
    position.x += xDelta;		 // Move the shape by xDelta in x, and yDelta in y:
    position.y += yDelta;
  }

  
}
