package sdetinterviewquestions3;

public class MaxSumLength {

    public static void main(String[] args) {
        //int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr = {2,-1,-2,1,3,5,4,-2,-1,0};
        System.out.println(maxSumLength(arr));
    }

    public static int maxSumLength(int[] arr) {
        int maxLen = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            currLen++;
            
            if (currSum > maxSum) {
                maxSum = currSum;
                maxLen = currLen;
            }

            if (currSum < 0) {
                currSum = 0;
                currLen = 0;
            }
        }

        return maxLen;
    }


}
