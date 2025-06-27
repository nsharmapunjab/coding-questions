package sdetinterviewquestions4;

import java.util.Arrays;

public class MoveZeroAtTheEnd {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println("Original Array : " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("Modified Array : " + Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
