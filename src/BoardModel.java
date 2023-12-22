import javax.swing.*;
import java.awt.*;

public class BoardModel {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    public static final Color EMPTY_COLOR = Color.WHITE;

    private Color[][] grid;
    private int currentPlayer = 1;

    public BoardModel() {
        grid = new Color[ROWS][COLUMNS];
        reset();
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void reset() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                grid[row][col] = EMPTY_COLOR;
            }
        }
        currentPlayer = 1;
    }
    public void removeDisks(JButton[][] buttons){
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                buttons[row][col].setBackground(EMPTY_COLOR);
            }
        }
    }

    public int getRowCount() {
        return ROWS;
    }

    public int getColumnCount() {
        return COLUMNS;
    }

    public Color getColor(int row, int col) {
        return grid[row][col];
    }

    public void setColor(int row, int col, Color color) {
        grid[row][col] = color;
    }

    public boolean isFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (grid[0][col] == EMPTY_COLOR) {
                return false;
            }
        }
        return true;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        int count = 3;
        setCurrentPlayer(count-currentPlayer);
    }
}
