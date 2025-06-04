package org.fakevegas.casino.mines.service;

import org.fakevegas.casino.mines.dto.ClickRequest;
import org.fakevegas.casino.mines.dto.MinesRequest;
import org.fakevegas.casino.mines.dto.MinesResult;
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

    public MinesResult startGame(MinesRequest request) {
        this.betAmount = request.getBetAmount();
        this.mines = request.getMines();
        this.exploded = false;
        this.field = generateField(mines);
        return toResult();
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public MinesResult click(ClickRequest clickRequest) {
        if (exploded || field == null) return toResult();

        int index = clickRequest.getIndex();
        if (index < 0 || index >= 25) return toResult();

        int value = field.get(index);
        if (value == 1) {
            exploded = true;
        } else if (value == 0) {
            field.set(index, 2); // marcar como clicado
        }
        return toResult();
    }

    private List<Integer> generateField(int bombs) {
        List<Integer> newField = new ArrayList<>();
        for (int i = 0; i < bombs; i++) newField.add(1); // bombas
        for (int i = bombs; i < fieldSize; i++) newField.add(0); // seguros
        Collections.shuffle(newField);
        return newField;
    }

    private double calculateMultiplier() {
        int totalSafe = fieldSize - mines;
        long safeRevealed = field.stream().filter(i -> i == 2).count();

        double multiplier = 1.0;
        for (int i = 0; i < safeRevealed; i++) {
            multiplier *= (double)(totalSafe - i) / (fieldSize - i);
        }
        double rtp = 0.99;
        return Math.round((1.0 / multiplier) * rtp * 100.0) / 100.0;
    }

    private MinesResult toResult() {
        return new MinesResult(exploded, calculateMultiplier(), field);
    }
}