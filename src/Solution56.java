import java.util.*;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */

//按照start排序 可合并的interval是连续
//按照end排序的话 会有特殊情况  [1,2] [3, 4] [5, 6] [1, 10], 这样就需要每次检查store里面所有的已经存在的interval 看看有没有完全包含的情况。
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class Solution56 {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        Interval a = new Interval(2, 3);
        Interval b = new Interval(4, 5);
        Interval c = new Interval(6, 7);
        Interval d = new Interval(8, 9);
        Interval e = new Interval(1, 10);

        List<Interval> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        System.out.println(new Solution56().merge(list));
    }
}
