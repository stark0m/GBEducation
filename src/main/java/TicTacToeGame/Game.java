package TicTacToeGame;



import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final char DOT_HUMAIN = 'X';              // Знак игрока 1
    public static final char DOT_AI = 'O';                  // Знак игрока 2
    public static final char DOT_EMPTY = '*';               // Знак пустой клетки
    public static final String FREE_SPACE = " ";            // Разделитель в сетке для вывода
    public static final char DOT_LOGO = 'L';                // Знак логотипа (первый знак при отображении)
    public static final int DIMENSION = 3;                 // Размерность поля
    public static final int CELLS_TOWIN = 3;                // Количество ячеек необходимых для победы


    public static Random rnd = new Random();
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        TicTacToeClass game = new TicTacToeClass(DIMENSION,CELLS_TOWIN, DOT_HUMAIN, DOT_AI, DOT_EMPTY, FREE_SPACE, DOT_LOGO);

        game.run();
    }
}
