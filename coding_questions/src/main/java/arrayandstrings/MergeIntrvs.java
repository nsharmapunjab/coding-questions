package src.main.java.arrayandstrings;

import sdetinterviewquestions4.OverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntrvs {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            start = start;
            end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervalsArr = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );
    }
}
