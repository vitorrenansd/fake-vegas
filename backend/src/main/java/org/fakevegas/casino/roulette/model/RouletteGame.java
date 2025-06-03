package org.fakevegas.casino.roulette.model;

public class RouletteGame {
    private final int bet;
    private final Colors color;
    private final boolean win;

    public RouletteGame(int bet, Colors color, boolean win) {
        this.bet = bet;
        this.color = color;
        this.win = win;
    }

    public int getBet() {
        return this.bet;
    }
    public Colors getColor() {
        return this.color;
    }
    public boolean getWin() {
        return this.win;
    }
}