package com.velociter.training.ankit.serialization;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Scanner;

class Name implements Serializable
{
private String name;
public Name(String name)
{
	this.name=name;
}
    public String toString() {
		return name;
	}
}
class Address implements Serializable
{
	private String address;
	public Address(String address)
	{
		this.address=address;
	}
		public String toString() {
		return address;
	}
}
class Person implements Serializable
{
	private Name name;
	private Address address;
	public Person(Name name,Address address)
	{
		this.name=name;
		this.address=address;
	}
	@Override
	public String toString() {
		//System.out.println(name+" "+address);
     return name+" "+address;
	}
}

public class PersonMainClass 
{
	   public static void main(String[] args) {
	   String name=null,address=null;
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter name");
	   name= sc.nextLine();
	   System.out.println("Enter Address");
	   address=sc.nextLine();
	   Name nameObj=new Name(name);
	   Address addressObj=new Address(address);
	   Person person=new Person(nameObj,addressObj);
	ObjectOutputStream objectOut=null;
	String filePath="E:\\New folder\\ObjectSerialization.txt";
	try {
		objectOut=new ObjectOutputStream(new FileOutputStream(filePath,true));
		//objectOut=new ObjectOutputStream(new BufferedOutputStream(new  FileOutputStream(filePath)));
		objectOut.writeObject(person);
		System.out.println("File Created"); 
	} catch (FileNotFoundException e) 
	{
	  e.printStackTrace();
	}
	catch (StreamCorruptedException e1)
	{
	 e1.printStackTrace();
	}
	catch (IOException e) 
	{
	  e.printStackTrace();
	}
  }
}
