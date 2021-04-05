package com.velociter.training.ankit.exceptionhandling;

public class Exception2 {

	public static int divide(int[] array, int index) throws ZeroDivideException,
	ClassifyIndexException {

    int indexUsed = 0;                 // Records the index value for each element reference.
    int numerator;                     // Store for numerator in division.
    int denominator;                   // Store for denominator in division.

try {

System.out.println("First try block in divide() entered");
numerator = array[indexUsed = index];
denominator = array[indexUsed = index+1];
array[indexUsed = index+2] = numerator/denominator;
System.out.println("Code at end of first try block in divide()");
} catch(ArithmeticException e) {
System.out.println("Arithmetic exception caught in divide()");
throw new ZeroDivideException(index+1);		// Throw new exception.
} catch(ArrayIndexOutOfBoundsException e) {
System.out.println("Out of bounds index exception caught in divide()");
// indexUsed will contain the value of the index when the exception was thrown
throw new ClassifyIndexException(indexUsed);	// Throw new exception.
}

System.out.println("Executing code after try block in divide()");
return array[index+2];		
}

public static void main(String args[]) {
int[] x = {10, 5, 0};		// Array of three integers.
int index = 0;			// Index used to access array.
int choice = 0;			// Selects the type of exception.

for(choice = 0; choice<3 ; choice++)

try {
switch(choice) {
case 0:		
index = 0;
x[1] = 0;
break;
case 1:		
index = 1;
break;
case 2:		
index = -1;
break;
}
System.out.println("\nFirst try block in main()entered");
System.out.println("result = "+divide(x,index));
} catch(ZeroDivideException e) {
int indexUsed = e.getIndex();		
if(indexUsed>0)	{			
x[indexUsed] = 1;			
x[indexUsed+1] = x[indexUsed-1];	
}
} catch(ClassifyIndexException e) {
System.out.println(e);	
} catch(ArithmeticException e) {
System.out.println("Arithmetic exception caught in main()");
} catch(ArrayIndexOutOfBoundsException e) {
System.out.println("Index out of bounds exception caught in main()");
}

System.out.println("Outside first try block in main()");
}
	
	
}
