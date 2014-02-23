package org.seveneyes.deck;

/**
 * Numbers possible on a card.
 * User: tonyb
 * Date: 2/22/14
 * Time: 2:28 PM
 */
public enum Number {
    TWO("2", "Two"),
    THREE("3", "Three"),
    FOUR("4", "Four"), 
    FIVE("5", "Five"), 
    SIX("6", "Six"),
    SEVEN("7", "Seven"),
    EIGHT("8", "Eight"),
    NINE("9", "Nine"),
    TEN("10", "Ten"),
    JACK("J", "Jack"),
    QUEEN("Q", "Queen"),
    KING("K", "King"),
    ACE("A", "Ace");

    private final String rank;
    private final String name;

    Number(String rank, String name) {
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
