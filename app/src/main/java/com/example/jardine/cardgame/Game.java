package com.example.jardine.cardgame;

import java.io.Serializable;

/**
 * Created by jardine on 08/01/2018.
 */

public class Game implements Serializable {
    private Player player;
    private Player computer;
    private Deck deck;
    private Wallet pot;
    private Player winner;

    public Game(String playerName, int playerAmount, int androidAmount) {
        this.deck = new Deck();
        this.player = new Player(playerName, playerAmount);
        this.computer = new Player("Android", androidAmount);
        this.pot = new Wallet(0);
        this.winner = null;
    }


    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public int getPot() {
        return pot.getAmount();
    }

    public void emptyPot() {
        this.pot.empty();
    }

    public void placeBets(int amount) {
        player.getWallet().decreaseAmount(amount);
        computer.getWallet().decreaseAmount(amount);
        this.pot.increaseAmount(amount * 2);
    }

    public void payOut() {
        this.winner.getWallet().increaseAmount(this.pot.getAmount());
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
            this.winner = this.player;
        }
        if (player.handValue() < computer.handValue()) {
            this.winner = this.computer;
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
