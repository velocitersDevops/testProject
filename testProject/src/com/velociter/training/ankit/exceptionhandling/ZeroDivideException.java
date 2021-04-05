package com.velociter.training.ankit.exceptionhandling;
public class ZeroDivideException extends Throwable {
private int index =-1;	                       // Index of array element causing error.

public ZeroDivideException(){}
public ZeroDivideException(String s) {
 super(s);                                    // Call the base constructor.
}

public ZeroDivideException(int index) {
 super("/ by zero");                          // Call the base constructor.
 this.index = index;                          // Set the index value.
}
public int getIndex() {
 return index;                                // Return the index value.
}
}