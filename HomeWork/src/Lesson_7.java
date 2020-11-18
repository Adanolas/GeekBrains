import java.util.Random;

public class Lesson_7 {

    public static void main(String[] Args) {
        final int num = 8;
        Random random = new Random();
        Cat cats[] = new Cat[num];
        boolean isAnybodyStarve = false;

        for (int i = 0; i < num; i++) {
            cats[i] = new Cat(getName(6), random.nextInt(5) + 1);
        }

        Plate plate = new Plate(0);

        do {
            isAnybodyStarve = false;
            plate.addFood(10);
            plate.getStatus();

            for (int i = 0; i < num; i++) {
                cats[i].eat(plate);
                if (!cats[i].isFull) isAnybodyStarve = true;
            }
            System.out.println();
            System.out.println("Коты поели:");

            for (int i = 0; i < num; i++) cats[i].getStatus();
            System.out.println();
        } while (isAnybodyStarve);

    }

    static String getName (int length) {
        Random random = new Random();
        char symb[] = new  char[length];
        symb[0] = (char) (random.nextInt(26) + 65);
        for (int i = 1; i < length; i++) {
            symb[i] = (char) (random.nextInt(26) + 97);
        }
        return new String(symb);
    }
}
