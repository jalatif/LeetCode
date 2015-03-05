package General;

/**
 * Created by manshu on 2/26/15.
 */
public class FizzBuzz {

    public static void fizzbuzz(int N) {
        for (int i = 1; i < N; i++) {
            boolean fb = false;
            if (i % 3 == 0) {
                System.out.print("Fizz");
                fb = true;
            }
            if (i % 5 == 0) {
                fb = true;
                System.out.print("Buzz");
            }
            if (!fb)
                System.out.println(i);
            else
                System.out.println();
        }
    }
    
    public static void main(String[] args) {
        fizzbuzz(100);    
    }
}
