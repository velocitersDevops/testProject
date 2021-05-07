package com.velociter.training.aalam.jdbc;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUDOperations
{
  	public static void main(String[] args)
	{
		Scanner scanObject = new Scanner(System.in);
		boolean operationContinueStatus=true;
		while(operationContinueStatus)
		{
			System.err.println("");
			System.out.println("\t Which operation You Want to Perform ");
			System.out.println("\t press 1 for display \n\t press 2 for insert \n\t press 3 for update  \n\t press 4 for delete \n\t press 5 for Even_Records  \n\t press 6 for Odd_Records ");
			CrudMethods crudOperationObject = new CrudMethods();
			
			int option=0;
			try {
				option = scanObject.nextInt();
				if(option >0  && option <7)
				{
				  if(option == 1)
				  {
					crudOperationObject.display();
				  }
				  if(option == 2)
				  {
					crudOperationObject.insert();
				  }
				  if(option == 3)
			      {
					crudOperationObject.update();
				  }
				  if(option == 4)
			 	  {
					crudOperationObject.delete();
				  }
				  if(option == 5)
			 	  {
					crudOperationObject.evenRecords();
				  }
				  if(option == 6)
			 	  {
					crudOperationObject.oddRecords();
				  }
				}else
				{
					System.err.println("WARNING ! You Should Enter a Valid Number Option ! please try again");
				}
			}catch(InputMismatchException e)
			{
				System.err.println("WARNING ! You Should Enter a Valid Number Option ! please try again");
				
			}
			
			
		}
		
	}

}
