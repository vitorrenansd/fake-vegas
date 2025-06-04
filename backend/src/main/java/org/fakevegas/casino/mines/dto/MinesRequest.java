package org.fakevegas.casino.mines.dto;

public class MinesRequest {
    private int betAmount;
    private int mines;

    public int getBetAmount() {
        return betAmount;
    }
    public int getMines() {
        return mines;
    }
    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
    public void setMines(int mines) {
        this.mines = mines;
    }
}