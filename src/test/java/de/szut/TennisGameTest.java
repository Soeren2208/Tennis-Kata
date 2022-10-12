package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TennisGameTest {

    private TennisGame game;

    @BeforeEach
    public void setUp(){
        this.game = new TennisGame("Federer", "Nadal");
    }

    @Test
    public void givenNoPointPlay_WhenGetResult_ThenReturnLove(){
        String result = this.game.getResult();
        assertThat(result, is("Love all"));
    }


}
