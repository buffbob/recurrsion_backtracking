package binary;

public class BinarySearch {


    private int[] ints;
    private int target;
    private int start;
    private int end;

    /**
     * sets the initial fields of start(0) and end(ints.length - 1)
     * @param i a sorted list of ints
     * @param t the target int to search for
     */
    public BinarySearch(int [] i, int t){
        this.ints = i;
        this.target = t;
        start = 0;
        end = i.length - 1;
    }
    /**
     * @param high
     * @param low
     * @return int --> -1 is a miss, or the index of the hit
     */
    public int recur(int low, int high) {
        int mid = ((high - low) / 2) + low;
        if ((mid < low) || (mid > high)){
            return -1;
        }
        if (target < ints[mid]) {
            int temp = mid - 1;
            return recur(low, temp);
        } else if (target > ints[mid]) {
            int temp = mid + 1;
            return recur(temp, high);
        } else return mid;


    }

    public static void main(String[] args) {
        int [] i1 = {-3, 0, 1, 33, 100};
        int [] i2 = {-3, 0, 3};

        int target = 112;
        BinarySearch bs = new BinarySearch(i1, target);
        System.out.println(bs.recur(bs.start, bs.end));
    }
}
