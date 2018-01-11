package com.example.jardine.cardgame;

import java.io.Serializable;

/**
 * Created by jardine on 08/01/2018.
 */

public class Game implements Serializable {
    private Player player;
    private Player computer;
    private Deck deck;
    private int pot;
    Player winner;

    public Game(String playerName) {
        this.deck = new Deck();
        this.player = new Player(playerName);
        this.computer = new Player("Android");
        this.pot = 0;
        this.winner = null;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public int getPot() {
        return pot;
    }

    public void emptyPot() {
        this.pot = 0;
    }

    public void placeBet(int amount) {
        player.decreaseWallet(amount);
        computer.decreaseWallet(amount);
    }

    public void payOut() {
        this.winner.increaseWallet(this.pot);
        this.emptyPot();
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

    public void determineWinner() {
        if(player.handValue() > computer.handValue()) {
            this.winner = player;
        }
        if (player.handValue() < computer.handValue()) {
            this.winner = computer;
        }
    }

    public String printWinner() {
        String message;
        if(this.winner == player) {
            message = "You win!";
        } else if(this.winner == computer) {
            message = "You lose!";
        } else {
            message = "It's a draw!";
        }
        return message;
    }
}
