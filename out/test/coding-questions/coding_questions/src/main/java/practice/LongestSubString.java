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
        for(int i=0;i<s2.length()-1;i++) {
            set.add(s2.charAt(i));
        }



    }
}
