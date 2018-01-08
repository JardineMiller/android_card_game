package com.example.jardine.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jardine on 08/01/2018.
 */

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int cardCount() {
        return this.cards.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        return this.cards.remove(0);
    }

    public void populateDeck() {
        for(CardSuit suit : CardSuit.values()) {
            for(CardValue value : CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }
}
