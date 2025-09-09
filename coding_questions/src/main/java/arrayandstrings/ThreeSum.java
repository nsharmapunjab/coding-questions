package src.main.java.arrayandstrings;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {

//        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int j=i+1;
            int k=arr.length-1;
            while(j<k) {
                if (arr[i] + arr[j] + arr[k]==0) {
                    System.out.print("\nIndex : " + i+ " : " + j + " : " + k);
                    j++;
                    k--;
                }
                else if (arr[i] + arr[j] + arr[k] >0) {
                    k--;
                }
                else if (arr[i] + arr[j] + arr[k] <0) {
                    j++;
                }
            }
        }
    }
}
