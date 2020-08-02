package com.dius.tennis;

import com.dius.tennis.states.WonState;
import com.dius.tennis.states.game.*;
import com.dius.tennis.states.point.*;

public class Game {
  private static final Love LOVE = new Love();
  private static final Deuce DEUCE = new Deuce();
  private PointState[] playerPointState = new PointState[]{LOVE, LOVE};
  private MatchContextHelper matchContextHelper;

  public Game(MatchContextHelper matchContextHelper) {
    this.matchContextHelper = matchContextHelper;
  }

  public GameState pointWonBy(String winnerName) {
    int winner = matchContextHelper.getPlayerIndex(winnerName);
    PointState winnerState = ((ProgressablePointState) playerPointState[winner]).progress();
    PointState loserState = playerPointState[1 - winner];
    if (winnerState instanceof WonState) {
      playerPointState[0] = LOVE;
      playerPointState[1] = LOVE;
      return new GameWonState();
    }
    playerPointState[winner] = winnerState;
    if ((winnerState instanceof Fourty && loserState instanceof Fourty) || (winnerState instanceof Advantage && loserState instanceof Advantage)) {
      playerPointState[0] = DEUCE;
      playerPointState[1] = DEUCE;
      return new GameDeuceState();
    }
    if (winnerState instanceof Advantage) {
      return new GameAdvantageState(winnerName);
    }
    return new GameOnState(String.format("%s-%s", playerPointState[0], playerPointState[1]));
  }

  @Override
  public String toString() {
    return String.format("%s-%s", playerPointState[0], playerPointState[1]);
  }
}
