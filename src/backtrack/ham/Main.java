package backtrack.ham;

import backtrack.ham.HamiltonCycle;

public class Main {

    public static void main(String[] args) {
        int [][] matrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        int [][] adjacencyMatrix2 = {
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1}
        };

        HamiltonCycle cycle = new HamiltonCycle();
        cycle.setMatrix(adjacencyMatrix2);
        System.out.println("a solution has been found-- " + cycle.findASolution(1));
        cycle.display();
    }
}
