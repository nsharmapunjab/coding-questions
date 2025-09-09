package src.main.java.arrayandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsPairing {

    public static void main(String[] args) {

        String s = "(a{[b]c})";

        System.out.println(isValid(s));

        first_solution(s);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        boolean hasMatchingPair = false;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.peek() != mapping.get(c)) {
                    return false;
                }
                stack.pop();
                hasMatchingPair = true;
            }
        }

        return stack.isEmpty() && hasMatchingPair;
    }

    private static void first_solution(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        System.out.println(map);
        boolean found=false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')') {
                while(stack.size()>0 && stack.peek()!=map.get(s.charAt(i))) {
                    stack.pop();
                }
                if (stack.size()>0 && stack.peek()==map.get(s.charAt(i))) {
                    found=true;
                }
            }
            if (s.charAt(i)=='}') {
                found=false;
                while(stack.size()>0 && stack.peek()!=map.get(s.charAt(i))) {
                    stack.pop();
                }
                if (stack.size()>0 && stack.peek()==map.get(s.charAt(i))) {
                    found=true;
                }
            }
            if (s.charAt(i)==']') {
                found=false;
                while(stack.size()>0 && stack.peek()!=map.get(s.charAt(i))) {
                    stack.pop();
                }
                if (stack.size()>0 && stack.peek()==map.get(s.charAt(i))) {
                    found=true;
                }
            }
            stack.push(s.charAt(i));
        }

        System.out.println(found);
    }
}
