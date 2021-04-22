

/* 
     Write a program to display a random choice from a set of six choices for breakfast (you could
use any set; for example, scrambled eggs, waffles, fruit, cereal, toast, or yogurt).
   
 */
package com.velociter.training.aalam.loopsAndLogic;
import java.util.Scanner;

public class ChoiseBreakFast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("  select your choice as a breakfast  ");
		System.out.println("======================================");
		System.out.println("1. scrambled eggs");
		System.out.println("2. waffles");
		System.out.println("3. fruit");
		System.out.println("4. cereal");
		System.out.println("5. toast");
		System.out.println("6. yogurt");
		System.out.println("");
		System.out.print("Enter Your Option  :");
		Scanner sc =new Scanner(System.in);
		int option = sc.nextInt();
		switch(option)
		{
		case 1: System.out.println("you selected breakfast is scrambled eggs ");
			    break;
			   
		case 2: System.out.println("you selected breakfast is scrambled eggs ");
		        break;
		case 3: System.out.println("you selected breakfast is scrambled eggs ");
		        break;
		case 4: System.out.println("you selected breakfast is scrambled eggs ");
		        break;
		case 5: System.out.println("you selected breakfast is scrambled eggs ");
		        break;
		case 6: System.out.println("you selected breakfast is scrambled eggs ");
		        break;
		default:System.out.println("you not select any option may be you not hungry.. ");
			    
		}
	}

}
