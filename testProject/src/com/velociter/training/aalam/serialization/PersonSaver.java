package com.velociter.training.aalam.serialization;

import java.util.Scanner;
import java.io.*;
public class PersonSaver 
{
   public static void main(String args[]) throws FileNotFoundException, IOException
   {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person name");
		String name = sc.next();
		Name nameObject = new Name(name);

		System.out.println("Enter Person address");
		String address = sc.next();
		Address addressObject = new Address(address);

		Person personObject = new Person(nameObject , addressObject);
		System.out.println("person details   "+personObject.toString());
		
		ObjectOutputStream objectOutPutStreamObject =null;
		try 
		{
			objectOutPutStreamObject = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("e:/programingExample/serialzation/ObjectData.bin",true)));
			objectOutPutStreamObject.writeObject(personObject);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		System.out.println("object Written into .txt file");
  
		objectOutPutStreamObject.close();
   }
	
}
