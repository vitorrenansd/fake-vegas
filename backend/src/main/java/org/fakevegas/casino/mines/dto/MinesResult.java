package org.fakevegas.casino.mines.dto;

import java.util.List;

public class MinesResult {
    private boolean exploded;
    private double multiplier;
    private List<Integer> field;

    public MinesResult(boolean exploded, double multiplier, List<Integer> field) {
        this.exploded = exploded;
        this.multiplier = multiplier;
        this.field = field;
    }

    public boolean isExploded() {
        return exploded;
    }
    public double getMultiplier() {
        return multiplier;
    }
    public List<Integer> getField() {
        return field;
    }
}