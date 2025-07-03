package sdetinterviewquestions4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingValuesFinder {

    public static List<Integer> findMissingValues(int[] arr) {
        List<Integer> missing = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int curr = arr[i];

            for (int j = prev + 1; j < curr; j++) {
                missing.add(j);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 6, 7, 10};
        System.out.println("Input array: " + Arrays.toString(input));
        List<Integer> missing = findMissingValues(input);

        System.out.println("Missing values: " + missing);
    }
}
