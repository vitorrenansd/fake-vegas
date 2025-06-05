package org.fakevegas.casino.mines.controller;

import org.fakevegas.casino.mines.dto.ClickRequest;
import org.fakevegas.casino.mines.dto.ClickResult;
import org.fakevegas.casino.mines.dto.GameResult;
import org.fakevegas.casino.mines.dto.GameRequest;
import org.fakevegas.casino.mines.service.MinesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mines")
@CrossOrigin("*")
public class MinesController {
    private final MinesService service;

    public MinesController(MinesService service) {
        this.service = service;
    }

    @PostMapping("/play")
    public GameResult start(@RequestBody GameRequest request) {
        return service.startGame(request);
    }

    @PostMapping("/click")
    public ClickResult click(@RequestBody ClickRequest clickRequest) {
        return service.click(clickRequest);
    }
}