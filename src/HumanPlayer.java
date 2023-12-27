import javax.swing.*;
import java.awt.*;

class HumanPlayer extends Player {
    private Controller controller;
    private StartPanel panel;

    public HumanPlayer() {
        super();
    }

    /**
     *
     * @param column The column that was selected via the click on ta specific button
     * @param buttons the Connect# grid made out of buttons.
     * @param color The collor the buttons will get, decided by the current player
     * @param board The board model providing information about the board
     */
    @Override
    public void makeMove(int column, JButton[][] buttons, Color color, BoardModel board) {
        int row;
        controller = new Controller(board);
        panel = new StartPanel();
        for (row = board.getRowCount() - 1; row >= 0; row--) {
            if (board.getColor(row, column) == BoardModel.EMPTY_COLOR) {
                board.setColor(row, column, color);
                if (controller.checkForWinner(row, column)) {
                    updateBoard(column, row, buttons, board);
                    panel.showWinnerMessage();
                    if (panel.askPlayAgain()) {
                        board.reset();
                        board.removeDisks(buttons);
                        return;
                    } else {
                        System.exit(0);
                    }
                } else if (board.isFull()) {
                    updateBoard(column, row, buttons, board);
                    panel.showDrawMessage();
                } else {
                    board.switchPlayer();
                    controller.computerMakesMove(buttons);
                }
                break;
            }
        }
        updateBoard(column, row, buttons, board);

    }

    private void updateBoard(int column, int row, JButton[][] buttons, BoardModel board) {
        buttons[row][column].setBackground(board.getColor(row, column));
    }
}