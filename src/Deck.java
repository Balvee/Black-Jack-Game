/*
* Deck.java
* Author: Brian Alvarez
* Submission Date: December 6 2015 *
* Purpose: Class Deck creates the deck used in the game by using all
* 52 cards. This is where the deck is suffled and cards are added
* back to it.
* Statement of Academic Honesty: *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia. 
* */
import java.util.Random;

/**
 * Class representing a standard 52 card deck. Allows users to shuffle, draw,
 * and add cards to the bottom for the purpose of playing various card games.
 */
public class Deck {
	
	/**
	 * Cards in the deck
	 */
	private Card [] cards;
	
	/**
	 * The number of cards in the physical deck on the table.
	 */
	private int numCardsInDeck;
	
	/**
	 * Create a standard 52 card deck w/ one of each type (Ace, King, Queen...) for each Suit (Hearts, Spades ..)
	 */
	public Deck() {
		
		Card.Suit [] suits = Card.Suit.values(); //creates an array of all of the Suits
		Card.Type [] types = Card.Type.values(); //creates an array of all of the Types
		cards = new Card[suits.length*types.length]; //sets the size of cards to 52 (types & suits)
		numCardsInDeck = 0;
		
		for(int i =0; i<suits.length; i++)
		{
			for(int j = 0; j<types.length; j++)
			{
				//Assigns 52 unique cards to the cards deck
				cards[numCardsInDeck] = new Card(types[j], suits[i]); 
				numCardsInDeck++; //increments the number of cards in the deck
			}
		}	
	}
	/**
	 * Draws card from the top
	 * @return the top card
	 */
	public Card draw() {
		if(numCardsInDeck != 0)
		{
			Card temp = cards[numCardsInDeck - 1];
			numCardsInDeck--;
			return temp;
		}
		else
		{
			System.out.println("Deck is empty.");
			return null;
		}
		
		
	}

	/**
	 * Swaps card at a with card at b
	 * @param a card to be swapped with b
	 * @param b card to be swapped with a
	 */
	private void swap(int a, int b) {
		Card temp = cards[a];
		cards[a] = cards[b];
		cards[b] = temp;
	}
	
	/**
	 * Shifts all the cards in the deck right by one place
	 */
	private void shiftRightOne() {
		if(numCardsInDeck == 52)
		{
			System.out.println("Sorry your deck is full!");	
		}
		else
		{
			Card temp = null;
			Card[] tempDeck = new Card[cards.length + 1];
			for(int index = 0; index < (cards.length); index++)
			{
				tempDeck[index + 1] = cards[index];
			}
			tempDeck[0] = temp;
			cards = tempDeck;
		}
		
	}	
	/**
	 * Add c to the bottom of the deck
	 * Print "Deck Full" when count equals the size of the deck
	 * @param c card to add
	 */	
	public void addToBottom(Card c) {
		if(numCardsInDeck == 52)
		{
			System.out.println("Sorry your deck is full!");	
		}
		else
		{
			shiftRightOne();
			cards[0] = c;
			numCardsInDeck++;
		}
 	}

	/**
	 * Shuffles the deck by swapping the cards 100 times
	 */
	public void shuffle() {
		Random number = new Random();
		int count = 0;
		do
			{
				for(int index = 0; index < numCardsInDeck; index++)
				{
					int value = number.nextInt(numCardsInDeck);
					swap(index, value);
				}
				count++;
			}while(count < 100);
	}
	/**
	 * Shuffles the deck by swapping cards n times
	 * @param n number of swaps
	 */
	public void shuffle(int n) {
		Random number = new Random();
		int count = 0;
		do
			{
				for(int index = 0; index < numCardsInDeck; index++)
				{
					int value = number.nextInt(numCardsInDeck);
					swap(index, value);
				}
				count++;
			}while(count < n);
	}
}
