package String;

/**
 * Created by manshu on 4/13/15.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            int i1 = Integer.parseInt(v1[i]);
            int i2 = Integer.parseInt(v2[i]);
            //System.out.println(i1 + " " + i2);
            if (i1 == i2) continue;
            if (i1 > i2) return 1;
            if (i1 < i2) return -1;
        }
        if (v1.length == v2.length) return 0;
        else if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; i++) {
                int i1 = Integer.parseInt(v1[i]);
                if (i1 != 0) return 1;
            }
            return 0;
        }
        else {
            for (int i = v1.length; i < v2.length; i++) {
                int i2 = Integer.parseInt(v2[i]);
                if (i2 != 0) return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("3.2.4.2", "3.2.4.2.0"));
    }
}
