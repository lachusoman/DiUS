package com.dius.tennis.states.game;

import com.dius.tennis.states.InProgressState;

public class GameOnState implements GameState, InProgressState {
  String message;
  public GameOnState(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
