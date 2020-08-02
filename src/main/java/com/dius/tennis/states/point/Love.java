package com.dius.tennis.states.point;

public class Love implements ProgressablePointState {
  private static final Fifteen fifteen = new Fifteen();

  @Override
  public PointState progress() {
    return fifteen;
  }

  @Override
  public String toString() {
    return "0";
  }
}
