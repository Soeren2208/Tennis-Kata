package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisGameTest {

    private TennisGame game;

    @BeforeEach
    public void setUp(){
        this.game = new TennisGame("Federer", "Nadal");
    }

    @Test
    public void givenServicePlayerWonPoint_WhenGetResult_Then15Love(){
        this.game.makePoint("Federer");
        assertThat(this.game.getResult(), is("15 love"));
    }

    @Test
    public void givenServicePlayerWonTwoPoints_WhenGetResult_Then30love(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        assertThat(this.game.getResult(), is("30 love"));
    }

    @Test
    public void givenBothPlayersWonPoints_WhenGetResult_Then30_15(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        assertThat(this.game.getResult(), is("30 15"));
    }

    @Test
    public void givenWrongPlayerName_WhenMakePoint_ThenThrowIllegalArgumentException(){
        Exception e = assertThrows(IllegalArgumentException.class, ()-> this.game.makePoint("falscher Name"));
        assertThat(e.getMessage(), is(equalTo("Wrong playername!")));
    }

    @Test
    public void givenDraw_WhenGetResult_ThenReturnScoreWithAll(){
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        assertThat(this.game.getResult(), is(equalTo("15 all")));
    }

    @Test
    public void givenWinGame_WhenGetResult_ThenReturnGame(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        assertThat(this.game.getResult(), is(equalTo("Game Federer")));
    }

    @Test
    public void givenDeuce_WhenGetResult_ThenDeuce(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        assertThat(this.game.getResult(), is(equalTo("Deuce")));
    }

    @Test
    public void givenAdventage_WhenGetResult_ThenAdvantage(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        assertThat(this.game.getResult(), is(equalTo("Advantage Nadal")));
    }

    @Test
    public void givenWinAfterAdventage_WhenGetResult_ThenGame(){
        this.game.makePoint("Federer");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Federer");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        this.game.makePoint("Nadal");
        assertThat(this.game.getResult(), is(equalTo("Game Nadal")));
    }



}
