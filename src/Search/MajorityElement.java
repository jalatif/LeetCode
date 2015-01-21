package Search;

/**
 * Created by manshu on 1/16/15.
 */
public class MajorityElement {
    public static int majorityElement(int[] num) {
        int element = num[0], count = 0;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                element = num[i];
                count = 1;
            }
            else if (element == num[i]) {
                count++;
            }
            else {
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 1};
        System.out.println(majorityElement(arr));
    }
}
