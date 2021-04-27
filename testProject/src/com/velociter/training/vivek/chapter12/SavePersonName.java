package com.velociter.training.vivek.chapter12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SavePersonName
{

	public static void main(String[] args) throws ClassNotFoundException
	
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your first Name  :");
		
		String name=scanner.nextLine();
		
		System.out.println("enter your Surname :");
		String surName=scanner.nextLine();
		
		System.out.println("enter your address :");
		String address= scanner.nextLine();
		
		Address addressObject= new Address(address);
		Name nameObject=new Name(name,address);
		Person personObject =new Person(nameObject,addressObject);
		
		File file= new File("c:\\AvoidFile\\abc.txt");
		
		try
		{
			FileOutputStream fosObject = new FileOutputStream(file);
			ObjectOutputStream objectOutput= new ObjectOutputStream(fosObject);
			objectOutput.writeObject(personObject);
			
			objectOutput.flush();
			objectOutput.close();
			
			System.out.println("object are stored into the file");
			
			
			
		} 
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		//System.out.println("object are stored into the file");

	}

}
