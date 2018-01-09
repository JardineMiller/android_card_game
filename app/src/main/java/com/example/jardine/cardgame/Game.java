package com.example.jardine.cardgame;

import java.io.Serializable;

/**
 * Created by jardine on 08/01/2018.
 */

public class Game implements Serializable {
    private Player player;
    private Player computer;
    private Deck deck;

    public Game(String playerName) {
        this.deck = new Deck();
        this.player = new Player(playerName);
        this.computer = new Player("Android");
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public void prepareDeck() {
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void dealCards() {
        Card card1 = deck.removeCard();
        player.addCard(card1);
        Card card2 = deck.removeCard();
        computer.addCard(card2);
    }

    public void startGame() {
        prepareDeck();
        dealCards();
        dealCards();
    }

    public String determineWinner() {
        if (player.handValue() == computer.handValue()) {
            return "It's a draw!";
        }
        if(player.handValue() > computer.handValue()) {
            return "You win!";
        } else {
            return computer.getName() + " wins. Better luck next time.";
        }
    }
}
