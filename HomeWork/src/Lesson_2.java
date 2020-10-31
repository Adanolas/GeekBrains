import java.util.Arrays;

public class Lesson_2 {

    public static int point;

    public static void main (String[] args) {
        //Первое задание
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Изначальный массив - " + Arrays.toString(a));
        System.out.println("Измененный массив - " + Arrays.toString(invertArr(a)));

        //Второе задание
        a = new int[8];
        System.out.println("Массив по второму заданию - " + Arrays.toString(fillUpArr(a)));

        //Третье задание
        a = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив по третьему заданию - " + Arrays.toString(changeArr(a)));

        //Четвертое задание
        int[][] b = new int[5][5];
        b = fillDiagonal(b);
        System.out.println("Массив по четвертому заданию:");
        for (int i = 0; i < b.length; i++) System.out.println(Arrays.toString(b[i]));

        //Пятое задание
        a = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nПроверка массива " + Arrays.toString(a) + "\nМинимальный элемент массива - " + getMin(a) + "\nМаксимальный элемент массива - " + getMax(a));

        //Шестое задание
        a = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        if (chekBalance(a)) System.out.println("Найдено место, где сумма левой и правой части массива равны.\nГраница находится между " + point + " и " + (point + 1) + " элементами массива.");
            else System.out.println("Нет места в массиве, где сумма левой и правой часть была бы равны.");

        //Седьмое задание
        a = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("\nМассив " + Arrays.toString(a) + " сдвинут - " + Arrays.toString(rollArr(a,-11)));
    }

    public static int[] invertArr(int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == 0) a[i] = 1; else a[i] = 0;
        return a;
    }

    public static int[] fillUpArr(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = i*3;
        return a;
    }

    public static int[] changeArr(int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] < 6) a[i] *= 2;
        return a;
    }

    public static int[][] fillDiagonal(int[][] a) {
        int stop = a.length;
        for (int i = 0; i < stop; i++)
            for (int j = 0; j < stop; j++)
                if ((i == j) || (i + j == stop - 1)) a[i][j] = 1;
        return a;
    }

    public static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    public static int getMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] < min) min = a[i];
        return min;
    }

    public static boolean chekBalance(int[] a) {
        int sum = 0;
        int sum2 = 0;
        System.out.println("\nПроверка массива " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum2 += a[j];
            }
            if ((sum == sum2) && (sum != 0)) {
                point = i;
                break;
            }
            sum2 = 0;
        }
        return sum == sum2;
    }

    public static int[] rollArr(int[] a, int n) {
        int buffer = 0;
        if (Math.abs(n) > a.length) {
            n = n % a.length;
        } else if ((n == a.length) || (n == 0)) {
            return a;
        }
        for (int i = 0; i < Math.abs(n); i++)
            if (n < 0) {
                buffer = a[0];
                for (int j = 0; j < a.length - 1; j++) a[j] = a[j + 1];
                a[a.length-1] = buffer;
            } else {
                buffer = a[a.length-1];
                for (int j = a.length - 1; j > 0; j--) a[j] = a[j - 1];
                a[0] = buffer;
            }
        return a;
    }

}
