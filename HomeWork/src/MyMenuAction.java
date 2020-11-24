import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuAction implements ActionListener {
    private int difficult;
    private JFrame frame;

    MyMenuAction(int difficult, JFrame frame) {
        this.difficult = difficult;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        Game newGame = new Game();
        newGame.startGame(difficult);
    }
}
