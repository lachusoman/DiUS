package com.dius.tennis.states.point;

import com.dius.tennis.states.InProgressState;

public interface ProgressablePointState extends PointState, InProgressState {
  public PointState progress();
}
