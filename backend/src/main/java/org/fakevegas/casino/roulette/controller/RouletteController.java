package org.fakevegas.casino.roulette.controller;

import org.fakevegas.casino.roulette.dto.RouletteRequest;
import org.fakevegas.casino.roulette.dto.RouletteResult;
import org.fakevegas.casino.roulette.service.RouletteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roulette")
@CrossOrigin("*")
public class RouletteController {
    private final RouletteService rouletteService;

    public RouletteController(RouletteService rouletteService) {
        this.rouletteService = rouletteService;
    }

    @PostMapping("/play")
    public RouletteResult play(@RequestBody RouletteRequest request) {
        return rouletteService.play(request);
    }
}