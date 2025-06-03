package org.fakevegas.casino.dice.controller;

import org.fakevegas.casino.dice.dto.DiceRequest;
import org.fakevegas.casino.dice.dto.DiceResult;
import org.fakevegas.casino.dice.service.DiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice")
public class DiceController {
    private final DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @PostMapping("/play")
    public DiceResult play(@RequestBody DiceRequest request) {
        return diceService.play(request);
    }
}