package com.dius.tennis.end2end;

import com.dius.tennis.Match;
import com.dius.tennis.states.DiUSTennisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void scenario1DiUSQuestionTest() {
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 1");
        match.pointWonBy("player 2");
        // this will return "0-0, 15-15"
        assertEquals("0-0, 15-15", match.score());


        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        // this will return "0-0, 40-15"
        assertEquals("0-0, 40-15", match.score());

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        // this will return "0-0, Deuce"
        assertEquals("0-0, Deuce", match.score());

        match.pointWonBy("player 1");
        // this will return "0-0, Advantage player 1"
        assertEquals("0-0, Advantage player 1", match.score());

        match.pointWonBy("player 1");
        // this will return "1-0"
        assertEquals("1-0", match.score());
    }

    @Test
    public void playerOneStraightWinTest() {
        Match match = new Match("player 1", "player 2");
        for (int j = 1; j <= 6; j++) {
            straightWin(match, "player 1", 4);
            assertEquals(j + "-0", match.score());
        }
        straightWin(match, "player 1", 4);
        assertEquals("player 1 Won", match.score());
    }

    @Test
    public void deuceAndAdvTest() {
        Match match = new Match("player 1", "player 2");
        straightWin(match, "player 1", 3);
        straightWin(match, "player 2", 3);
        assertEquals("0-0, Deuce", match.score());
        match.pointWonBy("player 2");
        assertEquals("0-0, Advantage player 2", match.score());
        match.pointWonBy("player 1");
        assertEquals("0-0, Deuce", match.score());
        match.pointWonBy("player 1");
        assertEquals("0-0, Advantage player 1", match.score());
        match.pointWonBy("player 1");
        assertEquals("1-0", match.score());
    }

    @Test
    public void deuceAndAdvReverseTest() {
        Match match = new Match("player 1", "player 2");
        straightWin(match, "player 1", 3);
        straightWin(match, "player 2", 3);
        assertEquals("0-0, Deuce", match.score());
        match.pointWonBy("player 2");
        assertEquals("0-0, Advantage player 2", match.score());
        match.pointWonBy("player 1");
        assertEquals("0-0, Deuce", match.score());
        match.pointWonBy("player 2");
        assertEquals("0-0, Advantage player 2", match.score());
        match.pointWonBy("player 2");
        assertEquals("0-1", match.score());
    }

    @Test
    public void grandSlamTest() {
        Match match = new Match("player 1", "player 2");
        straightWin(match, "player 1", 27);
        assertEquals("6-0, 40-0", match.score());
        straightWin(match, "player 1", 1);
        assertEquals("player 1 Won", match.score());
    }

    @Test
    public void negativeTest() {
        Match match = new Match("player 1", "player 2");
        straightWin(match, "player 1", 28);
        assertEquals("player 1 Won", match.score());

        straightWin(match, "player 1", 3);
        assertEquals("player 1 Won", match.score());
    }

    @Test()
    public void aPlaysBButCWinsWeirdTest() {
        Match match = new Match("player a", "player b");
        Assertions.assertThrows(DiUSTennisException.class, () -> {
            match.pointWonBy("player c");
        });
    }

    public void straightWin(Match match, String player, int times) {
        for (int i = 0; i < times; i++) {
            match.pointWonBy(player);
        }
    }
}
