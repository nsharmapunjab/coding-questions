package src.main.java.arrayandstrings;

public class FindSecondLargest {

    public static void main(String[] args) {

        int[] arr = {1,3,2,6,9,4,8,6,7};
//        int[] arr = {5, 5, 5, 5};
        int max=0;
        int secondMax=0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i]>max) {
                secondMax=max;
                max=arr[i];
            }
            if (arr[i]<max && arr[i]>secondMax) {
                secondMax=arr[i];
            }
        }

        System.out.println(secondMax);
    }
}
