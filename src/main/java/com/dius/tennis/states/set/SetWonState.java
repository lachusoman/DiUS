package com.dius.tennis.states.set;

import com.dius.tennis.states.WonState;

public class SetWonState implements SetState, WonState {
    private String message;
    public SetWonState(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
