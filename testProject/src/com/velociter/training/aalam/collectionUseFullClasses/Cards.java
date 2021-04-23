package com.velociter.training.aalam.collectionUseFullClasses;

public class Cards
{

	private Suit suit;
	private Value value;
	
	public Cards(Suit suit, Value value){
		this.suit = suit;
		this.value = value;
	}
	
	public String toString(){
		return this.suit.toString() + "-" + this.value.toString();
	}
	
	public Value getValue(){
		return this.value;
	}


	
}
