package kon.blats.tic.tac.toe;

import java.io.IOException;

/**
 * Created by kon on 7/7/2018.
 */
public class TicTacToeTest {

    public static void main(String[] args) throws IOException {
        Board board = new Board();

        int playerIndicator = 1;
        String currentPlayer = null;
        char playerValue;
        while (!board.isGameOver()) {

            if (isPlayerTwo(playerIndicator)) {
                playerValue = 'O';
                currentPlayer = "p2";
            } else {
                playerValue = 'X';
                currentPlayer = "p1";
            }

            System.out.println("player " + currentPlayer +" plays");
            System.out.println("select a available number between 1 - 9");
            System.out.println("Current tic-tac-toe state");
            printBoard(board);

            char userValue = (char) System.in.read();
            while (userValue < '1' || userValue > '9') {
                System.out.println("please select a number between 1 - 9");
                userValue = (char) System.in.read();
            }

            while (!fillUsersValues(Character.getNumericValue(userValue), board, playerValue)) {
                System.out.println("This cell is already filled please select again");
                userValue = (char) System.in.read();
                System.out.println(userValue);
            }

            playerIndicator++;
        }

        System.out.println("Player: " + currentPlayer + " won the game!");
        printBoard(board);
    }

    public static boolean fillUsersValues(int userNumber, Board board, char userValue) {
        userNumber = userNumber - 1;
        int x = userNumber / 3;
        int y = userNumber % 3;

        if (isAlreadyFilled(board, x, y)) {
            System.out.println("The current position is already filled");
            return false;
        } else {
            board.boardValues[x][y] = userValue;
            return true;
        }
    }

    public static boolean isAlreadyFilled(Board board, int x, int y) {
        return board.boardValues[x][y] == 'X' || board.boardValues[x][y] == 'O';
    }

    public static void printBoard(Board board) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(board.boardValues[row][column]);
            }
            System.out.println();
        }
    }

    public static boolean isPlayerTwo(int playerIndicator) {
        return playerIndicator % 2 == 0;
    }
}
