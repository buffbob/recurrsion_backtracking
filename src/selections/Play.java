package selections;

import java.util.Random;

public class Play {

    public static void main(String[] args) {
        int startIdx = 0;
        int endIdx = 9;

        for (int i = 0; i < 20; i++) {
            int pivotPt = new Random().nextInt(endIdx - startIdx + 1) + startIdx;
            System.out.println(pivotPt);
        }
    }
}
