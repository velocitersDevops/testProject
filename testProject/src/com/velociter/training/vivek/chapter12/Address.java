package com.velociter.training.vivek.chapter12;

import java.io.Serializable;

public class Address implements Serializable
{
  private String address;
  
  Address(String address)
  {
	this.address=address;  
  }
  
  public String toString()
  {
	  return address;
  }
}
