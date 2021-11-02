package backtrack.queen;

public class NQueens {

    private int [][] cheesboard;
    private int N;

    public NQueens(int n) {
        this.N = n;
        this.cheesboard = new int[n][n];
    }

    private boolean isValidPlace(int row, int col) {
        // confirm that for all previous columns there is no backtrack.queen on this row
        for (int i = 0; i < col; i++) {
            if(cheesboard[row][i] == 1) return false;
        }
        // now check that diagonal up is clear
        for (int r=row, c=col; r >=  0 && c >= 0; r--, c--) {
            if(cheesboard[r][c] == 1) return false;
        }
        // diagonal down
        for(int r = row, c = col; r < N && c >= 0; r++, c--){
            if (cheesboard[r][c] == 1) return false;
        }

        return true;
    }

    public boolean setQueen(int colIndex) {
        if (colIndex == N) return true;
        //
        for (int row = 0; row < N; row++) {
            if(isValidPlace(row, colIndex)){
                cheesboard[row][colIndex] = 1;
                if (setQueen(colIndex + 1)) return true;
                cheesboard[row][colIndex] = 0;
            }
        }
        return false;
    }

    public void solve() {
        if (setQueen(0)) {
            System.out.println("the solution was found! \n\n");
            display();
        } else {
            System.out.println("There is no solution!\n\n");
            display();
        }

    }


    public void display(){
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(cheesboard[row][col] == 1) System.out.print(" * ");
                else System.out.print(" - ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
