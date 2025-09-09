package src.main.java.sdetinterviewquestions5;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];

        leftArr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i]=leftArr[i-1] * arr[i-1];
        }

        rightArr[arr.length-1]=1;
        for (int i = arr.length-2; i >=0; i--) {
            rightArr[i]=rightArr[i+1] * arr[i+1];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=leftArr[i] * rightArr[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
