package org.fakevegas.casino.mines.controller;

import org.fakevegas.casino.mines.dto.ClickRequest;
import org.fakevegas.casino.mines.dto.MinesResult;
import org.fakevegas.casino.mines.model.MinesGame;
import org.fakevegas.casino.mines.service.MinesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mines")
@CrossOrigin("*")
public class MinesController {
    private final MinesService minesService;

    public MinesController(MinesService minesService) {
        this.minesService = minesService;
    }

    @PostMapping("/play")
    public MinesResult play(@RequestParam int bet, @RequestParam int mines) {
        MinesGame minesGame = minesService.startGame(bet, mines);
        return new MinesResult(minesGame.isExploded(), minesGame.getField());
    }

    @PostMapping("/click")
    public MinesResult click(@RequestBody ClickRequest clickRequest) {
        MinesGame minesGame = minesService.getCurrentGame();
        minesGame.click(clickRequest.getIndex());
        return new MinesResult(minesGame.isExploded(), minesGame.getField());
    }
}