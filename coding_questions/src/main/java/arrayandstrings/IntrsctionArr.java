package src.main.java.arrayandstrings;

import java.util.ArrayList;
import java.util.HashMap;

public class IntrsctionArr {

    public static void main(String[] args) {

        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i], map.getOrDefault(num1[i],0) +1);
        }
        System.out.println(map.toString());

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < num2.length; i++) {
            if (map.containsKey(num2[i])) {
                result.add(num2[i]);
                map.put(num2[i], map.getOrDefault(num2[i],0)-1);
            }
            if (map.getOrDefault(num2[i],0)==0) {
                map.remove(num2[i]);
            }
        }

        System.out.println(result);

    }
}
