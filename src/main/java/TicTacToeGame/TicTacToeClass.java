import java.util.Random;

import static TicTacToe.Main.in;

public class TicTacToeClass {
    int dimension;
    private char[][] tictacMap;
    char dot_humain;
    char dot_empty;
    char dot_ai;
    String free_space;
    char logo;
    private int needFilledCellsCountToWin;
    private static int lastTurnRow;
    private static int getLastTurnColumn;
    private static int totalTurns;

    public void run() {
        this.showWelcomeMessage();
        this.showMap();

        do {
            this.turnHumain();
            this.showMap();
            if (this.isTheGameIsOver(this.dot_humain)) {
                return;
            }


            this.turnAI();
            this.showMap();
            if (this.isTheGameIsOver(this.dot_ai)) {
                return;
            }

        } while (true);


    }

    private boolean isTheGameIsOver(char dot_entry) {
        String rowToCheck = "";
        String columnToCheck = "";
        String diagonalMainToCheck = "";
        String diagonalBackToCheck = "";



        rowToCheck = getLastTurnRowToCheck();
        columnToCheck = getLastTurnColumnToCheck();
        diagonalMainToCheck = getLastTurnDiagonalMainToCheck();
        diagonalBackToCheck = getLastTurnDiagonalBackToCheck();

        if (isWeHaveWinnerFromString(rowToCheck, dot_entry) || isWeHaveWinnerFromString(columnToCheck, dot_entry) ||
                isWeHaveWinnerFromString(diagonalMainToCheck, dot_entry) || isWeHaveWinnerFromString(diagonalBackToCheck, dot_entry)) {
            System.out.println("Победу одержал игрок, который ходил " + dot_entry + " ");
            return true;

        }
        if (isTheMapIsFull()) {
            System.out.println("Ничья! Ходить больше некуда!");
            return true;
        }

        return false;
    }

    private boolean isWeHaveWinnerFromString(String columnToCheck, char dot_entry) {
        int counter=0;
        if (columnToCheck.length() < this.needFilledCellsCountToWin) {
            return false;
        }

        for (int i = 0; i < columnToCheck.length(); i++) {
            if (columnToCheck.charAt(i)==dot_entry) {
                counter++;
                if (counter==this.needFilledCellsCountToWin) {
                    return true;
                }
            } else {
                counter = 0;
            }

        }

        return false;
    }

    private String getLastTurnDiagonalBackToCheck() {
        String resultString = "";
        resultString = String.valueOf(this.tictacMap[lastTurnRow][getLastTurnColumn]);

        for (int i = 1; i < this.dimension; i++) {
            if (isCoordinateValid(lastTurnRow + 1 + i) && isCoordinateValid(getLastTurnColumn + 1 - i)) {
                resultString = resultString + String.valueOf(this.tictacMap[lastTurnRow + i][getLastTurnColumn - i]);
            }
            if (isCoordinateValid(lastTurnRow + 1 - i) && isCoordinateValid(getLastTurnColumn + 1 + i)) {
                resultString = String.valueOf(this.tictacMap[lastTurnRow - i][getLastTurnColumn + i]) + resultString;
            }

        }
        return resultString;
    }

    private String getLastTurnDiagonalMainToCheck() {
        String resultString = "";
        resultString = String.valueOf(this.tictacMap[lastTurnRow][getLastTurnColumn]);

        for (int i = 1; i < this.dimension; i++) {
            if (isCoordinateValid(lastTurnRow + 1 + i) && isCoordinateValid(getLastTurnColumn + 1 + i)) {
                resultString = resultString + String.valueOf(this.tictacMap[lastTurnRow + i][getLastTurnColumn + i]);
            }
            if (isCoordinateValid(lastTurnRow + 1 - i) && isCoordinateValid(getLastTurnColumn + 1 - i)) {
                resultString = String.valueOf(this.tictacMap[lastTurnRow - i][getLastTurnColumn - i]) + resultString;
            }

        }
        return resultString;
    }

    private String getLastTurnColumnToCheck() {
        String s = "";
        for (int i = 0; i < this.dimension; i++) {
            s += this.tictacMap[i][getLastTurnColumn];

        }
        return s;
    }

