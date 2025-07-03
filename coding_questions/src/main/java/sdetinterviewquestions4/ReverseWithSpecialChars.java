package sdetinterviewquestions4;

import java.util.Stack;

public class ReverseWithSpecialChars {

    public static String reversePreserveSpecials(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Skip special characters from left
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            // Skip special characters from right
            else if (!Character.isLetter(chars[right])) {
                right--;
            }
            // Both are letters — swap
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "autom@t@ion";
        String result = reversePreserveSpecials(input);
        System.out.println("Input:  " + input);
        System.out.println("Output: " + result);
    }
}
