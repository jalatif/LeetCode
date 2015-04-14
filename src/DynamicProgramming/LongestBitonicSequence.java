package DynamicProgramming;

/**
 * Created by manshu on 4/11/15.
 */
public class LongestBitonicSequence {

    public static int longestBitonicSequence(int[] num) {
        int[] lis = new int[num.length];
        int[] lds = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            lis[i] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (num[j] < num[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
                j--;
            }
        }

        for (int i = num.length - 1; i >= 0; i--) {
            lds[i] = 1;
            int j = i + 1;
            while (j < num.length) {
                if (num[j] < num[i]) lds[i] = Math.max(lds[i], lds[j] + 1);
                j++;
            }
        }

        int max_bitonic_seq_length = 1;
        for (int i = 0; i < num.length; i++) {
            max_bitonic_seq_length = Math.max(max_bitonic_seq_length, lis[i] + lds[i] - 1);
        }

//        for (int i = 0; i < num.length; i++) {
//            System.out.print(lis[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < num.length; i++) {
//            System.out.print(lds[i] + " ");
//        }
//        System.out.println();

        return max_bitonic_seq_length;
    }

    public static void main(String[] args) {
        int[] num =  {80, 60, 30, 40, 20, 10};//{12, 11, 40, 5, 3, 1};//{1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestBitonicSequence(num));
    }
}
