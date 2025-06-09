package sdetinterviewquestions3;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(new FindKthLargest().findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        //find the min and max value in the array
        int minNums = Integer.MAX_VALUE, maxNums = Integer.MIN_VALUE;
        for(int i: nums) {
            minNums = Math.min(minNums, i);
            maxNums = Math.max(maxNums, i);
        }
        //create a counts array to keep track of the number of each element
        int[] counts = new int[maxNums - minNums + 1];
        //count the number of each element
        for(int i: nums) {
            counts[i-minNums]++;
        }
        //iterate the counts array in reverse order
        //and subtract the count of each element from k
        //until k is 0
        for(int i=counts.length - 1; i>=0; i--) {
            k-=counts[i];
            //when k is 0, return the element
            if(k<=0){
                return i+minNums;
            }
        }
        //if k is not 0, return 0
        return 0;
    }

}
