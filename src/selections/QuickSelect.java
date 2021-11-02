package selections;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

    private int [] ints;
    public QuickSelect(int [] i) {
        this.ints = i;
    }

    public int select(int kth){
        int idx = kth - 1; // for ex: the 2nd smallest is at index 1
        int res = quickSelect(idx, 0, ints.length - 1);
        return res;
    }

    private int quickSelect(int kthIndex, int startIndex, int endIndex) {
        int pivotIndex = partition(startIndex, endIndex);
        if (kthIndex < pivotIndex) { // discard right half
            return quickSelect(kthIndex, startIndex, pivotIndex - 1);
        } else if (kthIndex > pivotIndex) { // discard left half
            return quickSelect(kthIndex, pivotIndex + 1, endIndex);
        }
        return ints[pivotIndex];
    }

    private void swap(int idx1, int idx2) {
        int temp = ints[idx1];
        ints[idx1] = ints[idx2];
        ints[idx2] = temp;
    }

    private int partition(int startIdx, int endIdx) {
        int pivotPt = new Random().nextInt(endIdx - startIdx + 1) + startIdx;
        swap(pivotPt, endIdx);
        for (int j = startIdx; j < endIdx; j++) {
            if(ints[j] > ints[endIdx]){
                swap(j, startIdx);
                startIdx += 1;
            }
        }
        swap(startIdx, endIdx);
        return startIdx;
    }

    public void sort() {
        for (int i = 1; i <= ints.length; i++) {
            System.out.println(select(i));
        }
    }
}
