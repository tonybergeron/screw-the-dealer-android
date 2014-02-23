package org.seveneyes.deck;

/**
 * Class representing a playing card.
 * User: tonyb
 * Date: 2/22/14
 * Time: 2:28 PM
 */
public class Card {
    private Suit cardSuit;
    private Number cardNumber;

    /**
     * Constructor for Card class
     *
     * @param suit   suit of the card to create
     * @param number number of the card to create
     */
    public Card(Suit suit, Number number) {
        cardSuit = suit;
        cardNumber = number;
    }

    /**
     * Accessor for the suit of a card.
     *
     * @return the card's suit
     */
    public Suit getSuit() {
        return cardSuit;
    }

    /**
     * Accessor for the number of a card.
     *
     * @return the cards number
     */
    public Number getNumber() {
        return cardNumber;
    }

    /**
     * Returns a string representation of the current card.
     * @return string representing the card
     */
    public String toString(){
        return String.format("%s-%s", cardNumber.toString(), cardSuit.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object.getClass() != getClass())
            return false;
        Card other = (Card) object;
        if (!cardSuit.equals(other.getSuit()))
            return false;
        if (!cardNumber.equals(other.getNumber()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (cardSuit.toString() + cardNumber.toString()).hashCode();
    }
}
