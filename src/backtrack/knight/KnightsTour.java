package backtrack.knight;

public class KnightsTour {

    public static int counter = 0;
    int [][] chessboard;
    int size;

    public KnightsTour(){
        this.size = 9;
        chessboard = new int [size][size];
        initializeBoard();
    }



    public void solve(int x, int y) {
        chessboard[x][y] = 1;
        if (solveKnights(2, x, y)){
            System.out.println("---- A solution is ----");
            printKnights();
        } else System.out.println("NO SOLUTION");
    }

    private boolean solveKnights(int movesCounter, int x, int y) {
        if (movesCounter == size * size + 1){
            System.out.println("final spot @ (" + x + ", "+ y + ")");
            System.out.println("total trys = " + counter);
            return true;
        }
        counter++;
        // System.out.println("solving for move # = " + movesCounter);
        for (int i = 0; i < Constants.NUM_MOVES; i++) {
            int nextX = x + Constants.X_MOVES[i];
            int nextY = y + Constants.Y_MOVES[i];
            if(isValid(nextX,nextY)){
                chessboard[nextX][nextY] = movesCounter;
                if(solveKnights(movesCounter + 1, nextX, nextY)) return true;
                // backtrack
                chessboard[nextX][nextY] = -1;
            }
        }
        return false;
    }

    private boolean isValid2(int x, int y) {
        if((x < 0) || (x >= size)) return false;
        if((y < 0) || (y >= size)) return false;
        if(chessboard[x][y] != -1) return false;
        return true;


    }
    private boolean isValid(int x, int y){
        if(inRange(x,y) && notVisited(x,y)) {
            return true;
        }
        return false;
    }

    private boolean inRange(int x, int y) {
        if (((x>=0) &&(x<size)) && ((y>=0) && (y<size))) return true;
        return false;
    }

    private boolean notVisited(int x, int y) {
        // check value of array
        return chessboard[x][y] == -1 ? true: false;
    }
    
    private void initializeBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = -1;
            }
        }
    }

    private void printKnights(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%3d",chessboard[i][j]);
            }
            System.out.println();
        }
    }
}
