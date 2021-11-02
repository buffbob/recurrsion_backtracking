package selections;

import java.util.Arrays;

public class One {

    public static void testRandom(int[] ints, int k) {
        // random int between (lo+1) and (hi-1)
        for (int i = 0; i < 100; i++) {
            int r = (int) (Math.random() * (ints.length - 2) + 1);
            System.out.println(r);
        }
    }

    public static int kthLargest(int[] ints, int k, int firstIdx, int lastIdx){
        // partition based on r
        int pivot = partition(ints, firstIdx, lastIdx);
        // check position with k
        int idx = k - 1;
        if (pivot > idx) { // consider left side of pivot
            return kthLargest(ints, 2, firstIdx, pivot - 1);
        } else if (pivot < idx) { // consider the larger values
            return kthLargest(ints, 2, pivot + 1, lastIdx);
        }
        return ints[pivot];
    }

    private static int[] swap(int[] ints, int idx1, int idx2) {
        int temp = ints[idx1];
        ints[idx1] = ints[idx2];
        ints[idx2] = temp;
        return ints;
    }

    /**
     *
     * @param ints
     * @param idxLo
     * @param idxHi
     * @return index of the pivot
     */
    private static int partition(int[] ints, int idxLo, int idxHi) {
//        random int between (lo+1) and (hi-1)
        int r = (int) (Math.random() * (idxHi + 1));
        System.out.println("r = " + r);
//        convert k to 0-based index
//        swap the r value with the value at the end
        swap(ints, r, idxHi);
//        iterate through moving larger items to the right of the last value
        for (int i = idxLo; i < idxHi; i++) {
            if (ints[i] < ints[idxHi]) {
                swap(ints, i, idxLo);
                idxLo += 1;
            }
        }
        swap(ints, idxLo, idxHi);
        return idxLo;
    }

    public static void main(String[] args) {
        int[] i = {-5, 5, 10, 15, 25, 55, 78, 99, 101};
        int[] ii = {5, -35, 10, -15, 25, 2, 8, 99, 11};
        Arrays.stream(ii).forEach(x -> System.out.print(x + ", "));
        System.out.println();
//        int p = partition(ii, 0, ii.length -1);
//        System.out.println("pivot = " + p);
//        Arrays.stream(ii).forEach(x -> System.out.print(x + ", "));
//        System.out.printf("%n%d%n", ii.length);
//        System.out.println("--------------");
//        int r = (int) (Math.random() * (ii.length + 1));
//        for (int j = 0; j < 100; j++) {
//            System.out.println((int) (Math.random() * (ii.length)));
        System.out.println("---------------------");
        int kth = kthLargest(ii, 2, 0, (ii.length - 1));
        System.out.println(kth);



        }

    }

