import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {
    private BoardModel board = new BoardModel();
    private final Controller controller = new Controller(board);


    public StartPanel() {
    }

    public void initialiseGrid() {
        askPlayMode();
        JButton[][] buttons = new JButton[board.getRowCount()][board.getColumnCount()];


        for (int row = 0; row < board.getRowCount(); row++) {
            for (int col = 0; col < board.getColumnCount(); col++) {
                buttons[row][col] = new JButton();
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.startPlaying(finalCol, buttons);
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

    public void askPlayMode() {
        String[] options = new String[]{"Connect4", "Connect3", "Connect5"};
        int option = JOptionPane.showOptionDialog(null, "Which game mode would you like to play?", "Game mode", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        if (option == 0) {
            board.setROWS(6);
            board.setCOLUMNS(7);
            board.setWinConditionCount(4);
        } else if (option == 1) {
            board.setROWS(3);
            board.setCOLUMNS(3);
            board.setWinConditionCount(3);

        } else if (option == 2) {
            board.setROWS(10);
            board.setCOLUMNS(10);
            board.setWinConditionCount(5);
        }
        setLayout(new GridLayout(board.getRowCount(), board.getColumnCount()));

    }
    public void resetPanel(){
        removeAll();
        updateUI();
    }
}



