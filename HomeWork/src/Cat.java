public class Cat {
    private String name;
    private int appetite;
    boolean isFull;

    Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate plate) {
        if (isFull) System.out.println(name + " отказался от еды");
        else if (plate.isFoodEnough(appetite)) {
            System.out.println(name + " поел");
            isFull = true;
        } else {
            System.out.println(name + " не хватило еды");
        }
    }

    public void getStatus() {
        if (isFull) System.out.println(name + " сыт");
        else System.out.println(name + " голоден");
    }

}
