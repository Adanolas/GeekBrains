import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Lesson_3 {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int maxLength = chekMaxLength(words);
        int[] position = new int[maxLength];

        System.out.println("Игра началась, угадай слово - " + Arrays.toString(words));
        System.out.println("Для выхода из игры введите exit");
        Random random = new Random();
        int programChoice = random.nextInt(words.length);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш ответ - ");
        String answer = toLowerCase(scanner.next());

        int matches = checkMatches(answer,words[programChoice], position);
        int answerLength = answer.length();
        int programChoiceLength = words[programChoice].length();

        while (!isExit(answer)) {
            if (answerLength == matches && programChoiceLength == matches) {
                System.out.println("Поздравляю! Загаданное слово " + words[programChoice] + " совпадает с вашим ответом - " + answer);
                break;
            } else {
                System.out.println("Не правильно, попробуйте еще - " + programHint(words[programChoice], maxLength, position));
                position = new int[maxLength];
                System.out.print("Ваш ответ - ");
                answer = toLowerCase(scanner.next());
                matches = checkMatches(answer,words[programChoice], position);
                answerLength = answer.length();
            }
        }
    }

    public static int checkMatches(String playerWord, String currentWord, int[] position) {
        int count = 0;
        for (int i = 0; i < playerWord.length() && i < currentWord.length(); i++) {
            if (playerWord.charAt(i) == currentWord.charAt(i)) {
                count++;
                position[i] = 1;
            } else {
                position[i] = 0;
            }
        }
        return count;
    }

    public static String programHint(String correctWord, int maxLength, int[] position) {
        String hint = "";
        for (int i = 0; i < maxLength; i++) {
                if (position[i] == 1) {
                    hint += correctWord.charAt((i));
                } else {
                    hint += "#";
                }
            }
        return hint;
    }

    public static int chekMaxLength(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > max) max = words[i].length();
        }
        return max;
    }

    public static boolean isExit(String playerWord) {
        String stop = "exit";
        if (playerWord.length() < 4) return false;

        for (int i = 0; i < 4; i++) {
            if (playerWord.charAt(i) != stop.charAt(i)) {
                return false;
            } else {
                if (playerWord.length() > 4) return false;
            }
        }
        System.out.println("Решили сдаться, ну чтож...");
        return true;
    }
}
