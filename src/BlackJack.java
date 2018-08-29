/*
* BlackJack.java
* Author: Brian Alvarez
* Submission Date: December 6 2015 *
* Purpose: BlackJack is the location where the game is ordered as well as 
* where the card and hand are counted.
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
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();
		this.deck = deck;
		
		Hand playersHand = player.getHand();
		Hand dealersHand = dealer.getHand();
		
		Card newCard, newCard2;
		do
		{
			newCard = this.deck.draw();
			newCard2 = this.deck.draw();
		}while(newCard == null || newCard2 == null);
		playersHand.addCard(newCard);
		playersHand.addCard(newCard2);
		Card newCard3, newCard4;
		do
		{
			newCard3 = this.deck.draw();
			newCard4 = this.deck.draw();
		}while(newCard3 == null || newCard4 == null);
		dealersHand.addCard(newCard3);
		dealersHand.addCard(newCard4);
		this.player = player;
		this.dealer = dealer;
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		player.returnCardstoDeck(deck);
		dealer.returnCardstoDeck(deck);
		deck.shuffle();
		Hand playersHand = player.getHand();
		Hand dealersHand = dealer.getHand();
		
		playersHand.addCard(deck.draw());
		playersHand.addCard(deck.draw());
		dealersHand.addCard(deck.draw());
		dealersHand.addCard(deck.draw());
		  
		
	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		switch (c.getType())
		{
		case TWO:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		case TEN:
			return 10;
		case JACK:
			return 10;
		case QUEEN:
			return 10;
		case KING:
			return 10;
		case ACE:
			return 1;
		default:
			return 0;
		}
	}
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		Card[] tempHand = h.getCards();
		int value = 0;
		int count = 0;
		for(int index = 0; index < tempHand.length; index++)
		{	
			
			int valueOfCard = getValueOfCard(tempHand[index]);
			if (valueOfCard == 1)
			{
				valueOfCard = 0;
				count ++;
			}
			value = valueOfCard + value;
			if(index == tempHand.length - 1)
			{
				for(int number = 0; number < count; number ++)
				{
					if(value + 11 < 21)
					{
						value = value + 11;
						number ++;
						
					}
					else if(value + 1 < 21 && number < count)
					{
						value = value + 1;
					}
				}
			}
		}
		
		return value;

	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
