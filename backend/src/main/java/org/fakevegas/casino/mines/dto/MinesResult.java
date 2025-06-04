package org.fakevegas.casino.mines.dto;

import java.util.List;

public class MinesResult {
    private boolean exploded;
    private List<Integer> field;

    public MinesResult(boolean exploded, List<Integer> field) {
        this.exploded = exploded;
        this.field = field;
    }

    public boolean getExploded() {
        return this.exploded;
    }
    public List<Integer> getField() {
        return this.field;
    }
}