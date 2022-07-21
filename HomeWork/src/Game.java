import java.util.Random;

public class Game {
    public void startGame(int difficult) {
        MyWindow mainWindow = new MyWindow("Game " + difficult + "x" + difficult,300,300,600,600,difficult);
        MyButton buttons[] = mainWindow.buttonAdd();
        buttons[buttons.length-1].setVisible(false);

        Random random = new Random();

        for (int i = 0; i < difficult; i++) {
            mainWindow.buttonSwitch(buttons, random.nextInt(buttons.length-1), random.nextInt(buttons.length-1));
            mainWindow.buttonSwitch(buttons, random.nextInt(buttons.length-1), random.nextInt(buttons.length-1));
            mainWindow.buttonSwitch(buttons, random.nextInt(buttons.length-1), random.nextInt(buttons.length-1));
        }
    }
}
