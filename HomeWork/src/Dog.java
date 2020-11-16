import java.util.Random;

public class Dog extends Animal {
    int maxSwimDistance;

    Dog () {
        name = "Собака";
        Random random = new Random();
        maxRunDistance = 400 + random.nextInt(201);
        maxSwimDistance = 5 + random.nextInt(5);
        maxJumpHeight = 0.2 + random.nextDouble() / 2;
        maxJumpHeight = Math.round(maxJumpHeight * Math.pow(10,2)) / Math.pow(10,2);
    }

    @Override
    void run (int distance) {
        if (distance > 0 && distance <= maxRunDistance) System.out.println(name + " пробежала " + distance + " метра(ов)");
        else System.out.println("Слишком большое расстояние, " + name + " устала и присела отдохнуть на отметке " + maxRunDistance + " метра(ов)");
    }

    @Override
    void jump (double height) {
        if (height > 0 && height <= maxJumpHeight) System.out.println(name + " подпрыгнула на " + height + " метра(ов)");
        else System.out.println("Больше " + maxJumpHeight + " метра(ов) " + name + " не осилит");
    }

    @Override
    void swim(int distance) {
        if (distance > 0 && distance <= maxSwimDistance) System.out.println(name + " проплыла " + distance + " метра(ов)");
        else System.out.println("Слишком большое расстояние, " + name + " устала и вышла на берег отдохнуть на отметке " + maxSwimDistance + " метра(ов)");
    }
}
