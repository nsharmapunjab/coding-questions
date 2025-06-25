package sdetinterviewquestions4;

public class StringReverseWithNumbers {

    public static String reverseNonIntegerParts(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                currentWord.append(c);
            } else {
                if (currentWord.length() > 0) {
                    result.append(currentWord.reverse());
                    currentWord.setLength(0);
                }
                result.append(c);
            }
        }
        
        // Add any remaining characters in currentWord
        if (currentWord.length() > 0) {
            result.append(currentWord.reverse());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String input = "java234abc4534543tgh$$12tg";
        String expected = "avaj234cba4534543hgt$$12gt";
        String result = reverseNonIntegerParts(input);
        
        System.out.println("Input:    " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result:   " + result);
        System.out.println("Test " + (expected.equals(result) ? "Passed" : "Failed"));
    }
}
