package com.example.jardine.cardgame;

/**
 * Created by jardine on 08/01/2018.
 */

public enum CardSuit {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");


    private final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
