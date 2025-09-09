package src.main.java.sdetinterviewquestions5;

import java.util.HashMap;

public class FirstUniqueChar {

    public static void main(String[] args) {

        String s ="loveleetcode";

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(map);

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1) {
                System.out.println("Index : " + i);
                break;
            }
        }
    }
}
