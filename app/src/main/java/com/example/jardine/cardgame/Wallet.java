package com.example.jardine.cardgame;

/**
 * Created by jardine on 11/01/2018.
 */

public class Wallet {
    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }

    public void empty() {
        this.amount = 0;
    }
}
