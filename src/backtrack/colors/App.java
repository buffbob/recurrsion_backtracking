package backtrack.colors;

public class App {
    public static void main(String[] args) {
        int [][] matrix = {
                {0,1,0,1,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {1,1,1,0,1},
                {0,0,0,1,0}
        };
        int numColors = 3;
        Colors c = new Colors(matrix, numColors);
        c.solve();
        System.out.println();
    }
}