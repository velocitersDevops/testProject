package com.velociter.training.vivek.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
 private ArrayList<Cards> cards;
 
   public Deck()
   {
	   this.cards=new ArrayList<Cards>();
   }
   
   public void createFullDeck()
   {
	   //Generating cards
	   for(Suit cardSuit:Suit.values())
	   {
		   //adding new cards to the mix
		   for(Value cardValue:Value.values())
		   {
			   this.cards.add(new Cards(cardSuit,cardValue));
		   }
	   }
   }
   
   public void shuffle()
   {
	   ArrayList<Cards> tmpDeck=new ArrayList<Cards>();
	   //Use Random 
	   Random random =new Random();
	   
	   int randomCardIndex=0;
	   int originalSize=this.cards.size();
	   
	   for(int i=0;i<originalSize;i++)
	   {
		   //Generate Random Index rand.nextInt((max-min)+1)+min;
		   randomCardIndex = random.nextInt((this.cards.size()-1-0)+1)+0;
		   tmpDeck.add(this.cards.get(randomCardIndex));
		   this.cards.remove(randomCardIndex);
	   }
	   this.cards=tmpDeck;
	   
   }
   
   
   public String toString()
   {
	   String cardListOutput="";
	   int i=0;
	   for(Cards aCard:this.cards)
	   {
		   cardListOutput=cardListOutput+"\n"+i+"-"+aCard.toString();
		   i++;
	   }
	   return cardListOutput;
	   
   }
   
   public void removeCard(int i)
   {
	   this.cards.remove(i);
   }
   
   public int deckSize()
   {
	   return this.cards.size();
   }
   
   public void moveAllToDeck(Deck moveTo)
   {
	 int thisDeckSize=this.cards.size();
	 
	 //put cards into moveTo deck
	 
	 for(int i=0;i<thisDeckSize;i++)
	 {
		 moveTo.addCard(this.getCard(i));
	 }
	 
	 for(int i=0;i<thisDeckSize;i++)
	 {
		 this.removeCard(0);
	 }
   }
   
   public Cards getCard(int i)
   {
	   return this.cards.get(i);
   }
   
   public void addCard(Cards addCard)
   {
	   this.cards.add(addCard);
   }
   
   public void draw(Deck comingFrom)
   {
	  this.cards.add(comingFrom.getCard(0)); 
	  comingFrom.removeCard(0);
   }
   
   
   //return total value of cards in deck
   public int cardsValue()
   {
	   int totalValue=0;
	   int aces=0;
	   
	   for(Cards aCard:this.cards)
	   {
		   switch(aCard.getValue())
		   {
		   case TWO:totalValue=totalValue+2;
		   break;
		   case THREE:totalValue=totalValue+3;
		   break;
		   case FOUR:totalValue=totalValue+4;
		   break;
		   case FIVE:totalValue=totalValue+5;
		   break;
		   case SIX:totalValue=totalValue+6;
		   break;
		   case SEVEN:totalValue=totalValue+7;
		   break;
		   case EIGHT:totalValue=totalValue+8;
		   break;
		   case NINE:totalValue=totalValue+9;
		   break;
		   case TEN:totalValue=totalValue+10;
		   break;
		   case JACK:totalValue=totalValue+10;
		   break;
		   case QUEEN:totalValue=totalValue+10;
		   break;
		   case KING:totalValue=totalValue+10;
		   break;
		   case ACE:totalValue=totalValue+1;
		   break;
			   
		   
		   
		   }
	   }
	   
	   for(int i=0;i<aces;i++)
	   {
		  if(totalValue>10)
		  {
			  totalValue=totalValue+1;
		  }
		  else
		  {
			  totalValue=totalValue+11;
		  }
	   }
	   return totalValue;
   }
   
   
}
