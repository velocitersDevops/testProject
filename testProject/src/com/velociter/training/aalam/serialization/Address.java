package com.velociter.training.aalam.serialization;

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
