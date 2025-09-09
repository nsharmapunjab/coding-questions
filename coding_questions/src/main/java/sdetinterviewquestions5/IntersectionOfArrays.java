package src.main.java.sdetinterviewquestions5;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfArrays {

    public static void main(String[] args) {

        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        ArrayList result = new ArrayList();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i])>0) {
                result.add(arr2[i]);
                map.put(arr2[i],map.getOrDefault(arr2[i],0)-1);
            }
        }

        System.out.println(result);
    }
}
