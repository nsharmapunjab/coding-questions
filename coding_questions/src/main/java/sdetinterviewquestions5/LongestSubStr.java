package src.main.java.sdetinterviewquestions5;

import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestSubStr {

    public static void main(String[] args) {

//        String s="abcabcbb";
//        String s="bbbbb";
        String s="pwwkew";
        String resultStr="";
        int maxLen=0;

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) {
                if (set.size()>maxLen) {
                    maxLen=set.size();
                    resultStr=set.stream().map(String::valueOf).collect(Collectors.joining());
                    set.clear();
                }
                set.add(s.charAt(i));
            }
            else {
                set.add(s.charAt(i));
            }
        }

        System.out.println(resultStr);
    }
}
