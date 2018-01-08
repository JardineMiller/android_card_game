package com.example.jardine.cardgame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jardine on 08/01/2018.
 */

public class Game {
    private ArrayList<Player> players;
    private HashMap<Player, Integer> results;
    private Deck deck;
    private ArrayList<Player> winners;

    public Game(ArrayList<Player> players) {
        this.deck = new Deck();
        this.players = players;
        this.results = new HashMap<>();
        this.winners = new ArrayList<>();
    }

    public void prepareDeck() {
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void dealCard(int numberOfCards) {
        for(Player player : players) {
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.removeCard();
                player.addCard(card);
            }
        }
    }

    public void determineWinner() {
        for(Player player : players) {
            if(winners.size() == 0) {
                winners.add(player);
            } else if (winners.get(0).handValue() < player.handValue()) {
                winners.clear();
                winners.add(player);
            } else if (winners.get(0).handValue() == player.handValue()) {
                winners.add(player);
            }
        }
    }

    public String getPlayers() {
        String playersString = "";
        for(Player player : players) {
            playersString += "\nPlayer: " + player.getName() + " \nPoints: " + player.handValue() + "\nCards: " + player.getAllCards();
        }
        return playersString;
    }

    public String getWinners() {
        String winnersString = "";
        if (winners.size() == 1) {
            Player winner = winners.get(0);
            winnersString = "\nResult: " + winner.getName() + " wins with " + winner.handValue() + " points.";
        } else {
            winnersString = "\nResult: It's a draw";
        }
        return winnersString;
    }
}
