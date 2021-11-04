package backtrack.soduko;

public class Sudoku2 {

    private int[][] table;
    private int size;

    Sudoku2(int [][] t) {
        table = t;
        size = table.length;
    }


    public void solve() {
        if (solveSudoku(0,0)) showResults();
        System.out.println("no solution");
    }

    private boolean solveSudoku(int rowIdx, int colIdx) {
        if((rowIdx == size) && (++colIdx == size)) return true;
        if(rowIdx == size) rowIdx = 0;
        if (table[rowIdx][colIdx] != 0) return solveSudoku(rowIdx+1, colIdx);
        for (int i = 1; i <= size ; i++) {
            if(isValid(rowIdx, colIdx, i)){
                table[rowIdx][colIdx] = i;
                if(solveSudoku(rowIdx+1, colIdx)) return true;
                // BACKTRACK
                table[rowIdx][colIdx] = 0;
            }
        }
        return false;
    }


    private boolean isValid(int columnIdx, int rowIdx, int number) {
        // check row
        for (int i = 0; i < size; i++) {
            if (table[i][rowIdx] == number) return false;
        }
        // check col
        for (int i = 0; i < size; i++) {
            if (table[columnIdx][i] == number) return false;
        }
        // check sub array
        // find starting pt for subarray
        int stX = (columnIdx/3) * 3;
        int stY = (rowIdx/3) * 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if(table[stX + r][stY + c] == number) return false;
            }
        }
        return true;
    }

    private void showResults() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%3d", table[i][j]);
                if((j+1)%3 == 0) System.out.print("  ");
            }
            System.out.println();
            if((i+1)%3 == 0) System.out.println();

        }
    }

    public static void main(String[] args) {
        int sudokuTable[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        Sudoku2 sudoku = new Sudoku2(sudokuTable);
        sudoku.solve();

    }
}
