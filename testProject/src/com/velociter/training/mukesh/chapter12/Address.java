package com.velociter.training.mukesh.chapter12;
import java.io.Serializable;
public class Address implements Serializable
{
	private String address;
	public Address(String address)
	{
		this.address=address;
	}
	
	public String toString()
	{
		return address;
	}
}
