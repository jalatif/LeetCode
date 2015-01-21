package Search;

/**
 * Created by manshu on 1/12/15.
 */
public class PowerFxn {
    public static double powsimple(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < n; i++)
            result *= x;
        return result;
    }

    public static double pow(double x, int n) {
        if (n < 0) return pow(1./x, -1 * n);
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) return pow(x * x, n / 2);
        else return x * pow(x * x, (n - 1) / 2);
    }

    public static void main(String args[]) {
        System.out.println(pow(2, 10));
        System.out.println(pow(0.00001, 2147483647));
        System.out.println(pow(34.00515, -3));
    }

}
