package sdetinterviewquestions4;

import java.util.*;

public class OverlappingIntervals {
    static class Interval {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        // Sort intervals based on start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        List<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        result.add(current);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            
            // If current interval overlaps with the next one
            if (current.end >= next.start) {
                // Merge them by updating the end of current interval
                current.end = Math.max(current.end, next.end);
            } else {
                // No overlap, add next interval to result
                current = next;
                result.add(current);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1: Overlapping intervals
        List<Interval> intervals1 = Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        );
        
        System.out.println("Original intervals 1: " + intervals1);
        List<Interval> merged1 = mergeIntervals(new ArrayList<>(intervals1));
        System.out.println("Merged intervals 1: " + merged1);
        
        // Test case 2: All intervals are overlapping
        List<Interval> intervals2 = Arrays.asList(
            new Interval(1, 4),
            new Interval(4, 5)
        );
        
        System.out.println("\nOriginal intervals 2: " + intervals2);
        List<Interval> merged2 = mergeIntervals(new ArrayList<>(intervals2));
        System.out.println("Merged intervals 2: " + merged2);
        
        // Test case 3: No overlapping intervals
        List<Interval> intervals3 = Arrays.asList(
            new Interval(1, 2),
            new Interval(3, 4),
            new Interval(5, 6)
        );
        
        System.out.println("\nOriginal intervals 3: " + intervals3);
        List<Interval> merged3 = mergeIntervals(new ArrayList<>(intervals3));
        System.out.println("Merged intervals 3: " + merged3);
    }
}
