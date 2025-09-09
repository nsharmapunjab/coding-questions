package src.main.java.sdetinterviewquestions5;

import java.util.Arrays;

public class ThreeSumProblem {

    public static void main(String[] args) {

        int[] arr = {-1,0,1,2,-1,-4};
        int j=0;
        int k=arr.length-1;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            j=i+1;
            k=arr.length-1;
            while(j<k) {
                if (arr[i]+arr[j]+arr[k]==0) {
                    System.out.println("Output : " + arr[i]+":"+arr[j]+":"+arr[k] );
                    j++;
                    k--;
                }
                if (arr[i]+arr[j]+arr[k]>0) {
                    k--;
                }
                if (arr[i]+arr[j]+arr[k]<0) {
                    j++;
                }
            }
        }
    }
}
