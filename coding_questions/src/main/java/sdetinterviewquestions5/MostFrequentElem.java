package src.main.java.sdetinterviewquestions5;

import java.util.ArrayList;
import java.util.HashMap;

public class MostFrequentElem {

    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList result = new ArrayList();
        int count=3;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);

                if (map.get(arr[i])==count) {
                    result.add(arr[i]);
                }
            }
            else {
                map.clear();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }

        System.out.println(result);
    }
}
