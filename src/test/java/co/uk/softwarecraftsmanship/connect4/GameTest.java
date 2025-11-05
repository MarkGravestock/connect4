package co.uk.softwarecraftsmanship.connect4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @Test
    public void when_there_are_four_tokens_of_the_same_column_that_colour_wins() {
        Game game = new Game();
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        assertTrue(game.hasWinner(Colour.Red));
    }

    @Test
    public void when_there_are_three_tokens_of_the_same_colour_in_th_same_column_that_colour_has_not_won() {
        Game game = new Game();
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        assertFalse(game.hasWinner(Colour.Red));
    }

}
