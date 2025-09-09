package src.main.java.sdetinterviewquestions5;

import java.util.HashMap;

public class SubArraySumEqual {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2,1};
        int k=3;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;

        for(int num : arr) {
            sum+=num;

            if (map.containsKey(sum-k)) {
                count++;
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        System.out.println(count);
    }
}
