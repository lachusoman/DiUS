package com.dius.tennis.states.set;

import com.dius.tennis.states.InProgressState;
import com.dius.tennis.states.game.GameState;

public class SetOnState extends AbstractSetState implements InProgressState {

    public SetOnState(String message, GameState gameState) {
        super(message,gameState);
    }
}
