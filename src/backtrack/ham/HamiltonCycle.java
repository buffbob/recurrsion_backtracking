package backtrack.ham;

public class HamiltonCycle {

    private int [][] adjacencyMatrix;
    private int num;
    private int [] path;
    private boolean hasCycle;

    public boolean setMatrix(int [][] array){
        this.adjacencyMatrix = array;
        this.num = array[0].length; // array.length
        this.path = new int[array.length];
        // default value because all values on the diagonal are 0
        this.path[0] = 0;
        this.hasCycle = false;
        return true;
    }

    /**
     * @param position -- the idx of the path array
     * @return whether a solution is found
     */
    public boolean findASolution(int position) {
        if(position == num) {
            if(adjacencyMatrix[path[num-1]][path[0]] == 1) {
                hasCycle = true;
                return true;
            } else return false;

        }
        // iterate along vertices starting at 1 because
        for (int idx = 1; idx < num; idx++) {
            if(isPossible(position, idx)){
                path[position] = idx;
                if(findASolution(position + 1)) return true;

            }
        }
        return false;
    }

    public void display() {
        if(hasCycle) {
            System.out.println("A possible hamilton path");
            for (int i = 0; i < num; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        } else System.out.println("no path to display\nno complete cycles found!");
    }
    private boolean isPossible(int position, int verticesIdx) {
        // check that the value at adjacencyMatrix[path[position-1]][idx] == 1
        if(adjacencyMatrix[position-1][verticesIdx] == 0) return false;
        // check that the value verticleIdx is not in any previous position
        for(int i = 0; i < position; i++) {
            if(path[i] == verticesIdx) return false;
        }
        return true;
    }




}
