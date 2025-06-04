package org.fakevegas.casino.mines.model;

import java.util.List;

public class MinesGame {
    private List<Integer> field;
    private int betAmount;
    private int mines;
    private boolean exploded;

    public MinesGame(List<Integer> field, int betAmount, int mines) {
        this.field = field;
        this.betAmount = betAmount;
        this.mines = mines;
        this.exploded = false;
    }

    public List<Integer> getField() {
        return field;
    }
    public int getBetAmount() {
        return betAmount;
    }
    public int getMines() {
        return mines;
    }
    public boolean isExploded() {
        return exploded;
    }
    public void setField(List<Integer> field) {
        this.field = field;
    }
    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }
}