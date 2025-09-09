package arraylist;

import java.util.Arrays;
import java.util.HashMap;

public class StringToIntArray {

    public static void main(String[] args) {
        
       // String a = "coupang";
        String s = "aabdsdfadfabddd";

        System.out.println(stringToIntArray(s));
    }

    public static int stringToIntArray(String s) {
        int[] b = new int[256];
        for(int i=0;i<s.length();i++) {
            b[s.charAt(i)] = b[s.charAt(i)] + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (b[s.charAt(i)]==1) {
                return i;
            }
        }

        return -1;
    }

}
