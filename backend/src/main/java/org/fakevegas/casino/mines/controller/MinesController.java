package org.fakevegas.casino.mines.controller;

import org.fakevegas.casino.mines.dto.ClickRequest;
import org.fakevegas.casino.mines.dto.MinesResult;
import org.fakevegas.casino.mines.dto.MinesRequest;
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
    public MinesResult start(@RequestBody MinesRequest request) {
        return service.startGame(request);
    }

    @PostMapping("/click")
    public MinesResult click(@RequestBody ClickRequest clickRequest) {
        return service.click(clickRequest);
    }
}