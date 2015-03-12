package Math;

/**
 * Created by manshu on 3/11/15.
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitleRec(int n) {
        n = n - 1;
        int rem = n % 26;
        //if (rem == 0) rem = 26;

        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append((char) (rem - 1 + 65));

        int k = n / 26;
        //System.out.println("k = " + k);
        if (k < 26) {
            if (k == 0) stringBuilder.append((char) (rem + 65));
            else stringBuilder.append((char) (k + 65 - 1)).append((char) (rem + 65));
        }
        else {
            stringBuilder.append(convertToTitleRec(k)).append((char) (rem + 65));
        }
        return stringBuilder.toString();
    }

    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            n = n - 1;
            int rem = n % 26;
            int k = n / 26;
            //System.out.println("k = " + k);
            if (k < 26) {
                if (k == 0) stringBuilder.append((char) (rem + 65));
                else stringBuilder.append((char) (rem + 65));
            } else {
                stringBuilder.append((char) (rem + 65));
            }
            n = k;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitleRec(1023));
        System.out.println(convertToTitle(1023));

    }
}
