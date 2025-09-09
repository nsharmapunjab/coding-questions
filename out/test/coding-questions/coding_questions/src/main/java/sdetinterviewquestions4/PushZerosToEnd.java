package sdetinterviewquestions4;

public class PushZerosToEnd {

    // function to move all zeros to the end
    static void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        // to keep track of the index in temp[]
        int j = 0;

        // Copy non-zero elements to temp[]
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp[j++] = arr[i];
        }

        // Fill remaining positions in temp[] with zeros
        while (j < n)
            temp[j++] = 0;

        // Copy all the elements from temp[] to arr[]
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    // Function which pushes all zeros to end of an array
    static void pushZerosToEndInPlace(int[] arr) {
        
        // Count of non-zero elements
        int count = 0;  

        // If the element is non-zero, replace the element at
        // index 'count' with this element and increment count
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }

        // Now all non-zero elements have been shifted to
        // the front. Make all elements 0 from count to end.
        while (count < arr.length)
            arr[count++] = 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
