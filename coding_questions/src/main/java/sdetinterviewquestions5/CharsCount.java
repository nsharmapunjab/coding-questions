package src.main.java.sdetinterviewquestions5;

import java.util.HashSet;

public class CharsCount {

    public static void main(String[] args) {

        String s = "AAABBCCDD";

        char[] chr = new char[1];
        int pointer=0;
        StringBuilder sb = new StringBuilder();

        chr[0]=s.charAt(0);
        for (int i = 0; i < s.length(); i++) {

            if (chr[0]==s.charAt(i)) {
                pointer++;
            }
            else {
                sb.append(chr[0]);
                sb.append(pointer);
                chr[0]=s.charAt(i);
                pointer=1;
            }
        }

        sb.append(chr[0]);
        sb.append(pointer);

        System.out.println(sb.toString());
    }
}
