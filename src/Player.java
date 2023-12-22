import javax.swing.*;
import java.awt.*;

public abstract class Player {



    public abstract void makeMove(int column, JButton[][] buttons, Color color, BoardModel board);
}
