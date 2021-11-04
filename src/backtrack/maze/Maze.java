package backtrack.maze;

public class Maze {

    private String[][] maze;
    private int[][] solutionMatrix;
    private int size;
    private int[] start;
    private int[] exit;
    private int[] xMoves = new int[] {1,-1,0,0};
    private int[] yMoves = new int[] {0,0,1,-1};
    private int numMoves = xMoves.length;

    public Maze(String[][] matrix, int[] start, int[] exit) {
        this.maze = matrix;
        this.size = matrix.length;
        this.solutionMatrix = new int[size][size];
        this.start = start;
        this.exit = exit;
    }

    public void solve() {
        if(solveMaze(start[0], start[1])){
            System.out.println("solution found---");
            printSolution();
        } else System.out.println("NO SOLUTION FOUND");
    }

    private boolean solveMaze(int x, int y) {
        if (isFinished(x, y)){
            return true;
        }
        if (isValid(x, y)){
            solutionMatrix[x][y] = 1;
            for (int i = 0; i < numMoves; i++) {
                int xTemp = x + xMoves[i];
                int yTemp = y + yMoves[i];
                if(solveMaze(xTemp, yTemp)){
                    return true;
                }
            }
            // backtrack
            solutionMatrix[x][y] = 0;
        }
        return false;
    }
    private boolean isFinished(int x,int y){
        if((x == this.exit[0]) &&(y == this.exit[1])) {
            solutionMatrix[x][y] = 1;
            return true; // on the end
        }
        return false;
    }

    private boolean isValid(int x, int y){
        if(!((x >= 0) && (x < size))) return false;
        if(!((y >= 0) && (y < size))) return false;
        //check maze for opening or wall
        if (maze[x][y] == "X") return false; // "_" == ok
        // check that we are not going backwards
        if (solutionMatrix[x][y] == 1) return false;
        return true;
    }




    private static void printLine(int n) {
        for (int i = 0; i < n*3; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    public void printMaze() {
        printLine(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%3s", maze[i][j]);
            System.out.print("|");
            System.out.println();

        }
        printLine(size);
    }

    public void printSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%3s", solutionMatrix[i][j]);
            System.out.println();
        }
    }
}
