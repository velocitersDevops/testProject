package com.velociter.training.ankit.chapter6;
public class ShapeList {
	  // Construct a ShapeList from a single shape:
	  public ShapeList(Shape shape) {
	    // Create a one shape list:
	    start = new ShapeNode(shape);
	    end = start;
	  }

	  
	  public ShapeList(Shape[] shapes) {
	    this(shapes[0]);            // Create a one shape list.
	    

	    for(int i=1 ; i<shapes.length ; i++) //Another Shape list
	      add(shapes[i]);
	  }

	  public void add(Shape data) {
	    ShapeNode newEnd = new ShapeNode(data);	// Create a new list node
	    if(start == null)                       // If the list is empty
	      end = start = newEnd;			            // set the first & last
	    else {				                          // references to refer to new shape
	      end.setNext(newEnd);			            // Otherwise set next reference
	      end = newEnd;				                  // to new shape's reference.
	    }						                            // Update end reference.
	  }


	  // Output all the shapes in the list:
	  public void show() {
	    System.out.println("\nShapeList shapes are:");
	    ShapeNode current = start;                   // Set current to reference start.

	    while(current != null) {                     // If there is a current shape.					
	      current.show();                            // Display it.
	      current = current.getNext();               // Get the next element in the list.
	    }
	  }

	  private ShapeNode start;                       // Reference to first Shape in List.
	  private ShapeNode end;                         // Reference to last Shape in List.

	  // Inner class defines a node in a linked list of shapes:
	  class ShapeNode {
	    // Constructor:
	    public ShapeNode(Shape shape) {
	      this.shape = shape;                        // Store the Shape object.
	      next = null;                               // Initialize the next reference.
	    }

	    // Method to set the reference to the next shape:
	    public void setNext(ShapeNode next) {
	      this.next = next;
	    }

	    // Get the reference to the next shape:
	    public ShapeNode getNext()  {
	      return next;
	    }

	    // Overrides the method inherited from Object:
	    public String toString() {
	      return shape.toString();
	    }

	    // Output the shape contained in the ShapeNode:
	    public void show() {
	      System.out.println(toString());
	    }

	    ShapeNode next;                              // A reference to the next shape node in the list.
	    Shape shape;                                 // A reference to the shape object.
	  }
	}
