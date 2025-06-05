package org.fakevegas.casino.mines.service;

import org.fakevegas.casino.mines.dto.ClickRequest;
import org.fakevegas.casino.mines.dto.ClickResult;
import org.fakevegas.casino.mines.dto.GameRequest;
import org.fakevegas.casino.mines.dto.GameResult;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MinesService {
    private List<Integer> field;
    private final int fieldSize = 25;
    private int betAmount;
    private int mines;
    private boolean exploded;

    public int getBetAmount() {
        return this.betAmount;
    }

    private GameResult toGameResult() {
        return new GameResult(calculateMultiplier(), field);
    }
    private ClickResult toClickResult() {
        return new ClickResult(exploded, calculateMultiplier());
    }
    
    // Initializes a new mines game
    public GameResult startGame(GameRequest request) {
        this.betAmount = request.betAmount();
        this.mines = request.mines();
        this.exploded = false;
        this.field = generateField(mines);
        return toGameResult();
    }

    // Handles player click on a field position
    public ClickResult click(ClickRequest clickRequest) {
        if (exploded || field == null) return toClickResult();

        int index = clickRequest.index();
        if (index < 0 || index >= fieldSize) return toClickResult();

        int value = field.get(index);
        if (value == 1) {
            exploded = true;
        } else if (value == 0) {
            field.set(index, 2);
        }
        return toClickResult();
    }

    // Creates and shuffles the game field with bombs
    private List<Integer> generateField(int bombs) {
        List<Integer> newField = new ArrayList<>();
        // 0 = empty
        // 1 = bomb
        // 2 = clicked
        for (int i = 0; i < bombs; i++) newField.add(1); // Contains bombs
        for (int i = bombs; i < fieldSize; i++) newField.add(0); // Safe ones

        Collections.shuffle(newField); // Shuffle the field
        return newField;
    }

    // Calculates current win multiplier based on revealed safe positions
    private double calculateMultiplier() {
        int totalSafe = fieldSize - mines;
        long safeRevealed = field.stream().filter(i -> i == 2).count();

        double multiplier = 1.0;
        for (int i = 0; i < safeRevealed; i++) {
            multiplier *= (double)(totalSafe - i) / (fieldSize - i);
        }
        double rtp = 0.92;
        return Math.round((1.0 / multiplier) * rtp * 100.0) / 100.0;
    }
}