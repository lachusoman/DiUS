package com.dius.tennis.states.point;

public class Fifteen implements ProgressablePointState {
  private static final Thirty thirty = new Thirty();

  @Override
  public PointState progress() {
    return thirty;
  }

  @Override
  public String toString() {
    return "15";
  }
}
