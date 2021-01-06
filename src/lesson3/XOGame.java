package lesson3;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class XOGame {

    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);

    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;
    public static int winSymbols = 4; //количество символов для победы. Можжно менять в рамках размера игрового поля.

    public static void initMap() {
        mapSizeX = 5;   // размер поля можно менять при условии,что x и y будут равны
        mapSizeY = 5;
        map = new char[mapSizeY][mapSizeX];

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите свои координаты: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;
    }

    public static void aiTurn() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;

        // Проверка на выигрышный ход
            for (int i = 0; i < mapSizeX; i++) {
                for (int j = 0; j < mapSizeY; j++) {
                    if (!isCellBusy(i, j)) {
                        map[i][j] = PC_DOT;
                        if (checkWin(PC_DOT)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        map[i][j] = EMPTY_DOT;
                    }
                }
            }

        // Блокировка хода пользователя, если он побеждает на следующем ходу
            if (!ai_win) {
                for (int i = 0; i < mapSizeX; i++) {
                    for (int j = 0; j < mapSizeY; j++) {
                        if (!isCellBusy(i, j)) {
                            map[i][j] = HUMAN_DOT;
                            if (checkWin(HUMAN_DOT)) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            map[i][j] = EMPTY_DOT;
                        }
                    }
                }
            }

        // В случае если первые два условия отрицательны, мы вызываем метод наиболее оптимального хода,
        // а в случае если компьютер еще не ходил запускаем рандом.
        if (!ai_win && !user_win) {
            if(x == -1 && y == -1 ) {
                do {
                    Random rnd = new Random();
                    x = rnd.nextInt(mapSizeX);
                    y = rnd.nextInt(mapSizeY);
                }
                while (isCellBusy(x, y));
            } else {for (int i = 0; i < mapSizeX; i++) {
                for (int j = 0; j < mapSizeY; j++) {
                    if (!isCellBusy(i, j)) {
                        map[i][j] = PC_DOT;
                        if (checkWinAi(PC_DOT)) {
                            x = i;
                            y = j;
                        }
                        map[i][j] = EMPTY_DOT;
                    }
                }
            }

            }
        }
        map[x][y] = PC_DOT;
    }



    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > mapSizeX - 1 || y > mapSizeY - 1) {
            return false;
        }
        return map[x][y] != EMPTY_DOT;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean checkDiagonal(char symb, int offsetX, int offsetY, int winSymbols) {
        boolean toright, toleft; //метод проверки диагоналей со смещением
        toright = true;
        toleft = true;
        for (int i=0; i<winSymbols; i++) {
            toright &= (map[i+offsetX][i+offsetY] == symb);
            toleft &= (map[winSymbols-i-1+offsetX][i+offsetY] == symb);
        }
        return toright || toleft;
    }

    public static boolean checkLanes(char symb, int offsetX, int offsetY, int winSymbols) {
        boolean cols, rows; //метод проверки вертикалей со смещением
        for (int col=offsetX; col<winSymbols+offsetX; col++) {
            cols = true;
            rows = true;
            for (int row=offsetY; row<winSymbols+offsetY; row++) {
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }

            if (cols || rows) return true;
        }

        return false;
    }

    public static boolean checkWin(char symb) {
        for (int col=0; col<(mapSizeX-winSymbols+1); col++) {
            for (int row=0; row<(mapSizeY-winSymbols+1); row++) {
                // Вызываем методы проверки и если хоть один блок заполнен,
                // то игрок, который проставляет это символ, выиграл
                // иначе продолжаем для другого смещения
                if (checkDiagonal(symb, col, row, winSymbols) || checkLanes(symb, col, row, winSymbols)) return true;
            }
        }
        // Все подквадраты в квадрате проверены. 4-х последовательностей
        // подряд не выявлено. Значит еще не победа.
        return false;
    }

    public static boolean checkWinAi(char symb) {
        for (int col=0; col<3; col++) {
            for (int row=0; row<3; row++) {
                // компьютер собирает
                if (checkDiagonal(symb, col, row, 3) || checkLanes(symb, col, row, 3)) return true;
            }
        }
        for (int col=0; col<4; col++) {
            for (int row=0; row<4; row++) {
                // Вызываем методы проверки на последовательности из 2 символов и если хоть один блок заполнен,
                // то у игрока, который проставляет этот символ приемущество
                // иначе продолжаем для другого смещения
                if (checkDiagonal(symb, col, row, 2) || checkLanes(symb, col, row, 2)) return true;
            }
        }
        for (int col=0; col<5; col++) {
            for (int row=0; row<5; row++) {
                // Вызываем методы проверки на последовательности из 1 символа и если хоть один блок заполнен,
                // то у игрока, который проставляет этот символ приемущество
                // компьютер всегда мешает игроку
                if (checkDiagonal(symb, col, row, 1) || checkLanes(symb, col, row, 1)) return true;
            }
        }
        return false;
    }


    public static boolean isMapFull() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            System.out.println("Ход человека:\n ");
            printMap();

            if (checkWin(HUMAN_DOT)) {
                System.out.println("Human win!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            System.out.println("Ход компьютера:\n");
            TimeUnit.SECONDS.sleep(1);
            aiTurn();
            printMap();
            if (checkWin(PC_DOT)) {
                System.out.println("AI win!!! ^(((((");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
    }


}

