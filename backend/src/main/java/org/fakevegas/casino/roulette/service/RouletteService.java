package org.fakevegas.casino.roulette.service;

import org.fakevegas.casino.roulette.dto.RouletteRequest;
import org.fakevegas.casino.roulette.dto.RouletteResult;
import org.fakevegas.casino.roulette.model.Slots;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RouletteService {
    private final Random random = new Random();

    public RouletteResult play(RouletteRequest request) {
        Slots[] slots = Slots.values();
        Slots rolledSlot = slots[random.nextInt(slots.length)]; // pseudorandom, i need to fix this

        boolean win = rolledSlot.getColor() == request.color();
        return new RouletteResult(rolledSlot.getColor(), win);
    }
}