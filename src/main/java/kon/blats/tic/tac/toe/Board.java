package kon.blats.tic.tac.toe;

/**
 * Created by kon on 7/7/2018.
 */
public class Board {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    public char[][] boardValues = new char[ROWS][COLUMNS];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        char selectionValue = '1';
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                boardValues[row][column] = selectionValue;
                selectionValue++;
            }
        }
    }

    public boolean isGameOver() {
        for (int row = 0; row < ROWS; row++) {
            if (isCurrentRowHasTheSameValue(row)) {
                return true;
            }
        }

        for (int column = 0; column < COLUMNS; column++) {
            if (isCurrentColumnHasTheSameValue(column)) {
                return true;
            }
        }

        if (diagonalsHaveTheSameValue()) {
            return true;
        }

        return false;
    }

    private boolean isCurrentRowHasTheSameValue(int row) {
        return (boardValues[row][0] == boardValues[row][1])
                && (boardValues[row][1] == boardValues[row][2]);
    }

    private boolean isCurrentColumnHasTheSameValue(int column) {
        return (boardValues[0][column] == boardValues[1][column])
                && (boardValues[1][column] == boardValues[2][column]);
    }

    private boolean diagonalsHaveTheSameValue() {
        if ((boardValues[0][0] == boardValues[1][1])
                && (boardValues[1][1] == boardValues[2][2])) {
            return true;
        }

        if ((boardValues[2][0] == boardValues[1][1])
                && (boardValues[1][1] == boardValues[0][2])) {
            return true;
        }

        return false;
    }

}
