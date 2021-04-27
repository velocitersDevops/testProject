package com.velociter.training.vivek.chapter12;

import java.io.Serializable;

public class Name implements Serializable
{
  private String name;
  private String address;
  
  Name(String name,String address)
  {
	  this.name=name;
	  this.address=address;
  }
  
  public String toString()
  {
	  return name+"  "+address;
  }
}
