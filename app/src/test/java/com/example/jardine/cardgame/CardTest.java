package com.example.jardine.cardgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jardine on 08/01/2018.
 */

public class CardTest {
    Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.SPADES, CardValue.ACE);
    }

    @Test
    public void cardHasSuit() {
        assertEquals("Spades", card.getSuitString());
    }

    @Test
    public void cardHasValue() {
        assertEquals(11, card.getValue());
        assertEquals("Ace", card.getValueString());
    }

    @Test
    public void cardHasPrettyName() {
        assertEquals("Ace of Spades", card.prettyName());
    }

    @Test
    public void cardHasSuitType() {
        assertEquals(CardSuit.SPADES, card.getSuitType());
    }

    @Test
    public void cardHasValueType() {
        assertEquals(CardValue.ACE, card.getValueType());
    }

}
