package Education;

public class Spiral {
    private static final int SIZE_X = 0;
    private static final int SIZE_Y = 7;
    private static int[][] array = new int[SIZE_X][SIZE_Y];
    private static int counter = 0;
    private static int deep = 0;

    public static void main(String[] args) {
        fillArray(SIZE_X, SIZE_Y);
        showArray();
    }

    private static void showArray() {
        for (int i = 0; i < SIZE_Y; i++) {

            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(array[j][i] + " ");
                if (array[j][i] < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    private static void fillArray(int sizeX, int sizeY) {

        if (sizeX==0 || sizeY==0){
            throw new RuntimeException("0 размер массива не возможен");
        }
        while (!isCompleate()) {
            fillLinearX(deep, sizeX - deep, true);
            if (isCompleate()) return;

            fillLinearY(deep, sizeY - deep, true);
            if (isCompleate()) return;


            fillLinearX(deep, sizeX - deep, false);
            if (isCompleate()) return;

            fillLinearY(deep, sizeY - deep, false);

            deep++;
        }

    }

    private static boolean isCompleate() {
        return counter >= SIZE_X * SIZE_Y;
    }


    private static void fillLinearY(int currentDeep, int sY, boolean linear) {
        if (linear) {


            for (int i = 1; i < sY - currentDeep; i++) {
                array[SIZE_X - currentDeep - 1][i + currentDeep] = ++counter;

            }
        } else {
            for (int i = 1; i < sY - currentDeep - 1; i++) {
                array[currentDeep][SIZE_Y - 1 - currentDeep - i] = ++counter;


            }


        }
    }

    private static void fillLinearX(int currentDeep, int sx, boolean linear) {
        if (linear) {
            for (int i = 0; i < sx - currentDeep; i++) {
                array[i + currentDeep][currentDeep] = ++counter;

            }

        } else {
            for (int i = 1; i < sx - currentDeep; i++) {

                array[SIZE_X - 1 - currentDeep - i][SIZE_Y - currentDeep - 1] = ++counter;


            }
        }

    }
}
