package src.main.java.arrayandstrings;

import java.util.*;

public class Test {

    public static boolean user(String s, int i) {

int count = 1;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) + 1);

                if(hmap.get(c) == 3)
                {
                    if(count == i)
                    {
                       System.out.println(c);
                    }
                    else
                    {
                        count++;
                    }

                }
            } else {
                hmap.put(c, 1);
            }

        }

//        for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
//            if (entry.getValue() > i) {
//                System.out.println(entry.getKey());
//                return true;
//            }
//        }
          return false;
    }

    public static void main(String[] args) {
        //        user d has sign up with one
        //        user g has sign up with one
        //        user i has sign up with one
        //        user c has sign up with one
        //        user g has sign up with one
        //        user c has sign up with one
        //        user i has sign up with one
        //        user c has sign up with one
        //        user i has sign up with one
        //        user g has sign up with one

//        Any user repeat more than twice is junk user
        String input = "aaaaaaa";
        int i = 1; //c -- 2i  --3g
        String secondInput = "ihskassharmaihskassharmaihskassharma";
        System.out.println(user(input, 1));

    }
}

