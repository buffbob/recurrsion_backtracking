package backtrack.knight;

public class Constants {
    private Constants() {}

    public static final int BOARD_SIZE = 8;
    public static int [] X_MOVES = {2,1,-1,-2,-2,-1,1,2};
    public static int [] Y_MOVES = {1,2,2,1,-1,-2,-2,-1};
    public static int NUM_MOVES = X_MOVES.length;
}
