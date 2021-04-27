package com.velociter.training.aalam.loopsAndLogic;

import java.util.Scanner;

public class Capitals
{

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		int status = 0;
		int limittoiterate = 0;
		char character = 0;
		System.out.println("Enter your random sequence limit to genrate character except vovels");
		limittoiterate =sc.nextInt();
		
		 while( status < limittoiterate )   //checking here increemented value is lessten limit or not
		 {
			 
		//typecasting from int to char
		character = (char)(26*Math.random() + 'A');
	      switch(character) {
	        //Vowels ignored:
	        case 'A':
	        case 'E':
	        case 'I':
	        case 'O':
	        case 'U':
	          break;
	        default:
	          //Consonant displayed:
	          System.out.print(character + " ");
	          status++;
	          break;
	      }
		 }
		
	}

}
