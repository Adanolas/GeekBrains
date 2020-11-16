import java.util.Scanner;

public class Lesson_6 {

    static String catClass;

    public static void main(String[] Args) {
        int maxLength = 10;
        Cat cat[] = new Cat[maxLength];
        Dog dog[] = new Dog[maxLength];
        catClass = cat.toString();

        setTeam(maxLength,cat);
        setTeam(maxLength,dog);

        Animal pet[] = new Animal[maxLength * 2];

        setChallengers(pet,cat,dog);

        gameChoice(pet);

        System.out.println("Игры завершены");
    }

    static void setTeam(int quantity, Animal animal[]) {
        String typeOfAnimal = animal.toString();
        for (int i = 0; i < quantity; i++) {
            if (typeOfAnimal.equals(catClass))
                animal[i] = new Cat();
            else animal[i] = new Dog();
            animal[i].name += " " + (i + 1);
        }
    }

    static void setChallengers(Animal pet[], Cat cat[], Dog dog[]) {
        for (int i = 0; i < pet.length; i++) {
            if (i % 2 == 0) pet[i] = cat[i / 2];
            else pet[i] = dog[i / 2];
        }
    }

    static void gameChoice(Animal pet []) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Команды сформированы и готовы к играм, выберите соревнование:");
        System.out.println("1 - бег");
        System.out.println("2 - плавание");
        System.out.println("3 - прыжки в высоту");
        System.out.println("4 - выход");
        System.out.print("Ваш выбор: ");
        if (scanner.hasNextInt()) choice = scanner.nextInt();
        else choice = 0;
        switch (choice) {
            case 1 : runGame(pet); break;
            case 2 : swimGame(pet); break;
            case 3 : jumpGame(pet); break;
            case 4 : return;
            default: gameChoice(pet); break;
        }
    }

    static void runGame(Animal pet[]) {
        int distance;
        System.out.println("Выбрана игра бег.");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите расстояние для забега, для возврата в меню напишите что-нибудь: ");
            if (scanner.hasNextInt()) {
                distance = scanner.nextInt();
                for (int i = 0; i < pet.length; i++) {
                    pet[i].run(distance);
                }
            } else {
                gameChoice(pet);
                break;
            }
        } while (true);
    }

    static void swimGame(Animal pet[]) {
        int distance;
        System.out.println("Выбрана игра плавание.");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите расстояние заплыва, для возврата в меню напишите что-нибудь: ");
            if (scanner.hasNextInt()) {
                distance = scanner.nextInt();
                for (int i = 0; i < pet.length; i++) {
                    pet[i].swim(distance);
                }
            } else {
                gameChoice(pet);
                break;
            }
        } while (true);
    }

    static void jumpGame(Animal pet[]) {
        double height;
        System.out.println("Выбрана игра прыжки в высоту.");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите высоту планки, для возврата в меню напишите что-нибудь: ");
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                for (int i = 0; i < pet.length; i++) {
                    pet[i].jump(height);
                }
            } else {
                gameChoice(pet);
                break;
            }
        } while (true);
    }
}
