package src.main.java.arrayandstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vowels {

    public static void main(String[] args) {

        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Input : " + input);

        String vowels = "AEIOU";
        char[] cw = vowels.toCharArray();
        Set<Character> vwlChar = new HashSet<Character>();
        for (int i = 0; i < cw.length; i++) {
            vwlChar.add(cw[i]);
        }
        int count=0;
        int pointer=0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (vwlChar.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
                count++;
            }

            else {
                pointer=count;
                while (pointer>0) {
                    sb.append(input.charAt(i));
                    pointer--;
                }
            }
        }

        String result = "ABCDEFFGGHHIJJJKKKLLLMMMNNNOPPPPQQQQRRRRSSSSTTTTUVVVVVWWWWWXXXXXYYYYYZZZZZ";
        System.out.println("Output1 : " + result);
        System.out.println("Output2 : " + sb.toString());

    }
}
