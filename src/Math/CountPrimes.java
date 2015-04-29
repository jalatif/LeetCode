package Math;

/**
 * Created by manshu on 4/28/15.
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] isComposite = new boolean[n];
        int count = 0;
        int sqrtn = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= Math.min(sqrtn, n - 1); i++) {
            if (isComposite[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isComposite[j] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }
}
