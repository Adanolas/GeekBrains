import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private int x,y,width,height,difficult;
    private String title;

    MyWindow(String title, int x, int y, int width, int height, int difficult) {
        this.difficult = difficult;
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar myMenu = new JMenuBar();
        createMenu(myMenu);
        setJMenuBar(myMenu);
        setTitle(this.title);
        setBounds(this.x, this.y, this.width, this.height);
        setResizable(false);
        setLayout(new GridLayout(this.difficult,this.difficult));
        setVisible(true);
    }

    private void buttonInit(MyButton buttons[]) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new MyButton(i+1);
            add(buttons[i]);
            buttons[i].addActionListener(new MyActionListener(this, buttons[i], buttons));
        }
    }

    private void createMenu(JMenuBar myMenu) {
        JMenu game = new JMenu("Игра");
        JMenu newGame = new JMenu("Новая игра");
        JMenuItem x3 = new JMenuItem("3x3");
        JMenuItem x4 = new JMenuItem("4x4");
        JMenuItem x5 = new JMenuItem("5x5");
        newGame.add(x3);
        newGame.add(x4);
        newGame.add(x5);
        JMenuItem closeGame = new JMenuItem("Выход");
        game.add(newGame);
        game.add(closeGame);
        myMenu.add(game);

        x3.addActionListener(new MyMenuAction(3,this));
        x4.addActionListener(new MyMenuAction(4,this));
        x5.addActionListener(new MyMenuAction(5,this));

        closeGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public MyButton[] buttonAdd() {
        MyButton buttons[] = new MyButton[difficult*difficult];
        buttonInit(buttons);
        return buttons;
    }

    public MyButton[] buttonSwitch(MyButton buttons[], int button1, int button2) {
        int buffer = buttons[button1].getNumber();
        buttons[button1].setNumber(buttons[button2].getNumber());
        buttons[button2].setNumber(buffer);
        return buttons;
    }

    public int findWay(MyButton buttons[], int point) {
        if (point+difficult < buttons.length && !buttons[point+difficult].isVisible()) return point+difficult;
        if (point-difficult >= 0 && !buttons[point-difficult].isVisible()) return point-difficult;
        if (point-1 >= 0 && !buttons[point-1].isVisible()) return point-1;
        if (point+1 < buttons.length && !buttons[point+1].isVisible()) return point+1;
        return -1;
    }

    public void chekWin(MyButton buttons[]) {
        for (int i = 0; i < buttons.length; i++) {
            if (i != buttons[i].getNumber()-1) return;
        }
        int winChoice = JOptionPane.showConfirmDialog(this,"Сыграть еще?","Вы победили!",JOptionPane.YES_NO_OPTION);
        if (winChoice == 1) System.exit(0);
        else {
            dispose();
            Game newGame = new Game();
            newGame.startGame(difficult);
        }
    }


}
