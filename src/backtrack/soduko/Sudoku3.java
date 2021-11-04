package backtrack.soduko;

public class Sudoku3 {

    private int[][] sudokuTable;
    private int size;

    public Sudoku3(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
        this.size = sudokuTable.length;
    }

    public void solveSudokuProblem() {

        if ( !solve(0, 0) ){
            System.out.println("No feasible solution found...");
        } else {
            showResult();
        }
    }

    private boolean solve(int rowIndex, int columnIndex) {

        System.out.println("Before Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);

        if( rowIndex == size && ++columnIndex == size ){
            System.out.println("Vegere ertunk");
            return true;
        }

        System.out.println("After Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);

        if( rowIndex == size){
            System.out.println("Hop to next column, reinitialize rowIndex=0");
            rowIndex=0;
        }

        if ( sudokuTable[rowIndex][columnIndex] != 0 ) { // skip filled cells
            return solve(rowIndex + 1, columnIndex);
        }

        for (int numbers = 1; numbers <= size; ++numbers) {

            if ( valid(rowIndex, columnIndex, numbers) ) {

                sudokuTable[rowIndex][columnIndex] = numbers;

                if ( solve(rowIndex + 1, columnIndex) )
                    return true;
            }
        }

        sudokuTable[rowIndex][columnIndex] = 0; // backtracking !!!

        return false;
    }

    private boolean valid(int columnIndex, int rowIndex, int actualNumber) {

        // if the given number is already in the row: the number cannot be part of the solution
        for (int i = 0; i < size; ++i) // check the rows
            if ( sudokuTable[i][rowIndex] == actualNumber )
                return false;

        // if the given number is already in the column: the number cannot be part of the solution
        for (int k = 0; k < size; ++k)
            if ( sudokuTable[columnIndex][k] == actualNumber )
                return false;

        // if the given number is already in the box: the number cannot be part of the solution
        int boxRowOffset = (columnIndex / 3) * 3;
        int boxColumnOffset = (rowIndex / 3) * 3;

        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset + j])
                    return false;

        return true;
    }

    private void showResult() {

        for (int i = 0; i < size; ++i) {

            if(i % 3 == 0) System.out.println(" ");

            for (int j = 0; j < size; ++j) {

                if (j % 3 == 0) System.out.print(" ");
                System.out.print(sudokuTable[i][j]+" ");
            }

            System.out.println(" ");
        }
    }
}