package practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        String s1 = "abcdefacbccbagfacbacer";
        String s2 = "abc";

        longestSubString(s1, s2);
    }

    public static void longestSubString(String s1, String s2) {

        Set<Character> set = new HashSet<>();
        for(int i=0;i<s2.length();i++) {
            set.add(s2.charAt(i));
        }

        int current=0;
        int longest=0;
        int longestEnd=0;
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i))) {
                current++;
                if (current>longest) {
                    longest=current;
                    longestEnd=i+1;
                }
            }
            else {
                current=0;
            }
        }
        System.out.println("Longest substr length : " + longest);
        System.out.println("Longest substr : " + s1.substring((longestEnd-longest), longestEnd));
    }
}
