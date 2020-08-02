package com.dius.tennis.states.game;

import com.dius.tennis.states.InProgressState;

public class GameAdvantageState implements GameState, InProgressState {
    private final String player;

    public GameAdvantageState(String player) {
        this.player = player;
    }

    public String getMessage() {
        return "Advantage " + player;
    }
}
