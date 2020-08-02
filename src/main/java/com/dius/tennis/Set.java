package com.dius.tennis;

import com.dius.tennis.states.WonState;
import com.dius.tennis.states.game.GameState;
import com.dius.tennis.states.set.SetOnState;
import com.dius.tennis.states.set.SetState;
import com.dius.tennis.states.set.SetWonState;

public class Set {
    private final MatchContextHelper matchContextHelper;
    private final Game game;
    private final int[] score = new int[2];

    public Set(MatchContextHelper matchContextHelper) {
        this.matchContextHelper = matchContextHelper;
        this.game = new Game(matchContextHelper);
    }

    public SetState pointWonBy(String player) {
        int winnerIndex = matchContextHelper.getPlayerIndex(player);
        GameState onGoingGameState = game.pointWonBy(player);
        if (onGoingGameState instanceof WonState) {
            score[winnerIndex]++;
        }
        final String setScore = String.format("%s-%s", score[0], score[1]);
        if (score[winnerIndex] > 6 && (score[winnerIndex] >= score[1 - winnerIndex] + 2)) {
            return new SetWonState(setScore);
        }

        return new SetOnState(setScore, onGoingGameState);
    }
}
