package backtrack.colors;

public class Colors {

    private int numColors;
    private int [][] adjacencyMatrix;
    private int [] colors;
    private int numVertices;

    public Colors(int[][] adjMat, int numberOfColors) {
        this.adjacencyMatrix = adjMat;
        this.numVertices = adjMat.length;
        this.numColors = numberOfColors;
        this.colors = new int[numVertices];
    }

    public void solve() {
        if (solveColors(0)) {
            System.out.println("A solution was found and is printed below--");
            showResults();
        } else {
            System.out.println("No solution found!");
        }
    }

    private boolean solveColors(int nodeIdx) {
        if (nodeIdx == numVertices) {
            return true;
        }
        for (int colorIdx = 1; colorIdx <= numColors; colorIdx++) {
            if (isValidColor(nodeIdx, colorIdx)) {
                colors[nodeIdx] = colorIdx;
                if (solveColors(nodeIdx + 1)) return true;
            }
        }
        return false;
    }

    private boolean isValidColor(int node_index, int color_index) {
        // confirm that no previous connected nodes have a colorIdx = to color_index
        for (int vertIdx = 0; vertIdx < node_index; vertIdx++) {
            // test if connected to previous nodes and if the color idxs are the same
            if ((adjacencyMatrix[node_index][vertIdx] == 1) && (colors[vertIdx] == color_index)){
                    return false;
            }
        }
        return true;
    }

    public void showResults() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex = " + i + ", Color = " + colors[i]);
        }
    }
}
