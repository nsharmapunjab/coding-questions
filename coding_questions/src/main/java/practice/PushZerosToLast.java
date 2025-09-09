package src.main.java.practice;

import java.util.Arrays;

public class PushZerosToLast {

    public static void main(String[] args) {

        int[] a = {0, 3, 0, 5, 6, 0, -1, 7};
        System.out.println(Arrays.toString(a));

        int start=0;

        for (int i = 0; i < a.length; i++) {
            if (a[i]!=0) {
                a[start]=a[i];
                start++;
            }
        }

        while (start < a.length) {
            a[start]=0;
            start++;
        }

        System.out.println(Arrays.toString(a));
    }
}
