package com.dius.tennis;

import com.dius.tennis.states.DiUSTennisException;

/**
 * Ideally this is a candidate of Dependency injection.
 * By Dependency Inversion Principle I would inject it wherever it is required.
 */
public class MatchContextHelper {
    private final String player0;
    private final String player1;

    public MatchContextHelper(String player0, String player1) {
        if (player0 == null || player1 == null || player0.equals(player1)) {
            throw new DiUSTennisException("Players name cannot be null or same");
        }
        this.player0 = player0;
        this.player1 = player1;
    }

    public void validatePlayer(String player) {
        if (!player.equals(player0) && !player.equals(player1)) {
            throw new DiUSTennisException(String.format("%s cannot win when %s plays %s", player, player0, player1));
        }
    }

    public String getPlayerName(int index) {
        switch (index) {
            case 0:
                return player0;
            case 1:
                return player1;
            default:
                throw new DiUSTennisException("Player not found for index" + index);
        }
    }

    public int getPlayerIndex(String player) {
        if (player0.equals(player)) {
            return 0;
        } else if (player1.equals(player1)) {
            return 1;
        }
        throw new DiUSTennisException("Player Index not found for ." + player);
    }
}
