package Sort;

/**
 * Created by manshu on 1/14/15.
 */
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
