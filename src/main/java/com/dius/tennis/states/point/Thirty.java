package com.dius.tennis.states.point;

public class Thirty implements ProgressablePointState {
  private static final Fourty FOURTY = new Fourty();

  @Override
  public PointState progress() {
    return FOURTY;
  }

  @Override
  public String toString() {
    return "30";
  }
}
