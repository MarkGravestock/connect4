package co.uk.softwarecraftsmanship.connect4;

public class Game {
    int count = 0;

    public void playTokenInColumn(int column, Colour red) {
        count++;
    }

    public boolean hasWinner(Colour red) {
        return count > 3;
    }
}
