package com.velociter.training.mukesh.chapter12;

import java.io.Serializable;

public class Name implements Serializable
{

	private String firstName;
	private String secondName;
	
	public Name(String firstName, String secondName)
	{
		this.firstName=firstName;
		this.secondName=secondName;
		
	}
	public String toString()
	{
		return firstName + " "+ secondName;
	}
	
}
