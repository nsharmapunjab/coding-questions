package sdetinterviewquestions3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedList {

    public static List<Integer> flatten(List<?> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object element : nestedList) {
            if (element instanceof Integer) {
                result.add((Integer) element);
            } else if (element instanceof List<?>) {
                result.addAll(flatten((List<?>) element)); // Recursive flattening
            } else {
                throw new IllegalArgumentException("Unsupported element type: " + element.getClass());
            }
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        List<Object> nested = Arrays.asList(
            1,
            Arrays.asList(2, Arrays.asList(3, 4), 5),
            6
        );

        List<Integer> flat = flatten(nested);
        System.out.println("Flattened list: " + flat); // [1, 2, 3, 4, 5, 6]
    }
}
