package sdetinterviewquestions3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args) {
        
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(arr);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i][0] + " " + result[i][1]);
        }

    }

    public static int[][] merge(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i=0; i<arr.length; i++){
            int first = arr[i][0];
            int last = arr[i][1];
            
            if(list.isEmpty() || arr[i][0]> list.getLast().get(1)){
                list.add(Arrays.asList(first, last));
            }

            else{
                list.getLast().set(1, Integer.max(list.getLast().get(1), last));
            }
        }

        int[][] intervals = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<2; j++){
                intervals[i][j] = list.get(i).get(j);
            }
        }
        
        return intervals;
    }

}
