package com.velociter.training.aalam.serialization;

import java.io.Serializable;

public class Person implements Serializable
{
        private Name name;             //has a relationship
		private Address address;       //has a relationship
		
		public Person(Name name ,Address address)
		{
			this.name= name;
			this.address = address;
		}
		public String toString()
		{
			return name.toString()+"    "+address.toString();
		}
		
	

}
