import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        StartPanel panel = new StartPanel();
        JFrame frame = new JFrame("Connect4 Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.initialiseGrid();
        frame.getContentPane().add(panel);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
