package src.main.java.sdetinterviewquestions5;

public class SearchRotatedSortedArray {

    static int result=-1;

    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2};
        int target =0;
        int start=0;
        int last= arr.length-1;

        findElem(arr,start,last, target);
        System.out.println(result);
    }

    private static void findElem(int[] arr, int start, int last, int target) {
        if (start<=last) {
            int mid=(start+last)/2;

            if (arr[mid]== target) {
                result=mid;
            }
            else {
                findElem(arr,start,mid-1,target);
                findElem(arr,mid+1,last,target);
            }
        }
    }
}
