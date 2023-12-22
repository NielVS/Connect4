import javax.swing.*;
import java.awt.*;

class HumanPlayer extends Player {
    private Controller controller;
    private StartPanel panel;

    public HumanPlayer() {
        super();
    }

    @Override
    public void makeMove(int column, JButton[][] buttons, Color color, BoardModel board) {
        int row;
        controller = new Controller(board);
        panel = new StartPanel(board, controller);
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
                        System.exit(0); // or some other way to exit the game
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