package co.uk.softwarecraftsmanship.connect4;

import co.uk.softwarecraftsmanship.connect4.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board();
    }

    @Test
    public void when_a_token_is_placed_in_the_first_column_then_the_second_column_is_empty(){

        board.placeTokenAt(0);

        assertTrue(board.hasTokenAt(0,0));
        assertFalse(board.hasTokenAt(1,0));
    }

    @Test
    public void when_one_token_is_placed_in_the_first_and_second_column_then_both_columns_are_not_empty(){

        board.placeTokenAt(0);
        board.placeTokenAt(1);

        assertTrue(board.hasTokenAt(0,0));
        assertTrue(board.hasTokenAt(1,0));
    }

    @Test
    public void when_two_tokens_are_placed_in_the_first_column_then_second_column_is_empty(){

        board.placeTokenAt(0);
        board.placeTokenAt(0);

        assertTrue(board.hasTokenAt(0,0));
        assertTrue(board.hasTokenAt(0,1));
        assertFalse(board.hasTokenAt(1,0));
    }

    @Test
    public void when_two_tokens_are_placed_in_the_second_column_then_first_column_is_empty(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertFalse(board.hasTokenAt(0,0));
        assertTrue(board.hasTokenAt(1,0));
        assertTrue(board.hasTokenAt(1,1));
    }

    @Test
    public void when_a_token_is_placed_in_the_eight_column_then_the_move_is_invalid(){

        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.placeTokenAt(8);
        });
    }

    @Test
    public void when_four_tokens_are_placed_in_a_column_then_player_wins(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertTrue(HasWon(board));

    }

    @Test
    public void when_three_tokens_are_placed_in_a_column_then_player_has_not_won(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertFalse(HasWon(board));

    }

    @Test
    public void when_four_tokens_are_placed_in_a_single_row_then_player_wins(){

        board.placeTokenAt(0);
        board.placeTokenAt(1);
        board.placeTokenAt(2);
        board.placeTokenAt(3);

        assertTrue(HasWon(board));
    }

    private boolean HasWon(Board board) {
        return board.hasTokenAt(3, 0) || board.hasTokenAt(1, 3);
    }
}
