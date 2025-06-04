package org.fakevegas.casino.mines.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinesGame {
    private final int bet;
    private final int mines;
    private final int fieldSize = 25;
    private List<Integer> field;
    private boolean exploded = false;

    public MinesGame(int bet, int mines) {
        this.bet = bet;
        this.mines = mines;
        this.field = createField(mines);
    }

    private List<Integer> createField(int bombs) {
        List<Integer> field = new ArrayList<>();
        for (int i = 0; i < bombs; i++) { 
            field.add(1); // Fill bombs
        }
        for (int i = bombs; i < fieldSize; i++) {
            field.add(0); // Fill remaining with empty
        }

        Collections.shuffle(field);
        return field;
    }

    public boolean click(int index) {
        if (exploded || index < 0 || index >= fieldSize) return false;

        int clickedIdx = field.get(index);

        if (clickedIdx == 1) {
            exploded = true;
            return false;
        } else if (clickedIdx == 0) {
            field.set(index, 2);
            return true;
        }
        return true; // Already clicked
    }

    public int getBet() {
        return this.bet;
    }
    public int getMines() {
        return this.mines;
    }
    public boolean isExploded() {
        return exploded;
    }
    public List<Integer> getField() {
        return field;
    }
}