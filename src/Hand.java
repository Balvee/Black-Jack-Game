/*
* Hand.java
* Author: Brian Alvarez
* Submission Date: December 6 2015 *
* Purpose: Class Hand creates the users and dealers hands, empties the
* hands, adds hand back to deck.
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

/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
			Card[] tempCard = new Card[cards.length + 1];
			for(int index = 0; index < cards.length; index++)
			{
				tempCard[index] = cards[index]; 
			}
			tempCard[tempCard.length - 1] = c;
			cards = tempCard;
			
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		return cards.length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		// Ensure you return reference to the copy of the cards array
		// and not a reference actual cards array!
		Card[] hand = new Card[cards.length];
		for(int index = 0; index < cards.length; index++)
		{
			hand[index] = cards[index];
		}
		return hand;
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {
		Card[] discardedCard = new Card[cards.length];
		for(int index = 0; index < cards.length; index++)
		{
			discardedCard[index] = cards[index];
		}
		cards = new Card[0];
		return discardedCard;
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		if(cards.length == 0)
		{
			String empty = "Empty hand";
			return empty;
		}
		else
		{
			String cardsInHand = "";
			for(int index = 0; index < cards.length; index++)
			{
				String number = "" + index + 1;
				number.trim();
				String type = "" + cards[index].getType();
				type.trim();
				String suit = "" + cards[index].getSuit() + "S";
				suit.trim();
				String individualCard = type + "of" + suit;
				cardsInHand = individualCard + " " + cardsInHand;
			}
			return cardsInHand;
		}
	}
}
