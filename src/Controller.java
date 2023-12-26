import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Controller {
    private BoardModel board;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    public Controller(BoardModel board) {
        this.board = board;
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new ComputerPlayer();
    }

    public void startPlaying(int column, JButton[][] buttons) {
        humanPlayer.makeMove(column, buttons, getCurrentPlayerColor(), board);
    }

    public void computerMakesMove(JButton[][] buttons) {
        Random random = new Random();
        int column = random.nextInt(board.getColumnCount());
        computerPlayer.makeMove(column, buttons, getCurrentPlayerColor(), board);


    }

    public boolean checkForWinner(int row, int col) {
        return check4Across(row, col) || check4UpAndDown(row, col) || checkDiagonal(row, col);
    }

    private boolean checkDiagonal(int row, int col) {
        return checkDiagonalUp(row, col) || checkDiagonalDown(row, col);
    }

    private boolean checkDiagonalUp(int row, int col) {
        Color color = getCurrentPlayerColor();
        int count = 0;

        // Check diagonally up and to the right
        for (int r = row, c = col; r >= 0 && c < board.getColumnCount() && board.getColor(r, c) == color; r--, c++) {
            count++;
        }

        // Check diagonally down and to the left
        for (int r = row + 1, c = col - 1; r < board.getRowCount() && c >= 0 && board.getColor(r, c) == color; r++, c--) {
            count++;
        }

        return count >= board.getWinConditionCount();
    }

    private boolean checkDiagonalDown(int row, int col) {
        Color color = getCurrentPlayerColor();
        int count = 0;

        // Check diagonally up and to the left
        for (int r = row, c = col; r >= 0 && c >= 0 && board.getColor(r, c) == color; r--, c--) {
            count++;
        }

        // Check diagonally down and to the right
        for (int r = row + 1, c = col + 1; r < board.getRowCount() && c < board.getColumnCount() && board.getColor(r, c) == color; r++, c++) {
            count++;
        }

        return count >= board.getWinConditionCount();
    }


    private boolean check4UpAndDown(int row, int col) {
        Color color = getCurrentPlayerColor();
        int count = 0;

        // Check vertically upward
        for (int r = row; r >= 0 && board.getColor(r, col) == color; r--) {
            count++;
        }

        // Check vertically downward
        for (int r = row + 1; r < board.getRowCount() && board.getColor(r, col) == color; r++) {
            count++;
        }

        return count >= board.getWinConditionCount();
    }

    private boolean check4Across(int row, int col) {
        Color color = getCurrentPlayerColor();
        int count = 0;

        // Check horizontally to the right
        for (int c = col; c < board.getColumnCount() && board.getColor(row, c) == color; c++) {
            count++;
        }

        // Check horizontally to the left
        for (int c = col - 1; c >= 0 && board.getColor(row, c) == color; c--) {
            count++;
        }

        return count >= board.getWinConditionCount();
    }


    public Color getCurrentPlayerColor() {
        return (board.getCurrentPlayer() == 1) ? Color.RED : Color.YELLOW;
    }



}

