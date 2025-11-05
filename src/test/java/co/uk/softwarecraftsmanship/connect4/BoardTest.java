package co.uk.softwarecraftsmanship.connect4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board();
    }

    @Test
    public void when_a_token_is_placed_in_the_first_column_then_the_second_column_is_empty(){

        board.placeTokenAt(0);

        assertThat(board.hasTokenAt(0,0), is(true));
        assertThat(board.hasTokenAt(1,0), is(false));
    }

    @Test
    public void when_one_token_is_placed_in_the_first_and_second_column_then_both_columns_are_not_empty(){

        board.placeTokenAt(0);
        board.placeTokenAt(1);

        assertThat(board.hasTokenAt(0,0), is(true));
        assertThat(board.hasTokenAt(1,0), is(true));
    }

    @Test
    public void when_two_tokens_are_placed_in_the_first_column_then_second_column_is_empty(){

        board.placeTokenAt(0);
        board.placeTokenAt(0);

        assertThat(board.hasTokenAt(0,0), is(true));
        assertThat(board.hasTokenAt(0,1), is(true));
        assertThat(board.hasTokenAt(1,0), is(false));
    }

    @Test
    public void when_two_tokens_are_placed_in_the_second_column_then_first_column_is_empty(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertThat(board.hasTokenAt(0,0), is(false));
        assertThat(board.hasTokenAt(1,0), is(true));
        assertThat(board.hasTokenAt(1,1), is(true));
    }

    @Test
    public void when_a_token_is_placed_in_the_eight_column_then_the_move_is_invalid(){

        assertThrows(IndexOutOfBoundsException.class, () -> board.placeTokenAt(8));
    }

    @Test
    public void when_four_tokens_are_placed_in_a_column_then_player_wins(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertThat(HasWon(board), is(true));

    }

    @Test
    public void when_three_tokens_are_placed_in_a_column_then_player_has_not_won(){

        board.placeTokenAt(1);
        board.placeTokenAt(1);
        board.placeTokenAt(1);

        assertThat(HasWon(board), is(false));

    }

    @Test
    public void when_four_tokens_are_placed_in_a_single_row_then_player_wins(){

        board.placeTokenAt(0);
        board.placeTokenAt(1);
        board.placeTokenAt(2);
        board.placeTokenAt(3);

        assertThat(HasWon(board), is(true));
    }

    private boolean HasWon(Board board) {
        return board.hasTokenAt(3, 0) || board.hasTokenAt(1, 3);
    }
}
