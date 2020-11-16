import java.util.Random;

public class Cat extends Animal {

    Cat () {
        name = "Кот";
        Random random = new Random();
        maxRunDistance = 150 + random.nextInt(101);
        maxJumpHeight = 1.5 + random.nextDouble();
        maxJumpHeight = Math.round(maxJumpHeight * Math.pow(10,2)) / Math.pow(10,2);
    }

    @Override
    void run (int distance) {
        if (distance > 0 && distance <= maxRunDistance) System.out.println(name + " пробежал " + distance + " метра(ов)");
        else System.out.println("Слишком большое расстояние, " + name + " устал и присел отдохнуть на отметке " + maxRunDistance + " метра(ов)");
    }

    @Override
    void jump (double height) {
        if (height > 0 && height <= maxJumpHeight) System.out.println(name + " подпрыгнул на " + height + " метра(ов)");
        else System.out.println("Больше " + maxJumpHeight + " метра(ов) " + name + " не осилит");
    }

    @Override
    void swim(int distance) {
        System.out.println("Коты не плавают, даже на " + distance + " метра(ов)");
    }
}
