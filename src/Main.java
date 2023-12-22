import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BoardModel boardModel = new BoardModel();
        Controller controller = new Controller(boardModel);
            JFrame frame = new JFrame("Connect4 Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new StartPanel(boardModel,controller));
            frame.setSize(800,400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }
}
