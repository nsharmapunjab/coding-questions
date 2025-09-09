package sdetinterviewquestions3;

public class FindKthPositive {

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11,15,17,19,20};
        System.out.println(new FindKthPositive().findKthPositive(arr, 5));
    }  

    public int findKthPositive(int[] arr, int k) {
        // The idea is to use binary search.
        // The array is sorted, and we are looking for the first element
        // that is greater than or equal to k.
        // If the element at the middle index is greater than or equal to k,
        // then we know that the element we are looking for is in the left half.
        // If the element at the middle index is less than k, then we know that
        // the element we are looking for is in the right half.
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // calculate the missing number before the middle index
            // if the missing number is greater than or equal to k, then
            // we know that the element we are looking for is in the left half
            if (arr[mid] - (mid + 1) >= k) {
                right = mid - 1;
            // if the missing number is less than k, then we know that
            // the element we are looking for is in the right half
            } else {
                left = mid + 1;
            }
        }
        // the element we are looking for is the left index plus k
        return left + k;
    }

}
