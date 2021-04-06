//INPUT:
//create a rectangular array containing a multiplication table from 1 * 1 up to 12*12.

//OUTPUT:
//Output the table as 13 columns with the numeric values right-aligned in columns.


package com.velociters.chapter4;
public class MatrixNcrossN 
{
	   public static void matrix(int TABLE_SIZE)          //create method named matrix which takes final int table size as a argument
	   {
		    int[][] table = new int[TABLE_SIZE][TABLE_SIZE];
		 
		    for(int row = 0 ; row < table.length ; row++)
		    {
			      for(int column = 0 ; column< table[row].length ; column++) 
			      {
			        table[row][column] = (row+1)*(column+1);				// calculating n cross n matrix and store table 2d array
			      }
		    }
		    
		    //printing heading of row and column
		   
		    System.out.print("      :");             
		    for(int column = 1 ; column <= table[0].length ; column++) 
		    {
		      System.out.print((column<10 ? "    ": "   ") + column);
		    }
		   
		    System.out.println();
		    System.out.print("-------");
		    for(int space=1;space<=TABLE_SIZE;space++)	// printing separator with repeated until values are displaying.
		    {
		    	 System.out.print("-----");
		    }
		 
		    System.out.println();
		    for(int row = 0 ; row < table.length ; row++)
		    {
			      System.out.print("Row" + (row<9 ? "  ":" ") + (row+1) + ":");
			 
			      for(int column = 0; column < table[row].length; column++)
			      {
			    	  //here printing spaces starting from digit length(row*column).
			        System.out.print((table[row][column] < 10 ? "    " :table[row][column] < 100 ? "   " : table[row][column] < 1000 ? "  ": " ") + table[row][column]);
			      }
			      System.out.println();
		    }
		 }			// end matrix method body 

		 public static void main(String[]args) 
		 {
			    final int TABLE_SIZE = 32;
			    matrix(TABLE_SIZE);
		 }
		  
}	// end class body