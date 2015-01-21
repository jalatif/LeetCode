package Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by manshu on 1/14/15.
 */
public class Fractional2String {
    public static String fractionToDecimal(int numerator, int denominator) {

        String string = String.valueOf((numerator * 1.0) / denominator);
        HashMap<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();

        boolean fractionalPart = false;
        int i = 0;
        while (!fractionalPart) {
            fractionalPart = (string.charAt(i++) == '.');
        }
        LinkedList<Integer> temp;
        StringBuilder stringBuilder = new StringBuilder(string.substring(0, i));

        while (i < string.length()) {
            LinkedList<Integer> indices = map.get(string.charAt(i));
            if (indices == null) {
                temp = new LinkedList<Integer>();
                temp.add(i);
                map.put(string.charAt(i), temp);
            } else {
                Iterator<Integer> iterator = indices.iterator();
                while (iterator.hasNext()) {
                    int index = iterator.next();
                    int r = 1;
                    while (r < (i - index) && (i + r) < string.length()) {
                        if (string.charAt(index + r) != string.charAt(i + r)) break;
                        r++;
                    }
                    if (r == (i - index)) {
                        System.out.println("Hurray " + i + " " + index);
                        stringBuilder.append("(" + string.substring(index, i)+ ")");
                        i += r;
                    }
                }
                indices.addLast(i);
                //map.put(string.charAt(i), indices);
            }
            i++;
        }

        System.out.println(string);
        return stringBuilder.toString();

    }

    public static void main(String args[]) {
        System.out.println(fractionToDecimal(2, 3));
    }
}
