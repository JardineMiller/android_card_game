package com.example.jardine.cardgame;

/**
 * Created by jardine on 08/01/2018.
 */

public class Card {
    private CardSuit suit;
    private CardValue value;
    private String image;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
        this.image = null;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSuitString() {
        return suit.getSuit();
    }

    public CardSuit getSuitType() {
        return suit;
    }

    public CardValue getValueType() {
        return value;
    }

    public String getValueString() {
        return value.getValueString();
    }

    public int getValue() {
        return value.getValue();
    }

    public String prettyName() {
        return value.getValueString() + " of " + suit.getSuit();
    }
}
