import javax.swing.*;

public class MyButton extends JButton {
    private int number;
    private int position;

    MyButton(int number) {
        this.number = number;
        position = number-1;
        setText(""+this.number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        setText(""+this.number);
    }

    public int getPosition() {
        return position;
    }
}
