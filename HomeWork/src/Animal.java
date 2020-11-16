abstract class Animal {
    String name;
    int maxRunDistance;
    double maxJumpHeight;

    void run(int distance) {
        System.out.println("Животное пробежало " + distance + " метра(ов)");
    }

    void jump(double height) {
        System.out.println("Животное подпрыгнуло на " + height + " метра(ов)");
    }

    abstract void swim(int distance);
}
