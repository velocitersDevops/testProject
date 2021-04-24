package com.velociter.training.ankit.chapter4;

public class MatrixNxN {
	public static void matrixTable(int range)
	{
    final int tableSize =range;
	    
	    int[][] table = new int[tableSize][tableSize];
	    for(int i = 0 ; i < table.length ; ++i) {
	      for(int j = 0 ; j < table[i].length ; ++j) {
	        table[i][j] = (i+1)*(j+1);
	      }
	    }
	    System.out.print("      :");             
	    for(int j = 1 ; j <= table[0].length ; ++j) {
	      System.out.print((j<10 ? "    ": "   ") + j);// upper row  4 3 space
	   }
	    System.out.println();
	    System.out.print("-------");
	    for(int sp=1;sp<=tableSize;sp++)
		{
			System.out.print("-----");
		}System.out.println();
	    for(int i = 0 ; i < table.length; i++)   //side column
	    {
	      System.out.print("Row"+ (i<9 ?"  ":" ") + (i+1) + ":"); //2  1
	 
	      for(int j = 0; j < table[i].length; ++j) {
	    	  if (table[i][j]<10) 
	 	         System.out.print("    " + table[i][j] );    //4 space   
	 	        else
	 	        if (table[i][j]> 9 && table[i][j]<100)           
	 	         System.out.print("   " + table[i][j]); //   3 space
	 	        else 
	 	        	if (table[i][j]>99 && table[i][j]<1000)          
	 	   	         System.out.print("  " + table[i][j]); //2 space
	 	        	else
	 	        		System.out.print(" "+table[i][j]);   //  1  space 
	      }
	      System.out.println();
	    }
		
	}
	  public static void main(String[]args) {
	     int range=30;
		  matrixTable(range);
	  }
	}