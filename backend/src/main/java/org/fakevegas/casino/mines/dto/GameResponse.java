package org.fakevegas.casino.mines.dto;

import java.util.List;

public class GameResponse {
    private boolean exploded;
    private List<Integer> field;

    public GameResponse(boolean exploded, List<Integer> field) {
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