/*
  Write a program to create a rectangular array containing a multiplication matrix from 1 * 1 up to
12 * 12. Output the matrix as 13 columns with the numeric values right-aligned in columns. (The
first line of output will be the column headings, the first column with no heading, then the
numbers 1 to 12 for the remaining columns. The first item in each of the succeeding lines is the
row heading, which ranges from 1 to 12..
 */

package com.velociter.training.aalam.arrayAndString;

public class MatrixProblem
{

	public String maxSpace(int matixValue) {
		if (matixValue <= 9) {
			return "     "; // 5 space
		} else if (matixValue >= 10 && matixValue <= 99) {
			return "    "; //  4 space
		} else if (matixValue >= 100 && matixValue <= 999) {
			return "   "; // 3 space // 1 space
		} else if (matixValue >= 1000 && matixValue <= 9999) {
			return "  "; // 2 space
		} else {
			return " "; // 1 space
		}

	}

	public static void main(String[] args) {

		MatrixProblem ob = new MatrixProblem();

		int countRow = 1;
		final int SIZE = 5;

		int[][] matrix = new int[SIZE][SIZE];

		// Here 2 loop for storing value in matrix
		for (int i = 0; i <= matrix.length - 1; i++) 
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				matrix[i][j] = (i + 1) * (j + 1);
			}
		}

		//print column number
		for(int columnNumber = 1; columnNumber <= SIZE; columnNumber++)
		{
			if(columnNumber == 1) {
				System.out.print("           "+columnNumber);
			}
			else if(columnNumber <10)
			{
			System.out.print("     "+columnNumber);
			}
			else if(columnNumber >=10)
			{
			System.out.print("    "+columnNumber);
			}
		}
		
		System.out.println();
		System.out.print("------");  //default space

		//print line  
		for(int sp=1;sp<=SIZE;sp++)
		{
			 if(sp <= 9) {
					System.out.print("------");
				}
				else if(sp >=10 && sp <=99)
				{
				System.out.print("------");
				}
		}
		
		System.out.println();
		int matixValue = 0;     
		
		
		for (int i = 0; i <= matrix.length - 1; i++) 
		{
			if(countRow <=9)                                  // code for row Spacing //
				{
				System.out.print("row"+"  "+countRow);
				}
			    else 
			    {
			    	System.out.print("row"+" "+countRow);

			     }                                             
			
			for (int j = 0; j < matrix[0].length; j++)
			{
				matixValue = matrix[i][j];
				System.out.print(ob.maxSpace(matixValue));// code for print space
				System.out.print(matrix[i][j]); // code for print matrix
				
			}
			System.out.println();
			countRow++;
			
		}

		

	}

}

