package sdetinterviewquestions3;

import java.util.ArrayList;
import java.util.List;

public class BracketGenerator {

    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateBrackets(n);
        System.out.println("All valid bracket combinations for n = " + n + ":");
        for (String combo : combinations) {
            System.out.println(combo);
        }
    }
}
