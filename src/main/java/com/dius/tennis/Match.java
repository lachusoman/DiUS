package com.dius.tennis;

import com.dius.tennis.states.WonState;
import com.dius.tennis.states.set.SetState;
public class Match {
    private final Set set;
    private SetState onGoingSetState;
    private String score;
    MatchContextHelper matchContextHelper;

    public Match(String player1, String player2) {
        this.matchContextHelper = new MatchContextHelper(player1, player2);
        this.set = new Set(matchContextHelper);
    }

    public void pointWonBy(String player) {
        matchContextHelper.validatePlayer(player);
        if (onGoingSetState instanceof WonState) return;
        this.onGoingSetState = set.pointWonBy(player);
        if (onGoingSetState instanceof WonState) {
            score = player + " Won";
        } else {
            score = onGoingSetState.toString();
        }
    }

    public String score() {
        return score;
    }
}

