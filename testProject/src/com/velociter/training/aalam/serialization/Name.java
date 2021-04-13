package com.velociter.training.aalam.serialization;

import java.io.Serializable;

public class Name implements Serializable
{
  private String name;
  public Name(String name)
  {
	  this.name=name;
  }
  public String toString()
  {
	  return name;
  }
}
