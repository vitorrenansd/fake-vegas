package org.fakevegas.casino.dice.service;

import org.fakevegas.casino.dice.dto.DiceRequest;
import org.fakevegas.casino.dice.dto.DiceResult;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {
    private final Random random = new Random();

    public DiceResult play(DiceRequest request) {
        int rolled = random.nextInt(101); // pseudorandom, i need to fix this
        // Determine win condition
        boolean win = request.inverted() 
            ? rolled >= (100 - request.cutoff()) 
            : rolled <= request.cutoff();
        return new DiceResult(rolled, win);
    }
}