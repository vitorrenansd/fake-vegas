package org.fakevegas.casino.mines.service;

import org.fakevegas.casino.mines.model.MinesGame;
import org.springframework.stereotype.Service;

@Service
public class MinesService {
    private MinesGame currentGame;

    public MinesGame startGame(int betAmount, int mines) {
        currentGame = new MinesGame(betAmount, mines);
        return currentGame;
    }

    public MinesGame getCurrentGame() {
        return this.currentGame;
    }
}
