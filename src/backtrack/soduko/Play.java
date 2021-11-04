package backtrack.soduko;

public class Play {




    public static int[][] createMatrix(int n) {
        int[][] t = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = counter++;
            }
        }
        return t;
    }


    // create a matrix to consider only a subset of 3(boxSize) of the following matrix
//    divide Matrix into 3rds // and only consider your 3rd
    // find trident
    public static int trident(int n) {
        return n%3;
    }
    public static void printTrident(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(trident(i));
        }
    }
    public static void printArray(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static int [] createArray(int a) {
        int [] t = new int[a];
        for (int i = 0; i < a; i++) {
            t[i] = i;
        }
        return t;
    }

    public static void printSub3array(int[] a, int rowIdx) {
        int quadrantOf3 = rowIdx/3;
        int off = rowIdx%3;
        int startIdx = (quadrantOf3 * 3);
        for (int i = 0; i < 3; i++) {
            System.out.print(a[startIdx++] + " ");
        }
    }

    public static void printSub3Matrix(int[][] m, int rowIdx, int colIdx){
        // find the starting idx for the quadrant in question
        int subSize = 3;
        int rowStart = (rowIdx / subSize) * subSize;
        int colStart = (colIdx / subSize) * subSize;
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                System.out.printf("%3d", m[rowStart + i][colStart + j]);
            }
            System.out.println();

        }
    }




    public static void printIntMatrix(int [][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int size = 9;
        printIntMatrix(createMatrix(9));
//        printTrident(size);
//        printSub3array(createArray(9), 8);

        System.out.println("----------------------------------------------------");
        printSub3Matrix(createMatrix(9), 1, 4);

    }
}
