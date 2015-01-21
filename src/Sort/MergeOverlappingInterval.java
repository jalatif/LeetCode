package Sort;

import java.util.*;

/**
 * Created by manshu on 1/14/15.
 */
public class MergeOverlappingInterval {
    public static List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> stack = new Stack<Interval>();
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                Integer s1 = o1.start;
                return s1.compareTo(o2.start);
            }
        };
        Collections.sort(intervals, comparator);
        System.out.println(intervals);
        for (Interval interval : intervals) {
            if (!stack.empty()) {
                Interval interval1 = stack.peek();
                if (interval.start < interval1.end) {
                    if (interval.end > interval1.end)
                        interval1.end = interval.end;
                } else {
                    stack.push(interval);
                }
            } else {
                stack.push(interval);
            }
        }
        List<Interval> result = new ArrayList<Interval>();
        Iterator<Interval> intervalIterator = stack.iterator();
        while (intervalIterator.hasNext()) {
            result.add(intervalIterator.next());
        }
        return result;
    }

    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(3, 7));

        System.out.println(merge(intervals));
    }
}
