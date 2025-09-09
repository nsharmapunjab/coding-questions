package src.main.java.sdetinterviewquestions5;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    static class Interval {

        int start;
        int end;
        public Interval(int start, int end) {

            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(1,3));
        arr.add(new Interval(2,6));
        arr.add(new Interval(8,10));
        arr.add(new Interval(15,18));

        ArrayList<Interval> result = new ArrayList<>();
        Interval startIntv = new Interval(arr.get(0).start, arr.get(0).end);
        result.add(startIntv);

        for (int i = 1; i < arr.size(); i++) {

            if (startIntv.end > arr.get(i).start) {
                result.getLast().end = arr.get(i).end;
            }
            else {
                result.add(arr.get(i));
                startIntv = arr.get(i);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).start + " : " + result.get(i).end);
        }
    }
}
