package src.main.java.sdetinterviewquestions5;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int target = 9;
        int[] arr = {2,7,11,15};
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement)!=i) {
                System.out.println("Indexes : " + i + " and " + map.get(complement));
                break;
            }
        }
    }
}
