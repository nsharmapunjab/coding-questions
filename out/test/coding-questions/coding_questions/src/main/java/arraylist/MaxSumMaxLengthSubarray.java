package arraylist;

public class MaxSumMaxLengthSubarray {

    public static void main(String[] args) {
        int[] nums = {2, -1, -2, 1, 3, 5, 4, -2, -1, 0};

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if ((currentSum > maxSum) || 
                (currentSum == maxSum && (i - tempStart + 1 > maxLength))) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
                maxLength = i - tempStart + 1;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        // Output the result
        System.out.println("Max sum: " + maxSum);
        System.out.println("Max length subarray: [" + start + " to " + end + "]");
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
