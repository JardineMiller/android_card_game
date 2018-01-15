package com.example.jardine.cardgame;

/**
 * Created by jardine on 08/01/2018.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;
    Card card2;

    @Before
    public void before() {
        player = new Player("Jardine", 50);
        card = new Card(CardSuit.values()[0], CardValue.values()[0]);
        card2 = new Card(CardSuit.values()[1], CardValue.values()[1]);
    }

    @Test
    public void hasName() {
        assertEquals("Jardine", player.getName());
    }

    @Test
    public void playerHandIsEmpty() {
        assertEquals(0, player.handCount());
    }

    @Test
    public void canAddCardToHand() {
        player.addCard(card);
        assertEquals(1, player.handCount());
    }

    @Test
    public void testTotalValueOfHandOneCard() {
        player.addCard(card);
        assertEquals(2, player.handValue());
    }

    @Test
    public void testTotalValueOfHandManyCard() {
        player.addCard(card);
        player.addCard(card2);
        assertEquals(5, player.handValue());
    }
}

