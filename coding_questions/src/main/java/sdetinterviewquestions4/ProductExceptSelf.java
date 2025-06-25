package sdetinterviewquestions4;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    // Test code
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] output = productExceptSelf(input);

        for (int val : output) {
            System.out.print(val + " ");
        }
        // Output: 24 12 8 6
    }
}
