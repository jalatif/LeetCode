package Search;

/**
 * Created by manshu on 1/12/15.
 */
public class SquareRoot {

    public static double sqrt(int x) {
        if (x == 0 || x == 1) return x;
        double guess = 1.0;
        double threshold = 0.00000000001;
        while (true) {
            double curren_val = ((guess * guess) - x) / x;
            if (Math.abs(curren_val) < threshold) break;
            guess = (guess + x / guess) / 2.0;
        }
        return guess;
    }

    public static int sqrt_(int x) {
        if (x == 0 || x == 1) return x;
        double guess = 1;
        double threshold = 1;
        double curr_guess = 1;
        while (true) {
            curr_guess = (guess + x / guess) / 2;
            if (Math.abs(curr_guess -guess) < 1) break;
            guess = curr_guess;
        }
        return (int) curr_guess;
    }

    public static void main(String args[]) {
        System.out.println(sqrt_(2147395599));
    }

}
