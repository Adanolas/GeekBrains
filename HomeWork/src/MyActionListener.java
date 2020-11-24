import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private MyWindow frame;
    private MyButton button;
    private MyButton buttons[];

    MyActionListener(MyWindow frame, MyButton button, MyButton buttons[]) {
        this.frame = frame;
        this.button = button;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Нажата кнопка " + button.getNumber() + " на позиции " + button.getPosition());
        int position = frame.findWay(buttons,button.getPosition());
        if (position>=0) {
            frame.buttonSwitch(buttons, position, button.getPosition());
            buttons[position].setVisible(true);
            buttons[button.getPosition()].setVisible(false);
            frame.chekWin(buttons);
        }
    }
}
