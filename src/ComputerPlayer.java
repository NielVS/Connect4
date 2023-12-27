import javax.swing.*;
import java.awt.*;

class ComputerPlayer extends Player {
    private Controller controller;
    private StartPanel panel;

    public ComputerPlayer() {
        super();
    }

    /**
     *
     * @param column A randomly generated column index that makes the computer play automated
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
                    if (panel.askPlayAgain()) {
                        board.reset();
                        board.removeDisks(buttons);
                        return;
                    } else {
                        System.exit(0);
                    }
                } else {
                    board.switchPlayer();
                }
                break;
            }
        }
        if (row < 0) { //This makes sure that the Computer wont select a column that is full
            controller.computerMakesMove(buttons);
        } else {

            updateBoard(column, row, buttons, board);
        }

    }

    private void updateBoard(int column, int row, JButton[][] buttons, BoardModel board) {
        buttons[row][column].setBackground(board.getColor(row, column));
    }
}
