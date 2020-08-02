package com.dius.tennis.states.point;

public class Advantage implements ProgressablePointState {
  private static final PointWonState won = new PointWonState();

  @Override
  public PointState progress() {
    return won;
  }

  @Override
  public String toString() {
    return "Adv";
  }
}
