package Search;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by manshu on 1/12/15.
 */
public class Divide2Integers {
    public static int divide(int dividend, int divisor) {
        int sign = 1;

        if (dividend < 0) sign = 0 - sign;
        if (divisor < 0) sign = 0 - sign;

        long Dividend = Math.abs((long)dividend);
        long Divisor = Math.abs((long)divisor);

        if (Divisor == 0) return Integer.MAX_VALUE;
        //if (Divisor == 1) return sign * (int) Dividend;

        if (Dividend < Divisor) return 0;

        long i = 0;
        long num = 0;
        long quotient = 0;
        while (true) {
            num = Divisor << i++;
            if (Math.abs(num) > Dividend) {
                i -= 2;
                System.out.println("I = " + i);
                if (i > 0) quotient += 2l << (i - 1);
                else quotient += 1;
                System.out.println((Divisor << i));
                Dividend = Dividend - (Divisor << i);
                System.out.println("Match at 2^" + i + " Quotient = " + quotient + " dividend remain = " + Dividend);
                if (Dividend <= 0 || Dividend < Divisor) break;
                i = 0;
            }
        }
        if (quotient == Math.abs((long)Integer.MIN_VALUE)) {
            if (sign == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        return sign * (int) quotient;
    }
    public static int Divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        int sign = 1;
        if (dividend < 0) { sign = 0 - sign; dividend = 0 - dividend; }
        if (divisor < 0) { sign = 0 - sign; divisor = 0 - divisor; }

        if (dividend < divisor) return 0;

        int num = divisor;
        int quotient = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(divisor);

        while (true) {
            int temp = num;
            int i = divisor;
            num = 0;
            quotient = 0;
            for (; i > 0; i--) {
                num += temp;
                if (num > dividend) break;
            }
            quotient = (divisor - i);
            if (num > dividend) {num = num - temp; stack.pop(); break;}
            //System.out.println("result = " + num + " " + quotient);
            stack.push(num);

        }
        //System.out.println("result = " + num + " " + quotient);

//        Iterator<Integer> iterator = stack.iterator();
//        while (iterator.hasNext()) {
//            //System.out.print(iterator.next() + " ");
//        }
//        //System.out.println();

        if (stack.empty()) return sign * quotient;

        int result = stack.peek() * quotient;
        //System.out.println("first result = " + result);
        dividend = dividend - num;
        num = dividend;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            //System.out.println("Popped = " + current);
            quotient = 0;
            num = 0;
            for (int i = 0; i < divisor; i++) {
                num += current;
                if (num > dividend) {
                    quotient = i;
                    num = num - current;
                    break;
                }
            }
            if (stack.empty()) {result += quotient; return sign * result;}
            result += quotient * stack.peek();
            dividend = dividend - num;
            //System.out.println("result2 = " + result + " " + dividend);
        }

        return sign * result;
    }
    public static void main(String args[]) {
        System.out.println(5 << 4);
        int a = -1010369383;//2147483647;
        a = 2147483647;
        int b = 3;
        System.out.println(divide(a, b) + " <> " + a / b);
    }
}
