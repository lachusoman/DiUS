package com.dius.tennis.states.point;

import com.dius.tennis.states.WonState;

public class PointWonState implements PointState, WonState {
  @Override
  public String toString() {
    return "Won";
  }
}
