package com.example.jardine.cardgame;

import java.util.ArrayList;

/**
 * Created by jardine on 08/01/2018.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int wallet;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.wallet = 50;
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public void increaseWallet(int amount) {
        this.wallet += amount;
    }

    public void decreaseWallet(int amount) {
        this.wallet -= amount;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getAllCards() {
        String cards = "";
        for(Card card : hand) {
            cards += card.prettyName() + "\n";
        }
        return cards;
    }

    public int handCount() {
        return this.hand.size();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int handValue() {
        int total = 0;
        for(Card card : hand) {
            total += card.getValue();
        }
        return total;
    }
}
