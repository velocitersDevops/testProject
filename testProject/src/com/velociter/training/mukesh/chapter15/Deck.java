package com.velociter.training.mukesh.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{

	private ArrayList<Card> cards;
	
	public Deck()
	{
		//Create a new deck of playing cards
		this.cards = new ArrayList<Card>();
	}
	
	//Add 52 playing cards to a deck
	public void createFullDeck()
	{
		for(Shape cardShape : Shape.values())
		{
			
			for(Value cardValue : Value.values())
			{
				
				this.cards.add(new Card(cardShape,cardValue));
			}
		}
	 }
	
	
    //Shuffle deck of cards
    public void shuffle()
    {
		ArrayList<Card> temprorayDeck = new ArrayList<Card>();
		Random random = new Random();
		
		int randomCardIndex = 0;
		int originalSize = this.cards.size();
		
		for(int i = 0; i< originalSize; i++)
		{
			randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
			
			temprorayDeck.add(this.cards.get(randomCardIndex));
			
			this.cards.remove(randomCardIndex);
		}
		//set this.deck to our newly shuffled deck
		this.cards = temprorayDeck;
    }
	
	
	//Remove a card from the deck
	public void removeCard(int i)
	{
		this.cards.remove(i);
	}
	
	//Get card from deck
	public Card getCard(int i)
	{
		return this.cards.get(i);
	}
	
	//Add card to deck
	public void addCard(Card addCard)
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
		for(Card card : this.cards)
		{
			cardListOutput += "\n" + card.toString();
			i++;
		}
		return cardListOutput;
	}
	
	public void moveAllToDeck(Deck moveTo)
	{
		int thisDeckSize = this.cards.size();
		
		//put cards in moveTo deck
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
		for(Card card : this.cards)
		{
			//Switch of possible values
			switch(card.getValue())
			{
				case TWO: 
					totalValue += 2;
				    break;
				case THREE: 
					totalValue += 3;
				    break;
				case FOUR: 
					totalValue += 4;
				    break;
				case FIVE: 
					totalValue += 5;
				    break;
				case SIX: 
					totalValue += 6;
				    break;
				case SEVEN:
					totalValue += 7; 
				    break;
				case EIGHT: 
					totalValue += 8;
				    break;
				case NINE:
					totalValue += 9;
				    break;
				case TEN: 
					totalValue += 10; 
				    break;
				case JACK:
					totalValue += 10; 
				    break;
				case QUEEN:
					totalValue += 10; 
				    break;
				case KING: 
					totalValue += 10;
				    break;
				case ACE: 
					aces += 1;
				    break;
			}			
		}
		
		//Aces worth 11 or 1 - if 11 would go over 21 make it worth 1
		
		for(int i = 0; i < aces; i++)
		{
			//If they're already at over 10 getting an ace valued at 11 would put them up to 22, so make ace worth one
			if (totalValue > 10)
			{
				totalValue += 1;
			}
			else
			{
				totalValue += 11;
			}
		}
		
		//Return
		return totalValue;
	
	}
		
}
