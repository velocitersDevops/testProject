package com.velociter.training.aalam.collectionUseFullClasses;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private ArrayList<Cards> cards;
	
	public Deck()
	{
		//Create a new deck of playing cards
		this.cards = new ArrayList<Cards>();
	
	}
	
	//Add 52 playing cards to a deck
	public void createFullDeck()
	{
		//Generate Cards with values
		for(Suit cardSuit : Suit.values())     //all the card value based on shit with value 
		{
           for(Value cardValue : Value.values())
			{
        	   //here will be all values with each suit
        	   //Add new card to the mix
				this.cards.add(new Cards(cardSuit,cardValue));  
			}
		}
	}
	
	
//Shuffle deck of cards
public void shuffle()
{
	//Create a new arraylist to hold the shuffled cards temporarily
	ArrayList<Cards> tmpDeck = new ArrayList<Cards>();
	//Randomly pick from the old deck and copy values to the new deck
	Random random = new Random();
	int randomCardIndex = 0;
	int originalSize = cards.size(); //means how many cards have right now
	for(int i = 0; i<originalSize;i++)
	{
		//gen random num according to int randomNum = rand.nextInt((max - min) + 1) + min;
		randomCardIndex = random.nextInt((cards.size()-1 - 0) + 1) + 0; //index from 52 cards
		//throw random card into new deck
		tmpDeck.add(cards.get(randomCardIndex));
	}
	//set this.deck to our newly shuffled deck
	cards = tmpDeck;
}
	
	
	//Remove a card from the deck
	public void removeCard(int i)
	{
		this.cards.remove(i);
	}
	//Get card from deck
	public Cards getCard(int i)
	{
		return this.cards.get(i);
	}
	
	//Add card to deck
	public void addCard(Cards addCard)
	{
		this.cards.add(addCard);
	}
	
	//Draw a top card from deck
	public void draw(Deck comingFrom)
	{
		//Add card to this deck from whatever deck its coming from
		this.cards.add(comingFrom.getCard(0));
		//Remove the card in the deck its coming from
		comingFrom.removeCard(0);
	}
	
	//Use to print out deck
	public String toString()
	{
		String cardListOutput = "";
		int i = 0;
		for(Cards aCard : this.cards){
			cardListOutput += "\n" + aCard.toString();
			i++;
		}
		return cardListOutput;
	}
	
	public void moveAllToDeck(Deck moveTo)
	{
		int thisDeckSize = this.cards.size();
		for(int i = 0; i < thisDeckSize; i++)
		{
			moveTo.addCard(this.getCard(i));
		}
		//empty out the deck
		for(int i = 0; i < thisDeckSize; i++)
		{
			this.removeCard(0);
		}
	}
	
	public int deckSize()
	{
		return this.cards.size();
	}
	
	//Calculate the value of deck
	public int cardsValue()
	{
		int totalValue = 0;
		int aces = 0;
		//For every card in the deck
		for(Cards aCard : this.cards)
		{
			//Switch of possible values
			switch(aCard.getValue()){
			case TWO: totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: totalValue += 10; break;
			case ACE: aces += 1; break;
			}			
		}
		
		//Determine the total current value with aces
		//Aces worth 11 or 1 - if 11 would go over 21 make it worth 1
		for(int i = 0; i < aces; i++)
		{
			//If they're already at over 10 getting an ace valued at 11 would put them up to 22, so make ace worth one
			if (totalValue > 10)
			{
				totalValue += 1;
			}
			else{
				totalValue += 11;
			}
		}
		
		//Return
		return totalValue;
	
	}
	
	
}
