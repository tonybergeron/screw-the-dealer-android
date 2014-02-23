package org.seveneyes.deck;

/**
 * Suits possible on a card.
 * User: tonyb
 * Date: 2/22/14
 * Time: 2:28 PM
 */
public enum Suit {
    HEARTS("H", "Hearts"),
    DIAMONDS("D", "Diamonds"),
    SPADES("S", "Spades"),
    CLUBS("C", "Clubs");

    private final String rank;
    private final String name;

    Suit(String rank, String name) {
    	this.rank = rank;
    	this.name = name;
    }

    public String getRank() {
    	return rank;
    }

    public String getName() {
    	return name;
    }
}
