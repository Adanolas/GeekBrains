import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLineY(i,j,symb,true) ||
                    checkLineX(i,j,symb, true) ||
                    checkDiag(i,j,symb, true) ||
                    checkReversDiag(i,j,symb, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkLineY(int y, int x, char symb, boolean chekForWin) {
        int winStreak = chekForWin ? DOTS_TO_WIN : DOTS_TO_WIN - 1;
        for (int i = y; i < SIZE; i++) {
            if ((map[i][x] == symb) && (winStreak > 0)){
                winStreak--;
            } else break;
        }
        if (winStreak == 0) return true;
        return false;
    }

    public static boolean checkLineX(int y, int x, char symb, boolean chekForWin) {
        int winStreak = chekForWin ? DOTS_TO_WIN : DOTS_TO_WIN - 1;
        for (int i = x; i < SIZE; i++) {
            if ((map[y][i] == symb) && (winStreak > 0)){
                winStreak--;
            } else break;
        }
        if (winStreak == 0) return true;
        return false;
    }

    public static boolean checkDiag(int y, int x, char symb, boolean chekForWin) {
        int winStreak = chekForWin ? DOTS_TO_WIN : DOTS_TO_WIN - 1;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (y + i >= SIZE || x + i >= SIZE) break;
            if ((map[y + i][x + i] == symb) && (winStreak > 0)) {
                winStreak--;
            } else break;
        }
        if (winStreak == 0) return true;
        return false;
    }

    public static boolean checkReversDiag(int y, int x, char symb, boolean chekForWin) {
        int winStreak = chekForWin ? DOTS_TO_WIN : DOTS_TO_WIN - 1;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (y - i < 0 || x + i >= SIZE) break;
            if ((map[y - i][x + i] == symb) && (winStreak > 0)) {
                winStreak--;
            } else break;
        }
        if (winStreak == 0) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x = rand.nextInt(SIZE);
        int y = rand.nextInt(SIZE);
        final int step = DOTS_TO_WIN - 1;
        boolean isWinPositionFound = false;
        //Блокировка хода игрока
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLineX(i, j, DOT_X, false)) {
                        if (isCellValid(j + step, i)) {
                            x = j + step;
                            y = i;
                            isWinPositionFound = true;
                            } else if (isCellValid(j - 1, i)) {
                            x = j - 1;
                            y = i;
                            isWinPositionFound = true;
                        }
                } else if (checkLineY(i, j, DOT_X, false)) {
                    if (isCellValid(j, i + step)) {
                        x = j;
                        y = i + step;
                        isWinPositionFound = true;
                    } else if (isCellValid(j, i - 1)) {
                        x = j;
                        y = i - 1;
                        isWinPositionFound = true;
                    }
                } else if (checkDiag(i, j, DOT_X, false)) {
                    if (isCellValid(j + DOTS_TO_WIN - 1, i + step)) {
                        x = j + step;
                        y = i + step;
                        isWinPositionFound = true;
                    } else if (isCellValid(j - 1, i - 1)) {
                        x = j - 1;
                        y = i - 1;
                        isWinPositionFound = true;
                    }
                } else if (checkReversDiag(i, j, DOT_X, false)) {
                    if (isCellValid(j + step, i - step)) {
                        x = j + step;
                        y = i - step;
                        isWinPositionFound = true;
                    } else if (isCellValid(j - 1, i + 1)) {
                        x = j - 1;
                        y = i + 1;
                        isWinPositionFound = true;
                    }
                }
                if (isWinPositionFound) break;
            }
            if (isWinPositionFound) break;
        }

        //нечего блокировать - ходим в рандом
        while (!isCellValid(x, y)) {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
