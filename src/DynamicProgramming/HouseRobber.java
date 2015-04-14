package DynamicProgramming;

/**
 * Created by manshu on 4/13/15.
 */
public class HouseRobber {

    public static int rob(int[] num) {
        if (num == null || num.length == 0) return 0;
        int[] mi = new int[num.length];
        mi[0] = num[0];
        if (num.length == 1) return num[0];
        mi[1] = num[1];
        if (num.length == 2) return Math.max(num[0], num[1]);
        mi[2] = num[0] + num[2];
        for (int i = 3; i < num.length; i++) {
            mi[i] = num[i] + Math.max(mi[i - 2], mi[i - 3]);
        }
        return Math.max(mi[num.length - 1], mi[num.length - 2]);
    }

    public static void main(String[] args) {
        int[] num = {5, 10, 8, 2, 1, 50};
        System.out.println(rob(num));
    }
}
