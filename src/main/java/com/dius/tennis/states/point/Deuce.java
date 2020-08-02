package com.dius.tennis.states.point;

public class Deuce implements ProgressablePointState {
  private static final Advantage advantage = new Advantage();

  @Override
  public PointState progress() {
    return advantage;
  }

  @Override
  public String toString() {
    return "Deuce";
  }
}
