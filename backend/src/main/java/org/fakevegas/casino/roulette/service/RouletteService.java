package org.fakevegas.casino.roulette.service;

import org.fakevegas.casino.roulette.dto.RouletteRequest;
import org.fakevegas.casino.roulette.dto.RouletteResult;
import org.fakevegas.casino.roulette.model.Colors;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RouletteService {
    private final Random random = new Random();

    public RouletteResult play(RouletteRequest request) {
        Colors[] colors = Colors.values();
        Colors rolled = colors[random.nextInt(colors.length)]; // pseudorandom, i need to fix this

        boolean win = rolled == request.color();
        return new RouletteResult(rolled, win);
    }
}