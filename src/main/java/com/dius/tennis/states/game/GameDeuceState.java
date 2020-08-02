package com.dius.tennis.states.game;

import com.dius.tennis.states.InProgressState;

public class GameDeuceState implements GameState, InProgressState {
  public GameDeuceState() {
    super();
  }

  @Override
  public String getMessage() {
    return "Deuce";
  }
}
