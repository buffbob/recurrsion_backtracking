package backtrack.queen;

import backtrack.queen.NQueens;

public class Main {

    public static void main(String[] args) {
        NQueens queens = new NQueens(15);
        queens.solve();
    }
}
