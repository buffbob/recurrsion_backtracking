
package backtrack.soduko;

public class Soduko {

    private int [][] board;
    private int size;

    public Soduko(int[][] matrix) {
        this.board = matrix;
        this.size = matrix.length;
    }

    public void solve() {
        if (solveSoduko(0, 0)) showSolution();
        else System.out.println("No Solution Found");
    }

    private boolean solveSoduko(int rowIdx, int colIdx) {
        if (isFinished(rowIdx, colIdx)) return true;
        // end of row but not finished, reset rowIdx to 0
        if (rowIdx == size) rowIdx = 0;
        // test that we need to solve at the current location (ie number already entered as part of puzzle)
        if (board[rowIdx][colIdx] != 0) {
            return solveSoduko(rowIdx + 1, colIdx);
        }
        int number; // start number of sudoku table
        for (number = 1; number <= size; number++) {
            if (isValid(rowIdx, colIdx, number)){
                board[rowIdx][colIdx] = number;
                if(solveSoduko(rowIdx + 1, colIdx)) {
                    return true;
                }
                // backtrack
                board[rowIdx][colIdx] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int number){
        // check rowIdx (an entire column)
        for (int i = 0; i < size; i++) {
            if(board[i][colIndex] == number) return false;
        }
        // check column (a complete row)
        for (int i = 0; i < size; i++) {
            if(board[rowIndex][colIndex] == number) return false;
        }
        // check sub-array
        int rowStart = (rowIndex/3)*3;
        int colStart = (colIndex/3)*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[rowStart + i][colStart] == number) return false;
            }
        }
        return true;
    }

    private boolean isFinished(int rowIdx, int colIdx) {
        if ((rowIdx == size) && (++colIdx == size)) return true;
        return false;
    }
    public void showSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf(" %3d ", board[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int [][] one = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Soduko s = new Soduko((one));
        s.showSolution();
    }
}
