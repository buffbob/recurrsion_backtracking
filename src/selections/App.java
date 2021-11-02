package selections;

public class App {
    public static void main(String[] args) {
        int[] nums = {1, -5,10, 55, 2,3,-7, 7, 11,100};
        QuickSelect qs = new QuickSelect(nums);
        qs.sort();
    }
}
