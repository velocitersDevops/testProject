package com.velociter.training.mukesh.chapter15;

enum Shape 
{
	HEART, SPADE, DIAMOND, CLUB
}
enum Value
{
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

public class Card 
{

	private Shape shape;
	private Value value;
	
	public Card(Shape shape, Value value)
	{
		this.shape = shape;
		this.value = value;
	}
	
	public String toString()
	{
		return this.shape.toString() + "-" + this.value.toString();
	}
	
	public Value getValue()
	{
		return this.value;
	}
	
}
