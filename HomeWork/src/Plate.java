public class Plate {
    private int food;

    Plate (int food) {
        this.food = food;
    }

    public boolean isFoodEnough (int food) {
        if (this.food - food < 0) return false;
        this.food -= food;
        return true;
    }

    public void addFood (int food) {
        if (food <= 0) System.out.println("Не удалось наполнить тарелку");
        else {
            this.food += food;
            System.out.println("Тарелку наполнили на " + food);
        }
    }

    public void getStatus () {
        System.out.println("В тарелке " + food + " единиц(ы) еды");
    }
}
