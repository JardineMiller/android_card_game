package com.example.jardine.cardgame;

/**
 * Created by jardine on 08/01/2018.
 */

public enum CardValue {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    ACE("Ace", 11);


    private final String valueString;
    private final int value;

    CardValue(String valueString, int value) {
        this.valueString = valueString;
        this.value = value;
    }

    public String getValueString() {
        return valueString;
    }

    public int getValue() {
        return value;
    }
}
