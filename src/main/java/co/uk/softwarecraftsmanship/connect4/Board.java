package co.uk.softwarecraftsmanship.connect4;

public class Board {
    private final Column[] columns;

    public Board() {
        int numberOfColumns = 7;
        columns = new Column[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++){
            columns[i] = new Column();
        }
    }

    public void placeTokenAt(int columnIndex) {

        if(columnIndex > columns.length)
        {
            throw new IndexOutOfBoundsException();
        }
        columns[columnIndex].placeToken();
    }

    public boolean hasTokenAt(int columnIndex, int rowIndex) {
        return columns[columnIndex].hasTokenAt(rowIndex);
    }
}