    private String getLastTurnRowToCheck() {
        return String.valueOf(this.tictacMap[lastTurnRow]);
    }

    private boolean isTheMapIsFull() {
        return totalTurns == this.dimension * this.dimension;
    }

    private void turnAI() {
        int turnRow, turnColumn;

        Random rnd = new Random();

        do {
            turnRow = rnd.nextInt(this.dimension);
            turnColumn = rnd.nextInt(this.dimension);
        } while (!isMapCellFree(turnRow, turnColumn));



        System.out.println("Игрок 2 завершил ход Ряд=" + (turnRow + 1) + ", Столбец=" + (turnColumn + 1));

        fixTheTurn(turnRow, turnColumn, this.dot_ai);
    }

    private void turnHumain() {
        int turnRow, turnColumn;

        do {
            System.out.println("Ход игрока №1");
            System.out.println("Введите номер рядя от 1 до " + this.dimension + ": ");
            turnRow = getNextStepCoordinate() - 1;
            System.out.println("Введите номер столбца от 1 до " + this.dimension + ": ");
            turnColumn = getNextStepCoordinate() - 1;
            if (!isMapCellFree(turnRow, turnColumn)) {
                System.out.println("Некорректный воод, повторите попытку!!");
            }
        } while (!isMapCellFree(turnRow, turnColumn));
        fixTheTurn(turnRow, turnColumn, this.dot_humain);

    }

    private void fixTheTurn(int turnRow, int TurnColumn, char dotTurn) {
        lastTurnRow = turnRow;
        getLastTurnColumn = TurnColumn;
        totalTurns++;
        this.tictacMap[turnRow][TurnColumn] = dotTurn;

    }

    private boolean isMapCellFree(int turnRow, int turnCell) {
        return this.tictacMap[turnRow][turnCell] == this.dot_empty;
    }

    private void showWelcomeMessage() {
        System.out.printf("Игра крестики нолики на поле размером %dx%d c победой в %d клеток начинается!%n", this.dimension, this.dimension, this.needFilledCellsCountToWin);
    }

    private void initMap() {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                this.tictacMap[i][j] = this.dot_empty;

            }

        }
    }

    public TicTacToeClass(int SIZE,int CELLS_TOWIN, char DOT_HUMAIN, char DOT_AI, char DOT_EMPTY, String FREE_SPACE, char LOGO) {
        this.tictacMap = new char[SIZE][SIZE];
        this.dot_humain = DOT_HUMAIN;
        this.dot_ai = DOT_AI;
        this.free_space = FREE_SPACE;
        this.logo = LOGO;
        this.dimension = SIZE;
        this.dot_empty = DOT_EMPTY;
        this.initMap();
        this.needFilledCellsCountToWin = CELLS_TOWIN;

        lastTurnRow = 1;
        getLastTurnColumn = 1;

    }

    public void showMap() {
        showFirstRow();

        showOnlyMap();

    }

    private void showOnlyMap() {
        for (int i = 0; i < this.dimension; i++) {
            System.out.print(i + 1 + this.free_space);
            for (int j = 0; j < this.dimension; j++) {
                System.out.print(this.tictacMap[i][j] + this.free_space);

            }
            System.out.println();

        }
    }

    private void showFirstRow() {
        System.out.print(this.logo);
        System.out.print(this.free_space);
        for (int i = 0; i < this.dimension; i++) {
            System.out.print(i + 1 + free_space);
        }
        System.out.println();
    }

    private boolean isCoordinateValid(int tocheck) {
        return tocheck > 0 && tocheck <= this.dimension;
    }

    private int getNextStepCoordinate() {
        int result = 0;

        while (true) {
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (isCoordinateValid(result)) {
                    return result;
                }
                System.out.println("Не корректный ввод, введите число от 1 до " + this.dimension);
            } else {
                System.out.println("Не корректный ввод, введите число от 1 до " + this.dimension);
                System.out.print("Повторите ввод: ");
                in.next();

            }

        }
    }
}