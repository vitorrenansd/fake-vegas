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
        
        boolean win = request.inverted() ? rolled >= (100 - request.cutoff()) : rolled <= request.cutoff();
        // NOT INVERTED: You win if you roll a number lower than or equal to your chosen number
        // INVERTED: You win if you roll a number higher than or equal to your chosen number

        return new DiceResult(rolled, win);
    }
}