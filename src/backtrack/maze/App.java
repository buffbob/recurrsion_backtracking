package backtrack.maze;

public class App {
    public static void main(String[] args) {
        String [][] maze = new String [][] {
                {" ", " ", " ", " ", " "},
                {" ", "X", "X", " ", "X"},
                {"X", "X", "X", " ", "X"},
                {" ", " ", " ", " ", " "},
                {" ", "X", "X", "X", " "},

        };
        int [] s = {0, 0};
        int [] e = {maze.length-1, maze.length-1};
        Maze m = new Maze(maze, s, e);
        m.solve();
        m.printMaze();
        System.out.println("---------");
        System.out.println(maze.length);
        System.out.println(maze[0].length);
    }
}
