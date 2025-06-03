package org.fakevegas.casino.dice.model;

public class DiceGame {
    private final int bet;
    private final int roll;
    private final boolean win;

    public DiceGame(int bet, int roll, boolean win) {
        this.bet = bet;
        this.roll = roll;
        this.win = win;
    }

    public int getBet() {
        return this.bet;
    }
    public int getRoll() {
        return this.roll;
    }
    public boolean getWin() {
        return this.win;
    }
}