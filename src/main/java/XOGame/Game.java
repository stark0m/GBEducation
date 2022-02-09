package XOGame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    private static Pole pole = new Pole();
    private static int xX;
    private static int yY;

    /**/
    public static void main(String[] args) {


        while (pole.checkTheWin() == 3 && pole.hasFreePoint()) {                        /*Основной цыкл игры, выходим если есть победитель или все клетки заняты*/

            do {
                pole.showMe();                                                          // выводим поле на экран
                shootPlayer1();                                                         //Передаем ход игроку №1
            } while (!pole.humanGo(xX - 1, yY - 1) && pole.checkTheWin() == 3);    // Выходим из цыкла если ход удался или найден победитель
            pole.showMe();                                                               // выводим поле на экран
            pole.androidGo();                                                            // передаем ход боту (генератор случайных чисел)
        }                                                                               // конец игры
        pole.showResult();                                                              // выводим результат
    }

    /**/
    private static void shootPlayer1() {                      // ход игкрока №1
        System.out.println("Ход игрока №1");
        System.out.println("Введите координату Х: ");
        xX = getNextStepCoordinate();
        System.out.println("Введите координату Y: ");
        yY = getNextStepCoordinate();
    }

    private static int getNextStepCoordinate() {
        int result = 0;

        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result > 0 && result <= pole.SIZEXO) {
                    return result;
                }
                System.out.println("Не корректный ввод, введите число от 1 до " + pole.SIZEXO);
            } else {
                System.out.println("Не корректный ввод, введите число от 1 до " + pole.SIZEXO);
                System.out.print("Повторите ввод: ");

            }

        }
    }
}

/*Начинаем описывать класс ПОЛЕ*/
class Pole {

    public static final int SIZEXO = 3;                //Размер игрового поля
    private static final char DOT_X = 'X';              //
    private static final char DOT_Y = '0';              //
    private int status;                                 // Статус игрового поля 0- ничья, 1- Победа Х, 2- Победа О, 3- Игра в разгаре
    public char[][] xyPole = new char[SIZEXO][SIZEXO];

    public Pole() {                                      // Инициируем поле для игры
        for (int i = 0; i < SIZEXO; i++) {
            for (int j = 0; j < SIZEXO; j++) {
                this.xyPole[i][j] = '*';

            }
        }
        this.status = 3;                                 //игра началась 0-ничья, 1-победа Х, 2- победа О
    }

    /**/
    public void showResult() {
        switch (this.status) {
            case 1:
                System.out.println("Победил игрок №1");
                break;
            case 2:
                System.out.println("Победил игрок №2");
                break;
            case 0:
                System.out.println("Игра закончилась в ничью");
                break;
        }
    }


    /**/
    public boolean humanGo(int x, int y) {              // записываем ход игрока и возвращаем Правда если ход удался, ЛОЖ - в проивном случае
        this.status = this.checkTheWin();
        if (this.status != 3) {                          // Если есть победитель ходить более нельзя
            System.out.println("Есть победитель");
            return false;

        }
        if (!this.hasFreePoint()) {                      // Если нет свободных клеточек - выходим
            System.out.println("Некуда ходить");
            return false;
        }
        if (this.xyPole[x][y] != '*') {                 // Если клетка занята - выходим
            System.out.println("Клетка занята , там уже " + this.xyPole[x][y]);
            return false;
        }

        this.xyPole[x][y] = DOT_X;                      // Игра продолжается, записываем ход игрока
        System.out.println("Ход Игрока №1 завершен X=" + (x + 1) + ", Y=" + (y + 1));
        return true;

    }

    /**/
    public boolean hasFreePoint() {                    //Вычисляем есть ли еще свободные поля для хода
        for (int i = 0; i < SIZEXO; i++) {
            for (int j = 0; j < SIZEXO; j++) {
                if (this.xyPole[i][j] == '*') {
                    return true;
                }

            }

        }
        if (this.status == 3) {                          // Проверяем если еще игра продолжается и нет победителя, но поля закончились - заканчиваем игру
            this.status = 0;
        }
        return false;
    }

    /**//**/
    public boolean androidGo(int x, int y) {            //Ручной ход второго игрока
        this.status = this.checkTheWin();               // проверяем на выйгрыш
        if (this.hasFreePoint() && this.status == 3) {  // если есть куда ходить и никто еще не выйрал


            if (this.xyPole[x][y] == '*') {             // поле свободно для хода , О ходит и возвращает ПРАВДА
                this.xyPole[x][y] = DOT_Y;
                return true;
            } else { // поле занято для хода, возвращаем ЛОЖЬ
                System.out.println("В эту клетку походить нельзя");
                return false;

            }
        } else {                                        //либо есть выйгрыш , либо все поля заполнены - Возвращаем ЛОЖЬ
            this.status = 0;
            return false;
        }
    }

    /**/
    public void androidGo()                           //генерируем ход игрока №2
    {
        this.status = this.checkTheWin();
        if (this.status != 3) {                          // Если есть победитель ходить более нельзя
            System.out.println("Есть победитель");
            return;

        }
        if (!this.hasFreePoint()) {                      // Если нет свободных клеточек - выходим
            System.out.println("Некуда ходить");
            return;
        }

        int x;
        int y;
        Random rnd = new Random();
        x = rnd.nextInt(SIZEXO) + 1;
        y = rnd.nextInt(SIZEXO) + 1;
        /* System.out.println("Игрок №2 пробует ходить X="+x+" Y="+y);*/
        if (androidGo(x - 1, y - 1)) {
            System.out.println("Игрок 2 завершил ход X=" + x + ", Y=" + y);
            this.showMe();
        } else {
            this.androidGo();
        }
    }

    /*Разделитель*/
    public void showMe()                                // Выводим игровое поле на экран
    {
        System.out.println("       X->  ");
        System.out.print("       ");

        for (int i = 0; i < SIZEXO; i++) {
            System.out.print((i + 1) + " ");

        }
        System.out.println();
        System.out.println("       ______");

        for (int i = 0; i < SIZEXO; i++) {
            System.out.print("Y ↓ " + i + "| ");
            for (int j = 0; j < SIZEXO; j++) {
                System.out.print(this.xyPole[j][i] + " ");

            }
            System.out.println();
        }
        System.out.println();
    }
    /*Разделитель*/

    public int checkTheWin() // Проверяем на победителя
    {
        String lineOne = "";
        String lineTwo = "";
        for (int i = 0; i < SIZEXO; i++) {
            for (int j = 0; j < SIZEXO; j++) {
                lineOne += this.xyPole[i][j];
                lineTwo += this.xyPole[j][i];

            }
            // проверяем статус победы

            if (lineOne.equals((String) "000") || lineTwo.equals((String) "000")) {
                this.status = 2;
                return this.status;
            }
            if (lineOne.equals((String) "XXX") || lineTwo.equals((String) "XXX")) {
                this.status = 1;
                return this.status;
            }
            lineOne = "";
            lineTwo = "";

        }
        for (int i = 0; i < SIZEXO; i++) {
            lineOne += this.xyPole[i][i];
            lineTwo += this.xyPole[SIZEXO - i - 1][i];

        }
        if (lineOne.equals((String) "000") || lineTwo.equals((String) "000")) {
            this.status = 2;
            return this.status;
        }
        if (lineOne.equals((String) "XXX") || lineTwo.equals((String) "XXX")) {
            this.status = 1;
            return this.status;
        }
/*        System.out.println("line1=" + lineOne);
        System.out.println("line2=" + lineTwo);*/

        this.status = 3;
        return this.status;
    }

    public int isTheGameIsOver() {

        return 0;
    }


}