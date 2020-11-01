package ru.geekbrains.lesson_1;

import java.util.Scanner;

public class Lesson_1 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Второе задание
        boolean boo = true;
        byte by = 1;
        short sh = 1;
        int in = 1;
        long lo = 1;
        char ch = 'ы';
        float fl = 0.1234f;
        double dou = 0.12;


        System.out.print("Выполнение третьего задания \n" + "Введите 4 целых числа через enter:\n" + "A = ");
        int a = scanner.nextInt();
        System.out.print("B = ");
        int b = scanner.nextInt();
        System.out.print("C = ");
        int c = scanner.nextInt();
        System.out.print("D = ");
        int d = scanner.nextInt();
        System.out.println("Результат выражения a*(b+(c/d)) = " + math(a,b,c,d));

        System.out.print("Выполнение четвертого задания\n" + "A = ");
        a = scanner.nextInt();
        System.out.print("B = ");
        b = scanner.nextInt();
        System.out.println("Сумма лежит в пределах от 10 до 20 - " + test(a,b));

        System.out.print("Выполнение пятого задания\n" + "A = ");
        a = scanner.nextInt();
        chekOut(a);

        System.out.print("Выполнение шестого задания\n" + "A = ");
        a = scanner.nextInt();
        System.out.println("Чистло отрицательное - " + chekNeg(a));

        System.out.println("Выполнение седьмого задания");
        System.out.print("Введите Ваше имя : ");
        String str = scanner.next();
        hello(str);

        System.out.print("Выполнение восьмого задания\n" + "Введите год для проверки: ");
        a = scanner.nextInt();
        leapYear(a);
    }

    static float math (int a, int b, int c, int d) {
        return a * (b + ( (float) c / d));
    }

    static boolean test (int a, int b){
        if ((a + b >= 10) & (a + b <= 20 )) return true;
          else return false;
    }

    static void chekOut (int a) {
        if (a >= 0) System.out.println("Число положительное");
          else
            System.out.println("Число отрицательное");
    }

    static boolean chekNeg (int a) {
        if (a < 0) return true;
        else return false;
    }

    static void hello (String str) {
        System.out.println("Привет, " + str + "!");
    }

    static void leapYear (int a) {
        if (( a % 4 == 0 ) && (( a % 100 != 0) || ( a % 400 == 0 )))
            System.out.println("Год високосный");
        else
            System.out.println("Год не високосный");
    }
}
