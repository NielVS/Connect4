import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {
    private final BoardModel board;
    private final Controller controller;

    public StartPanel(BoardModel board, Controller controller) {
        this.board = board;
        this.controller = controller;
        initialiseGrid();
    }

    private void initialiseGrid(){

        setLayout(new GridLayout(board.getRowCount(), board.getColumnCount()));

        JButton[][] buttons = new JButton[board.getRowCount()][board.getColumnCount()];

        for (int row = 0; row < board.getRowCount(); row++) {
            for (int col = 0; col < board.getColumnCount(); col++) {
                buttons[row][col] = new JButton();
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.startPlaying(finalCol,buttons);
                    }
                });
                add(buttons[row][col]);
            }
        }
    }

    public void showWinnerMessage() {
        int winner = board.getCurrentPlayer();
        JOptionPane.showMessageDialog(null, "Player " + winner + " won!");
    }

    public void showDrawMessage() {
        JOptionPane.showMessageDialog(null, "It's a draw!");
    }

    public boolean askPlayAgain() {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }
}



