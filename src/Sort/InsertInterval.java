package Sort;

import java.util.*;

/**
 * Created by manshu on 1/14/15.
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            result.add(newInterval); return result;
        }

        int lo = 0, hi = intervals.size() - 1;
        int start = -1, end = -1;
        boolean startFound = false, endFound = false;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Interval midInterval = intervals.get(mid);
            if (midInterval.start > newInterval.start) hi = mid - 1;
            else if (midInterval.start < newInterval.start) {
                if (midInterval.end < newInterval.start) lo = mid + 1;
                else {
                    start = mid;
                    startFound = true;
                    break;
                }
            } else {
                start = mid;
                startFound = true;
                break;
            }
        }
        if (!startFound) start = lo;

        lo = 0; hi = intervals.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Interval midInterval = intervals.get(mid);
            if (midInterval.end < newInterval.end) lo = mid + 1;
            else if (midInterval.end > newInterval.end) {
                if (midInterval.start > newInterval.end) hi = mid - 1;
                else {
                    end = mid;
                    endFound = true;
                    break;
                }
            }
            else {
                end = mid;
                endFound = true;
                break;
            }
        }
        if (!endFound) end = lo - 1;

        System.out.println(start + " " + end);

        Interval interval = new Interval(newInterval.start, newInterval.end);
        if (startFound)
            if (intervals.get(start).start > newInterval.start)
                interval.start = newInterval.start;
            else
                interval.start = intervals.get(start).start;

        if (endFound)
            if (intervals.get(end).end < newInterval.end)
                interval.end = newInterval.end;
            else
                interval.end = intervals.get(end).end;

        System.out.println(interval);

        //if (!startFound && start == 0) result.add(interval);

        for (int i = 0; i < intervals.size(); i++) {
            if (i == start)
                result.add(interval);
            if (i < start || i > end)
                result.add(intervals.get(i));

        }

        if (!startFound && start == intervals.size()) result.add(interval);

        return result;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> stack = new Stack<Interval>();
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                Integer s1 = o1.start;
                return s1.compareTo(o2.start);
            }
        };
        //Collections.sort(intervals, comparator);
        for (Interval interval : intervals) {
            if (!stack.empty()) {
                Interval interval1 = stack.peek();
                if (interval.start <= interval1.end) {
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

    public static List<Interval> Insert(List<Interval> intervals, Interval newInterval) {
        int lo = 0, hi = intervals.size() - 1;
        int start = -1, end = -1;
        boolean startFound = false, endFound = false;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Interval midInterval = intervals.get(mid);
            if (midInterval.start > newInterval.start) hi = mid - 1;
            else if (midInterval.start < newInterval.start) lo = mid + 1;
            else {
                start = mid;
                startFound = true;
                break;
            }
        }
        System.out.println(start + " " + lo);
        if (start == -1 && (lo != intervals.size())) intervals.add(lo, newInterval);
        if (start == -1 && (lo == intervals.size())) intervals.add(newInterval);
        if (start != -1) intervals.add(start, newInterval);

//        if (!startFound && lo != 0) start = lo;
//        if (start >= intervals.size())intervals.add(newInterval);
//        else intervals.add(start + 1, newInterval);
        System.out.println(intervals);
        return merge(intervals);
    }

    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<Interval>();
//        intervals.add(new Interval(1, 5));
//        intervals.add(new Interval(3, 4));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));
//        intervals.add(new Interval(0, 5));
//        intervals.add(new Interval(9, 12));
        intervals.add(new Interval(1, 5));

        Interval interval = new Interval(2, 3);

        System.out.println(insert(intervals, interval));
        System.out.println(Insert(intervals, interval));
    }
}
