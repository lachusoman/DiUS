package com.dius.tennis.states.set;

import com.dius.tennis.states.WonState;
import com.dius.tennis.states.game.GameState;

public class AbstractSetState implements SetState{
    private String message;
    private GameState onGoingGame;
    public AbstractSetState(String message, GameState onGoingGame) {
        this.message = message;
        this.onGoingGame = onGoingGame;
    }

    @Override
    public String getMessage() {
        return message;
    }
    public GameState getOnGoingGame() {
        return onGoingGame;
    }

    @Override
    public String toString() {
        if(onGoingGame instanceof WonState) {
            return message;
        }
        return String.format("%s, %s", message, onGoingGame.getMessage());
    }
}
