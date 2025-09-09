package sdetinterviewquestions4;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

//        {1, 2, 3, 4}
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

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        // Build left product
        leftProd[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProd[i] = nums[i - 1] * leftProd[i - 1];
        }

        // Build right product
        rightProd[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProd[i] = nums[i + 1] * rightProd[i + 1];
        }

        // Final result
        for (int i = 0; i < n; i++) {
            nums[i] = leftProd[i] * rightProd[i];
        }

        return nums;
    }

    // Test code
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
//        int[] output = productExceptSelf(input);
        int[] output = productExceptSelf2(input);

        for (int val : output) {
            System.out.print(val + " ");
        }
        // Output: 24 12 8 6
    }
}
