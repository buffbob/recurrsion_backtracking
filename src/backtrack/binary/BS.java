package backtrack.binary;

public class BS {

    public static int find(int [] ints, int value, int lo, int hi) {

        int mid = (hi + lo)/2;

        if (lo > hi) return -1;

        if (value < ints[mid]) {
            return find(ints, value, lo, mid - 1);
        } else if (value > ints[mid]) {
            return find(ints, value, mid + 1, hi);
        } else return mid;
    }

    public static void main(String[] args) {
        int [] i = {-3, -2, 0};
        int v = 0;
        int sol = find(i, v, 0, i.length - 1);
        System.out.println(sol);
        System.out.println(Math.random());

    }

}
