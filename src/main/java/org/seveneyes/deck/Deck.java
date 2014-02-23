package org.seveneyes.deck;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A threadsafe Deck class.
 * User: tonyb
 * Date: 2/22/14
 * Time: 2:28 PM
 */
public class Deck {
    // Use ReentrantReadWriteLock to assure thread safety
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();

    private ArrayList<Card> cards;

    private int deckMax;

    /**
     * Constructor for Deck class
     */
    public Deck() {
        cards = new ArrayList<Card>();
    }

    /**
     * Initialize Deck
     */
    public void initializeDeck() {

        for (Number n : Number.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(s, n));
            }
        }

        deckMax = cards.size();
    }


    /**
     * =============================
     *
     * Deck Actions
     */


    /**
     * Draw a deck from the top of the deck
     *
     * @return deck from the top of the deck
     */
    public Card drawCard() {
        write.lock();
        try {
            if (cards.size() == 0)
                return null;
            return cards.remove(cards.size() - 1);
        } finally {
            write.unlock();
        }
    }

    /**
     * Adds a card to the top of the Deck
     */
    public void addCard(Card c) {
        write.lock();
        try {
            if (c != null && c.getNumber() != null && c.getSuit() != null) {
                cards.add(c);
            }
        } finally {
            write.unlock();
        }
    }

    /**
     * Shuffle the deck of cards.
     */
    public void shuffle() {
        write.lock();
        try {
            Card tmp;
            int index;
            for (int i = 0; i < cards.size(); i++) {
                index = (int) (Math.random() * (cards.size() - i)) + i;
                tmp = cards.get(i);
                cards.set(i, cards.get(index));
                cards.set(index, tmp);
            }
        } finally {
            write.unlock();
        }
    }

    /**
     * Get card at a given index, but do not remove it. If there is no card at that index, return null.
     * Required to allow array type access through AbstractList class.
     *
     * @param index position to
     * @return card at given index
     */
    public Card peek(int index) {
        read.lock();
        try {
            if (index > cards.size())
                return null;
            return cards.get(index - 1);
        } finally {
            read.unlock();
        }
    }

    /**
     * peeks at next card in the deck
     *
     * @return next card
     */
    public Card peek() {
        read.lock();
        try {
            if (cards.size() == 0)
                return null;
            return cards.get(cards.size() - 1);
        } finally {
            read.unlock();
        }
    }

    /**
     * Get the size of the given deck.
     *
     * @return the number of cards in the deck
     */
    public int size() {
        read.lock();
        try {
            return cards.size();
        } finally {
            read.unlock();
        }
    }

    public int getDeckMax() {
        return deckMax;
    }

    public void setDeckMax(int deckMax) {
        this.deckMax = deckMax;
    }

    public ArrayList<Card> getValues() {
        return cards;
    }
}
