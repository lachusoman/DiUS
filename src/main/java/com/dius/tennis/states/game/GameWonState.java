package com.dius.tennis.states.game;

import com.dius.tennis.states.WonState;

public class GameWonState implements GameState, WonState {
  private String player;
  @Override
  public String getMessage() {
    return "";
  }
}
